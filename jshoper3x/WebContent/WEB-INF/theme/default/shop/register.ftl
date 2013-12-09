
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
    <title>会员注册${(jshopbasicinfo.jshopname)}</title>
	<meta name="Author" content="OSTOCY">
	<meta name="Copyright" content="OSTOCY">
	<meta http-equiv="expires" content="0">    
	<#if (jshopbasicinfo.metaKeywords)! != ""><meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/></#if>
	<#if (jshopbasicinfo.metaDes)! != ""><meta name="description" content="${jshopbasicinfo.metaDes}"/></#if>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/register.css" />
  	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}/ui/default/js/easyvalidator/css/validate.css" />
  	<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
	<script type="text/javascript" src="${basepath}/ui/default/js/easyvalidator/js/easy_validator.pack.js"></script>
	<script type="text/javascript" src="${basepath}/ui/default/js/easyvalidator/js/jquery.bgiframe.min.js"></script>
	
	 <script type="text/javascript"> 
		  $(function(){
		    var timenow = new Date().getTime();	       
	         $('#random').attr("src","randomchecknum.action?d="+timenow);  
		  });
		  
	     function changeValidateCode(obj) {  
	         var timenow = new Date().getTime();	       
	         obj.src="randomchecknum.action?d="+timenow;  
	     }
		 var isExtendsValidate = true;	//如果要试用扩展表单验证的话，该属性一定要申明
function extendsValidate(){	//函数名称，固定写法
	
	//密码匹配验证
	if( $('#password').val() == $('#rpassword').val() ){	//匹配成功
		$('#rpassword').validate_callback(null,"sucess");	//此次是官方提供的，用来消除以前错误的提示
	}else{//匹配失败
		$('#rpassword').validate_callback("密码不匹配","failed");	//此处是官方提供的API，效果则是当匹配不成功，pwd2表单 显示红色标注，并且TIP显示为“密码不匹配”
		return false;
	}
	

	
	
}
      </script>
  </head>
  
  <body>

<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">


<div id="main">
	<div class="content mt5">
	   <div class="register">
	   <div class="top"><span id="activeemailmsg"></span></div>
	   <form id="myform_register" name="register" action="register.action" method="post">
				<div class="registerbox">
					<div class="reg_list1">
			        	<div class="reg_div1 ">
			        		<p><code>*</code> 请填写您的Email地址：</p>
			        		<cite><input onfocus="clearMsg(3)" type="text" id="email" name="email" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如ostocy@sina.com" ></cite>
			        		<div id="EmailMsg"></div>
			        	</div>
			        	<div class="reg_div1">
			        		<p><code>*</code> 请设置您的用户名：</p>
			        		<cite><input onfocus="clearMsg(1)" type="text" id="username" name="username" reg="^\w{6,20}$" tip="6-20位字符，可由中文、英文、数字及“_”组成"></cite>
			        		<div id="usernameMsg"></div>
			        	</div>
			        	<div class="reg_div1">
			        		<p><code>*</code> 请设定您的登录密码：</p>
			        		<cite><input onfocus="clearMsg(2)" type="password" name="password" id="password" reg="^\w{6,16}$" tip="密码请设为6-16为字母或数字">
			        		</cite><div id="passwordMsg"></div>
			        	</div>
			        	<div class="reg_div1"><p><code>*</code> 请再次输入设定密码：</p><cite><input type="password" onkeypress="clearMsg(this);" onblur="checkPwd2(this);" id="rpassword" name="rpassword"></cite><div id="password2Msg" class="accept"></div></div>
			        	<div class="reg_div2">
			        		<p><code>*</code> 请输入验证码：</p>
			        		<cite><input onfocus="clearMsg(2)" style="width:74px;" name="rand" id="rand"></cite>
			        		<em><img id="random" src="rand.action" onclick="changeValidateCode(this)"/>
			        		</em>
			        		<div id="validateCodeMsg"></div>
			        	</div>
			        	<div class="reg_div3"><p><input type="checkbox" name="checkbox" onclick="validateInput(this);" id="checkBox" checked=""></p><cite><a href="#">我已阅读并同意《欧斯塔克网上商城服务条款》</a></cite></div>
			        	<div class="reg_div4"><input type="image" src="${basepath}/ui/default/images/newuserbtn1.gif" id="submitBtn"></div>
			        	<div id="afterMsg" style="display:none;width:100px;margin-left:180px;margin-top:15px;" class="present"></div>
			        </div>
			    </div>
			  </form>
		
			 <div class="reg_foot"><p><img src="${basepath}/ui/default/images/reg_foot_l.gif"></p><cite><img src="${basepath}/ui/default/images/reg_foot_r.gif"></cite></div>
		  </div>
	</div> 
</div>


<#include "/WEB-INF/theme/default/shop/footer.ftl">
 <script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>   
</body>
</html>
