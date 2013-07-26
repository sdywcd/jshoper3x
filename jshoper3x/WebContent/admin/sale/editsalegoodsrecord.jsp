<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("detail") != null ? request
			.getParameter("detail") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#triggers img {
	cursor: pointer;
	margin: 0 5px;
	background-color: #fff;
	border: 1px solid #ccc;
	padding: 2px;
	width: 200px;
	height: 150px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
}

.abelinked {
	display: block;
	border: 1px solid #aaa;
	text-decoration: none;
	background-color: #fafafa;
	color: #123456;
	margin: 2px;
	clear: both;
}
</style>
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
					<h5>拍买记录</h5>

				</div>

				<div class="form">
					<div class="fields">

						<div class="field field-first">
							<div class="label">
								<label for="input-small">拍买用户 </label>
							</div>
							<div class="input">
								<input type="text" id="username" name="username"
									class="small"  readonly="readonly"/>(不可修改)

							</div>
						</div>
						<div class="field field-first">
							<div class="label">
								<label for="input-small">拍买用户姓名 </label>
							</div>
							<div class="input">
								<input type="text" id="realname" name="realname"
									class="small" readonly="readonly"/>(不可修改)

							</div>
						</div>
					<div class="field field-first">
							<div class="label">
								<label for="input-small">商品编号 </label>
							</div>
							<div class="input">
								<input type="text" id="salegoodsnumber" name="salegoodsnumber"
									class="small" />

							</div>
						</div>
 
						<div class="field field-first">
							<div class="label">
								<label for="input-small"> 商品名称: </label>
							</div>
							<div class="input">
								<input type="text" id="salegoodsname" name="salegoodsname"
									class="small" />

							</div>
						</div>

						<div class="field field-first">
							<div class="label">
								<label for="input-small"> 起拍价: </label>
							</div>
							<div class="input">
								<input type="text" id="salestartingprice" name="salestartingprice"
									class="small" />

							</div>
						</div>
							<div class="field field-first">
							<div class="label">
								<label for="input-small">成交价 :</label>
							</div>
							<div class="input">
								<input type="text" id="saleprice" name="saleprice"
									class="small"  />

							</div>
						</div>
				
							<div class="field field-first">
							<div class="label">
								<label for="input-small">拍卖者:</label>
							</div>
							<div class="input">
								<input type="text" id="salepeople" name="salepeople"
									class="small" />

							</div>
						</div>
							
							<div class="field field-first">
							<div class="label">
								<label for="input-small">固定电话 :</label>
							</div>
							<div class="input">
								<input type="text" id="telno" name="telno"
									class="small" />

							</div>
						</div>
							
							<div class="field field-first">
							<div class="label">
								<label for="input-small">手机号 :</label>
							</div>
							<div class="input">
								<input type="text" id="mobile" name="mobile"
									class="small" />

							</div>
						</div>
							<div class="field field-first">
							<div class="label">
								<label for="input-small">性别 :</label>
							</div>
							<div class="radios">
								<div class="radio">
									<input type=radio id="sex" name="sex"
										class="small" value="1" /> <label>男</label> <input
										type=radio id="sex" name="sex"
										class="small" checked="checked" value="0" /> <label>女</label>
								</div>
							</div>
						</div>
						<div class="field field-first">
							<div class="label">
								<label for="input-small">邮箱 :</label>
							</div>
							<div class="input">
								<input type="text" id="email" name="email"
									class="small"  />
							</div>
						</div>
						<div class="field field-first">
							<div class="label">
								<label for="input-small">积分:</label>
							</div>
							<div class="input">
								<input type="text" id="points" name="points"
									class="small" />
							</div>
						</div>
							<div class="field field-first">
							<div class="label">
								<label for="input-small">当前最高价:</label>
							</div>
							<div class="input">
								<input type="text" id="hiprice" name="hiprice"
									class="small" />
							</div>
						</div>
						
						<div class="field field-first">
							<div class="label">
								<label for="input-small"> 成交时间： </label>
							</div>
							<div class="input">
								<input type="text" id="saletradetime" name="saletradetime" class="small"
									onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})" />

							</div>
						</div>
							<div class="field field-first">
							<div class="label">
								<label for="input-small">参加拍买人数:</label>
							</div>
							<div class="input">
								<input type="text" id="joinnumber" name="joinnumber"
									class="small"  readonly="readonly"/>
							</div>
						</div>
						<div class="field field-first">
							<div class="label">
								<label for="input-small">商城价:</label>
							</div>
							<div class="input">
								<input type="text" id="marketprice" name="marketprice"
									class="small"  />
							</div>
						</div>
						<div class="field field-first">
							<div class="label">
								<label for="input-small"> 拍卖开始时间： </label>
							</div>
							<div class="input">
								<input type="text" id="begingtime" name="begingtime" class="small"
									onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})" />

							</div>
						</div>
							<div class="field field-first">
							<div class="label">
								<label for="input-small"> 拍卖结束时间： </label>
							</div>
							<div class="input">
								<input type="text" id="endingtime" name="endingtime" class="small"
									onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})" />

							</div>
						</div>
							<div class="field field-first">
							<div class="label">
								<label for="input-small">拍卖商品简介:</label>
							</div>
							<div class="input">
							<textarea rows="10" cols="40" id="salegoodsmessage" name="salegoodsmessage"
									class="small" ></textarea>
							</div>
						</div>
							<div class="field field-first">
							<div class="label">
								<label for="input-small">最低叫价:</label>
							</div>
							<div class="input">
								<input type="text" id="lowprice" name="lowprice"
									class="small"  />
							</div>
						</div>
						<div class="field field-first">
							<div class="label">
								<label for="input-small">产地:</label>
							</div>
							<div class="input">
								<input type="text" id="place" name="place"
									class="small"  />
							</div>
						</div>
						<div class="field field-first">
							<div class="label">
								<label for="input-small">生产厂商:</label>
							</div>
							<div class="input">
								<input type="text" id="manufacturer" name="manufacturer"
									class="small"  />
							</div>
						</div>
							<div class="field field-first">
							<div class="label">
								<label for="input-small">对应拍卖id:</label>
							</div>
							<div class="input">
								<input type="text" id="salegoodsid" name="salegoodsid"
									class="small"  />
							</div>
						</div>
						<div id="box-mainpicture" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
						<div class="form">
							<div class="fields">
								<div class="field">
									<div class="label">
										<label for="file">
										拍卖商品图片：
										</label>
									</div>
									<div class="input input-file">
										<button id="delpc" name="delpc">
											删除图片
										</button>
										<div id="file-uploader-demo1">
											<noscript>
												<p>
													Please enable JavaScript to use file uploader.
												</p>
												<!-- or put a simple form for upload here -->
											</noscript>
										</div>
										<!-- trigger elements -->
										<div id="triggers">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
						
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										拍卖商品说明:
									</label>
								</div>
								<div style="margin: 0 0 0 200px;">
									<div id="cssrefuse">
										<textarea id="salegoodsinformation" name="salegoodsinformation" cols="50" rows="12" style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
									</div>
								</div>
							</div>
								<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="hidden" id="salerecordid" name="salerecordid" />
								<!-- <input type="button" id="add" name="add" value="提交" />  -->
										<input type="button" id="update" name="update" value="更新"/>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
					
						</div>
					</div>	
				</div>
							
							
				<!-- end table -->
				
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/regme.js"></script>
		<script type="text/javascript" src="<%=basePath%>/admin/js/sale/salerecordmanagement.js"></script>
		<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script>
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
		<script type="text/javascript">
 		KE.show({
			id : 'salegoodsinformation',
		    imageUploadJson : '<%=basePath%>/jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>/jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		KE.show({ 
			id : 'commoditylist',
			items : ['fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist','insertunorderedlist']
		});
 		
 		 $().ready(function(){  
 		   $('#addbelinked').click(function() {  
 		    return !$('#select1 option:selected').remove().appendTo('#select2');  
 		   });
 		   $('#removebelinked').click(function() {  
 		    return !$('#select2 option:selected').remove().appendTo('#select1');  
 		   });  
 		 });  
 		
 	</script>
	</body>

</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>