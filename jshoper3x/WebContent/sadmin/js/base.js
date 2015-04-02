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
	}
	
	
	
	
});
