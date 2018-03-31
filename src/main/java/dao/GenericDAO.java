package dao;

import java.util.List;


public interface GenericDAO<T> {

	List<T> findAll();
	T findById(int id);
	boolean add(T object);
	boolean update(T object);
	boolean remove(int id);
}
