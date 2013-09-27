<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>普通订单设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">普通订单</a> <a
				class="brand2">编辑普通订单</a>
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
					<strong>说明</strong> 请根据需要编辑普通订单
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div class="line-dotted"></div>

				<!-- 开始显示form表单 -->
				<div class="form-actions">
					<div class="well">
						<h4>订单商品选择</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">选择订单商品:</span> 
						<input type="text" id="productName" name="productName" class="medium" placeholder="搜索商品" autocomplete="off" />
						<button id="searchproduct" name="searchproduct" class="btn btn-primary" type="button">查询</button>
						<span class="label label-info">输入检索商品</span>
					</div>
					
						<!-- flexigrid -->
						<div id="flexproductsmanagement">
							<table id="productsmanagement" style="display: none;"></table>
						</div>
					<div class="line-dotted"></div>
					<div class="span12" style="margin-left:0px;">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>
										货号
									</th>
									<th>
										商品
									</th>
									<th>
										价格
									</th>
									<th>
										数量
									</th>
									<th>
										库存状态
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody id="orderinfo">
								
								
							</tbody>
						</table>
						<div style="float:right;">
						<dl class="dl-horizontal">
							<dt>
								<span id="needquantity">0</span> 件商品，总商品金额：
							</dt>
							<dd>
								￥<span id="amount">0.0</span>
							</dd>
							<dt>
								运费：
							</dt>
							<dd>
								￥<span id="freightspan">0.0</span>
							</dd>
							<dt>
								应付总额：
							</dt>
							<dd>
								￥<span id="shouldpay">0.0</span>
							</dd>
						</dl>
						</div>
					</div>
					<div class="form-inline">
						<span class="label label-required">订单名称: </span> <input
							id="ordername" name="ordername" type="text" value="" class="medium"/> 
						<span class="label label-info">你已经选择了2个商品</span>
					</div>
					<div class="well">
						<h4>订单价格信息</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">运费:</span> <input type="text"
							id="freight" name="freight" /><span class="label label-info">你可以自定义一个运费</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">应付款: </span> <input
							id="shouldpay" name="shouldpay" type="text" value=""/> 
						<button class="btn btn-primary" type="button">修改价格</button>
						<span class="label label-info">价格修改成功</span>
					</div>
					<div id="modifyshouldpay" class="form-inline">
						<span class="label label-required">修改价格: </span> <input
							id="mshouldpay" name="mshouldpay" type="text" value=""/> 
						<button class="btn btn-primary" type="button">确认</button>
						<button class="btn btn-primary" type="button">取消</button>
						<span class="label label-info">请输入修改的价格</span>
					</div>
					
					
					<div class="well">
						<h4>收货人信息</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">jshoper平台账号: </span> <input
							id="membername" name="membername" type="text" value=""/> 
						<button class="btn btn-primary" type="button">验证</button>
						<span class="label label-info">账号可用</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">收货人: </span> <input
							id="shippingusername" name="shippingusername" type="text" value=""/> 
						<button class="btn btn-primary" type="button">查询</button>
						<span class="label label-info">未查询出改收货人信息</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">国家:</span> <input type="text"
							id="country" name="country" value="中国" class="small" />

					</div>
					<div class="form-inline">
						<span class="label label-required">省份:</span> <input type="text"
							id="province" name="province" /> <span
							class="label label-required">城市:</span> <input type="text"
							id="city" name="city" /> <span class="label label-required">区/县:</span>
						<input type="text" id="district" name="district" />
					</div>
					<div class="form-inline">
						<span class="label label-required">详细地址:</span> <input type="text"
							id="street" name="street" class="medium" />
					</div>
					<div class="form-inline">
						<span class="label label-required">邮政编码:</span> <input type="text"
							id="postcode" name="postcode" />
					</div>
					<div class="form-inline">
						<span class="label label-required">手机号码:</span> <input type="text"
							id="mobile" name="mobile" />
					</div>
					<div class="form-inline">
						<span class="label label-required">固定电话:</span> <input type="text"
							id="telno" name="telno" />
					</div>
					<div class="form-inline">
						<span class="label label-required">邮箱:</span> <input type="text"
							id="email" name="email" />
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label>
						<!-- 如果查询到了收货地址则需要设置影藏的收货地址id -->
						<input type="hidden" id="hidshippingaddressid" name="hidshippingaddressid" value="" />
					</div>
					<div class="well">
						<h4>支付及配送方式</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">支付方式:</span> <input
							type="radio" id="paystate" name="paystate" value="1" /> <label
							for="radio-1">支付宝</label> <input type="radio" id="paystate"
							name="paystate" value="0" /> <label for="radio-2">财付通 </label>
							<input type="radio" id="paystate"
							name="paystate" value="0" /> <label for="radio-2">货到付款 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">快递运输:</span> <input
							type="radio" id="delivermode" name="delivermode" value="1" /> <label
							for="radio-1">顺丰速运 </label> <input type="radio" id="delivermode"
							name="delivermode" value="0" /> <label for="radio-2">圆通 </label>
					</div>
					
					<div class="well">
						<h4>发票信息</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">发票类型:</span> <input
							type="radio" id="isinvoice" name="isinvoice" value="1" checked/> <label
							for="radio-1">个人</label> <input type="radio" id="isinvoice"
							name="isinvoice" value="0" /> <label for="radio-2">明细 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">发票抬头:</span> <input type="text"
							id="email" name="email" />
					</div>
					<div class="form-inline">
						<span class="label label-required">订单类型:</span> <input
							type="radio" id="ordertag" name="ordertag" value="1" checked/> <label
							for="radio-1">普通订单</label> 
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="submitorder"
							name="submitorder" value="提交" />
					</div>


				

				</div>


			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/order/normalordersmentjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>

