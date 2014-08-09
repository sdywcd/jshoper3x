<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>货物信息管理 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">货物信息管理 </a> <a
				id="dttitle" class="brand2">编辑货物信息 </a>
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
					<strong>说明</strong> 请根据需要编辑货物信息
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
		
				<div class="form-actions">
					<div class="well">
						<h4>规格信息获取区域（规格信息是商品的组成部分）</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">选择商品类型:</span>
						<select id="goodstypetn" name="goodstypetn"></select> <span class="label label-info">通过选择商品类型获取该类型下的规格值信息</span>
					</div>
					<div id="isSpecificationsOpenarea" style="display:none;" class="form-inline">
						<span class="label label-required">货物规格选择:</span>
						<select id="isSpecificationsOpen" name="isSpecificationsOpen"></select> <span
							class="label label-info">如果选择一般规格则表示该商品下只有一种规格的货品，如果选择其他则表示该商品下有多个规格货品</span>
					</div>
					<!-- 规格值内容填充区 -->
					<div id="specificationvalueareadiv" class="form-inline" style="display: none;">
					</div>
					<div class="well">
						<h4>已选规格值</h4>
					</div>
					<!-- 规格值内容已选填充区 -->
					<div id="specificationvalueareahavediv" class="form-inline" style="display: none;">
					</div>

					<div id="specificationsarea" class="form-inline">
						<div class="well">
							<h4>货物信息填写区域（货物信息是商品的组成部分）</h4>
						</div>
						<div class="accordion" id="spdefault">
							<div class="accordion-group">
								<div class="accordion-heading">
									<a id="spname" class="accordion-toggle" data-toggle="collapse"
										data-parent="#spdefault" href="#collapseOne"> 货物信息区域 </a>
								</div>
								<div id="collapseOne" class="accordion-body collapse in">
									<div class="accordion-inner">
										<div class="form-inline">
											<span class="label label-required">货号:</span> <input
												type="text" id="productSn" name="productSn" class="small" />
											<span class="label label-info">货号是标示货品的唯一编码</span>
										</div>
										<div class="form-inline">
											<span class="label label-required">货物名称:</span> <input
												type="text" id="productName" name="productName"
												class="medium" />
										</div>
										<div class="form-inline">
											<span class="label label-required">成本价:</span> <input
												type="text" id="cost" name="cost" class="small" /> <span
												class="label label-info">成本价是该货品实际最合理价值，理论上会员价不得低于成本价</span>
										</div>
										<div class="form-inline">
											<span class="label label-required">销售价:</span> <input
												type="text" id="saleprice" name="saleprice" class="small" />
											<span class="label label-info">销售价是该货品对非会员或者无优惠时的价格</span>
										</div>
										<div class="form-inline">
											<span class="label label-required">会员价:</span> <input
												type="text" id="memberprice" name="memberprice"
												class="small" /> <span class="label label-info">会员价是该货品对会员或者优惠时的价格</span>
										</div>
										<div class="form-inline">
											<span class="label label-required">市场价:</span> <input
												type="text" id="price" name="price" class="small" /> <span
												class="label label-info">市场价是该货品其他平台的价格</span>
										</div>
										<div class="form-inline">
											<span class="label label-required">重量:</span> <input
												type="text" id="weight" name="weight" class="small" /> <select
												id="unit" name="unit">
												<option value="克">克</option>
												<option value="公斤">公斤</option>
											</select> <span class="label label-info">重量的作用是用于计算物流费用</span>
										</div>
										<div class="form-inline">
											<span class="label label-required">库存:</span> <input
												type="text" id="store" name="store" class="small" />
										</div>
										<div class="form-inline">
											<span class="label label-required">预警库存:</span> <input
												type="text" id="freezeStore" name="freezeStore"
												class="small" />
										</div>
										

										<div class="form-inline">
											<span class="label label-required">仓储地址:</span> <input
												type="text" id="warehouseLocation" name="warehouseLocation"
												class="small" /> <span class="label label-info">该值表示库存存放在哪里。如果你有多个仓储点可能比较有用，可以是一个代号或者是详细地址</span>
										</div>
										<div class="form-inline">
											<span class="label label-required">货位:</span> <input
												type="text" id="placeStore" name="placeStore" class="small" />
											<span class="label label-info">该值表示货物存放在仓库中的位置，一般使用逗号分隔的x，y，z坐标表示</span>
										</div>
										<div class="form-inline">
											<span class="label label-required">是否默认:</span> <input
												type="radio" id="isDefault" name="isDefault" value="1"
												checked="checked" /> <label for="radio-1">是 </label> <input
												type="radio" id="isDefault" name="isDefault" value="0" /> <label
												for="radio-2">否 </label>
										</div>

										<div class="form-inline">
											<span class="label label-required">货品上架:</span> <input
												type="radio" id="isSalestate" name="isSalestate" value="1"
												checked="checked" /> <label for="radio-1">是 </label> <input
												type="radio" id="isSalestate" name="isSalestate" value="0" />
											<label for="radio-2">否 </label>
										</div>

									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidproductid" name="hidproductid" value="">
							  <input type="hidden" id="hidgoodsid" name="hidgoodsid" value="">
							   <input type="hidden" id="hidgoodsname" name="hidgoodsname" value="">
							  <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/products/productmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>
</body>
</html>

