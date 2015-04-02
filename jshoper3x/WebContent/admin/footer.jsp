<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<div class="navbar navbar-fixed-bottom">
	<div class="navbar-inner navbar-innerb">
		<div class="pull-right fixed-bottom-cp">&copy; jshoper 2014</div>
		<div class="viewsite fixed-bottom-div">
			<a href="https://github.com/sdywcd/jshoper3x" target="_blank"><i
				class="icon-share-alt"></i> 浏览源码网站</a>
		</div>
		<div class="loggedin-users fixed-bottom-div">
			<span class="badge">0</span> 访客在线
		</div>
		<div class="backloggedin-users fixed-bottom-div">
			<span class="badge">1</span> 管理在线
		</div>
		<div class="no-unread-messages fixed-bottom-div">
			<a href="#"><i
				class="icon-envelope"></i> 0</a>
		</div>
		<div class="logout fixed-bottom-div">
			<a href="#myModal" role="button" data-toggle="modal"><i
				class="icon-minus-sign"></i> 注销</a>
		</div>
	</div>
</div>

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">退出jshoper？</h3>
	</div>
	<div class="modal-body">
		<p>请再次确认您的操作…</p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		<button id="confirmlogout" class="btn btn-primary">确认退出</button>
	</div>
</div>
</html>
