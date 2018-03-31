package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import modle.User;
import service.UserServiceImpl;

@WebServlet("/controller/UserSignInServlet")
public class UserSignInServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		System.out.println(1);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.println(1);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("invoke UserInfoServlet");
		UserServiceImpl userServiceImpl = (UserServiceImpl) ServiceFactory.loadServiceImpl("UserServiceImpl");
		try {
			String studentCode = req.getParameter("student_code");
			String password = req.getParameter("password");
			System.out.println("student_code: " + studentCode + " password: " + password);
			int userId = userServiceImpl.validate(studentCode, password);
			if (userId != 0) {
				userServiceImpl.backId(req, resp, userId);
			} else if (userId == 0) {
				userServiceImpl.backId(req, resp, 0);
			} else if(userId == -1) {
				userServiceImpl.backId(req, resp, -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
