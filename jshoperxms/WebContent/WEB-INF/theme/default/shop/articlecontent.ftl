<!DOCTYPE HTML>
<html>
<head>
    <title>${(jshopbasicinfo.jshopname)}</title>
    <meta name="Author" content="jshoper3x">
    <meta name="Copyright" content="jshoper3x">
    <meta http-equiv="expires" content="0">
    <#if (jshopbasicinfo.metaKeywords)! != "">
    <meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/>
</#if>
<#if (jshopbasicinfo.metaDes)! != "">
<meta name="description" content="${jshopbasicinfo.metaDes}"/>
</#if>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div class="container_12">
 <div id="content" class="grid_9">
<article class="post view_post">
	<h1 class="post_title">Citrus Magic Solid Air Freshener</h1>
			<div class="content_article">
			${article.contentvalue}
			</div>
</article>
 </div>

</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">

</body>
</html>