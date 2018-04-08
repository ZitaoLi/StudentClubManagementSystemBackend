package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.FileUtils;
import util.ImageBase64Utils;

@WebServlet("/controller/ImageUploaderServlet")
public class ImageUploaderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post ImageUploaderServlet");
		try {
			String type = req.getParameter("type");
			if ("club_creation".equals(type)) {
				int tempId = Integer.parseInt(req.getParameter("temp_id"));
				String base64 = req.getParameter("base64_img");
				String path = "/resource/update_img/" + FileUtils.getRandomFileName();
				ImageBase64Utils.base64ToImageFile(base64, path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
