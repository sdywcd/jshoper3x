<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("intro") != null ? request.getParameter("intro") : "";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>文章分类设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">文章分类设置 </a> <a
				class="brand2">编辑文章分类 </a>
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
					<strong>说明</strong> 请根据需要编辑文章分类
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
					<div class="form-inline">
						<span class="label label-required">选择分类: </span> <select
							id="parentId" name="parentId"></select> <select id="parentId1"
							name="parentId1"></select> <span class="label label-info">请选择一个商品分类</span>
					</div>
					<div id="fater" class="form-inline">
						<span class="label label-required">上级分类: </span> <span id="modfl"><input
							type="text" id="parentName" name="parentName" value="" readonly /></span>
					</div>
					
					<div class="form-inline">
						<span class="label label-required">分类名称: </span> <input
							id="name" name="name" type="text" value=""
							class="small" />
					</div>
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">分类图标:</span></td>
								<td>
									<div id="uploadercategorylogo">
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
						<span class="label label-required">静态化标示:</span> <input
							type="text" id="sign" name="sign" class="small" reg="^[A-Za-z]+$" tip="只能由英文组成" />
					</div>
					<div class="form-inline">
						<span class="label label-required">排序:</span> <input type="text"
							id="sort" name="sort" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">页脚显示:</span> <input
							type="radio" id="position" name="position" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="position" name="position" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">同步移动平台:</span> <input
							type="radio" id="mobilesync" name="mobilesync" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="mobilesync" name="mobilesync" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">页面关键字:</span> <input
							type="text" id="metaKeywords" name="metaKeywords" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">页面描述:</span> <input type="text"
							id="metaDes" name="metaDes" class="medium" />
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> 
						<input type="hidden" id="hidarticleCategoryTid" name="hidarticleCategoryTid" value="" />
						<input type="hidden" id="hidgrade" name="hidgrade" value="" />
						<input class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/pagecontent/articlecategorymentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<script type="text/javascript">
 		function createUploader(){            
             var uploader = new qq.FileUploader({
                 element: document.getElementById('uploadercategorylogo'),
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



