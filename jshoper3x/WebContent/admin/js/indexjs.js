/**
 * ui
 */
$(function(){

});
/*
 * ===========================================Gorgeous split-line==============================================
 */
/**
 * Function
 */
$(function(){
	buildAllHtml=function(){
		$('#backinfo').html("正在生成网站请稍候......");
		$('#buildhtmlsubmit').attr("disabled", true);
		// $("#spaceused1").progressBar();
		// $("#spaceused2").progressBar({ barImage:
		// 'js/jqueryprogressbar/images/progressbg_yellow.gif'} );
		// $("#spaceused3").progressBar({ barImage:
		// 'js/jqueryprogressbar/images/progressbg_orange.gif', showText: false}
		// );
		// $("#spaceused4").progressBar(65, { showText: false, barImage:
		// 'js/jqueryprogressbarimages/progressbg_red.gif'} );
		// $("#buildprogressbar").progressBar();
		// setTimeout("showBuildProcess()", 750);
		$.post("buildAllHtml.action", function(data) {

			if (data.status == "success") {
				$('#backinfo').append(data.buildlog);
				$('#buildhtmlsubmit').attr("disabled", false);
				return;
			}
		});
	},
	//生成sqlite数据库
	createSqlite=function(){
		$.post("createTable.action", function(data) {
			if (data.sqlite) {
				jAlert('生成成功', '信息提示');
				return;
			} else {
				jAlert('生成失败', '信息提示');
				return;
			}
		});
	},
	logout=function(){
		$.post("bk/user/adminlogout.action",function(data){
			var pathnamearray = window.location.pathname.split("/");
			var pathname = pathnamearray[1] + "/";
			top.location.href = "http://" + window.location.host + "/" + pathname + "/login.jsp";
		});
	}
	
});

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * 检测用户是否登录并实行跳转控制
 */
$(function() {
	$.post("checklogin.action", function(data) {
		if (data.slogin) {
			var pathnamearray = window.location.pathname.split("/");
			var pathname = pathnamearray[1] + "/";
			if (pathname == "admin/") {
				pathname = "";
			}
			
			top.location.href ="http://" + window.location.host +"/"+pathname+"admin/login.jsp";
		} else {
			if (data.length > 0) {
				var pathnamearray = window.location.pathname.split("/");
				var pathname = pathnamearray[1] + "/";
				if (pathname == "admin/") {
					pathname = "";
				}
				top.location.href = "http://" + window.location.host + "/" + pathname + "admin/login.jsp";
			} else {
				return;
			}
		}

	});
	
	$.post("bk/user/checkAuthorityException.action",function(data){
		if (data.sauthority) {
			
			var pathnamearray = window.location.pathname.split("/");
			var pathname = pathnamearray[1] + "/";
			if (pathname == "jshop/") {
				pathname = "";
			}
			top.location.href = "http://" + window.location.host + "/" + pathname + "admin/authorityjump.jsp";
		} else {
			if (data.length > 0) {
				var pathnamearray = window.location.pathname.split("/");
				var pathname = pathnamearray[1] + "/";
				if (pathname == "jshop/") {
					pathname = "";
				}
				top.location.href = "http://" + window.location.host + "/" + pathname + "admin/authorityjump.jsp";
			} else {
				return;
			}
		}
	
	});
	
	
	/**
	 * 当点击注销并确认退出时
	 */
	$("#confirmlogout").click(function(){
		logout();
	});
});


