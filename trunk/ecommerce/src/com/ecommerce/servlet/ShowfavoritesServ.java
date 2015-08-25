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

public class ShowfavoritesServ extends HttpServlet{

	/**
	 * @param args
	 */
	public ShowfavoritesServ(){
		super();
	}
	
	public void destroy() {
		super.destroy();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
// TODO Auto-generated method stub
		int flag=1;//PrintWriter out = response.getWriter();
		try{
			
		Session session = HibernateSessionFactory.getSession();
		int itemid=Integer.parseInt(request.getParameter("itemid"));
		int userid=Integer.parseInt(request.getParameter("userid"));
		if(userid==-1)flag=2;
		else
		{
		ItemDAO query=new ItemDAO();
		Item item=query.findById(itemid);
		UsersDAO query2=new UsersDAO();
		Users user=query2.findById(userid);
		
		
		
		FavoritesId FavoritesId=new FavoritesId(itemid,userid);
		Favorites Favorites= new Favorites(FavoritesId,user,item,item.getItemUrl());
		Transaction tx = session.beginTransaction();
		session.save(Favorites);
		tx.commit();
		session.close();
				
		}
		
		}
		catch(Exception e)
		{
			//flag=0;
			//System.out.print("ssssss");
		}
		
			int userid=Integer.parseInt(request.getParameter("userid"));
			if(userid!=-1){
			FavoritesDAO query3=new FavoritesDAO();
			ArrayList items = new ArrayList();
			
			items = (ArrayList)query3.getItemsByUserId(userid);
			
			for(int i=0; i<items.size();i++){
				Item t = (Item)items.get(i);
				System.out.println(t.getItemName()+t.getPrice());
			}
			
			UsersDAO query2=new UsersDAO();
			Users user=query2.findById(userid);
		String target="./favorites.jsp";
		HttpSession session = request.getSession();
		session.setAttribute("items",items);
		session.setAttribute("user", user);


		request.getRequestDispatcher(target).forward(request, response);
			}
			else
			{
				flag=2;
				String target="./merchandise.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("flag",flag);
			
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
				out.println("<HTML>");
				out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
				out.println("  <BODY>");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"static/layout.css\" />");
				out.println("<script type=\"text/javascript\" src=\"js/AddFavorites.js\" charset=\"GBK\"></script><body onload=show("+flag+");>");
				out.println("  </BODY>");
				out.println("</HTML>");
				
			}
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
