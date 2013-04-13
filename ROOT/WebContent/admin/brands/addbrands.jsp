<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("intro") != null ? request.getParameter("intro") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>增加商品品牌</title>
		<style type="text/css">
#triggers img {
	cursor: pointer;
	margin: 0 5px;
	background-color: #fff;
	border: 1px solid #ccc;
	padding: 2px;
	width: 200px;
	height: 150px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
}
</style>
	</head>

	<body>
		<!-- header 包含头部导航-->
		<%@include file="/jshop/admin/header.jsp"%>
		<!-- end header -->
		<!-- content -->
		<div id="content">
			<!-- end content / left -->
			<%@include file="/jshop/admin/left.jsp"%>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- table -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						<h5>
							增加/编辑商品品牌
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										品牌名称:
									</label>
								</div>
								<div class="input">
									<input type="text" id="brandname" name="brandname" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-medium">
										品牌官方网址:
									</label>
								</div>
								<div class="input">
									<input type="text" id="url" name="url" class="medium" reg="^(http|https|ftp)\://[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\-\._\?\,\'/\\\+&%\$#\=~])*$" tip="URl格式，允许FTP,HTTP,HTTPS" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="file">
										LOGO:
									</label>
								</div>
								<div class="input input-file">
									<button id="delpc" name="delpc">
										删除图片
									</button>
									<div id="file-uploader-demo1">
										<noscript>
											<p>
												Please enable JavaScript to use file uploader.
											</p>
											<!-- or put a simple form for upload here -->
										</noscript>
									</div>
									<!-- trigger elements -->
									<div id="triggers">
									</div>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										排序:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sort" name="sort" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">
										介绍:
									</label>
								</div>
								<div style="margin:0 0 0 200px;">
									<textarea id="intro" name="intro" cols="50" rows="12" style="width:100%;height:600px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
								</div>
							</div>
						</div>
					</div>



					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="hidden" id="hidbrandid" name="hidbrandid" value="" />
										<input type="button" id="submit" name="submit" value="提交" />
										<input type="button" id="modify" name="modify" value="更新" style="display: none;" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end table -->



			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->

<script type="text/javascript" src="<%=basePath%>jshop/admin/js/brandmanagementjs.js"></script>
		<script type="text/javascript">
 		function createUploader(){            
             var uploader = new qq.FileUploader({
                 element: document.getElementById('file-uploader-demo1'),
                 action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	//var pcpath="<%=basePath%>"+responseJSON.success;
                	var pcpath=responseJSON.success;
  					var htm="<img id='"+id+"' src='"+pcpath+"' rel='#"+fileName+"'/>";
  					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' checked='true'/> "
  					$("#triggers").append(htm).append(checkpc);
                 },
             });           
         }
 		window.onload = createUploader; 
 
 	</script>
		<script type="text/javascript">
 		KE.show({
			id : 'intro',
		    imageUploadJson : '<%=basePath%>jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		
 	</script>






	</body>
</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>