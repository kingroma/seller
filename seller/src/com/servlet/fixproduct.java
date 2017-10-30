package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.ManagerStaticAttribute;
import com.manager.Admin_ProductManager;
import com.manager.Admin_SellerManager;
import com.product.Product;

/**
 * Servlet implementation class fixproduct
 */
@WebServlet("/fixproduct")
public class fixproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fixproduct() {
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
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("seller_name");
		String title = request.getParameter("title");
		String textarea = request.getParameter("textarea");
		String price = request.getParameter("price");
		String product_num = request.getParameter("product_num");
		String status = request.getParameter("status");
		String categori = "null";
		if(request.getParameter("categori")!=null)
			categori= request.getParameter("categori");
		
		System.out.println
		("id : "+id+"//title : "+title+"//textarea : "+textarea+"//price : "+price+"//product_num"+product_num+"//status"+status);
		
		Admin_ProductManager apm = new Admin_ProductManager();
		Admin_SellerManager asm = new Admin_SellerManager();
		Product p = apm.getProduct(ManagerStaticAttribute.productDataPath, product_num);
		/*
		System.out.println("getSeller  : "+p.getSeller());
		System.out.println("getTitle  : "+p.getTitle());
		System.out.println("getPrice  : "+p.getPrice());
		System.out.println("getTextarea : "+p.getTextarea());
		System.out.println("p.getProduct_num() : "+p.getProduct_num());
		*/
		
		p.setTitle(title);
		p.setTextarea(textarea);
		p.setPrice(price);
		p.setStatus(status);
		p.setCategori(categori);
		
		apm.fixProduct(ManagerStaticAttribute.productDataPath, p);
		asm.fixSellerProduct(id, p);
		System.out.println(apm.getProduct(ManagerStaticAttribute.productDataPath, p.getProduct_num()).getTitle());
		
		PrintWriter out = response.getWriter();
		out.print("<html><head>"
				+ "<script>"
				+ "alert('complete.');location.replace('main');"
				+ "</script>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>"
				+ "</head><body>");
		out.print("</body></html>");
	}

}
