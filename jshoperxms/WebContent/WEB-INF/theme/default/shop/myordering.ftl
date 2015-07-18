<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>所有订单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/js/jquery.query.js"></script>

</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">
<#include "/WEB-INF/theme/default/shop/usermenu.ftl">
<div id="mem_right" name="mem_right"  width="100%" height="606" frameborder="0" scrolling="no" onload="javascript:dyniframesize('mem_right');" style="display: block; ">
  <div id="mem_position"><a href="#" target="_parent">会员专区</a> &gt; <a href="#">订单管理</a></div>
  <div id="hui_r">
    <div class="huinew_rbox">

      <div class="myc_top">
        <ul>
          <li> <a class="cur" href="#" style="text-decoration:none;color:#333;"><span>我的订单(0)</span></a></li>
          <!--<li><a href="/Member/OrderListNotPay.do" style="text-decoration:none;color:#333;"><span>需要支付的订单(0)</span></a></li>
          <li><a href="/Member/OrderListCancel.do" style="text-decoration:none;color:#333;"><span>已取消的订单(0)</span></a></li>
    -->
        </ul>
      </div>
      <!-- flag为common的即为普通商品的订单 -->
      <div class="myorderlist_wrap">
        <table width="738" border="0" cellpadding="0" cellspacing="1" bgcolor="#e6e6e6" class="myorderlist">
          <tbody>
            <tr>
              <td class="myorderlist_th1 th1">订单号</td>
              <td class="myorderlist_th2 th1">商品名称</td>
			  <td class="myorderlist_th6 th1">应付金额</td>
              <td class="myorderlist_th3 th1">成交时间</td>
              <td class="myorderlist_th5 th1">数量</td>
              <td class="myorderlist_th7 th1">操作</td>
			  <td class="myorderlist_th7 th1"></td>
            </tr>
			<tr>
			<#if (userorder??)&&(userorder?size>0)>
			<#list userorder as u>
		   <tr class="align_Center">
				<td style="padding: 5px 0pt;">${u.orderid}</td>
				<td class="align_Left">
					<span>
						<a  target="_blank"  href="InitMyOrdersDetail.action?orderid=${u.orderid}">
							${u.goodsname}
						</a>
					</span>
				</td>
				<td>
					<span class="price">${u.shouldpay}</span>
				</td>
				<td>${u.purchasetime}</td>
				<td>
					${u.needquantity}
					<!-- 隐藏的orderid -->
					<input type="hidden" id="hidorderid" name="hidorderid" value="${u.orderid}"/>
				</td>
				<td>
				<#if (u.orderstate=='0')>
					<span>等待商家确认</span><br/>
				
				<#elseif (u.orderstate=='1')>
					<span>已确认配货中</span><br/>
				
				<#elseif (u.orderstate=='4')>
					<span>退货</span><br/>
				
				<#elseif (u.orderstate=='5')>
					<span>关闭</span><br/>
				
				<#elseif (u.orderstate=='7')>
					<span>缺货</span><br/>
				
				<#elseif (u.orderstate=='9')>
					<span>成功</span><br/>
				
				<#elseif (u.orderstate=='3')>
					<a href="http://www.alipay.com" target="_blank"><font color="red">确认收货</font></a>										
				<br/>
				</#if>
				
				<#if (u.paystate=='0')>
					<a href="InitPayPage.action?redirecturl=findAllUserOrderOn.action?&orderid=${u.orderid}"><font color="red">付款</font></a><br/>
					<a href="InitMyOrdersDetail.action?orderid=${u.orderid}" target="_blank">订单详细</a><br/>
					<a href="${u.logisticswebaddress}" target="_blank">追踪物流</a><br/>
				</#if>
				</td>
				<td>
					<#if (u.paystate=='1')>
						<span>您已付款</span><br/>
						</#if>
						<#if (u.shippingstate=='1')>
						<span>商家已发货</span>
						</#if>
						<#if (u.shippingstate=='0')>
							<span>配货中</span>									
						
					
					<#else>
						<span>您未付款</span>
					</#if>
					<br/>
				</td>
			</tr>
			<tr>
				<td style="text-align:center;background-color:#EBF4FB;">订单备注</td>
				<td style="" id="bz${o.orderid}" colspan="6">${o.customernotes}</td>
			</tr>
			</#list>
			</#if>
			</tr>
          </tbody>
        </table>
      </div>
      <!-- 普通商品订单代码结束 -->
      <!-- 手机直充订单列表 -->

      <div style="clear:both;"></div>
    </div>
  </div>
  <div class="mem_fixHeight"></div>
</div>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>