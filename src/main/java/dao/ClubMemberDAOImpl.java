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
		String sql = "select club_member.id, club_member.club_id, club_member.user_id, club_member.level, club_member.power, club_member.is_active, club_member.join_time, club_member.club_name, user.name, user.header_image_path from club_member,user where club_member.user_id = user.id";
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
            	member.setPower(rs.getString(5));
            	member.setActive(rs.getBoolean(6));
            	member.setJoinTime(rs.getTimestamp(7));
            	member.setClubName(rs.getString(8));
            	member.setUserName(rs.getString(9));
            	member.setUserHeaderImage(rs.getString(10));
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
		String sql = "select club_member.id, club_member.club_id, club_member.user_id, club_member.level, club_member.power, club_member.is_active, club_member.join_time, club_member.club_name, user.name, user.header_image_path from club_member,user where club_member.id=? and club_member.user_id = user.id";
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
            	member.setPower(rs.getString(5));
            	member.setActive(rs.getBoolean(6));
            	member.setJoinTime(rs.getTimestamp(7));
            	member.setClubName(rs.getString(8));
            	member.setUserName(rs.getString(9));
            	member.setUserHeaderImage(rs.getString(10));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return member;
	}

	@Override
	public ClubMember findByUserIdwithClubId(int userId, int clubId) {
		ClubMember member= null;
		String sql = "select club_member.id, club_member.club_id, club_member.user_id, club_member.level, club_member.power, club_member.is_active, club_member.join_time, club_member.club_name, user.name, user.header_image_path from club_member,user where club_member.user_id=? and club_member.club_id=? and club_member.user_id = user.id";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, clubId);
            rs = ps.executeQuery();
            if(rs.next()){
            	member = new ClubMember();
            	member.setId(rs.getInt(1));
            	member.setClubId(rs.getInt(2));
            	member.setUserId(rs.getInt(3));
            	member.setLevel(rs.getInt(4));
            	member.setPower(rs.getString(5));
            	member.setActive(rs.getBoolean(6));
            	member.setJoinTime(rs.getTimestamp(7));
            	member.setClubName(rs.getString(8));
            	member.setUserName(rs.getString(9));
            	member.setUserHeaderImage(rs.getString(10));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return member;
	}
	
	@Override
	public List<Integer> findClubIdByUserId(int userId) {
		List<Integer> clubIdList = new ArrayList<Integer>();
		String sql = "select club_id from club_member where user_id=?";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()){
            	clubIdList.add(rs.getInt(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return clubIdList;
	}

	@Override
	public List<Integer> findUserIdByClubId(int clubId) {
		List<Integer> clubIdList = new ArrayList<Integer>();
		String sql = "select user_id from club_member where club_id=?";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, clubId);
            rs = ps.executeQuery();
            while(rs.next()){
            	clubIdList.add(rs.getInt(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return clubIdList;
	}

	@Override
	public int findMinistorByClubId(int clubId) {
		int ministorId = 0;
		String sql = "select user_id from club_member where club_id=? and level=2";
		try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, clubId);
            rs = ps.executeQuery();
            if(rs.next()){
            	ministorId = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return ministorId;
	}

	@Override
	public boolean add(ClubMember member) {
		String sql = "insert into club_member(club_id, user_id, level, power, club_name)values(?,?,?,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, member.getClubId());
            ps.setInt(2, member.getUserId());
            ps.setInt(3, member.getLevel());
            ps.setString(4, member.getPower());
            ps.setString(5, member.getClubName());
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
