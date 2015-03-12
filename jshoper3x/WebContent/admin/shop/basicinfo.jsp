<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>基本信息设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">基本信息</a> <a
				class="brand2">基本信息浏览</a>
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
					<strong>说明</strong> 请填写商店的基本信息.
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div class="line-dotted"></div>
				<!-- 开始显示form表单 -->
				<div class="form-actions">
					<div class="form-inline">
						<span class="label label-required">商店名称:</span> <input type="text"
							id="jshopname" name="jshopname" class="small" /> <span
							class="label label-info">给你的商店起一个名字吧！</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商店标语:</span> <input type="text"
							id="jshopslogan" name="jshopslogan" class="small" /> <span
							class="label label-info">想一个响亮的口号吧！</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商店关键字:</span> <input
							type="text" id="metaKeywords" name="metaKeywords" class="medium" />
						<span class="label label-info">可以让你的商店在互联网上被搜索到！</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商店描述:</span> <input type="text"
							id="metaDes" name="metaDes" class="medium" /> <span
							class="label label-info">请告诉大家你的商店卖什么东西吧！</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">所在国家:</span> <input type="text"
							id="country" name="country" value="中国" class="small" />

					</div>
					<div class="form-inline">
						<span class="label label-required">所在省份:</span> <input type="text"
							id="province" name="province" /> <span
							class="label label-required">所在城市:</span> <input type="text"
							id="city" name="city" /> <span class="label label-required">所在区/县:</span>
						<input type="text" id="district" name="district" />
					</div>
					<div class="form-inline">
						<span class="label label-required">详细地址:</span> <input type="text"
							id="street" name="street" class="medium" />
					</div>
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">LOGO:</span></td>
								<td>
									<div id="uploadersitelogo">
										<noscript>
											Please enable JavaScript to use file uploader.
											<!-- or put a simple form for upload here -->
										</noscript>

									</div>
								</td>
							</tr>
						</table>
						<!-- trigger elements -->
						<div id="triggers"></div>

					</div>
					<div class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="delpc" name="delpc"
							value="删除所选图片" />
					</div>
					<div class="form-inline">
						<span class="label label-required">QQ号码:</span> <input type="text"
							id="qqservice" name="qqservice" />
					</div>
					<div class="form-inline">
						<span class="label label-required">SKYPE:</span> <input
							type="text" id="skypeservice" name="skypeservice" />
					</div>
					<div class="form-inline">
						<span class="label label-required">微信号:</span> <input type="text"
							id="weixinservice" name="weixinservice" />
					</div>
					<div class="form-inline">
						<span class="label label-required">sina微博:</span> <input
							type="text" id="sinaweiboservice" name="sinaweiboservice" />
					</div>
					<div class="form-inline">
						<span class="label label-required">邮件地址:</span> <input type="text"
							id="emailservice" name="emailservice" />
					</div>
					<div class="form-inline">
						<span class="label label-required">电话:</span> <input type="text"
							id="phoneservice" name="phoneservice" />
					</div>
					<div class="form-inline">
						<span class="label label-required">商户运营:</span> <select
							id="openstate" name="openstate">
							<option value="0">关闭</option>
							<option value="1">开启</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">关闭运营原因:</span> <input
							type="text" id="siteclosenotes" name="siteclosenotes"
							class="medium" /> <span class="label label-info">请告诉大家为什么关闭运营的原因！</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">License许可状态:</span> <select
							id="licensed" name="licensed">
							<option value="1">显示</option>
							<option value="0">隐藏</option>
						</select>
					</div>
					<div class="form-inline">
						<span class="label label-required">ICP备案号:</span> <input
							type="text" id="icpnum" name="icpnum" /> <span
							class="label label-info">请填写网站备案后得到的备案号！</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商户可见状态:</span> <select
							id="state" name="state">
							<option value="1">显示</option>
							<option value="0">隐藏</option>
						</select> <span class="label label-info">关系到是否可以在系统内容正常获取推送信息！</span>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success"
							style="display: none;" type="button" id="update" name="update"
							value="更新" /> <input type="hidden" id="hidbasicinfoid"
							name="hidbasicinfoid" value="" />
					</div>

				</div>


			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/shop/shopmentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<script type="text/javascript">
 		function createUploader(){
             var uploader = new qq.FileUploader({
                 element: document.getElementById('uploadersitelogo'),
                 action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: false,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	var pcpath1="<%=basePath%>"+responseJSON.success;
                	var pcpath=responseJSON.success;
  					var htm="<img id='"+id+"' src='"+pcpath1+"' rel='#"+fileName+"'/>";
  					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' />";
  					$("#triggers").append(htm).append(checkpc);
                 },
             });
         }
 		window.onload = createUploader; 
 	</script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>

