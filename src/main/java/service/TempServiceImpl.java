package service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TempDAOImpl;
import factory.DAOFactory;
import modle.Temp;

public class TempServiceImpl implements TempService {

	@Override
	public List<Temp> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Temp temp) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int add1(Temp temp) {
		TempDAOImpl tempDAOImpl = (TempDAOImpl) DAOFactory.getDAOImpl("TempDAOImpl");
		return tempDAOImpl.add1(temp);
	}

	@Override
	public boolean update(Temp temp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void backJson(HttpServletRequest request, HttpServletResponse response, Temp temp) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void backJson(HttpServletRequest request, HttpServletResponse response, List<Temp> temps) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void backJson(HttpServletRequest req, HttpServletResponse resp, String json) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}

}
