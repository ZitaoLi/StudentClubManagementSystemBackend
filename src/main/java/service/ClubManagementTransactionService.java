package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.ClubManagementTransaction;

public interface ClubManagementTransactionService extends GenericService<ClubManagementTransaction> {
	
	List<ClubManagementTransaction> findAll();
	ClubManagementTransaction findById(int id);
	boolean add(ClubManagementTransaction clubManagementTransaction);
	boolean update(ClubManagementTransaction clubManagementTransaction);
	boolean remove(int id);
	void backJson(HttpServletRequest request, HttpServletResponse response, ClubManagementTransaction clubManagementTransaction) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, List<ClubManagementTransaction> clubManagementTransaction) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, String json) throws Exception;
	String generateBody(int typeCode, Map map);
}
