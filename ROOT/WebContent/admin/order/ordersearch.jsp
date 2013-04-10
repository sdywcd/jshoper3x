<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>订单查询</title>
		
		
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
							订单查询
						</h5>


					</div>
					<!-- end box / title -->
					<div class="table">
						<!-- flexigrid -->
						<div id="flexordersearch" style="width: 98%; margin-left: 15px;">
							<table id="ordersearch" style="display: none;">	
							</table>
							<form id="form" action="InitOrdersDetail.action" method="post" theme="simple">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											订单编号：
										</label>
									</div>
									<div class="input">
										<input type="text" id="orderid" name="orderid" class="small" />
										<div class="button highlight">
											<input type="submit" name="submit" value="查询" class="ui-button ui-widget ui-state-default ui-corner-all" />											
										</div>
									</div>
								</div>
							</div>
						</div>

					</form>
							
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

	</body>
</html>
