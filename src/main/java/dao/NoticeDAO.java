package dao;

import java.util.List;

import modle.Notice;

interface NoticeDAO extends GenericDAO<Notice> {

	List<Notice> findAll();
	Notice findById(int id);
	boolean add(Notice notice);
	boolean update(Notice notice);
	boolean remove(int id);
}
