<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>订单管理 &middot; jshoper</title>

</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">订单管理</a> <a
				class="brand2">普通订单编辑</a>
		</div>
	</div>
	<div class="container-fluid">
	<div class="row-fluid">
		
		<div class="span12">
			<div class="alert alert-info">
				 <button type="button" class="close" data-dismiss="alert">×</button>
					<h4>订单状态！</h4> 
					<strong>当前订单状态：</strong> <span><s:property
								value="#request.order.orderdetail.orderstate" /></span>
					<strong>当前付款状态：</strong><span id="nowpaystate"><s:property
								value="#request.order.orderdetail.paystate" /></span>
					<strong>当前发货状态：</strong><span><s:property
								value="#request.order.orderdetail.shippingstate" /></span>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span6">
		<!-- 隐藏的订单id -->
		<input type="hidden" id="hidorderid" name="hidorderid"
						value="<s:property value="#request.order.orderdetail.orderid"/>" />
			 <span class="label badge-success">订单操作</span>
			<div class="row-fluid">
				<div class="span4">
					 <button id="close_order" name="close_order"  class="btn" type="button">关闭订单</button>
				</div>
				<div class="span4">
					 <button id="confirm_order" name="confirm_order" class="btn" type="button">确认订单</button>
				</div>
				<div class="span4">
					 <button id="pay_order"
						name="pay_order" class="btn" type="button">订单付款</button>
				</div>
			</div>
		</div>
		<div class="span6">
			 <span class="label badge-success">订单物流操作</span>
			<div class="row-fluid">
				
				<!--<s:if test="#request.order.orderdetail.deliverynumber!=null">
				<div class="span2">
						<span class="actionbutton">
						<button id="print_invoice" name="print_invoice"  class="btn" type="button">打印发货单</button></span>
				</div>
				</s:if>
			
				
				<s:if test="#request.order.orderdetail.expressnumber!=null">
				<div class="span2">
					<span class="actionbutton">
					<button id="print_express" name="print_express" class="btn" type="button">打印快递单</button></span>
				</div>
				</s:if>-->
				
				
				<div class="span2">
					 <button id="set_invoicenumber" name="set_invoicenumber" class="btn" type="button">输入发货单号</button>
				</div>
				<div class="span2">
					 <button id="set_expressnumber" name="set_expressnumber"  class="btn" type="button">输入快递单号</button>
				</div>
				<div class="span2">
					 <button id="shipping_order" name="shipping_order" class="btn" type="button">同步发货</button>
				</div>
			</div>
		</div>
	</div>
	<br>
			<div class="alert alert-info">
				 <button type="button" class="close" data-dismiss="alert">×</button>
					<h4>操作提醒</h4> 
					<p>1,确认操作只需在货到付款订单情况下使用。</p>
					<p>2,关闭操作表示次订单失败。</p>
					<p>3,发货操作表示订单会被放置到待发货订单中。</p>
					<p>4,请在发货前点击[同步发货]按钮获取信息，然后单击发货按钮</p>
			</div>
		
	<div id="tbfh" class="row-fluid">
		<div class="span4">
			 <legend>支付宝发货通道</legend> 
			<form class="form-inline">
				<div class="form-inline">
					<span class="label label-required">支付宝交易号: </span> <input
						id="trade_no" name="trade_no" type="text" value=""/><span class="label label-info">同支付宝对接后可获取到支付宝交易号</span> 
				</div>
				<div class="form-inline">
					<span class="label label-required">支付宝交易号: </span> 
					<select id="transport_type"
						name="transport_type">
							<option value="EMS">EMS</option>
							<option value="POST">平邮</option>
							<option value="EXPRESS" selected="selected">快递</option>
					 </select>
				</div>
				<div class="form-inline">
					<span class="label label-required">物流公司名称: </span> <input
						id="logistics_name" name="logistics_name" type="text" value=""/> 
				</div>
				<div class="form-inline">
					<span class="label label-required">物流发货单号: </span> <input
						id="invoice_no" name="invoice_no" type="text" value=""/><span class="label label-info">即快递单号</span> 
				</div>
				<div class="form-inline">
					<label class="label label-submit"></label>
				 	<input class="btn btn-success" type="button" name="alipaysendgoods"
					id="alipaysendgoods" value="发 货" />
				</div>
				<!-- 隐藏的支付方式id -->
				<input type="hidden" id="hidpaymentid" name="hidpaymentid"
				value="" />
			</form>
		</div>
		<div id="setinvoicenumberarea" class="span4">
			 <legend>发货单号生成通道</legend> 
			<form class="form-inline">
				<div class="form-inline">
					<span class="label label-required">发货单号: </span> <input
						id="invoicenumber" name="invoicenumber"  type="text" value=""/><span class="label label-info">通过点击生成发货单号获取一个随机的号码</span> 
				</div>
				<div class="form-inline">
					<label class="label label-submit"></label>
				 	<input class="btn btn-success" type="button" id="updateinvoicenumber" name="updateinvoicenumber" value="更新发货单号"  />
				</div>
				
				<div class="form-inline">
					<label class="label label-submit"></label>
				 	<input class="btn btn-success"  type="button" id="getrandominvoicenumber" name="getrandominvoicenumber" value="生成发货单号"  />
				</div>
			</form>
		</div>
		<div id="setexpressnumberarea" class="span4">
			 <legend>快递单号生成通道</legend> 
			<form class="form-inline">
				<div class="form-inline">
					<span class="label label-required">快递单号: </span> <input
						id="expressnumber" name="expressnumber"  type="text" value=""/><span class="label label-info">通过点击生成发货单号获取一个随机的号码</span> 
				</div>
				<div class="form-inline">
					<label class="label label-submit"></label>
				 	<input class="btn btn-success" type="button" id="updateexpressnumber" name="updateexpressnumber" value="更新快递单号" />
				</div>
			</form>
		</div>
	</div>
	
	
	<!-- 订单买家信息 -->
	<div id="order_info" class="row-fluid">
		<div class="span12">
			<p class="text-left text-info">
				订单详细——买家信息
			</p>
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							用户名称：
						</th>
						<th>
							真实姓名：
						</th>
						<th>
							联系电话：
						</th>
						<th>
							邮件：
						</th>
						<th>
							支付方式：
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<s:property value="#request.order.orderbuyerinfo.loginname" />
						</td>
						<td>
							<s:property value="#request.order.orderbuyerinfo.realname" />
						</td>
						<td>
							[<s:property value="#request.order.orderbuyerinfo.mobile" />][<s:property value="#request.order.orderbuyerinfo.telno" />]
						</td>
						<td>
							<s:property value="#request.order.orderbuyerinfo.email" /><a
						href="#?memberid=<s:property value="#request.order.orderbuyerinfo.id"/>">发送站内信</a>
						</td>
						<td>
							<s:property value="#request.order.orderdetail.paymentname" />
						</td>
					</tr>
				</tbody>
			</table>
			<p class="text-info">
				订单详细——订单信息
			</p>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							订单编号：
						</th>
						<th>
							订单来源：
						</th>
						<th>
							下单时间：
						</th>
						<th>
							订单状态：
						</th>
						<th>
							发货单号：
						</th>
						<th>
							发货时间：
						</th>
						<th>
							发货状态：
						</th>
						<th>
							快递单号：
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="success">
						<td>
							<s:property value="#request.order.orderdetail.orderid" />
						</td>
						<td>
							<s:property value="#request.order.orderdetail.orderTag" />
						</td>
						<td>
							<s:date name="#request.order.orderdetail.purchasetime" format="yyyy-MM-dd hh:mm:ss"/>
						</td>
						<td>
							<s:property value="#request.order.orderdetail.orderstate" />
						</td>
						<td>
							<s:property value="#request.order.orderdetail.deliverynumber" />
						</td>
						<td>
							<s:date name="#request.order.orderdetail.deliverytime" format="yyyy-MM-dd hh:mm:ss"/>
						</td>
						<td>
							<s:property value="#request.order.orderdetail.shippingstate" />
						</td>
						<td>
							<s:property value="#request.order.orderdetail.expressnumber" />
						</td>
					</tr>
				</tbody>
			</table>
			<p class="text-info">
				订单详细——货物信息
			</p>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							货物编号
						</th>
						<th>
							货物名称
						</th>
						<th>
							会员价
						</th>
						<th>
							赠送积分
						</th>
						<th>
							数量
						</th>
						<th>
							商品毛重
						</th>
						<th>
							运费
						</th>
						
					</tr>
				</thead>
				<tbody>
				<s:iterator id="bean" value="#request.order.ordergoods" status="ordergoods">
					<tr>
						<td>
							<s:property value="goodsid" />
						</td>
						<td>
							<div class="pic-info">
								<div class="pic">
									<!--<a title="商品图片" target="_blank"
										href="GetGoodsdetailBygoodsid.action?goodsid=<s:property value="goodsid"/>">
										<img src="Uploads/<s:property value="picture"/>"
										alt="商品图片">
									</a>  -->
								</div>
							</div>
							<div class="txt-info">
								<div class="desc">
									<!--<span class="name"> <a target="_blank"
										title="<s:property value="goodsname"/>"
										href="GetGoodsdetailBygoodsid.action?goodsid=<s:property value="goodsid"/>"><s:property
												value="goodsname" /></a>
									</span>-->
									<span class="name"> 
										<s:property value="goodsname" />
									</span>
								</div>
							</div>
						</td>
						<td>
							<s:property value="favorable" />
						</td>
						<td>
							<s:property value="points" />
						</td>
						<td>
							<s:property value="needquantity" />
						</td>
						<td>
							<s:property value="weight" />
						</td>
						<td>
							<s:property value="#request.order.orderdetail.freight" />
						</td>
					</tr>
					</s:iterator>
					<tr  class="error">
						<td colspan="6"></td>
						<td colspan="1">总价：<span><s:property
									value="#request.order.orderdetail.shouldpay" /></span></td>

					</tr>
				</tbody>
			</table>
			<p class="text-info">
				订单详细——物流信息
			</p>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							发货地址：
						</th>
						<th>
							运送方式：
						</th>
						<th>
							买家留言：
						</th>
						<th>
							物流信息：
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<s:property
							value="#request.order.shipping.province" />,<s:property
							value="#request.order.shipping.city" />,<s:property
							value="#request.order.shipping.district" />,<s:property
							value="#request.order.shipping.street" />,<s:property
							value="#request.order.shipping.postcode" />,<s:property
							value="#request.order.shipping.mobile" />,<s:property
							value="#request.order.shipping.telno" />
						</td>
						<td>
							<s:property value="#request.order.orderdetail.delivermode" />
						</td>
						<td>
							<s:property	value="#request.order.orderdetail.customernotes" />
						</td>
						<td>
							<a href="#">查看详细</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div class="line-dotted"></div>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/order/ordersdetailjs.js"></script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>

