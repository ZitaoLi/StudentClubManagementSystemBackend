package service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClubInternalTransactionDAOImpl;
import factory.DAOFactory;
import gson.ClubConferenceOrganizing;
import gson.ClubCreationRequest;
import gson.ClubMessagePush;
import modle.ClubInternalTransaction;

public class ClubInternalTransactionServiceImpl implements ClubInternalTransactionService {
	
	public static int CLUB_MESSAGE_PUSH = 1;
	public static int CLUB_CONFERENCE_ORGANIZATION = 2;

	@Override
	public List<ClubInternalTransaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClubInternalTransaction> findByClubId(int clubId) {
		ClubInternalTransactionDAOImpl clubInternalTransactionDAOImpl = (ClubInternalTransactionDAOImpl) DAOFactory.getDAOImpl("ClubInternalTransactionDAOImpl");
		return clubInternalTransactionDAOImpl.findByClubId(clubId);
	}

	@Override
	public ClubInternalTransaction findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(ClubInternalTransaction clubInternalTransaction) {
		ClubInternalTransactionDAOImpl clubInternalTransactionDAOImpl = (ClubInternalTransactionDAOImpl) DAOFactory.getDAOImpl("ClubInternalTransactionDAOImpl");
		return clubInternalTransactionDAOImpl.add(clubInternalTransaction);
	}

	@Override
	public boolean update(ClubInternalTransaction clubInternalTransaction) {
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
			ClubInternalTransaction clubInternalTransaction) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void backJson(HttpServletRequest req, HttpServletResponse resp,
			List<ClubInternalTransaction> clubInternalTransactions) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		
		Gson gson = new Gson();
		String json = gson.toJson(clubInternalTransactions);
		
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

	@Override
	public String generateBody(int typeCode, Map map) {
		if (typeCode == CLUB_MESSAGE_PUSH) {
			int userId = (int) map.get("user_id");
			String userName = (String) map.get("user_name");
			String userHeaderImagePath = (String) map.get("user_header_image_path");
			String title = (String) map.get("title");
			String content = (String) map.get("content");
			ClubMessagePush transaction = new ClubMessagePush();
			transaction.setUserId(userId);
			transaction.setUserName(userName);
			transaction.setUserHeaderImagePath(userHeaderImagePath);
			transaction.setTitle(title);
			transaction.setContent(content);
			return new Gson().toJson(transaction, ClubMessagePush.class);
		} else if (typeCode == CLUB_CONFERENCE_ORGANIZATION) {
			int userId = (int) map.get("user_id");
			String userName = (String) map.get("user_name");
			String userHeaderImagePath = (String) map.get("user_header_image_path");
			String title = (String) map.get("title");
			String content = (String) map.get("content");
			String time = (String) map.get("time");
			String place = (String) map.get("place");
			ClubConferenceOrganizing transaction = new ClubConferenceOrganizing();
			transaction.setUserId(userId);
			transaction.setUserName(userName);
			transaction.setUserHeaderImagePath(userHeaderImagePath);
			transaction.setTitle(title);
			transaction.setContent(content);
			transaction.setTime(time);
			transaction.setPlace(place);
			return new Gson().toJson(transaction, ClubConferenceOrganizing.class);
		}
		return null;
	}

}
