package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.News;

public interface NewsService extends GenericService<News> {

	List<News> findAll();
	List<News> findMultiNews(int num);
	News findById(int id);
	boolean add(News news);
	boolean update(News news);
	boolean remove(int id);
	void backJson(HttpServletRequest request, HttpServletResponse response, News news) throws Exception;
	void backJson(HttpServletRequest req, HttpServletResponse resp, List<News> newsList) throws Exception;
}
