package com.ecommerce.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.hiDAO.AdministratorDAO;
import com.ecommerce.hiDAO.UsersDAO;

public class DeleteUserServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteUserServ() {
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

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String deleteEmail=request.getParameter("deleteEmail");
		HttpSession session = request.getSession();
		String target;
		System.out.println(deleteEmail);
		UsersDAO udao = new UsersDAO();
		udao.deleteByEmail(deleteEmail);
		System.out.println("delete done");
		target = "./UserList.do";
		request.getRequestDispatcher(target).forward(request, response);
		
	}
	
	
}
