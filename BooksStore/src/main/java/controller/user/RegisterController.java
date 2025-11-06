package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.RoleBO;
import BO.UserBO;
import modal.Role;
import modal.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBO userBO = new UserBO();
	RoleBO roleBO=new RoleBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String hoten = request.getParameter("hoten");
		String passPrg = request.getParameter("password");
		String passConfirm = request.getParameter("confirm");
		
		if(email ==null || hoten==null || passConfirm==null || passPrg==null) {
			RequestDispatcher rd = request.getRequestDispatcher("user/dangky.jsp");
			rd.forward(request, response);
			return;
		}

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
		long roleId = 1;
		Role role = roleBO.getRoleById(roleId);
		if (role != null) {
			user.setRole(role);
		}
		userBO.createUser(user);

		// Đăng ký thành công → chuyển sang trang login
		response.sendRedirect("auth?action=login");
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
