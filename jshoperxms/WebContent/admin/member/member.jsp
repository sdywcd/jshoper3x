<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>会员设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">会员设置 </a> <a
				class="brand2">编辑会员</a>
		</div>

	</div>
	<div class="container-fluid containerb">

		<div class="row-fluid">

			<div class="span2">
				<!-- 引入左侧导航 -->
				<%@include file="/admin/left.jsp"%>
			</div>

			<div id="mainlogic" class="span10">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>说明</strong> 请根据需要编辑会员
				</div>
				<div id="alerterror" style="display: none;"
					class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> <strong></strong>
				</div>
				<div class="line-dotted"></div>
				<div class="btn-group">
					<button id="btnback" type="button" class="btn btn-success">返回</button>
				</div>
				<!-- 开始会员分组form表单 -->
				<div class="form-actions">
					<div class="form-inline">
						<span class="label label-required">用户名: </span> <input
							id="loginname" name="loginname" type="text" value=""
							class="small" /> 
							<span class="label label-info">用于前端登录的用户名，可以是邮箱也可以是普通字符，请勿使用特殊字符</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">密码: </span> <input
							id="loginpwd" name="loginpwd" type="password" value=""
							class="small" /> 
							<span class="label label-info">用于前端登录的密码</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">支付密码: </span> <input
							id="paypassword" name="paypassword" type="password" value=""
							class="small" /> 
							<span id="paypasswordstrong" class="label label-info">用于前端支付时的密码</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">昵称: </span> <input
							id="nick" name="nick" type="text" value=""
							class="small" /> 
							<span class="label label-info">一个昵称将会显示在你的用户名旁边</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">真实姓名: </span> <input
							id="realname" name="realname" type="text" value=""
							class="small" /> 
							<span class="label label-info">为了方便我们正确的称呼您请如实填写</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">居住城市: </span> <input
							id="city" name="city" type="text" value=""
							class="small" /> 
							<span class="label label-info">您现在居住的地方</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">具体区域: </span> <input
							id="district" name="district" type="text" value=""
							class="small" /> 
							<span class="label label-info">您现在居住的具体区域。例如：浦东新区</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">性别:</span> <input
							type="radio" id="sex" name="sex" value="1"
							checked="checked" /> <label for="radio-1">男 </label> <input
							type="radio" id="sex" name="sex" value="0" /> <label
							for="radio-2">女</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">性取向:</span> <input
							type="radio" id="whichsex" name="whichsex" value="1"
							checked="checked" /> <label for="radio-1">异性 </label> <input
							type="radio" id="whichsex" name="whichsex" value="0" /> <label
							for="radio-2">同性</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">婚姻状况:</span> <input
							type="radio" id="merrystatus" name=merrystatus value="1"
							checked="checked" /> <label for="radio-1">未婚 </label> <input
							type="radio" id="merrystatus" name="merrystatus" value="0" /> <label
							for="radio-2">已婚</label>
					</div>
					<div class="form-inline">
						<span class="label label-required">生日: </span> <input
							id="birthday" name="birthday" type="text" value=""
							class="small" /> 
							<span class="label label-info">请按照yyyymmdd格式填写。例如：19871101表示1987年11月1日</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">血型: </span> <input
							id="blood" name="blood" type="text" value=""
							class="small" /> 
							<span class="label label-info">格式：A，B，AB，O</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">星座: </span> <input
							id="constellation" name="constellation" type="text" value=""
							class="small" /> 
							
					</div>
					<div class="form-inline">
						<span class="label label-required">自述: </span> <input
							id="des" name="des" type="text" value=""
							class="large" /> 
							<span class="label label-info">自己的一段小介绍</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">手机: </span> <input
							id="mobile" name="mobile" type="text" value=""
							class="small" /> 
							
					</div>
					<div class="form-inline">
						<span class="label label-required">固话: </span> <input
							id="telno" name="telno" type="text" value=""
							class="small" /> 
							
					</div>
					<div class="form-inline">
						<span class="label label-required">QQ: </span> <input
							id="qq" name="qq" type="text" value=""
							class="small" /> 
							
					</div>
					<div class="form-inline">
						<span class="label label-required">微信: </span> <input
							id="weixin" name="weixin" type="text" value=""
							class="small" /> 
							
					</div>
					<div class="form-inline">
						<span class="label label-required">新浪微博: </span> <input
							id="sinaweibo" name="sinaweibo" type="text" value=""
							class="small" /> 
							
					</div>
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">头像:</span></td>
								<td>
									<div id="uploaderheadpath">
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
						<span class="label label-required">个人标签: </span> <input
							id="tag" name="tag" type="text" value=""
							class="small" /> 
						<span class="label label-info">请使用逗号分隔你的个人标签</span>	
					</div>
					<div class="form-inline">
						<span class="label label-required">安全邮箱: </span> <input
							id="email" name="email" type="text" value=""
							class="small" /> 
							<span class="label label-info">可以用来重置密码</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">安全问题: </span> <input
							id="question" name="question" type="text" value=""
							class="small" />
							<span class="label label-info">可以用来重置密码</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">安全回答: </span> <input
							id="answer" name="answer" type="text" value=""
							class="small" />
							<span class="label label-info">可以用来重置密码</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">用户状态:</span> <input
							type="radio" id="memberstate" name=memberstate value="1"
							checked="checked" /> <label for="radio-1">激活 </label> <input
							type="radio" id="memberstate" name="memberstate" value="0" /> <label
							for="radio-2">禁止</label>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidid" name="hidid" value="" /> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/member/membermentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<script type="text/javascript">
 		function createUploader(){            
             var uploader = new qq.FileUploader({
                 element: document.getElementById('uploaderheadpath'),
                 action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	var pcpath1="<%=basePath%>"+responseJSON.success;
                	var pcpath=responseJSON.success;
  					var htm="<img id='"+id+"' src='"+pcpath1+"' rel='#"+fileName+"'/>";
  					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' /> ";
  					$("#triggers").append(htm).append(checkpc);
                 },
             });           
         }
 		window.onload = createUploader; 
 
 	</script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>



