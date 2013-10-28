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
								￥<span id="shouldpayspan">0.0</span>
							</dd>
						</dl>
						</div>
					</div>
					<div class="form-inline">
						<span class="label label-required">订单名称: </span> <input
							id="ordername" name="ordername" type="text" value="" class="medium"/> 
					
					</div>
					<div class="well">
						<h4>订单价格信息</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">运费:</span> <input type="text"
							id="freight" name="freight" /><span class="label label-info">你可以自定义一个运费</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">订单总价: </span> <input
							id="shouldpay" name="shouldpay" type="text" value="" readonly/> 
						<button id="tomodifyshouldpay" class="btn btn-primary" type="button">修改订单总价</button>
						<span id="tomodifyshouldpayinfo" style="display:none;"  class="label label-info">订单总价修改成功</span>
					</div>
					<div id="modifyshouldpay" style="display:none;" class="form-inline">
						<span class="label label-required">修改价格: </span> <input
							id="mshouldpay" name="mshouldpay" type="text" value=""/> 
						<a href="#myModal" role="button" class="btn btn-primary" data-toggle="modal">确认</a>
						<span class="label label-info">请输入修改的价格</span>
					</div>
					
					
					<div class="well">
						<h4>选择发货人信息</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">搜索可用发货地址: </span> <input
							id="membername" name="membername" type="text" value=""/> 
						<button id="searchdeliveraddress" class="btn btn-primary" type="button" >搜索</button>
						<span id="accountcheckinfo" class="label label-info">请输入会员账号进行搜索</span>
				
					</div>
					
					<!-- flexigrid 会员发货地址列表-->
					<div id="flexdeliveraddressmanagement">
						<table id="deliveraddressmanagement" style="display: none;"></table>
					</div>
					
					<div class="line-dotted"></div>
					<div class="well">
						<h4>新增发货人信息</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">收货人: </span> <input
							id="shippingusername" name="shippingusername" type="text" value=""/> 
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
					 	<input class="btn btn-success" type="button" id="savedeliveraddress"
							name="savedeliveraddress" value="保存发货地址" />
					</div>
					<div class="well">
						<h4>支付及配送方式</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">支付方式:</span>
						<span id="paystatearea"></span>
						<!--  <input
							type="radio" id="paystate" name="paystate" value="1" /> <label
							for="radio-1">支付宝</label> <input type="radio" id="paystate"
							name="paystate" value="0" /> <label for="radio-2">财付通 </label>
							<input type="radio" id="paystate"
							name="paystate" value="0" /> <label for="radio-2">货到付款 </label>--> 
					</div>
					<div class="form-inline">
						<span class="label label-required">快递运输:</span>
						<span id="delivermodearea"></span>
						<!-- <input
							type="radio" id="delivermode" name="delivermode" value="1" /> <label
							for="radio-1">顺丰速运 </label> <input type="radio" id="delivermode"
							name="delivermode" value="0" /> <label for="radio-2">圆通 </label> -->
					</div>
					
					<div class="well">
						<h4>发票信息</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">发票类型:</span> <input
							type="radio" id="isinvoice" name="isinvoice" value="1" checked/> <label
							for="radio-1">个人</label> <input type="radio" id="isinvoice"
							name="isinvoice" value="1" /> <label for="radio-2">明细 </label>
							 <input type="radio" id="isinvoice"
							name="isinvoice" value="0" /> <label for="radio-2">不开票 </label>
					</div>
				    <div class="form-inline">
						<span class="label label-required">发票抬头:</span> <input type="text"
							id="invPayee" name="invPayee" />
					</div>
					<div class="form-inline">
						<span class="label label-required">订单类型:</span> <input
							type="radio" id="orderTag" name="orderTag" value="1" checked/> <label
							for="radio-1">普通订单</label>
							<input
							type="radio" id="orderTag" name="orderTag" value="2" /> <label
							for="radio-1">团购订单</label> 
							<input
							type="radio" id="orderTag" name="orderTag" value="3" /> <label
							for="radio-1">拍卖订单</label> 
							<input
							type="radio" id="orderTag" name="orderTag" value="4" /> <label
							for="radio-1">手机订单</label> 
					</div>
					<div class="well">
						<h4>订单备注</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">订单备注:</span> <input type="text"
							id="customerordernotes" name="customerordernotes" class="large"/>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label>
						<!-- 如果查询到了发货地址则需要设置影藏的发货地址id -->
						<input type="hidden" id="hidshippingaddressid" name="hidshippingaddressid" value="" />
						<!-- 如果查询到了平台账号则需要设置隐藏的会员id -->
						<input type="hidden" id="hidmemberid" name="hidmemberid" value=""/>
						<!-- 隐藏的productids字符串 -->
						<input type="hidden" id="hidproductid" name="hidproductid" value=""/>
						 <input
							class="btn btn-success" type="button" id="submitorder"
							name="submitorder" value="提交" />
					</div>


				

				</div>


			</div>

		</div>

	</div>
	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">订单价格修改提醒</h3>
	  </div>
	  <div class="modal-body">
	    <p>是否确认修改订单价格</p>
	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	    <button id="confirmtoupdateshouldpay" class="btn btn-primary" >确认修改</button>
	  </div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/order/ordersjs.js"></script>

	<%@include file="/admin/footer.jsp"%>

</body>
</html>

