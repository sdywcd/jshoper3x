<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>到货通知</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
<link rel="stylesheet" type="text/css" title="Green" href="${basepath}/ui/default/js/easyvalidator/css/validate.css" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/js/jquery.query.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/easyvalidator/js/easy_validator.pack.js"></script>
<script type="text/javascript">
	  $(function(){
		    var timenow = new Date().getTime();	       
	         $('#random').attr("src","randomchecknum.action?d="+timenow);  
		  });
		  
	     function changeValidateCode(obj) {  
	         var timenow = new Date().getTime();	       
	         obj.src="randomchecknum.action?d="+timenow;  
	     }
</script>
</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">
<#include "/WEB-INF/theme/default/shop/usermenu.ftl">
<div id="mem_right" name="mem_right" style="display:block">
<div id="mem_position"><a href="/Member/index.jsp" target="_parent">会员专区</a> &gt; <a href="/Member/OOSBookInList.do">到货通知</a></div>
<div id="hui_r">
  <div class="m1top"><span>到货通知</span></div>
  <div class="huiqh_rbox">
    <div class="huiqh_rmtitle">到货通知列表</div>
    <div class="huiqh_rm1">
      <div style="font-weight:bold;padding-top:15px;padding-bottom:15px;" align="center">您暂无提交任何到货通知！</div>
    </div>
    <div class="mem_qhdj">提交到货通知</div>
      <div class="huiqh_rm2">
        <div class="huiqh_rm2t1">标&nbsp;&nbsp;题：</div>
        <div class="huiqh_rm2inp1">
          <input name="title" value="" type="text">
          <span style="color:#c00;padding-left:10px;">*</span></div>
        <div class="huiqh_rm2t2">内&nbsp;&nbsp;容：</div>
        <div class="huiqh_rm2inp2">
          <textarea style="width:548px;" name="content" value="请输入“商品名称”、“生产企业”、“所需数量”、以便于我们提供更好的服务。"></textarea>
        </div>
        <div class="huiqh_rm2t3">验证码：</div>
        <div class="huiqh_rm2inp3">
          <input type="text" name="ValidateCode" value="" size="8" maxlength="4">
        </div>
        <div class="huiqh_rm2div"><img id="random" src="rand.action" onclick="changeValidateCode(this)"/></div>
		<div id="validateCodeMsg"></div>
        <div class="clear"></div>
        <div class="huiqh_rm2btn">
          <input type="image" src="${basepath}/ui/default/images/huiqh_subbtn.gif" alt="">
          <a href="javascript:;" onclick="resetForm();"><img src="${basepath}/ui/default/images/huiqh_resetbtn.gif" alt=""></a> </div>
      </div>
  </div>
</div>
</div>
<div class="mem_fixHeight"></div>
</div>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>