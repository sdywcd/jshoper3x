<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>

</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">
<#include "/WEB-INF/theme/default/shop/usermenu.ftl">

<div id="mem_right" name="mem_right"  width="100%" height="606" frameborder="0" scrolling="no" onload="javascript:dyniframesize('mem_right');" style="display: block; ">
  <div id="ind_r">
    <div class="m1top"><span>会员信息</span></div>
    <div class="m1">
      <div class="l">
        <div class="img"> <img src="${basepath}/ui/default/images/hui_100_100.jpg" alt=""> </div>
        <div class="update"><a href="/Member/UserUpdateForm.do">修改头像</a></div>
      </div>
      <div class="r">
        <ul>
		  <#if Session??&&Session["user"]?exists>
          <li>
		  
		  您好！<span class="name">${user.username}</span>&nbsp;&nbsp;欢迎您回来！
		  
		  </li>
          <li>您有【 <span class="huiind_s1">0</span> 条未读信息】，<a href="/Member/ReceiverList.do">查看</a>。</li>
          <li>您有【 <span class="huiind_s1" id="orderCount">0</span> 个正在处理的订单】，<a id="orderHref" href="#">查看</a>。</li>
          <li>您现在拥有的积分为：【<b><span class="huiind_s2">${user.points}</span></b>】</li>
          <li> 您现在拥有的购物券：【<b><span class="huiind_s2">0 张  共0元 </span></b>】
          </li>
          <li> 
            你的会员等级为：【<b><span class="huiind_s2"> 注册会员</span></b>】 </li>
		  </#if>
        </ul>
      </div>
    </div>
    <div style="margin-top:10px;" class="m1top"><span>我的最新订单</span></div>
    <div class="huiind_rm2">
      <div class="huiind_rm2th">
		<table>
			<tbody>
				<tr class="trhead">
					<td class="huiind_rm2th2">订单号</td>
					<td class="huiind_rm2th1">名称</td>
					<td class="huiind_rm2th1">下单时间</td>
					<td class="huiind_rm2th3">订单金额</td>
					<td class="huiind_rm2th4">订单状态</td>
					<td class="huiind_rm2th5">操作</td>
				</tr>
				<#if (userorderon??)&&(userorderon?size>0)>
					<#list userorderon as uo>
					<tr>
						<td>${uo.orderid}</td>
						<td><a target='_blank' href="InitMyOrdersDetail.action?orderid=${uo.orderid}">${uo.goodsname}</a></td>
						<td>${uo.purchasetime}</td>
						<td>${uo.shouldpay}</td>
						
						<td>
						<#if (uo.paystate=='1')>
							<span>您已付款</span><br/>
							</#if>
							<#if (uo.shippingstate=='1')>
							<span>商家已发货</span>
							</#if>
							<#if (uo.shippingstate=='0')>
							<span>配货中</span>									
						<#else>
							<span>您未付款</span>
						</#if>
						<br/>
						</td>
						<td>
						<#if (uo.orderstate=='0')>
							<span>等待商家确认</span><br/>
						
						<#elseif (uo.orderstate=='1')>
							<span>已确认配货中</span><br/>
						
						<#elseif (uo.orderstate=='4')>
							<span>退货</span><br/>
						
						<#elseif (uo.orderstate=='5')>
							<span>关闭</span><br/>
						
						<#elseif (uo.orderstate=='7')>
							<span>缺货</span><br/>
						
						<#elseif (uo.orderstate=='9')>
							<span>成功</span><br/>
						
						<#elseif (uo.orderstate=='3')>
							<a href="http://www.alipay.com" target="_blank"><font color="red">确认收货</font></a>										
						<br/>
						</#if>
						
						<#if (uo.paystate=='0')>
						<!--InitPayPage.action InitMyOrdersDetail-->
							<a href="InitPayPage.action?redirecturl=findAllUserOrderOn.action?&orderid=${uo.orderid}"><font color="red">付款</font></a><br/>
							<a href="InitMyOrdersDetail.action?orderid=${uo.orderid}" target="_blank">订单详细</a><br/>
							<a href="${uo.logisticswebaddress}" target="_blank">追踪物流</a><br/>
						</#if>
						</td>
					</tr>
					</#list>
				</#if>
			</tbody>
		</table>
      </div>
    </div>
	
    <div class="m2top"><span>商品推荐</span></div>
    <div class="m3">
	<#if (shufflerecommendgoods??)&&(shufflerecommendgoods?size>0)>
		<#list shufflerecommendgoods as scg>
		<div class="each1">
			<div class="img"><a href="${basepath}/<@scg.htmlPath?interpret />" target="_blank">
			<#list scg.pictureurl?split(",") as img>
			<#if img_index==0>
			<img style="width:120px;height:120px;" src="${basepath}/${img}" alt="${scg.goodsname}">
			</#if>
			</#list>
			</a>
			</div>
			<div class="name"><a href="${basepath}/<@scg.htmlPath?interpret />" target="_blank" title="${scg.goodsname}">${scg.goodsname}</a></div>
			<div id="commend${scg.goodsid}">
			  <div class="price2">会员价：<span>￥${scg.memberprice}</span></div>
			</div>
		</div>
		</#list>
	</#if>
    </div>
  </div>
</div>
</div>
<div id="dtmem_bot" class="dtmem_bot_ind"></div>
</div>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>