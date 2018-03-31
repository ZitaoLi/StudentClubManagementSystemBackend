package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.Administrator;
import modle.ClubInternalTransaction;
import util.DBUtils;

public class AdministratorDAOImpl implements AdministratorDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<Administrator> findAll() {
		Administrator administrator = null;
		List<Administrator> administrators = new ArrayList<Administrator>();
		String sql = "select id, name, password, created_time from administrator";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	administrator = new Administrator();
            	administrator.setId(rs.getInt(1));
            	administrator.setName(rs.getString(2));
            	administrator.setPassword(rs.getString(3));
            	administrator.setCreatedTime(rs.getTimestamp(4));
            	administrators.add(administrator);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return administrators;
	}

	@Override
	public Administrator findById(int id) {
		Administrator administrator= null;
		String sql = "select id, name, password, created_time from administrator";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	administrator = new Administrator();
            	administrator.setId(rs.getInt(1));
            	administrator.setName(rs.getString(2));
            	administrator.setPassword(rs.getString(3));
            	administrator.setCreatedTime(rs.getTimestamp(4));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return administrator;
	}

	@Override
	public boolean add(Administrator administrator) {
		String sql = "insert into administrator(name, password)values(?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, administrator.getName());
            ps.setString(2, administrator.getPassword());
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
	public boolean update(Administrator administrator) {
		String sql = "update administrator set name=?,password=? where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, administrator.getName());
            ps.setString(2, administrator.getPassword());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("¸üÐÂÊ§°Ü");
            return false;
        }finally{
            DBUtils.close(null, ps, conn);
        }
        return true;
	}

	@Override
	public boolean remove(int id) {
		String sql = "delete from administrator where id=?";
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
