<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的收藏</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}//ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}//ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}//ui/default/css/huiyuan.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"  src="${basepath}//ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}//js/jquery.query.js"></script>

</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">
<#include "/WEB-INF/theme/default/shop/usermenu.ftl">
<div id="mem_right" name="mem_right"  width="100%" height="606" frameborder="0" scrolling="no" onload="javascript:dyniframesize('mem_right');" style="display: block; ">
  <div id="mem_position"><a href="#" target="_parent">会员专区</a> &gt; <a href="#">我的收藏</a></div>
<div id="hui_r">
  <div class="huiind_rm1_t760"><span>我的收藏</span></div>
  <div class="mem_bor_006194" style="_height:1%;">
    <div style="padding:0 3px 15px 3px;">
      <div class="mem_scTitle">
        <div class="t1">商品图片</div>
        <div class="t2">商品名称</div>
        <div class="t3">操作</div>
      </div>
	  <#if (favorite??)&&(favorite?size>0)>
		<#list favorite as favs>
		  <div>
			<ul id="${favs.favoriteid}" class="mem_bor_70bccc_dashed" style="height:170px;">
				<li class="mem_Favorites01">
				  <div class="mem_Favorites01_div"> <a href="${basepath}//html/default/shop/$(favs.goodsid}" target="_blank" onmouseover="showLayer(244416,'l');" onmouseout="notShow(244416);"><img id="imgbox_244416" alt="${favs.title}" src="images/244416_1_pic120_5701.jpg" border="0"></a> </div>
				  <div id="pic_layer244416" class="list2_open" style="display:none;" onmouseover="this.style.display='';" onmouseout="this.style.display='none';">
					<div class="list2_op_top"><img src="${basepath}//ui/default/images/spacer.gif" alt="" height="1" width="1"></div>
					<div class="list_shadow_ie6 list2_op_shadow" id="layer_content">
					  <div class="list2_op_clo"><img onclick="hideLayer(244416);" style="cursor:pointer;" src="${basepath}//ui/default/images/list2_op_clo.gif" alt=""></div>
					  <div class="list2_opimg">
						<div><a href="/product/244416.html" target="_blank"><img src="/upload/601/603/51300/51301/51302/244416_1_pic310_5701.jpg" alt="${favs.title}" border="0"></a></div>
					  </div>
					</div>
					<div class="list_bottom_ie6 list2_op_bottom"></div>
				  </div>
				</li>
				<li class="mem_Favorites02">
				  <div style="line-height:22px;"> <a href="/product/244416.html" target="_blank" class="mem_214977_14" title="${favs.title}">${favs.title}</a> <br>
					<p><#if (favs.descript??)&&(favs.descript?size>0)>${favs.descript}</#if></p>
				  </div>
				</li>
				<li class="mem_Favorites04"> 
				<a href="javascript:;"onclick="DelMyFavoriteByid(${favs.favoriteid});" target="_blank">删除</a>
				</li>
				<div style="clear:both;"></div>
			  </ul>
		  </div>
		</#list>
     </#if>
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
  <div class="mem_fixHeight"></div>
</div>
</div>
</div>
<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}//ui/default/js/jshop.js"></script>
</body>
</html>