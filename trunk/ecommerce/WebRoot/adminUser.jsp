<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ecommerce.hiBean.Users" %>
<%@page import="java.util.ArrayList" %>
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
    <div>
    	<div class="layout960">
	<% List<Users> users = (List<Users>)session.getAttribute("users"); %>
			   <p><font color="red" size=20">用户列表：</font></p>
			 <table border="1" caption="用户列表：">                
                    <tbody><tr class="rowHeader">                                     
                        <td class="userName" width="100">用户名</td>
                        <td class="email" width="200">邮箱</td>                        
                        <td class="address" width="100">地址</td>                                                
                    </tr>         
                    <% 
                    for(int i=0;i<users.size();i++){
                    	Users user = users.get(i); %>
                   		<tr class='rowOdd'>
                        <td ><font color="blue"><%= user.getUserName()%></font></td>
						<td ><font color="blue"><%= user.getEmail()%></font></td>
                    	<td ><font color="blue"><%= user.getAddress()%></font></td>
                    	</tr>
                    <%}%>                    
                </tbody>
                </table>
               <div>
				<hr style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=#987cb9 SIZE=3/>
        		<form method="post" action="DeleteUser.do">
        		<table>
        			<tr><td><a href="./editInfo.jsp">编辑帐户</a></td></tr>
        			<tr><td>删除用户<td><input type="text" name="deleteEmail"/></td><td><input type="submit" text="确定"/></td></tr>
        		</table>
        		</form>
        	</div>	
        </div>
        
    </div>
</div>
<!-- header end -->

</body>
</html>
