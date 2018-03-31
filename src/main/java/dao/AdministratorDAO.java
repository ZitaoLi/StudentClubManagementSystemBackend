package dao;

import java.util.List;

import modle.Administrator;;

interface AdministratorDAO extends GenericDAO<Administrator> {

	List<Administrator> findAll();
	Administrator findById(int id);
	boolean add(Administrator administrator);
	boolean update(Administrator administrator);
	boolean remove(int id);
}
