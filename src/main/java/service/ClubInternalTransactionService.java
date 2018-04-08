package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.ClubInternalTransaction;

public interface ClubInternalTransactionService extends GenericService<ClubInternalTransaction> {

	List<ClubInternalTransaction> findAll();
	List<ClubInternalTransaction> findByClubId(int clubId);
	ClubInternalTransaction findById(int id);
	boolean add(ClubInternalTransaction clubInternalTransaction);
	boolean update(ClubInternalTransaction clubInternalTransaction);
	boolean remove(int id);
	void backJson(HttpServletRequest request, HttpServletResponse response, ClubInternalTransaction clubInternalTransaction) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, List<ClubInternalTransaction> clubInternalTransactions) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, String json) throws Exception;
	String generateBody(int typeCode, Map map);
}
