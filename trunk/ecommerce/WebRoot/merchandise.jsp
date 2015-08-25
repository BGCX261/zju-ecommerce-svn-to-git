<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page import="com.ecommerce.hiBean.Item"%>
<%@page import="com.ecommerce.hiDAO.PhotoDAO"%>
<%@page import="com.ecommerce.hiBean.Photo"%>
<%@page import="com.ecommerce.hiBean.Users"%>
<%@page import="com.ecommerce.hiBean.Store"%>
<%@page import="com.ecommerce.hiBean.StoreItem"%>
<%@page import="com.ecommerce.hiBean.UserItem"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" /><!--自动兼容IE8-->
<title>商品详情</title><!--浏览器窗口标题-->

<!--引用CSS文件-->

<link rel="stylesheet" type="text/css" href="static/layout.css" />
<link rel="stylesheet" type="text/css" href="static/pages.css" />

<!--引用JS文件-->
<script type="text/javascript" src="js/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery.magnifier.js" charset="utf-8"></script>

</head>

<body>
    <!-- header  -->
   <%boolean login=false; %>
   <%@include file="head.jsp" %>
<!-- header end -->

	<!-- 最新... -->
	<!-- 页面主体 -->
    <div id="container">
    <div id="main">
    
    	<%Item it= (Item) session.getAttribute("item");
    	  PhotoDAO p = new PhotoDAO();
    	  String url = ((Photo)p.findPicUrlByItemId(it)).getPicUrl();
    	  String title = it.getItemName();
    	  Users user=(Users)session.getAttribute("user");
    	  Integer userid=-1;
    	  if(user!=null)
    	  userid=user.getUserId();
    	  %>
    	<div class="main-top">
        	<h3><%=it.getItemName() %></h3>
        	<div class="gallery">
	        	<div class="pic-box">
    	    		<a><img src=<%=url %> class="magnify" title=<%=title%> /></a>
        		</div>
        	</div>
        	<div class="clear"></div>
        	<div class="item_intro">
            	<span class="fl" style="color: #E63;">简介：</span>
                <p><%=it.getDescription() %></p>
            </div>
	        <div class="act">
    	    	<a class="btn-pink" href="AddFavorites.do?itemid=<%=it.getItemId()%>&userid=<%=userid%>"><img src="static/like-icon.png" />喜欢</a>
        	    <a class="btn-green" href="Buy.do?itemid=<%=it.getItemId()%>&userid=<%=userid%>">购买</a>
            	<a class="btn-blue" href="Addshoppingcart.do?itemid=<%=it.getItemId()%>&userid=<%=userid %>">加入购物车</a>
        		
        	</div>
            <div class="item_detail" style="border-top:1px dotted #d1d1d1;">
            	<p><%=it.getDescription() %></p>
            </div>
        </div>
        
        <div class="main-comment">
        	<div class="comment-nav">
            	<a href="" class="current">全部评论</a>
               <!-- <span class="vline">|</span>
                <a href="">喜欢的人说</a>
                <span class="vline">|</span>
                <a href="">买过的人说</a>-->
            </div>
            <div class="comment-list">
            	<!-- 评论循环体 -->
            	<div class="cmt">
                    <div class="cmt-info">
                    	<a class="fl" href="">纪伊明</a>
                        <span class="fr gc">2012-05-23</span>
                    </div>
                    <p class="cmt-content"><span>Caramel makes a perfect match with latte.长长长长长长长长长长长长长长长长长长长长长长长长长长长长</span></p>
                </div>

                <!-- 循环体结束 -->
                <div class="cmt">
                    <div class="cmt-info">
                    	<a class="fl" href="">纪伊明</a>
                        <span class="fr gc">2012-05-23</span>

                    </div>
                    <p class="cmt-content"><span>Caramel makes a perfect match with latte.</span></p>
                </div>
            </div>
            <div class="clear">
            	<a class="btn-blue" href="javascript:" onclick="document.getElementById('commentDialog').style.display='block';document.getElementById('exposeMask').style.display='';">
                	评论
                </a>
            </div>
        </div>
        
    </div>
	<!-- main end -->
    
    <!-- 右边栏 -->
    <%
    	Object[] tt= null;
    	String name = null;
    	String type = null;
    	String addr = null;
    	String email = null;
    	//个人
    	if(it.getSellerStatus() == true){
    		tt = it.getUserItems().toArray();
    		System.out.println("from maerchandise.jsp: the number of owner is :" + tt.length);
    		
    		if(tt.length > 0){
    			Users u= new Users();
    			u = (Users) ((UserItem)tt[0]).getUsers();
    			name = u.getUserName();
    			type = u.getCampus();
    			addr = u.getAddress();
    			email = u.getEmail();
    		}
    	}
    	//商铺
    	else if(it.getSellerStatus() == false){
    		tt = it.getStoreItems().toArray();
    		System.out.println("from maerchandise.jsp: the number of owner is :" + tt.length);
    		if(tt.length > 0){
    			Store u= new Store();
    			u = (Store)((StoreItem)tt[0]).getStore();
    			name = u.getName();
    			type = u.getName();
    			addr = u.getName();
    			email = u.getName();
    		}
    	}
     %>
    <div id="aside">
    	<div class="block">
        	<div>
            	<a href="" class="likes"><em id="J_LikeCount" data-val="29">29</em></a>
                <div class="stat-box">
                	<span class="fl">300</span>
                    <a href="" class="fr"><span class="fr">1</span></a>
                </div>
                <div class="clear"></div>
                <div class="buy-info">
                	<div class="cola"><a href="shop.jsp"><%=name %></a></div>
                    <div class="colb">￥ <%=it.getPrice() %></div>
                    <div class="colc"><a class="btn-green" href="Buy.do?itemid=<%=it.getItemId()%>&userid=<%=userid%>">购买</a></div>
                    <div class="clear"></div>
                    <div class="item_detail" style="margin: 10px 0 0 4px;">
                    	<p>
                			<span class="reg_attr">类型：</span>
               					<%=it.getItemType() %>
                		</p>
            			
            			<p>
               				<span class="reg_attr">总量：</span>
               				<%=it.getLateSoldNumber() %>
            			</p>
            			<p>
            				<span class="reg_attr">商品状态：</span>
               				<%=it.getItemStatus() %>
            			</p>
                    </div>
                    <!-- detail end -->
                </div>
                <!-- buy-info end -->
            </div>
            <!-- div end -->
        </div>
        <!-- block end -->
        
        <div class="block"></div>
    </div>
	<!-- aside end -->
    
    </div>
	<!-- container end -->
    
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
                	<form action="Comment.do" enctype="text/plain" method="post">
					<div class="commentText-row">
						<div class="commentText-hd">
							<h4 class="fl">我要打分（满分为10）：</h4>
							<!--  <a href="javascript:void(0);" class="radioclick worth-radioclick-off" name="worth" data-type="1"><span>值得</span></a>
							<a href="javascript:void(0);" class="radioclick worth-radioclick-off" name="worth" data-type="0"><span>不值得</span></a>
							<span class="bought fl">
								<input type="checkbox" id="J_Bought" name="bought">
								<label for="J_Bought">我买过</label>
							</span>
							-->
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