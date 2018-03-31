package service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClubDAOImpl;
import dao.UserDAOImpl;
import factory.DAOFactory;
import modle.Club;
import modle.User;

public class UserServiceImpl implements UserService {

	@Override
	public List<User> findAll() {
		UserDAOImpl userDAOImpl = (UserDAOImpl) DAOFactory.getDAOImpl("UserDAOImpl");
		return userDAOImpl.findAll();
	}

	@Override
	public User findById(int id) {
		UserDAOImpl userDAOImpl = (UserDAOImpl) DAOFactory.getDAOImpl("UserDAOImpl");
		return userDAOImpl.findById(id);
	}

	@Override
	public boolean add(User club) {
		UserDAOImpl userDAOImpl = (UserDAOImpl) DAOFactory.getDAOImpl("UserDAOImpl");
		boolean res = userDAOImpl.add(club);
		return res;
	}

	@Override
	public boolean update(User club) {
		UserDAOImpl userDAOImpl = (UserDAOImpl) DAOFactory.getDAOImpl("UserDAOImpl");
		boolean res = userDAOImpl.update(club);
		return res;
	}

	@Override
	public boolean remove(int id) {
		UserDAOImpl userDAOImpl = (UserDAOImpl) DAOFactory.getDAOImpl("UserDAOImpl");
		boolean res = userDAOImpl.remove(id);
		return res;
	}
	
	@Override
	public void backSingleClubWithJson(HttpServletRequest req, HttpServletResponse resp, User user) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		Gson gson = new Gson();
		String json = gson.toJson(user);
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}
	
	@Override
	public void backMulitClubWithJson(HttpServletRequest req, HttpServletResponse resp, List<User> users) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		
		Gson gson = new Gson();
		String json = gson.toJson(users);
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}

	@Override
	public int validate(String studentCode, String password) {
	
		UserDAOImpl userDAOImpl = (UserDAOImpl) DAOFactory.getDAOImpl("UserDAOImpl");
		User user = userDAOImpl.findByCode(studentCode);
		if (user == null) {
			return -1;
		} else {
			System.out.println("p1: " + user.getPassword() + " p2: " + password);
		} 
		if (user.getPassword().equals(password)) {
			return user.getId();
		} else {
			return 0;
		}
	}
	

	@Override
	public int register(String studentCode, String name, String password, String email, String phone) {

		UserDAOImpl userDAOImpl = (UserDAOImpl) DAOFactory.getDAOImpl("UserDAOImpl");
		User user = userDAOImpl.findByCode(studentCode);
		if (user != null) {
			// ’À∫≈“—æ≠¥Ê‘⁄
			return -1;
		}
		user = new User();
		user.setStudentCode(studentCode);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhoneNumber(phone);
		boolean res = userDAOImpl.add(user);
		if (res == false) {
			// ÃÌº” ß∞‹
			return 0;
		}
		user = userDAOImpl.findByCode(studentCode);
		if (user == null) {
			// ÃÌº” ß∞‹
			return 0;
		}
		return user.getId();
	}

	@Override
	public void backId(HttpServletRequest req, HttpServletResponse resp, int id) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		System.out.println(id);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.print(id);
		out.close();
	}

}
