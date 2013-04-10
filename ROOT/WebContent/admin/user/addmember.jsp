<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>


		<title>增加/编辑会员</title>

		
	</head>

	<body>
		<!-- 编辑会员区域 -->
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
							增加/编辑会员
						</h5>
					</div>
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											用户名:
										</label>
									</div>
									<div class="input">
										<input id="username" name="username" type="text" value="" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											邮箱:
										</label>
									</div>
									<div class="input">
										<input id="email" name="email" type="text" value="" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											初始积分:
										</label>
									</div>
									<div class="input">
										<input id="points" name="points" type="text" value="" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="select">
											会员等级:
										</label>
									</div>
									<div class="select">

										<select id="grade" name="grade">
											<option value="0">
												---请选择---
											</option>
											
										</select>

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="select">
											用户类型:
										</label>
									</div>
									<div class="select">
										<select id="state" name="state">
											<option value="0">
												---请选择---
											</option>
											<option value="1">
												普通用户
											</option>
											<option value="2">
												一般管理员
											</option>
											<option value="3">
												超级管理员
											</option>
											<option value="4">
												手机用户
											</option>
										</select>
									</div>

								</div>

								<div class="field">
									<div class="label">
										<label for="select">
											会员状态:
										</label>
									</div>
									<div class="select">
										<select id="userstate" name="userstate">
											<option value="0">
												未激活
											</option>
											<option value="1">
												激活
											</option>
											<option value="2">
												禁止访问
											</option>
											<option value="3">
												禁止发帖
											</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="input">
										<div class="button highlight">
											<input style="display: none;" type="button" id="editadminregister" name="editadminregister" value="更新" />
											<input type="button" id="submit" name="submit" value="注册" />
											<input type="hidden" id="hiduserid" name="hiduserid" value=""/>
											
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
		
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/membermanagementjs.js"></script>

	</body>
</html>
