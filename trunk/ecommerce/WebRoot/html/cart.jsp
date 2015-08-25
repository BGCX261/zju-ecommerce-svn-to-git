<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>我的购物车</title><!--浏览器窗口标题-->

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

	<!-- 页面主体 -->
    <div id="container">
    <div id="main">
    <div class="cart-item-list" id="cart-active-items">
					<h3>我的购物车</h3>
					<!--小标题： 商品		价格		数量 -->
					<div class="cart-item-head">
						<table >
						<colgroup>
							<col width="800" />
							<col width="100" />
							<col width="100" />
						</colgroup>

							<tr class="">
								<td class="c2 txtsmall drkgry txtleft">现在购买：</td>
								<td class="c3 txtsmall drkgry txtright">价格</td>
								<td class="c4 txtsmall drkgry txtctr">数量</td>
							</tr>
						</table>
					</div>
					<!--商品列表 -->
					<div class="item-list">
						<!--这里的div 需不需要商品数据相关的自定义标签？ -->
						<div class="cart-item">
							<table >
						<colgroup>
							<col width="120" />
							<col width="680" />
							<col width="100" />
							<col width="100" />
						</colgroup>

								<tr>
									<!--商品图片： -->
									<td class="c1 textleft" valign="top"><a href="9527.htm">
										<img src="static/1.jpg" width="100" height="100" alt="java 入门 123" />
										</a></td>
									<!--商品文字说明： -->

									<td class="c2 txtleft txtnormal" valign="top"><p class="title"> <a href="9527.htm"> Java入门1•2•3:一个老鸟的...</a> <span class="creator"> 作者1；</span> <span class="binding"><b>平装</b></span> </p>
										<p class="scarcity red">此商品还剩一件，欲购从速</p>
										<p class="availability green"></p>
										<p class="merchant gry"> 卖家： <a href="9527.htm"> 有间公司</a> </p>
										<p class="buttons require-js"> <a onclick="return ;" href="javascript:void(false);">删除</a> &nbsp;·&nbsp; <a onclick="return;" href="javascript:void(false);">移入收藏夹</a> </p></td>
									<!--商品价格 -->
									<td class="c3 txtright txtnormal" valign="top"><p class="ourprice"> ￥10.00</p>
										<p class="yousave"> <span class="txtsmall">为您节省：</span> <br/>
											<span class="txtnormal savings"> ￥3.00&nbsp;(33%)</span> </p></td>
									<!--购买数量：input框 -->
									<td class="c4 txtctr txtnormal" valign="top"><p class="quantity">
											<input class="txtctr ime-disabled" type="text" autocomplete="off" value="999" maxlength="3" size="3" name="quantity.1001" />
										</p></td>

							</table>
						</div>
						
						<div class="roweven cart-item">
							<table >
						<colgroup>
							<col width="120" />
							<col width="680" />
							<col width="100" />
							<col width="100" />
						</colgroup>
								<tr>
									<!--商品图片： -->
									<td class="c1 textleft" valign="top"><a href="9527.htm">
										<img src="static/2.jpg" width="100" height="100" alt="Java 语言程序设计" />
										</a></td>
									<!--商品文字说明： -->
									<td class="c2 txtleft txtnormal" valign="top"><p class="title"> <a href="9527.htm"> Java 语言程序设计</a> <span class="creator"> 作者1；</span> <span class="binding"><b>平装</b></span> </p>
										<p class="scarcity green">现在有货</p>
										<p class="availability green"></p>
<!--								<p class="merchant gry"> 卖家： <a href="9527.htm"> 有间公司</a> </p>   -->
										<p class="buttons require-js"> <a onclick="return ;" href="javascript:void(false);">删除</a> &nbsp;·&nbsp; <a onclick="return;" href="javascript:void(false);">移入收藏夹</a> </p></td>
									<!--商品价格 -->
									<td class="c3 txtright txtnormal" valign="top"><p class="ourprice"> ￥90.00</p>
										<p class="yousave"> <span class="txtsmall">为您节省：</span> <br/>
											<span class="txtnormal savings"> ￥30.00&nbsp;(33%)</span> </p></td>
									<!--购买数量：input框 -->
									<td class="c4 txtctr txtnormal" valign="top"><p class="quantity">
											<input class="txtctr ime-disabled" type="text" autocomplete="off" value="999" maxlength="3" size="3" name="quantity.1001" />
										</p></td>
							</table>
						</div>

					</div>

					<!--商品价格小计 -->
					<div id="cart-subtotal" class="subtotal txtlarge txtright">
					合计：
					<span class="ourprice"> ￥100.00</span>
					</div>
					<!--小计上面的虚线分割线 page属性作用不明确-->
					<div class="cart-item-pagination" page="0">
					</div>
				</div>
				
    </div>

    
    <!-- main end -->
    
    <!-- 侧边栏 -->
    <div id="aside">
    	<div class="block">
        	<!--张琛：右侧结算框---------------------------------- -->
			<div class="checkout-box">
<!--				<span class="round-box-tl"></span>
				<span class="round-box-tr"></span>
				<span class="round-box-bl"></span>
				<span class="round-box-br"></span>
 -->				
				<form id="checkoutForm" action="9527.htm" method="post">
					<h3 class="txtlarge txtctr">
					结算(2件商品):
					<span class="ourprice">￥100.00</span>
					</h3>
					<p>
						<a href="check.htm">
						<img src="static/jiesuan.gif" width="135" height="27" alt="jiesuan.gif" />
						</a>
					</p>
					<p>
						或
					</p>
					<p>
						<a href="9527.htm">
						<img src="static/oneclick.gif" width="137" height="27" alt="oneclick.gif" />
						</a>
					</p>
					<p>发货至</p>
					<p>
						<select class="tiny" name="myAddress">
							<option> 暂无地址</option>
						</select>
					</p>
					
					
				</form>
			</div>
        </div>
    </div>
    </div>
    
    </div>
    
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