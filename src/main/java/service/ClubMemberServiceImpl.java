package service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClubDAOImpl;
import dao.ClubMemberDAOImpl;
import factory.DAOFactory;
import modle.ClubMember;
import net.sf.json.JSONObject;

public class ClubMemberServiceImpl implements ClubMemberService {

	@Override
	public List<ClubMember> findAll() {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		return clubMemberDAOImpl.findAll();
	}

	@Override
	public ClubMember findById(int id) {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		return clubMemberDAOImpl.findById(id);
	}

	@Override
	public int findMinistorByClubId(int clubId) {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		return clubMemberDAOImpl.findMinistorByClubId(clubId);
	}

	@Override
	public boolean add(ClubMember clubMember) {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		boolean res =  clubMemberDAOImpl.add(clubMember);
		return res;
	}

	@Override
	public boolean update(ClubMember clubMember) {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		boolean res =  clubMemberDAOImpl.update(clubMember);
		return res;
	}

	@Override
	public boolean remove(int id) {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		boolean res =  clubMemberDAOImpl.remove(id);
		return res;
	}

	@Override
	public ClubMember findByUserIdwithClubId(int userId, int clubId) {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		return clubMemberDAOImpl.findByUserIdwithClubId(userId, clubId);
	}

	@Override
	public List<Integer> findClubIdByUserId(int userId) {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		return clubMemberDAOImpl.findClubIdByUserId(userId);
	}

	@Override
	public List<Integer> findUserIdByClubId(int clubId) {
		ClubMemberDAOImpl clubMemberDAOImpl = (ClubMemberDAOImpl) DAOFactory.getDAOImpl("ClubMemberDAOImpl");
		return clubMemberDAOImpl.findUserIdByClubId(clubId);
	}

	@Override
	public void backJson(HttpServletRequest req, HttpServletResponse resp, ClubMember clubMember)
			throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		Gson gson = new Gson();
		String json = gson.toJson(clubMember);
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}

	@Override
	public void backJson(HttpServletRequest req, HttpServletResponse resp, List<ClubMember> clubMembers)
			throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		
		Gson gson = new Gson();
		String json = gson.toJson(clubMembers);
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
		
	}

	@Override
	public void backJson(HttpServletRequest req, HttpServletResponse resp, int[] array) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id_list", array);
		
		System.out.println("jsonObject: " + jsonObject);
		
		String json = jsonObject.toString();
		System.out.println("jsonObject.toString() : " + json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();

	}
	

}
