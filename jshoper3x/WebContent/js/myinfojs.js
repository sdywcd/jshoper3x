
$(function(){
	//获取url地址用来让用户登录时跳转
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);
	
	$('#hidarea').html(windowsurl);

	$('#submit').click(function(){
		var realname=$('#realname').val();
		if(realname==""){
			$('#realnamemsg').text("真实姓名必须填写");
			return;
		}
		var sex=$('input[name="sex"]:checked').val();
		var mobile=$('#mobile').val();
		var telno=$('#telno').val();
		var qq=$('#qq').val();
		var msn=$('#msn').val();
		var othercontract=$('#othercontract').val();
		
		$.post("UpdateUserforMyInfo.action",{"realname":realname,"sex":sex,"mobile":mobile,"telno":telno,"qq":qq,"msn":msn,"othercontract":othercontract},function(data){
			return;
		});
		
	});
});


