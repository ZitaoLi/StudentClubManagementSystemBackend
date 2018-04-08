package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.ClubInternalTransaction;
import modle.ClubManagementTransaction;
import util.DBUtils;

public class ClubManagementTransactionDAOImpl implements ClubManagementTransactionDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<ClubManagementTransaction> findAll() {
		ClubManagementTransaction transaction = null;
		List<ClubManagementTransaction> transactions = new ArrayList<ClubManagementTransaction>();
		String sql = "select id, user_id, transation_type, body, created_time from club_management_transaction";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	transaction = new ClubManagementTransaction();
            	transaction.setId(rs.getInt(1));
            	transaction.setUserId(rs.getInt(2));
            	transaction.setTransactionType(rs.getInt(3));
            	transaction.setBody(rs.getString(4));
            	transaction.setCreatedTime(rs.getTimestamp(5));
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
	public ClubManagementTransaction findById(int id) {
		ClubManagementTransaction transaction= null;
		String sql = "select id, user_id, transation_type, body, created_time from club_management_transaction where id=?";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	transaction = new ClubManagementTransaction();
            	transaction.setId(rs.getInt(1));
            	transaction.setUserId(rs.getInt(2));
            	transaction.setTransactionType(rs.getInt(3));
            	transaction.setBody(rs.getString(4));
            	transaction.setCreatedTime(rs.getTimestamp(5));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return transaction;
	}

	@Override
	public boolean add(ClubManagementTransaction transaction) {
		String sql = "insert into club_management_transaction(user_id, transation_type, body)values(?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, transaction.getUserId());
            ps.setInt(2, transaction.getTransactionType());
            ps.setString(3, transaction.getBody());
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
	public boolean update(ClubManagementTransaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		String sql = "delete from club_management_transaction where id=?";
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
