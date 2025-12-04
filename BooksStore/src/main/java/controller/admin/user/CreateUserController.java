package controller.admin.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.RoleBO;
import BO.UserBO;
import configuration.PasswordEncryptor;
import modal.Role;
import modal.User;

@WebServlet("/admin/create-user")
public class CreateUserController extends HttpServlet {
	UserBO userBO = new UserBO();
	RoleBO roleBO = new RoleBO();

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
		String  rolePrg= request.getParameter("role");
		if(hoTen!=null && email!=null && diaChi!=null && phone!=null && gioTinh!=null && pass!=null && rolePrg!=null) {
			Long roleId=Long.parseLong(rolePrg);
			User user = new User();
			user.setDiaChi(diaChi);
			user.setEmail(email);
			user.setGioTinh(gioTinh.equals("1"));
			user.setHoTen(hoTen);
			
			Role role = roleBO.getRoleById(roleId);
			
			if(role!=null) {
				user.setRole(role);
			}
			
			user.setPassword(pass);
			user.setPhone(phone);
			userBO.createUser(user);
			
			response.sendRedirect("/admin/user");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/create-user.jsp");
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
