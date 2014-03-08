<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>地址簿</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/js/jquery.query.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/location.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/YLChinaArea.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>

</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">
<#include "/WEB-INF/theme/default/shop/usermenu.ftl">
<div id="mem_right" name="mem_right"  width="100%" height="606" style="position:relative ">
  <div id="mem_position"><a href="#" target="_parent">会员专区</a> &gt; <a href="#">地址簿</a></div>
  <div id="hui_r">
        <div class="myad_rm1title"><span>我的地址薄</span></div>
      <div class="myad_rbox">
 		<div class="myac_rmtitle" style="margin-left:12px">我的地址薄</div>
       <div class="myad_rm1">
          <div class="myad_rth">
            <div class="myad_rth1">收货人</div>
            <div class="myad_rth2">详细地址</div>
            <div class="myad_rth3">邮编</div>
            <div class="myad_rth4">固定电话</div>
            <div class="myad_rth5">手机</div>
            <div class="myad_rth6">操作</div>
          </div>
		<#if (deliveraddress??)&&(deliveraddress?size>0)>
		<#list deliveraddress as addr>
            <div class="myad_rtd1">${addr.username}</div>
            <div class="myad_rtd2">${addr.street}</div>
            <div class="myad_rtd3">${addr.postcode}</div>
            <div class="myad_rtd4">${addr.telno}</div>
            <div class="myad_rtd5">${addr.mobile}</div>
            <div class="myad_rtd6"><a href="javascript:;" onclick="alteradderss(${addr.addressid});" class="thickbox myad_s1">修改</a>
              <a href="javascript:;" onclick="delmyaddress(${addr.addressid});" class="myad_s2">删除</a></div>
        </#list>
		</#if>
          <div class="clear"></div>
        </div>
          <div class="myad_rm2">
			<div class="myad_rm2title">新增收货人地址</div>
			<input id="addsid" name="addsid" type="hidden" value="">
            <div class="myad_rm2l"><span>*</span>收 货 人：</div>
			<div class="myad_rm2r1"><input type="text" name="username" id="username"></div>
			<div class="myad_rm2l"><span>*</span>国  家：</div>
			<div class="myad_rm2r1"><select id="country" name="country"><option value="1">中国</option></select></div>
            <div class="myad_rm2l"><span>*</span>省  份：</div>
      		<div id="ChinaArea" class="myad_rm2r1">
			 <select id="province" name="province" style="width: 100px;"></select>
			 <select id="city" name="city" style="width: 100px;"></select>
			 <select id="district" name="district" style="width: 120px;"> </select>      
			 </div>
            <div class="myad_rm2l"><span>*</span>详细地址：</div>
            <div class="myad_rm2r2"><input type="text" class="input2" maxlength="40" name="street" style="width: 400px;" id="street" onblur="checkreceiverAddress();" onfocus="aa(this);"></div>
            <div class="myad_rm2l"><span>&nbsp;</span>固定电话：</div>
            <div class="myad_rm2r3"><input type="text" class="input1" name="telno" id="telno" maxlength="11"></div>
            <div><input type="hidden" name="telephoneType" value="0"></div>
            <div class="clear"></div>
            <div class="myad_rm2l"><span>*</span>手机号码：</div>
            <div class="myad_rm2r1"> <input type="text" class="input1" name="mobile" id="mobile" maxlength="11"></div>
            <div class="myad_rm2l"><span>*</span>邮政编码：</div>
            <div class="myad_rm2r1"><input type="text" name="postcode" class="input1" id="postcode"></div>
			<div class="myad_rm2l"><span>&nbsp;</span>电子邮件</div>
			<div class="myad_rm2r1"><input type="text" name="email" class="input1" id="email" style="width: 200px;"></div>
            <div class="clear"></div>
            <div class="myad_btn"><input type="image" src="${basepath}/ui/default/images/myad_addbtn.gif" onclick="myAddressAdd();">&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="image" src="${basepath}/ui/default/images/myad_alterbtn.gif" onclick="myAddressAlter();"></div>
          </div>
      </div>
	<div class="mem_fixHeight"></div>
    </div>
</div>
</div>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>