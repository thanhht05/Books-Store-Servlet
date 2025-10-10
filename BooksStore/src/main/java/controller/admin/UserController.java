package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.UserBO;
import configuration.PasswordEncryptor;
import modal.User;

@WebServlet("/create-user")
public class UserController extends HttpServlet {
	UserBO userBO = new UserBO();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hoTen=request.getParameter("hoten");
		String email = request.getParameter("email");
		String diaChi= request.getParameter("diachi");
		String phone = request.getParameter("phone");
		String gioTinh= request.getParameter("giotinh");
		String pass=request.getParameter("pass");
		if(hoTen!=null && email!=null && diaChi!=null && phone!=null && gioTinh!=null && pass!=null) {
			User user = new User();
			user.setDiaChi(diaChi);
			user.setEmail(email);
			user.setGioTinh(gioTinh.equals("1"));
			user.setHoTen(hoTen);
			
			user.setPassword(pass);
			user.setPhone(phone);
			userBO.createUser(user);
			
			response.sendRedirect("admin");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("admin/create-user.jsp");
			rd.forward(request, response);
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
