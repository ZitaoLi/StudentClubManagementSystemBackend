package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import modle.ClubInternalTransaction;
import modle.ClubMember;
import service.ClubInternalTransactionServiceImpl;
import service.ClubMemberServiceImpl;

@WebServlet("/controller/ClubTransactionServlet")
public class ClubTransactionServlet extends HttpServlet {
	
	public static int MESSAGE_PUSH = 1;
	public static int CONFERENCE_ORGANIZING = 2;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("post ClubTransactionServlet");
		try {
			String type = req.getParameter("type");
			System.out.println("type: " + type);
			if ("message_push".equals(type)) {
				ClubInternalTransactionServiceImpl clubInternalTransactionServiceImpl = (ClubInternalTransactionServiceImpl) ServiceFactory.loadServiceImpl("ClubInternalTransactionServiceImpl");
				int userId = Integer.parseInt(req.getParameter("user_id"));
				int clubId = Integer.parseInt(req.getParameter("club_id"));
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				System.out.println("user_id: " + userId + " club_id: " + clubId + " title: " + title + " content: " + content);
				ClubMemberServiceImpl clubMemberServiceImpl = (ClubMemberServiceImpl) ServiceFactory.loadServiceImpl("ClubMemberServiceImpl");
				ClubMember clubMember = clubMemberServiceImpl.findByUserIdwithClubId(userId, clubId);
				System.out.println("clubMember: " + clubMember);
				if (clubMember == null) {
					// 返回0表示社团成员不存在
					clubInternalTransactionServiceImpl.backJson(req, resp, "0");
					return;
				}
				
				Map map = new HashMap();
				map.put("user_id", userId);
				map.put("user_name", clubMember.getUserName());
				map.put("user_header_image_path", clubMember.getUserHeaderImage());
				map.put("title", title);
				map.put("content", content);
				String body = clubInternalTransactionServiceImpl.generateBody(1, map);
				System.out.println("body: " + body);
				
				ClubInternalTransaction clubInternalTransaction = new ClubInternalTransaction();
				clubInternalTransaction.setBody(body);
				clubInternalTransaction.setMemberId(clubMember.getId());
				clubInternalTransaction.setTransacitonType(1);
				clubInternalTransaction.setClubId(clubId);
				System.out.println("clubInternalTransaction: " + clubInternalTransaction);
				boolean res = clubInternalTransactionServiceImpl.add(clubInternalTransaction);
				if (res == false) {
					// -1表示添加失败
					clubInternalTransactionServiceImpl.backJson(req, resp, "-1");
					return;
				} else {
					// 1表示添加成功
					clubInternalTransactionServiceImpl.backJson(req, resp, "1");
					return;
				}
				
			} else if ("conference_organizing".equals(type)) {
				ClubInternalTransactionServiceImpl clubInternalTransactionServiceImpl = (ClubInternalTransactionServiceImpl) ServiceFactory.loadServiceImpl("ClubInternalTransactionServiceImpl");
				int userId = Integer.parseInt(req.getParameter("user_id"));
				int clubId = Integer.parseInt(req.getParameter("club_id"));
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String time = req.getParameter("time");
				String place = req.getParameter("place");
				System.out.println("user_id: " + userId + " club_id: " + clubId + " title: " + title + " content: " + content + " time: " + time + " place: " + place);
				ClubMemberServiceImpl clubMemberServiceImpl = (ClubMemberServiceImpl) ServiceFactory.loadServiceImpl("ClubMemberServiceImpl");
				ClubMember clubMember = clubMemberServiceImpl.findByUserIdwithClubId(userId, clubId);
				System.out.println("clubMember: " + clubMember);
				if (clubMember == null) {
					// 返回0表示社团成员不存在
					clubInternalTransactionServiceImpl.backJson(req, resp, "0");
					return;
				}
				
				Map map = new HashMap();
				map.put("user_id", userId);
				map.put("user_name", clubMember.getUserName());
				map.put("user_header_image_path", clubMember.getUserHeaderImage());
				map.put("title", title);
				map.put("content", content);
				map.put("time", time);
				map.put("place", place);
				String body = clubInternalTransactionServiceImpl.generateBody(2, map);
				System.out.println("body: " + body);
				
				ClubInternalTransaction clubInternalTransaction = new ClubInternalTransaction();
				clubInternalTransaction.setBody(body);
				clubInternalTransaction.setMemberId(clubMember.getId());
				clubInternalTransaction.setTransacitonType(2);
				clubInternalTransaction.setClubId(clubId);
				System.out.println("clubInternalTransaction: " + clubInternalTransaction);
				boolean res = clubInternalTransactionServiceImpl.add(clubInternalTransaction);
				if (res == false) {
					// -1表示添加失败
					clubInternalTransactionServiceImpl.backJson(req, resp, "-1");
					return;
				} else {
					// 1表示添加成功
					clubInternalTransactionServiceImpl.backJson(req, resp, "1");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
