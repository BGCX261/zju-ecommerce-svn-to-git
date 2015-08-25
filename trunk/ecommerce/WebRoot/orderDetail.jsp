<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>订单详情</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />

<!--引用JS文件-->
<script type="text/javascript" src="" charset="utf-8"></script>

</head>

<body>
    <!-- header  -->
   <%boolean login=true; %>
   <%@include file="head.jsp" %>
<!-- header end -->


    <!-- 注册 -->
    <div class="layout960" id="register">
    	<!--订单详情-->
        <h3>订单详情</h3>
        <div id="orderDetailUp">
            <p>订单编号：201201011234</p>
            <p>订单生成时间：2012-03-06 19:09</p>
            <p>支付宝交易号：</p>
            <p>付款时间：</p>
            <p>订单状态：</p>
            <p>物流信息：</p>
        </div>
		
		<div id="orderDetailDown">
            <div style="border-bottom: 1px solid white; padding: 4px 10px;">
                <p>
                    <strong>收货地址：</strong>呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵
                </p>
                <p>
                    <strong>卖家留言：</strong>呵呵呵呵呵
                </p>
            </div>
            <div style="border-bottom: 1px solid white; padding: 4px 10px;">
                <p>
                    <strong>卖家信息：</strong>CAD&CG实验室
                </p>
            </div>
            <div style="padding: 4px 10px;">
                <p>
                    <strong>商品信息：</strong>OpenGL Programming Guide (7th)
                </p>
            </div>
        </div>
    </div>
    <!-- 注册 end -->
    
    
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