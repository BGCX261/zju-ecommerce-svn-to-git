package com.ecommerce.servlet;




import java.awt.List;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.ecommerce.db.HibernateSessionFactory;
import com.ecommerce.hiBean.Item;
import com.ecommerce.hiBean.OrderItem;
import com.ecommerce.hiBean.OrderItemId;
import com.ecommerce.hiBean.Orders;
import com.ecommerce.hiBean.UserRecord;
import com.ecommerce.hiBean.UserRecordId;
import com.ecommerce.hiBean.Users;
import com.ecommerce.hiDAO.ItemDAO;
import com.ecommerce.hiDAO.OrderItemDAO;
import com.ecommerce.hiDAO.OrdersDAO;
import com.ecommerce.hiDAO.UserRecordDAO;
import com.ecommerce.hiDAO.UsersDAO;

public class Ordergener extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Ordergener() {
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

		ArrayList itemList = (ArrayList<Item>)request.getSession().getAttribute("items");
		Users user = (Users) request.getSession().getAttribute("user");
		//需要写三个表，itme-order表，user-record表，和order表
		//先写order表
		Orders odd ;
		Session session1 = HibernateSessionFactory.getSession();
		Transaction tx = session1.beginTransaction();
		{
			Orders order = new Orders();
			float money=0;
			for(int i=0;i<itemList.size();i++) money+=((Item)itemList.get(i)).getPrice();
			order.setMoney(money);
			Timestamp date =new Timestamp(System.currentTimeMillis());
			order.setSubmintTime(date);
			order.setOrderStatus("2");
			order.setUsers(user);
			
			session1.save(order);
			
			OrdersDAO temp = new OrdersDAO();
			odd = temp.findByTimeStamp(date);
			System.out.print("tag1111:"+odd.getSubmintTime());
		}
		//item order表走起,odd是订单
		{		
			for(int i=0;i<itemList.size();i++){
				Item it = (Item)itemList.get(i);
				OrderItem oi = new OrderItem();
				oi.setItem(it);
				oi.setOrders(odd);
				OrderItemId temp= new OrderItemId(odd.getOrderId(),it.getItemId(),1);
				oi.setId(temp);
				session1.save(oi);
			}
		}
		{	
			UserRecord ur = new UserRecord();
			ur.setOrders(odd);
			ur.setUsers(user);
			UserRecordId temp = new UserRecordId(user.getUserId(),0,odd.getOrderId());
			ur.setId(temp);
			session1.save(ur);
		}
		
		tx.commit();
		session1.flush();
		session1.close();
		
		String target="./orders.jsp";
		HttpSession session = request.getSession();
		session.removeAttribute("items");
		session.setAttribute("orderStatus","6");
		request.getRequestDispatcher(target).forward(request, response);
	
	}
}
