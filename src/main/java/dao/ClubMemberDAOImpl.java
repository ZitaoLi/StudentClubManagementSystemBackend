package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modle.ClubMember;
import modle.User;
import util.DBUtils;

public class ClubMemberDAOImpl implements ClubMemberDAO {
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

	@Override
	public List<ClubMember> findAll() {
		ClubMember member = null;
		List<ClubMember> members = new ArrayList<ClubMember>();
		String sql = "select id, club_id, user_id, level, power, is_active, join_time from club_member";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	member = new ClubMember();
            	member.setId(rs.getInt(1));
            	member.setClubId(rs.getInt(2));
            	member.setUserId(rs.getInt(3));
            	member.setLevel(rs.getInt(4));
            	member.setActive(rs.getBoolean(5));
            	member.setJoinTime(rs.getTimestamp(6));
            	members.add(member);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return members;
	}

	@Override
	public ClubMember findById(int id) {
		ClubMember member= null;
		String sql = "select id, club_id, user_id, level, power, is_active, join_time from club_member";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	member = new ClubMember();
            	member.setId(rs.getInt(1));
            	member.setClubId(rs.getInt(2));
            	member.setUserId(rs.getInt(3));
            	member.setLevel(rs.getInt(4));
            	member.setActive(rs.getBoolean(5));
            	member.setJoinTime(rs.getTimestamp(6));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return member;
	}

	@Override
	public boolean add(ClubMember member) {
		String sql = "insert into club_member(club_id, user_id, level, power)values(?,?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, member.getClubId());
            ps.setInt(2, member.getUserId());
            ps.setInt(3, member.getLevel());
            ps.setString(4, member.getPower());
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
	public boolean update(ClubMember member) {
		String sql = "update club_member set level=?,power=?,is_active=? where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, member.getLevel());
            ps.setString(2, member.getPower());
            ps.setBoolean(3, member.isActive());
            ps.setInt(5, member.getId());
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
		String sql = "delete from club_member where id=?";
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
