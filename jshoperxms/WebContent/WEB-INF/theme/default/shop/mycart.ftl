<!DOCTYPE HTML>
<html>
<head>
	<title>${(jshopbasicinfo.jshopname)}</title>
	<meta name="Author" content="jshoper3x">
	<meta name="Copyright" content="jshoper3x">
	<meta http-equiv="expires" content="0">
	<#if (jshopbasicinfo.metaKeywords)! != "">
	<meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/>
</#if>
<#if (jshopbasicinfo.metaDes)! != "">
<meta name="description" content="${jshopbasicinfo.metaDes}"/>
</#if>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">
<div class="clear"></div>
<!--载入主导航文件-->
<#include "/WEB-INF/theme/default/shop/mainnavigation.ftl">
<div class="clear"></div>

<section id="main" class="entire_width">
<div class="container_12">
	<div class="grid_12">
		<div class="cart_check">
			<h1 class="page_title">我的购物清单</h1>

			<table class="cart_product">
				<tr>
					<th class="images">商品编号</th>
					<th class="bg name"></th>
					<th class="bg name">商品名</th>
					<th class="bg price">单价</th>
					<th class="qty">数量</th>
					<th class="bg subtotal">积分</th>
					<th class="close"></th>
				</tr>
				<#if (membercart??)&&(membercart?size>0)>
					<#list membercart as cart>
					<tr>
						<td class="images">
							${cart.usersetnum}
						</td>
						<td class="bg name">
						<a href="${basepath}/${cart.htmlpath}"><img style="width:100px;height:100px;" src="${basepath}${cart.picture}" alt=""></a> 
						</td>
						<td class="bg name">
							
								
								<a href="${basepath}/${cart.htmlpath}">${cart.goodsname}</a> 
							
						</td>
						<td class="bg price">￥${cart.favorable}</td>
						<td class="qty">
							<input type="text" name="amount${cart.goodsid}" id="amount${cart.goodsid}"  value="${cart.needquantity}" readonly="true" />
						</td>
						<td class="bg subtotal">${cart.points}</td>
						<td class="close">
							<a title="close" class="close" href="#" onclick="delCartByid(${cart.id});"></a>
						</td>
						<!-- 隐藏的goodsid -->
						<input type="hidden" id="hidgoodsid" name="hidgoodsid" value="${cart.goodsid}"/>
						<!-- 隐藏的productid -->
						<input type="hidden" id="hidproductid" name="hidproductid" value="${cart.productid}"/>
					</tr>
					</#list>
				</#if>
				<tr>
					<td colspan="7" class="cart_but">
						<button id="goonshopping" name="goonshopping" class="continue">
							<span>icon</span>
							继续购物
						</button>
						<button id="refreshcart" name="refreshcart" class="update">
							<span>icon</span>
							刷新清单
						</button>
					</td>
				</tr>
			</table>
			<div class="bottom_block total">
				<table class="subtotal">
					<tr class="grand_total">
						<td>商品总价（不含运费）</td>
						<td class="price">￥${totalmemberprice}</td>
					</tr>
				</table>
				<button class="checkout" id="gotojiesuan" name="gotojiesuan">去结算</button>
				<a href="#">下一步，填写您的收货信息。</a>
			</div>
		</div>
	</div>
	<!-- .grid_12 -->

	<div class="clear"></div>
	<!-- .carousel -->

</div>
<!-- .container_12 -->
</section>
<!-- #main -->
<!--hidden params area-->
<!--用于重新登录后的跳转链接-->
<input type="hidden" id="hidbasepath" name="hidbasepath" value="${basepath}"/>
<!--用于重新登录后的跳转链接-->
<input type="hidden" id="hidurl" name="hidurl" value=""/>
<div class="clear"></div>
<#include "/WEB-INF/theme/default/shop/footer.ftl"></body>
</html>