$(function(){
	//控制购物车显示
	$("#download_now").hover(function(){
		$('.tooltip').css("display","block");
	},
	function(){
		$('.tooltip').css("display","block");
	});
	$('#cartmark').hover(function(){
		$('.tooltip').css("display","block");
	},
	function(){
		$('.tooltip').css("display","none");
	});
	
	
	//获取url地址用来让用户登录时跳转
	function redirect(){
		var url=window.location.search;
		if(url==""){
			var redirecturl="index.html";
			window.location.href=redirecturl;
		}else{
			var redirecturl= url.substring(url.indexOf("?")+13,url.length);
			self.location=redirecturl;
		}
	}
	
	//用户登录ajax
	$("#submit").click(function(){
		var username=$('#username').val();
		var password=$('#password').val();
		$.post("login.action",{"username":username,"password":password},function(data){
			if(data.loginflag){
				redirect();
			}else{
				return;
			}
			
		});
	});


});