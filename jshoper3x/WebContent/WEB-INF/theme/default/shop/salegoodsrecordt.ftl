<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <title>首页ostocy-jshop</title>
 <meta name="Author" content="OSTOCY">
 <meta name="Copyright" content="OSTOCY">
 <meta http-equiv="expires" content="0">
 <meta content="ostocy-jshop2.0系统演示" name="keywords">
 <meta content="ostocy-jshop2.0系统演示" name="description">
 <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
 <link href="${basepath}/ui/default/css/global.css" type="text/css" rel="stylesheet">
 <link href="${basepath}/ui/default/css/teambuy.css" type="text/css" rel="stylesheet">
 <link href="${basepath}/ui/default/css/category.css" type="text/css" rel="stylesheet">
 <link href="${basepath}/ui/default/js/easyslider1.7/css/screen.css" type="text/css" rel="stylesheet">
 <script src="${basepath}/ui/default/js/jquery-1.6.2.min.js" type="text/javascript"></script>
 <script src="${basepath}/ui/default/js/easyslider1.7/js/easySlider1.7.js" type="text/javascript"></script>
 
 	<style>
 		.t{text-shadow: 3px 1px 30px #000; color:#676767; font-size:30px; font-weight:bold;margin:0 0 0 30px;}
 </style>	
 </head>
 <body>
 <!--载入公共头文件-->
 <#include "/WEB-INF/theme/default/shop/header.ftl">
 
 <div class="wrap">
   <div class="g_content">
     <div class="g_maindiv">
       <div class="mainleft">
         <div class="leftdiv3">
           <div class="top"></div>
           <div class="box">
             <div class="t">拍卖列表</div>
 			 <ul>
 			<#if (salegoodslist??) && (salegoodslist?size>0)>
 			<#list salegoodslist as sglist>
               <!-- 已经开始的 -->
               <li class="li2">
                 <div class="day">
                   <cite>${sglist.salegoodsname}</cite></div>
                 <div class="liwrap">
                   <div class="name"><a target="_blank" href="Salegoods.action?salegoodsid=${sglist.salegoodsid}"><span>商品简介：</span>${sglist.salegoodsmessage}</a></div>
                   <div class="info"> <a target="_blank" href="Salegoods.action?salegoodsid=${sglist.salegoodsid}">
                     <div class=""></div>
                     </a>
                     
                     <div class="infoleft">
                     
                       <div class="amount">已有<span>0 </span> 人参与</div>
                       <div class="price">
                         <p>起拍价：<span>￥&nbsp;${sglist.salestartingprice}</span></p>
                         <cite>当前最高价：<span id="memberprice400261_500423">0</span></cite>
                   
                         </div>
                        
                     </div>
                     <div class="pic"><a target="_blank" href="Salegoods.action?salegoodsid=${sglist.salegoodsid}"><img src="${sglist.salegoodspictureurl}" width="120px" height="120px"></a></div>
                   </div>
                 </div>
               </li>
               </#list>
 			</#if>
            
             </ul>
            
 			
           </div>
           <div class="bottom"></div>
           <div class="listbottom"> </div>
         </div>
       </div>
       <div class="mainright">
         <div class="rightdiv2"><a target="_blank" href="#"><img src="${basepath}/ui/default/images/g_gz1.gif"></a> <a target="_blank" href="/#"><img src="${basepath}/ui/default/images/g_gz2.gif"></a> <a target="_blank" href="#"><img src="${basepath}/ui/default/images/g_gz3.gif"></a> </div>
         
         <div style="width:198px;border:#c2c2c2 solid 1px;background:#FFFFFF;float:left;margin:9px 0 0 0;padding:0 0 7px 0;">
           <p style="margin:11px 0 0 20px;"><a target="_blank" href="#"><img src="${basepath}/ui/default/images/t_sina.jpg"></a></p>
           <p style="margin:5px 0 0 20px;"><a target="_blank" href="#"><img src="${basepath}/ui/default/images/t_qq.jpg"></a></p>
           <p style="margin:7px 0 0 7px;"><img src="${basepath}/ui/default/images/t_tao3c.jpg"></p>
         </div>
         
         <div class="rightdiv4"><img src="${basepath}/ui/default/images/r_pic02.jpg"></div>
       </div>
     </div>
   </div>
 </div>
 <script src="js/jshop.js" type="text/javascript"></script>
 <#include "/WEB-INF/theme/default/shop/footer.ftl">
 </body>
 
 </html>