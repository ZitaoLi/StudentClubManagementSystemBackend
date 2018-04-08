package dao;

import java.util.List;

import modle.Temp;

public interface TempDAO extends GenericDAO<Temp> {
	List<Temp> findAll();
	Temp findById(int id);
	boolean add(Temp temp);
	boolean update(Temp temp);
	boolean remove(int id);
}
