package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.ClubMember;

public interface ClubMemberService extends GenericService<ClubMember> {

	List<ClubMember> findAll();
	ClubMember findById(int id);
	ClubMember findByUserIdwithClubId(int userId, int clubId);
	int findMinistorByClubId(int clubId);
	boolean add(ClubMember clubMember);
	boolean update(ClubMember clubMember);
	boolean remove(int id);
	void backJson(HttpServletRequest request, HttpServletResponse response, ClubMember clubMember) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, List<ClubMember> clubMembers) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, int[] array) throws Exception;
	List<Integer> findClubIdByUserId(int userId);
	List<Integer> findUserIdByClubId(int clubId);
}
