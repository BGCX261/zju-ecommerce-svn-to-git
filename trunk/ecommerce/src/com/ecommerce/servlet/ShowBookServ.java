package com.ecommerce.servlet;




import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.hiBean.Item;
import com.ecommerce.hiDAO.ItemDAO;

public class ShowBookServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowBookServ() {
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
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
// TODO Auto-generated method stub	
		String itemId=request.getParameter("type");
		System.out.println(itemId);
		
		String target="./merchandises.jsp";
		HttpSession session = request.getSession();
		session.setAttribute("itemType",itemId);
		
		request.getRequestDispatcher(target).forward(request, response);
	}
	
	

}
