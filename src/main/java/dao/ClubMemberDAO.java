package dao;

import java.util.List;

import modle.ClubMember;

interface ClubMemberDAO extends GenericDAO<ClubMember> {

	List<ClubMember> findAll();
	ClubMember findById(int id);
	boolean add(ClubMember member);
	boolean update(ClubMember member);
	boolean remove(int id);
}
