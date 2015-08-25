<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ecommerce.hiBean.Item" %>
<%@page import="com.ecommerce.hiBean.Photo"%>
<%@page import="com.ecommerce.hiDAO.PhotoDAO"%>
<%@page import="com.ecommerce.hiDAO.ItemDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>浏览商品</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />
<link rel="stylesheet" type="text/css" href="static/cart.css" />
<link rel="stylesheet" type="text/css" href="static/jqzoom.css" />

<!--引用JS文件-->
<script type="text/javascript" src="static/jquery-1.7.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery.jqzoom1.0.1.js" charset="utf-8"></script>
<style type"text/css">
div.notes{
	font-size:12px;
}
div.notes a{
	color:#990000;
}

</style>
<script type="text/javascript">

$(function() {
	$(".jqzoom").jqzoom();
});
</script>
</head>

<body>
 <!-- header  -->
     <!-- header  -->
   <%boolean login=false; %>
   <%@include file="head.jsp" %>
<!-- header end -->
<%String type = (String) session.getAttribute("itemType");
	if(type == null) type = "物品";
	System.out.print("from merchandises:" + type);
%>
	<div id="container">
    	<div class="goods-title">
        	<h3><%=type %></h3>
            <ul class="tag-sort" name="searchCond" value="uncertain">
            	<li>排序&nbsp;&nbsp;|</li>
				<li><a href="changeCondSearch.do?itemList=list&searchCond=all">所有</a></li>
        		<li><a href="changeCondSearch.do?itemList=list&searchCond=sales">销量</a></li>
        		<li><a href="changeCondSearch.do?itemList=list&searchCond=price">价格</a></li>
        		<li><a href="changeCondSearch.do?itemList=list&searchCond=trust">信誉</a></li>
        		<li><a href="changeCondSearch.do?itemList=list&searchCond=stockTime">上架时间</a></li>
    		</ul>
        </div>
       <div class="goods-wall">
       <div class="latest box-shadow">
    	<div class="hd">
        	<h3>结果...</h3>
        </div>
        <ul>
<% 
	ArrayList list = null;
	if(type.equals("物品")) 	list= (ArrayList) session.getAttribute("items"); 
	else {
		ItemDAO i = new ItemDAO();
		list = (ArrayList) i.findByItemType(type);
		session.removeAttribute("itemType");
	}
   	Item result;
  		if(list!=null){
  			session.setAttribute("itemCount",list.size());
  			for(int i=0;i<list.size();i++){
  				result=(Item)list.get(i);
  				String sessionkey="item"+i;    //用于改变条件搜索，将已经搜索的结果保存在session中
  				session.setAttribute(sessionkey,result.getItemId());
  				PhotoDAO pd = new PhotoDAO();
  				String url = ((Photo)pd.findPicUrlByItemId(result)).getPicUrl();
  				//String url=null;
  				String title = result.getDescription();
  				String name=result.getItemName();
   %>
          <li>
            <div class="goods fl">
            	<div class="goods-pic">
            	
            	<div id="content" >
            	
					<a href=<%=url %> class="jqzoom" style="" title=<%=name %>>
						<img src=<%=url %>  title=<%=name %> width="120" height="120">
					</a>
					</div>
					
                	<a href="Merchandise.do?itemId=<%=result.getItemId() %>"><strong class="like-count"><%=result.getItemName() %></strong></a>
                </div>
               <!-- 加入商品图片数据库URL<div class="goods-pic">
                	<a href="merchandise.jsp"><img src="static/almond_210X209.jpg" title="美国原装进口万多福大杏仁" width="210" /></a>
                </div> -->
                <div class="goods-stat">
                	<span class="like-num">喜欢: </span>
                    <span class="fr">价格：<%=result.getPrice() %></span>
                </div>
                <div class="goods-intro">
                	<span><%=result.getDescription() %>
                    </span>
                </div>
            </div>
            </li>
            <% } }
            	else{
            		System.out.println("No Item Matched.");
            	}%>
            </ul>	
        </div>
		<!-- goods-wall end -->
    </div>
	
    
    
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