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
<div id="header" class="header">
	<div class="m-head">
    	<div class="layout960">
        	<h1 class="g-logo">
            	<a href="index.html"></a>
            </h1>
        </div>
    </div>
    <div class="m-nav">
    	<div class="layout960">
        	<ul class="channel">
            	<li class="first"><a class="on" href="index.html">首页</a></li>
                <li><a href="merchandises.html">图书</a></li>
                <li><a href="merchandises.html">数码</a></li>
                <li><a href="merchandises.html">美食</a></li>
                <li><a href="merchandises.html">服装</a></li>
            </ul>
            
            <a class="btn-pink fr" href="favorites.html">收藏夹</a>
            <a class="btn-green fr" href="cart.html">购物车(0)</a>
            <!-- 已登录 -->
			<div class="regLogin fr">
            	<a href="orders.html">我的订单</a>
                <span class="vLine5">|</span>
            	<a href="javascript:;" id="login_popup_show" onclick="document.getElementById('login_popup').style.display='block';document.getElementById('login_popup_hide').style.display='inline';document.getElementById('login_popup_show').style.display='none';" style="display:inline;">我的账户</a>
                <a href="javascript:;" id="login_popup_hide" onclick="document.getElementById('login_popup').style.display='none';document.getElementById('login_popup_hide').style.display='none';document.getElementById('login_popup_show').style.display='inline';" style="display:none;">我的账户</a>
                <div id="login_popup" style="display: none;">
                	<div id="login_form">
						<p class="textbox">
							<a href="myAccount.html" class="btn-blue">编辑账户信息</a>
							<a class="btn-pink fr" href="index.html">注销</a>
						</p>
						<p class="textbox">
							<a href="shop.html" class="btn-blue">管理个人主页</a>
							
						</p>
						<p class="textbox">
							<a href="addItem.html" class="btn-blue">发布商品</a>
						</p>						
					</div>
                </div>
            </div>
			<!-- 已登录 regLogin end -->
            
            <div id="search" class="search">
            	<span>
                	<form id="form-search" enctype="text" action="" method="post">
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
    	<a href="index.html" class="logo"><img src="static/footer-logo.png" /></a>
        <div class="clear"></div>
        <p class="cp">Copyright ©2012 All rights reserved. 软件工程出品</p>
    </div>
    <!-- 底部 end -->

</body>
</html>