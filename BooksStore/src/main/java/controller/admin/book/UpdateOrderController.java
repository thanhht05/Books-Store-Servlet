package controller.admin.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.ChiTietHDBO;
import modal.ChiTietHoaDon;

/**
 * Servlet implementation class UpdateBookController
 */
@WebServlet("/admin/UpdateOrder")
public class UpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChiTietHDBO chiTietHDBO = new ChiTietHDBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idOrder= request.getParameter("order_id");
		
		if(idOrder!=null) {
			ChiTietHoaDon cthd = chiTietHDBO.getById(Long.parseLong(idOrder));
			
			request.setAttribute("order", cthd);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/order/update.jsp");
			rd.forward(request, response);
			
		}else {
			String daMuaStr= request.getParameter("daMua");
			Long id = Long.parseLong(request.getParameter("id"));
			
			if(daMuaStr.equals("1")) {
				
				chiTietHDBO.updateOrder(id, true);
			}else {
				chiTietHDBO.updateOrder(id, false);
			}
			response.sendRedirect("/admin/orders");
		
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
