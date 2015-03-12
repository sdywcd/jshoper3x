
$(function() {
	 
	/**
	 * 充值
	 */
	saveMemberRechargeRecordsT=function(){
		var balance=$("#balance").val();
		if(balance==""){
			formwarning("#alerterror", "请输入金额");
			return false;
		}
		var memberid=$("#hidmemberid").val();
		if(memberid==""){
			formwarning("#alerterror", "请选择会员");
			return false;
		}
		var membername=$("#membername").val();
		if(membername==""){
			formwarning("#alerterror", "请选择会员");
			return false;
		}
		var operatetype=$("input[name='operatetype']:checked").val();
		$.post("saveMemberRechargeRecordsT.action",{
			"memberid":memberid,
			"balance":balance,
			"operatetype":operatetype,
			"membername":membername
		},function(data){
			if(data.sucflag){
				window.location.href="memberrechargement.jsp?operate=find&folder=member";
				return;
			}
		});
	},
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
				display:'手机',
				name:'mobile',
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
				display:'状态',
				name:'memberstate',
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
				name : '选择该会员进行充值',
				bclass : 'add',
				onpress : action
			}, {
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
			if(com=="选择该会员进行充值"){
				if ($('.trSelected', grid).length==1) {
					$(".trSelected td:nth-child(2) div", $('#membermanagement')).each(function(i){
						$("#membername").val(this.innerHTML);
					});
					var str = "";
					$('.trSelected', grid).each(function() {
						str = this.id.substr(3);
					});
					$("#hidmemberid").val(str);
				}else{
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
				
			}
		}

	},
	/**
	 * 查询会员
	 */
	findMember=function(){
		//查询所有会员
		findAllmembert();
	}
	$("#submit").click(function(){
		saveMemberRechargeRecordsT();
	});
	
	/**
	 * 查询
	 */
	$("#search").click(function(){
		findMember();
	});
	
	/**
	 * 获取所有会员列表
	 */
	findAllMemberRechargeT=function(){
			$("#memberrechargement").flexigrid( {
			url : 'findAllMemberRechargeT.action',
			dataType : 'json',
			cache : false,
			colModel : [ { 
				display:'会员账号',
				name:'membername',
				width:250,
				sortable:true,
				align:'center'
			},{ 
				display:'账户余额',
				name:'balance',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'创建时间',
				name:'createtime',
				width:200,
				sortable:true,
				align:'center'
			},{
				display:'上次充值时间',
				name:'updatetime',
				width:200,
				sortable:true,
				align:'center'
			}],
			buttons : [ {
				name : '充值',
				bclass : 'add',
				onpress : action
			},{
				separator : true
			} ],
	
			searchitems : [{
				display:'请选择搜索条件',
				name:'sc',
				isdefault : true
			}, {
				display : '账户名称',
				name : 'membername'
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
			if(com=="充值"){
				if ($('.trSelected', grid).length == 1) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str = this.id.substr(3);
					});
					var membername="";
					$(".trSelected td:nth-child(2) div", $('#memberrechargement')).each(function(i){
						membername=this.innerHTML;
					});
					window.location.href="memberrecharge.jsp?operate=add&memberid="+str+"&membername="+membername+"&folder=member";
				}else{
					window.location.href="memberrecharge.jsp?operate=add&folder=member";
					return;
				}
				
			}
		}

	}
	
  	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		var membername=$.query.get("membername");
		var memberid=$.query.get("memberid");
		if(membername!==""&&memberid!==""){
			$("#hidmemberid").val(memberid);
			$("#membername").val(membername);
		}
	}else if(operate=="edit"){
		
	}else if(operate=="find"){
		findAllMemberRechargeT();
	}
	
	
});

