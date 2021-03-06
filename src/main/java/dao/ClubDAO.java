package dao;

import java.util.List;

import modle.Club;

interface ClubDAO extends GenericDAO<Club> {

	List<Club> findAll();
	Club findById(int id);
	Club findByName(String clubName);
	boolean add(Club club);
	boolean update(Club club);
	boolean remove(int id);
}
