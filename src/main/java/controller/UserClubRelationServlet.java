package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import modle.ClubMember;
import modle.User;
import service.ClubMemberServiceImpl;
import service.UserServiceImpl;

@WebServlet("/controller/UserClubRelationServlet")
public class UserClubRelationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("get UserClubRelationServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post UserClubRelationServlet");
		ClubMemberServiceImpl clubMemberServiceImpl = (ClubMemberServiceImpl) ServiceFactory.loadServiceImpl("ClubMemberServiceImpl");
		try {
			String userId = req.getParameter("user_id");
			String  clubId = req.getParameter("club_id");
			if (userId != null) {
				int id = Integer.parseInt(userId);
				List<Integer> clubIdList = clubMemberServiceImpl.findClubIdByUserId(id);
				System.out.println("club_id: " + clubIdList.toString());
				
				int[] clubIdArray = new int[clubIdList.size()];  
				for(int i = 0; i<clubIdList.size(); i++){  
					clubIdArray[i] = clubIdList.get(i);  
				}
				clubMemberServiceImpl.backJson(req, resp, clubIdArray);
			} else if (clubId != null) {
				int id = Integer.parseInt(clubId);
				List<Integer> userIdList = clubMemberServiceImpl.findUserIdByClubId(id);
				System.out.println("user_id: " + userIdList.toString());
				
				int[] userIdArray = new int[userIdList.size()];  
				for(int i = 0; i<userIdList.size(); i++){  
					userIdArray[i] = userIdList.get(i);  
				}
				clubMemberServiceImpl.backJson(req, resp, userIdArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
