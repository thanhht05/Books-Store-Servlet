package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.UserBO;
import modal.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBO userBO = new UserBO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailLogin = request.getParameter("email");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();

		if (emailLogin == null && pass == null) {
			RequestDispatcher rd = request.getRequestDispatcher("user/dangnhap.jsp");
			rd.forward(request, response);
			return;
		}

		if (!userBO.checkLogin(emailLogin, pass)) {
			request.setAttribute("error", "Sai tài khoản hoặc mật khuẩu");
			RequestDispatcher rd = request.getRequestDispatcher("user/dangnhap.jsp");
			rd.forward(request, response);
			return;
		}

		User user = userBO.getUserByEmail(emailLogin);
		session.setMaxInactiveInterval(1 * 24 * 60 * 60); // 1ngay,
		session.setAttribute("userLogin", user);

		if (user.getRole().getId() == 1) {
			response.sendRedirect("home");
		} else {
			response.sendRedirect("admin");
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
