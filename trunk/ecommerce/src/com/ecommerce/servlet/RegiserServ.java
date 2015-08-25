package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.bussiness.UserBussiness;
import com.ecommerce.hiBean.Users;

public class RegiserServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegiserServ() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	   Users user=new Users();
	   
	    	user.setUserPwd(request.getParameter("password1"));		 
	    	user.setUserName(request.getParameter("username"));   
	    	user.setEmail(request.getParameter("email"));	   
	    	user.setPhone(request.getParameter("mobile"));	   
	        user.setAddress(request.getParameter("addr"));
	        user.setCampus(request.getParameter("campus"));
	 
	   
	    
	    user=UserBussiness.userRgister(user);
	    String target;
	   if (user!=null) {
			
		HttpSession session = request.getSession();		
	    session.setAttribute("user", user);
	    session.removeAttribute("errorinfo");
	    target="./index.jsp";
	   }
	   else{
		   HttpSession session = request.getSession();		
		   session.setAttribute("errorinfo", "邮箱已经存在");
		 target="./register.jsp";
	   }
	    response.sendRedirect(target);
	   
	
}
}
