package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.hiDAO.*;
import com.ecommerce.hiBean.*;

public class changeCondSearchServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public changeCondSearchServ() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String Cond=request.getParameter("searchCond");
		String itemName = (String)session.getAttribute("searchItemName");
		String orderCondString = "itemId";
		if(Cond == "all")
			orderCondString = "itemId";
		else if(Cond == "price")
			orderCondString = "price";
		else if(Cond == "sales")
			orderCondString = "lateSoldNumber";
		else if(Cond == "stockTime")
			orderCondString = "shelveTime";
		else if(Cond == "trust")
			orderCondString = "itemPoint";
		
		System.out.println(orderCondString+itemName);
		ItemDAO query=new ItemDAO();
		ArrayList items = new ArrayList();
		items = (ArrayList)query.findByNameAlikeCondition(itemName,orderCondString);
		
		for(int i=0; i<items.size();i++){
			Item t = (Item)items.get(i);
			System.out.println(t.getItemName()+t.getPrice());
		}
		/*Integer itemCount = (Integer)session.getAttribute("itemCount");
		Integer itemID;
		ArrayList<Integer>itemsID = new ArrayList<Integer>();
		for(int i=0;i<itemCount;i++){
			String itemkey = "item"+i;
			itemID = (Integer)session.getAttribute(itemkey);
			System.out.println(itemID);
			itemsID.add(itemID);			
		}
		ItemDAO query=new ItemDAO();
		ArrayList sortItems = new ArrayList();
		sortItems = (ArrayList)query.SortItem(itemsID, Cond);*/
		String target="";		
		
		target="./merchandises.jsp";
		HttpSession session2 = request.getSession();
		session2.setAttribute("items",items);
	
	
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