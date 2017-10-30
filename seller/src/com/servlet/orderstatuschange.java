package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.SuperAdminClass;

/**
 * Servlet implementation class orderstatuschange
 */
@WebServlet("/orderstatuschange")
public class orderstatuschange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderstatuschange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String status_radio = request.getParameter("status_radio");
		String seller_id = request.getParameter("seller_id");
		String buyer_id = request.getParameter("buyer_id");
		String product_num = request.getParameter("product_num");
		String order_num = request.getParameter("order_num");
		
		if(status_radio==null|seller_id==null|buyer_id==null|product_num==null|order_num==null){
			PrintWriter out = response.getWriter();
			out.print("<html><head>"
					+ "<script>"
					+ "alert('something wrong.');location.replace('main');"
					+ "</script>"
					+ "<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>"
					+ "</head><body>");
			out.print("</body></html>");
		}else{
			SuperAdminClass sac = new SuperAdminClass(buyer_id, seller_id, product_num, order_num);
			sac.changeOrderStatusBySeller(status_radio);
			PrintWriter out = response.getWriter();
			out.print("<html><head>"
					+ "<script>"
					+ "alert('complete');location.replace('main');"
					+ "</script>"
					+ "<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>"
					+ "</head><body>");
			out.print("</body></html>");
		}
	}

}
