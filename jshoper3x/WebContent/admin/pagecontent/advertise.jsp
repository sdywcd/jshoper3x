<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("contentvalue") != null ? request
			.getParameter("contentvalue") : "";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>广告管理 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">广告管理 </a> <a
				class="brand2">编辑广告 </a>
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
					<strong>说明</strong> 请根据需要编辑广告
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
				
				<!-- 开始显示商品类型form表单 -->
				<div class="form-actions">
					<div id="selectadvertiseshowwhere" class="form-inline">
						<span class="label label-required">选择广告展现平台: </span>
							<select id="showWhere" name="showWhere">
								<option value="0">--请选择广告展现平台--</option>
								<option value="1">移动平台</option>
								<option value="2">web平台</option>
								<option value="3">所有平台</option>
							</select>
						<span class="label label-info">请选择一个广告展现平台</span>
					</div>
					<div id="selectadvertisetype" class="form-inline">
						<span class="label label-required">选择广告展现类型: </span>
							<select id="type" name="type">
								<option value="0">--请选择广告展现类型--</option>
								<option value="1">二维码</option>
								<option value="2">图片</option>
								<option value="3">html网页</option>
								<option value="4">语音音频</option>
								<option value="5">视频</option>
							</select>
						<span class="label label-info">请选择一个广告展现类型</span>
					</div>
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">图片:</span></td>
								<td>
									<div id="uploaderarticlemainpicture">
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
						<span class="label label-required">展现位置标记:</span> <input type="text"
							id="showTag" name="showTag" class="small" />
						<span class="label label-info">该标记是读取广告的重要依据</span>
					</div>
					
					<div class="form-inline">
						<span class="label label-required">广告保存位置:</span> <input type="text"
							id="advPath" name="advPath" class="small" />
						<span class="label label-info">该值表示你所选择的广告保存的位置，可以是一个url</span>
					</div>
					
					<div class="form-inline">
						<span class="label label-required">广告说明:</span> <input type="text"
							id="alt" name="alt" class="small" />
						<span class="label label-info">当广告加载失败时显示的文字信息</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">广告高度:</span> <input type="text"
							id="height" name="height" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">广告宽度:</span> <input type="text"
							id="width" name="width" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">广告标识码:</span> <input type="text"
							id="code" name="code" class="small" />
						<span class="label label-info">广告唯一标识码</span>
					</div>
					
					<div class="form-inline">
						<span class="label label-required">排序:</span> <input type="text"
							id="sort" name="sort" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">上线时间:</span> <input
							type="text" id="begintime" name="begintime" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">下线时间:</span> <input type="text"
							id="endtime" name="endtime" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">状态:</span> <input
							type="radio" id="state" name="state" value="1"
							checked="checked" /> <label for="radio-1">上线 </label> <input
							type="radio" id="state" name="state" value="0" /> <label
							for="radio-2">下线</label>
					</div>
					
					
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidadvertiseid" name="hidadvertiseid" value="" />
						<input type="hidden" id="hidgrade" name="hidgrade" value="" />
						<input class="btn btn-success" type="button" id="submit"
							name="submit" value="提交" /> <input class="btn btn-success"
							type="button" id="update" name="update" value="更新"
							style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/pagecontent/articlementjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/kindeditor/kindeditor-min.js"></script>

	<script type="text/javascript">
 		KE.show({
			id : 'contentvalue',
		    imageUploadJson : '<%=basePath%>/admin/js/plugins/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>/admin/js/plugins/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 	</script>
 	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<script type="text/javascript">
 		function createUploader(){            
             var uploader = new qq.FileUploader({
                 element: document.getElementById('uploaderarticlemainpicture'),
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

<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>


