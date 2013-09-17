$(function() {
	/**
	 * ui
	 */
	$('input').iCheck({
	    checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%' // optional
	});
	 
	/**
	 * 增加用户分组
	 */
	saveMemberT=function(){
		var loginname=$("#loginname").val();
		if(loginname==""){
			formwarning("#alerterror", "用户名必须填写");
			return false;
		}
		var loginpwd=$("#loginpwd").val();
		if(loginpwd==""){
			formwarning("#alerterror", "密码必须填写");
			return false;
		}
		if(loginpwd.length<7||loginpwd.length>16){
			formwarning("#alerterror", "密码长度必须大于等于7位小于16位");
			return false;
		}
		var nick=$("#nick").val();
		var realname=$("#realname").val();
		var city=$("#city").val();
		var district=$("#district").val();
		var sex=$("input[name='sex']:checked").val();
		var whichsex=$("input[name='whichsex']:checked").val();
		var merrystatus=$("input[name='merrystatus']:checked").val();
		var birthday=$("#birthday").val();
		var blood=$("#blood").val();
		var constellation=$("#constellation").val();
		var des=$("#des").val();
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
		//获取个人标签
		var temptag=$("#tag").val();
		var tag="";
		var array=new Array();
		array=temptag.split(",");
		$(array).each(function(k,v){
			tag+="{\"tag\":\""+v+"\"},";
		});
		tag="["+tag.toString().substring(0,tag.length-1)+"]";
		var email=$("#email").val();
		var question=$("#question").val();
		var answer=$("#answer").val();
		var userstate=$("input[name='userstate']:checked").val();
		$.post("saveMemberT.action",{
			"loginname":loginname,
			"loginpwd":loginpwd,
			"nick":nick,
			"realname":realname,
			"city":city,
			"district":district,
			"sex":sex,
			"whichsex":whichsex,
			"merrystatus":merrystatus,
			"birthday":birthday,
			"blood":blood,
			"constellation":constellation,
			"des":des,
			"qq":qq,
			"weixin":weixin,
			"sinaweibo":sinaweibo,
			"headpath":headpath,
			"tag":tag,
			"email":email,
			"question":question,
			"answer":answer,
			"userstate":userstate
		},function(data){
			if(data.sucflag){
				window.location.href="membergroupment.jsp?operate=find&folder=member";
				return;
			}else{
				formwarning("#alerterror", "用户分组增加失败");
				return false;
			}
		});
	},
	
	findMembergroupByid=function(){
		var id=$.query.get("id");
		if(id==""){
			return false;
		}
		$.post("findMemberTById.action",{"id":id},function(data){
			if(data.sucflag){
				$("#hidid").val(data.bean.id);
				$("#loginname").val(data.bean.loginname);
				$("#loginpwd").val(data.bean.loginpwd);
				$("#nick").val(data.bean.nick);
				$("#realname").val(data.bean.realname);
				$("#city").val(data.bean.city);
				$("#district").val(data.bean.district);
				if("1"==data.bean.sex){
					$("input[name='sex']").get(0).checked=true;
				}else{
					$("input[name='sex']").get(1).checked=false;
				}
				if("1"==data.bean.whichsex){
					$("input[name='whichsex']").get(0).checked=true;
				}else{
					$("input[name='whichsex']").get(1).checked=false;
				}
				if("1"==data.bean.merrystatus){
					$("input[name='merrystatus']").get(0).checked=true;
				}else{
					$("input[name='merrystatus']").get(1).checked=false;
				}
				
				$("#birthday").val(data.bean.birthday);
				$("#blood").val(data.bean.blood);
				$("#constellation").val(data.bean.constellation);
				$("#des").val(data.bean.des);
				$("#qq").val(data.bean.qq);
				$("#weixin").val(data.bean.weixin);
				$("#sinaweibo").val(data.bean.sinaweibo);
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
					htm="<img id='"+value+"' src='"+data.basepath+pcpath+"'></img>";
					checkpc="<input id='"+value+"' name='pcpath' type='checkbox' value='"+value+"' checked/>";
					allpcpath=htm+checkpc;
					$('#triggers').append(allpcpath);
				});
				var jsonstr=$.parseJSON(data.bean.tag);
				var tag="";
				if(jsonstr!=null){
					$.each(jsonstr,function(k,v){
						tag+=v+",";
					});
				}
				tag=tag.toString().substring(0, tag.length-1);
				$("#tag").val(tag);
				$("#email").val(data.bean.email);
				$("#question").val(data.bean.question);
				$("#answer").val(data.bean.answer);
				if("1"==data.bean.userstate){
					$("input[name='userstate']").get(0).checked=true;
				}else{
					$("input[name='userstate']").get(1).checked=false;
				}
				$("#submit").hide();
				$("#update").show();
			}
		});
		
	},
	
	updateMembergroup=function(){
		var id=$("#hidid").val();
		var loginname=$("#loginname").val();
		if(loginname==""){
			formwarning("#alerterror", "用户名必须填写");
			return false;
		}
		var loginpwd=$("#loginpwd").val();
		if(loginpwd==""){
			formwarning("#alerterror", "密码必须填写");
			return false;
		}
		if(loginpwd.length<7||loginpwd.length>16){
			formwarning("#alerterror", "密码长度必须大于等于7位小于16位");
			return false;
		}
		var nick=$("#nick").val();
		var realname=$("#realname").val();
		var city=$("#city").val();
		var district=$("#district").val();
		var sex=$("input[name='sex']:checked").val();
		var whichsex=$("input[name='whichsex']:checked").val();
		var merrystatus=$("input[name='merrystatus']:checked").val();
		var birthday=$("#birthday").val();
		var blood=$("#blood").val();
		var constellation=$("#constellation").val();
		var des=$("#des").val();
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
		//获取个人标签
		var temptag=$("#tag").val();
		var tag="";
		var array=new Array();
		array=temptag.split(",");
		$(array).each(function(k,v){
			tag+="{\"tag\":\""+v+"\"},";
		});
		tag="["+tag.toString().substring(0,tag.length-1)+"]";
		var email=$("#email").val();
		var question=$("#question").val();
		var answer=$("#answer").val();
		var userstate=$("input[name='userstate']:checked").val();
		$.post("saveMemberT.action",{
			"id":id,
			"loginname":loginname,
			"loginpwd":loginpwd,
			"nick":nick,
			"realname":realname,
			"city":city,
			"district":district,
			"sex":sex,
			"whichsex":whichsex,
			"merrystatus":merrystatus,
			"birthday":birthday,
			"blood":blood,
			"constellation":constellation,
			"des":des,
			"qq":qq,
			"weixin":weixin,
			"sinaweibo":sinaweibo,
			"headpath":headpath,
			"tag":tag,
			"email":email,
			"question":question,
			"answer":answer,
			"userstate":userstate
		},function(data){
			if(data.sucflag){
				window.location.href="membergroupment.jsp?operate=find&folder=member";
				return;
			}else{
				formwarning("#alerterror", "用户分组更新失败");
				return false;
			}
		});
		
	},
	
	
	$("#submit").click(function(){
		saveMemberT();
	});
	$("#update").click(function(){
		updateMember();
	});
	/**
	 * 获取所有会员列表
	 */
	findAllmembert=function(){
			$("#membermanagement").flexigrid( {
			url : 'findAllMemberT.action',
			dataType : 'json',
			cache : false,
			colModel : [ { 
				display:'用户名',
				name:'loginname',
				width:150,
				sortable:true,
				align:'center'
			},{ 
				display:'昵称',
				name:'nick',
				width:100,
				sortable:true,
				align:'center'
			},{ 
				display:'姓名',
				name:'realname',
				width:100,
				sortable:true,
				align:'center'
			},{ 
				display:'城市',
				name:'city',
				width:100,
				sortable:true,
				align:'center'
			},{ 
				display:'性别',
				name:'sex',
				width:100,
				sortable:true,
				align:'center'
			},{ 
				display:'QQ',
				name:'qq',
				width:100,
				sortable:true,
				align:'center'
			},{ 
				display:'微信',
				name:'weixin',
				width:150,
				sortable:true,
				align:'center'
			},{ 
				display:'新浪微博',
				name:'sinaweibo',
				width:150,
				sortable:true,
				align:'center'
			},{ 
				display:'标签',
				name:'tag',
				width:150,
				sortable:true,
				align:'center'
			},{ 
				display:'创建时间',
				name:'createtime',
				width:200,
				sortable:true,
				align:'center'
			},{ display:'创建者',
				name:'creatorid',
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
				name:'删除',
				bclass:'del',
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
				name : 'loginname'
			} ],
			sortname : "createtime",
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
					window.location.href="member.jsp?operate=edit&folder=member&id="+str;
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}else if(com=='删除'){
				if ($('.trSelected', grid).length > 0) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str += this.id.substr(3) + ",";
					});
					$.post("delMemberT.action",{"id":str},function(data){
						$('#membermanagement').flexReload();
					});
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}else if(com=="添加"){
				window.location.href="member.jsp?operate=add&folder=member";
				return;
			}
		}

	}
	
  	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		
	}else if(operate=="edit"){
		findMemberByid();
	}else if(operate=="find"){
		findAllmembert();
	}
	
	
});

