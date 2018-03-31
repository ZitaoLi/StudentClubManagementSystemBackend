package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.AdministratorDAOImpl;
import dao.ClubDAOImpl;
import factory.DAOFactory;
import modle.Club;
import util.CharacterUtils;

@WebServlet("/controller/TestServlet")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=UTF-8");
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
//		ClubDAOImpl clubDAOImpl = new ClubDAOImpl();
//		List<Club> clubs = clubDAOImpl.findAll();
		ClubDAOImpl clubDAOImpl = (ClubDAOImpl) DAOFactory.getDAOImpl("ClubDAOImpl");
		System.out.println(clubDAOImpl);
		List<Club> clubs = clubDAOImpl.findAll();
		for (Club club: clubs) {
			System.out.println(club.getClubName());
			String json = gson.toJson(club);
			out.write(json);
		}
//		Club club = clubDAOImpl.findById(13);
//		Gson gson = new Gson();
//		String json = gson.toJson(club);
//		out.write(json);
		
//		String str = "мен╞";
//		System.out.println(CharacterUtils.getEncoding(str));
//		Club club2 = new Club();
//		club2.setClubName(str);
//		club2.setClubInfo(str);
//		club2.setClubBgImagePath("");
//		clubDAOImpl.addClub(club2);
//		out.println("insert success");
		
//		AdministratorDAOImpl daoImpl = (AdministratorDAOImpl) DAOFactory.getDAO("AdministratorDAOImpl");
//		System.out.println(daoImpl);
//		AdministratorDAOImpl impl = new AdministratorDAOImpl();
//		System.out.println(impl);
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
