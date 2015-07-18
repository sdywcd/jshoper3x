<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>支付方式设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">支付方式</a> <a
				class="brand2">支付方式浏览</a>
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
					<strong>说明</strong> 请填写支付信息
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>

				<div class="line-dotted"></div>
				<div class="btn-group">
					<button id="btnback" type="button" class="btn btn-success">返回</button>
				</div>
				<!-- 开始显示form表单 -->
				<div class="form-actions">
					<div class="form-inline">
						<span class="label label-required">支付方式名称:</span> <input
							type="text" id="paymentname" name="paymentname" /> <span
							class="label label-info">目前仅支持支付宝</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">支付方式代码:</span> <input
							type="text" id="paymentCode" name="paymentCode" />
					</div>
					<div class="form-inline">
						<span class="label label-required">支付费率:</span> <input type="text"
							id="paymentFree" name="paymentFree" />
					</div>
					<div class="form-inline">
						<span class="label label-required">接口类型(支付宝):</span> <select
							id="paymentInterface" name="paymentInterface">
							<option value="1">即时到帐收款接口</option>
							<option value="2">担保交易收款接口</option>
							<option value="3">双功能收款接口</option>
							<option value="4">网银支付接口</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">账号:</span> <input type="text"
							id="account" name="account" />
					</div>
					<div class="form-inline">
						<span class="label label-required">安全效验码:</span> <input
							type="text" id="safecode" name="safecode" />
					</div>
					<div class="form-inline">
						<span class="label label-required">合作者身份ID:</span> <input
							type="text" id="partnerid" name="partnerid" />
					</div>

					<div class="form-inline">
						<span class="label label-required">快捷支付:</span> <select
							id="isFast" name="isFast">
							<option value="1">支持</option>
							<option value="0">不支持</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">描述:</span> <input type="text"
							id="des" name="des" class="small" />
					</div>

					<div class="form-inline">
						<span class="label label-required">使用:</span> <select id="state"
							name="state">
							<option value="1">是</option>
							<option value="2">否</option>
						</select>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							style="display: none;" id="update" name="update" value="更新"></input>
						<input type="hidden" id="paymentid" name="paymentid" value="" />
					</div>

				</div>


			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/setting/paymentmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>

