package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.ManagerStaticAttribute;
import com.common.SortArrayList;
import com.manager.Admin_OrderManager;
import com.manager.Admin_SellerManager;
import com.order.Order;
import com.product.Product;
import com.seller.Seller;

import java.util.ArrayList;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("TEST");
		ArrayList<Product> p = new ArrayList<Product>();
		String id = null;
		if(request.getSession().getAttribute("id")==null)
			response.sendRedirect("index.jsp");
		else{
			id = request.getSession().getAttribute("id").toString();
			//System.out.println(id);
			if(id==null||id.equals(""))
				response.sendRedirect("index.jsp");
			else{
				
				SortArrayList sort = new SortArrayList();
				
				p = sort.SortProduct(setList(id));
				

				Admin_SellerManager asm = new Admin_SellerManager();
				Seller s = asm.getSeller(ManagerStaticAttribute.sellerDataPath, id);
				s.setOrder(sort.SortOrder(s.getOrder()));
				s.setSell_product(sort.SortProduct(s.getSell_product()));
				//sort 하기 
				RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
				
				request.setAttribute("product_list", p);
				request.setAttribute("seller", s);
				
				rd.forward(request,response);
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	
		/*
		Admin_SellerManager asm = new Admin_SellerManager();
		Seller seller = null;
		ArrayList<Product> sell_list = null;
		if(id!=null){
			seller = asm.getSeller(ManagerStaticAttribute.sellerDataPath , id);
			sell_list = seller.getSell_product();
		}
		*/
		
	}
	
	public ArrayList<Product> setList(String id){
		Seller seller = null;
		ArrayList<Product> sell_list = null;
		if(id!=null){
			Admin_SellerManager asm = new Admin_SellerManager();
			
			
			if(id!=null){
				seller = asm.getSeller(ManagerStaticAttribute.sellerDataPath , id);
				sell_list = seller.getSell_product();
				
				 
			}
		}
		return sell_list;
	}
	
	public ArrayList<Order> setOrderList(String seller_id){
		String OrderPath = ManagerStaticAttribute.orderDataPath;
		Admin_OrderManager aom = new Admin_OrderManager();
		
		File file = new File(OrderPath);
		
		//Seller 판매하는거 오더들 가지고오기 .
		
		//aom.getOrder(path, num)
		return null;
	}
}
