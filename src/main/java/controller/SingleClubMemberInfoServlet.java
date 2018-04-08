package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import modle.ClubMember;
import service.ClubMemberServiceImpl;
import service.UserServiceImpl;

@WebServlet("/controller/SingleClubMemberInfoServlet")
public class SingleClubMemberInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("get SingleClubMemberInfoServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("post SingleClubMemberInfoServlet");
		ClubMemberServiceImpl clubMemberSeiviceImpl = (ClubMemberServiceImpl) ServiceFactory.loadServiceImpl("ClubMemberServiceImpl");
		try {
			int userId = Integer.parseInt(req.getParameter("user_id"));
			int clubId = Integer.parseInt(req.getParameter("club_id"));
			System.out.println("user_id: " + userId + "club_id: " + clubId);
			ClubMember clubMember = clubMemberSeiviceImpl.findByUserIdwithClubId(userId, clubId);
			if (clubMember != null) {
				clubMemberSeiviceImpl.backJson(req, resp, clubMember);
			} else {
				PrintWriter out = resp.getWriter();
				out.print(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
