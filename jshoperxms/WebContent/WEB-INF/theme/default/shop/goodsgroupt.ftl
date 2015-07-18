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
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/teambuy.css" />
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
			var begin=document.getElementById('begintime').value;
			var end =document.getElementById('endtime').value;
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
				temp="已过期";
			}
			if(endtime>=nowTime&&cday>1){
				temp=cday+" 天 "+chour+" 时 "+cminute+"分 "+csecond+"秒";
			}else if(endtime>=nowTime&&cday<1){
				temp=chour+" 时 "+cminute+"分 "+csecond+"秒";
			}
			if(begintime>nowTime){
		 	temp="团购即将开始";
			}	
			document.getElementById("timer").innerHTML=temp;
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
					<#if (goodsgroupt??)&&(goodsgroupt?size>0) >
							
					<#assign x="${goodsgroupt.memberprice?c}"/>
                            <#assign y="${goodsgroupt.groupprice?c}"/>
					<form method="post" enctype="multipart/form-data" id="buyForm">
					
					<div class="name">
										
					塔克团 特价团购${goodsgroupt.groupprice?c} 直接便宜${(x?number-y?number)}元 ${goodsgroupt.goodsname}   现货发售，当天发货。全网最低的行货正品，快快下手吧~
					</div>
					<div id="pp" class="div1_left">
					   
                                           <!-- 进行中 -->
					       
                                               <!-- 下单数大于最小成单数 且小于最大数-->
					       <div class="price1" id="scareBuyBtn">
					       

                                              <a onClick="addtogroupcart(${goodsgroupt.groupid});" href="#"> 
                                               <span>￥</span>
											   
                                               <b id="customerPrice_240603">${goodsgroupt.groupprice?c}</b>
                                               </a>
							</div>

					<div class="price2">
					   <div class="h1">
						<p>塔克价</p>
						<p>节省</p>
					   </div>
					   <div class="h1">
						<cite>
						<span id="memberprice400215_240603" class="t2">		
						${goodsgroupt.memberprice?c}
						
						</span>
						</cite>
							
						<cite>		
												
						<span id="memberprice2400215_240603" class="t2">${(x?number-y?number)}</span>
						</cite>
					   </div>
					</div>
					<div class="sale">
					   
                                           <!-- 进行中 -->
					       
                                               <!-- 下单数大于最小成单数 且小于最大数-->
					       <div id="ss1" class="s1">
					       

					     <p><span id="sordercount" name="sordercount">${goodsgroupt.SOrderCount}</span>人已购买</p>
					     <p><cite>数量有限，下单要快哟</cite></p>
					   </div>

                                           
                                           <!-- 进行中 -->
					       
                                               <!-- 下单数大于最小成单数 且小于最大数-->
					       <div id="ss2" class="s2">
					      <div class="amo1">

					     <span id="ratio"><div style="width:0.0%" class="amo2"></div></span>
					     </div>

						 <#assign a="${goodsgroupt.salequantity}"/>
                         <#assign b="${goodsgroupt.SOrderCount}"/>
					   <p>共有<span id="salequantity" name="salequantity">${goodsgroupt.salequantity}</span>份，
					   还剩<span id="peoplecountplux" name="peoplecountplux">${(a?number-b?number)}</span>份</p>
					</div>
					       


					<div id="mixcount" name="mixcount" class="s3">
					
                                           <!-- 进行中 -->
					       
                                               <!-- 下单数大于最小成单数 且小于最大数-->
					       <img src="${basepath}/ui/default/images/success1.gif">
					       
					</div>
					    <div class="s4">
						<#setting date_format=" MM/dd/yyyy HH:mm:ss "/>
						<input type="text" id="begintime" name="begintime" value="${goodsgroupt.begintime?date?string}" style= "display:none " />
						<input type="text" id="endtime" name="endtime" value="${goodsgroupt.endtime?date?string}" style= "display:none " />
						
						<span id="asdfgh">距活动结束还有：<br></span>
						<span id="timer"><script type="text/javascript">lxfendTime()	</script>
						
						</span>		
					    </div>
					</div>
                                        <div class="sw">
						<a style="background:url(${basepath}/ui/default/images/icon02.gif) no-repeat;" class="kaixin" href="javascript:window.open('http://www.kaixin001.com/repaste/share.php?rtitle='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;rurl='+encodeURIComponent(document.location.href)+'&amp;rcontent='+encodeURIComponent(document.getElementById('contenttt').value.substring(0,76)));void(0)">开心网</a>
						<a style="background:url(${basepath}/ui/default/images/icon04.gif) no-repeat;" class="renren" href="javascript:window.open('http://share.renren.com/share/buttonshare.do?title='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;link='+encodeURIComponent(document.location.href),'favit','');void(0)">人人网</a>
						<a style="background:url(${basepath}/ui/default/images/icon03.gif) no-repeat;" class="douban" href="javascript:window.open('http://www.douban.com/recommend/?title='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;url='+encodeURIComponent(location.href),'favit','');void(0)">豆瓣</a>
						<a style="background:url(${basepath}/ui/default/images/icon05.gif) no-repeat;" class="sina" href="javascript:(function(){window.open('http://v.t.sina.com.cn/share/share.php?title='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;url='+encodeURIComponent(location.href)+'&amp;source=bookmark','_blank','width=450,height=400');})()">微博</a>
						<a class="im" title="分享到QQ微博" href="javascript:void(window.open('http://v.t.qq.com/share/share.php?title='+encodeURIComponent(document.getElementById('contenttt').value)+'&amp;rurl='+encodeURIComponent(document.location.href)));">qq微博</a>
						<a class="mail" title="邮件" href="mailto:?subject=塔克团购&amp;body=哈喽，我看塔克商城在团购这个东东：三星（SAMSUNG）S5360 3G手机 WCDMA/GSM Android OS v2.3系统（金属灰）……。我觉得挺不错的，价格还很便宜。建议你也来看看哦 ">邮件</a>
					</div>
				      </div>
				      <input type="hidden" value="塔克团购三星（SAMSUNG）S5360 3G手机 WCDMA/GSM Android OS v2.3系统（金属灰），建议你也来看看http://www.tao3c.com/teamBuy/302905.html" name="contenttt" id="contenttt">
				  </form>


				
				<div class="div1_right">				   <div class="pic">
					
					<img src="${goodsgroupt.pictureurl}" width="470px" height="470px">
				   </div>
				</div>
				
			    </div>
			    <div class="bottom"></div>
			   </div>
     <div class="leftdiv2">
		<div class="top"></div>
		<div class="box">
		<div class="title">详细信息</div>
		<div class="text2"><p><span style="font-family: 宋体"><span style="widows: 2; text-transform: none; background-color: rgb(255,255,255); text-indent: 0px; font: 12px/18px 宋体, Arial, Lucida, Verdana, Helvetica, sans-serif; white-space: normal; orphans: 2; letter-spacing: normal; color: rgb(51,51,51); word-spacing: 0px; -webkit-text-decorations-in-effect: none; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px" class="Apple-style-span">
</span></span></p><table width="750" cellspacing="0" cellpadding="0" border="0" align="center" style="empty-cells: show">
    <tbody>
       ${goodsgroupt.detail}
    </tbody>
</table>
</div>
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