package service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.NewsDAOImpl;
import dao.UserDAOImpl;
import factory.DAOFactory;
import modle.News;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> findMultiNews(int num) {
		NewsDAOImpl newsDAOImpl = (NewsDAOImpl) DAOFactory.getDAOImpl("NewsDAOImpl");
		return newsDAOImpl.findMultiNews(num);
	}

	@Override
	public News findById(int id) {
		NewsDAOImpl newsDAOImpl = (NewsDAOImpl) DAOFactory.getDAOImpl("NewsDAOImpl");
		return newsDAOImpl.findById(id);
	}

	@Override
	public boolean add(News news) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(News news) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void backJson(HttpServletRequest req, HttpServletResponse resp, List<News> newsList) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		
		Gson gson = new Gson();
		String json = gson.toJson(newsList);
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}

	@Override
	public void backJson(HttpServletRequest req, HttpServletResponse resp, News news) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		Gson gson = new Gson();
		String json = gson.toJson(news);
		
		System.out.println(json);
		
		PrintWriter out = null;
		out = resp.getWriter();
		out.write(json);
		out.close();
	}

}
