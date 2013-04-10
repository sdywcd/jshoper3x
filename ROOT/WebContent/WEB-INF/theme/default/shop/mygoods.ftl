
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
  <head> 
    
   <title>${jshopbasicinfo.jshopname}我的抵用券</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<#if (jshopbasicinfo.metaKeywords)! !=""><meta http-equiv="keywords" content="${jshopbasicinfo.metaKeywords}"></#if>
	<#if (jshopbasicinfo.metaDes)! !=""><meta http-equiv="description" content="${jshopbasicinfo.metaDes}"></#if>
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}//ui/default/css/style_usercenter.css" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}//ui/default/css/style_green.css" />
	<link rel="stylesheet" type="text/css" href="${basepath}//ui/default/css/tabs-accordion-usercenter.css"/>
	<script type="text/javascript"  src="${basepath}//ui/default/js/jquery1.4.2.js"></script>
	<script type="text/javascript" src="${basepath}//ui/default/js/jquery.tools.min.js"></script>
  	<script type="text/javascript" src="${basepath}//js/mygoodsjs.js"></script>
  	<!--[if IE 6]>
	<style>
	body {behavior: url("<%=basePath%>ui/default/css/csshover3.htc");}
	</style>
	<![endif]-->


  </head>
  
<body>

<input type="hidden" name="hidurl" id="hidurl"/>


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
		
		<!-- 读取导航菜单 -->
		  <div id="menu">
			<ul>
				<#list siteNavigationList as navigation>
					<#if navigation.position="2">
					<li>
						<a href="${basepath}//<@navigation.htmlPath?interpret />"
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

				<br class="clear"/>
				<div id="cart_info">
					<div class="cart_img">
						<img src="ui/default/images_green/cart_004.gif" alt="已买到商品" />
					</div>
					
					<div class="list_cart">
						<h2><strong>我的未处理订单</strong></h2>
					</div>
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
								<#if (userorder??)&&(userorder?size>0)>
								<#list userorder as myorder>
								<tr class="align_Center">
									<td style="padding: 5px 0pt;">${myorder.orderid}</td>
									<td class="align_Left">
										<span>
											<a href="GetOrderdetailbyorderid.action?orderid=${myorder.orderid}">
												${myorder.goodsname}
											</a>
										</span>
									</td>
									<td>
										<span class="price">${myorder.shouldpay}</span>
									</td>
									<td>${myorder.purchasetime}</td>
									<td>
										${myorder.needquantity}
										<!-- 隐藏的orderid -->
										<input type="hidden" id="hidorderid" name="hidorderid" value="${myorder.orderid}"/>
									</td>
									<td>
									<#if (myorder.orderstate==3)>
										
										<a href="ConfirmGoodsReceive.action?orderid=${myorder.orderid}">确认收货</a><br/>
									
									<#else>
										<a href="InitMyOrdersDetail.action?orderid=${myorder.orderid}" target="_blank">订单详细</a><br/>
										<a>追踪物流</a><br/>
									</#if>
									
									</td>
									<td>
										<#if (myorder.shippingstate==1)>
											<span>商家已发货</span>
										
										<#else>
											<span>配货中</span>
										</#if>
										<br/>
										
										<#if (myorder.paystate==1)>
											<span>您已付款</span>
										
										<#else>
											<span>您未付款</span>
										</#if>
										<br/>
										
										<#if (myorder.orderstate==6)||(myorder.orderstate==5)>
										<a href="DelOrderByorderid.action?orderid=${myorder.orderid}">删除</a><br/>
										</#if>
									</td>
								</tr>
								<tr>
									<td style="display:none;" id="bz${myorder.orderid}" colspan="7">${myorder.customernotes}</td>
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
					
					<div class="round">
						<div class="lround"></div>
						<div class="rround"></div>
					</div>
					
				</div>
				
				<br class="clear" />
		
			

				
				
			</div>
	
		</div>
		
		<div id="secondaryContent_2columns">
		
			<div id="columnC_2columns">
	
				<#include  "/WEB-INF/theme/default/shop/usercentermenu.ftl" >

			</div>

		</div>

		<br class="clear" />

	</div>

</div>


    <#include "/WEB-INF/theme/default/shop/footer.ftl">
  </body>
</html>
