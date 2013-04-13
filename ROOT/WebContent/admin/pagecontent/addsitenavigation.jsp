<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>增加/编辑导航</title>

	
	
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
							增加/编辑导航
						</h5>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										名称:
									</label>
								</div>
								<div class="input">
									<input id="name" name="name" type="text" value="" class="small" />
								</div>
							</div>

							<div id="fater" class="field">
								<div class="label">
									<label for="select">
										系统内容:
									</label>
								</div>
								<div class="select">
									<div id="addfl">
										<select id="syscontent" name="syscontent">

										</select>
									</div>
								</div>
							</div>
							<div id="fater" class="field">
								<div class="label">
									<label for="select">
										位置:
									</label>
								</div>
								<div class="select">
									<select id="position" name="position">
										<option value="1">
											上
										</option>
										<option value="2">
											中
										</option>
										<option value="3">
											下
										</option>
									</select>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										链接地址:
									</label>
								</div>
								<div class="input">
									<input id="htmlPath" name="htmlPath" type="text" value="" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label label-checkbox">
									<label>
										是否新窗口打开:
									</label>
								</div>
								<div class="checkboxes">
									<div class="checkbox">
										<input type="checkbox" id="isTargetBlank" name="isTargetBlank" checked="checked" />
										<label for="isTargetBlank">
											是
										</label>
									</div>
									<div class="checkbox">
										<input type="checkbox" id="isTargetBlank" name="isTargetBlank" />
										<label for="isTargetBlank">
											否
										</label>
									</div>

								</div>
							</div>
							<div class="field">
								<div class="label label-checkbox">
									<label>
										是否显示:
									</label>
								</div>
								<div class="checkboxes">
									<div class="checkbox">
										<input type="checkbox" id="isVisible" name="isVisible" checked="checked" />
										<label for="isVisible">
											是
										</label>
									</div>
									<div class="checkbox">
										<input type="checkbox" id="isVisible" name="isVisible" />
										<label for="isVisible">
											否
										</label>
									</div>

								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										标示:
									</label>
								</div>
								<div class="input">
									<input id="sign" name="sign" value="" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										排序:
									</label>
								</div>
								<div class="input">
									<input id="sort" name="sort" value="" reg="^\d+$" tip="只能是数字" class="small" />

								</div>

							</div>

						</div>
					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">


										<input type="hidden" id="hidsnid" name="hidsnid" value="" />

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
<script type="text/javascript" src="<%=basePath%>jshop/admin/js/sitenavigationmanagementjs.js"></script>



	</body>
</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>