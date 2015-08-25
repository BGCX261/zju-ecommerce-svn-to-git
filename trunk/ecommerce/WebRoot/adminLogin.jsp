<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="" charset="utf-8"></script>

</head>

<body>

<div id="header" class="header">
	<div class="m-head">
    	<div class="layout960">
        	<h1 class="g-logo">
            	<a href="index.jsp"></a>
            </h1>
        </div>
    </div>
    <div class="m-nav">
    	<div class="layout960">

         <form id="adminLogin" name="adminLogin" action="adminLogin.do" method="post">
         	管理账号：<input type="text" name="adminName"/>
 			管理密码：<input type="password" name="adminPwd"/>
 			<input type="submit" value="提交"/>        
         </form>  
            
        </div>
    </div>
</div>
<!-- header end -->

</body>
</html>