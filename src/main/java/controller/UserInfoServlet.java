package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import modle.User;
import service.UserServiceImpl;

@WebServlet("/controller/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("get UserInfoServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post UserInfoServlet");
		UserServiceImpl userServiceImpl = (UserServiceImpl) ServiceFactory.loadServiceImpl("UserServiceImpl");
		try {
			int userId = Integer.parseInt(req.getParameter("user_id"));
			User user = userServiceImpl.findById(userId);
			userServiceImpl.backSingleClubWithJson(req, resp, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
