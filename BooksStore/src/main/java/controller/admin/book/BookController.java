package controller.admin.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.SachBO;
import modal.Sach;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/admin/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SachBO sachBO = new SachBO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		String pagePrg= request.getParameter("page");
		if(pagePrg!=null) {
			page=Integer.parseInt(pagePrg);
		}
		int rowsPerPage=10;
		int totalSach = sachBO.countSach();
		ArrayList<Sach> dss= sachBO.getSachByPage(page, rowsPerPage);
		
	    int totalPages = (int) Math.ceil((double) totalSach / rowsPerPage);
		request.setAttribute("dss", dss);
		request.setAttribute("curPage", page);
		request.setAttribute("totalPages", totalPages);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/books/show.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
