<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>发布商品</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />

<!--引用JS文件-->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" ></script>
<script type="text/javascript" src="static/jquery-1.7.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="static/frame.js" charset="utf-8"></script>

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
            <a class="btn-green fr" href="favorites.html">购物车(0)</a>
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
    <div class="layout960" id="addItem">
    	<h3>发布商品</h3>
        <div class="box-shadow">
        <form action="" enctype="multipart/form-data" method="post">
            <p>
                <span class="reg_attr">类型：</span>
                <input type="radio" name="item_type" id="radio_new" value="0" checked="checked" ><label>全新</label>
                &nbsp;&nbsp;
                <input type="radio" name="item_type" id="radio_used" value="1" checked="false"><label>二手</label>
            </p>
            <p id="howOld">
                <span class="reg_attr">成色：</span>
                <input type="text" name="howOld" />
            </p>
            <p>
                <span class="reg_attr">分类：</span>
                <select name="class"><option value="0">默认</option><option value="1">图书</option><option value="2">数码</option><option value="3">服装</option><option value="4">美食</option></select>
            </p>
            <p>
                <span class="reg_attr">总量：</span>
                <input type="text" name="total" style="width: 30px;" />
            </p>
            <p>
                <span class="reg_attr">单价：</span>
                <input type="text" name="price" style="width: 30px;" />&nbsp;元
            </p>
            <p>
                <span class="reg_attr">所在地：</span>
                <select name="campus"><option value="0">紫金港校区</option><option value="1">玉泉校区</option><option value="2">西溪校区</option><option value="3">之江校区</option><option value="4">华家池校区</option><option value="6">其它</option></select>
            </p>
            <p>
                <span class="reg_attr" style="float: left;">地址：</span>
                <textarea name="fahuo_addr"></textarea>
            </p>
            <p>
                <span class="reg_attr">交易方式：</span>
                <input type="checkbox" name="trade_method" value="0" checked="checked"><label>线下</label>
                &nbsp;&nbsp;
                <input type="checkbox" name="trade_method" value="1"><label>支付宝</label>
            </p>
            <p>
                <span class="reg_attr">运费：</span>
                <input id="radio_bySeller" type="radio" name="item_type" value="0" checked="checked" ><label>卖家承担</label>
                &nbsp;&nbsp;
                <input id="radio_byBuyer" type="radio" name="item_type" value="1"><label>买家承担</label>
                &nbsp;&nbsp;
                <span id="yunfei"><input type="text" name="yunfei" style="width: 30px;" />&nbsp;元</span>
            </p>
            <p>
                <span class="reg_attr" style="float: left;">名称：</span>
                <textarea name="item_name"></textarea>
            </p>
            <p>
                <span class="reg_attr" style="float: left;">简介：</span>
                <textarea name="item_brief"></textarea>
            </p>
            <p>
                <span class="reg_attr" style="float: left;">详情：</span>
                <textarea name="item_detail" wrap="virtual"></textarea>
            </p>
            <p>
                <span class="reg_attr">图片：</span>
                <input type="file" name="item_img" />
            </p>
            <br />
            <input type="submit" name="submit_item" value="发布商品" style="margin-left: 103px;" class="" />
        </form>
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