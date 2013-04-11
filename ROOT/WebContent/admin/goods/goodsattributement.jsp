<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
    <title>商品属性设置 &middot; jshoper</title>
   
  </head>
  
  <body data-spy="scroll" data-target=".subnav" data-offset-top="40">
		<!-- header 包含头部导航-->
		<%@include file="/admin/header.jsp"%>
		<!-- end header -->
		<div class="navbar">
            <div class="navbar-innert">
	            <a class="brand" href="#"><img src="<%=basePath%>admin/ui/assets/img/logo.png" width="175" height="30" alt=""></a>
	            <a class="brand" href="#">商品属性</a>
				<a class="brand2">所有商品属性列表</a>
            </div>
			<div class="subnav" data-spy="affix" data-offset-top="40">
			    <ul class="nav nav-pills">
			      <li><a href="#typography">Typography</a></li>
			      <li><a href="#code">Code</a></li>
			      <li><a href="#tables">Tables</a></li>
			      <li><a href="#forms">Forms</a></li>
			      <li><a href="#buttons">Buttons</a></li>
			      <li><a href="#icons">Icons by Glyphicons</a></li>
			    </ul>
			</div>
    	</div>
    	<div class="container-fluid containerb">
			
		    <div class="row-fluid">
			
		    <div class="span2">
				<!-- 引入左侧导航 -->
				<%@include file="/admin/left.jsp"%>
		    </div>
			
		    <div class="span10">
	            <div class="alert alert-success">
	              <button type="button" class="close" data-dismiss="alert">×</button>
	              <strong>Well done!</strong> You successfully read this important alert message.
	            </div>
			<div class="input-append">
			    <input class="span2" id="appendedInputButtons" type="text">
			    <button class="btn" type="button"><i class="icon-search"></i></button>
			    <button class="btn" type="button"><i class="icon-remove"></i></button>
		    </div>
			<div class="line-dotted"></div>
				<!-- flexigrid -->
				<div id="flexgoodsattributenmanagement">
			    	<table id="goodsattributenmanagement" style="display:none;" ></table>
				</div>
			<div class="line-dotted"></div>
			<div class="pagination">
			    <ul>
			    <li><a href="#">Prev</a></li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">Next</a></li>
			    </ul>
		    </div>
			<div class="line-dotted"></div>
				<h4>销量 Top 5</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
		          <li><a href="#dropdowns"><span class="badge badge-success">1</span> 西牧狼商务英伦复古牛皮</a></li>
		          <li><a href="#buttonGroups"><span class="badge badge-warning">2</span> 限量300台送UV镜！特价尼康 D3200！</a></li>
		          <li><a href="#buttonDropdowns"><span class="badge badge-important">3</span> 电子书刊畅读卡（季度卡）赠《攻心话术》！</a></li>
		          <li><a href="#navs"><span class="badge badge-info">4</span> ayhke磨砂牛皮保暖棉鞋</a></li>
		          <li><a href="#navbar"><span class="badge badge-inverse">5</span> E人E本T4 WIFI版</a></li>
		        </ul>
					<div class="line-dotted"></div>
				<h4>销量 Top 5</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
		          <li><a href="#dropdowns"><span class="badge badge-success">1</span> 西牧狼商务英伦复古牛皮</a></li>
		          <li><a href="#buttonGroups"><span class="badge badge-warning">2</span> 限量300台送UV镜！特价尼康 D3200！</a></li>
		          <li><a href="#buttonDropdowns"><span class="badge badge-important">3</span> 电子书刊畅读卡（季度卡）赠《攻心话术》！</a></li>
		          <li><a href="#navs"><span class="badge badge-info">4</span> ayhke磨砂牛皮保暖棉鞋</a></li>
		          <li><a href="#navbar"><span class="badge badge-inverse">5</span> E人E本T4 WIFI版</a></li>
		        </ul>
			
					<div class="line-dotted"></div>
				<h4>销量 Top 5</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
		          <li><a href="#dropdowns"><span class="badge badge-success">1</span> 西牧狼商务英伦复古牛皮</a></li>
		          <li><a href="#buttonGroups"><span class="badge badge-warning">2</span> 限量300台送UV镜！特价尼康 D3200！</a></li>
		          <li><a href="#buttonDropdowns"><span class="badge badge-important">3</span> 电子书刊畅读卡（季度卡）赠《攻心话术》！</a></li>
		          <li><a href="#navs"><span class="badge badge-info">4</span> ayhke磨砂牛皮保暖棉鞋</a></li>
		          <li><a href="#navbar"><span class="badge badge-inverse">5</span> E人E本T4 WIFI版</a></li>
		        </ul>
			
					<div class="line-dotted"></div>
				<h4>销量 Top 5</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
		          <li><a href="#dropdowns"><span class="badge badge-success">1</span> 西牧狼商务英伦复古牛皮</a></li>
		          <li><a href="#buttonGroups"><span class="badge badge-warning">2</span> 限量300台送UV镜！特价尼康 D3200！</a></li>
		          <li><a href="#buttonDropdowns"><span class="badge badge-important">3</span> 电子书刊畅读卡（季度卡）赠《攻心话术》！</a></li>
		          <li><a href="#navs"><span class="badge badge-info">4</span> ayhke磨砂牛皮保暖棉鞋</a></li>
		          <li><a href="#navbar"><span class="badge badge-inverse">5</span> E人E本T4 WIFI版</a></li>
		        </ul>
			
		    </div>
			
		    </div>
		
	    </div>
    	<script type="text/javascript" src="<%=basePath%>admin/js/goods/goodsattributementjs.js"></script>
		<%@include file="/admin/footer.jsp"%>
		
  </body>
</html>
					
   	 