package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Type;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import factory.ServiceFactory;
import modle.ClubMember;
import modle.User;
import service.ClubMemberServiceImpl;
import service.ClubService;

@WebServlet("/controller/MultiClubMemberInfoServlet")
public class MultiClubMemberInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("get MultiClubMemberInfoServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("post MultiClubMemberInfoServlet");
		ClubMemberServiceImpl clubMemberSeiviceImpl = (ClubMemberServiceImpl) ServiceFactory.loadServiceImpl("ClubMemberServiceImpl");
		try {
			String[] userIdList = req.getParameterValues("user_id_list");
			String[] clubIdList = req.getParameterValues("club_id_list");
			System.out.println("user_id_list: " + userIdList);
			System.out.println("club_id_list: " + clubIdList);
			
			if (userIdList != null) {
				int clubId = Integer.parseInt(req.getParameter("club_id"));
				List<ClubMember> clubMembers = new ArrayList<ClubMember>();
				for (String userId: userIdList) {
					ClubMember clubMember = clubMemberSeiviceImpl.findByUserIdwithClubId(Integer.parseInt(userId), clubId);
					clubMembers.add(clubMember);
				}
				clubMemberSeiviceImpl.backJson(req, resp, clubMembers);
			} else if (clubIdList != null) {
				int userId = Integer.parseInt(req.getParameter("user_id"));
				List<ClubMember> clubMembers = new ArrayList<ClubMember>();
				for (String clubId: clubIdList) {
					ClubMember clubMember = clubMemberSeiviceImpl.findByUserIdwithClubId(userId, Integer.parseInt(clubId));
					clubMembers.add(clubMember);
				}
				clubMemberSeiviceImpl.backJson(req, resp, clubMembers);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
