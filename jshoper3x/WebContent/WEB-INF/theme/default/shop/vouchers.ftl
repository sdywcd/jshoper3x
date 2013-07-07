<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
  <head>
   
    
    <title>我的抵用券</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<#if (jshopbasicinfo.metaKeywords)! !=""><meta http-equiv="keywords" content="${jshopbasicinfo.metaKeywords}"></#if>
	<#if (jshopbasicinfo.metaDes)! !=""><meta http-equiv="description" content="${jshopbasicinfo.metaDes}"></#if>
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}/ui/default/css/style_usercenter.css" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basepath}/ui/default/css/style_green.css" />
	<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/tabs-accordion-usercenter.css"/>
	<script type="text/javascript"  src="${basepath}/ui/default/js/jquery1.4.2.js"></script>
	<script type="text/javascript" src="${basepath}/ui/default/js/jquery.tools.min.js"></script>
  	<script type="text/javascript" src="${basepath}/js/myvouchersjs.js"></script>
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

				<br class="clear"/>
				<div id="cart_info">
					<div class="cart_img">
						<img src="ui/default/images_green/cart_007.gif" alt="我的抵用券" />
					</div>
					<div class="list_cart">
						<h2><strong>我的抵用券</strong></h2>
					</div>
					<div class="cart_table">
						<table>
							<tbody>
								<tr class="trhead">
									<td width="10%" style="height:30px;">兑换码</td>
									<td>内容</td>
									<td width="14%">开始时间</td>
									<td width="14%">结束时间</td>
									<td width="10%">状态</td>
									<td width="9%"></td>
								</tr>
								<#if (vouchers??)&&(vouchers?size>0)>
								<#list vouchers as myvouchers>
								<tr class="align_Center">
									<td style="padding: 5px 0pt;">${myvouchers.vouchersname}</td>
									<td class="align_Left">
										<span>
												${myvouchers.voucherscontent}
										</span>
									</td>
									<td>
										<span class="price">${myvouchers.begintime}</span>
									</td>
									<td>${myvouchers.endtime}</td>
									<td>
										<span>${myvouchers.state}</span>
										<!-- 隐藏的抵用券id -->
										<input type="hidden" id="hidvouchersid" name="hidvouchersid" value="${myvouchers.vouchersid}"/>
										</td>
									<td></td>
								</tr>
								</#list>
								</#if>
							</tbody>
						</table>
	
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
