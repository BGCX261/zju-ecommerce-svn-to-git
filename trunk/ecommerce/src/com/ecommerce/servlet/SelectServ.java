package com.ecommerce.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.db.HibernateSessionFactory;
import com.ecommerce.hiBean.Favorites;
import com.ecommerce.hiBean.FavoritesId;
import com.ecommerce.hiBean.Item;
import com.ecommerce.hiBean.Shoppingcart;
import com.ecommerce.hiBean.ShoppingcartId;
import com.ecommerce.hiBean.Users;
import com.ecommerce.hiDAO.FavoritesDAO;
import com.ecommerce.hiDAO.ItemDAO;
import com.ecommerce.hiDAO.ShoppingcartDAO;
import com.ecommerce.hiDAO.UsersDAO;


/**
 * @param args
 */
public class SelectServ extends HttpServlet{

public SelectServ(){
	super();
}

public void destroy() {
	super.destroy();
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	
	Session session = HibernateSessionFactory.getSession();
	 String[] power=request.getParameterValues("selectAll");
	 int userid=Integer.parseInt(request.getParameter("userid"));
	 int itemid;
	 String target="";
	 String power_str="";
	   	   String str = new String(request.getParameter("Submit").getBytes("ISO-8859-1"),"utf-8");
	   if(str.equals("批量删除"))
	   {
		   for (int i = 0; i < power.length; i++) {
			  power_str+=power[i];
			  itemid=Integer.parseInt(power[i]);
			  ItemDAO query=new ItemDAO();
			  Item item=query.findById(itemid);
				UsersDAO query2=new UsersDAO();
				Users user=query2.findById(userid);

		FavoritesId FavoritesId=new FavoritesId(itemid,userid);
		Favorites Favorites= new Favorites(FavoritesId,user,item,item.getItemUrl());
		Transaction tx = session.beginTransaction();
		session.delete(Favorites);
		tx.commit();
		   }
		   //session.close();
		   FavoritesDAO query3=new FavoritesDAO();
			ArrayList items = new ArrayList();
			
			items = (ArrayList)query3.getItemsByUserId(userid);
			HttpSession session1 = request.getSession();
			session1.setAttribute("items",items);
		target="./favorites.jsp";
		request.getRequestDispatcher(target).forward(request, response);
		
		
	   }
	   else if(str.equals("批量购买"))
	   {
		   
		   for (int i = 0; i < power.length; i++) {
				  power_str+=power[i];
				  itemid=Integer.parseInt(power[i]);
				  ItemDAO query=new ItemDAO();
				  Item item=query.findById(itemid);
					UsersDAO query2=new UsersDAO();
					Users user=query2.findById(userid);
		   ShoppingcartId ShoppingcartId=new ShoppingcartId(itemid,userid);
			Shoppingcart Shoppingcart= new Shoppingcart(ShoppingcartId,user,item);
			Transaction tx = session.beginTransaction();
			session.save(Shoppingcart);
			tx.commit();
		   }
			session.close();
			target="./cart.jsp";
			ShoppingcartDAO query3=new ShoppingcartDAO();
			ArrayList items = new ArrayList();
			
			items = (ArrayList)query3.getItemsByUserId(userid);
			
			HttpSession session1 = request.getSession();
			session1.setAttribute("items",items);
			request.getRequestDispatcher(target).forward(request, response);
		   
	   
	   
	   
	   }
	   
	   
	   
	   
	   
	   System.out.println(userid+"ssssss");
	   session.close();
	   //System.out.println(str);
	
	
	
}



}
