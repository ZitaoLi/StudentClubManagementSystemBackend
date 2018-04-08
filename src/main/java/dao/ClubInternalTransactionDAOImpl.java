package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.ClubInternalTransaction;
import modle.ClubMember;
import util.DBUtils;

public class ClubInternalTransactionDAOImpl implements ClubInternalTransactionDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<ClubInternalTransaction> findAll() {
		ClubInternalTransaction transaction = null;
		List<ClubInternalTransaction> transactions = new ArrayList<ClubInternalTransaction>();
		String sql = "select id, member_id, club_id, transaction_type, body, created_time from club_internal_transaction";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	transaction = new ClubInternalTransaction();
            	transaction.setId(rs.getInt(1));
            	transaction.setMemberId(rs.getInt(2));
            	transaction.setClubId(rs.getInt(3));
            	transaction.setTransacitonType(rs.getInt(4));
            	transaction.setBody(rs.getString(5));
            	transaction.setCreatedTime(rs.getTimestamp(6));
            	transactions.add(transaction);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return transactions;
	}

	@Override
	public List<ClubInternalTransaction> findByClubId(int clubId) {
		ClubInternalTransaction transaction = null;
		List<ClubInternalTransaction> transactions = new ArrayList<ClubInternalTransaction>();
		String sql = "select id, member_id, club_id, transaction_type, body, created_time from club_internal_transaction where club_id=?";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, clubId);
            rs = ps.executeQuery();
            while(rs.next()){
            	transaction = new ClubInternalTransaction();
            	transaction.setId(rs.getInt(1));
            	transaction.setMemberId(rs.getInt(2));
            	transaction.setClubId(rs.getInt(3));
            	transaction.setTransacitonType(rs.getInt(4));
            	transaction.setBody(rs.getString(5));
            	transaction.setCreatedTime(rs.getTimestamp(6));
            	transactions.add(transaction);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return transactions;
	}

	@Override
	public ClubInternalTransaction findById(int id) {
		ClubInternalTransaction transaction= null;
		String sql = "select id, member_id, club_id, transaction_type, body, created_time from club_internal_transaction where id=?";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	transaction = new ClubInternalTransaction();
            	transaction.setId(rs.getInt(1));
            	transaction.setMemberId(rs.getInt(2));
            	transaction.setClubId(rs.getInt(3));
            	transaction.setTransacitonType(rs.getInt(4));
            	transaction.setBody(rs.getString(5));
            	transaction.setCreatedTime(rs.getTimestamp(6));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return transaction;
	}

	@Override
	public boolean add(ClubInternalTransaction transaction) {
		String sql = "insert into club_internal_transaction(member_id, club_id, transaction_type, body)values(?,?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, transaction.getMemberId());
            ps.setInt(2, transaction.getClubId());
            ps.setInt(3, transaction.getTransacitonType());
            ps.setString(4, transaction.getBody());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Ìí¼ÓÊ§°Ü");
            return false;
        }finally{
            DBUtils.close(null, ps, conn);
        }
		return true;
	}

	@Override
	public boolean update(ClubInternalTransaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		String sql = "delete from club_internal_transaction where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("É¾³ýÊ§°Ü");
            return false;
        }finally{
            DBUtils.close(null, ps, conn);
        }
        return true;
	}

}
