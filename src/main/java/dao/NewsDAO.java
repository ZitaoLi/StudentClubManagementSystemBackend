package dao;

import java.util.List;

import modle.News;;

interface NewsDAO extends GenericDAO<News> {

	List<News> findAll();
	List<News> findMultiNews(int num);
	News findById(int id);
	boolean add(News news);
	boolean update(News news);
	boolean remove(int id);
}
