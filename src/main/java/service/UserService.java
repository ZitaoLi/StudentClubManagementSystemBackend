package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.User;

public interface UserService extends GenericService<User> {

	List<User> findAll();
	User findById(int id);
	boolean add(User user);
	boolean update(User user);
	boolean remove(int id);
	int validate(String studentCode, String password);
	int register(String studentCode, String name, String password, String email, String phone);
	void backId(HttpServletRequest req, HttpServletResponse resp, int id) throws Exception;
	void backSingleClubWithJson(HttpServletRequest req, HttpServletResponse resp, User user) throws Exception;
	void backMulitClubWithJson(HttpServletRequest req, HttpServletResponse resp, List<User> users) throws Exception;
}
