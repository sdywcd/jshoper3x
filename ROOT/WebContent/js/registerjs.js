var flag =false;
//验证商品传递的参数
function  validatethenpostinfotoaddgoods(){
	var username = $('#username').val();
	var password =$('#password').val();
	var rpassword =$('#rpassword').val();
	var email =$('#email').val();
	var rand= $('#rand').val();
	var random =$('#random').val();
	 if(username==""){
		 alert("用户名必须填写");
		 return false;
	 }
	 if(password==""){
		 alert("密码必须填写");		 
		 return false;
	 }
	 if(password<4&&password>20){
		 alert("密码必须为6 - 20 之间");
		 return false;
	 }
	 if(rpassword == ""){
		 alert("请重复密码");
		 return false;
	 }
	 if(rpassword!=password){
		 alert("两次填写密码不一致");
		 return false;
	 }
	 if(email==""){
		 alert("邮箱必须填写");
		 return false;
	 }
	 if(rand==""){
		 alert("验证码必须填写");
		 return false;
	 }
//	 if(rand!=random){
//		 alert("验证码填写有误");
//		 return false;
//	 }
	 if (/^[0-9a-z][_.0-9a-z-]{0,31}@([0-9a-z][0-9a-z-]{0,30}[0-9a-z].){1,4}[a-z]{2,4}$/.test(email))
		 {		 }else{  
	    	alert("邮箱格式不正确，请重新填写");
	    	return false;}
	 flag=true;
}
//function isemail(email)
//{
//    if (/^[0-9a-z][_.0-9a-z-]{0,31}@([0-9a-z][0-9a-z-]{0,30}[0-9a-z].){1,4}[a-z]{2,4}$/.test(email))return true;
//    else  
//    	alert("邮箱格式不正确，请重新填写");
//    	return false;
//}


$(function(){
	
//	$('#submit').click(function(){
//		validatethenpostinfotoaddgoods();
//	});
	
	var msg=$.query.get('msg');
	if(msg!=""){
		$("#msg").text("");
		switch(msg){
			case 1:
				$("#msg").text("6-20个字符建议使用您的邮箱或者手机号码不允许中文字符");
				break;
			case 2:
				$("#msg").text("6-20个非中文字符");
				break;
			case 3:
				$("#msg").text("邮箱必须填写");
				break;
			case 4:
				$("#msg").text("用户已经存在");
				break;
			case 5:
				$("#msg").text("验证码错误");
				break;
			case 6:
				$("#msg").text("激活邮件已经发送");
				break;
			case 7:
				$("#msg").text("邮箱已经被使用");
				break;
		}
	}

	
});
