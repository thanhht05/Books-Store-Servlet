package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.LoaiBO;
import BO.SachBO;
import modal.Loai;
import modal.Sach;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoaiBO loaiBO= new LoaiBO();
		SachBO sachBO = new SachBO();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.setAttribute("dsl", loaiBO.getAllLoai());
		ArrayList<Sach> ds=null;
		String mlPrg=request.getParameter("ml");
		String tenSachPrg=request.getParameter("tenSach");
		
		if(mlPrg!=null){
			
			ds=sachBO.getSachByLoai(mlPrg);
		}else if(tenSachPrg!=null){
			ds=sachBO.findByTenSach(tenSachPrg);
		}else{
			ds=sachBO.getAllSach();
		}
		
		request.setAttribute("dss", ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
		
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
