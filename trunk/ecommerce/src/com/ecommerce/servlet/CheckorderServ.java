package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.db.HibernateSessionFactory;
import com.ecommerce.hiBean.*;
import com.ecommerce.hiDAO.*;

public class CheckorderServ extends HttpServlet{

	/**
	 * @param args
	 */
	public CheckorderServ(){
		super();
	}
	
	public void destroy() {
		super.destroy();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
// TODO Auto-generated method stub
				
		
		int userid=Integer.parseInt(request.getParameter("userid"));
		ShoppingcartDAO query=new ShoppingcartDAO();
		ArrayList items = new ArrayList();
		
		items = (ArrayList)query.getItemsByUserId(userid);
		System.out.println(items.size());
		for(int i=0; i<items.size();i++){
			Item t = (Item)items.get(i);
			System.out.println(t.getItemName()+t.getPrice());
		}
		String target="./check.jsp";
		HttpSession session = request.getSession();
		session.setAttribute("items",items);
		request.getRequestDispatcher(target).forward(request, response);

	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	
	
	
}
