package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import modle.Club;
import service.ClubServiceImpl;

@WebServlet("/controller/ImageLoaderServlet")
public class ImageLoaderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post ImageLoaderServlet");
		try {
			String imgType = req.getParameter("img_type");
			if ("club_bg_img".equals(imgType)) {
				int clubId = Integer.parseInt(req.getParameter("id"));
				ClubServiceImpl clubServiceImpl = (ClubServiceImpl) ServiceFactory.loadServiceImpl("ClubServiceImpl");
				Club club = clubServiceImpl.findById(clubId);
				clubServiceImpl.backJson(req, resp, club.getClubBgImagePath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
