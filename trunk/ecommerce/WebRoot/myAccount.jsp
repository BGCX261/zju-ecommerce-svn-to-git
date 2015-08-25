<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ecommerce.hiBean.*"%>
<%@page import="com.ecommerce.bussiness.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>我的账户信息</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />

<!--引用JS文件-->
<script type="text/javascript" src="" charset="utf-8"></script>

</head>

<body>
    <!-- header  -->
   <%@include file="head.jsp" %>
<!-- header end -->

    <!-- 账户信息 同注册 -->
    <div class="layout960" id="register">
    	<h3>账户信息</h3>
        <div class="box-shadow">

        <%
        Users us=(Users)session.getAttribute("user");       
         %>
         <%if(us!=null){ %>
        	<p>用户名：<span><%=us.getUserName() %></span></p>
            <p>收货地址：<span><%=us.getAddress() %></span></p>
			<p>支付宝账户名：<span><%=us.getZhifubaoCard() %></span></p>
            <p>内网邮箱：<span><%=us.getEmail() %></span></p>
            <p>手机号：<span><%=us.getPhone() %></span></p>
            <p>QQ号：<span><%=us.getDouban() %></span></p> 
            <%} %>
			<br />
            <span class="btn-edit"><a href="editInfo.jsp">编辑</a></span>
        </div>
    </div>
    <!-- 账户信息 end -->
	
	    <!-- 交易记录 -->
    <div class="layout960" id="register">
    	<h3>交易记录</h3>
        <div class="box-shadow">

        <%
              List<UserRecord> record=UserBussiness.queryOrderRecord(us.getUserId());
         %>
         <tr class="">
			<td class="c2 txtsmall drkgry txtleft">商品名称</td>
			<td class="c3 txtsmall drkgry txtright">价格</td>
			<td class="c3 txtsmall drkgry txtright">购物时间</td>
			<td class="c4 txtsmall drkgry txtctr">购物者</td>
		</tr>
		<% for(int i=0 ; i < record.size() ; i++) {
		         Orders it=record.get(i).getOrders();
		         Users u=record.get(i).getUsers();
		        
		%>
		 <tr class="">
			<td class="c2 txtsmall drkgry txtleft"><%= it.getOrderStatus()%></td>
			<td class="c3 txtsmall drkgry txtright"><%=it.getMoney() %></td>
			<td class="c3 txtsmall drkgry txtright"><%=it.getSuccessTime() %></td>
			<td class="c4 txtsmall drkgry txtctr"><%=u.getUserName()%></td>
		</tr>
		
		<%} %>
        </div>
    </div>
    <!-- 交易记录 -->
	
	    <!-- 评价记录 -->
    <div class="layout960" id="register">
    	<h3>交易记录</h3>
        <div class="box-shadow">

        <%
              List<Comments> commentList=UserBussiness.queryCommentRecord(us.getUserId());
         %>
        
        </div>
    </div>
   
	
	<!-- 若显示商铺信息 -->
	<div class="layout960" id="register">
    	<h3>热意餐厅（显示商铺名）</h3>
		
        <div class="box-shadow">
            <p>地址：<span>青芝坞161号-158号</span></p>
			<p>支付宝账户名：<span>test@gmail.com</span>
            <p>邮箱：<span>stu@zju.edu.cn</span></p>
            <p>电话：<span>18608610086</span></p>
			<p>移动虚拟网短号：<span>如果有的话</span></p>
            <p>简介：<span>这里的菜，完全不按牌理出牌。所有的料理都个性卓然。</span></p>
			<br />
			<p>小图：
				<img src="static/热意餐厅_180X250.jpg" width="180" id="shop-logo-small" />
			</p>
			<p>大图：
				<img src="static/热意餐厅_640x380.jpg" width="600" id="shop-logo-title" />
			</p>
			<br />

            <span class="btn-edit"><a href="editInfo.jsp">编辑</a></span>
        </div>
    </div>
	<!-- 商铺信息 end -->
    
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