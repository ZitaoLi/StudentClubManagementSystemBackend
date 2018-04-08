package service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClubManagementTransactionDAOImpl;
import factory.DAOFactory;
import gson.ClubAccessRequest;
import gson.ClubActivityRequest;
import gson.ClubCreationRequest;
import modle.ClubManagementTransaction;

public class ClubManagementTransactionServiceImpl implements ClubManagementTransactionService {
	
	public static int CLUB_CREATION_REQUEST = 1;
	public static int CLUB_DISSOLUTION_REQUEST = 2;
	public static int CLUB_ACTIVITY_REQUEST = 3;

	@Override
	public List<ClubManagementTransaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClubManagementTransaction findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(ClubManagementTransaction clubManagementTransaction) {
		ClubManagementTransactionDAOImpl clubManagementTransactionDAOImpl = (ClubManagementTransactionDAOImpl) DAOFactory.getDAOImpl("ClubManagementTransactionDAOImpl");
		return clubManagementTransactionDAOImpl.add(clubManagementTransaction);
	}

	@Override
	public boolean update(ClubManagementTransaction clubManagementTransaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void backJson(HttpServletRequest request, HttpServletResponse response,
			ClubManagementTransaction clubManagementTransaction) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void backJson(HttpServletRequest request, HttpServletResponse response,
			List<ClubManagementTransaction> clubManagementTransaction) throws Exception {
		// TODO Auto-generated method stub

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

	@Override
	public String generateBody(int typeCode, Map map) {
		if (typeCode == CLUB_CREATION_REQUEST) {
			int userId = (int) map.get("user_id");
			String clubName = (String) map.get("club_name");
			String title = (String) map.get("title");
			String content = (String) map.get("content");
			String imagePath = (String) map.get("image_path");
			ClubCreationRequest request = new ClubCreationRequest();
			request.setUserId(userId);
			request.setClubName(clubName);
			request.setTitle(title);
			request.setContent(content);
			request.setImagePath(imagePath);
			return new Gson().toJson(request, ClubCreationRequest.class);
		} else if (typeCode == CLUB_DISSOLUTION_REQUEST) {
			
		} else if (typeCode == CLUB_ACTIVITY_REQUEST) {
			int userId = (int) map.get("user_id");
			int clubId = (int) map.get("club_id");
			String clubName = (String) map.get("club_name");
			String title = (String) map.get("title");
			String content = (String) map.get("content");
			String time = (String) map.get("time");
			String place = (String) map.get("place");
			String userName = (String) map.get("user_name");
			String userHeaderImagePath = (String) map.get("user_header_image_path");
			String imagePath = (String) map.get("image_path");
			ClubActivityRequest request = new ClubActivityRequest();
			request.setUserId(userId);
			request.setClubName(clubName);
			request.setTitle(title);
			request.setContent(content);
			request.setImagePath(imagePath);
			request.setUserName(userName);
			request.setUserHeaderImagePath(userHeaderImagePath);
			request.setTime(time);
			request.setPlace(place);
			request.setClubId(clubId);
			return new Gson().toJson(request, ClubActivityRequest.class);
		}
		return null;
	}

}
