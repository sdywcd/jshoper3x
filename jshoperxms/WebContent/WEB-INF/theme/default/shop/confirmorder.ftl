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
      <#if (deliveraddress??)&&(deliveraddress?size>0)>
       <div class="consignee_address"> <span class="fb">常用地址</span> </div>
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
             <#if da.state=='1'>
                <input id="checkaddress" name="checkaddress" value="${da.addressid}" type="radio" checked="checked"/>
             <#else>
              <input id="checkaddress" name="checkaddress" value="${da.addressid}" type="radio"/>
             </#if>
            </td>
            <td class="qty">
              ${da.shippingusername}
            </td>
            <td class="qty">
              ${da.mobile}
            </td>
            <td class="qty">
              ${da.telno}
            </td>
            <td class="bg">
              ${da.province}-${da.city}-${da.district}-${da.street}
            </td>
           
        </tr>
      </#list>
    </table>
      </#if>
    
        </div>
    
    <div id="addnewaddressarea">
     <div id="newaddress">
        <div>
          <strong>收货人姓名:</strong><sup class="surely">*</sup><br/>
         <input type="text" name="membername" id="membername" value="">
        </div>
        <div>
          <strong>国家:</strong><sup class="surely">*</sup><br/>
            <select id="country" name="country">
              <option value="1">中国</option>
            </select>
        </div>
        <div id="ChinaArea">
          <strong>省份:</strong><sup class="surely">*</sup><br/>
            <select id="province" name="province" style="width: 100px;"></select>
            <select id="city" name="city" style="width: 100px;"></select>
            <select id="district" name="district" style="width: 120px;"> </select>      
        </div>
        <div>
          <strong>地址:</strong><sup class="surely">*</sup><br/>
            <input type="text" class="input2" maxlength="40" name="street" id="street" value="" style="width: 400px;"/>
        </div>
        <div>
          <strong>邮政编码:</strong><br/>
            <input type="text" name="postcode"  id="postcode" value="">
            <cite >有助于快速确定送货地址</cite>
        </div>
        <div>
          <strong>手机号码:</strong><sup class="surely">*</sup><br/>
             <input type="text"  name="mobile" id="mobile" maxlength="11" value="" />
            <cite >用于接收发货通知短信及送货前确认</cite> 
        </div>
        <div>
          <strong>固定电话:</strong><br/>
             <input type="text" name="telno" id="telno" maxlength="11" value="" />
            <cite >有助于快速确定送货地址</cite>
        </div>
        <div>
          <strong>电子邮件:</strong><sup class="surely">*</sup><br/>
             <input type="text" name="email"  id="email" value="" />
             <cite >方便您及时获取虚拟物品信息</cite>
        </div>
        <div>
         <input id="savemyaddress" name="savemyaddress" type="button" value="保存收货人信息"  /><cite id="addressmsg"></cite>
       </div>
      </div>
         
       </div>
      </div>
    </div>
  </div>


    <!--支付方式和配送方式-->
    <div class="cart_check">
    <div class="payingdeliver" id="orders_boxm3">
     <h1 class="page_title">支付及配送方式</h1>
    
      <div id="payinfo">
        <p> 支付方式：
    <#if (payments??)&&(payments?size>0)>
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
    <#else>
    无
    </#if>
     </p>
    
        <p> 配送方式：
    <#if (logistics??)&&(logistics?size>0)>
    <#list logistics as l>
    <br>
    <#if l.visible=='1'>
    <input id="logisticsid" name="logisticsid" type="radio" value="${l.logisticsid}" checked="checked"/>
    ${l.logisticsname}
    <div class="middle">
     运    费：${freight}
    <input type="hidden" id="hd${l.logisticsid}" name="hd${l.logisticsid}" value="${l.website}"/>
    </div>
    </#if>
    </#list>
    <#else>
    无 
    </#if>
    </p>
      </div>
      <br>
    </div>
  </div>
  
      <!--订单备注-->
        <div class="cart_check">
    <div class="payingdeliver" id="orders_boxm3">
     <h1 class="page_title">订单备注<a id="modifyorderbz">[修改]</a></h1>
      <div>
        <p> 
    <div style="text-align:center;">
    <textarea id="customernotes" name="customernotes" rows="2" cols="100"></textarea>
    </div>
     </p>
      </div>
      <br>
    </div>
  </div>
    <div class="cart_check">
      <h1 class="page_title">商品信息</h1>

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
    </div>
      <div class="cart_check">
   <div class="settlement_amount" align="center">
        <div id="amountListTable" class="settlement_amount" align="center">
          <table style="font-weight:normal;">
            <tbody>
              <tr>
                <td align="right">商品金额：</td>
                <td align="right">&nbsp;&nbsp;&nbsp;<span style="color:red">￥</span> <span id="goodstotalprice" style="color:red">${totalprice}</span></td>
              </tr>
              <tr>
                <td align="right">运费：</td>
                <td align="right">+&nbsp;<span style="color:red">￥</span> <span id="goodsfreightprice" style="color:red">${freight}</span></td>
              </tr>
        <tr>
                <td align="right">总积分：</td>
                <td align="right">+&nbsp;<span style="color:red">￥</span> <span id="goodstotalpoints" style="color:red">${totalpoints}</span></td>
              </tr>
              <tr id="totalAmountRow" style="font-weight:bold;">
                <td align="right"><p style="font-size:20px;">订单应付总额：</p></td>
                <td align="right"><cite>￥<span id="shouldtotalprice">${totalfreight}</span></cite></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
          <div class="confirm_btn">
        <div class="add_explanation">
          <div class="set_l_div4" id="orders_boxm10">
            <div class="set_div4_div1"></div>
          </div>
        </div>
        <div class="confirm_right">
          <br>
      <!--隐藏的数据-->
      <!--购物车中商品id-->
      <input id="cartgoodsid" name="cartgoodsid" type="hidden" value="${cartgoodsid}">
      <!---购物车中商品名称集合cartgoodsname-->
      <input id="cartgoodsname" name="cartgoodsname" type="hidden" value="${cartgoodsname}">
      <!--购物车中所有商品数量总和-->
      <input id="cartneedquantity" name="cartneedquantity" type="hidden" value="${cartneedquantity}">
      <!--购物车id-->
      
      <input id="cartid" name="cartid" type="hidden" value="${cartid}">
     
       <input id="submitorder" name="submitorder" type="button" value="提交订单"/>

      </div>
      </div>
    </div>
  </div>
  
   
  <!-- .grid_12 -->

  <div class="clear"></div>
  <!-- .carousel -->

</div>
<!-- .container_12 -->
</section>
<div class="clear"></div>
<!--hidden params area-->
<!--用于重新登录后的跳转链接-->
<input type="hidden" id="hidurl" name="hidurl" value=""/>
<script type="text/javascript" src="${basepath}/ui/default/js/location.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/YLChinaArea.js"></script>
<#include "/WEB-INF/theme/default/shop/footer.ftl">

</body>
</html>

