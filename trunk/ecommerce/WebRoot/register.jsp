<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>注册新用户</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />

<!--引用JS文件-->
<script type="text/javascript" src="" charset="utf-8"></script>

</head>

<body>
    <!-- header  -->
   <%boolean login=false; %>
   <%@include file="head.jsp" %>
<!-- header end -->


    <!-- 注册 -->
    
    <div class="layout960" id="register">
    	<h3>注册新用户</h3>
        <div class="box-shadow">
        <form action="register.acion"  method="post">
             <p>
                <span class="reg_attr">邮箱：</span>
                <input type="text" name="email" />
            </p>
            <c:if test="${errorinfo != null}">
                     <c:out value="${errorinfo }"/>
           </c:if>
            <p>
                <span class="reg_attr">用户名：</span>
                <input type="text" name="username" />
            </p>
            <p>
                <span class="reg_attr">密码：</span>
                <input type="text" name="password1" />
            </p>
            <p>
                <span class="reg_attr">确认密码：</span>
                <input type="text" name="password2" />
            </p>    
            <p>
                <span class="reg_attr">手机号：</span>
                <input type="text" name="mobile" />
            </p>
            <p>
                <span class="reg_attr">QQ号：</span>
                <input type="text" name="QQ" />
            </p>
            <p>
                <span class="reg_attr">校区：</span>
                  <select name="campus">
                  <option value="玉泉">玉泉</option>
                  <option value="紫金港">紫金港</option>
                  <option value="西溪">西溪</option>
                  <option value="华家池">华家池</option>
                  <option value="之江">之江</option
                  ></select>
            </p>
            <p>
                <span class="reg_attr">收货地址：</span>
                <input type="text" name="addr" />
            </p>
            <p>
                <span class="reg_attr">支付宝账户名：</span>
                <input type="text" name="alipayAccount" />
            </p>
            <br />
            <input type="submit" name="submitRegister" value="注册" />
        </form>
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