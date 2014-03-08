<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>支付密码保护</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/js/jquery.query.js"></script>

</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">
<#include "/WEB-INF/theme/default/shop/usermenu.ftl">

<div id="mem_right" name="mem_right" style="display:block">
<div id="mem_position"><a href="/Member/index.jsp" target="_parent">会员专区</a> &gt; <a href="/Member/UpdatePayPassword.do">修改支付密码</a></div>
<div id="hui_r">
  <div class="myc_top">
    <ul>
      <li><a class="cur" href="javascript:;"><span>修改支付密码</span></a></li>
    </ul>
  </div>
  <div class="paypw_rmain">
  
    <div class="paypw_rm2">
      <div class="paypw_rmtitle2">设置支付密码保护问题</div>
      <div class="clear"></div>
      <div id="showMsg1" align="center" style="font-weight:bold;height:20px;width:200px;color:#fff;line-height:20px;margin-left:240px;background:#ef8f00;visibility:hidden;"></div>
     <div class="paypw_tips2" style="color:#333333">请输入您的旧密码保护答案和要修改的新密码保护</div>
        <div class="paypw_rm2t1" style="margin-top:10px;"><span style="color:#c00;padding-left:10px;">*</span> 旧的密码保护问题：
		<#if Session["user"]?exists>
			<#if user.question??>
			${user.question}
			</#if>
		</#if>
		</div>
        <div class="paypw_rml2"><span style="color:#c00;padding-left:10px;">*</span> 答案：</div>
        <div class="paypw_rmr2">
          <input type="text" name="oldanswer">
          <input type="hidden" value="您的宠物的名字是" name="oldquestion">
        </div>
        <div class="paypw_rml2"><span style="color:#c00;padding-left:10px;">*</span> 设置新的密码保护问题：</div>
        <div class="paypw_rmr2">
          <select name="paySafetyQuestion"  id="paySafetyQuestion">
            <option value="">请选择</option>
            <option value="您最喜欢的运动员的名字">您最喜欢的运动员的名字</option>
            <option value="您的幸运数字是多少">您的幸运数字是多少</option>
            <option value="您的宠物的名字是">您的宠物的名字是</option>
            <option value="您的启蒙老师叫什么">您的启蒙老师叫什么</option>
            <option value="您最喜欢的鸟类是什么">您最喜欢的鸟类是什么</option>
            <option value="您最喜欢吃的一道菜是">您最喜欢吃的一道菜是</option>
            <option value="您最喜欢的一部电影是">您最喜欢的一部电影是</option>
            <option value="您最钟爱的一本书是什么">您最钟爱的一本书是什么</option>
            <option value="您少年时心目中的英雄是谁">您少年时心目中的英雄是谁</option>
            <option value="您收过的最令你感动的礼物是">您收过的最令你感动的礼物是</option>
          </select>
        </div>
		<div class="clear"></div>
        <div class="paypw_rml2"><span style="color:#c00;padding-left:10px;">*</span> 答案：</div>
        <div class="paypw_rmr2">
          <input type="text" id="payAnswer" name="payAnswer" size="50" value="" />
        </div>
        <div class="clear"></div>
        <div class="paypw_btn">
          <input type="button" id="questionprotectsubmit" style="background:url(${basepath}/ul/defaultimages/edique_savebtn.gif) no-repeat; width:79px;height:26px;" value="">
        </div>

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
