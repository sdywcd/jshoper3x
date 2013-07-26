<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
							id="goodsTypeId" name="goodsTypeId">

						</select> <span class="label label-info">请选择一个商品类型</span>
					</div>
					<!-- 加载商品类型属性和参数区域 -->
					
					<div id="gat" style="display:none;border:1px solid #E3E3E3;padding:10px;margin-bottom:10px;">
						<div class="well"><h4>商品属性选择区域</h4></div>

							<div class="form-inline">
								<span class="label label-required">属性选择区:</span> <select
									id="gatarea" name="gatarea"></select>
							</div>
						
					</div>
					
					<div id="params" style="display:none;border:1px solid #E3E3E3;padding:10px;margin-bottom:10px;">
						<div class="well"><h4>商品参数填写区域</h4></div>

							<div class="form-inline">
								<span class="label label-required">参数填写区:</span> 
								<input id="paramsarea" name="paramsarea" value=""/>
							</div>
						
					</div>
					
					
					<div class="form-inline">
						<span class="label label-required">选择分类: </span> 
						<select id="parentId" name="parentId"></select><!-- 顶级分类一级分类 -->
						 <select id="parentId1" name="parentId1"></select> <!-- 二级分类 -->
						 <select id="parentId2" name="parentId2"></select> <!-- 三级分类 -->
						 <span class="label label-info">请选择一个商品分类</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商品名称:</span> <input type="text"
							id="goodsname" name="goodsname" class="medium" />
							<span class="label label-info">商品名称会根据货品规格信息智能变化</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商品编码:</span> <input type="text"
							id="usersetnum" name="usersetnum" class="small" />
							<span class="label label-info">商品编码可以标记货品和商品的归属关系（货品表要记录商品编码）</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">商品品牌: </span> 
						<select id="brandname" name="brandname"></select>
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
						<span class="label label-required">新品:</span> <input
							type="radio" id="isNew" name="isNew" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="isNew" name="isNew" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">推荐:</span> <input
							type="radio" id="recommended" name="recommended" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="recommended" name="recommended" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">热销:</span> <input
							type="radio" id="hotsale" name="hotsale" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="hotsale" name="hotsale" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">特价:</span> <input
							type="radio" id="bargainprice" name="bargainprice" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="bargainprice" name="bargainprice" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">同步移动平台:</span> <input
							type="radio" id="ismobileplatformgoods" name="ismobileplatformgoods" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="ismobileplatformgoods" name="ismobileplatformgoods" value="0" /> <label
							for="radio-2">否 </label>
					</div>
					<div class="form-inline">
						<span class="label label-required">上架:</span> <input
							type="radio" id="salestate" name="salestate" value="1"
							checked="checked" /> <label for="radio-1">是 </label> <input
							type="radio" id="salestate" name="salestate" value="0" /> <label
							for="radio-2">否 </label>
							<span class="label label-info">这里的上架选项和货品中的上架选项不同，这里控制多个，货品仅控制自己一个</span>
					</div>
					<div class="form-inline">
						<span class="label label-required">规格选择:</span>
						 <select id="isSpecificationsOpen" name="isSpecificationsOpen"></select>
							<span class="label label-info">如果选择一般规格则表示该商品下只有一种规格的货品，如果选择其他则表示该商品下有多个规格货品</span>
					</div>
					
					<div id="specificationsarea"class="form-inline" style="display:none;">
						<div class="well"><h4>商品货品规格信息填写区域（商品信息必须由货品规格信息组成）</h4></div>
						<div class="accordion" id="spdefault">
						  <div class="accordion-group">
						    <div class="accordion-heading">
						      <a id="spname" class="accordion-toggle" data-toggle="collapse" data-parent="#spdefault" href="#collapseOne">
						        规格信息区域
						      </a>
						    </div>
						    <div id="collapseOne" class="accordion-body collapse in">
						      <div class="accordion-inner">
								<div class="form-inline">
									<span class="label label-required">货号:</span> 
									<input type="text"id="productSn" name="productSn" class="small" />
									<span class="label label-info">货号是标示货品的唯一编码</span>
								</div>
								<div class="form-inline">
									<span class="label label-required">成本价:</span> 
									<input type="text"id="cost" name="cost" class="small" />
									<span class="label label-info">成本价是该货品实际最合理价值，理论上会员价不得低于成本价</span>
								</div>
								<div class="form-inline">
									<span class="label label-required">销售价:</span> 
									<input type="text"id="saleprice" name="saleprice" class="small" />
									<span class="label label-info">销售价是该货品对非会员或者无优惠时的价格</span>
								</div>
								<div class="form-inline">
									<span class="label label-required">会员价:</span> 
									<input type="text"id="memberprice" name="memberprice" class="small" />
									<span class="label label-info">会员价是该货品对会员或者优惠时的价格</span>
								</div>
								<div class="form-inline">
									<span class="label label-required">市场价:</span> 
									<input type="text"id="price" name="price" class="small" />
									<span class="label label-info">市场价是该货品其他平台的价格</span>
								</div>
								<div class="form-inline">
									<span class="label label-required">重量:</span> 
									<input type="text"id="weight" name="weight" class="small" />
									<select id="unit" name="unit">
											<option value="1">
												克（g）
											</option>
										</select>
									<span class="label label-info">重量的作用是用于计算物流费用</span>
								</div>
								<div class="form-inline">
									<span class="label label-required">库存:</span> 
									<input type="text"id="store" name="store" class="small" />
								</div>
								<div class="form-inline">
									<span class="label label-required">预警库存:</span> 
									<input type="text"id="freezeStore" name="freezeStore" class="small" />
								</div>
								<div class="form-inline">
									<span id="specificationtext" class="label label-required">规格值选择:</span> 
										<div id="specificationvaluearea" style="margin-top:-28px;position:relative;width:110px; display: inline;">
											
											
										</div>
									
								</div>
								<div class="form-inline">
									<span class="label label-required">仓储地址:</span> 
									<input type="text"id="warehouseLocation" name="warehouseLocation" class="small" />
									<span class="label label-info">该值表示库存存放在哪里。如果你有多个仓储点可能比较有用，可以是一个代号或者是详细地址</span>
								</div>
								<div class="form-inline">
									<span class="label label-required">货位:</span> 
									<input type="text"id="placeStore" name="placeStore" class="small" />
									<span class="label label-info">该值表示货物存放在仓库中的位置，一般使用逗号分隔的x，y，z坐标表示</span>
								</div>
								<div class="form-inline">
									<span class="label label-required">是否默认:</span> <input
										type="radio" id="isDefault" name="isDefault" value="1"
										checked="checked" /> <label for="radio-1">是 </label> <input
										type="radio" id="isDefault" name="isDefault" value="0" /> <label
										for="radio-2">否 </label>
								</div>
								
								<div class="form-inline">
									<span class="label label-required">货品上架:</span> <input
										type="radio" id="isSalestate" name="isSalestate" value="1"
										checked="checked" /> <label for="radio-1">是 </label> <input
										type="radio" id="isSalestate" name="isSalestate" value="0" /> <label
										for="radio-2">否 </label>
								</div>
								<div class="form-inline">
									<label class="label label-submit"></label> 
									<input class="btn btn-success" type="button" id="submitp"
										name="submitp" value="保存货品信息" />
								</div>
						      </div>
						    </div>
						  </div>
						 
						</div>
					</div>
					<div  class="form-inline">
					<table>
					<tr>
					<td>
						<span class="label label-required">主图:</span>
						</td>
					<td>
						 <div id="uploadergoodpc">
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
						<span class="label label-required">操作:</span>
						<input class="btn btn-success" type="button" id="delpc" name="delpc" value="删除所选图片"/>
					</div>
					<div class="form-inline">
						<span class="label label-required">商品介绍:</span> <textarea id="detail" name="detail" cols="50" rows="12" style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
					</div>
					
					<div class="form-inline">
						<span class="label label-required">商品清单:</span>
						<textarea id="commoditylist" name="commoditylist" cols="50" rows="12" style="width: 100%; height: 400px; visibility: hidden;"><%=htmlspecialchars(htmlDatacommoditylist)%></textarea>
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
							id="hidgoodsCategoryTid" name="hidgoodsCategoryTid" value="" />
						<input type="hidden" id="hidgrade" name="hidgrade" value="">
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
		src="<%=basePath%>admin/js/goods/goodsmentjs.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
			<script type="text/javascript"
		src="<%=basePath%>admin/js/plugins/kindeditor/kindeditor-min.js"></script>
	<script type="text/javascript">
 		function createUploader(){            
             var uploader = new qq.FileUploader({
                 element: document.getElementById('uploadergoodpc'),
                 action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	var pcpath1="<%=basePath%>"+ responseJSON.success;
							var pcpath = responseJSON.success;
							var htm = "<img id='"+id+"' src='"+pcpath1+"' rel='#"+fileName+"'/>";
							var checkpc = "<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' /> ";
							$("#triggers").append(htm).append(checkpc);
						},
					});
		}
		window.onload = createUploader;
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
 		KE.show({
			id : 'commoditylist',
			items : ['fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist','insertunorderedlist']
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
