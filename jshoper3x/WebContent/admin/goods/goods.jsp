<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("detail") != null ? request
			.getParameter("detail") : "";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>商品信息管理 &middot; jshoper</title>
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""></a> <a class="brand" href="#">商品信息管理 </a> <a
				class="brand2">编辑商品信息 </a>
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
					<strong>说明</strong> 请根据需要编辑商品信息
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
						<span class="label label-required">选择商品类型: </span> <select
							id="goodsTypeId" name="goodsTypeId" >

						</select> <span class="label label-info">请选择一个商品类型</span>
					</div>
					<!-- 加载商品类型属性和参数区域 -->

					<div id="gat"
						style="display: none; border: 1px solid #E3E3E3; padding: 10px; margin-bottom: 10px;">
						<div class="well">
							<h4>商品属性选择区域</h4>
						</div>

						<div class="form-inline">
							<span class="label label-required">属性选择区:</span> <select
								id="gatarea" name="gatarea"></select>
						</div>

					</div>

					<div id="params"
						style="display: none; border: 1px solid #E3E3E3; padding: 10px; margin-bottom: 10px;">
						<div class="well">
							<h4>商品参数填写区域</h4>
						</div>

						<div class="form-inline">
							<span class="label label-required">参数填写区:</span> <input
								id="paramsarea" name="paramsarea" value="" />
						</div>

					</div>

					<div id="goodscategory" style="display: none;" class="form-inline">
						<span class="label label-required">商品所在分类: </span> <span
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

					<div id="selectgoodscategory" class="form-inline">
						<span class="label label-required">选择分类: </span> <select
							id="navid" name="navid"></select>
						<!-- 顶级分类一级分类 -->
						<select id="ltypeid" name="ltypeid"></select>
						<!-- 二级分类 -->
						<select id="stypeid" name="stypeid"></select>
						<!-- 三级分类 -->
						<span class="label label-info">请选择一个商品分类</span>

					</div>
					<div id="modifygoodscategory" style="display: none;"
						class="form-inline">
						<span class="label label-required">操作:</span> <input
							class="btn btn-success" type="button" id="reselectgoodscategory"
							name="reselectgoodscategory" value="重新选择分类" />
					</div>
					<div class="form-inline">
						<span class="label label-required">商品名称:</span> <input type="text"
							id="goodsname" name="goodsname" class="medium" /> <span
							class="label label-info">商品名称会根据货品规格信息智能变化</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商品编码:</span> <input type="text"
							id="usersetnum" name="usersetnum" class="small" /> <span
							class="label label-info">商品编码可以标记货品和商品的归属关系（货品表要记录商品编码）</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商品品牌: </span> <select
							id="brandname" name="brandname"></select>
					</div>
					<div class="form-inline">
						<span class="label label-required">成本价:</span> <input
							type="text" id="cost" name="cost" class="small" /> <span
							class="label label-info">成本价是该货品实际最合理价值，理论上会员价不得低于成本价</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">销售价:</span> <input
							type="text" id="saleprice" name="saleprice" class="small" />
						<span class="label label-info">销售价是该货品对非会员或者无优惠时的价格</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">会员价:</span> <input
							type="text" id="memberprice" name="memberprice"
							class="small" /> <span class="label label-info">会员价是该货品对会员或者优惠时的价格</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">市场价:</span> <input
							type="text" id="price" name="price" class="small" /> <span
							class="label label-info">市场价是该货品其他平台的价格</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商品积分:</span> <input type="text"
							id="points" name="points" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">排序:</span> <input type="text"
							id="sort" name="sort" class="small" />
					</div>
					<div class="form-inline">
						<span class="label label-required">新品:</span> <input type="radio"
							id="isNew" name="isNew" value="1" checked="checked" /> <label
							for="radio-1">是 </label> <input type="radio" id="isNew"
							name="isNew" value="0" /> <label for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">推荐:</span> <input type="radio"
							id="recommended" name="recommended" value="1" checked="checked" />
						<label for="radio-1">是 </label> <input type="radio"
							id="recommended" name="recommended" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">热销:</span> <input type="radio"
							id="hotsale" name="hotsale" value="1" checked="checked" /> <label
							for="radio-1">是 </label> <input type="radio" id="hotsale"
							name="hotsale" value="0" /> <label for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">特价:</span> <input type="radio"
							id="bargainprice" name="bargainprice" value="1" checked="checked" />
						<label for="radio-1">是 </label> <input type="radio"
							id="bargainprice" name="bargainprice" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">同步移动平台:</span> <input
							type="radio" id="ismobileplatformgoods"
							name="ismobileplatformgoods" value="1" checked="checked" /> <label
							for="radio-1">是 </label> <input type="radio"
							id="ismobileplatformgoods" name="ismobileplatformgoods" value="0" />
						<label for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">上架:</span> <input type="radio"
							id="salestate" name="salestate" value="1" checked="checked" /> <label
							for="radio-1">是 </label> <input type="radio" id="salestate"
							name="salestate" value="0" /> <label for="radio-2">否 </label> <span
							class="label label-info">这里的上架选项和货品中的上架选项不同，这里控制多个，货品仅控制自己一个</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">虚拟商品:</span> <input
							type="radio" id="isvirtualsale" name="isvirtualsale" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="isvirtualsale" name="isvirtualsale" value="0" /> <label
							for="radio-2">否 </label>
					</div>
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
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">主图:</span></td>
								<td>
									<div id="mainpicture">
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
							value="删除所选主图片" />
					</div>

					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">展示图:</span></td>
								<td>
									<div id="pclist">
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
						<span class="label label-required">商品介绍:</span>
						<textarea id="detail" name="detail" cols="50" rows="12"
							style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
					</div>

					<div class="form-inline">
						<span class="label label-required">商品清单:</span>
						<textarea id="commoditylist" name="commoditylist" cols="50"
							rows="12" style="width: 100%; height: 400px;"></textarea>
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
							id="hidgoodsid" name="hidgoodsid" value="" /> <input
							type="hidden" id="hidproductid" name="hidproductid" value=""> <input
							class="btn btn-success" type="button" id="submit" name="submit"
							value="提交" /> <input class="btn btn-success" type="button"
							id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>

			</div>

		</div>

	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/goods/goodsmentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/kindeditor/kindeditor-min.js"></script>
	<script type="text/javascript">
	$(function(){
		//创建主图上传控件
		createMainPictureUploader=function(){
			var uploader = new qq.FileUploader({
	      		element: document.getElementById('mainpicture'),
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
		},
		//创建多图上传控件
		createPicturesUploader=function(){
			var uploader = new qq.FileUploader({
	      		element: document.getElementById('pclist'),
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
			              cloudhtml+= "<input id='"+id+"' name='pclist' type='checkbox' value='"+v.normalfilepath+"' /> ";
			            }
			            if(v.compressfilepath!=undefined){
			              cloudhtml+= "<img id='"+id+"' src='"+v.compressfilepath+"' rel='#"+fileName+"'/>";
			              cloudhtml+= "<input id='"+id+"' name='compresspclist' type='checkbox' value='"+v.compressfilepath+"' /> ";
			            }
		          	}else{
			            if(v.normalfilepath!=undefined){
			              var localpath="<%=basePath%>"+v.normalfilepath;
			              cloudhtml+= "<img id='"+id+"' src='"+localpath+"' rel='#"+fileName+"'/>";
			              cloudhtml+= "<input id='"+id+"' name='pclist' type='checkbox' value='"+v.normalfilepath+"' /> ";
			            }
			            if(v.compressfilepath!=undefined){
			            	var compresslocalpath="<%=basePath%>"+v.compressfilepath;
			              cloudhtml+= "<img id='"+id+"' src='"+compresslocalpath+"' rel='#"+fileName+"'/>";
			              cloudhtml+= "<input id='"+id+"' name='compresspclist' type='checkbox' value='"+v.compressfilepath+"' /> ";
			            }
		          	}
		          	$("#triggers").append(cloudhtml);
	      		}
	    	});
		},
		createMainPictureUploader();
		createPicturesUploader();
	});
	

	</script>
	<script type="text/javascript">
 		KE.show({
			id : 'detail',
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
