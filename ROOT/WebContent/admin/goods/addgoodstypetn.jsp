<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>增加商品类型</title>


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
							增加/编辑商品类型
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商品类型名称:
									</label>
								</div>
								<div class="input">
									<input type="text" id="name" name="name" class="small" />
									<div class="button highlight">
										<input type="button" id="submit" name="submit" value="增加" />
										<input id="modify" type="button" value="更新" style="display: none;" />
										<input type="button" id="addparam" name="addparam" value="增加参数" />
										<input type="hidden" id="goodsTypeId" name="goodsTypeId" value="" />

									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="title">
						<h5>
							增加/编辑商品类型参数
						</h5>
					</div>
					<div class="table">
						<table>
							<thead>
								<tr>
									<th class="center">
										参数名称
									</th>
									<th>
										排序
									</th>
									<th>
										操作
									</th>
								</tr>

							</thead>
							<tbody>

							</tbody>
						</table>
					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">

										<input type="button" id="submitparam" name="submitparam" value="提交" />
										<input type="button" id="modifyparam" name="modifyparam" value="更新" style="display: none;" />
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/goodstypetnmanagementjs.js"></script>




	</body>
</html>
