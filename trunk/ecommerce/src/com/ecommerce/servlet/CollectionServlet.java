package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.hiBean.CartItem;
import com.ecommerce.hiBean.Item;
import com.ecommerce.hiBean.Photo;
import com.ecommerce.hiDAO.ItemDAO;
import com.ecommerce.hiDAO.PhotoDAO;


public class CollectionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CollectionServlet() {
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
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");//处理中文乱码
		PrintWriter out = response.getWriter();
		String path = request.getParameter("path");
		HttpSession session = request.getSession();
		//ConvertUtil cutils = new ConvertUtil();
		List<CartItem> items = null;
		ItemDAO itemdao = new ItemDAO();
		//PhotoDAO pd = new PhotoDAO();
		String tourl = "";
		//添加商品到收藏夹
		if ("addItemToCollection".equals(path)) {
			
			String itemId = request.getParameter("itemId");

			if (session.getAttribute("collectionitems") == null) {
				items = new ArrayList<CartItem>();
			} else {
				items =  (List<CartItem>) session.getAttribute("collectionitems");
			}

			Item item = (Item) itemdao.findById(Integer.parseInt(itemId));
			Iterator iter = items.iterator();
			
			//Photo photo = pd.findPicUrlByItemId(item);
			//String picUrl = photo.getPicUrl();
			boolean exist = false;
			
			while(iter.hasNext()){
				CartItem ci = (CartItem) iter.next();
				if(ci.getItem().getItemId().equals(item.getItemId()))
					{
					ci.setQuantity(ci.getQuantity()+1);
					exist = true;
					break;
					}
			}
			if(!exist)
			{items.add(new CartItem(item,1,null));}
			session.setAttribute("collectionitems", items);
			//session.setAttribute("itemnum", items.size());
			
			tourl = "collection.jsp";
			}
		//从购物车中删除商品
		else if ("removeItemFromCollection".equals(path)) {
			String itemId = request.getParameter("itemId");
			if (session.getAttribute("collectionitems") == null) {
				items = new ArrayList<CartItem>();
			} else {
				items =  (List<CartItem>) session.getAttribute("collectionitems");
			}

			for(int i =0;i<items.size();i++)
			{
				if(items.get(i).getItem().getItemId().equals(Integer.parseInt(itemId)))
				{
					items.remove(i);break;
				}
			}

			//session.setAttribute("collectionitems", items);
			session.setAttribute("itemnum", items.size());

			tourl = "collection.jsp";
		} 
		//删除收藏夹中的所有商品
		else if ("CleanItemFromCollection".equals(path)) {
			items = new ArrayList<CartItem>();
			session.setAttribute("collectionitems", items);
			//session.setAttribute("itemnum", items.size());

			tourl = "collection.jsp";
		}
		response.sendRedirect(tourl);
	}


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
