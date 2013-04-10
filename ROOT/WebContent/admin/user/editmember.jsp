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


		<title>修改管理员密码</title>

		
	

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
							修改管理员密码
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
									<input id="username" name="username" type="text" value="" class="small" readonly />
								</div>
							</div>

							<div class="field">
								<div class="label">
									<label for="input-small">
										原始密码:
									</label>
								</div>
								<div class="input">
									<input id="password" name="password" type="password" value="" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										新密码:
									</label>
								</div>
								<div class="input">
									<input id="newpassword" name="newpassword" value="" type="password" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										重复新密码:
									</label>
								</div>
								<div class="input">
									<input id="renewpassword" name="renewpassword" type="password" value="" class="small" />
								</div>
							</div>
						</div>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" id="editmember" name="editmember" value="修改" />
										<input type="hidden" id="userid" name="userid" value="" />
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
	<script type="text/javascript">
 function extendsValidate(){
	if($('#newpassword').val()==$('#renewpassword').val(){
		$('#renewpassword').validate_callback(null,"sucess");
	} else {
		$('#renewpassword').validate_callback("两次输入的密码不匹配","failed");
		return false;
	}
 }
</script>
	</body>
</html>
