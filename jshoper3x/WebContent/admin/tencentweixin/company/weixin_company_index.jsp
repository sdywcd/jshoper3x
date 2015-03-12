<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>首页 &middot; jshoper</title>

</head>
<body>
	<!-- header 包含头部导航-->
	<%@include file="/admin/tencentweixin//header.jsp"%>

	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""> </a> <a class="brand" href="#">欢迎登录微信企业号后台管理系统</a>
		</div>
	</div>
	<div class="container-fluid containerb">

		<div class="row-fluid">

			<div class="span2">
				<a href="#" class="thumbnail"><img
					src="<s:property value="#session.admin.headpath"/>" alt=""
					class="caption"> </a>
				<div class="well well-small smallt">
					<h4><s:property value="#session.admin.realname"/> ，你好！</h4>
					<p>
						欢迎您再次来到<br />微信企业号后台管理
					</p>
					<button class="btn btn-block btn-primary" type="button">我的工作</button>
				</div>


				<div class="line-dotted"></div>
				<!-- 引入左侧导航 -->
				<%@include file="/admin/left.jsp"%>

			</div>

			<div class="span10">
				<div class="row-fluid">
					<ul class="thumbnails">
						<li class="span2"><a
							href="<%=basePath%>admin/goods/goods.jsp?operate=add"
							class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-edit.png"
								alt="" class="caption">
								<h4>企业号设置</h4> </a></li>
						<li class="span2"><a
							href="<%=basePath%>admin/pagecontent/articlement.jsp?operate=find"
							class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-article.png"
								alt="" class="caption">
								<h4>通讯录</h4> </a></li>
						<li class="span2"><a
							href="<%=basePath%>admin/goods/goodscategoryment.jsp?operate=find"
							" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-category.png"
								alt="" class="caption">
								<h4>企业部门</h4> </a></li>
					</ul>
				</div>
				<!-- 新的模块页面 -->
				<style type="text/css">
					.home,#Profile,#Messages{
						margin-left: 0;
					}
					.home .span2{
						margin-top:1.388%;
						text-align: center;
					}
					.tab-content{
						margin-bottom: 3.6%;
					}
				</style>
				<!-- tag -->
				 <ul id="mytab" class="nav nav-tabs">
				 	<li class="active"><a href="#Home" data-toggle="tab">微信考勤</a></li>
				 </ul>
				<!-- /tag -->
				<div  class="tab-content">
			        <div class="tab-pane fade in active home">
			        	<li class="span2">
							<a href="<%=basePath%>admin/goods/goodstypetnment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-banner.png"	alt="" class="caption">
								<h4>考勤规则</h4>
							</a>
						</li>
						<li class="span2">
							<a href="<%=basePath%>admin/goods/goodsattributement.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-banner-categories.png"	alt="" class="caption">
								<h4>考勤地址</h4>
							</a>
						</li>
						<li class="span2">
							<a href="<%=basePath%>admin/brands/brandsment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-banner-client.png"	alt="" class="caption">
								<h4>考勤统计</h4>
							</a>
						</li>
						<li class="span2">
							<a href="<%=basePath%>admin/goods/goodstypetnbrandsment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-banner-tracks.png"	alt="" class="caption">
								<h4>考勤设置</h4>
							</a>
						</li>
			        </div>
				</div>
				<!-- tag -->
				 <ul id="mytab" class="nav nav-tabs">
				 	<li class="active"><a href="#Home" data-toggle="tab">微信请假</a></li>
				 </ul>
				<!-- /tag -->
				<div  class="tab-content">
			        <div class="tab-pane fade in active home">
			       	 	<li class="span2">
							<a href="<%=basePath%>admin/order/normalorderstobeshippedunpayment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-stats.png"	alt="" class="caption">
								<h4>请假查询</h4>
							</a>
						</li>
			        	<li class="span2">
							<a href="<%=basePath%>admin/order/normalorderstobeshippedunpayment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-stats.png"	alt="" class="caption">
								<h4>请假类型设置</h4>
							</a>
						</li>
						<li class="span2">
							<a href="<%=basePath%>admin/order/normalorderstobeshippedhavepayment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-stats.png"	alt="" class="caption">
								<h4>员工假期设置</h4>
							</a>
						</li>
						<li class="span2">
							<a href="<%=basePath%>admin/order/normalorderstobeshippedhavepayment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-stats.png"	alt="" class="caption">
								<h4>请假审核人设置</h4>
							</a>
						</li>
			        </div>
				</div>
				<!-- tag -->
				 <ul id="mytab" class="nav nav-tabs">
				 	<li class="active"><a href="#Home" data-toggle="tab">微信CRM</a></li>
				 </ul>
				<!-- /tag -->
				<div  class="tab-content">
			        <div class="tab-pane fade in active home">
			       	 	<li class="span2">
							<a href="<%=basePath%>admin/order/normalorderstobeshippedunpayment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-stats.png"	alt="" class="caption">
								<h4>客户资料录入</h4>
							</a>
						</li>
			        	<li class="span2">
							<a href="<%=basePath%>admin/order/normalorderstobeshippedunpayment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-stats.png"	alt="" class="caption">
								<h4>客户资料列表</h4>
							</a>
						</li>
						
			        </div>
				</div>

			</div>


		</div>

	</div>



	<!-- footer -->
	<%@include file="/admin/footer.jsp"%>
</body>
</html>