package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if (action == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
			rd.forward(request, response);
			return;
		}

		switch (action) {
		case "login":
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");

			String url;

			if (un == null || pass == null) {
				url = "dangnhap.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
				return;
			} else if (un.equals("abc") && pass.equals("123")) {
				session.setAttribute("un", un);
				url = "home";
				response.sendRedirect(url);
				return;
			} else {
				request.setAttribute("error", "Đăng nhập thất bại!");
				url = "dangnhap.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
				return;
			}

		

		case "logout":
			session.invalidate(); // Xóa session hiện tại
			response.sendRedirect("auth?action=login");
			return;

		default:
			response.sendRedirect("dangnhap.jsp");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
