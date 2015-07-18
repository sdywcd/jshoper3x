
$(function(){
	
	$("#delpc").click(function() {
		var str = "";
		var sum = 0;
		$(":checkbox[name='pcpath']").each(function() {
			if ($(this).attr("checked")) {
				sum++;
				str += this.id + ",";
			}
		});
		if (sum == 0) {
			alert('只有在选择图片后才能删除');
			return false;
		}
		var array = new Array();
		array = str.split(",");
		$(array).each(function(k, v) {
			$("#triggers img").remove("img[id=" + v + "]");
			$("#triggers input[name='pcpath']").remove("input[id=" + v + "]");
		});
	});
	
	updateUserT=function(){
		var realname=$("#realname").val();
		var mobile=$("#mobile").val();
		var qq=$("#qq").val();
		var weixin=$("#weixin").val();
		var sinaweibo=$("#sinaweibo").val();
		//获取头像路径集合
		var headpath="";
		$(":checkbox[name='pcpath']").each(function() {
			if($(this).attr("checked")){
				headpath+=this.value+",";
			}
		});
		headpath=headpath.toString().substring(0, headpath.length-1);
		var email=$("#email").val();
		var question=$("#question").val();
		var answer=$("#answer").val();
		var state=$("#state").val();
		var userstate=$("input[name='userstate']:checked").val();
		var hiduserid=$("#hiduserid").val();
		$.post("updateUserT.action",{
			"realname":realname,
			"mobile":mobile,
			"qq":qq,
			"weixin":weixin,
			"sinaweibo":sinaweibo,
			"headpath":headpath,
			"email":email,
			"question":question,
			"answer":answer,
			"userstate":userstate,
			"state":state,
			"userid":hiduserid
		},function(data){
			if(data.sucflag){
				window.location.href="userment.jsp?operate=find&folder=user";
				return;
			}
		});
	},
	
	findUserByUserid=function(){
		var userid=$.query.get('userid');
		if(userid==""){
			return false;
		}
		$.post("findUserById.action",{"userid":userid},function(data){
			if(data.sucflag){
				$('#username').attr("value",data.bean.username);
				$("#password").attr("value",data.bean.password);
				$('#realname').attr("value",data.bean.realname);
				$('#mobile').attr("value",data.bean.mobile);
				$('#qq').attr("value",data.bean.qq);
				$('#weixin').attr("value",data.bean.weixin);
				$('#sinaweibo').attr("value",data.bean.sinaweibo);
				//获取头像路径集合
				var pcpath="";
				var pcurl=data.bean.headpath;
				var htm="";
				var checkpc="";
				var temp=pcurl.split(',');
				var allpcpath="";
				$.each(temp,function(n,value){
					if(""==value){
						return;
					}
					pcpath=value;
					htm="<img id='"+value+"' src='"+data.bean.headpath+"'></img>";
					checkpc="<input id='"+value+"' name='pcpath' type='checkbox' value='"+value+"' checked/>";
					allpcpath=htm+checkpc;
					$('#triggers').append(allpcpath);
				});
				$('#email').attr("value",data.bean.email);
				$('#question').attr("value",data.bean.question);
				$('#answer').attr("value",data.bean.answer);
				$('#state').val(data.bean.state);
				if("1"==data.bean.userstate){
					$("input[name='userstate']").get(0).checked=true;
				}else{
					$("input[name='userstate']").get(1).checked=true;
				}
				$('#hiduserid').attr("value",data.bean.userid);
				$("#password").attr("readonly",true);
				$('#username').attr("readonly",true);
				$('#submit').hide();
				$('#update').show();	
				
			}
			
			
		});
		
	},
	
	
	saveUser=function(){
		var username=$("#username").val();
		if(username==""){
			formwarning("#alerterror", "用户名必须填写");
			return false;
		}
		var password=$("#password").val();
		if(password==""){
			formwarning("#alerterror", "密码必须填写");
			return false;
		}
		if(password.length<7||password.length>16){
			formwarning("#alerterror", "密码长度必须大于等于7位小于16位");
			return false;
		}
		var realname=$("#realname").val();
		var mobile=$("#mobile").val();
		var qq=$("#qq").val();
		var weixin=$("#weixin").val();
		var sinaweibo=$("#sinaweibo").val();
		//获取头像路径集合
		var headpath="";
		$(":checkbox[name='pcpath']").each(function() {
			if($(this).attr("checked")){
				headpath+=this.value+",";
			}
		});
		headpath=headpath.toString().substring(0, headpath.length-1);
		var email=$("#email").val();
		var question=$("#question").val();
		var answer=$("#answer").val();
		var state=$("#state").val();
		var userstate=$("input[name='userstate']:checked").val();
		$.post("saveUserT.action",{
			"username":username,
			"password":password,
			"realname":realname,
			"mobile":mobile,
			"qq":qq,
			"weixin":weixin,
			"sinaweibo":sinaweibo,
			"headpath":headpath,
			"email":email,
			"question":question,
			"answer":answer,
			"userstate":userstate,
			"state":state
		},function(data){
			if(data.sucflag){
				window.location.href="userment.jsp?operate=find&folder=user";
				return;
			}else{
				if(data.message!=""){
					formwarning("#alerterror",data.message);
					return false;
				}else{
					formwarning("#alerterror", "用户增加失败");
					return false;
				}
			}
		});
	},
	
	findAllUser=function(){
		$("#usermanagement").flexigrid( {
			url : 'bk/user/findAllUsert.action',
			dataType : 'json',
			cache : false,
			colModel : [ {
				display:'店铺名',
				name:'shopname',
				width:200,
				sortable:true,
				align:'center'
			},{ 
				display:'用户名',
				name:'username',
				width:215,
				sortable:true,
				align:'center'
			},{ 
				display:'真名',
				name:'realname',
				width:115,
				sortable:true,
				align:'center'
			},{ 
				display:'邮箱',
				name:'email',
				width:215,
				sortable:true,
				align:'center'
			},{ 
				display:'手机',
				name:'mobile',
				width:115,
				sortable:true,
				align:'center'
			},{ 
				display:'角色',
				name:'rolemname',
				width:115,
				sortable:true,
				align:'center'
			},{ 
				display:'账号类型',
				name:'state',
				width:115,
				sortable:true,
				align:'center'
			},{ 
				display:'账户状态',
				name:'userstate',
				width:115,
				sortable:true,
				align:'center'
			},{ display:'操作',
				name:'operate',
				width:100,
				sortable:true,
				align:'center'
			}],
			buttons : [ {
				name : '添加',
				bclass : 'add',
				onpress : action
			},{
				name : '编辑',
				bclass : 'edit',
				onpress : action
			},{
				name:'删除',
				bclass:'del',
				onpress:action
			},{
				name:'激活',
				bclass:'edit',
				onpress:action
			},{
				name:'设置角色',
				bclass:'edit',
				onpress:action
			}
//			,{
//				name:'查看权限',
//				bclass:'edit',
//				onpress:action
//			}
			,{
				separator : true
			} ],

			searchitems : [{
				display:'请选择搜索条件',
				name:'sc',
				isdefault : true
			}, {
				display : '用户名',
				name : 'username'
			} ],
			sortname : "registtime",
			sortorder : "desc",
			usepager : true,
			title : '',
			useRp : true,
			rp : 20,
			rpOptions : [ 5, 20, 40, 100 ],
			showTableToggleBtn : true,
			width :'auto',
			height : 'auto',
			pagestat : '显示{from}到{to}条，共{total}条记录',
			procmsg : '正在获取数据，请稍候...',
			checkbox:true
		});
		function action(com, grid){
			if(com=='编辑'){
				if ($('.trSelected', grid).length == 1) {
					var str = $('.trSelected', grid)[0].id.substr(3);
					window.location.href="user.jsp?operate=edit&folder=member&userid="+str;
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}else if(com=='删除'){
				if ($('.trSelected', grid).length > 0) {
					var str="";
					$(".trSelected td:nth-child(1) div", $('#usermanagement')).each(function(i){
						str+=this.innerHTML+"  ";
					});
					$("#contentp").text(str);
					$("#delModal").modal({
						keyboard:true,
						show:true,
					});
					$("#btnok").click(function(){
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("DelUsert.action", {
							"userid" : str
						}, function(data) {
							if (data.sucflag) {
								$("#delModal").modal('hide');
								$('#usermanagement').flexReload();
								forminfo("#alertinfo", "删除系统用户成功");
							}
						});
					});
					$("#btnclose").click(function(){
						$("#delModal").modal('hide');
					});
					return;
				} else {
					formwarning("#alerterror", "请选择要删除的信息");
					return false;
				}
			}else if(com=="添加"){
				window.location.href="user.jsp?operate=add";
				return;
			}else if(com=='激活'){
				if ($('.trSelected', grid).length == 1) {
					var str = $('.trSelected', grid)[0].id.substr(3);
					var userstate="1";
					$.post("updateUserbyuserstate.action",{"userid":str,"userstate":userstate},function(data){
						if(data.sucflag){
							formwarning("#alertinfo", "操作成功");
							return false;			
						}else{
							formwarning("#alerterror", "操作失败");
							return false;
						}
					});
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}else if(com=='设置角色'){
				if ($('.trSelected', grid).length == 1) {
					var str = $('.trSelected', grid)[0].id.substr(3);
					window.location.href="userrole.jsp?operate=edit&folder=user&userid="+str;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}
//			else if(com='查看权限'){
//				//这里要进入权限列表
//				if ($('.trSelected', grid).length == 1) {
//					var str = $('.trSelected', grid)[0].id.substr(3);
//					$.post("findUserRoleMByuserid.action",{"userid":str},function(data){
//						if(data.sucflag){
//							jAlert(data.bean.rolename,"信息提示");
//							return ;				
//						}else{
//							jAlert("操作失败","信息提示");
//							return ;
//						}
//					});
//				} else {
//					formwarning("#alerterror", "请选择一条信息");
//					return false;
//				}
//			}
		}
	}
	
	$("#submit").click(function(){
		saveUser();
	});
	$("#update").click(function(){
		updateUserT();
	});
	
	
  	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		
	}else if(operate=="edit"){
		findUserByUserid();
	}else if(operate=="find"){
		findAllUser();
	}
});
