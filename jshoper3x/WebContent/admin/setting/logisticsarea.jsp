<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>物流商区域价格&middot; jshoper</title>

</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">物流商区域价格</a> <a
				class="brand2">编辑物流商区域价格</a>
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
					<strong>说明</strong> 请根据需要编辑物流商区域价格
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
						<span class="label label-required">计算模式:</span> <select
							id="costway" name="costway">
							<option value="1">按重量计算</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">标准运费:</span> <input type="text"
							id="normalcost" name="normalcost" value="5" /> <span
							class="label label-info">在按重量计算模式下，最低运费为5元</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">标准重量:</span> <input type="text"
							id="normalvalue" name="normalvalue" value="5" /> <span
							class="label label-info">在【标准费用】下的重量例如小于5kg的使用标准费用，超出的重量采用续重计算</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">续费基准:</span> <input type="text"
							id="overcost" name="overcost" value="10" /> <span
							class="label label-info">超出标准计费模式后续费10元</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">续重基准:</span> <input type="text"
							id="overvalue" name="overvalue" value="1" /> <span
							class="label label-info">每1kg续费10元</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">配送地区:</span> <input type="text"
							id="sendarea" name="sendarea" value="" /> <span
							class="label label-info">例如上海</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">使用状态:</span> <select id="state"
							name="state">
							<option value="1">启用</option>
							<option value="0">禁用</option>
						</select>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;"></input>
						<input type="hidden" id="logbusareaid" name="logbusareaid"
							value=""></input> <input type="hidden" id="logisticsid"
							name="logisticsid" value=""></input>
					</div>

				</div>
			</div>

		</div>

	</div>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/setting/logisticsareamentjs.js"></script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>

