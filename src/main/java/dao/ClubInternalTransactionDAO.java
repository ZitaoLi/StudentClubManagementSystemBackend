package dao;

import java.util.List;

import modle.ClubInternalTransaction;;

interface ClubInternalTransactionDAO extends GenericDAO<ClubInternalTransaction> {

	List<ClubInternalTransaction> findAll();
	List<ClubInternalTransaction> findByClubId(int clubId);
	ClubInternalTransaction findById(int id);
	boolean add(ClubInternalTransaction transaction);
	boolean update(ClubInternalTransaction transaction);
	boolean remove(int id);
}
