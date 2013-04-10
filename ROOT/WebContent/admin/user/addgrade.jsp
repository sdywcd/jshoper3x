<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("content") != null ? request.getParameter("content") : "";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>增加会员等级</title>

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

					<div class="title">
						<h5>
							增加/编辑会员等级
						</h5>
					</div>
						<div class="form">
							<div class="fields">

								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											选择会员等级名称：
										</label>
									</div>
									<div class="input">
										<input id="gradename" name="gradename" type="text" class="small"></input>
									</div>
								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											升级所需金额：
										</label>
									</div>
									<div class="input">
										<input id="needcost" name="needcost" type="text" class="small"></input>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											该等级可获得折扣：
										</label>
									</div>
									<div class="input">
										<input id="discount" name="discount" type="text" class="small"></input><span>例如:需要7折,则输入0.7</span>
									</div>
								</div>
							
								<div class="form">
									<div class="fields">
										<div class="field field-first">
											<div class="input">
												<div class="button highlight">
												<input type="submit" id="submit" name="submit" value="增加" />
												<input style="display: none;" type="button" id="editgrade" name="editgrade" value="更新" />
												<input type="hidden" id="gradeid" name="gradeid" value="" />
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
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->

		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/grademanagementjs.js"></script>





	</body>
</html>
