package controller.admin.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.UserBO;

/**
 * Servlet implementation class DeleteUserController
 */
@WebServlet("/admin/delete-user")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBO userBO = new UserBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deletId = request.getParameter("delete-id");
		if (deletId != null) {
			request.setAttribute("id", deletId);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/delete-user.jsp");
			rd.forward(request, response);
		}else {
			
			Long id = Long.parseLong(request.getParameter("id"));
			if (id != null) {
				boolean isDeleted = userBO.deleteUserById(id);
				if (isDeleted) {
					response.sendRedirect("/admin/user");
				}
			}

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
