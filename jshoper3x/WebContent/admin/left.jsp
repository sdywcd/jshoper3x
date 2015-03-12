<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<body>

	<div class="well well-small">
		<ul class="nav nav-list">
			<li class="nav-header">自定义快捷菜单</li>
			<li><a
				href="<%=basePath%>admin/goods/goodstypetnment.jsp?operate=find">商品类型参数设置</a></li>
			<li><a
				href="<%=basePath%>admin/goods/goodsattributement.jsp?operate=find">商品属性设置
			</a></li>
			<li><a
				href="<%=basePath%>admin/products/productspecificationment.jsp?operate=find">商品规格设置
			</a></li>
			<li><a
				href="<%=basePath%>admin/goods/goodscategoryment.jsp?operate=find">商品分类设置
			</a></li>
			<li><a
				href="<%=basePath%>admin/goods/goodsment.jsp?operate=find">商品列表</a>
			</li>
		</ul>
	</div>
	
	<div class="well well-small">
		<ul class="nav nav-list">
			<li class="nav-header">你可以</li>
			<li><a target="_blank"
				href="https://github.com/sdywcd/jshoper3x">在github上关注我们</a></li>
			<li><a target="_blank"
			href="http://www.jshoper.org">在jshoperx官网了解我们更多</a></li>
		</ul>
	</div>
</body>