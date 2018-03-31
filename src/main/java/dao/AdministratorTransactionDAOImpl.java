package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.AdministratorTransaction;
import modle.ClubManagementTransaction;
import util.DBUtils;

public class AdministratorTransactionDAOImpl implements AdministratorTransactionDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<AdministratorTransaction> findAll() {
		AdministratorTransaction administratorTransaction = null;
		List<AdministratorTransaction> administratorTransactions = new ArrayList<AdministratorTransaction>();
		String sql = "select id, administrator_id, transaction_id, is_solved, solved_time from administrator_transaction";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	administratorTransaction = new AdministratorTransaction();
            	administratorTransaction.setId(rs.getInt(1));
            	administratorTransaction.setAdministratorId(rs.getInt(2));
            	administratorTransaction.setTransactionId(rs.getInt(3));
            	administratorTransaction.setSolved(rs.getBoolean(4));
            	administratorTransaction.setSovledTime(rs.getTimestamp(5));
            	administratorTransactions.add(administratorTransaction);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return administratorTransactions;
	}

	@Override
	public AdministratorTransaction findById(int id) {
		AdministratorTransaction administratorTransaction = null;
		String sql = "select id, administrator_id, transaction_id, is_solved, solved_time from administrator_transaction";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	administratorTransaction = new AdministratorTransaction();
            	administratorTransaction.setId(rs.getInt(1));
            	administratorTransaction.setAdministratorId(rs.getInt(2));
            	administratorTransaction.setTransactionId(rs.getInt(3));
            	administratorTransaction.setSolved(rs.getBoolean(4));
            	administratorTransaction.setSovledTime(rs.getTimestamp(5));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return administratorTransaction;
	}

	@Override
	public boolean add(AdministratorTransaction administratorTransaction) {
		String sql = "insert into administrator_transaction(administrator_id, transaction_id)values(?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, administratorTransaction.getAdministratorId());
            ps.setInt(2, administratorTransaction.getTransactionId());
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
	public boolean update(AdministratorTransaction administratorTransaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		String sql = "delete from administrator_transaction where id=?";
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
