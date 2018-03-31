package dao;

import java.util.List;

import modle.User;

interface UserDAO extends GenericDAO<User> {

	List<User> findAll();
	User findById(int id);
	User findByCode(String studentCode);
	boolean add(User user);
	boolean update(User user);
	boolean remove(int id);
}
