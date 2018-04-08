package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClubDAOImpl;
import factory.DAOFactory;
import factory.ServiceFactory;
import modle.Club;
import service.ClubService;
import service.ClubServiceImpl;
import util.MyHttpUtils;

@WebServlet("/controller/ClubInfoServlet")
public class ClubInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get invoked");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClubServiceImpl clubServiceImpl = (ClubServiceImpl) ServiceFactory.loadServiceImpl("ClubServiceImpl");
		try {
			String clubId = req.getParameter("club_id");
			String clubName = req.getParameter("club_name");
			System.out.println("club_id: " + clubId);
			System.out.println("club_name: " + clubName);
			if (clubId == null && clubName != null) {
				// TODO 根据club_name查找
				Club club = clubServiceImpl.findByName(clubName);
				if (club == null) {
					// 返回0表示社团不存在
					clubServiceImpl.backJson(req, resp, "0");
				} else {
					clubServiceImpl.backSingleClubWithJson(req, resp, club);
				}
			} else if (clubId != null) {
				// TODO 根据club_id查找
				int id = Integer.parseInt(clubId);
				Club club = clubServiceImpl.findById(id);
				clubServiceImpl.backSingleClubWithJson(req, resp, club);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}











