<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>物流及配送设置&middot; jshoper</title>

</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">物流及配送</a> <a
				class="brand2">编辑物流</a>
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
					<strong>说明</strong> 请根据需要编辑物流信息
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
						<span class="label label-required">物流商名称:</span> <input
							type="text" id="logisticsname" name="logisticsname" />
					</div>
					<div class="form-inline">
						<span class="label label-required">城市:</span> <input type="text"
							id="city" name="city" />
					</div>
					<div class="form-inline">
						<span class="label label-required">联系人:</span> <input type="text"
							id="contractor" name="contractor" />
					</div>
					<div class="form-inline">
						<span class="label label-required">座机:</span> <input type="text"
							id="telno" name="telno" />
					</div>
					<div class="form-inline">
						<span class="label label-required">手机:</span> <input type="text"
							id="mobile" name="mobile" />
					</div>
					<div class="form-inline">
						<span class="label label-required">传真:</span> <input type="text"
							id="faxno" name="faxno" />
					</div>
					<div class="form-inline">
						<span class="label label-required">邮箱:</span> <input type="text"
							id="email" name="email" />
					</div>
					<div class="form-inline">
						<span class="label label-required">地址:</span> <input type="text"
							id="address" name="address" class="medium" />
					</div>
					<div class="form-inline">
						<span class="label label-required">网址:</span> <input type="text"
							id="website" name="website" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">收款人:</span> <input type="text"
							id="receiver" name="receiver" />
					</div>
					<div class="form-inline">
						<span class="label label-required">银行账号:</span> <input type="text"
							id="bankaccount" name="bankaccount" />
					</div>
					<div class="form-inline">
						<span class="label label-required">所属银行:</span> <input type="text"
							id="bankaddress" name="bankaddress" />
					</div>
					<div class="form-inline">
						<span class="label label-required">保价:</span> <select id="insure"
							name="insure">
							<option value="1">支持</option>
							<option value="0">不支持</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">货到付款:</span> <select id="isCod"
							name="isCod">
							<option value="1">支持</option>
							<option value="0">不支持</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">使用范围:</span> <select id="state"
							name="state">
							<option value="1">用户可见（前台可见）</option>
							<option value="2">物流商可见（后台可见）</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">默认显示:</span> <select
							id="visible" name="visible">
							<option value="1">显示</option>
							<option value="0">隐藏</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">服务范围:</span> <select
							id="sendrange" name="sendrange">
							<option value="1">国际</option>
							<option value="0">国内</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">描述:</span> <input type="text"
							id="des" name="des" class="large" />
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;"></input>
						<input type="hidden" id="logisticsid" name="logisticsid" value=""></input>
					</div>

				</div>
			</div>

		</div>

	</div>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/setting/logisticsmentjs.js"></script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>

