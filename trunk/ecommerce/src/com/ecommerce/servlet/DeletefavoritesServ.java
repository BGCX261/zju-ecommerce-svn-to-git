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

public class DeletefavoritesServ extends HttpServlet{

	/**
	 * @param args
	 */
	public DeletefavoritesServ(){
		super();
	}
	
	public void destroy() {
		super.destroy();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
// TODO Auto-generated method stub
		int flag=3;//PrintWriter out = response.getWriter();
		try{
			
		Session session = HibernateSessionFactory.getSession();
		int itemid=Integer.parseInt(request.getParameter("itemid"));
		int userid=Integer.parseInt(request.getParameter("userid"));
		System.out.print("aaaaa"+itemid+"aaaa"+userid);
		
		ItemDAO query=new ItemDAO();
		Item item=query.findById(itemid);
		UsersDAO query2=new UsersDAO();
		Users user=query2.findById(userid);
		FavoritesId FavoritesId=new FavoritesId(itemid,userid);
		Favorites Favorites= new Favorites(FavoritesId,user,item,item.getItemUrl());
		Transaction tx = session.beginTransaction();
		session.delete(Favorites);
		tx.commit();System.out.print("kkkkk");
		session.close();
				
		}
		catch(Exception e)
		{
			//flag=4;
			System.out.print("ssssss");
		}
		int userid=Integer.parseInt(request.getParameter("userid"));
		FavoritesDAO query3=new FavoritesDAO();
		ArrayList items = new ArrayList();
		
		items = (ArrayList)query3.getItemsByUserId(userid);
		String target="./favorites.jsp";
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
