package controller.admin.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.UserBO;
import modal.User;

/**
 * Servlet implementation class UpdateUserController
 */
@WebServlet("/admin/update-user")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBO userBO = new UserBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String updateId = request.getParameter("update-id");
		
		if (updateId != null) {
			User user = userBO.getUserById(Long.parseLong(updateId));
			if (user != null) {
				request.setAttribute("user", user);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/update-user.jsp");
			rd.forward(request, response);
		} else {
			Long id = Long.parseLong(request.getParameter("id"));
			String hoTen = request.getParameter("hoten");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String diaChi = request.getParameter("diachi");
			Integer gt = Integer.parseInt(request.getParameter("giotinh"));
			

			
			if (id != null && hoTen != null && email != null && phone != null && diaChi != null && gt != null) {
				boolean gioTinh = (gt == 1);
				User user = new User();
				user.setHoTen(hoTen);
				user.setEmail(email);
				user.setPhone(phone);
				user.setGioTinh(gioTinh);
				user.setDiaChi(diaChi);
				user.setId(id);

				boolean isUpdated = userBO.updateUserById(user);
				if (isUpdated) {
					response.sendRedirect("/admin/user");
				} else {
					request.setAttribute("error", "Cập nhật thất bại!");
					RequestDispatcher rd = request.getRequestDispatcher("/admin/user/update-user.jsp");
					rd.forward(request, response);
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
