<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ecommerce.hiBean.Item" %>
<%@page import="com.ecommerce.hiBean.Photo"%>
<%@page import="com.ecommerce.hiBean.Users"%>
<%@page import="com.ecommerce.hiDAO.PhotoDAO"%>
<%@page import="com.ecommerce.hiDAO.ItemDAO"%>
<%@page import="com.ecommerce.hiDAO.UsersDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>首页 | 欢迎</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />
<link rel="stylesheet" type="text/css" href="static/cart.css" />

<!--引用JS文件-->
<script type="text/javascript" src="" charset="utf-8"></script>

</head>

<body>
    <!-- header  -->
   <%boolean login=true; %>
   <%@include file="head.jsp" %>
<!-- header end -->

	<!-- 页面主体 -->
    <div id="container">
    
    <!-- main -->
    <div id="main">
    	<!--==================张琛：确认订单:: 地址，联系，货物列表，-->
		
		<h1 class="confirm">确认订单信息</h1>
		<!---------------------------------------默认地址提示 -->
		<div id="message-box" class="message">
			<span class="iconinfo"></span>
			<div id="save-default-box" >
				<h6 style="color:#F00"> 提示：</h6>
				<p>
					<input id="tip-checkbox" type="checkbox" checked="checked" />
					<label for="tip-checkbox">我希望默认使用此订单的送货地址、付款方式~~</label>
				</p>
			</div>
		</div>
		
		<!---------------------------------------------详细信息 -->
		<div class="orangebox details">
			<div class="whitebox" id="details-r1">
				
				<!---------------------------------address -->
				<%
				Users u = (Users)session.getAttribute("user");
				 %>
				<div class="address">
					<h3 >订单信息</h3>
					<ul class="address-details">
						<li class="uname">收货人姓名：<%=u.getUserName() %></li>
						<li class="street">收货人地址：<%=u.getAddress() %></li>
						<li class="phonenum">收货人电话: <%=u.getPhone() %></li>
						<li class="changelink">
							<a href="javascript:;" onclick="document.getElementById('ChangeOrderDialog').style.display='block';document.getElementById('exposeMask').style.display='';">更改地址</a>
						</li>
					</ul>
				</div>
				
				<!-- ------------------------------payment-->
				<div class="payment">
					<h3>付款方式</h3>
					<ul class="payment-details">
						<li>货到付款</li>
						<li>
							
						</li>
					</ul>
				</div>
				
				
			</div>
			<!------------------------------再看一眼详单。送货方式 -->
			<div class="whitebox" id="details-r2">
				<h3>商品列表</h3>
				<!------------------------------货物列表 -->
				<div class="goods-list">
				
				<%
				
				ArrayList list = null;
				list= (ArrayList) session.getAttribute("items"); 
				
				Item item;
				float totalprice=0;
				if(list!=null)
				{
				for(int i=0;i<list.size();i++)
				{
  				item=(Item)list.get(i);
  				PhotoDAO pd = new PhotoDAO();
  				String url = ((Photo)pd.findPicUrlByItemId(item)).getPicUrl();
  				UsersDAO userdao=new UsersDAO();
  				String owenername=((Users)userdao.findById(item.getOwenerId())).getUserName();
  				totalprice=totalprice+item.getPrice();
  				//String url=null;
  				%>
  								
					<div class="item">
						<div class="item-image">
							<img src=<%=url%> width="100" height="100" alt=<%=item.getItemName() %> />
						</div>
						<div class="item-description">
							<h4 class="title"><%=item.getItemName() %></h4>
							<p class="author"> xxx</p>
							<p class="price">￥<%=item.getPrice() %></p>
							<p class="quantity">
								<b>数量：</b>
								<span>1</span>
								
							</p>
							<p class="seller">
								卖家：&nbsp;<b> <%=owenername %></b>
							</p>
						</div>
					</div>
					<%}
					} %>

					
				</div>
				
				<!------------------------------送货方式 -->
				<div class="ship-options">
					<h4 class=" drkgry">送货方式</h4>
					<ul>
						<li>
							<label><input type="radio" name="ship-method" id="ordinary"/>平邮（3日）</label>
						</li>
						<li>
							<label><input type="radio" name="ship-method" id="express"/>快递（1~2日）</label>											
						</li>
						<li>
							<label><input type="radio" name="ship-method" id="urgent"/>加急快递（1日）</label>
						</li>
					</ul>
					
					<!---------------------------货物拆分 -->
					<h4 class=" drkgry">货物拆分</h4>
					<ul>
						<li>
							<label><input type="radio" name="ship-split" id="waitall"/>等待所有商品到货一起发货</label>						
						</li>
						<li>
							<label><input type="radio" name="ship-split" id="splitgoods"/>用最快方式拆分订单发货 (可能产生额外费用)</label>
						
						</li>
					</ul>					

					<!--------------------------只在工作日送货 -->
					<h4 class=" drkgry">希望送货的时间</h4>
					<ul>
						<li>
							<label><input type="radio" name="ship-date" id="workdays"/>只工作日送货</label>
						</li>
						<li>
							<label><input type="radio" name="ship-date" id="weekends"/>只双休日、假日送货</label>						
						</li>
						<li>
							<label><input type="radio" name="ship-date" id="anytime"/>工作日、双休日或假日均可送货</label>					
						</li>
					</ul>
					<!------------------------------------客户备注 -->					
					<h4>配送相关特殊说明（配送公司会尽量协调）：</h4>
					<input type="text" class="remarks" />
					<span class="small">最多15个字</span>
				</div>
			</div>
			
		</div>
        
    </div>
    <!-- main end -->
    
      <%
            Users user=(Users)session.getAttribute("user");
    	  
    	 	int userid=user.getUserId();
            
             %>
    <!-- 侧边栏 -->
    <div id="aside">
    	<div class="block">
        
        <!--右侧 确认支付  框-->
        <div class="payoff-box">
		<form method="post" action="9527.htm" id="payoffForm">
			<p>
				<a href="Ordergener.do?userid=<%=userid%>@price=<%=totalprice%>></a>">
					<img src="static/payoff.png" width="137" height="27" alt="订单确认" />
				</a>					
			</p>
			<div class="whitebox">
				<table style="width:100%;">
					<tr>
						<td class="txtleft">
							商品：
						</td>
						<td class="txtright">
							￥<%=totalprice%>
						</td>
					</tr>
					<tr>
						<td class="txtleft">
							配送费：
						</td>
						<td class="txtright">
							￥5.00
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<hr/>
						</td>
					</tr>
				
					<tr>
						<td class="ourprice" colspan="2">
							订单总计： 
							<em >￥<%=totalprice+5%></em>
						</td>
					</tr>

				</table>
			</div>
		</form>
	</div>
        
        </div>
    </div>
    </div>
    
    </div>
    
    <div class="clear"></div>
    <!-- 底部 -->
    <div class="footer" id="footer">
    	<a href="index.jsp" class="logo"><img src="static/footer-logo.png" /></a>
        <div class="clear"></div>
        <p class="cp">Copyright ©2012 All rights reserved. 软件工程出品</p>
    </div>
    <!-- 底部 end -->

	<div id="ChangeOrderDialog" class="g-dialog" style="display: none; z-index: 9999; top: 136px; left: 444.5px; position: fixed; ">
    	<div class="dialog-content">
        	<div class="hd">
            	<h3>更改收货地址</h3>
            </div>
            <div class="bd">
            	<div id="comment-form">
            	<form id="changeOrderInfo" enctype="text" action="ChangeOrderInfoServ.do" method="post">
					<div class="commentText-row">
                        <div class="commentText-hd">
							<h4 class="fl">电话：</h4>
						</div>
						<div class="commentText-bd">
                        	<div class="clear"></div>
							<input type="text" name="phone"  />
						</div>
						<div class="commentText-hd">
							<h4 class="fl">新地址：</h4>
						</div>
						<div class="commentText-bd">
							<textarea class="b-textarea cmt-txa" name="ChangeOrderInfo" id="J_ChangeOrderInfo" placeholder=""></textarea>
						</div>
					</div>
					<!-- commentText-row end -->
					<div style="padding: 10px 0;">
						<input type="submit" class="bbl-btn pub" id="CommentSubmit" value="确定" />
					</div>
                    <div class="clear"></div>
					</form>
				</div>
				<!-- comment-form end -->
			</div>
			<!-- bd clearfix end -->
			<a class="close" href="javascript:;" onclick="document.getElementById('exposeMask').style.display='none';document.getElementById('ChangeOrderDialog').style.display='none';"></a>
		</div>
		<!-- dialog-content end -->
	</div>
	<!-- ChangeOrderDialog end -->
    <div id="exposeMask" style="position: absolute; top: 0px; left: 0px; z-index: 9998; background-color: rgb(0, 0, 0); display: none; opacity: 0.3; width: 1349px; height: 1756px; "></div>

</body>
</html>