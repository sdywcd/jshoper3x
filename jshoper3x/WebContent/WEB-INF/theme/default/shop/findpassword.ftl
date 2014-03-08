
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
	<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/register.css" />
	<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/findpd.css" />
  	<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/js/jquery.query.js"></script>
		
  </head>
  
  <body>

<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">


<div id="main">
  <div class="location">您所在的位置： <a href="/?mid=0">首页</a> &gt; <a href="javascript:;">找回密码</a></div>
  <div class="content mt5">
    <div class="password">
      <div class="top"></div>
      <div class="passwordbox">
        <div class="p_div1">1.如果您设置了安全问题，您可以通过安全问题找回您的密码，请输入您的安全问题的正确答案</div>
        <form id="FPassByPPFrom" name="FPassByPPFrom" method="post">
          <div class="p_div2">
            <div id="showMsg" style="color:red;float:left;margin-top:5px;padding-left:150px;"></div>
            <div>
              <p>请填写您的用户名：</p>
              <span>
              <input type="text" id="username" name="username" class="fpw_rinp1">
              </span></div>
            <div>
              <p>请选择您的安全问题：</p>
              <span>
              <select style="width:213px;;height:27px;" id="question" name="question">
                <option value="">请选择...</option>
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
              </span>
              <!--<div class="op">提示信息的位置，加在这个div上</div>
						          <div class="btn"><input class="style1" type="button" onclick="checkPPForm();"/></div>-->
              <cite><input type="button"  id="checkfindpassword" class="btnsubmit" value="提交" /></cite> </div>
            <div>
              <p>回答：</p>
              <span>
              <input type="text" id="answer"  name="answer" size="50" value="">
              </span></div>
          </div>
        </form>
        <div class="p_div1 mt10">2.如果您知道您注册时使用的电子邮件地址，请输入您的电子邮件地址，我们将把您的密码发送到您的邮箱里</div>
        <form id="findpassByEmail" name="findpassByEmail" onsubmit="return false;" style="margin:0px">
          <div class="p_div2">
            <div>
              <p>请填写您的Email地址：</p>
              <span>
              <input type="text" name="Email" id="Email">
              <input type="hidden" name="loginId" id="loginId" value=" ">
              </span><cite><a href="javascript:;" onclick="checkEMForm();" class="btn">提交</a></cite></div>
          </div>
        </form>
        <div class="p_div3">请正确填写您的注册的电子邮箱地址，系统将把信的密码发送到您的注册邮箱，如果该邮箱地址错误，或者您已经忘记注册是的邮箱地址，
          我们将无法为您找回密码，建议您<a href="#" target="_blank">重新注册</a>一个帐号。 </div>
      </div>
      <div class="reg_foot">
        <p><img src="${basepath}/ui/default/images/reg_foot_l.gif"></p>
        <cite><img src="${basepath}/ui/default/images/reg_foot_r.gif"></cite></div>
    </div>
  </div>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
	<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>
