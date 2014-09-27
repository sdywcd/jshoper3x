<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("intro") != null ? request.getParameter("intro") : "";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>静态化内容 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">静态化内容 </a> <a
				class="brand2">静态化内容</a>
		</div>

	</div>
	<div class="container-fluid containerb">

		<div class="row-fluid">

			<div class="span2">
				<!-- 引入左侧导航 -->
				<%@include file="/admin/left.jsp"%>
			</div>

			<div id="mainlogic" class="span10">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>说明</strong> 请根据需要静态化内容
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div class="line-dotted"></div>
				<div class="btn-group">
					<button id="btnback" type="button" class="btn btn-success">返回</button>
				</div>
				<!-- 开始显示商品类型form表单 -->
				<div class="form-actions">
					<div class="well">
						<h4>重新生成模板文件</h4>
					</div>
					<div id="modifygoodscategory" class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="recreatetemplate"
							name="recreatetemplate" value="开始重新生成模板文件" />
					</div>
					<div class="well">
						<h4>静态化全站</h4>
					</div>
					<div id="modifygoodscategory" class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="startbuildallhtml"
							name="startbuildallhtml" value="开始静态化全站" />
					</div>
					<div class="well">
						<h4>首页静态化</h4>
					</div>
					<div id="modifygoodscategory" class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="startbuildindexhtml"
							name="startbuildindexhtml" value="开始静态化首页" />
					</div>
					<div class="well">
						<h4>静态化商品</h4>
					</div>
					<div id="selectgoodscategory" class="form-inline">
						<span class="label label-required">选择商品分类: </span> <select
							id="navid" name="navid"></select>
						<!-- 顶级分类一级分类 -->
						<select id="ltypeid" name="ltypeid"></select>
						<!-- 二级分类 -->
						<select id="stypeid" name="stypeid"></select>
						<!-- 三级分类 -->
						<span class="label label-info">请选择一个商品分类进行静态化</span>

					</div>
					<div id="modifygoodscategory" class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="startbuildgoodshtml"
							name="startbuildgoodshtml" value="开始静态化商品" />
					</div>
					<div id="modifygoodscategory" class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="startbuildallgoodshtml"
							name="startbuildallgoodshtml" value="开始静态化全部商品" />
					</div>
					
					<div class="well">
						<h4>静态化文章内容</h4>
					</div>
					<div id="selectarticlecategory" class="form-inline">
						<span class="label label-required">选择文章分类: </span>
							<select id="articlenavid" name="articlenavid"></select>
							<!-- 顶级分类一级分类 -->
							<select id="articleltypeid" name="articleltypeid"></select>
							<!-- 二级分类 -->
							<select id="articlestypeid" name="articlestypeid"></select>
							<!-- 三级分类 -->
						<span class="label label-info">请选择一个文章分类</span>
					</div>
					<div id="modifygoodscategory" class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="startbuildarticleshtml"
							name="startbuildarticleshtml" value="开始静态化文章" />
					</div>
					<div id="modifygoodscategory" class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="startbuildallarticleshtml"
							name="startbuildallarticleshtml" value="开始静态化全部文章" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/pagecontent/staticpageconentmentjs.js"></script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>



