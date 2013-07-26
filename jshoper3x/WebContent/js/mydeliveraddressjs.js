$(function(){
	//获取url地址用来让用户登录时跳转
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);
	
	$('#hidarea').html(windowsurl);
	$('#addaddress').click(function(){
		var hidurl=$('#hidurl').val();
		var username=$('#username').val();
		//此处添加收货人信息
		var country=$("#country").find("option:selected").text();
		var province=$('#province').find("option:selected").text();
	    var city=$('#city').find("option:selected").text();
	    var district=$('#district').find("option:selected").text();
		var street=$('#street').val();
		var mobile=$('#mobile').val();
		var telno=$('#telno').val();
		var email=$('#email').val();
		var postcode=$('#postcode').val();
		if(username==""&&street==""&&mobile==""){
			alert("请填写收货信息");
			return;
		}
		$.post("addDeliveraddress.action",{"username":username,"country":country,"province":province,"city":city,"district":district,"street":street,"mobile":mobile,"telno":telno,"email":email,"postcode":postcode},function(data){
			
			if(data.slogin){
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp";
			}
			if(data.sflag){
				window.location.href="GetUserDeliverAddress.action";
			}
		});
		
	});
	
	//控制新增地址区域的显示和关闭
	$('#addnewa').click(function(){
		$('#addnewaddressarea').show();
		$('#addressarea').hide();
	});
	$('#closenewa').click(function(){
		$('#addnewaddressarea').hide();
		$('#addressarea').show();
	});
	


});



