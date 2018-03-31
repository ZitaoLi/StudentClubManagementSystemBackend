package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.AdministratorTransaction;
import modle.News;
import util.DBUtils;

public class NewsDAOImpl implements NewsDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<News> findAll() {
		News news = null;
		List<News> newsList = new ArrayList<News>();
		String sql = "select id, administrator_id, user_id, club_id, title, content, image_path, start_num, created_time from news";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	news = new News();
            	news.setId(rs.getInt(1));
            	news.setAdministratorId(rs.getInt(2));
            	news.setUserId(rs.getInt(3));
            	news.setClubId(rs.getInt(4));
            	news.setTitle(rs.getString(5));
            	news.setContent(rs.getString(6));
            	news.setImagePath(rs.getString(7));
            	news.setStartNum(rs.getInt(8));
            	news.setCreatedTime(rs.getTimestamp(9));
            	newsList.add(news);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return newsList;
	}

	@Override
	public News findById(int id) {
		News news = null;
		String sql = "select id, administrator_id, user_id, club_id, title, content, image_path, start_num, created_time from news";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	news = new News();
            	news.setId(rs.getInt(1));
            	news.setAdministratorId(rs.getInt(2));
            	news.setUserId(rs.getInt(3));
            	news.setClubId(rs.getInt(4));
            	news.setTitle(rs.getString(5));
            	news.setContent(rs.getString(6));
            	news.setImagePath(rs.getString(7));
            	news.setStartNum(rs.getInt(8));
            	news.setCreatedTime(rs.getTimestamp(9));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return news;
	}

	@Override
	public boolean add(News news) {
		String sql = "insert into news(administrator_id, user_id, club_id, title, content, image_path, start_num)values(?,?,?,?,?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, news.getAdministratorId());
            ps.setInt(2, news.getUserId());
            ps.setInt(3, news.getClubId());
            ps.setString(4, news.getTitle());
            ps.setString(5, news.getContent());
            ps.setString(6, news.getImagePath());
            ps.setInt(7, news.getStartNum());
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
	public boolean update(News news) {
		String sql = "update news set title=?,content=?,image_path=? where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getContent());
            ps.setString(3, news.getImagePath());
            ps.setInt(4, news.getId());
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
		String sql = "delete from news where id=?";
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
