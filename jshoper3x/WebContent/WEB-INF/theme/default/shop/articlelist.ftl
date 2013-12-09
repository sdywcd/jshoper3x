<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
  <head>
    <title>${articleCategory.name} Soipay帮助中心<#if setting.isShowPoweredInfo="1"> - Powered By Soipay</#if></title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="Author" content="OSTOCY TEAM" />
	<meta name="Copyright" content="JSHOP" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<#if (articleCategory.metaKeywords)! != ""><meta name="keywords" content="${articleCategory.metaKeywords}" /></#if>
	<#if (articleCategory.metaDescription)! != ""><meta name="description" content="${articleCategory.metaDescription}" /></#if>
	<link rel="icon" href="favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}//ui/default/css/style_usercenter.css" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}//ui/default/css/style_green.css" />
	<link rel="stylesheet" type="text/css" href="${basepath}//ui/default/css/tabs-accordion-usercenter.css"/>
  	<script type="text/javascript"  src="${basepath}//ui/default/js/jquery1.4.2.js"></script>
	<script type="text/javascript" src="${basepath}//ui/default/js/jquery.tools.min.js"></script>

  	<!--[if IE 6]>
	<style>
	body {behavior: url("${basepath}//ui/default/css/csshover3.htc");}
	</style>
	<![endif]-->

  </head>
  
  <body>
  <input id="hidurl" name="hidurl" value="" type="hidden"/>
<div id="top_header">
	<div id="top_header_menu">
	<#include "/WEB-INF/theme/default/shop/top_header.ftl">
    </div>
</div>
<div id="header">
	<div id="header_inner" class="fixed">
		<div id="logo">
			<h2>www.soipay.com</h2>
		</div>
		<!-- 读取导航菜单 
		  <s:action name="GetIndexMenu" namespace="/jshop_system" id="bean" /> -->
		  <div id="menu">
			<ul>
				<!--<li><a href="<%=basePath %>index.jsp " class="active">首页</a></li>
			    <s:if test="#bean.mainmenu!=null">
                <s:iterator id="bean" value="#bean.mainmenu" status="findindexmenu">
				<li><a href="<%=basePath %>goods/goodslist.jsp?navid=<s:property value="navid"/>" target="_blank" class="active"><s:property value="nname"/></a></li>
                </s:iterator>
			    </s:if>-->
				<@mainmenu_list mainmenu_navid=mainmenu.navid type="recommend" count=mainmenucount;mainmenuList>
					<#list mainmenuList as mmenu>
						<li><a href="$(basePath)/index.jsp" class="active" title="首页"</a></li>
					</#list>
				</@mainmenu_list>
			</ul>
		 </div>
	</div>
</div>
<div id="main">
	<div id="main_inner" class="fixed">
		  <div id="top_main_inner" class="fixed">
				<!--<jsp:include page="../../header.jsp"></jsp:include>-->
				<#include "../../header.jsp">
		  </div>
		  <div id="primaryContent_2columns">
				<div id="columnA_2columns">
						<div class="detail">
							$(contentvalue)
						</div>
				</div>
		  </div>
		  <div id="secondaryContent_2columns">
				<div id="columnC_2columns">
					<!--<jsp:include page="helpcentermenu.jsp"></jsp:include>-->
					<#include "helpcentermenu.jsp">
				</div>
		  </div>
		  <br class="clear" />
	</div>

</div>
<#include "../../footer.jsp">
<#include "/WEB-INF/template/shop/footer.ftl">
	<!-- This JavaScript snippet activates those tabs -->
<script>             
$(function() { 
$("#accordion").tabs("#accordion div.pane", {tabs: 'h2', effect: 'slide', initialIndex: null});
});
</script>
</body>

</html>
