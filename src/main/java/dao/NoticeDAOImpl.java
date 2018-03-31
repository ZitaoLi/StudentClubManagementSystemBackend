package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.NewsComment;
import modle.Notice;
import util.DBUtils;

public class NoticeDAOImpl implements NoticeDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<Notice> findAll() {
		Notice notice = null;
		List<Notice> notices = new ArrayList<Notice>();
		String sql = "select id, user_id, notice_type, is_read, body, created_time from notice";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	notice = new Notice();
            	notice.setId(rs.getInt(1));
            	notice.setUserId(rs.getInt(2));
            	notice.setNoticeType(rs.getInt(3));
            	notice.setRead(rs.getBoolean(4));
            	notice.setBody(rs.getString(5));
            	notice.setCreatedTime(rs.getTimestamp(6));
            	notices.add(notice);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return notices;
	}

	@Override
	public Notice findById(int id) {
		Notice notice = null;
		String sql = "select id, user_id, notice_type, is_read, body, created_time from notice";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	notice = new Notice();
            	notice.setId(rs.getInt(1));
            	notice.setUserId(rs.getInt(2));
            	notice.setNoticeType(rs.getInt(3));
            	notice.setRead(rs.getBoolean(4));
            	notice.setBody(rs.getString(5));
            	notice.setCreatedTime(rs.getTimestamp(6));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return notice;
	}

	@Override
	public boolean add(Notice notice) {
		String sql = "insert into notice(user_id, notice_type, body)values(?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, notice.getUserId());
            ps.setInt(2, notice.getNoticeType());
            ps.setString(3, notice.getBody());
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
	public boolean update(Notice notice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		String sql = "delete from notice where id=?";
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
