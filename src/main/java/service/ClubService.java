package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.Club;

public interface ClubService extends GenericService<Club> {

	List<Club> findAll();
	Club findById(int id);
	boolean add(Club club);
	boolean update(Club club);
	boolean remove(int id);
	public void backSingleClubWithJson(HttpServletRequest req, HttpServletResponse resp, Club club) throws Exception;
	public void backMulitClubWithJson(HttpServletRequest req, HttpServletResponse resp, List<Club> clubs) throws Exception;
	
}
