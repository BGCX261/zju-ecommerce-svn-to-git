<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ecommerce.hiBean.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ecommerce.hiBean.Users"%>
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
        	<ul class="channel">
            	<li class="first"><a class="on" href="index.jsp">首页</a></li>
                <li><a href="ShowBookServ.do?type=book">图书</a></li>
                <li><a href="ShowBookServ.do?type=digital">数码</a></li>
                <li><a href="ShowBookServ.do?type=food">美食</a></li>
                <li><a href="ShowBookServ.do?type=cloth">服装</a></li>
            </ul>

            <a class="btn-pink fr" href="adminLogin.jsp">管理员登陆</a>

			<!-- 已登录 -->
			<c:choose>
			<c:when test="${user!=null }">

			    <%Users user=(Users)session.getAttribute("user"); %>
            	<div class="btn-pink fr">Hello <%=user.getUserName()%></div>
            
            	
			 <%
    	 	int userid=user.getUserId();
             %>
             <a class="btn-pink fr" href="Showfavorites.do?userid=<%=userid%>">收藏夹</a>
            <a class="btn-green fr" href="Showcart.do?userid=<%=userid%>">购物车</a>
           <div class="regLogin fr">

            	<a href="ShowOrderServ.do?orderStatus=6">我的订单</a>
            	<!-- 待确认收货(0)待发货(1)待付款(2)待评价(3)已完成(4)垃圾箱（5）全部(6)-->

                <span class="vLine5">|</span>
            	<a href="javascript:;" id="login_popup_show" onclick="document.getElementById('login_popup').style.display='block';document.getElementById('login_popup_hide').style.display='inline';document.getElementById('login_popup_show').style.display='none';" style="display:inline;">我的账户</a>
                <a href="javascript:;" id="login_popup_hide" onclick="document.getElementById('login_popup').style.display='none';document.getElementById('login_popup_hide').style.display='none';document.getElementById('login_popup_show').style.display='inline';" style="display:none;">我的账户</a>
                <div id="login_popup" style="display: none;">
                	<div id="login_form">
						<p class="textbox">
							<a href="myAccount.jsp" class="btn-blue">管理账户信息</a>		
						  <a href="addItem.jsp" class="btn-blue fl">发布商品</a>		
						</p>
						<!--  <div class="clear"></div>-->
						<p class="textbox">
 							<a href="shop.jsp" class="btn-blue">管理个人主页</a>		
 							  <a href="shop.jsp" class="btn-blue fl">管理商铺主页</a>					
 															
						</p>
	
						<p class="textbox">
							<a class="btn-pink fr" href="Logout.action">注销</a>
						</p>	
				
					</div>
                </div>
            </div>
			<!-- 已登录 regLogin end -->
			</c:when>
			<c:otherwise>
			<!-- 未登录-->

            <div class="regLogin fr">
            	<a href="register.jsp">注册</a>
                <span class="vLine5">|</span>
            	<a href="javascript:;" id="login_popup_show" onclick="document.getElementById('login_popup').style.display='block';document.getElementById('login_popup_hide').style.display='inline';document.getElementById('login_popup_show').style.display='none';" style="display:inline;">登录</a>
                <a href="javascript:;" id="login_popup_hide" onclick="document.getElementById('login_popup').style.display='none';document.getElementById('login_popup_hide').style.display='none';document.getElementById('login_popup_show').style.display='inline';" style="display:none;">登录</a>
                <div id="login_popup" style="display: none;">
                	<div id="login_form">
						<form action="Login.action" method="post" id="unlogin_form">
							<p class="textbox">
								<label for="log_email" id="label_email">E-mail 地址</label>
								<label for="log_shangpuming" style="display:none;" id="label_shangpuming">商铺名</label>
								<input type="text" tabindex="1" title="E-mail 地址" value="" name="email" class="fr" id="log_email" spellcheck="false">
							</p>
							<p class="textbox">
								<label for="log_password">密 码</label>
								<input type="password" tabindex="2" title="密码" value="" name="password" class="fr" id="log_password" maxlength="16">
							</p>
							<p class="remember">
                            	
                            	<span><input type="radio" id="user_type_geren" name="user_type" value="1" checked="checked"><label>个人</label></span>
                                <span><input type="radio" id="user_type_shangpu" name="user_type" value="0" checked="false"><label>商铺</label></span>
								<input type="submit" class="btn-pink fr" tabindex="4" value="登 录" onfocus="this.blur();" id="log_submit" name="submit">
							</p>
						</form>
					</div>
                </div>
            </div>
			<!-- 未登录 regLogin end -->
           </c:otherwise>
           </c:choose>
            <div id="search" class="search">
            	<span>
                	<form id="form-search" enctype="text" action="ItemSearch.do" method="post">
            			<select name="classification">
                			<option value="0">全部</option>
                    		<option value="1">图书</option>
                    		<option value="2">数码</option>
                    		<option value="3">美食</option>
                    		<option value="4">服装</option>
               	 		</select>
                        <input type="text" name="keyword" placeholder="搜宝贝，搜店铺"  />
        				<input class="btn-pink" type="submit" value="搜索" />
                    </form>
                </span>
            </div>
            
        </div>
    </div>
</div>
<!-- header end -->
