<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>图片素材设置 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">图片素材管理 </a> <a
				class="brand2">编辑图片素材</a>
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
					<strong>说明</strong> 请根据需要编辑图片素材
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
						<span class="label label-required">存放目录:</span> <input
							type="text" id="imgdirpath" name="imgdirpath" class="small" />
					</div>
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">上传图片素材:</span></td>
								<td>
									<div id="uploaderimagepath">
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
					<div id="process"></div>
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
		src="<%=basePath%>admin/js/material/imagematerialmentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<script type="text/javascript">
		var imgdirpath1
			$(function(){
			imgdirpath1=$.query.get('imgdirpath');
			if(imgdirpath1==""){
				return false;
			}else{
				$('#imgdirpath').attr("value",imgdirpath1);
			}
		});
 		function createUploader(){            
             var uploader = new qq.FileUploader({
                 element: document.getElementById('uploaderimagepath'),
                 action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: [],
                 onComplete: function(id, fileName, responseJSON){
                	 var filetype=["jpeg","jpg","gif","png"];
                	 var dotag=false;
                	 if(fileName.indexOf(".")>=0){
                		 var extname=fileName.substring(fileName.indexOf(".")+1,fileName.length);
                		 for(var i=0;i<filetype.length;i++){
                			 if(extname===filetype[i]){
                				 dotag=true;
                    			 break;
                			 }
                		 }
                		 if(dotag){
                			var pcpath1="<%=basePath%>"+responseJSON.success;
                         	var pcpath=responseJSON.success;
           					var htm="<img id='"+id+"' src='"+pcpath1+"' rel='#"+fileName+"'/>";
           					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' /> ";
           					$("#triggers").append(htm).append(checkpc);
                		 }else{
                			var pcpath1="<%=basePath%>"+responseJSON.success;
                          	var pcpath=responseJSON.success;
                			var checkpc="<br><p id='"+id+"' name='pcpath'>"+fileName+"</p><br>";
                			$("#triggers").append(htm).append(checkpc);
                		 }
                	 }
                	 
                	
                 },
                 onProgress:function(id,fileName,loaded,total){
                	$("#process").text(loaded+"/"+total);
                 },
             });           
         }
 		window.onload = createUploader; 
 
 	</script>
	<%@include file="/admin/footer.jsp"%>

</body>
</html>



