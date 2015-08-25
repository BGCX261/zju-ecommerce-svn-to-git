<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ecommerce.hiDAO.OrdersDAO"%>
<%@page import="com.ecommerce.hiBean.Users"%>
<%@page import="com.ecommerce.hiDAO.UserRecordDAO"%>
<%@page import="com.ecommerce.hiBean.UserRecord"%>
<%@page import="com.ecommerce.hiBean.Orders"%>
<%@page import="org.hibernate.criterion.Order"%>
<%@page import="com.ecommerce.hiBean.OrderItem"%>
<%@page import="com.ecommerce.hiDAO.OrderItemDAO"%>
<%@page import="com.ecommerce.hiBean.Item"%>
<%@page import="com.ecommerce.hiDAO.PhotoDAO"%>
<%@page import="com.ecommerce.hiBean.Photo"%>
<%@page import="com.ecommerce.db.HibernateSessionFactory"%>
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
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" ></script>
<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />
<link rel="stylesheet" type="text/css" href="static/cart.css" />

<script type="text/javascript" charset="utf-8">
function shouhuo()
{
	itemName=document.getElementsByName("orderBox");
	var str="";
	var rand = new Date().getTime(); //这里用当前时间作为参数加到url中，是为了使URL发生变化，这样验证码才会动态加载，
	var num = 0;
	for(var i = 0 ;i<itemName.length;i++){
		if (itemName[i].checked)
		{
    		str += itemName[i].value + ";";
    		num = num + 1;
    	}
  	}
  	str+=rand;
  	if (num == 0)
  	{
  		alert("至少选中一项！");
  		return false;
  	}
	document.getElementById("orderinput").action="ConfirmOrderServ.do?shouhuoOrder="+str;
	document.getElementById("orderinput").submit();
}

function fukuan()
{
	itemName=document.getElementsByName("orderBox");
	var str="";
	var rand = new Date().getTime(); //这里用当前时间作为参数加到url中，是为了使URL发生变化，这样验证码才会动态加载，
	var num = 0;
	for(var i = 0 ;i<itemName.length;i++){
		if (itemName[i].checked)
		{
    		str += itemName[i].value + ";";
    		num = num + 1;
    	}
  	}
  	if (num == 0)
  	{
  		alert("至少选中一项！");
  		return false;
  	}
  	str+=rand;
	document.getElementById("orderinput").action="DeleteOrderServ.do?fukuanOrder="+str;
	document.getElementById("orderinput").submit();
}

function shanchu()
{
	itemName=document.getElementsByName("orderBox");
	var str="";
	var rand = new Date().getTime(); //这里用当前时间作为参数加到url中，是为了使URL发生变化，这样验证码才会动态加载，
	var num = 0;
	for(var i = 0 ;i<itemName.length;i++){
		if (itemName[i].checked)
		{
    		str += itemName[i].value + ";";
    		num = num + 1;
    	}
  	}
  	if (num == 0)
  	{
  		alert("至少选中一项！");
  		return false;
  	}
  	str+=rand;
	document.getElementById("orderinput").action="DeleteOrderServ.do?shanchuOrder="+str;
	document.getElementById("orderinput").submit();
}
</script>
</head>

<body>&nbsp; 
    m<!-- header  -->
   <%boolean login=true; %>
   <%@include file="head.jsp" %>
<!-- header end -->

	<!-- 页面主体 -->
    <div id="container">
	<!-- main -->
    <div id="main">
    	<!--商品名-->
        <h3>我的订单</h3>



<%
String orderStatus = (String)session.getAttribute("orderStatus");
System.out.println("from order:"  +  orderStatus);
Users us=(Users)session.getAttribute("user");

session.removeAttribute("orderStatus");
OrdersDAO od = new OrdersDAO();
ArrayList orderList = (ArrayList<Orders>) od.findByUserName(Integer.toString(us.getUserId()));
    if(orderList.size() >0){
    	int [] statusCount = new int[6];
    	for(int i=0; i<orderList.size();i++){
    		Orders tempOrder = (Orders)orderList.get(i);
    		statusCount[Integer.parseInt(tempOrder.getOrderStatus())]++;
    	}
    	String[] statusName = new String[6];
    	statusName[0]="待确认收货";
    	statusName[1]="待发货";
    	statusName[2]="待付款";
    	statusName[3]="待评价";
    	statusName[4]="已完成";
    	statusName[5]="垃圾箱";
    	
	%>
		<!--利用选项卡结构-->
		<div id="tabs">
		<ul>
			<li><a href="ShowOrderServ.do?orderStatus=UNCONFIRM RECEIPT">已发货(<%=statusCount[0] %>)</a></li>
			<li><a href="ShowOrderServ.do?orderStatus=1">待发货(<%=statusCount[1] %>)</a></li>
			<li><a href="ShowOrderServ.do?orderStatus=2">待付款(<%=statusCount[2] %>)</a></li>
            <li><a href="ShowOrderServ.do?orderStatus=3">已付款(<%=statusCount[3] %>)</a></li>
            <li><a href="ShowOrderServ.do?orderStatus=4">交易完成(<%=statusCount[4] %>)</a></li>
            <li><a href="ShowOrderServ.do?orderStatus=5">垃圾箱(<%=statusCount[5] %>)</a></li>
		</ul>
		</div>
		<div id="searchOrders">
            <input type="text" name="searchOrders" style="width: 200px;"/>
            <input type="submit" value="在订单中搜索" style="width: 100px;" />
        </div>

<form name="orderinput"  id="orderinput" action="" method="post">

		<!--订单列表区-->
		<div id="orders">
            <div id="ordersTitle">
                <div class="col1">&nbsp;</div>
                <div class="col2">商品</div>
                <div class="col3">订单总金额</div>
                <div class="col4">订单状态</div>
                <div class="col5">&nbsp;操作</div>
            </div>

            <!--1条订单记录的循环体-->
<%    	for(int i=0; i<orderList.size();i++){
			Orders tempOrder = (Orders)orderList.get(i);
			System.out.println("from orders order id is :" +tempOrder.getOrderId());
    		if(!tempOrder.getOrderStatus().equals("5") &&  (tempOrder.getOrderStatus().equals(orderStatus)  || orderStatus.equals("6")) 
    		|| tempOrder.getOrderStatus().equals("5") && orderStatus.equals("5")){
    		
    		OrderItemDAO tempdao = new OrderItemDAO();
    		ArrayList ItemList = (ArrayList)tempdao.findByOrder(tempOrder);
    		System.out.println("from orders itemlist length is :" +ItemList.size());
    		String picUrl = null;
    		PhotoDAO pd = new PhotoDAO();
    		Item itt = ((OrderItem)ItemList.get(0)).getItem();
    		Photo p = (Photo)pd.findPicUrlByItemId(itt);
    		picUrl = p.getPicUrl(); %>
      <div class="orderRecord">
          <div class="col1">
              &nbsp;
              <input type="checkbox" name="orderBox" value="<%=tempOrder.getOrderId()%>" />&nbsp;
              <img src="<%=picUrl%>" width=80 height=80/>
          </div>
          <div class="col2">
              <p>订单号：<a href=""><%=tempOrder.getOrderId() %></a></p>
              <p>下单时间：<%=tempOrder.getSubmintTime() %></p>
 				<%for (int j =0; j< ItemList.size();j++){ 
 				Item it = ((OrderItem)ItemList.get(j)).getItem();
 				%>
              <p><a href="Merchandise.do?itemId=<%=it.getItemId() %>"><%=it.getItemName() %></a></p>
              <%} %>
          </div>
          <div class="col3"><%=tempOrder.getMoney() %></div>
          <div class="col4"><%=statusName[Integer.parseInt(tempOrder.getOrderStatus())] %></div>
          <div class="col5">
              <p><a href="javascript:" onclick="document.getElementById('commentDialog').style.display='block';document.getElementById('exposeMask').style.display='';">评论</a></p>
              <p><a href="" name="delete">删除</a></p>
              <p><a href="" name="tuikuan">退款</a></p>
              <p><a href="" name="tousu">投诉</a></p>
          </div>
      </div>
      <!--1条订单记录循环体结束-->
<%}}%> 
<% }%>
			<div class="function">
		           <div style="float:left; margin:5px 10px;font:宋体"><input type="checkbox" name="selectAll" />全选</div>
		             <div style="float:left;margin:5px 10px ;font:宋体"><a href="#" onclick="shouhuo()"> 确认收货</a></div>
		             <div style="float:left;margin:5px 10px ;font:宋体"><a href="#" onclick="fukuan()"> 合并付款</a></div>
		             <div style="float:left;margin:5px 10px ;font:宋体"><a href="#" onclick="shanchu()"> 删除订单</a></div>
		    </div>
	</div>
</form>
    </div>

    <!-- main end -->
    
    <!-- 侧边栏 -->
    <div id="aside">
    	<div class="block">
        	
        </div>
    </div>
    <!-- 侧边栏 end -->
    
    </div>
    <!-- 页面主体 container end -->
    
    
    <div class="clear"></div>
    <!-- 底部 -->
    <div class="footer" id="footer">
    	<a href="index.jsp" class="logo"><img src="static/footer-logo.png" /></a>
        <div class="clear"></div>
        <p class="cp">Copyright ©2012 All rights reserved. 软件工程出品</p>
    </div>
    <!-- 底部 end -->
    
    <div id="commentDialog" class="g-dialog" style="display: none; z-index: 9999; top: 136px; left: 444.5px; position: fixed; ">
    	<div class="dialog-content">
        	<div class="hd">
            	<h3>评论</h3>
            </div>
            <div class="bd">
            	<div id="comment-form">
					<form action="" enctype="text/plain" method="post">
					<div class="commentText-row">
						<div class="commentText-hd">
							<h4 class="fl">我觉得这个宝贝：</h4>
							<a href="javascript:void(0);" class="radioclick worth-radioclick-off" name="worth" data-type="1"><span>值得</span></a>
							<a href="javascript:void(0);" class="radioclick worth-radioclick-off" name="worth" data-type="0"><span>不值得</span></a>
							<span class="bought fl">
								<input type="checkbox" id="J_Bought" name="bought">
								<label for="J_Bought">我买过</label>
							</span>
						</div>
						<div class="commentText-bd">
							<textarea class="b-textarea cmt-txa" name="commentContent" id="J_CommentContent" placeholder=""></textarea>
						</div>
					</div>
					<!-- commentText-row end -->
					<div style="padding: 10px 0;">
						<input type="submit" class="bbl-btn pub" id="CommentSubmit" value="确定">
					</div>
                    <div class="clear"></div>
					</form>
				</div>
				<!-- comment-form end -->
			</div>
			<!-- bd clearfix end -->
			<a class="close" href="javascript:;" onclick="document.getElementById('exposeMask').style.display='none';document.getElementById('commentDialog').style.display='none';"></a>
		</div>
		<!-- dialog-content end -->
	</div>
	<!-- commentDialog end -->
    <div id="exposeMask" style="position: absolute; top: 0px; left: 0px; z-index: 9998; background-color: rgb(0, 0, 0); display: none; opacity: 0.3; width: 1349px; height: 1756px; "></div>

</body>
</html>