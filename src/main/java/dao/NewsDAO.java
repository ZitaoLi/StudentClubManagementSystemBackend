package dao;

import java.util.List;

import modle.News;;

interface NewsDAO extends GenericDAO<News> {

	List<News> findAll();
	News findById(int id);
	boolean add(News news);
	boolean update(News news);
	boolean remove(int id);
}
