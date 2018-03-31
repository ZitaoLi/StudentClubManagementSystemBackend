package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import service.UserServiceImpl;

@WebServlet("/controller/UserSignUpServlet")
public class UserSignUpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("invoke UserSignUpServlet");
		UserServiceImpl userServiceImpl = (UserServiceImpl) ServiceFactory.loadServiceImpl("UserServiceImpl");
		try {
			String studentCode = req.getParameter("student_code");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			System.out.println("student_code: " + studentCode + " name: " + name + " password: " + password + " email: " + email + " phone: " + phone);
			// TODO register service
			int userId = userServiceImpl.register(studentCode, name, password, email, phone);
			if (userId != 0) {
				userServiceImpl.backId(req, resp, userId);
			} else if (userId == 0) {
				// 添加失败
				userServiceImpl.backId(req, resp, 0);
			} else if(userId == -1) {
				// 账号已经存在
				userServiceImpl.backId(req, resp, -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
