package com.ecommerce.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.hiDAO.AdministratorDAO;
import com.ecommerce.hiDAO.UsersDAO;

public class adminLoginServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public adminLoginServ() {
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
		String adminName=request.getParameter("adminName");
		String adminPwd=request.getParameter("adminPwd");
		 
		HttpSession session = request.getSession();
		String target;
		AdministratorDAO adminDao = new AdministratorDAO();
		if(adminDao.adminLogin(adminName, adminPwd)==true){
			System.out.println("admin login success");
			target="./UserList.do";			
		}
		else{
			System.out.println("admin login error");
			target="./adminLogin.jsp";
		}
		session.setAttribute("adminName",adminName);
		request.getRequestDispatcher(target).forward(request, response);
		
	}
	
	
}
