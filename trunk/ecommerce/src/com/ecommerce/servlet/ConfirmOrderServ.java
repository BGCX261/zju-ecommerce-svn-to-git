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
import com.ecommerce.hiDAO.ItemDAO;
import com.ecommerce.hiDAO.OrderItemDAO;
import com.ecommerce.hiDAO.OrdersDAO;
import com.ecommerce.hiDAO.UserRecordDAO;

public class ConfirmOrderServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ConfirmOrderServ() {
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
		String itemId=request.getParameter("shouhuoOrder");
		String[] orderId = itemId.split(";");
		OrdersDAO od = new OrdersDAO();
		Session s= od.getSession();
		for(int i =0;i<orderId.length-1;i++){
			System.out.println("hahaha:"+orderId[i]);
			int id = Integer.parseInt(orderId[i]);
			//µÃµ½order
			Orders tempOrder = (Orders)od.findById(id);
			tempOrder.setOrderStatus("4");
			{
				s.save(tempOrder);
			}
		}	
		Transaction tx = s.beginTransaction();
		tx.commit();
		s.flush();
		s.close();
		String target="./orders.jsp";
		HttpSession session = request.getSession();
		session.removeAttribute("shouhuoOrder");
		session.setAttribute("orderStatus","6");
		request.getRequestDispatcher(target).forward(request, response);
	
	}
}
