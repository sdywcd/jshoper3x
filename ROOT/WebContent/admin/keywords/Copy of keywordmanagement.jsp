<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>商品关键字设置</title>


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
							商品关键字设置
						</h5>
					</div>
					<!-- end box / title -->
					<div class="table">
						<!-- flexigrid -->
						<div id="flexkeywordmanagement" style="width: 98%; margin-left: 15px;">
							<table id="keywordmanagement" style="display: none;"></table>
						</div>
					</div>
					<div class="title">
						<h5>
							增加/编辑商品关键字
						</h5>
					</div>
					
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											关键字名称：
										</label>
									</div>
									<div class="input">
										<input id="keywordname" name="keywordname" type="text" value="" class="small" />

									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="select">
											类型：
										</label>
									</div>
									<div class="select">
										<select id="type" name="type">
											<option value="0">
												---请选择---
											</option>
											<option value="1">
												商品类型
											</option>
											<option value="2">
												文章类型
											</option>
										</select>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="select">
											显示状态：
										</label>
									</div>
									<div class="select">
										<select id="state" name="state">
											<option value="1" selected>
												显示
											</option>
											<option value="2">
												隐藏
											</option>
										</select>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											显示顺序：
										</label>
									</div>
									<div class="input">
										<input type="text" id="sort" name="sort" class="small" />
									</div>
								</div>
								
								<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" name="submit" id="submit" value="提交" />
										<input id="modify" type="button" value="更新" style="display: none;" />
										<input type="hidden" id="keywordid" name="keywordid" value=""></input>
										</div>
								</div>
							</div>
						</div>
					</div>
								<div class="field">
									<div class="label">
										<label for="input-small"></label>
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

		
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/keywordmanagementjs.js"></script>

	</body>
</html>
