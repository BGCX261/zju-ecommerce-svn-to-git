<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ecommerce.hiBean.Item" %>
<%@page import="com.ecommerce.hiBean.Photo"%>
<%@page import="com.ecommerce.hiBean.Users"%>
<%@page import="com.ecommerce.hiBean.Favorites"%>
<%@page import="com.ecommerce.hiDAO.PhotoDAO"%>
<%@page import="com.ecommerce.hiDAO.ItemDAO"%>
<%@page import="com.ecommerce.hiDAO.UsersDAO"%>
<%@page import="com.ecommerce.hiDAO.FavoritesDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>我的收藏</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />
<link rel="stylesheet" type="text/css" href="static/cart.css" />

<!--引用JS文件-->
<script type="text/javascript" src="" charset="utf-8"></script>

</head>

<body>
    <!-- header  -->
   <%boolean login=true; %>
   <%@include file="head.jsp" %>
<!-- header end -->

	<!-- 页面主体 -->
    <div id="container">
	<!-- main -->
    <div id="main">
    	<!--我的收藏（喜欢）-->
        <h3>我的收藏</h3>
	    
        <!--利用“我的订单”结构-->
	<!--<div id="searchOrders">
		<form action="FavoritesSearch.do" method="post">
            <input type="text" name="searchOrders" style="width: 200px;"/>
            <input type="submit" value="在收藏中搜索" style="width: 100px;" />
            </form>
            <span style="float: right;">
                排序：
                <select name="classification">
                    <option value="1">收藏时间倒序</option>
                    <option value="2">收藏时间正序</option>
                    <option value="3">价格由低到高</option>
                    <option value="4">价格由高到低</option>
                </select>
            </span>
        </div>
        -->

		<!--订单列表区-->
		<div id="orders">
			<div class="function">
                
               
            </div>
		<%
            Users user=(Users)session.getAttribute("user");
    	  
    	 	int userid=user.getUserId();
            
             %>
            <div id="ordersTitle">
                <div class="col1">&nbsp;</div>
                <div class="col2">商品</div>
                <div class="col3">价格</div>
                <div class="col4">我要买</div>
                <div class="col5">&nbsp;操作</div>
            </div>
            <form id="form1" name="form1" method="post" action="select.do?userid=<%=userid%>">
	
			<%

				ArrayList items=(ArrayList)session.getAttribute("items");
				ArrayList favorites=(ArrayList)session.getAttribute("favorites");
				
				Item item;
				Favorites favorite;
				//float totalprice=0;
				if(items!=null)
				{
				for(int i=0;i<items.size();i++)
				{
				item=(Item)items.get(i);
  				PhotoDAO pd = new PhotoDAO();
  				String url = ((Photo)pd.findPicUrlByItemId(item)).getPicUrl();
  				UsersDAO owner=new UsersDAO();
  				String owenername=((Users)owner.findById(item.getOwenerId())).getUserName();
  				

 			%>


            <!--1条订单记录的循环体-->
            <div class="orderRecord">
                <div class="col1">
                    &nbsp;
                    <input type="checkbox" name="selectAll" value="<%=item.getItemId() %>" />&nbsp;
                    <img src="<%=url%>" width=80 height=80/>
                </div>
                <div class="col2">
                    <p><a href="Merchandise.do?itemId=<%=item.getItemId()%>"><%=item.getItemName()%></a></p>
                    <p><a href="">卖家：<%=owenername%></a></p>
                    <p>销量：<%=item.getLateSoldNumber()%>件</p>
                    <p>库存：65536件</p>
                </div>
                <div class="col3">￥<%=item.getPrice() %></div>
                <div class="col4"><input type="text" style="width: 30px; text-align: center;" value="1"/>&nbsp;件</div>
                <div class="col5">
                    <p><a href="Buy.do?itemid=<%=item.getItemId()%>&userid=<%=userid%>">购买</a></p>
                    <p><a href="Deletefavorites.do?itemid=<%=item.getItemId()%>&userid=<%=userid%>">删除</a></p>
                </div>
            </div>
            <!--1条订单记录循环体结束-->
            
            <%}
            } 
            %>

          

			<div class="function">
               
                <input type="submit" name="Submit" value="批量购买" style="color:#0000FF;font-family:黑体;font-size:18px"/>
                <input type="submit" name="Submit" value="批量删除" style="color:#0000FF;font-family:黑体;font-size:18px"/>
            </div> </form>
		</div>
    </div>
    <!-- main end -->
    
    <!-- 侧边栏 -->
    <div id="aside">
    	<div class="block">
        	
        </div>
    </div>
    <!-- 侧边栏 end -->
    
    </div>
    <!-- 页面主体 container end -->
    
    
    <div class="clear"></div>
    <!-- 底部 -->
    <div class="footer" id="footer">
    	<a href="index.jsp" class="logo"><img src="static/footer-logo.png" /></a>
        <div class="clear"></div>
        <p class="cp">Copyright ©2012 All rights reserved. 软件工程出品</p>
    </div>
    <!-- 底部 end -->

</body>
</html>