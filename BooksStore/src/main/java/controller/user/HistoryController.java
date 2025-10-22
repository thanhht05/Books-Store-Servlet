package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.LichSuMuaBO;
import modal.LichSuMua;
import modal.User;

@WebServlet("/history")
public class HistoryController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LichSuMuaBO lichSuMuaBO = new LichSuMuaBO();
	public HistoryController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("userLogin");
			if(user!=null) {
				ArrayList<LichSuMua> dsls= lichSuMuaBO.getLichSuMuaByUserId(user.getId());
				request.setAttribute("dsls",dsls);
				

	            RequestDispatcher rd = request.getRequestDispatcher("/user/lichsumua.jsp");
	            rd.forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
