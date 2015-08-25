var isshow=0;
function creatediv(flag)   
{               
    var msgw,msgh,bordercolor;   
    msgw=400;
    msgh=200;  
    var sWidth,sHeight;   
    if( top.location == self.location )   
        doc = document;   
    var docElement = doc.documentElement;   
    sWidth=docElement.clientWidth;   
    sHeight = docElement.clientHeight;   
    if( docElement.scrollHeight > sHeight )   
        sHeight = docElement.scrollHeight;   
    var bgObj=document.createElement("div");   
    bgObj.setAttribute('id','bgDiv');   
    bgObj.style.position="absolute";   
    bgObj.style.top="0";   
    bgObj.style.left="0";   
    bgObj.style.background="#777";   
    bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";   
    bgObj.style.opacity="0.6";   
    bgObj.style.width=sWidth + "px";   
    bgObj.style.height=sHeight + "px";   
    bgObj.style.zIndex = "10000";   
    document.body.appendChild(bgObj);   
           
    var msgObj=document.createElement("div");   
    msgObj.setAttribute("id","msgDiv");   
    msgObj.setAttribute("align","center");   
    msgObj.style.position = "absolute";   
    msgObj.style.left = "50%";   
    msgObj.style.background="#fff";   
    msgObj.style.marginLeft = "-200px" ;   
    msgObj.style.top = "30%";   
    msgObj.style.width = msgw + "px";   
    msgObj.style.height =msgh + "px";   
    msgObj.style.zIndex = "10001"; 
    if(flag==1)
    	msgObj.innerHTML = "<img src=\"static/header-bg.png\" width=400></img><br /><br />收藏成功！<br /> <br /><br /><a href=\"javascript:void(0);\" class=\"btn-blue\" onclick=\"window.location.href= './merchandise.jsp';return false\">确定</a>";
    else if(flag==0)
    	msgObj.innerHTML = "<img src=\"static/header-bg.png\" width=400></img><br /><br />该物品已经在收藏夹中！<br /> <br /><br /><a href=\"javascript:void(0);\" class=\"btn-blue\" onclick=\"window.location.href= './merchandise.jsp';return false\">确定</a>";
    else if(flag==2)
    	msgObj.innerHTML = "<img src=\"static/header-bg.png\" width=400></img><br /><br />请先登入！<br /> <br /><br /><a href=\"javascript:void(0);\" class=\"btn-blue\" onclick=\"window.location.href= './merchandise.jsp';return false\">确定</a>";
    else if(flag==3)
    	msgObj.innerHTML = "<img src=\"static/header-bg.png\" width=400></img><br /><br />加入购物车成功！<br /> <br /><br /><a href=\"javascript:void(0);\" class=\"btn-blue\" onclick=\"window.location.href= './merchandise.jsp';return false\">确定</a>";
    else if(flag==4)
    	msgObj.innerHTML = "<img src=\"static/header-bg.png\" width=400></img><br /><br />该物品已经在购物车中！<br /> <br /><br /><a href=\"javascript:void(0);\" class=\"btn-blue\" onclick=\"window.location.href= './merchandise.jsp';return false\">确定</a>";

    document.body.appendChild(msgObj);   
}   
function delWinD()   
{   
   document.getElementById("bgDiv").style.display="none";   
   document.getElementById("msgDiv").style.display="none";   
   isshow=0;   
}   
function show(flag)   
{     
    isshow=1;   
    if(!document.getElementById("msgDiv"))
        creatediv(flag);   
    else 
    {   
        document.getElementById("bgDiv").style.display="";   
        document.getElementById("msgDiv").style.display="";   
        document.getElementById("msgDiv").style.top=(document.documentElement.clientHeight/2+document.documentElement.scrollTop-252)+"px";   
    }     
}   
