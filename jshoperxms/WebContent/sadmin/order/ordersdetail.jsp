<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>订单详细</title>


<link href="<%=basePath%>jshop/admin/themes/default/easyui.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_blue.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>jshop/admin/css/orderdetail.css" />
<link rel="stylesheet"
	href="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.css"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>

<script type="text/javascript"
	src="<%=basePath %>jshop/admin/js/jquery1.4.2.js"></script>
<script type="text/javascript"
	src="<%=basePath %>jshop/admin/js/flexigrid/flexigrid.js"></script>
<script type="text/javascript"
	src="<%=basePath %>jshop/admin/js/ordersdetailjs.js"></script>
<style type="text/css">
td {
	font-size: 9pt;
	line-height: 120%;
	color: #353535
}

body {
	font-size: 9pt;
	line-height: 120%
}
</style>
</head>

<body>
	<!-- 订单状态显示 -->
	<table width="98%" border="0" cellpadding="1" cellspacing="1"
		align="center">
		<tr>
			<td class="panel-header">订单状态</td>
		</tr>
	</table>
	<s:if test="#request.order!=null">

		<div id="orderstatearea" style="width: 98%;">
			<div class="bd">
				<div class="order_state">
					<strong>当前订单状态：<span><s:property
								value="#request.order.orderdetail.orderstate" /></span></strong>
				</div>
				<div class="order_state">
					<strong>当前付款状态：<span id="nowpaystate"><s:property
								value="#request.order.orderdetail.paystate" /></span></strong>
				</div>
				<div class="order_state">
					<strong>当前发货状态：<span><s:property
								value="#request.order.orderdetail.shippingstate" /></span></strong>
				</div>
				<div class="action">
					<input type="hidden" id="hidorderid" name="hidorderid"
						value="<s:property value="#request.order.orderdetail.orderid"/>" />
					<span class="actionbutton"><input type="button"
						id="close_order" name="close_order" value="关闭" /></span> <span
						class="actionbutton"><input type="button"
						id="confirm_order" name="confirm_order" value="确认" /></span> <span
						class="actionbutton"><input type="button" id="pay_order"
						name="pay_order" value="付款" /></span>

					<s:if test="#request.order.orderdetail.deliverynumber!=null">
						<span class="actionbutton"><input type="button"
							id="print_invoice" name="print_invoice" value="打印发货单" /></span>
					</s:if>
					<s:if test="#request.order.orderdetail.expressnumber!=null">
						<span class="actionbutton"><input type="button"
							id="print_express" name="print_express" value="打印快递单" /></span>
					</s:if>
					<span class="actionbutton"><input type="button"
						id="set_invoicenumber" name="set_invoicenumber" value="输入发货单号" /></span>
					<span class="actionbutton"><input type="button"
						id="set_expressnumber" name="set_expressnumber" value="输入快递单号" /></span>
					<span id="orderupdatemsg"></span> <span class="actionbutton"><input
						type="button" id="shipping_order" name="shipping_order"
						value="同步发货" /></span>
				</div>
				<div class="tbnotes">
					<span>操作提醒</span>
					<p>1,确认操作只需在货到付款订单情况下使用。</p>
					<p>2,关闭操作表示订单失败。</p>
					<p>3,发货操作表示订单会被放置到待发货订单中。</p>
					<p>4,请在发货前点击[同步发货]按钮获取信息，然后单击发货按钮</p>
				</div>
			</div>

			<div id="tbfh">
				<div id="order_info" class="tabs-container">
					<ul class="tabnav">
						<li class="current"><a name="tab0">支付宝发货通道</a></li>
					</ul>
					<div class="tabs-panels">
						<div class="info-box">
							<div class="db">
								<table>
									<col width="20%">
									<col width="20%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<tbody class="contact-info">
										<tr>
											<th colspan="1"><h4>支付宝发货通道</h4></th>
										</tr>
										<tr>
											<td>支付宝交易号：<span><INPUT type="text" size=30
													id="trade_no" name="trade_no" maxlength="20" value="" /></span></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
										</tr>
										<tr>
											<td>发货类型：<span><select id="transport_type"
													name="transport_type">
														<option value="EMS">EMS</option>
														<option value="POST">平邮</option>
														<option value="EXPRESS" selected="selected">快递</option>
												</select></span></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
										</tr>
										<tr>
											<td>物流公司名称：<span><INPUT type="text" size=30
													id="logistics_name" name="logistics_name" maxlength="30"
													value=""></span></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
										</tr>
										<tr>
											<td>物流发货单号(即快递单号)：<span><INPUT type="text"
													size=30 id="invoice_no" name="invoice_no" maxlength="50"
													value=""></span></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
										</tr>
										<tr>
											<td><span><input name="alipaysendgoods"
													id="alipaysendgoods" value="发 货" type="button"></span></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
											<td colspan="2">
												<!-- 隐藏的支付方式id -->
												<input type="hidden" id="hidpaymentid" name="hidpaymentid"
												value="" />
											</td>
										</tr>
									</tbody>

								</table>

							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 发货单号生成区域 -->
			<div id="setinvoicenumberarea" style="display: none;">
				<div id="order_info" class="tabs-container">
					<ul class="tabnav">
						<li class="current"><a name="tab0">填充发货单号</a></li>
					</ul>
					<div class="tabs-panels">
						<div class="info-box">
							<div class="db">
								<table>
									<col width="20%">
									<col width="20%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<tbody class="contact-info">
										<tr>
											<th colspan="1"><h4>发货单号</h4></th>
										</tr>
										<tr>
											<td>发货单号：<span><INPUT type="text"
													id="invoicenumber" name="invoicenumber" value="" /></span></td>
											<td colspan="2"><span><INPUT type="button"
													id="updateinvoicenumber" name="updateinvoicenumber"
													value="更新发货单号" /></span></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
										</tr>
										<tr>
											<td>自动生成：<span><INPUT type="button"
													id="getrandominvoicenumber" name="getrandominvoicenumber"
													value="生成发货单号" /></span></td>
										</tr>
									</tbody>

								</table>

							</div>
						</div>
					</div>
				</div>
			</div>


			<!--快递单号生成区域 -->
			<div id="setexpressnumberarea" style="display: none;">
				<div id="order_info" class="tabs-container">
					<ul class="tabnav">
						<li class="current"><a name="tab0">填充快递单号</a></li>
					</ul>
					<div class="tabs-panels">
						<div class="info-box">
							<div class="db">
								<table>
									<col width="20%">
									<col width="20%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<col class="10%">
									<tbody class="contact-info">
										<tr>
											<th colspan="1"><h4>快递单号</h4></th>
										</tr>
										<tr>
											<td>快递单号：<span><INPUT type="text"
													id="expressnumber" name="expressnumber" value="" /></span></td>
											<td colspan="2"><span><INPUT type="button"
													id="updateexpressnumber" name="updateexpressnumber"
													value="更新快递单号" /></span></td>
											<td colspan="2"></td>
											<td colspan="2"></td>
										</tr>
										<tr>
											<td></td>
										</tr>
									</tbody>

								</table>

							</div>
						</div>
					</div>
				</div>
			</div>







			<!-- 订单买家信息 -->
			<div id="order_info" class="tabs-container">
				<ul class="tabnav">
					<li class="current"><a name="tab0">订单详细</a></li>
				</ul>
				<div class="tabs-panels">
					<div class="info-box">
						<div class="db">
							<table>
								<col width="20%">
								<col width="20%">
								<!-- 宝贝 -->
								<col class="10%">
								<!-- 交易状态 -->
								<col class="10%">
								<!-- 单价（元） -->
								<col class="10%">
								<!-- 数量 -->
								<col class="10%">
								<!-- 优惠 -->
								<col class="10%">
								<!-- 合计（元） -->
								<col class="10%">
								<!-- 运费（元） -->
								<!-- 买/卖家信息 -->
								<tbody class="contact-info">
									<tr>
										<th colspan="1"><h4>买家信息</h4></th>
									</tr>
									<tr>
										<td>用户名称：<span class="username"><s:property
													value="#request.order.orderbuyerinfo.username" /></span></td>
										<td colspan="2">真实姓名：<span class="realname"><s:property
													value="#request.order.orderbuyerinfo.realname" /></span></td>
										<td colspan="2">联系电话：<span class="mobile">[<s:property
													value="#request.order.orderbuyerinfo.mobile" />][<s:property
													value="#request.order.orderbuyerinfo.telno" />]
										</span></td>
										<td colspan="2">邮件：<span class="mail"><s:property
													value="#request.order.orderbuyerinfo.email" /></span><span><a
												href="#?userid=<s:property value="#request.order.orderbuyerinfo.userid"/>">发送站内信</a></span></td>
									</tr>
									<tr>
										<td>支付方式：<span><s:property
													value="#request.order.orderdetail.paymentname" /></span></td>
									</tr>
								</tbody>
								<tbody class="contact-info">
									<tr class="sep-row">
										<td colspan="8"></td>
									</tr>
									<tr>
										<th colspan="1"><h4>订单信息</h4></th>
									</tr>

									<tr>
										<td>订单编号：<span><s:property
													value="#request.order.orderdetail.orderid" /></span></td>
										<td colspan="2">订单来源：<span><s:property
													value="#request.order.orderdetail.orderTag" /></span></td>
										<td colspan="2">下单时间：<span><s:property
													value="#request.order.orderdetail.purchasetime" /></span></td>
										<td colspan="2">订单状态：<span><s:property
													value="#request.order.orderdetail.orderstate" /></span></td>
									</tr>
									<tr>
										<td>发货单号：<span><s:property
													value="#request.order.orderdetail.deliverynumber" /></span></td>
										<td colspan="2">发货时间：<span><s:property
													value="#request.order.orderdetail.deliverytime" /></span></td>
										<td colspan="2">发货状态：<span><s:property
													value="#request.order.orderdetail.shippingstate" /></span></td>
										<td colspan="2">快递单号：<span><s:property
													value="#request.order.orderdetail.expressnumber" /></span></td>

									</tr>
								</tbody>

								<tbody class="contact-info">
									<tr class="sep-row">
										<td colspan="8"></td>
									</tr>
									<tr class="order-hd">
										<th>商品编号</th>
										<th>商品名称</th>
										<th>商品自定义编号</th>

										<th>会员价</th>
										<th>赠送积分</th>
										<th>数量</th>
										<th>商品毛重</th>
										<th>运费</th>
									</tr>
									<s:iterator id="bean" value="#request.order.ordergoods"
										status="ordergoods">
										<tr class="order-item">
											<td><s:property value="goodsid" /></td>
											<td>
												<div class="pic-info">
													<div class="pic">
														<a title="商品图片" target="_blank"
															href="GetGoodsdetailBygoodsid.action?goodsid=<s:property value="goodsid"/>">
															<img src="Uploads/<s:property value="picture"/>"
															alt="<s:property value="goodsname"/>">
														</a>
													</div>
												</div>
												<div class="txt-info">
													<div class="desc">
														<span class="name"> <a target="_blank"
															title="<s:property value="goodsname"/>"
															href="GetGoodsdetailBygoodsid.action?goodsid=<s:property value="goodsid"/>"><s:property
																	value="goodsname" /></a>
														</span>
													</div>
												</div>
											</td>
											<td><s:property value="usersetnum" /></td>

											<td colspan="1"><s:property value="favorable" /></td>
											<td colspan="1"><s:property value="points" /></td>
											<td colspan="1"><s:property value="needquantity" /></td>
											<td colspan="1"><s:property value="weight" /></td>
											<td colspan="1"><s:property
													value="#request.order.orderdetail.freight" /></td>

										</tr>
									</s:iterator>
									<tr class="order-item">
										<td colspan="7"></td>
										<td colspan="1">总价：<span><s:property
													value="#request.order.orderdetail.shouldpay" /></span></td>

									</tr>
								</tbody>
								<tbody class="contact-info">
									<tr class="sep-row">
										<td colspan="8"></td>
									</tr>
									<tr>
										<th colspan="1"><h4>物流信息</h4></th>
									</tr>

									<tr>
										<td colspan="7">发货地址：<span><s:property
													value="#request.order.shipping.province" />,<s:property
													value="#request.order.shipping.city" />,<s:property
													value="#request.order.shipping.district" />,<s:property
													value="#request.order.shipping.street" />,<s:property
													value="#request.order.shipping.postcode" />,<s:property
													value="#request.order.shipping.mobile" />,<s:property
													value="#request.order.shipping.telno" />,</span></td>

									</tr>
									<tr>
										<td colspan="7">运送方式：<span><s:property
													value="#request.order.orderdetail.delivermode" /></span></td>
									</tr>
									<tr>
										<td colspan="7">买家留言：<span><s:property
													value="#request.order.orderdetail.toBuyerNotes" /></span></td>
									</tr>
									<tr>
										<td colspan="7"><a href="#">查看详细</a></td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>

	</s:if>
	<!-- 结束订单状态显示 -->

</body>
</html>
