
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String pathb = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathb + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>首页 &middot; jshoper</title>
<!-- Le styles -->
<link href="<%=basePath%>admin/ui/assets/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/docs.css" rel="stylesheet">
<link
	href="<%=basePath%>admin/ui/assets/js/google-code-prettify/prettify.css"
	rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/base.css" rel="stylesheet">
<link
	href="<%=basePath%>admin/js/plugins/icheckmaster/skins/square/blue.css"
	rel="stylesheet">


<!-- import flexigrid css -->
<link
	href="<%=basePath%>admin/js/plugins/flexigrid/css/flexigrid/flexigrid_blue.css"
	rel="stylesheet" type="text/css">
<!-- import uploader css -->
<link href="<%=basePath%>admin/js/plugins/uploader/fileuploader.css"
	rel="stylesheet">
<!-- import  farbtastic css-->
<link href="<%=basePath%>admin/js/plugins/farbtastic/farbtastic.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="shortcut icon"
	href="<%=basePath%>admin/ui/assets/ico/favicon.ico">
</head>
<body>
	<!-- Navbar================================================== -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".navbar-inverse-collapse"> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="nav-collapse collapse navbar-inverse-collapse">
					<ul class="nav">
						<li class="active"><a href="<%=basePath%>admin/index.jsp">主页</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">实验室 <b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li class="nav-header">未上市产品</li>
							<li><a href="/admin/tencentweixin/company/weixin_company_index.jsp"><i class="icon-globe"></i>微信OA</a></li>
						</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">管理 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="icon-star"></i> 授权</a></li>
								<li><a href="#"><i class="icon-wrench"></i> 技术支持</a></li>
							
							</ul></li>

					</ul>
					<ul class="nav pull-right">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> 商品管理 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="<%=basePath%>admin/goods/goodstypetnment.jsp?operate=find">商品类型参数设置
								</a></li>
								<li><a
									href="<%=basePath%>admin/goods/goodsattributement.jsp?operate=find">商品属性设置</a></li>
								<li><a
									href="<%=basePath%>admin/brands/brandsment.jsp?operate=find">品牌设置</a></li>
								<li><a
									href="<%=basePath%>admin/goods/goodstypetnbrandsment.jsp?operate=find">品牌类型设置
								</a></li>
								<li><a
									href="<%=basePath%>admin/products/productspecificationment.jsp?operate=find">商品规格设置
								</a></li>
								<li><a
									href="<%=basePath%>admin/goods/goodscategoryment.jsp?operate=find">商品分类设置
								</a></li>
								<li class="divider"></li>
								<li><a
									href="<%=basePath%>admin/goods/goods.jsp?operate=add">添加新商品
								</a></li>
								<li><a
									href="<%=basePath%>admin/goods/goodsment.jsp?operate=find">所有商品
								</a></li>
								<li class="divider"></li>
								<li><a
									href="<%=basePath%>admin/goods/goodsbelinkedsale.jsp?operate=add">添加关联销售商品
								</a></li>
								<li><a
									href="<%=basePath%>admin/goods/goodsbelinkedsalement.jsp?operate=find">关联销售商品设置
								</a></li>
								<!--  <li><a href="#">团购商品 </a></li>
								<li><a href="#">团购订单管理 </a></li>-->
								<!-- <li class="dropdown-submenu"><a tabindex="-1" href="#">商品列表</a>
									<ul class="dropdown-menu">
									
										<li><a tabindex="-1" href="#">仓库商品</a></li> 
									</ul>
								</li>-->
								<li class="divider"></li>
								<li><a
									href="<%=basePath%>admin/goods/goodscomment.jsp?operate=add">添加商品评论</a></li>
								<li><a
									href="<%=basePath%>admin/goods/goodscommentment.jsp?operate=find">商品评论</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> 订单管理 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li class="dropdown-submenu"><a tabindex="-1"
									href="<%=basePath%>admin/order/normalordersment.jsp?operate=find">普通订单</a>
									<ul class="dropdown-menu">
										<li><a tabindex="-1"
											href="<%=basePath%>admin/order/normalorderstobeshippedunpayment.jsp?operate=find">未付款——货到付款订单</a></li>
										<li><a tabindex="-1"
											href="<%=basePath%>admin/order/normalorderstobeshippedhavepayment.jsp?operate=find">已付款——需发货订单</a></li>
									</ul></li>

								<li class="dropdown-submenu"><a tabindex="-1"
									href="<%=basePath%>admin/order/grouponordersment.jsp?operate=find">团购订单</a>
									<ul class="dropdown-menu">
										<li><a tabindex="-1"
											href="<%=basePath%>admin/order/grouponorderstobeshippedhavepayment.jsp?operate=find">已付款——需发货团购订单</a></li>

									</ul></li>
								<li class="dropdown-submenu"><a tabindex="-1"
									href="<%=basePath%>admin/order/auctionordersment.jsp?operate=find">拍卖订单</a>
									<ul class="dropdown-menu">
										<li><a tabindex="-1"
											href="<%=basePath%>admin/order/auctionorderstobeshippedhavepayment.jsp?operate=find">已付款——需发货拍卖订单</a></li>

									</ul></li>
								<li class="dropdown-submenu"><a tabindex="-1"
									href="<%=basePath%>admin/order/mobileordersment.jsp?operate=find">手机订单</a>
									<ul class="dropdown-menu">
										<li><a tabindex="-1"
											href="<%=basePath%>admin/order/mobileorderstobeshippedunpayment.jsp?operate=find">未付款——货到付款手机订单</a></li>
										<li><a tabindex="-1"
											href="<%=basePath%>admin/order/mobileorderstobeshippedhavepayment.jsp?operate=find">已付款——需发货手机订单</a></li>

									</ul></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">会员管理 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="<%=basePath%>admin/member/membergroup.jsp?operate=add">添加会员分组</a></li>
								<li><a
									href="<%=basePath%>admin/member/membergroupment.jsp?operate=find">会员分组列表</a></li>
								<li><a
									href="<%=basePath%>admin/member/member.jsp?operate=add">添加会员</a></li>
								<li><a
									href="<%=basePath%>admin/member/memberment.jsp?operate=find">会员列表</a></li>
								<li><a
									href="<%=basePath%>admin/member/membergradement.jsp?operate=find">会员等级设置</a></li>
								<li><a
									href="<%=basePath%>admin/member/memberrechargement.jsp?operate=find">会员充值中心</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> 内容管理 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="<%=basePath%>admin/pagecontent/sitenavigationment.jsp?operate=find">导航设置</a></li>
								<li><a
									href="<%=basePath%>admin/pagecontent/articlecategoryment.jsp?operate=find">文章分类设置</a></li>
								<li><a
									href="<%=basePath%>admin/pagecontent/article.jsp?operate=add">添加文章</a></li>
								<li><a
									href="<%=basePath%>admin/pagecontent/articlement.jsp?operate=find">所有文章</a></li>
								<li><a
									href="<%=basePath%>admin/pagecontent/staticpagecontent.jsp?operate=find">静态化内容</a></li>
								<!-- <li><a
									href="<%=basePath%>admin/pagecontent/advertise.jsp?operate=add">添加广告</a></li>
									<li><a
									href="<%=basePath%>admin/pagecontent/articlement.jsp?operate=find">所有广告列表</a></li> -->
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> 素材管理 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="<%=basePath%>admin/material/imagematerialment.jsp?operate=find">图片素材列表</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> 系统设置 <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="<%=basePath%>admin/setting/basicinfoment.jsp?operate=find">商城信息设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/emailment.jsp?operate=find">邮箱设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/globalparamset.jsp?operate=find">全局参数设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/paymentment.jsp?operate=find">支付方式设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/logisticsment.jsp?operate=find">物流及配送设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/templatethemement.jsp?operate=find">模板主题设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/templatement.jsp?operate=find">模板文件设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/templatesetment.jsp?operate=find">模板文件和系统内容设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/modulement.jsp?operate=find">系统模块设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/functionment.jsp?operate=find">模块功能设置</a></li>
								<li><a
									href="<%=basePath%>admin/setting/rolement.jsp?operate=find">角色权限设置</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>

		</div>
		<!-- /navbar-inner -->
	</div>


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=basePath%>admin/ui/assets/js/jquery.js"></script>
	<script
		src="<%=basePath%>admin/ui/assets/js/google-code-prettify/prettify.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-transition.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-alert.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-modal.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-dropdown.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-scrollspy.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-tab.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-tooltip.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-popover.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-button.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-collapse.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-carousel.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-typeahead.js"></script>

	<script
		src="<%=basePath%>admin/js/plugins/icheckmaster/jquery.icheck.min.js"></script>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/flexigrid/myflexigrid.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/jquery.query.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/validatorjs/validator.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>admin/js/indexjs.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/base.js"></script>


</body>
</html>
