<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>首页ostocy-jshop</title>
<meta content="OSTOCY" name="Author">
<meta content="OSTOCY" name="Copyright">
<meta content="0" http-equiv="expires">
<meta content="ostocy-jshop2.0系统演示" name="keywords">
<meta content="ostocy-jshop2.0系统演示" name="description">
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="${basepath}/ui/default/css/global.css" type="text/css" rel="stylesheet">
<link href="${basepath}/ui/default/css/teambuy.css" type="text/css" rel="stylesheet">
<link href="${basepath}/ui/default/css/category.css" type="text/css" rel="stylesheet">
<link href="${basepath}/ui/default/js/easyslider1.7/css/screen.css" type="text/css" rel="stylesheet">
<script src="${basepath}/ui/default/js/jquery-1.6.2.min.js" type="text/javascript"></script>
<script src="${basepath}/ui/default/js/easyslider1.7/js/easySlider1.7.js" type="text/javascript"></script>
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
            <div class="title"><img src="${basepath}/ui/default/images/g_wq_1.gif"></div>
			 <ul>
			<#if (goodsgrouplist??) && (goodsgrouplist?size>0)>
			<#list goodsgrouplist as ggtlist>
              <!-- 已经开始的 -->
              <li class="li2">
                <div class="day">
                  <p><img src="${basepath}/ui/default/images/g_wq_icon.gif"></p>
                  <cite>${ggtlist.begintime}</cite></div>
                <div class="liwrap">
                  <div class="name"><a target="_blank" href="/html/default/shop/group/${ggtlist.groupid}.html">塔克团 特价团购${ggtlist.groupprice}  ${ggtlist.goodsname}   现货发售，当天发货。全网最低的行货正品，快快下手吧~</a></div>
                  <div class="info"> <a target="_blank" href="/html/default/shop/group/${ggtlist.groupid}.html">
                    <div class="isopen"></div>
                    </a>
                    <div class="infoleft">
                      <div class="amount">限<span> ${ggtlist.cashlimit} </span> 人购买</div>
                      <div class="price">
                        <p>团购价：<span>￥&nbsp;${ggtlist.groupprice}</span></p>
                        <cite>塔克价：<span id="memberprice400261_500423">${ggtlist.memberprice} </span></cite></div>
                    </div>
                    <div class="pic"><a target="_blank" href="/html/default/shop/group/${ggtlist.groupid}.html"><img src="${ggtlist.pictureurl}" width="120px" height="120px"></a></div>
                  </div>
                </div>
              </li>
              </#list>
			</#if>
              <!-- 即将开始的  -->
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