<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ecommerce.hiBean.Item" %>
<%@page import="com.ecommerce.hiDAO.PhotoDAO"%>
<%@page import="com.ecommerce.hiBean.Photo"%>
<%@page import="com.ecommerce.hiBean.Store"%>
<%@page import="javax.mail.*"%>
<%@page import="com.ecommerce.hiBean.Users"%>
<%@page import="com.ecommerce.hiBean.StoreItem"%>
<%@page import="com.ecommerce.hiBean.UserItem"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>首页 - 亲亲吾爱</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />
<link rel="stylesheet" type="text/css" href="static/cart.css" />

<!--引用JS文件-->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" ></script>
<script type="text/javascript" src="static/jquery-1.7.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="static/frame.js" charset="utf-8"></script>

<script type="text/javascript" charset="utf-8">
	$(function () {
        $('a[name="delete"]').bind('click', function () {
			//用弹出对话框测试是否选中了此订单的订单号，成功后可删除。
			alert( $(".col2 p a", $(this).parent().parent().parent() ).eq(0).text() );
			
            $.post('/XXX.jsp', {							//
                ID: $(".col2 p a", $(this).parent().parent().parent() ).eq(0).text(),
                messageID: $(this).attr("id"),
                text: $(this).prev().val()
            }, function (data) {	//回调函数
            });
            return false;
        });
		
		$('a[name="tuikuan"]').bind('click', function () {
            $.post('/XXX.jsp', {							//
                ID: $(this).parent().parent().prev().attr("id"),
                messageID: $(this).attr("id"),
                text: $(this).prev().val()
            }, function (data) {	//回调函数
            });
            return false;
        });
		
		$('a[name="tousu"]').bind('click', function () {
            $.post('/XXX.jsp', {							//
                ID: $(this).parent().parent().prev().attr("id"),
                messageID: $(this).attr("id"),
                text: $(this).prev().val()
            }, function (data) {	//回调函数
            });
            return false;
        });
    });
</script>
</head>

<body>
    <!-- header  -->
   <%boolean login=false; %>
   <%@include file="head.jsp" %>

	<!-- 最新... -->
    <div class="latest box-shadow">
    	<div class="hd">
        	<h3>最新...</h3>
        </div>
        <ul>
        	<!-- 循环体 -->
        	<% List<Item> items=(List<Item>)session.getAttribute("latestItems"); %>
        	<%
        		if(items != null)
        		for(int i=0;i<items.size();i++){
        			PhotoDAO p = new PhotoDAO();
					Photo  pp= (Photo)p.findPicUrlByItemId(items.get(i));
        			String picUrl = pp.getPicUrl();
        			String title = ((Item)items.get(i)).getItemName();
        			String owner = ((Item)items.get(i)).getTag4();
        			String target = null;
        			Object[] tt= null;
        			Store s = null;
        			Users u = null;
        			Integer id = null;
        	%>	
        	<li>
            	<div class="latest-item"><a href="Merchandise.do?itemId=<%=items.get(i).getItemId() %>"><img src=<%= picUrl %> width="120" height="120" title=<%= title %> /></a></div>
                <div class="latest-user">
                	<!-- <a href=""><img class="user-head" src="" /></a> -->
                	<%if (items.get(i).getSellerStatus() == false ){
                		tt = items.get(i).getStoreItems().toArray();
                		s = ((StoreItem)(tt[0])).getStore();
                		target = "StoreView.do?storeId=";
                		id = s.getStoreId();
                	}
                	else {
                		tt = items.get(i).getUserItems().toArray();
                		u = ((UserItem)(tt[0])).getUsers();
                		target = "SellerView.do?sellerId=";
                		id = u.getUserId();
                	}%>
                	<span class="name ofh"><a href="<%=target %><%=id%>"><%=owner %></a></span>
                    <span class="like"><img src="static/like-icon.png" /></span>
                </div>
            </li>
            <%} %>
            <!-- 循环体结束 -->
        </ul>
    </div>
    <!-- “最新...” end -->
    
    <!-- 商铺区 -->
    <div class="shop">
    	<div class="hd">
        	<h3>商铺<span class="more"><a href="">更多</a></span></h3>
        </div>
        <div class="clear"></div>
        <ul class="shop-list">
        	<!-- 循环体 -->
        	<% List<Store> stores=(List<Store>)session.getAttribute("hotestStores"); %>
        	<%	if(stores != null)
        		for(int i=0;i<stores.size();i++){
        		String Url = ((Store)stores.get(i)).getUrl();
        		String title = ((Store)stores.get(i)).getName();
        	%>
        	<li><a href="StoreView.do?storeId=<%=stores.get(i).getStoreId() %>" class="small"><img src=<%=Url %> title=<%=title %> width="180"/></a></li>
             <%} %>
            <!-- 循环体结束 -->
        </ul>
    </div>
    <!-- 商铺区 end -->
    
    
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