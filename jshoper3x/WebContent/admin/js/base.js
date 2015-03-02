$(function(){

	
	
	/**
	 * 当表单有错误的时候用来显示提示信息
	 * divid 需要填充的层
	 * msg 提示信息
	 * location 提示后定位页面的div id
	 */
	formwarning=function(divid,msg){
		$(divid).show();
		$(divid+" strong").text(msg);
		window.location.hash = "#navigation";
	},
	forminfo=function(divid,msg){
		$(divid).show();
		$(divid+" strong").text(msg);
		window.location.hash = "#navigation";
	},
	$("#btnback").click(function(){
		history.back(-1);
	});
	/**
	 * 动态改变页面标题区域值
	 */
	setdttitle=function(divid,msg){
		$(divid).text(msg);
	};
	

	
});
/*
 * ===========================================Gorgeous split-line==============================================
 */
//(function($){
//	// fix sub nav on scroll
//	var $win = $(window)
//	  , $nav = $('.subnav')
//	  , navTop = $('.subnav').length && $('.subnav').offset().top - 40			  , isFixed = 0
//
//	processScroll()
//
//	// hack sad times - holdover until rewrite for 2.1
//	$nav.on('click', function () {
//		if (!isFixed) setTimeout(function () {  $win.scrollTop($win.scrollTop() - 47) }, 10)
//	})
//
//	$win.on('scroll', processScroll)
//
//	function processScroll() {
//		var i, scrollTop = $win.scrollTop()
//		if (scrollTop >= navTop && !isFixed) {
//			isFixed = 1
//			$nav.addClass('subnav-fixed')
//		} else if (scrollTop <= navTop && isFixed) {
//			isFixed = 0
//			$nav.removeClass('subnav-fixed')
//		}
//	}
//})(jQuery);