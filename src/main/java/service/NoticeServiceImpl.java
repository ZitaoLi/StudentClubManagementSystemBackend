package service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.google.gson.Gson;

import dao.ClubMemberDAOImpl;
import dao.NoticeDAOImpl;
import factory.DAOFactory;
import gson.ClubAccessRequest;
import modle.ClubMember;
import modle.Notice;

public class NoticeServiceImpl implements NoticeService {
	
	public static int SYSTEM_NOTICE = 1;
	public static int CLUB_INTERNAL_MESSAGE_NOTICE = 2;
	public static int CLUB_CONFERENCE_NOTICE = 3;
	public static int CLUB_ACCESS_NOTICE = 4;

	@Override
	public List<Notice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Notice notice) {
		NoticeDAOImpl noticeDAOImpl = (NoticeDAOImpl) DAOFactory.getDAOImpl("NoticeDAOImpl");
		boolean res =  noticeDAOImpl.add(notice);
		return res;
	}

	@Override
	public boolean update(Notice notice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void backJson(HttpServletRequest request, HttpServletResponse response, Notice notice) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void backJson(HttpServletRequest request, HttpServletResponse response, List<Notice> notices)
			throws Exception {
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
	public String generateNoticeBody(int typeCode, Map map) {
		if (typeCode == SYSTEM_NOTICE) {
			
		} else if (typeCode == CLUB_INTERNAL_MESSAGE_NOTICE) {
			
		} else if (typeCode == CLUB_CONFERENCE_NOTICE) {
			
		} else if (typeCode == CLUB_ACCESS_NOTICE) {
			int userId = (int) map.get("user_id");
			int clubId = (int) map.get("club_id");
			String clubName = (String) map.get("club_name");
			String title = (String) map.get("title");
			String content = (String) map.get("content");
			ClubAccessRequest request = new ClubAccessRequest();
			request.setUserId(userId);
			request.setClubId(clubId);
			request.setClubName(clubName);
			request.setTitle(title);
			request.setContent(content);
			return new Gson().toJson(request, ClubAccessRequest.class);
		}
		return null;
	}

}
