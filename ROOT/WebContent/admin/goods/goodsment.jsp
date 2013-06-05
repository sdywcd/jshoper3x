<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
    <title>商品列表 &middot; jshoper</title>
   
  </head>
  
  <body data-spy="scroll" data-target=".subnav" data-offset-top="40">
		<!-- header 包含头部导航-->
		<%@include file="/admin/header.jsp"%>
		<!-- end header -->
		<div class="navbar">
            <div class="navbar-innert">
	            <a class="brand" href="#"><img src="<%=basePath%>admin/ui/assets/img/logo.png" width="175" height="30" alt=""></a>
	            <a class="brand" href="#">商品</a>
				<a class="brand2">所有商品列表</a>
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
				<div id="flexgoodsmanagement">
			    	<table id="goodsmanagement" style="display:none;" ></table>
				</div>
			<div class="line-dotted"></div>
			
			
			
		    </div>
			
		    </div>
		
	    </div>
    	<script type="text/javascript" src="<%=basePath%>admin/js/goods/goodsmentjs.js"></script>
		<%@include file="/admin/footer.jsp"%>
		
  </body>
</html>
					
   	 