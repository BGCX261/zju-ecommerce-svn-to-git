package com.ecommerce.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.hiBean.Users;
import com.ecommerce.hiDAO.AdministratorDAO;
import com.ecommerce.hiDAO.UsersDAO;

public class UserListServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserListServ() {
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 
		HttpSession session = request.getSession();
		String target;
		UsersDAO udao = new UsersDAO();
		List<Users> users= (List<Users>)udao.findAll();
		
		target="./adminUser.jsp";		
		session.setAttribute("users",users);
		request.getRequestDispatcher(target).forward(request, response);
		
	}
	
	

}
