package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modle.Administrator;
import modle.Temp;
import util.DBUtils;

public class TempDAOImpl implements TempDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
	@Override
	public List<Temp> findAll() {
		Temp temp = null;
		List<Temp> temps = new ArrayList<Temp>();
		String sql = "select id, title, content, time, place, image_path, created_time, temp_name, user_id from temp";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	temp = new Temp();
            	temp.setId(rs.getInt(1));
            	temp.setTitle(rs.getString(2));
            	temp.setContent(rs.getString(3));
            	temp.setTime(rs.getString(4));
            	temp.setPlace(rs.getString(5));
            	temp.setImagePath(rs.getString(6));
            	temp.setCreatedTime(rs.getTimestamp(7));
            	temp.setTempName(rs.getString(8));
            	temp.setUserId(rs.getInt(9));
            	temps.add(temp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return temps;
	}

	@Override
	public Temp findById(int id) {
		Temp temp= null;
		String sql = "select id, title, content, time, place, image_path, created_time, temp_name, user_id from temp where id=?";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	temp = new Temp();
            	temp.setId(rs.getInt(1));
            	temp.setTitle(rs.getString(2));
            	temp.setContent(rs.getString(3));
            	temp.setTime(rs.getString(4));
            	temp.setPlace(rs.getString(5));
            	temp.setImagePath(rs.getString(6));
            	temp.setCreatedTime(rs.getTimestamp(7));
            	temp.setTempName(rs.getString(8));
            	temp.setUserId(rs.getInt(9));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return temp;
	}
	
	@Override
	public boolean add(Temp temp) {
		return false;
	}

	public int add1(Temp temp) {
		String sql = "insert into temp(title, content, time, place, image_path, temp_name, user_id)values(?,?,?,?,?,?,?)";
		int id = 0;
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, temp.getTitle());
            ps.setString(2, temp.getContent());
            ps.setString(3, temp.getTime());
            ps.setString(4, temp.getPlace());
            ps.setString(5, temp.getImagePath());
            ps.setString(6, temp.getTempName());
            ps.setInt(7, temp.getUserId());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();   
            if (rs.next()) {  
                id = rs.getInt(1);     
            } 
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ÃÌº” ß∞‹");
            return 0;
        }finally{
            DBUtils.close(null, ps, conn);
        }
		return id;
	}

	@Override
	public boolean update(Temp temp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
