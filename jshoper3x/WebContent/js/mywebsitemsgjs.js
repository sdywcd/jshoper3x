
$(function(){
	//获取url地址用来让用户登录时跳转
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);
	
	$('#hidarea').html(windowsurl);

	//控制开发票是否显示和关闭
	$("#newmsg").toggle(
			function(){
				$('#msgarea').show();
				$('#msgarea1').show();
			},
			function(){
				$('#msgarea').hide();
				$('#msgarea1').hide();
			}
	)

	//发信息
	$("#btn_reportSpam").click(function(){
		$('#inbox').hide();
		$('#write').show();
		$('#text1').hide();
	});
	//收件箱
	$("#setAllReaded").click(function(){
		
		$('#inbox').show();
		$('#write').hide();
		$('#text1').hide();
		window.location.href="findAllWebsiteMsgByToUsername.action";
	});
	//详细信息
	$("#title").click(function(){	
		
		var msgtextid = $('#mailid').val();
		$.post("findMsgtextById.action",{"msgtextid":msgtextid},function(data){
			$('#webtitle').attr("value",data.webbean.title);
			$('#msgfromusrname').attr("value",data.webbean.msgfromusrname);
			$('#createtime').attr("value",data.webbean.createtime);
			$('#msgtousername').attr("value",data.webbean.msgtousername);
			$('#msgtext').attr("value",data.msgbean.text);
		});
		$('#text1').show();
		$('#inbox').hide();
		$('#write').hide();
				
	});
	
	$('#submit').click(function(){
		var title=$('#title').val();
		var msgToUsername=$('#msgToUsername').val();
		var text=$('#text').val();
		if(title==""||msgToUsername==""||text==""){
				return;
		}
		$.post("addWebsiteMsgT.action",{"title":title,"msgToUsername":msgToUsername,"text":text},function(data){
			if(data.slogin){
				if(data.sflag){
					$('#msginfo').text('发送信件成功');
				}
			}else{
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			}
		});
	});
});


