<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/tabs-accordion-usercenter.css"/>
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/myorderdetail.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/js/jquery.query.js"></script>
</head>

<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">

<div width="100%" height="606" frameborder="0" scrolling="no" style="display: block; ">
  <div id="mem_position"><a href="#" target="_parent">会员专区</a> &gt; <a href="#">订单详细</a></div>
	<div id="main_inner" class="fixed">              
	  <div id="primaryContent_columnless">
			<div id="columnA_columnless">

				<br class="clear"/>
				<div id="orderdetail_info">
				
					<!-- 订单状态显示 -->
	   <table border="0" cellpadding="1" cellspacing="1" align="center">
	 		<tr> 
	   			<td class="panel-header">订单状态</td>
	  		</tr>
	   </table>

	  <#if myorder.myorderdetail??>
	  <div id="orderstatearea">
        <div class="bd">
        	<div class="order_state">
        		<strong>当前订单状态：<span>${myorder.myorderdetail.orderstate}</span></strong>
        	</div>
        	<div class="order_state">
        		<strong>当前付款状态：<span id="nowpaystate">${myorder.myorderdetail.paystate}</span></strong>
        	</div>
        	<div class="order_state">
        		<strong>当前发货状态：<span>${myorder.myorderdetail.shippingstate}</span></strong>
        	</div>
        	<div class="action">
        		<input type="hidden" id="hidorderid" name="hidorderid" value="${myorder.myorderdetail.orderid}"/>
        	</div>
        	<div class="tbnotes">
        		<span>温馨提醒</span>
        		 <p>1、交易已成功，如果你还未收到货物，或者收到的货物无法正常使用，请及时联系卖家协商处理。
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
									<td>用户名称：<span class="username">${myorder.myorderbuyerinfo.username}</span></td>
									<td colspan="2">真实姓名：<span class="realname">${myorder.myorderbuyerinfo.realname}</span></td>
									<td colspan="2">联系电话：<span class="mobile">[${myorder.myorderbuyerinfo.mobile}][${myorder.myorderbuyerinfo.telno}]</span></td>
									<td colspan="2">邮件：<span class="mail">${myorder.myorderbuyerinfo.email}</span><span><a href="#?userid=${myorder.myorderbuyerinfo.userid}">给商家留言</a></span></td>
								</tr>
								<tr>
									<td>支付方式：<span>${myorder.myorderdetail.paymentname}</span></td>
								</tr>
							</tbody>
							<tbody class="contact-info">
								<tr class="sep-row"><td colspan="8"></td></tr>
								<tr>
									<th colspan="1"><h4>订单信息</h4></th>
								</tr>
								
								<tr>
									<td>订单编号：<span>${myorder.myorderdetail.orderid}</span></td>
									<td colspan="2">订单来源：<span>${myorder.myorderdetail.orderTag}</span></td>
									<td colspan="2">下单时间：<span>${myorder.myorderdetail.purchasetime}</span></td>
									<td colspan="2">订单状态：<span>${myorder.myorderdetail.orderstate}</span></td>
								</tr>
								<tr>
									<td>发货单号：<span><#if myorder.myorderdetail.deliverynumber! !="">${myorder.myorderdetail.deliverynumber}</#if></span></td>
									<td colspan="2">发货时间：<span><#if myorder.myorderdetail.deliverytime! !="">${myorder.myorderdetail.deliverytime}</#if></span></td>
									<td colspan="2">发货状态：<span>${myorder.myorderdetail.shippingstate}</span></td>
								</tr>
							</tbody>
							
							<tbody class="contact-info">
								<tr class="sep-row"><td colspan="8"></td></tr>
								<tr class="order-hd">
									<th>商品编号</th>
									<th>商品名称</th>
									<th>货号</th>
									
									<th>价格</th>
									<th>赠送积分</th>
									<th>数量</th>
									<th>商品重量</th>
									<th>运费</th>
								</tr>
								<#if (myorder.myordergoods??)&&(myorder.myordergoods?size>0)>
								<#list myorder.myordergoods as mog>
								<tr class="order-item">
									<td>${mog.goodsid}</td>
									<td>
										<div class="pic-info">
											<div class="pic">
												<a title="商品图片" target="_blank" href="${basepath}/html/default/shop/${mog.goodsid}.html">
													<img src="${mog.picture}" alt="${mog.goodsname}">
											    </a>
											</div>
										</div>
										<div class="txt-info">
											<div class="desc">
												<span class="name">
												<a target="_blank" title="${mog.goodsname}" href="{basepath}html/default/shop/${mog.goodsid}.html">${mog.goodsname}</a>
												</span>
											</div>
										</div>
									</td>
									<td>${mog.usersetnum}</td>
									
									<td colspan="1">${mog.favorable}</td>
									<td colspan="1">${mog.points}</td>
									<td colspan="1">${mog.needquantity}</td>
									<td colspan="1">${mog.weight}</td>
									<td colspan="1">${myorder.myorderdetail.freight}</td>
								
								</tr>
								</#list>
								</#if>
								<tr class="order-item">
									<td colspan="7"></td>
									<td colspan="1">总价：<span>${myorder.myorderdetail.shouldpay}</span></td>
								
								</tr>
							</tbody>
							<tbody class="contact-info">
								<tr class="sep-row"><td colspan="8"></td></tr>
								<tr>
									<th colspan="1"><h4>物流信息</h4></th>
								</tr>
								
								<tr>
									<td colspan="7">发货地址：<span>${myorder.myshipping.province},${myorder.myshipping.city},${myorder.myshipping.district},${myorder.myshipping.street},${myorder.myshipping.postcode},${myorder.myshipping.mobile},${myorder.myshipping.telno},</span></td>
									
								</tr>
								<tr>
									<td colspan="7">运送方式：<span>${myorder.myorderdetail.delivermode}</span></td>
								</tr>
								<tr>
									<td colspan="7">买家留言：<span>${myorder.myorderdetail.customernotes}</span></td>
								</tr>
								<tr>
									<td colspan="7"></td>
								</tr>
							</tbody>
        				</table>
        				
        			</div>
        		</div>
        	</div>
        </div>
	  </div>
	    
	 </#if>
	  <!-- 结束订单状态显示 -->		
				</div>
				
			</div>
	
		</div>
		
	
	</div>
  
  </div>

</div>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>