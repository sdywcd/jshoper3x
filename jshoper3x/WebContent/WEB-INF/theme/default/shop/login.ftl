
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>${(jshopbasicinfo.jshopname)}</title>
	<meta name="Author" content="OSTOCY">
	<meta name="Copyright" content="OSTOCY">
	<meta http-equiv="expires" content="0">    
	<#if (jshopbasicinfo.metaKeywords)! != ""><meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/></#if>
	<#if (jshopbasicinfo.metaDes)! != ""><meta name="description" content="${jshopbasicinfo.metaDes}"/></#if>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/register.css" />
    <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/js/easyvalidator/css/validate.css" />
  	<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="${basepath}/js/jquery.query.js"></script>
	<script type="text/javascript" src="${basepath}/ui/default/js/easyvalidator/js/easy_validator.pack.js"></script>
	<script type="text/javascript" src="${basepath}/ui/default/js/easyvalidator/js/jquery.bgiframe.min.js"></script>
  
  </head>
  
  <body>

<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">


<div id="main">
		<div class="content mt5">
			<div id="login" class="login">
				<div class="top">
					<img src="${basepath}/ui/default/images/login_top.gif">
				</div>

				<div class="loginbox">
					<div class="reg_left">
						
							<div class="login_div1">
								<p>用户名</p>
								<cite><input type="text" name="username" id="username" reg="^\w{6,20}$" tip="请输入用户名称">
								</cite>
							</div>
							<div class="login_div2">
								<p>密 码</p>
								<cite><input type="password" id="password" name="password" reg="^\w{6,20}$" tip="请输入用户密码"> </cite><span><a href="${basepath}/html/default/shop/user/findpassword.html">忘记密码？</a> </span>
							</div>

							<div class="login_div4">
								<input id="submit" name="submit" type="button"  style="border:0 solid #ffffff;height:35px;width:105px;background:url(${basepath}/ui/default/images/login_btn.gif);cursor:pointer;">
							</div>
						<div class="login_div5">
									
						</div>


					</div>



					<div class="reg_right">
						<a href="${basepath}/html/default/shop/user/register.html"><img class="newuser" src="${basepath}/ui/default/images/reg_btn2.gif"> </a>
					</div>
				</div>
				<div class="reg_foot">
					<p>
						<img src="${basepath}/ui/default/images/reg_foot_l.gif">
					</p>
					<cite><img src="${basepath}/ui/default/images/reg_foot_r.gif">
					</cite>
				</div>


			</div>
			
		</div>
	</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
	<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>
