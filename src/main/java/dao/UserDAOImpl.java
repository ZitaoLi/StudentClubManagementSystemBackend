package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.Club;
import modle.User;
import util.DBUtils;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<User> findAll() {
		User user = null;
		List<User> users = new ArrayList<User>();
		String sql = "select id, student_code, password, email, phone_number, name, self_introduction, header_image_path, created_time from user";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	user = new User();
            	user.setId(rs.getInt(1));
            	user.setStudentCode(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setEmail(rs.getString(4));
            	user.setPhoneNumber(rs.getString(5));
            	user.setName(rs.getString(6));
            	user.setSelfIntroduction(rs.getString(7));
            	user.setHeaderImagePath(rs.getString(8));
            	user.setCreatedTime(rs.getTimestamp(9));
                users.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return users;
	}

	@Override
	public User findById(int id) {
		User user = null;
		String sql = "select id, student_code, password, email, phone_number, name, self_introduction, header_image_path, created_time from user where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt(1));
            	user.setStudentCode(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setEmail(rs.getString(4));
            	user.setPhoneNumber(rs.getString(5));
            	user.setName(rs.getString(6));
            	user.setSelfIntroduction(rs.getString(7));
            	user.setHeaderImagePath(rs.getString(8));
            	user.setCreatedTime(rs.getTimestamp(9));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return user;
	}

	@Override
	public User findByCode(String studentCode) {
		User user = null;
		String sql = "select id, student_code, password, email, phone_number, name, self_introduction, header_image_path, created_time from user where student_code=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentCode);
            rs = ps.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt(1));
            	user.setStudentCode(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setEmail(rs.getString(4));
            	user.setPhoneNumber(rs.getString(5));
            	user.setName(rs.getString(6));
            	user.setSelfIntroduction(rs.getString(7));
            	user.setHeaderImagePath(rs.getString(8));
            	user.setCreatedTime(rs.getTimestamp(9));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return user;
	}

	@Override
	public boolean add(User user) {
		String sql = "insert into user(student_code, password, email, phone_number, name, self_introduction, header_image_path)values(?,?,?,?,?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getStudentCode());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getName());
            ps.setString(6, user.getSelfIntroduction());
            ps.setString(7, user.getHeaderImagePath());
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
	public boolean update(User user) {
		String sql = "update user set password=?,email=?,phone_number=?,name=?,self_introduction=?,header_image_path=? where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhoneNumber());
            ps.setString(4, user.getName());
            ps.setString(5, user.getSelfIntroduction());
            ps.setString(6, user.getHeaderImagePath());
            ps.setInt(7, user.getId());
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
		String sql = "delete from user where id=?";
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
