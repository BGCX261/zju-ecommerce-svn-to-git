<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ecommerce.hiBean.Store"%>
<%@page import="com.ecommerce.hiBean.Item"%>
<%@page import="com.ecommerce.hiBean.Photo"%>
<%@page import="com.ecommerce.hiDAO.PhotoDAO"%>
<%@page import="com.ecommerce.hiBean.StoreItem"%>
<%@page import="com.ecommerce.hiBean.Users"%>
<%@page import="com.ecommerce.hiBean.UserItem"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>主页</title><!--浏览器窗口标题-->

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
<% 
	Store store= (Store) session.getAttribute("store"); 
	if(store != null){
   	Object[] itemList = store.getStoreItems().toArray();
   	if(itemList.length > 0){	
   		System.out.println("from shop.jsp: the num of items is " +itemList.length);
   		StoreItem first = (StoreItem) itemList[0];
   		Item firstItem = first.getItem();
   		System.out.println("from shop.jsp: the num of items is " + firstItem.getItemName());
   		PhotoDAO pdao = new PhotoDAO();
   		String firstUrl =  ((Photo)pdao.findPicUrlByItemId(firstItem)).getPicUrl();
   		String firstTitle = store.getName();
   	
  %>
	<div id="container">
    	<div class="shop-title">
        	<img src=<%=firstUrl %> title=<%=firstTitle %> width="600" />
            <div id="aside">
            	<div class="block">
                	<h3><%=firstTitle %></h3>
                    <p>好评：92%</p>
                    <p>点评数：36</p>
					<p>地址：青芝坞161号-158号</p>
					<p>电话：0571-88933088</p>
					<span><a target="blank" href="tencent://message/?uin=1842632579&amp;Site=文昌物流&amp;Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:1842632579:10" alt="在线咨询" /></a></span>
                    <p id="shop-intro" style="margin-top: 4px; padding-top: 4px; border-top: 1px dotted #d1d1d1;">这里的菜，完全不按牌理出牌。所有的料理都个性卓然。</p>
            	</div>
            </div>
            <div class="clear"></div>
        </div>
        <!-- shop-title end -->
        <div class="clear"></div>
        
        <div class="goods-wall">
        <% for(int i = 1; i < itemList.length; i++){ 
        			StoreItem st = (StoreItem) itemList[i];
            		Item item = st.getItem();
            		String Url =  ((Photo)pdao.findPicUrlByItemId(item)).getPicUrl();
            		String Title = store.getName();
         %>
        	<!-- 循环体 -->
            <div class="goods fl">
            	<div><span class="goods-func"><a href="editItem.jsp">编辑</a><a href="">下架</a><a href="">删除</a></span></div>
            	<div class="goods-pic">
                	<a href="merchandise.jsp"><img src=<%=Url %> title=<%=Title %> width="210"/></a>
                </div>
                <div class="goods-stat">
                	<span class="like-num">喜欢: <em class="like-count">98</em></span>
                    <span class="fr">价格：16</span>
                </div>
                <div class="goods-intro">
                	<span>装在试管里滴~
                    </span>
                </div>
            </div>
            <%} %>
            <!-- 循环体 end -->
            <%session.removeAttribute("store"); %>
            <%} }%>
            
            <!-- 用户商家 -->
            <% 
            System.out.println("from shop.jsp: the url and tile is: ");
        		Users u= (Users) session.getAttribute("seller"); 
        		String QQ = u.getDouban();
        		String address = u.getAddress();
            	if(u != null){	
            		Object[] itemList1 = u.getUserItems().toArray();
            		if(itemList1.length > 0 ){
            		UserItem first = (UserItem) itemList1[0];
            		Item firstItem = first.getItem();
            		PhotoDAO pdao = new PhotoDAO();
            		String firstUrl =  ((Photo)pdao.findPicUrlByItemId(firstItem)).getPicUrl();
            		String firstTitle = u.getUserName();
            		System.out.println("from shop.jsp: the url and tile is: "+ firstUrl + "  "+firstTitle);
            %>
	<div id="container">`
    	<div class="shop-title">
        	<img src=<%=firstUrl %> title=<%=firstTitle %> width="600" />
            <div id="aside">
            	<div class="block">
                	<h3><%=firstTitle %></h3>
                    <p>好评：92%</p>
                    <p>点评数：36</p>
					<p>地址：青芝坞161号-158号</p>
					<p>电话：0571-88933088</p>
					<p><span><a target="blank" href="tencent://message/?uin=<%=QQ %>&amp;Site=<%=address %>&amp;Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:<%=QQ %>:10" alt="在线咨询" /></a></span></p>
                    <p id="shop-intro" style="margin-top: 4px; padding-top: 4px; border-top: 1px dotted #d1d1d1;">这里的菜，完全不按牌理出牌。所有的料理都个性卓然。</p>
            	</div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
        <div class="goods-wall">
        <% for(int i = 1; i < itemList1.length; i++){ 
        			UserItem st = (UserItem) itemList1[i];
            		Item item = st.getItem();
            		String Url =  ((Photo)pdao.findPicUrlByItemId(item)).getPicUrl();
            		String Title = u.getUserName();
         %>
        	<!-- 循环体 -->
            <div class="goods fl">
            	<div><span class="goods-func"><a href="editItem.jsp">编辑</a><a href="">上架</a><a href="">删除</a></span></div>
            	<div class="goods-pic">
                	<a href="merchandise.jsp"><img src=<%=Url %> title=<%=Title %> width="210"/></a>
                </div>
                <div class="goods-stat">
                	<span class="like-num">喜欢: <em class="like-count">98</em></span>
                    <span class="fr">价格：16</span>
                </div>
                <div class="goods-intro">
                	<span>装在试管里滴~
                    </span>
                </div>
            </div>
            <%} %>
            <!-- 循环体 end -->
            <%}}%>
            <%session.removeAttribute("seller");  %>
            
        </div>
        <!-- goods-wall end -->
        
        <!-- 若显示商品管理 -->
        <div class="clear" style="border-bottom: 1px dotted #d1d1d1;"></div>
		<h3>未上架商品</h3>
		<div class="goods-wall" id="off-shelf">
			<!-- 循环体 -->
            <div class="goods fl">
            	<div><span class="goods-func"><a href="editItem.jsp">编辑</a><a href="">上架</a><a href="">删除</a></span></div>
            	<div class="goods-pic">
                	<a href="merchandise.html"><img src="static/米浆.jpg" title="米浆" width="210"/></a>
                </div>
                <div class="goods-stat">
                	<span class="like-num">喜欢: <em class="like-count">98</em></span>
                    <span class="fr">价格：16</span>
                </div>
                <div class="goods-intro">
                	<span>装在试管里滴~
                    </span>
                </div>
            </div>
            <!-- 循环体 end -->
            
		</div>
		<!-- 商品管理 end -->
		
    </div>
	
    
    
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