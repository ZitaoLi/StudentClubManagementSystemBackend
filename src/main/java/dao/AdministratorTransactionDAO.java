package dao;

import java.util.List;

import modle.AdministratorTransaction;

interface AdministratorTransactionDAO extends GenericDAO<AdministratorTransaction> {

	List<AdministratorTransaction> findAll();
	AdministratorTransaction findById(int id);
	boolean add(AdministratorTransaction administratorTransaction);
	boolean update(AdministratorTransaction administratorTransaction);
	boolean remove(int id);
}
