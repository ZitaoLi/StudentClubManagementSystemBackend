package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import modle.Club;
import modle.ClubManagementTransaction;
import modle.ClubMember;
import modle.Notice;
import modle.Temp;
import modle.User;
import service.ClubInternalTransactionServiceImpl;
import service.ClubManagementTransactionServiceImpl;
import service.ClubMemberServiceImpl;
import service.ClubServiceImpl;
import service.NoticeServiceImpl;
import service.TempServiceImpl;
import service.UserServiceImpl;
import util.FileUtils;
import util.ImageBase64Utils;

@WebServlet("/controller/UserRequestServlet")
public class UserRequestServlet extends HttpServlet {
	
	public static int CLUB_ACCESS_REQUEST = 1;
	public static int CLUB_CREATION_REQUEST = 2;
	public static int CLUB_QUERY_REQUEST = 3;
	public static int CLUB_ACTIVITY_REQUEST = 4;
	public static int CLUB_DISSSOLUTION_REQUEST = 5;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post UserRequestServlet");
		try {
			String type = req.getParameter("type");
			if ("club_access".equals(type)) {
				// TODO 处理入团申请请求
				handleClubAccessRequest(req, resp);
			} else if ("club_creation".equals(type)) {
				// TODO 处理社团创建请求
				handleClubCreationRequest(req, resp);
			} else if ("club_query".equals(type)) {
				// TODO 处理社团查询请求
				
			} else if ("club_activity".equals(type)) {
				// TODO 处理活动申请请求
				handleClubActivityRequest(req, resp);
			} else if ("club_dissolution".equals(type)) {
				// TODO 处理社团解除请求
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void handleClubActivityRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ClubManagementTransactionServiceImpl clubManagementTransactionServiceImpl = (ClubManagementTransactionServiceImpl) ServiceFactory.loadServiceImpl("ClubManagementTransactionServiceImpl");
		int userId = Integer.parseInt(req.getParameter("user_id"));
		int clubId = Integer.parseInt(req.getParameter("club_id"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String time = req.getParameter("time");
		String place = req.getParameter("place");
		String base64 = req.getParameter("base64_img");
		System.out.println("user_id: " + userId + " club_id: " + clubId + " title: " + title + " content: " + content + " time: " + time + " place: " + place);
		
		ClubServiceImpl clubServiceImpl = (ClubServiceImpl) ServiceFactory.loadServiceImpl("ClubServiceImpl");
		Club club = clubServiceImpl.findById(clubId);
		System.out.println("club: " + club);
		if (club == null) {
			// 返回0表示社团已经存在
			clubManagementTransactionServiceImpl.backJson(req, resp, "0");
		}
		UserServiceImpl userServiceImpl = (UserServiceImpl) ServiceFactory.loadServiceImpl("UserServiceImpl");
		User user= userServiceImpl.findById(userId);
		System.out.println("user: " + user);
		if (user == null) {
			// 返回0表示社团已经存在
			clubManagementTransactionServiceImpl.backJson(req, resp, "0");
		}
		// 保存图片
		String imagePathUrl = "";
		if (!"".equals(base64) && base64 != null) {
			String randomFileName = FileUtils.getRandomFileName() + ".jpg";
			String path = "C:\\Users\\homet\\eclipse-workspace\\StudentClubManagementSystem\\src\\main\\webapp\\resource\\update_img\\" +  randomFileName;
			imagePathUrl = "/resource/update_img/" + randomFileName;
			System.out.println("path: " + path);
			System.out.println("imagePathUrl: " + imagePathUrl);
			ImageBase64Utils.base64ToImageFile(base64, path);
		}
		
		Map map = new HashMap<>();
		map.put("club_id", clubId);
		map.put("club_name", club.getClubName());
		map.put("title", title);
		map.put("content", content);
		map.put("time", time);
		map.put("place", place);
		map.put("user_id", userId);
		map.put("user_name", user.getName());
		map.put("user_header_image_path", user.getHeaderImagePath());
		map.put("image_path", imagePathUrl);
		String body = clubManagementTransactionServiceImpl.generateBody(3, map);

		ClubManagementTransaction clubManagementTransaction = new ClubManagementTransaction();
		clubManagementTransaction.setBody(body);
		clubManagementTransaction.setUserId(userId);
		clubManagementTransaction.setTransactionType(3);
		boolean res = clubManagementTransactionServiceImpl.add(clubManagementTransaction);
		if (res == false) {
			// 返回-1表示添加失败
			clubManagementTransactionServiceImpl.backJson(req, resp, "-1");
		} else {
			clubManagementTransactionServiceImpl.backJson(req, resp, "1");
		}
	}

	private void handleClubCreationRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ClubManagementTransactionServiceImpl clubManagementTransactionServiceImpl = (ClubManagementTransactionServiceImpl) ServiceFactory.loadServiceImpl("ClubManagementTransactionServiceImpl");
		int userId = Integer.parseInt(req.getParameter("user_id"));
		String clubName = req.getParameter("club_name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String base64 = req.getParameter("base64_img");
		System.out.println("user_id: " + userId + " club_name: " + clubName + " title: " + title + " content: " + content);
		// 确认社团是否存在
		ClubServiceImpl clubServiceImpl = (ClubServiceImpl) ServiceFactory.loadServiceImpl("ClubServiceImpl");
		Club club = clubServiceImpl.findByName(clubName);
		System.out.println("club: " + club);
		if (club != null) {
			// 返回0表示社团已经存在
			clubManagementTransactionServiceImpl.backJson(req, resp, "0");
		}
		// 保存图片
		String imagePathUrl = "";
		if (!"".equals(base64) && base64 != null) {
			String randomFileName = FileUtils.getRandomFileName() + ".jpg";
			String path = "C:\\Users\\homet\\eclipse-workspace\\StudentClubManagementSystem\\src\\main\\webapp\\resource\\update_img\\" +  randomFileName;
			imagePathUrl = "/resource/update_img/" + randomFileName;
			System.out.println("path: " + path);
			System.out.println("imagePathUrl: " + imagePathUrl);
			ImageBase64Utils.base64ToImageFile(base64, path);
		}
		
		Map map = new HashMap<>();
		map.put("club_name", clubName);
		map.put("title", title);
		map.put("content", content);
		map.put("user_id", userId);
		map.put("image_path", imagePathUrl);
		String body = clubManagementTransactionServiceImpl.generateBody(1, map);

		ClubManagementTransaction clubManagementTransaction = new ClubManagementTransaction();
		clubManagementTransaction.setBody(body);
		clubManagementTransaction.setUserId(userId);
		clubManagementTransaction.setTransactionType(1);
		boolean res = clubManagementTransactionServiceImpl.add(clubManagementTransaction);
		if (res == false) {
			// 返回-1表示添加失败
			clubManagementTransactionServiceImpl.backJson(req, resp, "-1");
		} else {
			clubManagementTransactionServiceImpl.backJson(req, resp, "1");
		}
//		TempServiceImpl tempServiceImpl = (TempServiceImpl) ServiceFactory.loadServiceImpl("TempServiceImpl");
//		Temp temp = new Temp();
//		temp.setTitle(title);
//		temp.setContent(content);
//		temp.setTempName(clubName);
//		temp.setUserId(userId);
//		temp.setTime("");
//		temp.setPlace("");
//		temp.setImagePath("");
//		System.out.println("temp: " + temp);
//		int tempId = tempServiceImpl.add1(temp);
//		System.out.println("tempId: " + tempId);
//		if (tempId == 0) {
//			// 返回-1表示添加失败
//			tempServiceImpl.backJson(req, resp, "-1");
//		} else {
//			// 返回tempId
//			tempServiceImpl.backJson(req, resp, String.valueOf(tempId));
//		}
		
	}

	private void handleClubAccessRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		NoticeServiceImpl noticeServiceImpl = (NoticeServiceImpl) ServiceFactory.loadServiceImpl("NoticeServiceImpl");
		int userId = Integer.parseInt(req.getParameter("user_id"));
		String clubName = req.getParameter("club_name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println("user_id: " + userId + "club_name: " + clubName + "title: " + title + "content: " + content );
		// 确认社团是否存在
		ClubServiceImpl clubServiceImpl = (ClubServiceImpl) ServiceFactory.loadServiceImpl("ClubServiceImpl");
		Club club = clubServiceImpl.findByName(clubName);
		if (club == null) {
			// 返回0表示社团不存在
			noticeServiceImpl.backJson(req, resp, "0");
		}
		// 找到社团对应部长
		ClubMemberServiceImpl clubMemberServiceImpl = (ClubMemberServiceImpl) ServiceFactory.loadServiceImpl("ClubMemberServiceImpl");
		int clubId = club.getId();
		int ministorId = clubMemberServiceImpl.findMinistorByClubId(clubId);
		System.out.println("ministorId: " + ministorId);
		// 向Notice表添加添加一条记录
		Map map = new HashMap();
		map.put("user_id", userId);
		map.put("club_id", clubId);
		map.put("club_name", clubName);
		map.put("title", title);
		map.put("content", content);
		String body = noticeServiceImpl.generateNoticeBody(4, map);
		System.out.println("body: " + body);
		Notice notice = new Notice();
		notice.setUserId(ministorId);
		notice.setNoticeType(1);
		notice.setBody(body);
		System.out.println("notice: " + notice);
		boolean res = noticeServiceImpl.add(notice);
		System.out.println("res: " + res);
		if (!res ) {
			// 返回-1表示添加失败
			noticeServiceImpl.backJson(req, resp, "-1");
		} else {
			// 返回1表示添加成功
			noticeServiceImpl.backJson(req, resp, "1");
		}
	}

}
