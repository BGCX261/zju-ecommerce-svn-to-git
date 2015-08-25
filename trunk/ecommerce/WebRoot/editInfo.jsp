<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>编辑账户信息</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />

<!--引用JS文件-->
<script type="text/javascript" src="js/makesame.js" charset="utf-8"></script>


</head>

<body>
<!-- header  -->
   <%boolean login=true; %>
   <%@include file="head.jsp" %>
<!-- header end -->


    <!-- 编辑账户信息 同注册 -->
    <div class="layout960" id="register">
    	<h3>编辑账户信息</h3>
        <div class="box-shadow">
        <form action="EditUserInfo.action" enctype="text" method="post">
            <p>
                <span class="reg_attr">新用户名：</span>
                <input type="text" name="username" placeholder="${user.userName }" />
            </p>
            <p>
                <span class="reg_attr">新密码：</span>
                <input type="text" name="password1" />
            </p>
             <div id="alert" ></div>
            <p>
                <span class="reg_attr" >确认密码：</span> 
                <input type="text" name="password2" onchange="makesame()"/>
               
            </p>
            <p>
                <span class="reg_attr">更改收货地址：</span>
                <input type="text" name="addr" placeholder="${user.address }" />
            </p>
            <p>
                <span class="reg_attr">更改支付宝账户：</span>
                <input type="text" name="alipayAccount" placeholder="" />
            </p>
            <p>
                <span class="reg_attr">新邮箱：</span>
                <input type="text" name="email" placeholder="${user.email }" />
            </p>
            <p>
                <span class="reg_attr">更改手机号：</span>
                <input type="text" name="mobile" placeholder="${user.phone}" />
            </p>
            <p>
                <span class="reg_attr">更改移动虚拟网短号：</span>
                <input type="text" name="duanHao" placeholder="" />
            </p>
            <br />
            <input type="submit"  id = "submitreg" name="submitRegister" value="保存更改" />
        </form>
        </div>
    </div>
    <!-- 编辑账户信息 end -->
	
	<!-- 编辑商铺信息 -->
	<div class="layout960" id="register">
    	<h3>编辑商铺信息</h3>
        <div class="box-shadow">
        <form action="" enctype="multipart/form-data" method="post">
            <p>
                <span class="reg_attr">新商铺名：</span>
                <input type="text" name="username" placeholder="此处显示原商铺名" />
            </p>
            <p>
                <span class="reg_attr">新密码：</span>
                <input type="text" name="password1" />
            </p>
            <p>
                <span class="reg_attr">确认密码：</span>
                <input type="text" name="password2" />
            </p>
            <p>
                <span class="reg_attr">更改地址：</span>
                <input type="text" name="addr" placeholder="此处显示原地址" />
            </p>
            <p>
                <span class="reg_attr">更改支付宝账户：</span>
                <input type="text" name="alipayAccount" placeholder="此处显示原支付宝账户名" />
            </p>
            <p>
                <span class="reg_attr">新邮箱：</span>
                <input type="text" name="email" placeholder="此处显示原邮箱地址" />
            </p>
            <p>
                <span class="reg_attr">更改电话：</span>
                <input type="text" name="mobile" placeholder="此处显示原号码" />
            </p>
            <p>
                <span class="reg_attr">更改移动虚拟网短号：</span>
                <input type="text" name="duanHao" placeholder="此处显示原号码" />
            </p>
			<p>
				<span class="reg_attr">更改简介：</span>
				<textarea name="shopIntro" style="width: 400px; height: 55px;" placeholder="此处显示原简介"></textarea>
			</p>
			<p>
				<span class="reg_attr">小图（180*250）：</span>
				<input type="file" name="shop-logo-small" />
			</p>
			<p>
				<span class="reg_attr">大图（600*360）：</span>
				<input type="file" name="shop-logo-title" />
			</p>
            <br />
            <input type="submit" name="submitRegister" value="保存更改" />
        </form>
        </div>
    </div>
	<!-- 编辑商铺信息 end -->
    
    
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