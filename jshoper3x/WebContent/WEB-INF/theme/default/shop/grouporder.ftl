<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>填写核对订单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/shopcar.css" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/location.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/YLChinaArea.js"></script>
</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">
<input type="hidden" id="hidurl" name="hidurl" value=""/>
<div id="main">
  <div class="head_nav">
    <div>
      <div class="head_shopcar_step">
        <div class="steppic"><img src="${basepath}/ui/default/images/step_1.gif"></div>
        <div class="step1">我的购物车</div>
        <div class="steppic"><img src="${basepath}/ui/default/images/step_2.gif"></div>
        <div class="step1">填写核对订单</div>
        <div class="steppic"><img src="${basepath}/ui/default/images/step_3.gif"></div>
        <div class="step2">成功提交订单</div>
        <div class="steppic"><img src="${basepath}/ui/default/images/step_4.gif"></div>
      </div>
    </div>
  </div>
  <div>
    <div id="orders_infom1" class="consignee_info">
      <h1>
        <p>收货人信息</p>
      </h1>
      <a style="font-size: 12px; font-weight: normal;" href="javascript:void(0);" onclick="showaddress1('orders_infom1','orders_boxm1');" class="orderBlue"></a>
      <div class="consignee_div2" id="" style="padding-bottom: 4px;">
        <div class="consignee_address_wrap">
			<!--获取常用地址数据-->
          <div class="consignee_address"> <span class="fb">常用地址</span> </div>
		  <#if (deliveraddress??)&&(deliveraddress?size>0)>
			<#list deliveraddress as da>
			  
				<div class="consignee_address" id="td2378038"> 
				<#if da.state=='1'>
			  <s><input id="checkaddress" name="checkaddress" value="${da.addressid}" type="radio" checked="checked"/></s>
			  <span> ${da.username}&nbsp;&nbsp;&nbsp;&nbsp;${da.mobile}&nbsp;&nbsp;&nbsp;&nbsp;${da.province}-${da.city}-${da.district}-${da.street}</span>
			  <#else>
			   <s><input id="checkaddress" name="checkaddress" value="${da.addressid}" type="radio"/></s>
			  <span> ${da.username}&nbsp;&nbsp;&nbsp;&nbsp;${da.mobile}&nbsp;&nbsp;&nbsp;&nbsp;${da.province}-${da.city}-${da.district}-${da.street}</span>
			  
				<cite> <a href="javascript:;" onclick="deladdress(${da.addressid});" class="myad_s2">删除</a> </cite>
				</#if>
				</div>
				
		
			</#list>
		  </#if>
		
        </div>
		
		<div id="addnewaddressarea">
        <ul id="newaddress" class="address_content">
          <li>
            <p> <span>*</span>收货人姓名 </p>
            <cite>
            <input type="text" class="input1" name="username" id="username" value="">
            </cite>
		  </li>
		   <li>
            <p> <span>*</span>国&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家 </p>
            <cite>
            <select id="country" name="country">
				<option value="1">中国</option>
			</select>
            </cite>
		  </li>
          <li>
            <p> <span>*</span>省&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份 </p>
            <cite><span id="regionCanvas">
			<div id="ChinaArea">
				<select id="province" name="province" style="width: 100px;"></select>
				<select id="city" name="city" style="width: 100px;"></select>
				<select id="district" name="district" style="width: 120px;"> </select>      
			</div>
            </span></cite>
          </li>
          <li>
            <p> <span>*</span>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址 </p>
            <cite><span id="showaddress11"></span></cite><cite>
            <input type="text" class="input2" maxlength="40" name="street" style="width: 400px;" id="street" onblur="checkreceiverAddress();" onfocus="aa(this);">
            </cite>
		  </li>
          <li>
            <p>邮政编码</p>
            <cite>
            <input type="text" name="postcode" class="input1" id="postcode">
            </cite> <cite id="heckout_consignee_input3">有助于快速确定送货地址</cite></li>
          <li>
            <p> <span>*</span>手机号码 </p>
            <cite>
            <input type="text" class="input1" name="mobile" id="mobile" maxlength="11">
            </cite> <cite>或者 固定电话</cite> <cite>
            <input type="text" class="input1" name="telno" id="telno" maxlength="11">
            </cite> <cite id="consignee_input7">用于接收发货通知短信及送货前确认</cite> <cite id="phoneMsg"></cite> </li>
		  <li>
            <p>电子邮件</p>
            <cite>
            <input type="text" name="email" class="input1" id="email" style="width: 200px;">
            </cite></li>       
	   </ul>
		</div>
        <div class="add_address"> <a href="javascript:;" onclick="addnewAddress();" class="cartbtn">
          <div class="savebtn consigneebtn">保存收货人信息</div>
          </a> </div>
      </div>
    </div>
	<!--支付方式和配送方式-->
    <div class="payingdeliver" id="orders_boxm3">
      <h1>
        <p>支付及配送方式</p>
      </h1>
      <div id="payinfo">
        <p> 支付方式：
		<#if (payments??)&&(payments?size>0)>
		<#list payments as pm>
		<input id="paymentid" name="paymentid" type="radio" value="${pm.paymentid}"/>
		${pm.paymentname}
		</#list>
		<#else>
		无
		</#if>
		 </p>
        <p> 配送方式：
		<#if (logistics??)&&(logistics?size>0)>
		<#list logistics as l>
		<#if l.visible=='1'>
		<input id="logisticsid" name="logisticsid" type="radio" value="${l.logisticsid}" checked="checked"/>
		${l.logisticsname}
		<div class="middle">
			<table style="width:100%">
				<tbody>
					<tr>
						<td style="text-align:right;width:80px;">运    费：</td>
						<td>${freight}</td>
						<td><input type="hidden" id="hd${l.logisticsid}" name="hd${l.logisticsid}" value="${l.website}"/></td>
					</tr>
				
				</tbody>
			</table>
		</div>
		<a id="modifylogistics" style="cursor:pointer;">[修改]</a>  <a style="display:none;cursor:pointer;" id="closelogistics">[关闭]</a>
		<#else>
		<!--更多配送方式-->
		<div id="otherlogistics" style="display:none;">
		<p>更多配送方式:
			<input id="logisticsid" name="logisticsid" type="radio" value="${l.logisticsid}"/>
			${l.logisticsname}
			<div class="middle">
				<table style="width:100%">
					<tbody>
						<tr>
							<td style="text-align:right;width:80px;">运    费：</td>
							<td>10</td>
						</tr>
					
					</tbody>
				</table>
			</div>
		</p>
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
	<!--订单备注-->
    <div class="payingdeliver" id="orders_boxm3">
      <h1>
        <p>订单备注<a id="modifyorderbz">[修改]</a> </p>
      </h1>
      <div>
        <p> 
		<div style="text-align:center;">
		<textarea id="customernotes" name="customernotes" rows="2" cols="100"></textarea>
		</div>
		 </p>
      </div>
      <br>
    </div>
    <div class="receiptinfo" id="orders_infom11" style="">
      <h1>
        <p>发票信息</p>
      </h1>
      <div class="receipt_div2">
        <div class="receipt_tab">
          <ul>
            <li>
              <p>
                <input type="radio" name="invoiceType0" value="0" id="invoiceType0">
                普通发票 </p>
            </li>
            <li>
              <p>
                <input type="radio" name="invoiceType0" value="1"  id="invoiceType0" checked="checked">
                不用发票 </p>
            </li>
          </ul>
        </div>
        <input type="hidden" id="invoiceTile" value="">
        <div class="receipt_show1" id="personInvoiceType">
          <ul>
            <li><span>发票抬头：</span></li>
            <li>
              <p>
                <input type="radio" name="invoiceTitle" value="1" id="perInvoiceTitle1">
                个人</p>
            </li>
            <li>
              <p>
                <input type="radio" name="invoiceTitle" value="2" id="perInvoiceTitle2">
                单位</p>
            </li>
            <li><span id="perCompanyName" style="display:none;"><code>*</code>单位名称：
              <input type="text" name="inv_payee" id="inv_payee" value="">
              </span></li>
          </ul>
          <ul>
            <li><span>发票内容：</span></li>
            <li>
              <p>
                <input type="radio" name="perInvoiceContent" id="perInvoiceContent1" value="0">
                明细</p>
              <cite></cite></li>
            <li>
              <p>
                <input type="radio" name="perInvoiceContent" id="perInvoiceContent2" value="1">
                办公用品</p>
              <cite></cite></li>
            <li>
              <p>
                <input type="radio" name="perInvoiceContent" id="perInvoiceContent3" value="2">
                电脑配件</p>
              <cite></cite></li>
            <li>
              <p>
                <input type="radio" name="perInvoiceContent" id="perInvoiceContent4" value="3">
                耗材</p>
              <cite></cite></li>
          </ul>
          <div class="savereceiptinfo"><a href="javascript:void(0);" onclick="saveInvoice(1);">
            <div class="savebtn receiptinfobtn1">保存发票信息</div>
            </a></div>
        </div>
    
      </div>
    </div>

  </div>
  
  <div class="detailinfo">
    <h1>
      <p>商品信息</p>
      
    <div class="detailinfo_div1">
	<#if (groupcart??)&&(groupcart?size>0)>
      <table align="center" cellpadding="0" cellspacing="0" class="car_table1">
        <tbody>
          <tr class="title">
		    <td style="height:30px;">商品编号</td>
            <td>商品名称</td>
            <td>价格</td>
            <td>数量</td>
            <td>获得积分</td>
            <td>库存状态</td>
          </tr>
		  
          <tr>
			<td class="td3"> ${groupcart.usersetnum}</td>
            <td class="td1"><div class="img"> <a href="${basepath}/html/default/shop/group/${groupcart.goodsid}.html"><img src="${groupcart.picture}" alt=""> </a> </div>
              <div class="name"> <a href="${basepath}/html/default/shop/group/${groupcart.goodsid}.html"> ${groupcart.goodsname} </a>
              </div></td>
            <td class="td3"> ￥${groupcart.groupprice} </td>
            <td class="td4"> ${groupcart.needquantity} </td>
            <td class="td5"><span id="points">${groupcart.points} </span></td>
            <td class="td6">
				<div id="cart"> 
					<span id="UnitPrice30083387">
					<#if (groupcart.quantity>0)>
						有货
					<#else>
						缺货（有货后即刻发货）
					</#if>
					</span> 
				</div>
			</td>
          </tr>
         
       
        </tbody>
      </table>
	  </#if>
    </div>
    <div class="settlement">
      <div class="set_l_div1">结算信息</div>
      <div class="settlement_deduction">
        <div id="myquandiv1" style="float: left; display: inline; ">
          <!-- 购物券层
          <div class="set_l_div2 hidden" id="myquandiv2" style="display: inline; ">
            <div class="set_l_div2_t"> <span><a href="javascript:;" onclick="onchangeGouWu('onGouWuId');"><img src="/datang/templets/Default/Default/images_order/icon10.gif"></a></span> <cite><a href="javascript:;" onclick="onchangeGouWu('onGouWuId');">使用我的购物券</a></cite> </div>
            <div>&nbsp;</div>
           <div class="set_l_div2_box" id="gouwuquan" style="display:none">
              <div class="set_div3_div2"><cite>我拥有的购物券：</cite><a href="/Member/index.jsp?url=MyCoupon.do" target="_blank" class="setbtn">使用新的优惠券</a></div>
              <br>
              <div class="set_div2_d5"> </div>
            </div>-->
          </div>
        </div>
      </div>
      <div class="settlement_amount" align="center">
        <div id="amountListTable" class="settlement_amount" align="center">
          <table style="font-weight:normal;">
            <tbody>
              <tr>
                <td align="right">商品金额：</td>
                <td align="right">&nbsp;&nbsp;&nbsp;<span style="color:red">￥</span> <span id="goodstotalprice" style="color:red"><#if (totalprice??)&&(totalprice?size>0)>${totalprice}</#if></span></td>
              </tr>
              <tr>
                <td align="right">运费：</td>
                <td align="right">+&nbsp;<span style="color:red">￥</span> <span id="goodsfreightprice" style="color:red"><#if (freight??)&&(freight?size>0)>${freight}</#if></span></td>
              </tr>
			  <tr>
                <td align="right">总积分：</td>
                <td align="right">+&nbsp;<span style="color:red">￥</span> <span id="goodstotalpoints" style="color:red"><#if (totalpoints??)&&(totalpoints?size>0)>${totalpoints}</#if></span></td>
              </tr>
              <tr id="totalAmountRow" style="font-weight:bold;">
                <td align="right"><p style="font-size:20px;">订单应付总额：</p></td>
                <td align="right"><cite>￥<span id="shouldtotalprice"><#if (totalfreight??)&&(totalfreight?size>0)>${totalfreight}</#if></span></cite></td>
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
		  <input id="cartgoodsid" name="cartgoodsid" type="hidden" value="<#if (cartgoodsid??)&&(cartgoodsid?size>0)>${cartgoodsid}</#if>">
		  <!---购物车中商品名称集合cartgoodsname-->
		  <input id="cartgoodsname" name="cartgoodsname" type="hidden" value="<#if (cartgoodsname??)&&(cartgoodsname?size>0)>${cartgoodsname}</#if>">
		  <!--购物车中所有商品数量总和-->
		  <input id="cartneedquantity" name="cartneedquantity" type="hidden" value="<#if (cartneedquantity??)&&(cartneedquantity?size>0)>${cartneedquantity}</#if>">
		  <!--购物车id-->
		  
		  <input id="cartid" name="cartid" type="hidden" value="<#if (cartid??)&&(cartid?size>0)>${cartid}</#if>">
          <img id="submitlink" onclick="InitAlipayandAddOrder();" style="cursor: pointer;" src="${basepath}/ui/default/images/submitbtn.gif"> </div>
      </div>
      <div class="clear"></div>
    </div>
  </div>
  </form>
</div>
<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
<script>
// 所在地插件
	$("#ChinaArea").jChinaArea( {
		aspnet : false,
		s1 : "上海市",// 默认选中的省名
		s2 : "上海市",// 默认选中的市名
		s3 : "黄浦区"// 默认选中的县区名
	});
</script>
</body>
</html>