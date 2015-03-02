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
	<%@include file="header.jsp"%>

	<div class="navbar">
		<div class="navbar-innert">
			 <a class="brand" href="#">欢迎登录店铺后台管理系统</a>
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
						欢迎您再次来到<br />Jshoper3o
					</p>
					<button class="btn btn-block btn-primary" type="button">我的工作</button>
				</div>


				<div class="line-dotted"></div>
				<!-- 引入左侧导航 -->
				<%@include file="left.jsp"%>

			</div>

			<div class="span7">
				<div class="row-fluid">
					<ul class="thumbnails">
						<li class="span2"><a
							href="<%=basePath%>admin/shop/goods/goods.jsp?operate=add"
							class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-edit.png"
								alt="" class="caption">
								<h4>添加商品</h4> </a></li>
						<li class="span2"><a href="<%=basePath%>admin/shop/member/membergroupment.jsp?operate=find" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-user.png"
								alt="" class="caption">
								<h4>分组管理</h4> </a></li>
						<li class="span2"><a href="<%=basePath%>admin/shop/setting/basicinfoment.jsp?operate=find" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-config.png"
								alt="" class="caption">
								<h4>基本设置</h4> </a></li>
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
				 	<li class="active"><a href="#Home" data-toggle="tab">商品管理</a></li>
				 </ul>
				<!-- /tag -->
				<div  class="tab-content">
			        <div class="tab-pane fade in active home">
						<li class="span2">
							<a href="<%=basePath%>admin/shop/goods/goodscommentment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-levels.png"	alt="" class="caption">
								<h4>商品评论</h4>
							</a>
						</li>
			        </div>
				</div>
				<!-- tag -->
				 <ul id="mytab" class="nav nav-tabs">
				 	<li class="active"><a href="#Home" data-toggle="tab">订单管理</a></li>
				 </ul>
				<!-- /tag -->
				<div  class="tab-content">
			        <div class="tab-pane fade in active home">
			        	<li class="span2">
							<a href="<%=basePath%>admin/shop/order/normalorderstobeshippedunpayment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-stats.png"	alt="" class="caption">
								<h4>货到付款</h4>
							</a>
						</li>
						<li class="span2">
							<a href="<%=basePath%>admin/shop/order/normalorderstobeshippedhavepayment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-stats.png"	alt="" class="caption">
								<h4>需发货</h4>
							</a>
						</li>
			        </div>
				</div>
				<!-- tag -->
				 <ul id="mytab" class="nav nav-tabs">
				 	<li class="active"><a href="#Home" data-toggle="tab">会员管理</a></li>
				 </ul>
				<!-- /tag -->
				<div  class="tab-content">
			        <div class="tab-pane fade in active home">
			        	<li class="span2">
							<a href="<%=basePath%>admin/shop/member/member.jsp?operate=add" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-user-add.png"	alt="" class="caption">
								<h4>添加会员</h4>
							</a>
						</li>
						<li class="span2">
							<a href="<%=basePath%>admin/shop/member/membergroup.jsp?operate=add" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-groups-add.png"	alt="" class="caption">
								<h4>添加会员分组</h4>
							</a>
						</li>
			        </div>
				</div>
				
				
			</div>

			<div class="span3">
				<h4>最新需发货订单</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
					<s:iterator id="bean" value="#session.newestorders" status="newestorders">
						<li><a href="InitOrdersDetail.action?orderid=<s:property value="orderid"/>"><s:date name="createtime" format="yyyy-MM-dd hh:mm:ss"/>  <s:property value="ordername"/></a></li>
					</s:iterator>
					
				
				</ul>
				<div class="line-dotted"></div>
				
			</div>

		</div>

	</div>



	<!-- footer -->
	<%@include file="footer.jsp"%>
</body>
</html>