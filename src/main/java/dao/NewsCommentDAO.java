package dao;

import java.util.List;

import modle.NewsComment;

interface NewsCommentDAO extends GenericDAO<NewsComment> {

	List<NewsComment> findAll();
	NewsComment findById(int id);
	boolean add(NewsComment comment);
	boolean update(NewsComment comment);
	boolean remove(int id);
}
