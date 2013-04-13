<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>商品单位设置</title>


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
							商品单位设置
						</h5>


					</div>
					<!-- end box / title -->
					<div class="table">
						<!-- flexigrid -->
						<div id="flexgoodsunitmanagement" style="width: 98%; margin-left: 15px;">
							<table id="goodsunitmanagement" style="display: none;"></table>
						</div>


					</div>
					<div class="title">
						<h5>
							增加/编辑商品单位
						</h5>
					</div>
					<form id="form" action="addGoodsunit.action" method="post" theme="simple">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											单位名称：
										</label>
									</div>
									<div class="input">
										<input type="text" id="unitname" name="unitname" class="small" />
										<div class="button highlight">
											<input type="submit" name="submit" value="增加" class="ui-button ui-widget ui-state-default ui-corner-all" />
											<input id="modify" type="button" value="更新" class="ui-button ui-widget ui-state-default ui-corner-all" style="display: none;" />
											<input type="hidden" id="unitid" name="unitid" value="" />
										</div>
									</div>
								</div>
							</div>
						</div>

					</form>
				</div>
				<!-- end table -->



			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/goodsunitmanagementjs.js"></script>



	</body>
</html>
