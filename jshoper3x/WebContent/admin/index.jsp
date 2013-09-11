<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""> </a> <a class="brand" href="#">欢迎登录后台管理系统</a>
		</div>
	</div>
	<div class="container-fluid containerb">

		<div class="row-fluid">

			<div class="span2">
				<a href="#" class="thumbnail"><img
					src="http://i.360buy.com/commons/img/no-img_mid_.jpg" alt=""
					class="caption"> </a>
				<div class="well well-small smallt">
					<h4>陈达，你好！</h4>
					<p>
						上次登录时间<br />2012年12月18日15:01:25
					</p>
					<button class="btn btn-block btn-primary" type="button">我的jshooper</button>
				</div>


				<div class="line-dotted"></div>
				<!-- 引入左侧导航 -->
				<%@include file="left.jsp"%>

			</div>

			<div class="span7">
				<div class="row-fluid">
					<ul class="thumbnails">
						<li class="span2"><a
							href="<%=basePath%>admin/goods/goods.jsp?operate=add"
							class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-article-add.png"
								alt="" class="caption">
								<h4>添加产品</h4> </a></li>
						<li class="span2"><a
							href="<%=basePath%>admin/pagecontent/articlement.jsp?operate=find"
							class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-article.png"
								alt="" class="caption">
								<h4>文章管理</h4> </a></li>
						<li class="span2"><a
							href="<%=basePath%>admin/goods/goodscategoryment.jsp?operate=find"
							" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-category.png"
								alt="" class="caption">
								<h4>分类管理</h4> </a></li>
						<li class="span2"><a href="#" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-menumgr.png"
								alt="" class="caption">
								<h4>图片管理</h4> </a></li>
						<li class="span2"><a href="#" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-user.png"
								alt="" class="caption">
								<h4>会员管理</h4> </a></li>
						<li class="span2"><a href="<%=basePath%>admin/setting/basicinfoment.jsp?operate=find" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-config.png"
								alt="" class="caption">
								<h4>基本设置</h4> </a></li>
					</ul>
				</div>


				<h4>系统运行信息</h4>
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="left_2">系统版本号：</td>
							<td>jshoper Enterprise 4.6.0.0 <a href="#"><span
									class="label label-info">有可用的更新！</span> </a>
							</td>
						</tr>
						<tr>
							<td>系统启动时间：</td>
							<td>2012年12月18日15:19:26</td>
						</tr>
						<tr>
							<td>系统已运行时间：</td>
							<td>2012-12-18 15:20:08</td>
						</tr>
						<tr>
							<td>系统CUP使用率：</td>
							<td>0.12% <span class="badge badge-warning">!</span>
							</td>
						</tr>
						<tr>
							<td>系统分配的物理内存量：</td>
							<td>124.56MB</td>
						</tr>
						<tr>
							<td>缓存对象数：</td>
							<td>87</td>
						</tr>
					</tbody>
				</table>
				<div class="line-dotted"></div>
				<h4>系统运行环境</h4>
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="left_2">java版本：</td>
							<td>6.15</td>
						</tr>
						<tr>
							<td>apache版本：</td>
							<td>2.12</td>
						</tr>
						<tr>
							<td>操作系统：</td>
							<td>Microsoft Windows 2003 (Microsoft Windows NT 5.2.3790
								Service Pack 2)</td>
						</tr>
						<tr>
							<td>数据库版本：</td>
							<td>Mysql Express Edition</td>
						</tr>
						<tr>
							<td>数据库版本号：</td>
							<td>9.00.15</td>
						</tr>
						<tr>
							<td>数据库大小：</td>
							<td>数据库:9 M / 日志:16 M</td>
						</tr>
					</tbody>
				</table>

			</div>

			<div class="span3">
				<h4>更新 New 5</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
					<li><a href="#dropdowns">最后400台！超值佳能5D Mark I </a></li>
					<li><a href="#buttonGroups">酷冷至尊战斧二代主动式40</a></li>
					<li><a href="#buttonDropdowns">康佳 LED 32英寸 高清窄边</a></li>
					<li><a href="#navs">换季清仓19.9元抢限量红叶雨伞</a></li>
					<li><a href="#navbar">专车专用全包围手缝脚垫</a></li>
				</ul>
				<div class="line-dotted"></div>
				<h4>销量 Top 5</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
					<li><a href="#dropdowns"><span class="badge badge-success">1</span>
							西牧狼商务英伦复古牛皮</a></li>
					<li><a href="#buttonGroups"><span
							class="badge badge-warning">2</span> 限量300台送UV镜！特价尼康 D3200！</a></li>
					<li><a href="#buttonDropdowns"><span
							class="badge badge-important">3</span> 电子书刊畅读卡（季度卡）赠《攻心话术》！</a></li>
					<li><a href="#navs"><span class="badge badge-info">4</span>
							ayhke磨砂牛皮保暖棉鞋</a></li>
					<li><a href="#navbar"><span class="badge badge-inverse">5</span>
							E人E本T4 WIFI版</a></li>
				</ul>


			</div>

		</div>

	</div>



	<!-- footer -->
	<%@include file="footer.jsp"%>
</body>
</html>