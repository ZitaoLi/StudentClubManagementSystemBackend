package dao;

import java.util.List;

import modle.ClubMember;

interface ClubMemberDAO extends GenericDAO<ClubMember> {

	List<ClubMember> findAll();
	ClubMember findById(int id);
	ClubMember findByUserIdwithClubId(int userId, int clubId);
	List<Integer> findClubIdByUserId(int userId);
	List<Integer> findUserIdByClubId(int clubId);
	boolean add(ClubMember member);
	boolean update(ClubMember member);
	boolean remove(int id);
	int findMinistorByClubId(int clubId);
}
