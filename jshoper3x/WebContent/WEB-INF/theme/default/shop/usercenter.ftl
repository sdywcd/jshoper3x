<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
  <head>
    <title>${(goodsCategory.name)}用户中心</title>
    <meta name="Author" content="OSTOCY">
	<meta name="Copyright" content="OSTOCY">
	<meta http-equiv="expires" content="0">      
    <meta name="keywords" content=""/>
	<meta name="description" content=""/>
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}/ui/default/css/style_usercenter.css" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}/ui/default/css/style_green.css" />
	<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/tabs-accordion-usercenter.css"/>
  	<script type="text/javascript"  src="${basepath}/ui/default/js/jquery1.4.2.js"></script>
	<script type="text/javascript" src="${basepath}/ui/default/js/jquery.tools.min.js"></script>

  	<!--[if IE 6]>
	<style>
	body {behavior: url("${basepath}/ui/default/css/csshover3.htc");}
	</style>
	<![endif]-->

  </head>
  
  <body>
  <input type="hidden" id="hidurl" name="hidurl" value=""/>
<div id="top_header">
	<div id="top_header_menu">
	<#include "/WEB-INF/theme/default/shop/top_header.ftl">
    </div>
</div>
<div id="header">

	<div id="header_inner" class="fixed">

		<div id="logo">
			<h2>www.soipay.com</h2>
		</div>
		  <div id="menu">
			<ul>
				<#list siteNavigationList as navigation>
					<#if navigation.position="2">
					<li>
						<a href="${basepath}/<@navigation.htmlPath?interpret />"
						<#if navigation.isTargetBlank="1"> target="_blank"</#if> class="active">${navigation.name}
						</a>
					</li>
				        </#if>
				</#list>
			</ul>
		 </div>
		
		
  </div>
</div>

<div id="main">

	<div id="main_inner" class="fixed">
	  <div id="top_main_inner" class="fixed">
   			<#include "/WEB-INF/theme/default/shop/headersearch.ftl">
      </div>
	  <div id="primaryContent_2columns">
			<div id="columnA_2columns">
					<div class="detail">
						<div class="usercenter_userinfo">
							<div class="head">
								<a href="#">
									<!--<s:if test="#session.user.headurl!=null">
										<img src="<%=basePath %>ui/default/images_green/hui.jpg" alt="" />
									</s:if>
									<s:else>
										<img src="<%=basePath %>ui/default/images_green/hui.jpg" alt="" />
									</s:else>-->
									
								</a>
								<!--<a class="modify" href="#">修改头像</a>-->
							</div>
							<div class="info">
								<strong>sdywcd</strong>
								<span class="point">积分：88</span>
							</div>
							<div class="useful-actions">
								<a href="#">安全设置</a>
								<a href="#">收货地址管理</a>
							</div>
							<div class="notice">
								<div class="wrapper">
									<div class="section">
										<ul>
											<li>待付款<a href="">(1)</a></li>
											<li>待确认收货<a href="">(2)</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				<div class="title">待处理订单</div>
				<div id="cart_info">
				<div class="cart_table">
						<table>
							<tbody>
								<tr class="trhead">
									<td width="10%" style="height:30px;">订单编号</td>
									<td>商品名称</td>
									<td width="14%">应付金额</td>
									<td width="15%">成交时间</td>
									<td width="5%">数量</td>
									<td width="12%">订单操作</td>
									<td width="12%"></td>
								</tr>
								<#if (userorderon??)&&(userorderon?size>0)">
								<#list userorderon as uo>
								<tr class="align_Center">
									<td style="padding: 5px 0pt;">${uo.orderid}</td>
									<td class="align_Left">
										<span>
											<a target="_blank"   href="InitMyOrdersDetail.action?orderid=${uo.orderid}">
												${uo.goodsname}
											</a>
										</span>
									</td>
									<td>
										<span class="price">${uo.shouldpay}</span>
									</td>
									<td>${uo.purchasetime}</td>
									<td>
										${uo.needquantity}
										<!-- 隐藏的orderid -->
										<input type="hidden" id="hidorderid" name="hidorderid" value="${uo.orderid}"/>
									</td>
									<td>
									<#if uo.orderstate=0>
										<span>等待商家确认</span><br/>
									<#elseif uo.orderstate=1>
										<span>已确认配货中</span><br/>
									<#elseif uo.orderstate=4>
										<span>退货</span><br/>
									<#elseif uo.orderstate=5>
										<span>关闭</span><br/>
									<#elseif uo.orderstate=7>
										<span>缺货</span><br/>
									<#elseif uo.orderstate=9>
										<span>成功</span><br/>
									<#elseif uo.orderstate=3>
										<a href="http://www.alipay.com" target="_blank"><font color="red">确认收货</font></a><br/>
									</#if>
									<#if uo.paystate=0>
										<a href="InitPayPage.action?redirecturl=findAllUserOrderOn.action?&orderid=${uo.orderid}"><font color="red">付款</font></a><br/>
									</#if>
									
										<a target="_blank"   href="InitMyOrdersDetail.action?orderid=<s:property value="${uo.orderid}">订单详细</a><br/>
										<a>物流信息</a><br/>
									</td>
									<td>
										<#if uo.paystate=1>
											<span>您已付款</span><br/>
											<#if uo.shippingstate=1>
											<span>商家已发货</span>
											</#if>
											<#if uo.shippingstate=0>
												<span>配货中</span>
											</#if>
										<#else>
											<span>您未付款</span>
										</#if>
										<br/>
										<a id="customernotes" onclick="showcustomernotes(<s:property value="${uo.orderid}"/>)">备注</a><br/>			
									</td>
								</tr>
								<tr>
									<td style="display:none;" id="bz<s:property value="${uo.orderid}"/>" colspan="7">${uo.customernotes}</td>
								</tr>
								</#list>
								</#if>
								
							</tbody>
						</table>
						<ul class="cart_bottom">
							<li class="libuyandjs">
								
								<div class="submit_btn" style="text-align:right;">
								
								</div>
							</li>
						</ul>
					</div>
					
				</div>
		    
			    <div class="title">我的购物车</div>
					<div id="cart_info">
					<div class="cart_table">
							<table>
								<tbody>
									<tr class="trhead">
										<td width="10%" style="height:30px;">商品编号</td>
										<td>商品名称</td>
										<td width="14%">会员价</td>
										<td width="8%">赠送积分</td>
										<td width="10%">商品数量</td>
										<td width="9%">删除商品</td>
									</tr>
									<s:if test="#session.usercart!=null">
									<s:iterator id="bean" value="#session.usercart.cart" status="cart">
									<tr class="align_Center">
										<td style="padding: 5px 0pt;"><s:property value="usersetnum"/></td>
										<td class="align_Left">
											<div class="p-img">
												<a href="GetGoodsdetailBygoodsid.action?goodsid=<s:property value="goodsid"/>">
													<img src="Uploads/<s:property value="picture"/>"/>
												</a>
											</div>
											<span>
												<a href="GetGoodsdetailBygoodsid.action?goodsid=<s:property value="goodsid"/>">
													<s:property value="goodsname"/>
												</a>
											</span>
										</td>
										<td>
											<span class="price"><s:property value="favorable"/></span>
										</td>
										<td><s:property value="points"/></td>
										<td>
											<a id="reduceamount" onclick="changereduceamount(<s:property value="goodsid"/>,<s:property value="weight"/>,<s:property value="favorable"/>)">
												<img src="ui/default/images_green/bag_close.gif" alt="" />
											</a>
											<input onblur="changeinfo(<s:property value="goodsid"/>,<s:property value="weight"/>,<s:property value="favorable"/>)" type="text" name="amount,<s:property value="favorable"/>,<s:property value="weight"/>" id="amount<s:property value="goodsid"/>" value="<s:property value="needquantity"/>" size="2"/>
											<a id="plusamount"  onclick="changeplusamount(<s:property value="goodsid"/>,<s:property value="weight"/>,<s:property value="favorable"/>)">
												<img src="ui/default/images_green/bag_open.gif" alt="" />
											</a>
											<!-- 隐藏的goodsid -->
											<input type="hidden" id="hidgoodsid" name="hidgoodsid" value="<s:property value="goodsid"/>"/>
											</td>
										<td><a href="DelCartByGoodsId.action?goodsid=<s:property value="goodsid"/>">删除</a></td>
									</tr>
									</s:iterator>
									</s:if>
								</tbody>
							</table>
							<ul class="cart_bottom">
								<li class="libuyandjs">
									
									<div class="submit_btn" style="text-align:right;">
										<a href="<%=basePath %>index.jsp" id="goonbuy">继续购物</a>
										<a  id="gotojs">去结算</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
			  
			    
			</div>
	
		</div>
		
		<div id="secondaryContent_2columns">
		
			<div id="columnC_2columns">
				<jsp:include page="usercentermenu.jsp"></jsp:include>
				
			</div>

		</div>

		<br class="clear" />

	</div>

</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">

	<!-- This JavaScript snippet activates those tabs -->
<script>
                    
$(function() { 

$("#accordion").tabs("#accordion div.pane", {tabs: 'h2', effect: 'slide', initialIndex: null});
});

                    </script>
</body>

</html>
