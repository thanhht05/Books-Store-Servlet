package controller.user;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import BO.RoleBO;
import BO.UserBO;
import modal.Role;
import modal.User;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBO userBO = new UserBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if (action == null) {
			// Mặc định: hiển thị trang đăng nhập
			RequestDispatcher rd = request.getRequestDispatcher("user/dangnhap.jsp");
			rd.forward(request, response);
			return;
		}

		switch (action) {
		case "login":
			// Hiển thị form đăng nhập
			RequestDispatcher rdLogin = request.getRequestDispatcher("user/dangnhap.jsp");
			rdLogin.forward(request, response);
			break;

		case "register":
			// Hiển thị form đăng ký
			RequestDispatcher rdRegister = request.getRequestDispatcher("user/dangky.jsp");
			rdRegister.forward(request, response);
			break;

		case "logout":
			session.invalidate();
			response.sendRedirect("auth?action=login");
			break;

		default:
			response.sendRedirect("auth?action=login");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		RoleBO roleBO = new RoleBO();
		

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		switch (action) {
		case "login":
			String emailLogin = request.getParameter("email");
			String pass = request.getParameter("pass");

			if (emailLogin == null || pass == null) {
				request.setAttribute("error", "Vui lòng nhập đủ thông tin!");
				request.getRequestDispatcher("user/dangnhap.jsp").forward(request, response);
				return;
			}

			if (userBO.checkLogin(emailLogin, pass)) {
				User user = userBO.getUserByEmail(emailLogin);
				
				if(user!=null) {
					session.setMaxInactiveInterval(1* 24*60*60); // 1ngay, 
					session.setAttribute("userLogin",user);
					
					
					
				}
				if(user.getRole().getId()==1) {
					response.sendRedirect("home");
				}else {
					response.sendRedirect("/admin");
				}
			} else {
				request.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
				request.getRequestDispatcher("user/dangnhap.jsp").forward(request, response);
			}
			break;

		case "register":
			String email = request.getParameter("email");
			String hoten=request.getParameter("hoten");
			String passPrg = request.getParameter("password");
			String passConfirm = request.getParameter("confirm");
			

			if (!passPrg.equals(passConfirm)) {
				request.setAttribute("error", "Mật khẩu xác nhận không khớp!");
				request.getRequestDispatcher("user/dangky.jsp").forward(request, response);
				return;
			}

			if (userBO.checkExistsUserByEmail(email)) {
				request.setAttribute("error", "Tài khoản đã tồn tại!");
				request.getRequestDispatcher("user/dangky.jsp").forward(request, response);
				return;
			}

			User user = new User();
			user.setEmail(email);
			user.setPassword(passPrg);
			user.setHoTen(hoten);
			long roleId=1;
			Role role =roleBO.getRoleById(roleId);
			if(role!=null) {
				user.setRole(role);
			}
			userBO.createUser(user);

			// Đăng ký thành công → chuyển sang trang login
			response.sendRedirect("auth?action=login");
			break;

		default:
			response.sendRedirect("auth?action=login");
			break;
		}
	}
}
