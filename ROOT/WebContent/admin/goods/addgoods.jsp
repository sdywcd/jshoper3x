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
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="select">
											选择商品所属分类:
										</label>
									</div>
									<div class="select">
										<select id="navid" name="navid">
											<option value="0">
												---请选择---
											</option>
										</select>
										<select id="ltypeid" name="ltypeid">
											<option value="0">
												---请选择---
											</option>
										</select>
										<select id="stypeid" name="stypeid">
											<option value="0">
												---请选择---
											</option>
										</select>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-medium">
											商品名称:
										</label>
									</div>
									<div class="input">
										<input id="goodsname" name="goodsname" type="text" class="medium"></input>
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											商品编码:
										</label>
									</div>
									<div class="input">
										<input id="usersetnum" name="usersetnum" type="text" class="small" reg="^\d{4,20}$" tip="编号要是4位-20位数字之间"></input>
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											货号:
										</label>
									</div>
									<div class="input">
										<input id="productSn" name="productSn" type="text" class="small"></input>
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="select">
											商品品牌:
										</label>
									</div>
									<div class="select">
										<select id="brandname" name="brandname">
											<option value="0">
												---请选择---
											</option>
										</select>
									</div>
								</div>
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
								<div class="field">
									<div class="label">
										<label for="select">
											重量:
										</label>
									</div>
									<div class="select">
										<input type="text" id="weight" name="weight" class="small"></input>
										<select id="weightselect">
											<option value="0">
												---请选择---
											</option>
										</select>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											初始库存:
										</label>
									</div>
									<div class="input">
										<input type="text" id="quantity" name="quantity" value="0" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											预警库存:
										</label>
									</div>
									<div class="input">
										<input type="text" id="freezeStore" name="freezeStore" value="10" class="small" />

									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											货位:
										</label>
									</div>
									<div class="input">
										<input type="text" id="placeStore" name="placeStore" value="" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											商品积分:
										</label>
									</div>
									<div class="input">
										<input type="text" id="points" name="point" value="0" class="small"></input>
									</div>
								</div>
								<div class="field">
									<div class="label label-radio">
										<label>
											是否新品:
										</label>
									</div>
									<div class="radios">
										<div class="radio">
											<input type="radio" id="isNew" name="isNew" value="1" />
											<label for="radio-1">
												新品
											</label>
										</div>
										<div class="radio">
											<input type="radio" id="isNew" name="isNew" value="0" checked />
											<label for="radio-2">
												非新品
											</label>
										</div>
									</div>
								</div>
								<div class="field">
									<div class="label label-radio">
										<label>
											是否推荐:
										</label>
									</div>
									<div class="radios">
										<div class="radio">
											<input type="radio" id="recommended" name="recommended" value="1" />
											<label for="radio-1">
												推荐
											</label>
										</div>
										<div class="radio">
											<input type="radio" id="recommended" name="recommended" value="0" checked />
											<label for="radio-2">
												不推荐
											</label>
										</div>
									</div>
								</div>
								<div class="field">
									<div class="label label-radio">
										<label>
											是否热销:
										</label>
									</div>
									<div class="radios">
										<div class="radio">
											<input type="radio" id="hotsale" name="hotsale" value="1" />
											<label for="radio-1">
												热销
											</label>
										</div>
										<div class="radio">
											<input type="radio" id="hotsale" name="hotsale" value="0" checked />
											<label for="radio-2">
												不热销
											</label>
										</div>
									</div>
								</div>
								<div class="field">
									<div class="label label-radio">
										<label>
											是否特价:
										</label>
									</div>
									<div class="radios">
										<div class="radio">
											<input type="radio" id="bargainprice" name="bargainprice" value="1" />
											<label for="radio-1">
												特价
											</label>
										</div>
										<div class="radio">
											<input type="radio" id="bargainprice" name="bargainprice" value="0" checked />
											<label for="radio-2">
												不特价
											</label>
										</div>
									</div>
								</div>
								<div class="field">
									<div class="label label-radio">
										<label>
											是否上架:
										</label>
									</div>
									<div class="radios">
										<div class="radio">
											<input type="radio" id="salestate" name="salestate" value="1" />
											<label for="radio-1">
												上架
											</label>
										</div>
										<div class="radio">
											<input type="radio" id="salestate" name="salestate" value="0" checked />
											<label for="radio-2">
												下架
											</label>
										</div>
									</div>
								</div>
								<div class="field">
									<div class="label label-radio">
										<label>
											是否同步到移动平台:
										</label>
									</div>
									<div class="radios">
										<div class="radio">
											<input type="radio" id="ismobileplatformgoods" name="ismobileplatformgoods" value="1" />
											<label for="radio-1">
												同步
											</label>
										</div>
										<div class="radio">
											<input type="radio" id="ismobileplatformgoods" name="ismobileplatformgoods" value="0" checked />
											<label for="radio-2">
												不同步
											</label>
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
					<div id="box-detail" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field">
									<div class="label label-textarea">
										<label for="textarea">
											商品描述:
										</label>
									</div>
									<div style="margin: 0 0 0 200px;">
										<div id="cssrefuse" style="padding:5px">
											<textarea id="detail" name="detail" cols="50" rows="12" style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="box-commoditylist" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field">
									<div class="label label-textarea">
										<label for="textarea">
											商品清单:
										</label>
									</div>
									<div style="margin: 0 0 0 200px;">
										<div id="cssrefuse" style="padding:5px">
											<textarea id="commoditylist" name="commoditylist" cols="50" rows="12" style="width: 100%; height: 400px; visibility: hidden;"><%=htmlspecialchars(htmlDatacommoditylist)%></textarea>
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
								<div class="field">
									<div class="label">
										<label for="input-small">
											页面关键字:
										</label>
									</div>
									<div class="input">
										<input type="text" id="metaKeywords" name="metaKeywords" value="" class="small" />

									</div>
								</div>
								<div class="field">
									<div class="label label-textarea">
										<label for="textarea">
											页面描述:
										</label>
									</div>
									<div class="textarea textarea-editor">
										<textarea id="metaDescription" name="metaDescription" cols="50" rows="12"></textarea>
									</div>
								</div>

							</div>

						</div>
					</div>
					<div id="box-attrs" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field">
									<div class="label">
										<label for="select">
											请选择商品类型:
										</label>
									</div>
									<div class="select">
										<select id="goodsTypeId" name="goodsTypeId">

										</select>
									</div>

								</div>
								<div id="gat" class="select">

								</div>
								<div class="field">
									<div id="gatattr">

									</div>

								</div>

							</div>

						</div>
					</div>
					<div id="box-specification" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field">
									<div class="label">
										<label for="select">
											是否开启商品规格功能:
										</label>
									</div>
									<div class="select">
										<select id="isSpecificationsOpen" name="isSpecificationsOpen">
											<option value="0">
												---请选择---
											</option>
											<option value="1">
												开启
											</option>
											<option value="2">
												关闭
											</option>
										</select>
									</div>
								</div>
								<div class="field">
									<div class="label label-checkbox">
										<label>

										</label>
									</div>
									<div class="checkboxes">
										<div id="Specificationslistarea">

										</div>
										<div id="addproductarea">
											<input type="button" id="addproduct" name="addproduct" value="增加货品" />
										</div>
									</div>
								</div>
								<div class="table">
									<div style="overflow-y: scroll; width: 100%; height: 100%">
										<table id="addproductlistarea">
											<thead>
												<tr>
													<th class="center">
														货号
													</th>
													<th id="tempkey"></th>
													<th>
														销售价
													</th>
													<th>
														会员价
													</th>
													<th>
														市场价
													</th>
													<th>
														成本价
													</th>
													<th>
														重量
													</th>
													<th>
														库存
													</th>
													<th>
														预警库存
													</th>
													<th>
														货位
													</th>
													<th>
														仓库位置
													</th>
													<th>
														默认
													</th>
													<th>
														上架
													</th>
													<th>
														删除
													</th>
												</tr>
											</thead>
											<tbody>

											</tbody>
										</table>
									</div>
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
