<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("intro") != null ? request.getParameter("intro") : "";
%>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>品牌设置 &middot; jshoperx</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">品牌设置 </a> <a
				class="brand2">编辑品牌 </a>
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
					<strong>说明</strong> 请根据需要编辑品牌
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
				<form id="brandsform">
				<div  class="form-actions">
					
					<div class="form-inline">
						<span class="label label-required">品牌名称: </span> <input
							id="brandname" name="brandname" type="text" value=""
							class="small" required />
					</div>
					<div class="form-inline">
						<span class="label label-required">品牌官方网址: </span> <input id="url"
							name="url" type="text" value="" class="medium" />
					</div>
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">LOGO:</span></td>
								<td>
									<div id="uploaderbrandlogo">
										<noscript>
											Please enable JavaScript to use file uploader.
											<!-- or put a simple form for upload here -->
										</noscript>

									</div>
								</td>
							</tr>
						</table>
						<!-- trigger elements -->
						<div id="maintriggers"></div>

					</div>
					<div class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="maindelpc" name="maindelpc"
							value="删除所选图片" />
					</div>
					<div class="form-inline">
						<span class="label label-required">排序: </span> <input id="sort"
							name="sort" type="text" value="" class="small" required/>
					</div>
					<div class="form-inline">
						<span class="label label-required">介绍: </span>
						<textarea id="intro" name="intro" cols="50" rows="12"
							style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
					</div>
					<div class="form-inline">
						<span class="label label-required">备注说明: </span> <input id="remark"
							name="remark" type="text" value="" class="small" required/>
					</div>
					<div class="form-inline">
						<label class="label label-submit"></label> <input type="hidden"
							id="hidbrandid" name="hidbrandid" value="" /> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>
			</form>
			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/brands/brandsmentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/kindeditor/kindeditor-min.js"></script>

	<script type="text/javascript">
	$(function(){
		createBrandLogoUploader=function(){
			var uploader = new qq.FileUploader({
                 element: document.getElementById('uploaderbrandlogo'),
                 action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
	        		var v=responseJSON;
		          	var cloudhtml="";
		          	if(v.isCloudImg){
			            if(v.normalfilepath!=undefined){
			              cloudhtml+= "<img id='"+id+"' src='"+v.normalfilepath+"' rel='#"+fileName+"'/>";
			              cloudhtml+= "<input id='"+id+"' name='mainpc' type='checkbox' value='"+v.normalfilepath+"' /> ";
			            }
			            if(v.compressfilepath!=undefined){
			              cloudhtml+= "<img id='"+id+"' src='"+v.compressfilepath+"' rel='#"+fileName+"'/>";
			              cloudhtml+= "<input id='"+id+"' name='maincompresspc' type='checkbox' value='"+v.compressfilepath+"' /> ";
			            }
		          	}else{
			            if(v.normalfilepath!=undefined){
			              var localpath="<%=basePath%>"+v.normalfilepath;
			              cloudhtml+= "<img id='"+id+"' src='"+localpath+"' rel='#"+fileName+"'/>";
			              cloudhtml+= "<input id='"+id+"' name='mainpc' type='checkbox' value='"+v.normalfilepath+"' /> ";
			            }
			            if(v.compressfilepath!=undefined){
			            	var compresslocalpath="<%=basePath%>"+v.compressfilepath;
			              cloudhtml+= "<img id='"+id+"' src='"+compresslocalpath+"' rel='#"+fileName+"'/>";
			              cloudhtml+= "<input id='"+id+"' name='maincompresspc' type='checkbox' value='"+v.compressfilepath+"' /> ";
			            }
		          	}
		          	$("#maintriggers").append(cloudhtml);
	      		}
            });  
		}
		createBrandLogoUploader();
	});
 	</script>
	<script type="text/javascript">
 		KE.show({
			id : 'intro',
		    imageUploadJson : '<%=basePath%>admin/js/plugins/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>admin/js/plugins/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		
 	</script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>



