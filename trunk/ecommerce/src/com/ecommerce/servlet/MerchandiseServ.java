package com.ecommerce.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;

import com.ecommerce.hiBean.Comments;
import com.ecommerce.hiBean.Item;
import com.ecommerce.hiDAO.CommentsDAO;
import com.ecommerce.hiDAO.ItemDAO;


public class MerchandiseServ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MerchandiseServ() {
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
		String itemId=request.getParameter("itemId");
		Integer iitemId=Integer.parseInt(itemId);		
		System.out.println(iitemId);
		ItemDAO id = new ItemDAO();		
		Item item = id.findById(iitemId);	
		
		CommentsDAO cdao = new CommentsDAO();
		List<Comments> comments= cdao.findCommentByItemId(iitemId);
		
		HttpSession session = request.getSession();
		session.setAttribute("item", item);	
		session.setAttribute("comments", comments);
		String target="./merchandise.jsp";			
		request.getRequestDispatcher(target).forward(request, response);
	}
	
	
}
