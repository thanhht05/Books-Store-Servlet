package controller.admin.book;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BO.LoaiBO;
import BO.SachBO;
import DAO.UploadDAO;
import modal.Loai;

/**
 * Servlet implementation class CreateBookController
 */
@WebServlet("/admin/create-book")
public class CreateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UploadDAO uploadDAO = new UploadDAO();
	SachBO sachBO = new SachBO();
	LoaiBO loaiBO = new LoaiBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateBookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		if (request.getContentLength() <= 0) { // nếu người dùng k upload, k gửi form-data
			ArrayList<Loai> dsLoai = loaiBO.getAllLoai();
			request.setAttribute("dsLoai", dsLoai);
			request.getRequestDispatcher("/admin/books/create.jsp").forward(request, response);
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "files";
		response.getWriter().println(dirUrl1);

		String tenSach = null;
		long soLuong = 0;
		long gia = 0;
	
		String tacGia = null;
		String img = null;
		String maLoai=null;
		LocalDateTime now = LocalDateTime.now();
		Timestamp ngayNhap = Timestamp.valueOf(now);


		
		try {

			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						img="img/"+nameimg;
						String dirUrl = request.getServletContext().getRealPath("/img");
						

						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						
						File uploadedFile = new File(dirUrl + File.separator + nameimg);

						try {
							fileItem.write(uploadedFile);// lưu file
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
							System.out.println("UPLOAD THÀNH CÔNG...!");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("tenSach"))
						tenSach = fileItem.getString("UTF-8");
					if (tentk.equals("maLoai"))
						maLoai = fileItem.getString("UTF-8");
					if (tentk.equals("tacGia"))
						tacGia = fileItem.getString("UTF-8");
					if (tentk.equals("gia"))
						gia = Long.parseLong(fileItem.getString());
					if (tentk.equals("soLuong"))
						soLuong = Long.parseLong(fileItem.getString());
				}
			}
			
			sachBO.createSach(tenSach, soLuong, gia, tacGia, img, ngayNhap,maLoai);
			response.sendRedirect("/admin/book");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
