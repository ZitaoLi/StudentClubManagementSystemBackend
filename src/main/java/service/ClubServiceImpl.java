package service;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClubDAOImpl;
import factory.DAOFactory;
import modle.Club;

public class ClubServiceImpl implements ClubService {

	@Override
	public List<Club> findAll() {
		ClubDAOImpl clubDAOImpl = (ClubDAOImpl) DAOFactory.getDAOImpl("ClubDAOImpl");
		return clubDAOImpl.findAll();
	}

	@Override
	public Club findById(int id) {
		ClubDAOImpl clubDAOImpl = (ClubDAOImpl) DAOFactory.getDAOImpl("ClubDAOImpl");
		return clubDAOImpl.findById(id);
	}

	@Override
	public Club findByName(String clubName) {
		ClubDAOImpl clubDAOImpl = (ClubDAOImpl) DAOFactory.getDAOImpl("ClubDAOImpl");
		return clubDAOImpl.findByName(clubName);
	}

	@Override
	public boolean add(Club club) {
		ClubDAOImpl clubDAOImpl = (ClubDAOImpl) DAOFactory.getDAOImpl("ClubDAOImpl");
		boolean res = clubDAOImpl.add(club);
		return res;
	}

	@Override
	public boolean update(Club club) {
		ClubDAOImpl clubDAOImpl = (ClubDAOImpl) DAOFactory.getDAOImpl("ClubDAOImpl");
		boolean res = clubDAOImpl.update(club);
		return res;
	}

	@Override
	public boolean remove(int id) {
		ClubDAOImpl clubDAOImpl = (ClubDAOImpl) DAOFactory.getDAOImpl("ClubDAOImpl");
		boolean res = clubDAOImpl.remove(id);
		return res;
	}
	
	@Override
	public void backSingleClubWithJson(HttpServletRequest req, HttpServletResponse resp, Club club) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
//		int clubId = Integer.parseInt(req.getParameter("club_id"));
		
//		Club club = findById(clubId);
		
		Gson gson = new Gson();
		String json = gson.toJson(club);
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}
	
	@Override
	public void backMulitClubWithJson(HttpServletRequest req, HttpServletResponse resp, List<Club> clubs) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
//		int clubId = Integer.parseInt(req.getParameter("club_id"));
		
//		List<Club> clubs = findAll();
		
		Gson gson = new Gson();
		String json = gson.toJson(clubs);
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}

	@Override
	public void backJson(HttpServletRequest req, HttpServletResponse resp, String json) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}
	
}









