package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import service.ClubInternalTransactionServiceImpl;
import modle.ClubInternalTransaction;

@WebServlet("/controller/MessageWallServlet")
public class MessageWallServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post MessageWallServlet");
		try {
			int clubId = Integer.parseInt(req.getParameter("club_id"));
			System.out.println("club_id: " + clubId);
			ClubInternalTransactionServiceImpl clubInternalTransactionServiceImpl = (ClubInternalTransactionServiceImpl) ServiceFactory.loadServiceImpl("ClubInternalTransactionServiceImpl");
			List<ClubInternalTransaction> clubInterTransactions = clubInternalTransactionServiceImpl.findByClubId(clubId);
			System.out.println("clubInterTransactions: " + clubInterTransactions);
			if (clubInterTransactions == null) {
				// 返回0表示没有数据
				clubInternalTransactionServiceImpl.backJson(req, resp, "0");
			} else {
				clubInternalTransactionServiceImpl.backJson(req, resp, clubInterTransactions);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
