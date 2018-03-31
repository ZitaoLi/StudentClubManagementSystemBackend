package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.Club;
import util.DBUtils;

public class ClubDAOImpl implements ClubDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<Club> findAll() {
		Club club = null;
		List<Club> clubs = new ArrayList<Club>();
		String sql = "select id, club_name, club_info, club_bg_image_path, created_time, life_time, member_num from club";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	club = new Club();
            	club.setId(rs.getInt(1));
            	club.setClubName(rs.getString(2));
            	club.setClubInfo(rs.getString(3));
            	club.setClubBgImagePath(rs.getString(4));
            	club.setCreatedTime(rs.getTimestamp(5));
            	club.setLifeTime(rs.getInt(6));
            	club.setMemberNum(rs.getInt(7));
                clubs.add(club);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return clubs;
	}

	@Override
	public Club findById(int id) {
        Club club = null;
        String sql = "select id, club_name, club_info, club_bg_image_path, created_time, life_time, member_num from club where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	club = new Club();
            	club.setId(rs.getInt(1));
            	club.setClubName(rs.getString(2));
            	club.setClubInfo(rs.getString(3));
            	club.setClubBgImagePath(rs.getString(4));
            	club.setCreatedTime(rs.getTimestamp(5));
            	club.setLifeTime(rs.getInt(6));
            	club.setMemberNum(rs.getInt(7));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return club;
	}

	@Override
	public boolean add(Club club) {
		String sql = "insert into club(club_name, club_info, club_bg_image_path)values(?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, club.getClubName());
            ps.setString(2, club.getClubInfo());
            ps.setString(3, club.getClubBgImagePath());
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
	public boolean update(Club club) {
        String sql = "update club set club_name=?,club_info=?,club_bg_image_path=? where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, club.getClubName());
            ps.setString(2, club.getClubInfo());
            ps.setString(3, club.getClubBgImagePath());
            ps.setInt(4, club.getId());
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
		String sql = "delete from club where id=?";
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
