package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.AdministratorTransaction;
import modle.NewsComment;
import util.DBUtils;

public class NewsCommentDAOImpl implements NewsCommentDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<NewsComment> findAll() {
		NewsComment comment = null;
		List<NewsComment> comments = new ArrayList<NewsComment>();
		String sql = "select id, news_id, user_id, content, created_time from news_comment";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	comment = new NewsComment();
            	comment.setId(rs.getInt(1));
            	comment.setNewsId(rs.getInt(2));
            	comment.setUserId(rs.getInt(3));
            	comment.setContent(rs.getString(4));
            	comment.setCreatedTime(rs.getTimestamp(5));
            	comments.add(comment);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return comments;
	}

	@Override
	public NewsComment findById(int id) {
		NewsComment comment = null;
		String sql = "select id, news_id, user_id, content, created_time from news_comment";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	comment = new NewsComment();
            	comment.setId(rs.getInt(1));
            	comment.setNewsId(rs.getInt(2));
            	comment.setUserId(rs.getInt(3));
            	comment.setContent(rs.getString(4));
            	comment.setCreatedTime(rs.getTimestamp(5));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return comment;
	}

	@Override
	public boolean add(NewsComment comment) {
		String sql = "insert into news_comment(news_id, user_id, content)values(?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, comment.getNewsId());
            ps.setInt(2, comment.getUserId());
            ps.setString(3, comment.getContent());
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
	public boolean update(NewsComment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		String sql = "delete from news_comment where id=?";
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
