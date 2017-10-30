package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.SuperAdminClass;
import com.order.Order;
import com.product.Comment;

/**
 * Servlet implementation class replyorder
 */
@WebServlet("/replyorder")
public class replyorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public replyorder() {
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
		
		request.getParameter("");
		/*
		<input style="display:none;" name="seller_id" value="<%=order_list.get(j).getSeller() %>"> 
		<input style="display:none;" name="buyer_id" value="<%=order_list.get(j).getBuyer() %>">
		<input style="display:none;" name="product_num" value="<%=order_list.get(j).getProduct_num() %>">
		<input style="display:none;" name="order_num" value="<%=order_list.get(j).getOrder_num() %>">
		<input style="display:none;" name="order_comment" value="<%=order_list.get(j).getComment() %>">
		<input style="display:none;" name="order_comment_num" value="<%=z %>">
		
		<input style="width:250px;height:20px;" type="text" name="reply" value=" ">
		<input type="button" style="font-size:8pt;width:40px;height:20px;"value="¿Ï·á">
		*/
		
		String seller_id = request.getParameter("seller_id");
		String buyer_id = request.getParameter("buyer_id");
		String product_num = request.getParameter("product_num");
		String order_num = request.getParameter("order_num");
		
		String order_comment_num = request.getParameter("order_comment_num");
		String reply = request.getParameter("reply");
		
		SuperAdminClass sac = new SuperAdminClass(buyer_id, seller_id, product_num, order_num);
		
		if(seller_id==null|buyer_id==null|product_num==null|order_num==null|order_comment_num==null|reply==null){
			PrintWriter out = response.getWriter();
			out.print("<html><head>"
					+ "<script>"
					+ "alert('error.');location.replace('main');"
					+ "</script>"
					+ "<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>"
					+ "</head><body>");
			out.print("</body></html>");
		}
		else{
			if(sac.changeOrderReplyBySeller(order_comment_num,reply)){
			
			
				PrintWriter out = response.getWriter();
				out.print("<html><head>"
						+ "<script>"
						+ "alert('complete.');location.replace('main');"
						+ "</script>"
						+ "<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>"
						+ "</head><body>");
				out.print("</body></html>");
			}else{
				PrintWriter out = response.getWriter();
				out.print("<html><head>"
						+ "<script>"
						+ "alert('error.');location.replace('main');"
						+ "</script>"
						+ "<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>"
						+ "</head><body>");
				out.print("</body></html>");
			}
		}
		
	}

}
