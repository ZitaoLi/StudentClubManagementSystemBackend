package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.Notice;

public interface NoticeService extends GenericService<Notice> {

	List<Notice> findAll();
	Notice findById(int id);
	boolean add(Notice notice);
	boolean update(Notice notice);
	boolean remove(int id);
	void backJson(HttpServletRequest request, HttpServletResponse response, Notice notice) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, List<Notice> notices) throws Exception;
	void backJson(HttpServletRequest request, HttpServletResponse response, String json) throws Exception;
	String generateNoticeBody(int typeCode, Map map);
}
