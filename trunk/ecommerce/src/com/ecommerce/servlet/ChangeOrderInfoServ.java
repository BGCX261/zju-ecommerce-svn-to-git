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
import org.hibernate.criterion.Order;

import com.ecommerce.hiBean.Item;
import com.ecommerce.hiBean.OrderItem;
import com.ecommerce.hiBean.Orders;
import com.ecommerce.hiBean.UserRecord;
import com.ecommerce.hiBean.Users;
import com.ecommerce.hiDAO.ItemDAO;
import com.ecommerce.hiDAO.OrderItemDAO;
import com.ecommerce.hiDAO.OrdersDAO;
import com.ecommerce.hiDAO.UserRecordDAO;
import com.ecommerce.hiDAO.UsersDAO;

public class ChangeOrderInfoServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ChangeOrderInfoServ() {
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

		String phoneString = request.getParameter("phone");
		System.out.println("tag1:"+phoneString);
		String ChangeOrderInfo = new String(request.getParameter("ChangeOrderInfo").getBytes("ISO-8859-1"),"utf-8");
		Users users = (Users)request.getSession().getAttribute("user");
		System.out.println("the user id is:"+users.getUserId());
		
		UsersDAO ud = new UsersDAO();
		Session s= ud.getSession();
		{
			users.setPhone(phoneString);
			users.setAddress(ChangeOrderInfo);
			s.merge(users);
		}	
		Transaction tx = s.beginTransaction();
		tx.commit();
		s.flush();
		s.close();
		
		String target="./check.jsp";
		HttpSession session = request.getSession();
		request.getRequestDispatcher(target).forward(request, response);
	
	}
}
