<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>全局参数设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">全局参数</a> <a
				class="brand2">全局参数浏览</a>
		</div>

	</div>
	<div class="container-fluid containerb">

		<div class="row-fluid">

			<div class="span2">
				<!-- 引入左侧导航 -->
				<%@include file="/admin/left.jsp"%>
			</div>

			<div class="span10">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>说明</strong> 请选择如下的全局控制项如无特殊原因可不需要改动
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div class="line-dotted"></div>

				<!-- 开始显示form表单 -->
				<div class="form-actions">
					<div class="well">
						<h4>基础相关</h4>
					</div>
					<!--  <div class="form-inline">
						<span class="label label-required">系统语言:</span> <input
							type="radio" id="language" name="language" value="1" /> <label
							for="radio-1">中文 </label> <input type="radio" id="language"
							name="language" value="0" /> <label for="radio-2">英文 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">库存管理:</span> <input
							type="radio" id="isstockment" name="isstockment" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio" id="isstockment"
							name="isstockment" value="0" /> <label for="radio-2">关闭
						</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">采购计划:</span> <input
							type="radio" id="ispurchaseplan" name="ispurchaseplan" value="1" />
						<label for="radio-1">开启 </label> <input type="radio"
							id="ispurchaseplan" name="ispurchaseplan" value="0" /> <label
							for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">财务管理:</span> <input
							type="radio" id="isfinancement" name="isfinancement" value="1" />
						<label for="radio-1">开启 </label> <input type="radio"
							id="isfinancement" name="isfinancement" value="0" /> <label
							for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">工作流引擎:</span> <input
							type="radio" id="isworkflowengine" name="isworkflowengine"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isworkflowengine" name="isworkflowengine"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">任务调度:</span> <input
							type="radio" id="istaskschedule" name="istaskschedule" value="1" />
						<label for="radio-1">开启 </label> <input type="radio"
							id="istaskschedule" name="istaskschedule" value="0" /> <label
							for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">访问统计:</span> <input
							type="radio" id="isvisitcount" name="isvisitcount" value="1" />
						<label for="radio-1">开启 </label> <input type="radio"
							id="isvisitcount" name="isvisitcount" value="0" /> <label
							for="radio-2">关闭 </label>
					</div>-->
					<div class="form-inline">
						<span class="label label-required">会员注册:</span> <input
							type="radio" id="isusercanregister" name="isusercanregister"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isusercanregister" name="isusercanregister"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">发送邮件激活会员:</span> <input
							type="radio" id="issendactivatemail" name="issendactivatemail"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="issendactivatemail" name="issendactivatemail"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<!--  
					<div class="form-inline">
						<span class="label label-required">发送队列中邮件:</span> <input
							type="radio" id="isqueuemail" name="isqueuemail" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio" id="isqueuemail"
							name="isqueuemail" value="0" /> <label for="radio-2">关闭
						</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">购物帮助:</span> <input
							type="radio" id="isshoppinghelp" name="isshoppinghelp" value="1" />
						<label for="radio-1">开启 </label> <input type="radio"
							id="isshoppinghelp" name="isshoppinghelp" value="0" /> <label
							for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">站点帮助:</span> <input
							type="radio" id="isshoppinghelp" name="iswebsitehelp" value="1" />
						<label for="radio-1">开启 </label> <input type="radio"
							id="isshoppinghelp" name="iswebsitehelp" value="0" /> <label
							for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">日志记录:</span> <input
							type="radio" id="islog" name="islog" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio" id="islog"
							name="islog" value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">权限控制:</span> <input
							type="radio" id="isauthoritycontrol" name="isauthoritycontrol"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isauthoritycontrol" name="isauthoritycontrol"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>-->
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="basicupdate"
							name="basicupdate" value="更新" />
					</div>

					<div class="well">
						<h4>内容相关</h4>
					</div>
					<!-- 
					<div class="form-inline">
						<span class="label label-required">文章分页字符数: </span> <input
							id="articlesplitsize" name="articlesplitsize" type="text" value="" /> <span
							class="label label-info">文章每多少个字符进行分页</span>
					</div> -->
					<div class="form-inline">
						<span class="label label-required">评论审核:</span> <input
							type="radio" id="iscommentmoderation" name="iscommentmoderation"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="iscommentmoderation" name="iscommentmoderation"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<!-- 
					<div class="form-inline">
						<span class="label label-required">可评论对象:</span> <input
							type="radio" id="commenttarget" name="commenttarget" value="1" />
						<label for="radio-1">登录用户 </label> <input type="radio"
							id="commenttarget" name="commenttarget" value="2" /> <label
							for="radio-1">游客 </label> <input type="radio" id="commenttarget"
							name="commenttarget" value="3" /> <label for="radio-1">发表过同类主题用户
						</label> <input type="radio" id="commenttarget" name="commenttarget"
							value="4" /> <label for="radio-1">发表过任意内容用户 </label> <input
							type="radio" id="commenttarget" name="commenttarget" value="0" />
						<label for="radio-2">禁止评论 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">自动分享评论:</span> <input
							type="radio" id="isautosharecomment" name="isautosharecomment"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isautosharecomment" name="isautosharecomment"
							value="0" /> <label for="radio-2">关闭 </label>
					</div> -->
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="contentupdate"
							name="contentupdate" value="更新" />
					</div>
					<div class="well">
						<h4>订单相关</h4>
					</div>
					
					<div class="form-inline">
						<span class="label label-required">订单开票:</span> <input
							type="radio" id="isinvoice" name="isinvoice" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio" id="isinvoice"
							name="isinvoice" value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<!-- 
					<div class="form-inline">
						<span class="label label-required">使用积分:</span> <input
							type="radio" id="isusepoint" name="isusepoint" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio" id="isusepoint"
							name="isusepoint" value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">优惠券内容:</span> <input
							type="radio" id="isdiscountcoupon" name="isdiscountcoupon"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isdiscountcoupon" name="isdiscountcoupon"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">缺货处理:</span> <input
							type="radio" id="isstockoutprocess" name="isstockoutprocess"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isstockoutprocess" name="isstockoutprocess"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">确认订单发送邮件:</span> <input
							type="radio" id="isconfirmtomail" name="isconfirmtomail"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isconfirmtomail" name="isconfirmtomail"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">付款发送邮件:</span> <input
							type="radio" id="ispaymail" name="ispaymail" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio" id="ispaymail"
							name="ispaymail" value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">发货发送邮件:</span> <input
							type="radio" id="isdelivergoodsmail" name="isdelivergoodsmail"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isdelivergoodsmail" name="isdelivergoodsmail"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">取消订单发送邮件:</span> <input
							type="radio" id="iscancelordermail" name="iscancelordermail"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="iscancelordermail" name="iscancelordermail"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">下单通知客服系统:</span> <input
							type="radio" id="isnoticeservice" name="isnoticeservice"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isnoticeservice" name="isnoticeservice"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">新订单提醒:</span> <input
							type="radio" id="isnoticeneworder" name="isnoticeneworder"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isnoticeneworder" name="isnoticeneworder"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">货到付款:</span> <input
							type="radio" id="iscashondelivery" name="iscashondelivery"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="iscashondelivery" name="iscashondelivery"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">免运费额度:</span> <input
							id="freeshoppinglines" name="freeshoppinglines" type="text"
							value="" />
					</div> -->
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="orderupdate"
							name="orderupdate" value="更新" />
					</div>
<!--  
					<div class="well">
						<h4>短信相关</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">商家手机号码: </span> <input
							id="salemobile" name="salemobile" type="text" value="" /> <span
							class="label label-info">系统将通过该号码发送信息至客户手机</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">下单发短信:</span> <input
							type="radio" id="isordermsg" name="isordermsg" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio" id="isordermsg"
							name="isordermsg" value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">付款发短信:</span> <input
							type="radio" id="ispaymsg" name="ispaymsg" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio" id="ispaymsg"
							name="ispaymsg" value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">发货发短信:</span> <input
							type="radio" id="isdelivermsg" name="isdelivermsg" value="1" />
						<label for="radio-1">开启 </label> <input type="radio"
							id="isdelivermsg" name="isdelivermsg" value="0" /> <label
							for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="msgupdate"
							name="msgupdate" value="更新" />
					</div>
					-->
					<!-- 
					<div class="well">
						<h4>移动平台相关</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">同步订单数据:</span> <input
							type="radio" id="issyncmobileplatform"
							name="issyncmobileplatform" value="1" /> <label for="radio-1">开启
						</label> <input type="radio" id="issyncmobileplatform"
							name="issyncmobileplatform" value="0" /> <label for="radio-2">关闭
						</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">同步商品数据:</span> <input
							type="radio" id="issyncgoodsdata" name="issyncgoodsdata"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="issyncgoodsdata" name="issyncgoodsdata"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">同步内容数据:</span> <input
							type="radio" id="issynccontentdata" name="issynccontentdata"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="issynccontentdata" name="issynccontentdata"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">同步购物车数据:</span> <input
							type="radio" id="issynccartdata" name="issynccartdata" value="1" />
						<label for="radio-1">开启 </label> <input type="radio"
							id="issynccartdata" name="issynccartdata" value="0" /> <label
							for="radio-2">关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">同步订单数据:</span> <input
							type="radio" id="issyncorderdata" name="issyncorderdata"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="issyncorderdata" name="issyncorderdata"
							value="0" /> <label for="radio-2">关闭 </label>
					</div>

					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="mobileupdate"
							name="mobileupdate" value="更新" />
					</div>
 -->
					<div class="well">
						<h4>会员相关</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">赠送积分:</span> <input
							id="freepoint" name="freepoint" type="text" value="" />
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="memberupdate"
							name="memberupdate" value="更新" />
					</div>

					<div class="well">
						<h4>库存相关</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">扣减库存时机:</span> <input
							type="radio" id="stockreduce" name="stockreduce" value="1" /> <label
							for="radio-1">下单后</label> <input type="radio" id="stockreduce"
							name="stockreduce" value="2" /> <label for="radio-2">付款后</label>
						<input type="radio" id="stockreduce" name="stockreduce" value="3" />
						<label for="radio-2">发货后</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">初始库存:</span> <input
							id="defaultstock" name="defaultstock" type="text" value="" />
					</div>
					<div class="form-inline">
						<span class="label label-required">预警库存:</span> <input
							id="inventorywarning" name="inventorywarning" type="text"
							value="" />
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="stockupdate"
							name="stockupdate" value="更新" />
					</div>

					<div class="well">
						<h4>图片相关</h4>
					</div>
					<!--  
					<div class="form-inline">
						<span class="label label-required">水印文件:</span> <input type="file"
							id="watermarkfile" name="watermarkfile" /> <input type="hidden"
							id="watermarkfileimg" name="watermarkfileimg" value="0" />
						<button id="upload" name="upload"
							onclick="uploadwatermarkfile('watermarkfile','image','watermark');">上传</button>
						<img id="showwatermarkfileimg" name="showwatermarkfileimg"
							alt="水印图片位置" src="" style="width: 300px; height: 300px;" /> <span
							class="label label-info">选择一个文件作为水印</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">水印透明度:</span> <input
							id="watermarkclarity" name="watermarkclarity" type="text"
							value="20" />
					</div>
					-->
					
					<div class="form-inline">
						<span class="label label-required">云存储资源:</span> <input
							type="radio" id="issaveimgtocloud"
							name="issaveimgtocloud" value="1" /> <label for="radio-1">七牛云存储
						</label> <input type="radio" id="issaveimgtocloud"
							name="issaveimgtocloud" value="0" /> <label for="radio-2">
							关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">本地保留原图:</span> <input
							type="radio" id="issaveoriginalbitmap"
							name="issaveoriginalbitmap" value="1" /> <label for="radio-1">开启
						</label> <input type="radio" id="issaveoriginalbitmap"
							name="issaveoriginalbitmap" value="0" /> <label for="radio-2">
							关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">缩略图宽度:</span> <input
							id="thumbnailwidth" name="thumbnailwidth" type="text" value="" />
					</div>
					<div class="form-inline">
						<span class="label label-required">缩略图高度:</span> <input
							id="thumbnailheight" name="thumbnailheight" type="text" value="" />
					</div>
					<div class="form-inline">
						<span class="label label-required">默认图片宽度:</span> <input
							id="defaultwidth" name="defaultwidth" type="text" value="" />
					</div>
					<div class="form-inline">
						<span class="label label-required">默认图片高度:</span> <input
							id="defaultheight" name="defaultheight" type="text" value="" />
					</div>
					<div class="form-inline">
						<span class="label label-required">图片压缩:</span> <input
							type="radio" id="isimagecompression" name="isimagecompression"
							value="1" /> <label for="radio-1">开启 </label> <input
							type="radio" id="isimagecompression" name="isimagecompression"
							value="0" /> <label for="radio-2"> 关闭 </label>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="imgupdate"
							name="imgupdate" value="更新" />
					</div>


					<div class="well">
						<h4>商品相关</h4>
					</div>
					<!-- 
					<div class="form-inline">
						<span class="label label-required">积分重命名:</span> <input
							id="pointrename" name="pointrename" type="text" value="" />
					</div>
					<div class="form-inline">
						<span class="label label-required">积分换算比例:</span> <input
							id="integralconversionration" name="integralconversionration"
							type="text" value="1:1000" /> <span class="label label-info">当你需要让用户购物得到的积分能够抵扣部分商品价格时，请设定此项，例如1000:1（1000积分兑换1元人民币）格式1:1000！</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">积分支付比例:</span> <input
							id="proportionintegralpayment" name="proportionintegralpayment"
							type="text" value="20" />% <span class="label label-info">积分使用后抵扣的金额占总金额的最高比例</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">虚拟物品支持:</span> <input
							type="radio" id="isvirtualitemsupport"
							name="isvirtualitemsupport" value="1" /> <label for="radio-1">开启
						</label> <input type="radio" id="isvirtualitemsupport"
							name="isvirtualitemsupport" value="0" /> <label for="radio-2">
							关闭 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">外链商品支持:</span> <input
							type="radio" id="outlinkgoodssupport"
							name="outlinkgoodssupport" value="1" /> <label for="radio-1">开启
						</label> <input type="radio" id="outlinkgoodssupport"
							name="outlinkgoodssupport" value="0" /> <label for="radio-2">
							关闭 </label>
					</div>
					 -->
					<div class="form-inline">
						<span class="label label-required">规格商品支持:</span> <input
							type="radio" id="isspecificationsupport"
							name="isspecificationsupport" value="1" /> <label for="radio-1">开启
						</label> <input type="radio" id="isspecificationsupport"
							name="isspecificationsupport" value="0" /> <label for="radio-2">
							关闭 </label>
					</div>
					<!--  
					<div class="form-inline">
						<span class="label label-required">商品评论条件:</span> <input
							type="radio" id="goodscommentcondition"
							name="goodscommentcondition" value="1" /> <label for="radio-1">买过该商品
						</label> <input type="radio" id="goodscommentcondition"
							name="goodscommentcondition" value="2" /> <label for="radio-2">
							购买过任意商品</label> <input type="radio" id="goodscommentcondition"
							name="goodscommentcondition" value="3" /> <label for="radio-2">
							开放评论</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">智能商品命名:</span> <input
							type="radio" id="isintelligentproductnamed"
							name="isintelligentproductnamed" value="1" /> <label
							for="radio-1">开启 </label> <input type="radio"
							id="isintelligentproductnamed" name="isintelligentproductnamed"
							value="0" /> <label for="radio-2"> 关闭 </label> <span
							class="label label-info">可以把品牌、重量等信息追加在商品标题中</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">关联属性商品数:</span> <input
							id="associateattributecount" name="associateattributecount"
							type="text" value="5" />
					</div>-->
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="goodsupdate"
							name="goodsupdate" value="更新" />
					</div>

					<div class="well">
						<h4>备案相关</h4>
					</div>
					<div class="form-inline">
						<span class="label label-required">ICP备案号:</span> <input id="icp"
							name="icp" type="text" value="" />
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="icpupdate"
							name="icpupdate" value="更新" />
					</div>

				</div>


			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/setting/globalparamsetjs.js"></script>
	<!-- 加载上传插件 -->
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/ajaxfileupload/ajaxfileupload.js"></script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>

