package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.Upload;;

/**
 * Servlet implementation class fileupload
 */
@WebServlet("/fileupload")
public class fileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileupload() {
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
		
		if(request.getSession().getAttribute("id").toString()==null){
			
		}
		else if(request.getParameter("title")==null){
			
		}
		else if(request.getParameter("price")==null){
			
		}
		
		Upload upload = new Upload(request,request.getSession().getAttribute("id").toString()); 
		
		PrintWriter out = response.getWriter();
		out.print("<html><head>"
				+ "<script>"
				+ "alert('upload complete.');location.replace('main');"
				+ "</script>"
				+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"
				+ "</head><body>");
		out.print("</body></html>");
	}
	public void error(String msg,HttpServletResponse response){
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<html><head>"
					+ "<script>"
					+ "alert('"+msg+"');location.replace('main');"
					+ "</script>"
					+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"
					+ "</head><body>");
			out.print("</body></html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
