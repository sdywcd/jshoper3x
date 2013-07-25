<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>增加用户角色</title>
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
							增加/编辑用户角色
						</h5>
					</div>
					
					
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
									<label for="select">
										选择角色:
									</label>
								</div>
								<div class="select">
									<div>
										<select id="roleid" name="roleid">

										</select>
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
										<input  type="button" id="submitrole" name="submitrole" value="提交"/>
										<input type="button" id="modifyrole" name="modifyrole" value="修改" style="display: none;" />
										<input type="hidden" id="hidid" name="hidid" value=""/>
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
  	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/membermanagementjs.js"></script>
  
  </body>
</html>