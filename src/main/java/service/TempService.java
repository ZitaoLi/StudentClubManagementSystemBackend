package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.Temp;

public interface TempService extends GenericService<Temp> {

	List<Temp> findAll();
	Temp findById(int id);
	boolean add(Temp temp);
	boolean update(Temp temp);
	boolean remove(int id);
	void backJson(HttpServletRequest request, HttpServletResponse response, Temp temp) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, List<Temp> temps) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, String json) throws Exception;
}
