<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>帮助中心--${article.title}</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>

</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="main">
<table width="0" border="0" align="center" cellpadding="0" cellspacing="0">
  <tbody>
  <tr>
	<#include "/WEB-INF/theme/default/shop/helprightmenu.ftl">
	<td width="46" valign="top">
	
	<table width="771" border="0" cellspacing="0" cellpadding="0">
		${article.contentvalue}
	</table>
	
	</td>
	</tr>
	</tbody>
	</table>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>