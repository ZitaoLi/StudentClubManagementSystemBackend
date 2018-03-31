package service;

import java.util.List;

import modle.Club;

public interface GenericService<T> {

	List<T> findAll();
	T findById(int id);
	boolean add(T obj);
	boolean update(T obj);
	boolean remove(int id);
}
