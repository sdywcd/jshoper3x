<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>找回密码${(jshopbasicinfo.jshopname)}</title>
	<meta name="Author" content="OSTOCY">
	<meta name="Copyright" content="OSTOCY">
	<meta http-equiv="expires" content="0">    
	<#if (jshopbasicinfo.metaKeywords)! != ""><meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/></#if>
	<#if (jshopbasicinfo.metaDes)! != ""><meta name="description" content="${jshopbasicinfo.metaDes}"/></#if>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="${basepath}//ui/default/css/register.css" />
	<link rel="stylesheet" type="text/css" href="${basepath}//ui/default/css/findpd.css" />
  	<script type="text/javascript"  src="${basepath}//ui/default/js/jquery-1.6.2.min.js"></script>
  </head>
  
  <body>

<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="main">
	  <div id="main2">
	    <div id="maintop"></div>
		<div id="position"><a href="/?mid=0">首页</a> &gt; 找回密码</div>
	
	    <div id="find">
	      <div class="top"></div>
	      <div class="find_sucBox">
	        <div class="find_box2">
	          <div class="txt1"><img src="${basepath}//ui/default/images/find_sucTitle.gif" alt=""></div>
	          <div class="txt2">您的申请已成功提交，系统已经给您的邮箱发送了通知信。</div>
	          <div class="txt3">请立刻登录邮箱，并按照邮件仲的提示完成取回密码的操作。</div>
	          <div class="txt4">注意：如果您连续多次取回密码，请以最新收到的邮件为准。</div>
	          <div class="btn"><a href="/?mid=0"><img src="${basepath}//ui/default/images/find_btn_goBack.gif" alt=""></a></div>
	        </div>
	      </div>
	      <div class="bot"></div>
	    </div>
	
	  </div>
	</div>
<#include "/WEB-INF/theme/default/shop/footer.ftl">
	<script type="text/javascript" src="${basepath}//ui/default/js/jshop.js"></script>
</body>
</html>
