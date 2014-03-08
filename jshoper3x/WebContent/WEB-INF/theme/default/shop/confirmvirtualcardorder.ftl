<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>虚拟商品订单结算${(jshopbasicinfo.jshopname)}</title>
<meta name="Author" content="OSTOCY">
<meta name="Copyright" content="OSTOCY"><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
	<#assign isvirtual=0/>
	
	
		<div id="orders_infom1" class="consignee_info">
		<div class="consignee_div2" id="" style="padding-bottom: 4px;">
		<div id="addnewaddressarea">
        <ul id="newaddress" class="address_content">
		<li>
            <p>请输入手机号码</p>
            <cite>
            <input type="text" name="mobileforisvirtual" class="input1" id="mobileforisvirtual" style="width: 200px;">
            </cite><cite id="consignee_input7">方便我们及时为您充值</cite>
		</li>
		<li>
            <p>请确认手机号码</p>
            <cite>
            <input type="text" name="mobileforisvirtualag" class="input1" id="mobileforisvirtualag" style="width: 200px;">
            </cite><cite id="consignee_input7">方便我们正确为您充值</cite>
		</li>    		
	    </ul>
		</div>
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
			<#if (pm.paymentCode=='zfb')>
				<img src='${basepath}/pay/alipay/alipay_logo.png'/>
			</#if>
			<#if (pm.paymentCode=='cft')>
				<img src='${basepath}/pay/tenpay/caifutong.gif'/>
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
	
  </div>
  
  <div class="detailinfo">
    <h1>
      <p>商品信息</p>
      <cite><a href="findAllCartByUserId.action">返回修改购物车</a></cite></h1>
    <div class="detailinfo_div1">
	
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
		  <#list cart as c>
          <tr>
			<td class="td3">${c.usersetnum}</td>
            <td class="td1"><div class="img"> <a href="${basepath}/html/default/shop/${c.goodsid}.html"><img src="${c.picture}" alt=""> </a> </div>
              <div class="name"> <a href="${basepath}/html/default/shop/${c.goodsid}.html"> ${c.goodsname} </a>
              </div></td>
            <td class="td3"> ￥${c.favorable} </td>
            <td class="td4"> ${c.needquantity} </td>
            <td class="td5"><span id="points">${c.points} </span></td>
            <td class="td6">
				<div id="cart"> 
					<span id="UnitPrice30083387">
					<#if (c.quantity>0)>
						有货
					<#else>
						缺货（有货后即刻发货）
					</#if>
					</span> 
				</div>
			</td>
          </tr>
          </#list>
       
        </tbody>
      </table>
	  
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
                <td align="right">&nbsp;&nbsp;&nbsp;<span style="color:red">￥</span> <span id="goodstotalprice" style="color:red">${totalprice}</span></td>
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
		 
			<img id="submitlink" onclick="InitAlipayandAddOrderisvirtualcard();" style="cursor: pointer;" src="${basepath}/ui/default/images/submitbtn.gif">
		 
		  </div>
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

