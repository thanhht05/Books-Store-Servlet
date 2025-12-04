package DAO;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadDAO extends HttpServlet {
	private static final String UPLOAD_DIR = "img"; // thư mục lưu ảnh

	public String handleUploadFile(HttpServletRequest request, String inputFileName)
			throws IOException, ServletException {
		// Lấy thư mục lưu file
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		// Lấy file từ form
		Part filePart = request.getPart(inputFileName); // inputFileName = "customFile"

		if (filePart != null) {
			String fileName = filePart.getSubmittedFileName();
			String filePath = uploadPath + File.separator + fileName;
			filePart.write(filePath);
			return UPLOAD_DIR + "/" + fileName; // trả về đường dẫn tương đối để lưu vào DB
		}

		return null;

	}
}
