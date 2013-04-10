<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
  <head>

    <title>${jshopbasicinfo.jshopname}用户激活邮件</title>
	<meta name="Author" content="OSTOCY">
	<meta name="Copyright" content="OSTOCY">
	<meta http-equiv="expires" content="0">    
	<#if (jshopbasicinfo.metaKeywords)! != ""><meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/></#if>
	<#if (jshopbasicinfo.metaDes)! != ""><meta name="description" content="${jshopbasicinfo.metaDes}"/></#if>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}/ui/default/css/style_green.css" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}/ui/default/css/form.css" />
    <script type="text/javascript"  src="${basepath}/ui/default/js/jquery1.4.2.js"></script>
    <script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
  	<!--[if IE 6]>
	<style>
	body {behavior: url("${basepath}/ui/default/css/csshover3.htc");}
	</style>
	<![endif]-->
    <script>
	     var uid=$.query.get('uid');
		 if(uid!=""){
			$.post("updateUserstate.action",{"uid":uid},function(data){
				if(data.sucflag){
					$("#myform_register p label").html("用户激活成功访问<a href='${basepath}/index.html'>首页</a>");
				}else{
					$("#myform_register p label").text("非法操作");
				}
			});
		 }
	</script>
  </head>
  
<body>

<div id="top_header">
	<div id="top_header_menu">
	
    </div>
</div>
<div id="header">

	<div id="header_inner" class="fixed">

		<div id="logo">
			<h2>www.soipay.com</h2>
		</div>
		
		<!-- 读取导航菜单 -->
		  <div id="menu">
			
		 </div>
		
		
  </div>
</div>

<div id="main">

	<div id="main_inner" class="fixed">
	  <div id="top_main_inner" class="fixed">
 
      </div>
      
     <div id="primaryContent_columnless">

			<div id="columnA_columnless">
				<div class="register">
				<h3>${(jshopbasicinfo.jshopname)}用户激活状态</h3>
				
				<div id="myform_register">
      			<p>
         			<label></label>
         		    
         		</p>
      			
      			</div>
				</div>
			</div>
		</div>
		<br class="clear" />

	</div>

</div>



	
  </body>
</html>
