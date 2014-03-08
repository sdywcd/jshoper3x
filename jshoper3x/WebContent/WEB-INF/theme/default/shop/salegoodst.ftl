<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 <html>
 <head>
 <title>首页${(jshopbasicinfo.jshopname)}</title>
 <meta name="Author" content="OSTOCY">
 <meta name="Copyright" content="OSTOCY">
 <meta http-equiv="expires" content="0">
 <#if (jshopbasicinfo.metaKeywords)! != "">
 <meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/>
 </#if>
 	<#if (jshopbasicinfo.metaDes)! != "">
 <meta name="description" content="${jshopbasicinfo.metaDes}"/>
 </#if>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
 <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/salegoods.css" />
 <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/category.css" />
 <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/js/easyslider1.7/css/screen.css"/>
 <script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
 <script type="text/javascript" src="${basepath}/ui/default/js/easyslider1.7/js/easySlider1.7.js">
 
 </script>
 <script type="text/javascript">	
 						function lxfendTime(){
 						var intervalId=setInterval(function(){
 			var temp=null;
 			var nowTime = new Date().getTime();			
 			var begin=document.getElementById('begingtime').value;
 			var end =document.getElementById('endingtime').value;
 			var begintime=new Date(begin).getTime();
 			var endtime=new Date(end).getTime();
 			var grouptime=endtime-nowTime;
 			var seconds= grouptime/1000;
 			var minutes = Math.floor(seconds/60);
 			var hours = Math.floor(minutes/60);
 			var days = Math.floor(hours/24);
 			var cday = days;
 			var chour=hours % 24;
 			var cminute=minutes % 60;
 			var csecond=Math.floor(seconds%60);
 			if(endtime<=nowTime){
 				temp="恭喜用户拍的此商品";
 			}
 			if(endtime>=nowTime&&cday>1){
 				temp="拍卖剩余时间："+cday+" 天 "+chour+" 时 "+cminute+"分 "+csecond+"秒";
 			}else if(endtime>=nowTime&&cday<1){
 				temp="拍卖剩余时间："+chour+" 时 "+cminute+"分 "+csecond+"秒";
 			}
 			if(begintime>nowTime){
 		 	temp="拍卖即将开始";
 			}	
 			
 			document.getElementById("timer").innerHTML=temp;
 			if(begintime>nowTime){
 			document.getElementById("qiang").style.display='none';
 			}
 			if(endtime<=nowTime){
 			document.getElementById("qiang").style.display='none';
 			}
 		},1000);
 		
 		
 		
 		
 	}	
 	
  
 	
 	</script>
    
     
     
 </head><body>
 
 <!--载入公共头文件-->
 <#include "/WEB-INF/theme/default/shop/header.ftl">
 <input type="hidden" id="hidurl" name="hidurl" value=""/>
 <div class="wrap">
 
 	    <div style="background:url(${basepath}/ui/default/images/g_topbanner.jpg) no-repeat top center; width: 100%;">
 		<div class="g_content">
 		
 		    <div class="g_maindiv">
 		       <div class="mainleft">
 			    <div class="leftdiv1">
 				<div class="top"></div>
 				<div class="box">
 			<#if (salegoodst??) && (salegoodst?size>0)>
 	
 					<form method="post" enctype="multipart/form-data" id="buyForm" action="AddSaleGoodsrecordByHiprice.action?salegoodsid=${salegoodst.salegoodsid}">
 					
 					<div class="right-extra">
 				<h1>${salegoodst.salegoodsname} </h1>
 				<div class="product-intro">
 						<div class="product-img">
 								<div class="p-img"> <img alt="${salegoodst.salegoodsname}" src="${salegoodst.salegoodspictureurl}" width="132" height="132" onerror="#"></div>
 								<p> （商品图片仅供参考，以实物为准）</p>
 						</div>
 						<div class="auction-info">
 								<ul>
 										<li>商品编号：${salegoodst.salegoodsnumber}</li>
                                         <li>商品名称：${salegoodst.salegoodsname}</li>
                                          </#if>
                                         <#if (salejoinnumber??)>
                                         <li>当前参加拍卖人数：${salejoinnumber}</li>
                                           </#if>
                                            <#if (salegoodst??) && (salegoodst?size>0)>
                                         <li>拍卖管理员：${salegoodst.salepeople}</li>
                                         <li>商品产地：${salegoodst.place}</li>					
                                         <li>生产厂商：${salegoodst.manufacturer}</li>
                                         <li>塔克商城价：<cite>${salegoodst.marketprice}</cite></li>
                                         <li>最低加价：${salegoodst.lowprice} </li>
                                         <li>拍卖开始时间：${salegoodst.begingtime}</li>
                                         <li>拍卖截止时间：${salegoodst.endingtime}</li>
                                         </#if>
                                         <#if (rehiprice??)>
                                    		<li>当前最高价：${rehiprice}</li>   
                                   </#if>
                                                   <#if (salegoodst??) && (salegoodst?size>0)>                      
                                         <li><#setting date_format=" MM/dd/yyyy HH:mm:ss "/>
 						<input type="text" id="begingtime" name="begingtime" value="${salegoodst.begingtime?date?string}" style= "display:none " />
 						<input type="text" id="endingtime" name="endingtime" value="${salegoodst.endingtime?date?string}" style= "display:none " />
                         <cite id="timer">
 						<script type="text/javascript">lxfendTime()	</script>	</cite></li>
                         <li>我要抢：<input type="test" name="hiprice"  id="hiprice" /><input type="submit"  name="submit" value="出价" /><div id="nowprice"></div></li>
                                         
 								</ul>
 																<div class="warning">${salegoodst.salegoodsmessage}</div>
 														</div>
 				</div>
 			
 			</div>
 	
 				       </form>
 	<div class="bottom"></div>
 	 </div>
      </div>
      
      <div class="leftdiv2">
 		<div class="top"></div>
 		<div class="box">
 		<div class="title">详细信息</div>
 			${salegoodst.salegoodsinformation}
 		</div>
 		<div class="bottom"></div>
      </div>
      </div>
        </#if>
     <div class="mainright">
         <div class="rightdiv2">
 	   <a target="_blank" href="#">
 	   <img src="${basepath}/ui/default/images/g_gz1.gif">
 	   </a>
 	   <a target="_blank" href="#">
 	   <img src="${basepath}/ui/default/images/g_gz2.gif">
 	   </a>
 	   <a target="_blank" href="#">
 	   <img src="${basepath}/ui/default/images/g_gz3.gif">
 	   </a>
 	</div>
 	
 
 	<div style="width:198px;border:#c2c2c2 solid 1px;background:#FFFFFF;float:left;margin:9px 0 0 0;padding:0 0 7px 0;">
 		<p style="margin:11px 0 0 20px;"><a target="_blank" href="#"><img src="${basepath}/ui/default/images/t_sina.jpg"></a></p>
 		<p style="margin:5px 0 0 20px;"><a target="_blank" href="#"><img src="${basepath}/ui/default/images/t_qq.jpg"></a></p>
 		<p style="margin:7px 0 0 7px;"><img src="${basepath}/ui/default/images/t_tao3c.jpg"></p>
 	</div>
 	
 
 	<div class="rightdiv4">
 		<img src="${basepath}/ui/default/images/r_pic02.jpg">
 	</div>
        </div>
       </div>
      </div>
     </div>
     
    </div>
    
 <#include "/WEB-INF/theme/default/shop/footer.ftl">
 <script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
 <script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
 		 
 </body>
 </html>