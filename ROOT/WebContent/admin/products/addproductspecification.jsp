<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>增加商品规格管理</title>
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
							增加/编辑商品规格
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										规格名称:
									</label>
								</div>
								<div class="input">
									<input type="text" id="name" name="name" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="select">
										规格类型:
									</label>
								</div>
								<div class="select">
									<select id="specificationsType" name="specificationsType">
										<option value="1">
											文字类型
										</option>
										<option value="2">
											图片类型
										</option>
									</select>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										备注:
									</label>
								</div>
								<div class="input">
									<input type="text" id="note" name="note" class="small" />

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
								<div class="label">
									<label for="input-small">

									</label>
								</div>
								<div class="input">
									<div id="selectcolordiv">
										<div id="selectcolor" style="color: red; font-size: 1.4em"></div>
										<form action="" style="width: 500px;">
											<div id="picker" style="float: right;"></div>
											<div class="form-item">
												<input type="text" id="color1" name="color1" class="colorwell" value="#123456" />
											</div>
											<div class="form-item">
												<input type="text" id="color2" name="color2" class="colorwell" value="#123456" />
											</div>
											<div class="form-item">
												<input type="text" id="color3" name="color3" class="colorwell" value="#123456" />
											</div>

										</form>
									</div>

								</div>

							</div>

						</div>
					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" id="addparam" name="addparam" value="增加规格值" />
									</div>
								</div>
							</div>
						</div>
					</div>



					<div class="title">
						<h5>
							增加/编辑商品规格
						</h5>
					</div>
					<div class="table">
						<table>
							<thead>
								<tr>
									<th class="center">
										规格值名称
									</th>
									<th>
										规格值参数
									</th>
									<th>
										图片
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

										<input type="hidden" id="hidspecificationsid" name="hidspecificationsid" value="" />
										<input type="button" id="submit" name="submit" value="提交" />
										<input type="button" id="modify" name="modify" value="更新" style="display: none;" />
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/productspecificationmanagementjs.js"></script>
		<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('#demo').hide();
		var f = $.farbtastic('#picker');
		var p = $('#picker').css('opacity', 0.25);
		var selected;
		$('.colorwell').each(function() {
			f.linkTo(this);
			$(this).css('opacity', 0.75);
		}).focus(function() {
			if (selected) {
				$(selected).css('opacity', 0.75).removeClass('colorwell-selected');
			}
			f.linkTo(this);
			p.css('opacity', 1);
			$(selected = this).css('opacity', 1).addClass('colorwell-selected');
		});
	});
	
 	

</script>


	</body>
</html>
