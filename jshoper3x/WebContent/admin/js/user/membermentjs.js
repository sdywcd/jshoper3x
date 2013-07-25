
/**
 * Global variables
 */
var session="true";
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * ui
 */
$(function(){

	$("h6").each(function(){
		$(this).removeClass("selected"); 
	});
	$("ul").each(function(){
		$(this).removeClass("opened"); 
		$(this).addClass("closed"); 
	});
	$("#h-menu-member").addClass("selected");
	$("#menu-member").removeClass("closed"); 
	$("#menu-member").addClass("opened");
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Required to initialize the page data
 */
$(function(){
	/**
	 * 获取模块下拉列表
	 */
	var userid=$.query.get('userid');
	if(userid==""){
		return false;
	}
	$.post("findAllRoleForSelect.action", function(data) {
		if (data.sucflag) {
			$('#roleid').append(data.rolestr);	
		}
	});

});
$(function(){
 //获取用户等级信息
    $.post("findAllGradeForselect.action",function(data){
        if(data.sucflag){
            var temp="<option value='0'>---请选择---</option>";
            $.each(data.beanlist,function(i,v){
                temp+="<option value='"+v.gradeid+"'>"+v.gradename+"</option>";
            });
            $("#grade").html(temp);
        }else{
            jAlert('你还没有录入用户等级相关信息','信息提示');
        }
    });

});
/*===========================================Gorgeous split-line==============================================*/



/**
 * flexigrid list
 */
$(function() {
	$("#membermanagement").flexigrid( {
		url : 'findAllUsert.action',
		dataType : 'json',
		cache : false,
		colModel : [ { 
			display:'用户名',
			name:'username',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'真名',
			name:'realname',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'邮箱',
			name:'email',
			width:315,
			sortable:true,
			align:'center'
		},{ 
			display:'性别',
			name:'sex',
			width:80,
			sortable:true,
			align:'center'
		},{ 
			display:'累计积分',
			name:'points',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'QQ1',
			name:'qq',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'MSN1',
			name:'msn',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'会员等级',
			name:'gradename',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'会员操作状态',
			name:'userstate',
			width:215,
			sortable:true,
			align:'center'
		},{
			display : '成为会员时间',
			name : 'gradetime',
			width : 214,
			sortable : true,
			align : 'center'
				
		},{ display:'注册时间',
			name:'registtime',
			width:200,
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
			name : '修改管理员密码',
			bclass : 'edit',
			onpress : action
		},{
			name:'删除',
			bclass:'delete',
			onpress:action
		},{
			name:'发送激活邮件',
			bclass:'add',
			onpress:action
		},{
			name:'禁止登录',
			bclass:'edit',
			onpress:action
		},{
			name:'禁止发帖',
			bclass:'edit',
			onpress:action
		},{
			name:'激活',
			bclass:'edit',
			onpress:action
		},{
			name:'设置权限',
			bclass:'edit',
			onpress:action
		},{
			name:'查看权限',
			bclass:'edit',
			onpress:action
		},{
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
		sortname : "gradetime",
		sortorder : "desc",
		usepager : true,
		title : '会员列表',
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
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href="addmember.jsp?session="+session+"#member&userid="+str+"";
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=='删除'){
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("DelUsert.action",{"userid":str},function(data){
							$('#membermanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		}else if(com=="添加"){
			window.location.href="addmember.jsp?session="+session;
			return;
		}else if(com=="修改管理员密码"){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("findUserById.action",{"userid":str},function(data){
							if(data.beanlist.state!=3 && data.beanlist.state!=2){
								jAlert('这不是管理员和超级管理员，不能修改','信息提示');
								return false;
							}else{
								window.location.href="editmember.jsp?session="+session+"#member&userid="+str+"";
							}
						});		
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=="发送激活邮件"){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("sendeMail.action",{"userid":str},function(data){
							if(data.slogin==false){
								jAlert('此用户已激活，不能重复激活','信息提示');
								return false;
							}else{
								jAlert('恭喜！邮件已发送','信息提示');
								window.location.href="membermanagement.jsp?session="+session+"#settings";
							}
						});	
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=='禁止登录'){
				if ($('.trSelected', grid).length == 1) {
					jConfirm('确定编辑此项吗?', '信息提示', function(r) {
						if (r) {
							var str = $('.trSelected', grid)[0].id.substr(3);
							var userstate="2";
							$.post("updateUserbyuserstate.action",{"userid":str,"userstate":userstate},function(data){
								if(data.sucflag){
									jAlert("操作成功","信息提示");
									return ;
								}else {
									jAlert("操作失败","信息提示");
									return ;
								}
							});
						}
					});
				} else {
					jAlert('请选择一条信息', '信息提示');
					return false;
				}
		}else if(com=='禁止发帖'){
				if ($('.trSelected', grid).length == 1) {
					jConfirm('确定编辑此项吗?', '信息提示', function(r) {
						if (r) {
							var str = $('.trSelected', grid)[0].id.substr(3);
							var userstate="3";
							$.post("updateUserbyuserstate.action",{"userid":str,"userstate":userstate},function(data){
								if(data.sucflag){
									jAlert("操作成功","信息提示");
									return ;				
								}else{
									jAlert("操作失败","信息提示");
									return ;
								}
							});
						}
					});
				} else {
					jAlert('请选择一条信息', '信息提示');
					return false;
				}
		}else if(com=='激活'){
				if ($('.trSelected', grid).length == 1) {
					jConfirm('确定编辑此项吗?', '信息提示', function(r) {
						if (r) {
							var str = $('.trSelected', grid)[0].id.substr(3);
							var userstate="1";
							$.post("updateUserbyuserstate.action",{"userid":str,"userstate":userstate},function(data){
								if(data.sucflag){
									jAlert("操作成功","信息提示");
									return ;				
								}else{
									jAlert("操作失败","信息提示");
									return ;
								}
							});
						}
					});
				} else {
					jAlert('请选择一条信息', '信息提示');
					return false;
				}
		}else if(com=='设置权限'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href="adduserrole.jsp?session="+session+"#member&userid="+str+"";
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com='查看权限'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定查看此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("findUserRoleMByuserid.action",{"userid":str},function(data){
							if(data.sucflag){
								jAlert(data.bean.rolename,"信息提示");
								return ;				
							}else{
								jAlert("操作失败","信息提示");
								return ;
							}
						});
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}
	}
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Add Function
 */
$(function(){
	
	$("#submitrole").click(function(){
		var roleid=$("#roleid").val();
		if(roleid=="0"){
			jAlert("请选择角色","提示信息");
			return false;
		}
        var rolemname=$('#roleid').find("option:selected").text();
		var userid=$.query.get('userid');
		if(userid==""){
			return false;
		}
		$.post("addUserRoleM.action",{"userid":userid,"roleid":roleid},function(data){
			if(data.sucflag){
                $.post("updateUserRoleMByuserid.action",{"userid":userid,"roleid":roleid,"rolemname":rolemname},function(data){
                    if(data.sucflag){
                        jAlert("角色设置成功","信息提示");
                        return;
                    }         
                });
				
			}
		});
	});
    
    /**
     * 点击增加用户
     */
    $("#submit").click(function(){
        var username=$("#username").val();
        var email=$("#email").val();
        var points=$("#points").val();
        var grade=$("#grade").val();
        var gradename=$('#grade').find("option:selected").text();
        var state=$("#state").val();
        var userstate=$("#userstate").val();
        if("0"==grade){
            jAlert('会员等级必须选择','信息提示');
            return false;
        }
        if("0"==state){
            jAlert('用户类型必须选择','信息提示');
            return false;
        }
        var regnotascii = /^[\x00-\xff]$/g ;  //两个字节的字符
        var regunexpect = /[^a-zA-Z0-9\u4e00-\u9fa5_]/g; //中文英文数字都下划线ok
        var regemail = /\w+([-]?\w)*@([-]?\w)*[\.]?[\w]{2,3}([\.]?[\w]{2,3})?/; //匹配伊妹儿地址
        var regpoints = /^[1-9][\d]{1,8}\.[\d]{1,2}|(^0\.)[\d]{1,2}/;//匹配积分10位,两位小数
        if(username){
        	if(username.match(regunexpect)){
        		jAlert('用户名可以以"中文英文数字下划线的组合"','信息提示');
        		return false;
        	}
        	var unamelength = 0;
        	for(var i=0;i<username.length;i++)
        		{
        			var curcode = username.substring(i,1); 
        			if(regnotascii.test(curcode)) 
        				{
        					unamelength += 2;
        				}
        			else{
        					unamelength++;
        			}
        		}
        	if(unamelength > 50){
        		jAlert('字符串不能大于50','信息提示');
        		return false;
        	}
        }else{
        	jAlert('用户名字不能为空','信息提示');
        	return false;
        }
        if(email){       	
        	if(!regemail.test(email)){
        		jAlert('不是标准的email格式','信息提示');
        		return false;
        	}
        }else{
        	jAlert('email地址不能为空','信息提示');
        	return false;
        }
        if(!regpoints.test(points)){
        	jAlert('积分是10位,两位小数','信息提示');
        	return false;
        } 
        
        $.post("adminregister.action",{"username":username,"email":email,"points":points,"grade":grade,"gradename":gradename,"state":state,"userstate":userstate},function(data){
            if(data.msg=="4"){
                jAlert("用户已经存在","信息提示");
                return false;
            }
            if(data.msg=="5"){
                jAlert("邮箱已经存在","信息提示");
                return false;
            }
            if(data.sucflag){
                jAlert("用户添加成功","信息提示");
                window.location.href="membermanagement.jsp?session="+session+"#member";
            }else{
                jAlert("用户添加失败","信息提示");
                return false;
            }
            
        });
    });
    
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Update Function
 */
$(function(){
	
//	var msg=$.query.get("msg");
//	if(msg!=""){
//		switch(msg){
//			case 4:
//				jAlert("用户已经存在","信息提示");
//				break;
//		}
//	}
	$("#editmember").click(function(){
		var username=$('#username').val();
		var newpassword=$('#newpassword').val();
		var password=$('#password').val();
		if(newpassword==""){
			JAlert("请输入新密码","信息提示");
			return false;
		}
		if(password==""){
			JAlert("请输入原始密码","信息提示");
			return false;
		}
        var regnotascii = /^[\x00-\xff]$/g ;  //两个字节的字符
        var regunexpect = /[^a-zA-Z0-9\u4e00-\u9fa5_]/g; //中文英文数字都下划线ok
        var regemail = /\w+([-]?\w)*@([-]?\w)*[\.]?[\w]{2,3}([\.]?[\w]{2,3})?/; //匹配伊妹儿地址
        var regpoints = /^[1-9][\d]{1,8}\.[\d]{1,2}|(^0\.)[\d]{1,2}/;//匹配积分10位,两位小数
        if(username){
        	if(username.match(regunexpect)){
        		jAlert('用户名可以以"中文英文数字下划线的组合"','信息提示');
        		return false;
        	}
        	var unamelength = 0;
        	for(var i=0;i<username.length;i++)
        		{
        			var curcode = username.substring(i,1); 
        			if(regnotascii.test(curcode)) 
        				{
        					unamelength += 2;
        				}
        			else{
        					unamelength++;
        			}
        		}
        	if(unamelength > 50){
        		jAlert('字符串不能大于50','信息提示');
        		return false;
        	}
        }else{
        	jAlert('用户名字不能为空','信息提示');
        	return false;
        }
        if(email){       	
        	if(!regemail.test(email)){
        		jAlert('不是标准的email格式','信息提示');
        		return false;
        	}
        }else{
        	jAlert('email地址不能为空','信息提示');
        	return false;
        }
        if(!regpoints.test(points)){
        	jAlert('积分是10位,两位小数','信息提示');
        	return false;
        } 
		$.post("UpdateUserMember.action",{"username":username,"password":password,"newpassword":newpassword},function(data){
			
			window.location.href="membermanagement.jsp?session="+session+"#member";
		});
	});
	
	
	$("#editadminregister").click(function(){
		var userid=$('#hiduserid').val();
		var username=$('#username').val();
		var points=$('#points').val();
		var grade=$('#grade').val();
        var gradename=$('#grade').find("option:selected").text();
		var state=$('#state').val();
		var userstate=$('#userstate').val();
		var email=$('#email').val();
        var regnotascii = /^[\x00-\xff]$/g ;  //两个字节的字符
        var regunexpect = /[^a-zA-Z0-9\u4e00-\u9fa5_]/g; //中文英文数字都下划线ok
        var regemail = /\w+([-]?\w)*@([-]?\w)*[\.]?[\w]{2,3}([\.]?[\w]{2,3})?/; //匹配伊妹儿地址
        var regpoints = /^[1-9][\d]{1,8}\.[\d]{1,2}|(^0\.)[\d]{1,2}/;//匹配积分10位,两位小数
        if(username){
        	if(username.match(regunexpect)){
        		jAlert('用户名可以以"中文英文数字下划线的组合"','信息提示');
        		return false;
        	}
        	var unamelength = 0;
        	for(var i=0;i<username.length;i++)
        		{
        			var curcode = username.substring(i,1); 
        			if(regnotascii.test(curcode)) 
        				{
        					unamelength += 2;
        				}
        			else{
        					unamelength++;
        			}
        		}
        	if(unamelength > 50){
        		jAlert('字符串不能大于50','信息提示');
        		return false;
        	}
        }else{
        	jAlert('用户名字不能为空','信息提示');
        	return false;
        }
        if(email){       	
        	if(!regemail.test(email)){
        		jAlert('不是标准的email格式','信息提示');
        		return false;
        	}
        }else{
        	jAlert('email地址不能为空','信息提示');
        	return false;
        }
        if(!regpoints.test(points)){
        	jAlert('积分是10位,两位小数','信息提示');
        	return false;
        } 
		$.post("UpdateUserTunpwd.action",{"userid":userid,"username":username,"email":email,"points":points,"grade":grade,"gradename":gradename,"userstate":userstate,"state":state},function(data){
			if(data.sucflag){
               window.location.href="membermanagement.jsp?session="+session+"#member";
            }
		});
		
	});

	var userid=$.query.get('userid');
	if(userid==""){
		return false;
	}else{
		$.post("findUserById.action",{"userid":userid},function(data){
			$('#username').attr("value",data.beanlist.username);
			$('#realname').attr("value",data.beanlist.realname);
			$('#email').attr("value",data.beanlist.email);
			$('#points').attr("value",data.beanlist.points);
			$('#grade').val(data.beanlist.grade);
			$('#state').val(data.beanlist.state);
			$('#userstate').val(data.beanlist.userstate);
			$('#hiduserid').attr("value",data.beanlist.userid);
			$('#submit').hide();
			$('#editadminregister').show();	
			
			return;
		});
	}
	
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
