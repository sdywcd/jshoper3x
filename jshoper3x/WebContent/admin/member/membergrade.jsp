<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>会员等级设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">会员等级设置 </a> <a
				class="brand2">编辑会员等级</a>
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
					<strong>说明</strong> 请根据需要编辑会员等级
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
				<!-- 开始会员分组form表单 -->
				<div class="form-actions">
					<div class="form-inline">
						<span class="label label-required">等级类型: </span> 
						<select id="type" name="type">
							<option value="1">信用值</option>
							<option value="2">经验值</option>
						</select>
							<span class="label label-info">购买等行为可以获取到经验值和信用值并升级到对应的信用和经验值称谓</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">等级名称: </span> <input
							id="name" name="name" type="text" value=""
							class="small" /> 
						
					</div>
					<div class="form-inline">
						<span class="label label-required">等级范围开始值: </span> <input
							id="start" name="start" type="text" value=""
							class="small" /> 
							<span class="label label-info">这是取得该等级的最小值</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">等级范围结束值: </span> <input
							id="end" name="end" type="text" value=""
							class="small" /> 
							<span class="label label-info">这是取得该等级的最大值也是进入下一个等级的最小值</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">增量: </span> <input
							id="increment" name="increment" type="text" value=""
							class="small" /> 
							<span class="label label-info">进行会员行为时取得的固定的固定信用或者经验值</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">倍率: </span> <input
							id="multiplypower" name="multiplypower" type="text" value=""
							class="small" /> 
							<span class="label label-info">设置倍率后可以在获取经验和信用是加上乘以这个倍率</span>
					</div>
					
					<div class="form-inline">
						<span class="label label-required">积分兑换比率: </span> <input
							id="mpchangepower" name="mpchangepower" type="text" value=""
							class="small" /> 
							<span class="label label-info">设置在该等级下积分兑换经验值和信用值得比例。格式（1：x）</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">折扣率: </span> <input
							id="discount" name="discount" type="text" value=""
							class="small" /> 
							<span class="label label-info">格式：9.2  8.0 </span>
					</div>
					<div class="form-inline">
						<span class="label label-required">倍率状态:</span> <input
							type="radio" id="mpstate" name="mpstate" value="1"
							checked="checked" /> <label for="radio-1">开启 </label> <input
							type="radio" id="mpstate" name="mpstate" value="0" /> <label
							for="radio-2">关闭</label>
					</div>
					
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidid" name="hidid" value="" /> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/member/membergradementjs.js"></script>	
 
	<%@include file="/admin/footer.jsp"%>

</body>
</html>



