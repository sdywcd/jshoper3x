<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的购物车${(jshopbasicinfo.jshopname)}</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/shopcar.css" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="main">
<input id="hidurl" name="hidurl" type="hidden" value=""/>
  <div id="errorMsgDiv" style="padding-left: 20px; "> <font color="red">&nbsp;&nbsp;&nbsp;&nbsp;温馨提示：</font>请输入正确的商品数量！ </div>
  <div class="head_nav">
				<div class="head_shopcar_step">
					<div class="steppic">
						<img src="${basepath}/ui/default/images/step_1.gif">
					</div>
					<div class="step1">
						我的购物车
					</div>
					<div class="steppic">
						<img src="${basepath}/ui/default/images/step_3.gif">
					</div>
					<div class="step2">
						填写核对订单
					</div>
					<div class="steppic">
						<img src="${basepath}/ui/default/images/step_5.gif">
					</div>
					<div class="step2">
						成功提交订单
					</div>
					<div class="steppic">
						<img src="${basepath}/ui/default/images/step_4.gif">
					</div>
				</div>
			</div>
  <div class="cartcontent" id="showcart">
    
    <div class="st1_div1">
      <table class="car_table3" cellspacing="0" cellpadding="0" id="cartTable2">
        <tbody>
          <tr class="title">
		  <td>商品编号</td>
            <td>商品名称</td>
            <td>价格（元）</td>
            <td>商品数量</td>
            <td>获积分</td>
            <td>操作</td>
          </tr>
          <!--当前可卖数-->
          <!--安全可卖数-->
		  <#if (usercart??)&&(usercart?size>0)>
		  <#list usercart as cart>
          <tr id="cartitemAll_30003301">
		  <td class="td3">${cart.usersetnum}</td>
            <td class="td2">
				<div class="img"> 
				<a href="${basepath}/html/default/shop/${cart.goodsid}.html"><img src="${basepath}${cart.picture}" alt=""></a> 
				</div>
				<div class="name"> <a href="${basepath}/html/default/shop/${cart.goodsid}.html">${cart.goodsname}</a> </div>
			</td>
              <td class="td3"><span>￥${cart.price}</span><br>
              ￥${cart.favorable} </td>
			<#if cart.productid=="0"||cart.productid=="">
            <td class="td4">
			   <a id="reduceamount" onclick="changereduceamount(${cart.goodsid},${cart.weight},${cart.favorable?string('0')})">
				<img src="${basepath}/ui/default/images/bag_close.gif" alt="" />
			</a>
			<input onblur="changeinfo(${cart.goodsid},${cart.weight},${cart.favorable?string('0')})" type="text" name="amount,${cart.favorable?string('0')},${cart.weight}" id="amount${cart.goodsid}" value="${cart.needquantity}" size="2"/>
			<a id="plusamount"  onclick="changeplusamount(${cart.goodsid},${cart.weight},${cart.favorable?string('0')})">
				<img src="${basepath}/ui/default/images/bag_open.gif" alt="" />
			</a>
			<!-- 隐藏的goodsid -->
			<input type="hidden" id="hidgoodsid" name="hidgoodsid" value="${cart.goodsid}"/>
			</td>
			<#else>
			<td class="td4">
			   <a id="reduceamount" onclick="changereduceamount(${cart.productid},${cart.weight},${cart.favorable?string('0')})">
				<img src="${basepath}/ui/default/images/bag_close.gif" alt="" />
			</a>
			<input onblur="changeinfo(${cart.productid},${cart.weight},${cart.favorable?string('0')})" type="text" name="amount,${cart.favorable?string('0')},${cart.weight}" id="amount${cart.productid}" value="${cart.needquantity}" size="2"/>
			<a id="plusamount"  onclick="changeplusamount(${cart.productid},${cart.weight},${cart.favorable?string('0')})">
				<img src="${basepath}/ui/default/images/bag_open.gif" alt="" />
			</a>
			<!-- 隐藏的goodsid -->
			<input type="hidden" id="hidproductid" name="hidproductid" value="${cart.productid}"/>
			</td>
			</#if>
            <td class="td5"><span id="integral">${cart.points}</span></td>
            <td class="td7">
				
              <a href="javascript:void(0)" onclick="delCartByid(${cart.id});">删除</a>
			
			  </td>
          </tr>
          </#list>
		 </#if>
        </tbody>
      </table>
    </div>
    <div class="st1_div2" id="integerPoint">
      <span></span>
       <div class="st1_div2_r">重量总计：<span id="totalweight">${totalweight}</span>克
      </div>
      <div class="st1_div2_r">商品总价（不含运费）：<span id="totalmemberprice">${totalmemberprice}</span>元
      </div>
    </div>
    <div class="st1_btn" id="others">
      <div class="myc_delTips2" id="delAll1" style="display:none;">
        <div class="box">你确定要删除吗？<br>
          <a style="color:#c00; text-decoration:none;" href="/DelCartItem.do?mid=0&amp;ItemId=&amp;ObjectId=&amp;ObjectType=&amp;deliveryDepartmentId=" class="sea_keyword">[确定]</a>&nbsp;&nbsp;<a style="color:#c00; text-decoration:none;" href="javascript:void(0);" onclick="showDelAllCart('delAll','1');">[取消]</a></div>
        <div class="bot"></div>
      </div>
      <!--<a href="javascript:;" onclick="showDelAllCart('delAll','1')"><img src="${basepath}/ui/default/images/cart_btn1.gif"></a>-->
	  <a href="${basepath}/index.html"><img src="${basepath}/ui/default/images/cart_btn2.gif"></a>
      <a id="gotojs" onclick="gotojs();" href="#" class="nextbtn1"> <img src="${basepath}/ui/default/images/cart_btn3.gif"> </a> </div>
  </div>
</div>
<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>