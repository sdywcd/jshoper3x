<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("detail") != null ? request
			.getParameter("detail") : "";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlDatacommoditylist = request.getParameter("commoditylist") != null ? request
			.getParameter("commoditylist") : "";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>增加新商品</title>
		<!-- include the Tools -->

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
.abelinked{  
   display: block;  
   border: 1px solid #aaa;  
   text-decoration: none;  
   background-color: #fafafa;  
   color: #123456;  
   margin: 2px;  
   clear:both;  
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
				<!-- tabs -->
				<div class="box ui-tabs ui-widget ui-widget-content ui-corner-all" id="box-tabs">
					<!-- box / title -->
					<div class="title">
						<h5>
							增加新商品
						</h5>
						<ul class="links ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
							<li class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
								<a href="#box-basic">基础信息</a>
							</li>
							<li class="ui-state-default ui-corner-top">
								<a href="#box-mainpicture">图片</a>
							</li>
							<li class="ui-state-default ui-corner-top">
								<a href="#box-detail">描述</a>
							</li>
							<li class="ui-state-defautl ui-corner-top">
								<a href="#box-commoditylist">清单信息</a>
							</li>
							<li class="ui-state-default ui-corner-top">
								<a href="#box-seo">搜索优化</a>
							</li>
							<li class="ui-state-default ui-corner-top">
								<a href="#box-attrs">属性和参数</a>
							</li>
							<!-- <li class="ui-state-default ui-corner-top">
								<a href="#box-specification">规格货品</a>
							</li>
							<li class="ui-state-default ui-corner-top">
								<a href="#box-goodsbelinked">关联商品</a>
							</li>
							<li class="ui-state-default ui-corner-top">
								<a href="#box-virtualresults">虚拟商品</a>
							</li> -->
							<li class="ui-state-default ui-corner-top">
								<a href="#box-submit">提交信息</a>
							</li>
						</ul>
					</div>
					<!-- box / title -->
					<div id="box-basic" class="ui-tabs-panel ui-widget-content ui-corner-bottom">
						<div class="form">
						
							
							
								
								<div class="field">
									<div class="label">
										<label for="input-small">
											销售价:
										</label>
									</div>
									<div class="input">
										<input id="saleprice" name="saleprice" value="0" type="text" class="small"></input>
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											会员价:
										</label>
									</div>
									<div class="input">
										<input type="text" id="memberprice" name="memberprice" value="0" class="small"></input>
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											市场价:
										</label>
									</div>
									<div class="input">
										<input type="text" id="price" name="price" size="20" value="0" class="small"></input>
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											成本价:
										</label>
									</div>
									<div class="input">
										<input type="text" id="cost" name="cost" value="0" class="small"></input>
									</div>

								</div>
								
								
							
						
									</div>
								
								</div>
							</div>
						</div>
					</div>
					<div id="box-mainpicture" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="file">
											主图片:
										</label>
									</div>
									<div class="input input-file">
										<button id="delpc" name="delpc" style="border:1px solid #ccc;">
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
									<div class="input input-file">
										<button id="showserverpc" name="showserverpc" style="border:1px solid #ccc;">
											从服务器选择已上传的图片
										</button>
										
										<!-- trigger elements -->
										<div id="triggers1" style="border:1px solid #ccc;width:80%;height:200px">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				
				
					</div>
					<div id="box-seo" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field">
									<div class="label">
										<label for="select">
											搜索关键字:
										</label>
									</div>
									<div class="select">
										<select id="keywordname" name="keywordname">
											<option value="0">
												---请选择---
											</option>
										</select>
									</div>
								</div>
						
			
					

						</div>
					</div>
					<div id="box-goodsbelinked" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field ">
									<div class="label">
										<label for="select">
											选择商品所属分类进行搜索:
										</label>
									</div>
									<div class="select">
										<div>
											<select id="navidbelinked" name="navidbelinked">
												<option value="0">
													---请选择---
												</option>
											</select>
											<select id="ltypeidbelinked" name="ltypeidbelinked">
												<option value="0">
													---请选择---
												</option>
											</select>
											<select id="stypeidbelinked" name="stypeidbelinked">
												<option value="0">
													---请选择---
												</option>
											</select>
											
											<input style="border:1px solid #ccc;" type="button" id="searchbelinkedgoods" name="searchbelinkedgoods" value="搜索" />
										</div>
									</div>
								</div>
								<div class="field">
									<div class="label label-textarea">
										<label for="textarea">
											可关联商品列表：
										</label>
									</div>
 
									<div class="textarea" style="weight:auto;height:400px;">
										<div style="float:left;text-align:center;margin: 10px;">  
										  <select style="width:400px;height:350px" multiple id="canbelinkedgoodsselect">  
											   <option value="1">商品填充区</option>  
						
										  </select>  
  										  <a class="abelinked" href="#" id="addbelinked">add &gt;&gt;</a>  
 										</div>  
										 <div style="float:left;text-align:center;margin: 10px;">  
											  <select style="width:400px;height:350px" multiple id="linkedgoodsselect"></select>  
											  <a class="abelinked" href="#" id="removebelinked">&lt;&lt; remove</a>  
										 </div>  
									</div>
								</div>

									
								
							</div>

						</div>
					</div>
					<div id="box-virtualresults" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field">
									
									<div class="label label-radio">
										<label>
											是否虚拟:
										</label>
									</div>
									<div class="radios">
										<div class="radio">
											<input type="radio" id="isvirtual" name="isvirtual" value="1" />
											<label for="radio-1">
												是
											</label>
										</div>
										<div class="radio">
											<input type="radio" id="isvirtual" name="isvirtual" value="0" checked />
											<label for="radio-2">
												否
											</label>
										</div>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-medium">
											虚拟反馈:
										</label>
									</div>
									<div class="input">
										<input type="text" id="virtualresults" name="virtualresults" value="" class="medium" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="box-submit" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="input">
										<div class="button highlight">
											<input type="button" id="submit" name="submit" value="完成并增加商品"></input>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end content / right -->

		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/addgoodsjs.js"></script>
		<script type="text/javascript">
 		 function createUploader(){ 
             var uploader = new qq.FileUploader({
                 element: document.getElementById('file-uploader-demo1'),
                 action: '<%=basePath%>/ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	var pcpath1="<%=basePath%>"+responseJSON.success;
  					var pcpath=responseJSON.success;
  					var htm="<img id='"+id+"' src='"+pcpath1+"' rel='#"+fileName+"'/>";
  					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' checked='true'/> "
  					$("#triggers").append(htm).append(checkpc);
                 },
               
             });           
         }
 		window.onload = createUploader; 
 	</script>

		<script type="text/javascript">
 		KE.show({
			id : 'detail',
		    imageUploadJson : '<%=basePath%>/jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>/jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		KE.show({
			id : 'commoditylist',
			items : ['fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist','insertunorderedlist']
		});
 		
 		 $().ready(function(){  
 		   $('#addbelinked').click(function() {  
 		    return !$('#canbelinkedgoodsselect option:selected').remove().appendTo('#linkedgoodsselect');  
 		   });
 		   $('#removebelinked').click(function() {  
 		    return !$('#linkedgoodsselect option:selected').remove().appendTo('#canbelinkedgoodsselect');  
 		   });  
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
