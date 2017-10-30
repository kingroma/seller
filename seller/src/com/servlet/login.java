package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.ManagerStaticAttribute;
import com.manager.Admin_SellerManager;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id").toString();
		String pw = request.getParameter("pw").toString();
		
		//System.out.println(id+"/"+pw);
		
		Admin_SellerManager asm = new Admin_SellerManager();
		
		if(asm.loginSeller(ManagerStaticAttribute.sellerDataPath, id, pw)){
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				
				PrintWriter out = response.getWriter();
				out.print("<html><head>"
						+ "<script>"
						+ "alert('welcome.');location.replace('main');"
						+ "</script>"
						+ "<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>"
						+ "</head><body>");
				out.print("</body></html>");
				
				//response.sendRedirect("main.jsp");
			}
		else{
			PrintWriter out = response.getWriter();
			out.print("<html><head><script>alert('[[ "+id+" ]] is not');location.replace('index.jsp');</script></head><body>");
			out.print("</body></html>");
			//response.sendRedirect("index.jsp");
		}
		
	}

}
