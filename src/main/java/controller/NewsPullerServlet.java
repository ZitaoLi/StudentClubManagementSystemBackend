package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import modle.Club;
import modle.News;
import service.NewsServiceImpl;

@WebServlet("/controller/NewsPullerServlet")
public class NewsPullerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("get NewsPullerServlet");
		NewsServiceImpl newsServiceImpl = (NewsServiceImpl) ServiceFactory.loadServiceImpl("NewsServiceImpl");
		try {
			List<News> newsList = newsServiceImpl.findMultiNews(5);
			System.out.println("newsList: " + newsList);
			newsServiceImpl.backJson(req, resp, newsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post NewsPullerServlet");
		NewsServiceImpl newsServiceImpl = (NewsServiceImpl) ServiceFactory.loadServiceImpl("NewsServiceImpl");
		try {
			int newsId = Integer.parseInt(req.getParameter("news_id"));
			System.out.println("news_id: " + newsId);
			News news = newsServiceImpl.findById(newsId);
			System.out.println("news: " + news);
			newsServiceImpl.backJson(req, resp, news);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
