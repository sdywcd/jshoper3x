<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlDatacommentcontent = request.getParameter("commentcontent") != null ? request
			.getParameter("commentcontent") : "";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>商品评论设置 &middot; jshoper</title>

</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">商品评论</a> <a
				class="brand2">编辑商品评论</a>
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
					<strong>说明</strong> 请根据需要定义商品评论
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div class="line-dotted"></div>
				<div class="btn-group">
					<button id="btnback" type="button" class="btn btn-success">返回</button>
				</div>
				<div class="form-actions">
					<div class="form-inline">
						<span class="label label-required">选择需评论商品</span>
						<input type="text" id="goodsname" name="goodsname" class="medium" placeholder="搜索商品进行评论" autocomplete="off" />
							<button id="searchgoods" name="searchproduct" class="btn btn-primary" type="button">查询</button>
							<span class="label label-info">输入检索商品</span>
					</div>
				</div>
				<!-- 商品flexigrid -->
				<div id="flexgoodsmanagement">
					<table id="goodsmanagement" style="display: none;"></table>
				</div>
				<!-- 商品评论区域 -->
				<div id="addgoodscommentarea" style="display:;">
					<div class="well">
						<h4>增加商品评论</h4>
					</div>
					<div class="form-actions">
						<div class="form-inline">
							<span class="label label-required">商品对象:</span>
							<input type="text" id="commentgoods" name="commentgoods" class="medium"  readonly />
								<span class="label label-info">请查询并选择需要评论的商品对象</span>
						</div>
						<div class="form-inline">
							<span class="label label-required">商品评论人:</span> <input
								type="text" id="replyorcommentusername" name="replyorcommentusername" class="small" /> <span
								class="label label-info">该项可以填写任意用户名称</span>
						</div>
						<div class="form-inline">
							<span class="label label-required">评论内容:</span>
							<textarea id="commentcontent" name="commentcontent" cols="50"
								rows="12" style="width: 100%; height: 400px; visibility: hidden;"><%=htmlspecialchars(htmlDatacommentcontent)%></textarea>
							<span class="label label-info">评论内容可输入约500个字符</span>
						</div>
						<div class="form-inline">
							<span class="label label-required">该评论分值:</span>
							<input type="radio" id="score" name="score" value="1" checked="checked" />
							<label for="radio-1">1分</label>
							<input type="radio" id="score" name="score" value="2" />
							<label for="radio-2">2分 </label>
							<input type="radio" id="score" name="score" value="3" />
							<label for="radio-3">3分</label>
							<input type="radio" id="score" name="score" value="4" />
							<label for="radio-4">4分 </label>
							<input type="radio" id="score" name="score" value="5" />
							<label for="radio-5">5分</label>
							<input type="radio" id="score" name="score" value="6" />
							<label for="radio-6">6分 </label>
							<input type="radio" id="score" name="score" value="7" />
							<label for="radio-7">7分</label>
							<input type="radio" id="score" name="score" value="8" />
							<label for="radio-8">8分 </label>
							<input type="radio" id="score" name="score" value="9" />
							<label for="radio-9">9分</label>
							<input type="radio" id="score" name="score" value="10" />
							<label for="radio-10">10分 </label>
							<span class="label label-info">分值表示该条评论的价值可用作未来店铺信用和个人信用的基础参数</span>
						</div>
						
						<div class="form-inline">
							<label class="label label-submit"></label> <input type="hidden"
								id="hidgoodsid" name="hidgoodsid" value="" /><input
								class="btn btn-success" type="button" id="submit" name="submit"
								value="提交" /> <input class="btn btn-success" type="button"
								id="update" name="update" value="更新" style="display: none;" />
						</div>
					</div>
				</div>
				<div class="line-dotted"></div>
				
			</div>

		</div>

	</div>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/goods/goodscommentmentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/kindeditor/kindeditor-min.js"></script>
	<script type="text/javascript">
		KE.show({
			id : 'commentcontent',
			items : ['fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist','insertunorderedlist']
		});
		
	</script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>

