package dao;

import java.util.List;

import modle.ClubManagementTransaction;

interface ClubManagementTransactionDAO extends GenericDAO<ClubManagementTransaction> {

	List<ClubManagementTransaction> findAll();
	ClubManagementTransaction findById(int id);
	boolean add(ClubManagementTransaction transaction);
	boolean update(ClubManagementTransaction transaction);
	boolean remove(int id);
}
