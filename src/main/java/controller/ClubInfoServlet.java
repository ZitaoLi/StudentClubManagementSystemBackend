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
			int clubId = Integer.parseInt(req.getParameter("club_id"));
			Club club = clubServiceImpl.findById(clubId);
			clubServiceImpl.backSingleClubWithJson(req, resp, club);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}











