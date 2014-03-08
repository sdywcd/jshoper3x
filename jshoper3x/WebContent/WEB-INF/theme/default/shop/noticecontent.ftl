<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>${(jshopbasicinfo.jshopname)}公告${(article.title)}</title>
<meta name="Author" content="OSTOCY">
<meta name="Copyright" content="OSTOCY">
<meta http-equiv="expires" content="0">
<#if (article.metaKeywords)! != ""><meta name="keywords" content="${article.metaKeywords}"/></#if>
<#if (title.metaDes)! != ""><meta name="description" content="${title.metaDes}"/></#if>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/category.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/news.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/js/easyslider1.7/css/screen.css"/>
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/easyslider1.7/js/easySlider1.7.js"></script>
</head><body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="main">
	<#if (article??)>
  <div class="location">当前位置：<a href="${basepath}/index.html">首页</a> &gt;
	<a href="/">公告</a>
	<a href="${basepath}/<@article.htmlPath?interpret />">${article.title}</a>
	</div>
  <div class="content">
    <div class="newsdetails">
      <div class="newstitle">
	  
        <p>${article.title}</p>
        <cite>${article.createtime} 来源：${article.author}</cite> </div>
      <div class="newscontent">
        ${article.contentvalue}
      </div>
    </div>
  </div>
  <div class="clear"></div>
  </#if>
</div>


<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>