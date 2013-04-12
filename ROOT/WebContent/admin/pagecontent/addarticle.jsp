<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("contentvalue") != null ? request.getParameter("contentvalue") : "";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>增加/编辑文章</title>
	
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
							增加/编辑文章
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-medium">
										文章标题:
									</label>
								</div>
								<div class="input">
									<input type="text" id="title" name="title" class="medium" />

								</div>

							</div>
							<div id="addfl" class="field">
								<div class="label">
									<label for="select">
										分类选择:
									</label>
								</div>
								<div class="select">
									<div>
										<select id="parentId" name="parentId">

										</select>
										<select id="parentId1" name="parentId1">

										</select>
									</div>
								</div>

							</div>
							<div id="modfl" class="field">
								<div class="label">
									<label for="select">
										所属分类:
									</label>
								</div>
								<div class="select">
									<div>
										<input type="text" id="parentName" name="parentName" value="" readonly />
										<input type="button" id="modifycategory" name="modifycategory" value="修改" />
									</div>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										作者:
									</label>
								</div>
								<div class="input">
									<input type="text" id="author" name="author" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label label-checkbox">
									<label>
										是否发布:
									</label>
								</div>
								<div class="checkboxes">
									<input id="ispublication" name="ispublication" type="checkbox" checked="checked"/>
										<label>
											是
										</label>
								</div>
							</div>
							<div class="field">
								<div class="label label-checkbox">
									<label>
										是否推荐:
									</label>
								</div>
								<div class="checkboxes">
									<input id="isrecommend" name="isrecommend" type="checkbox" checked="checked" />
									<label>
										是
									</label>
								</div>
							</div>
							<div class="field">
								<div class="label label-checkbox">
									<label>
										是否置顶:
									</label>
								</div>
								<div class="checkboxes">
									<input id="istop" name="istop" type="checkbox" checked="checked" />
									<label>
										是
									</label>
								</div>
							</div>
							<div class="field">
								<div class="label label-checkbox">
									<label>
										是否公告:
									</label>
								</div>
								<div class="checkboxes">
									<input id="isnotice" name="isnotice" type="checkbox" checked="checked" />
									<label>
										是
									</label>
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
										内容:
									</label>
								</div>
								<div style="margin: 0 0 0 200px;">
									<textarea id="contentvalue" name="contentvalue" cols="50" rows="12" style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										页面关键字:
									</label>
								</div>
								<div class="input">
									<input type="text" id="metaKeywords" name="metaKeywords" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										页面描述:
									</label>
								</div>
								<div class="input">
									<textarea id="metaDes" name="metaDes" rows="12" cols="50"></textarea>

								</div>

							</div>
						</div>
					</div>



					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="hidden" id="hidposition" name="hidposition" value="" />
										<input type="hidden" id="hidarticleid" name="hidarticleid" value="" />
										<input type="hidden" id="hidarticleCategoryTid" name="articleCategoryTid" value="" />
										<input type="hidden" id="hidreadcount" name="hidreadcount" value=""/>
										<input type="button" id="submit" name="submit" value="提交" />
										<input type="button" id="modify" name="modify" value="修改" style="display: none;" />
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
			<script type="text/javascript" src="<%=basePath%>jshop/admin/js/articlemanagementjs.js"></script>
		<script type="text/javascript">
 		KE.show({
			id : 'contentvalue',
		    imageUploadJson : '<%=basePath%>jshop/admin/js/jsp/upload_json_articleimg.jsp',
			fileManagerJson :'<%=basePath%>jshop/admin/js/jsp/file_manager_json_articleimg.jsp',
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