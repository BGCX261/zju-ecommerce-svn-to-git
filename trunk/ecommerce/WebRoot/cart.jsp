<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ecommerce.hiBean.Item" %>
<%@page import="com.ecommerce.hiBean.Photo"%>
<%@page import="com.ecommerce.hiBean.Users"%>
<%@page import="com.ecommerce.hiDAO.PhotoDAO"%>
<%@page import="com.ecommerce.hiDAO.ItemDAO"%>
<%@page import="com.ecommerce.hiDAO.UsersDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>我的购物车</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />
<link rel="stylesheet" type="text/css" href="static/cart.css" />

<!--引用JS文件-->
<script type="text/javascript" src="" charset="utf-8"></script>

</head>

<body>
    <!-- header  -->
   <%@include file="head.jsp" %>
<!-- header end -->



	<!-- 页面主体 -->
    <div id="container">
    <div id="main">
    <div class="cart-item-list" id="cart-active-items">
					<h3>我的购物车</h3>
					<!--小标题： 商品		价格		数量 -->
					<div class="cart-item-head">
						<table >
						<colgroup>
							<col width="800" />
							<col width="100" />
							<col width="100" />
						</colgroup>

							<tr class="">
								<td class="c2 txtsmall drkgry txtleft">现在购买：</td>
								<td class="c3 txtsmall drkgry txtright">价格</td>
								<td class="c4 txtsmall drkgry txtctr">数量</td>
							</tr>
						</table>
					</div>
					<!--商品列表 -->
					
					<div class="item-list">
			<%
            Users user2=(Users)session.getAttribute("user");
    	  
    	 	int userid2=user2.getUserId();
            
             %>
					<%

				ArrayList items=(ArrayList)session.getAttribute("items");
				Item item;
				float totalprice=0;
				if(items!=null)
				{
				for(int i=0;i<items.size();i++)
				{
				item=(Item)items.get(i);
  				PhotoDAO pd = new PhotoDAO();
  				String url = ((Photo)pd.findPicUrlByItemId(item)).getPicUrl();
  				UsersDAO owner=new UsersDAO();
  				String owenername=((Users)owner.findById(item.getOwenerId())).getUserName();
  				totalprice=totalprice+item.getPrice();
				


 %>
					
					
					
						<!--这里的div 需不需要商品数据相关的自定义标签？ -->
						<div class="cart-item">
							<table >
						<colgroup>
							<col width="120" />
							<col width="680" />
							<col width="100" />
							<col width="100" />
						</colgroup>

								<tr>
									<!--商品图片： -->
									<td class="c1 textleft" valign="top"><a href="Merchandise.do?itemId=<%=item.getItemId()%> ">
										<img src="<%=url %>" width="100" height="100" alt="<%=item.getItemName() %>" />
										</a></td>
									<!--商品文字说明： -->

									<td class="c2 txtleft txtnormal" valign="top"><p class="title"> <a href="Merchandise.do?itemId=<%=item.getItemId()%>"><%=item.getItemName() %></a> <span class="creator"> 作者1；</span> <span class="binding"><b>平装</b></span> </p>
										<p class="scarcity red">此商品还剩一件，欲购从速</p>
										<p class="availability green"></p>
										<p class="merchant gry"> 卖家： <a href="9527.htm"><%=owenername%></a> </p>
									    <p class="buttons require-js"> <a href="Deleteshoppingcart.do?itemid=<%=item.getItemId()%>&userid=<%=userid2%>">删除</a> &nbsp;·&nbsp; 
									<!--商品价格 -->
									<td class="c3 txtright txtnormal" valign="top"><p class="ourprice"> <%=item.getPrice() %></p>
										<p class="yousave"> <span class="txtsmall">为您节省：</span> <br/>
											<span class="txtnormal savings"> ￥3.00&nbsp;(33%)</span> </p></td>
									<!--购买数量：input框 -->
									<td class="c4 txtctr txtnormal" valign="top"><p class="quantity">
											<input class="txtctr ime-disabled" type="text" autocomplete="off" value="1" maxlength="3" size="3" name="quantity.1001" />
										</p></td>

							</table>
						</div>
						
						
						<%}} %>
					</div>
	

					<!--商品价格小计 -->
					<div id="cart-subtotal" class="subtotal txtlarge txtright">
					合计：
					<span class="ourprice"> ￥<%=totalprice %></span>
					</div>
					<!--小计上面的虚线分割线 page属性作用不明确-->
					<div class="cart-item-pagination" page="0">
					</div>
				</div>
				
    </div>

    	
    
    
    <!-- main end -->
    
    <!-- 侧边栏 -->
    <div id="aside">
    	<div class="block">
        	<!--张琛：右侧结算框---------------------------------- -->
			<div class="checkout-box">
<!--				<span class="round-box-tl"></span>
				<span class="round-box-tr"></span>
				<span class="round-box-bl"></span>
				<span class="round-box-br"></span>
 -->				
				<form id="checkoutForm" action="9527.htm" method="post">
					<h3 class="txtlarge txtctr">
					结算(<%=items.size()%>件商品):
					<span class="ourprice">￥<%=totalprice %></span>
					</h3>
					<p>
						<a href="check.htm">
						<img src="static/jiesuan.gif" width="135" height="27" alt="jiesuan.gif" />
						</a>
					</p>
					<p>
						或
					</p>
					<p>
						<a href="Checkorder.do?userid=<%=userid2%>">
						<img src="static/oneclick.gif" width="137" height="27" alt="oneclick.gif" />
						</a>
					</p>
					<p>发货至</p>
					<p>
						<select class="tiny" name="myAddress">
							<option> 暂无地址</option>
						</select>
					</p>
					
					
				</form>
			</div>
        </div>
    </div>
    </div>
    
    </div>
    
    <div class="clear"></div>
    <!-- 底部 -->
    <div class="footer" id="footer">
    	<a href="" class="logo"><img src="static/footer-logo.png" /></a>
        <div class="clear"></div>
        <p class="cp">Copyright ©2012 All rights reserved. 软件工程出品</p>
    </div>
    <!-- 底部 end -->

</body>
</html>