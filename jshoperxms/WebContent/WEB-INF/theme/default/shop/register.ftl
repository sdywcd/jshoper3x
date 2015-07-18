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
<div class="clear"></div>
<!--载入主导航文件-->
<#include "/WEB-INF/theme/default/shop/mainnavigation.ftl">
<div class="clear"></div>
<section id="main" class="newuser_entire_width">
<div class="container_12">
    <div class="grid_6 new_customers" style="margin-top:0px;">
       
          <form id="register" name="register" action="${basepath}/register.action" method="post" class="registed">
           <h2>如果您是第一次购物</h2>
        <p>只有在创建yooxi账户后方可使用网站的全部功能，不过创建的过程很简单、迅速。请务必填写您的真实信息。</p>
            <div class="email"> <strong>用户名:</strong> <sup class="surely">*</sup>
                <br/>
                <input type="text" id="loginname" name="loginname" class="" value="" />
            </div>
            <!-- .email -->
            <div class="password"> <strong>密码:</strong> <sup class="surely">*</sup>
                <br/>
                <input type="password" id="loginpwd" name="loginpwd" class="" value="" />
            </div>
             <!-- pwd -->
            <div class="password"> <strong>确认密码:</strong> <sup class="surely">*</sup>
                <br/>
                <input type="password" id="confirmpassword" name="confirmpassword" class="" value="" />
            </div>
            <!-- .remember -->
              <span style="color:red;" id="registererrormsg"></span>
            <div class="submit">
            

                <input type="button" value="创建我的账户" id="submitmyaccount" class="account"></input>
                          </div>
            <!-- .submit --> </form>
    </div>
    <!-- .grid_6 -->
    <div class="grid_6">
        <form class="registed">
            <h2>如果您是已注册用户</h2>
            <p>现在就登录您的账户，尽情享购吧！</p>
            <div class="email"> <strong>用户名:</strong> <sup class="surely">*</sup>
                <br/>
                <input type="text" id="username" name="username" class="" value="" />
            </div>
            <!-- .email -->
            <div class="password"> <strong>密码:</strong> <sup class="surely">*</sup>
                <br/>
                <input type="password" id="password" name="password" class="" value="" />
                <a class="forgot" href="#">忘记您的密码?</a>
            </div>
            <!-- .password -->
            <div class="remember">
                <input class="niceCheck" type="checkbox" name="Remember_password" />
                <span class="rem">记住密码</span>
            </div>
            <!-- .remember -->
            <div class="submit">
                <input type="button" id="tologin" name="tologin" value="登录" />
                <sup class="surely">*</sup>
                <span id="errormsg"></span>
            </div>
            <!-- .submit --> </form>
        <!-- .registed --> </div>
    <!-- .grid_6 -->
    <div class="clear"></div>
</div>
<!-- .container_12 -->
</section>
<!-- #main -->
<div class="clear"></div>
<#include "/WEB-INF/theme/default/shop/footer.ftl"></body>
</html>