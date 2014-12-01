<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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

      <div id="orders_infom1" class="consignee_info">
        <h1 class="page_title">收货人信息</h1>
        <a style="font-size: 12px; font-weight: normal;" href="javascript:void(0);" onclick="showaddress1('orders_infom1','orders_boxm1');" class="orderBlue"></a>
        <div class="consignee_div2" id="" style="padding-bottom: 4px;">
          <div class="consignee_address_wrap">
            <!--获取常用地址数据-->

            <#if (deliveraddress??)&&(deliveraddress?size>
            0)>
            <div class="consignee_address">
              <span class="fb">常用地址</span>
            </div>
            <table class="cart_product">
              <tr>
                <th class="qty"></th>
                <th class="qty">收货人</th>
                <th class="qty">手机号</th>
                <th class="qty">固定电话</th>
                <th class="bg">地址</th>

              </tr>
              <#list deliveraddress as da>

              <tr>
                <td class="qty">
                  <#if (da.addressid)==(myorderinfo.deliveraddressid)>
                  <input id="checkaddress" name="checkaddress" value="${da.addressid}" type="radio" checked="checked"/>
                  <#else>
                  <input id="checkaddress" name="checkaddress" value="${da.addressid}" type="radio"/>
                </#if>
              </td>
              <td class="qty">${da.shippingusername}</td>
              <td class="qty">${da.mobile}</td>
              <td class="qty">${da.telno}</td>
              <td class="bg">${da.province}-${da.city}-${da.district}-${da.street}</td>

            </tr>
          </#list>
        </table>
      </#if>
    </div>

    <div id="addnewaddressarea">
      <div id="newaddress">
        <div> <strong>收货人姓名:</strong> <sup class="surely">*</sup>
          <br/>
          <input type="text" name="membername" id="membername" value=""></div>
        <div> <strong>国家:</strong> <sup class="surely">*</sup>
          <br/>
          <select id="country" name="country">
            <option value="1">中国</option>
          </select>
        </div>
        <div id="ChinaArea">
          <strong>省份:</strong>
          <sup class="surely">*</sup>
          <br/>
          <select id="province" name="province" style="width: 100px;"></select>
          <select id="city" name="city" style="width: 100px;"></select>
          <select id="district" name="district" style="width: 120px;"></select>
        </div>
        <div>
          <strong>地址:</strong>
          <sup class="surely">*</sup>
          <br/>
          <input type="text" class="input2" maxlength="40" name="street" id="street" value="" style="width: 400px;"/>
        </div>
        <div>
          <strong>邮政编码:</strong>
          <br/>
          <input type="text" name="postcode"  id="postcode" value="">
          <cite >有助于快速确定送货地址</cite>
        </div>
        <div>
          <strong>手机号码:</strong>
          <sup class="surely">*</sup>
          <br/>
          <input type="text"  name="mobile" id="mobile" maxlength="11" value="" />
          <cite >用于接收发货通知短信及送货前确认</cite>
        </div>
        <div>
          <strong>固定电话:</strong>
          <br/>
          <input type="text" name="telno" id="telno" maxlength="11" value="" />
          <cite >有助于快速确定送货地址</cite>
        </div>
        <div>
          <strong>电子邮件:</strong>
          <sup class="surely">*</sup>
          <br/>
          <input type="text" name="email"  id="email" value="" />
          <cite >方便您及时获取虚拟物品信息</cite>
        </div>
        <div>
          <input id="savemyaddress" name="savemyaddress" type="button" value="保存收货人信息"  />
          <cite id="addressmsg"></cite>
        </div>
      </div>

    </div>
  </div>
</div>

</div>

<div class="cart_check">
<!--支付方式和配送方式-->
<div class="payingdeliver" id="orders_boxm3">
  <h1 class="page_title">支付及配送方式</h1>

  <div id="payinfo">
    <p>
      支付方式：
      <#if (payments??)&&(payments?size>
      0)>
      <#list payments as pm>

      <#if (pm.paymentCode=='zfb')>
      <input id="paymentid" name="paymentid" type="radio" value="${pm.paymentid}"/>
      <img src='${basepath}/pay/alipay/alipay_logo.png'/>
    </#if>
    <#if (pm.paymentCode=='cft')>
    <input id="paymentid" name="paymentid" type="radio" value="${pm.paymentid}"/>
    <img src='${basepath}/pay/tenpay/caifutong.gif'/>
  </#if>
</#list>
<#else>无</#if>
</p>

<p>
配送方式：
<#if (logistics??)&&(logistics?size>
0)>
<#list logistics as l>
<br/>
<#if l.visible=='1'>
<input id="logisticsid" name="logisticsid" type="radio" value="${l.logisticsid}" checked="checked"/>
${l.logisticsname}
<div class="middle">
运    费：${freight}
<input type="hidden" id="hd${l.logisticsid}" name="hd${l.logisticsid}" value="${l.website}"/>
</div>
</#if>
</#list>
<#else>无</#if>
</p>
</div>
<br></div>
</div>

<!--订单备注-->
<div class="cart_check">
<div class="payingdeliver" id="orders_boxm3">
<h1 class="page_title">
订单备注
<a id="modifyorderbz">[修改]</a>
</h1>
<div>
<p>
<div style="text-align:center;">
<textarea id="customernotes" name="customernotes" rows="2" cols="100"></textarea>
</div>
</p>
</div>
<br></div>
</div>



<div class="cart_check">

<h1 class="page_title">订单信息</h1>
<#if (myorderinfo??)>
<table class="cart_product">
<tbody>
<tr >
<th class="images">订单编号</th>
<th class="bg name">订单名称</th>
<th class="bg price">上次下单时间</th>
<th class="bg price">商品数量</th>
</tr>

<tr>
<td class="td3">${myorderinfo.orderid}</td>
<td class="td1">
<div class="name">
<a href="InitMyOrdersDetail.action?orderid=${myorderinfo.orderid}">${myorderinfo.ordername}</a>
</div>
</td>
<td class="td3">${myorderinfo.purchasetime}</td>
<td class="td4">${myorderinfo.needquantity}</td>
</tr>

</tbody>
</table>
</#if>
</div>

<div class="cart_check">
<h1 class="page_title">结算信息</h1>
<table style="font-weight:normal;">
<tbody>
<tr>
<td align="right">商品金额：</td>
<td align="right">
&nbsp;&nbsp;&nbsp;
<span style="color:red">￥</span>
<span id="goodstotalprice" style="color:red">${myorderinfo.amount}</span>
</td>
</tr>
<tr>
<td align="right">运费：</td>
<td align="right">
+&nbsp;
<span style="color:red">￥</span>
<span id="goodsfreightprice" style="color:red">${freight}</span>
</td>
</tr>
<tr id="totalAmountRow" style="font-weight:bold;">
<td align="right">
<p style="font-size:20px;">订单应付总额：</p>
</td>
<td align="right">
<cite>
￥
<span id="shouldtotalprice">${myorderinfo.shouldpay}</span>
</cite>
</td>
</tr>
</tbody>
</table>
<input id="submitlink" type="button" onclick="InitAgAlipayandUpdateOrder();" value="在线支付" />

</div>
</div>

</div>

</section>
<div class="clear"></div>
<!--hidden params area-->
<!--隐藏的数据-->
<input type="hidden" name="hidorderid" id="hidorderid" value="${myorderinfo.orderid}"/>
<!--用于重新登录后的跳转链接-->
<input type="hidden" id="hidurl" name="hidurl" value=""/>
<script type="text/javascript" src="${basepath}/ui/default/js/location.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/YLChinaArea.js"></script>
<#include "/WEB-INF/theme/default/shop/footer.ftl"></body>
</html>