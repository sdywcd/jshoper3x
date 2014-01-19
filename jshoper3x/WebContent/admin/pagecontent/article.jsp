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
<title>内容文章管理 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">文章管理 </a> <a
				class="brand2">编辑文章 </a>
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
					<strong>说明</strong> 请根据需要编辑文章
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
						<span class="label label-required">外链:</span> <input
							type="radio" id="isoutsite" name="isoutsite" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="isoutsite" name="isoutsite" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">外链地址:</span> <input type="text"
							id="outsitelink" name="outsitelink" class="medium"  value="" />
					</div>
					<div id="articlecategory" style="display: none;" class="form-inline">
						<span class="label label-required">文章所在分类: </span> <span
							id="shownname"></span>
						<!-- 显示顶级分类一级分类名称 -->
						<span id="showlname"></span>
						<!-- 显示二级分类名称 -->
						<span id="showsname"></span>
						<!-- 显示三级分类名称 -->
						<span id="shownavid" style="display: none;"></span> <span
							id="showltypeid" style="display: none;"></span> <span
							id="showstypeid" style="display: none;"></span> <input
							type="hidden" id="hidnavid" value=""></input> <input
							type="hidden" id="hidnname" value=""></input> <input
							type="hidden" id="hidltypeid" value=""></input> <input
							type="hidden" id="hidlname" value=""></input> <input
							type="hidden" id="hidstypeid" value=""></input> <input
							type="hidden" id="hidsname" value=""></input>
					</div>		
				
					<div id="selectarticlecategory" class="form-inline">
						<span class="label label-required">选择文章分类: </span>
							<select id="navid" name="navid"></select>
							<!-- 顶级分类一级分类 -->
							<select id="ltypeid" name="ltypeid"></select>
							<!-- 二级分类 -->
							<select id="stypeid" name="stypeid"></select>
							<!-- 三级分类 -->
						<span class="label label-info">请选择一个文章分类</span>
					</div>
					<div id="modifyarticlecategory" style="display: none;"
						class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="reselectarticlecategory"
							name="reselectarticlecategory" value="重新选择分类" />
					</div>
					<div class="form-inline">
						<span class="label label-required">文章标题:</span> <input type="text"
							id="title" name="title" class="medium" />
					</div>
					<div class="form-inline">
						<span class="label label-required">作者:</span> <input type="text"
							id="author" name="author" class="small" />
					</div>
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">主图:</span></td>
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
						<span class="label label-required">排序:</span> <input type="text"
							id="sort" name="sort" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">发布:</span> <input
							type="radio" id="ispublication" name="ispublication" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="ispublication" name="ispublication" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">推荐:</span> <input
							type="radio" id="isrecommend" name="isrecommend" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="isrecommend" name="isrecommend" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">置顶:</span> <input
							type="radio" id="istop" name="istop" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="istop" name="istop" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">公告:</span> <input
							type="radio" id="isnotice" name="isnotice" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="isnotice" name="isnotice" value="0" /> <label
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
						<span class="label label-required">正文简介:</span> <input type="text"
							id="tipcontent" name="tipcontent" class="large" />
					</div>
					<div class="form-inline">
						<span class="label label-required">正文:</span>
						<textarea id="contentvalue" name="contentvalue" cols="50" rows="12"
							style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
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
						<label class="label label-submit"></label> <input type="hidden"
							id="hidarticleid" name="hidarticleid" value="" />
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


