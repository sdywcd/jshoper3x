
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Required to initialize the page data
 */
$(function(){
	findPaymentbyId=function(){
		var paymentid=$.query.get("paymentid");
		if(paymentid!=""){
			$.post("findPaymentbyId.action",{
				"paymentid":paymentid
			},function(data){
				$("#paymentname").attr("value",data.bean.paymentname);
				$("#paymentCode").attr("value",data.bean.paymentCode);
				$("#paymentFree").attr("value",data.bean.paymentFree);
				$("#paymentInterface").val(data.bean.paymentInterface);
				$("#account").attr("value",data.bean.account);
				$("#safecode").attr("value",data.bean.safecode);
				$("#partnerid").attr("value",data.bean.partnerid);
				$("#isFast").val(data.bean.isFast);
				$("#des").attr("value",data.bean.des);
				$("#state").val(data.bean.state);
				$("#paymentid").attr("value",data.bean.paymentid);
				$("#submit").hide();
				$("#update").show();
			});
		};
	}
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * main logic
 */
$(function(){
	var operate=$.query.get("operate");
	if(operate=="edit"){
		findPaymentbyId();
	}
});

/*
 * ===========================================Gorgeous split-line==============================================
 */
/**
 * flexigrid list 
 */
$(function() {
	$("#paymentmanagement").flexigrid( {
		url : 'findAllPayment.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'店铺名',
			name:'shopname',
			width:200,
			sortable:true,
			align:'center'
		},{ 
			display:'支付方式名称',
			name:'paymentname',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'支付方式代码',
			name:'paymentCode',
			width:150,
			sortable:true,
			align:'center'
		}, { 
			display:'手续费',
			name:'paymentFree',
			width:150,
			sortable:true,
			align:'center'
		},{ 
			display:'接口类型',
			name:'paymentInterface',
			width:115,
			sortable:true,
			align:'center'
		},{
			display : '描述',
			name : 'des',
			width : 100,
			sortable : true,
			align : 'center'
		},{ 
			display:'快捷支付',
			name:'isFast',
			width:100,
			sortable:true,
			align:'center'
		},{ 
			display:'状态',
			name:'state',
			width:100,
			sortable:true,
			align:'center'
		}],
		buttons : [{
			name : '添加',
			bclass : 'add',
			onpress : action
		},{
			name : '编辑',
			bclass : 'add',
			onpress : action
		},{
			name : '开启',
			bclass : 'add',
			onpress : action
		},{
			name : '禁用',
			bclass : 'del',
			onpress : action
		},{
			name : '删除',
			bclass : 'del',
			onpress : action
		},{
			separator : true
		} ],

		searchitems : [ {
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		}],
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
	function action(com, grid) {
		if(com=='开启'){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				$.post("openPayment.action",{"paymentid":str},function(data){
					$('#paymentmanagement').flexReload();
					forminfo("#alertinfo","开启支付方式成功");
				});
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}else if(com=='禁用'){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				$.post("closePayment.action",{"paymentid":str},function(data){
					$('#paymentmanagement').flexReload();
					forminfo("#alertinfo","禁用支付方式成功");
				});
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}else if(com=="添加"){
			window.location.href = "payment.jsp?operate=add&folder=setting";
			return;
		}else if(com=="编辑"){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "payment.jsp?operate=edit&folder=setting&paymentid="+str;
				return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}else if(com=="删除"){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				$.post("delPaymentByid.action",{"paymentid":str},function(data){
					$('#paymentmanagement').flexReload();
					forminfo("#alertinfo","删除支付方式成功");
				});
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}
	}
});
/*
 * ===========================================Gorgeous split-line==============================================
 */
/**
 * Add Function
 */
$(function(){
	$("#submit").click(function(){
		var paymentname=$("#paymentname").val();
		if(paymentname==""){
			formwarning("#alerterror","请先输入支付方式名称");
			return false;
		}
		var paymentCode=$("#paymentCode").val();
		if(paymentCode==""){
			formwarning("#alerterror","请先输入支付方式代码");
			return false;
		}
		var paymentFree=$("#paymentFree").val();
		if(paymentFree==""){
			formwarning("#alerterror","请先输入支付费率");
			return false;
		}
		var paymentInterface=$("#paymentInterface").val();
		var account=$("#account").val();
		if(account==""){
			formwarning("#alerterror","请先输入账号");
			return false;
		}
		var safecode=$("#safecode").val();
		if(safecode==""){
			formwarning("#alerterror","请先输入安全效验码");
			return false;
		}
		var partnerid=$("#partnerid").val();
		if(partnerid==""){
			formwarning("#alerterror","请先输入合作者身份ID");
			return false;
		}
		var isFast=$("#isFast").val();
		var des=$("#des").val();
		var state=$("#state").val();
		this.value="提交中";
		this.disabled=true;
		$.post("addPayment.action",{
			"paymentname":paymentname,
			"paymentCode":paymentCode,
			"paymentFree":paymentFree,
			"paymentInterface":paymentInterface,
			"account":account,
			"safecode":safecode,
			"partnerid":partnerid,
			"isFast":isFast,
			"des":des,
			"state":state
		},function(data){
			if(data.sucflag){
				window.location.href="paymentment.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","添加支付方式信息失败");
				return false;
			}
		});
		
	});
});
/*
 * ===========================================Gorgeous split-line==============================================
 */
/**
 * Update Function
 */
$(function(){
	$("#update").click(function(){
		var paymentname=$("#paymentname").val();
		if(paymentname==""){
			formwarning("#alerterror","请先输入支付方式名称");
			return false;
		}
		var paymentCode=$("#paymentCode").val();
		if(paymentCode==""){
			formwarning("#alerterror","请先输入支付方式代码");
			return false;
		}
		var paymentFree=$("#paymentFree").val();
		if(paymentFree==""){
			formwarning("#alerterror","请先输入支付费率");
			return false;
		}
		var paymentInterface=$("#paymentInterface").val();
		var account=$("#account").val();
		if(account==""){
			formwarning("#alerterror","请先输入账号");
			return false;
		}
		var safecode=$("#safecode").val();
		if(safecode==""){
			formwarning("#alerterror","请先输入安全效验码");
			return false;
		}
		var partnerid=$("#partnerid").val();
		if(partnerid==""){
			formwarning("#alerterror","请先输入合作者身份ID");
			return false;
		}
		var paymentid=$("#paymentid").val();
		var isFast=$("#isFast").val();
		var des=$("#des").val();
		var state=$("#state").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updatePayment.action",{
			"paymentname":paymentname,
			"paymentCode":paymentCode,
			"paymentFree":paymentFree,
			"paymentInterface":paymentInterface,
			"account":account,
			"safecode":safecode,
			"partnerid":partnerid,
			"isFast":isFast,
			"des":des,
			"state":state,
			"paymentid":paymentid
		},function(data){
			if(data.sucflag){
				window.location.href="paymentment.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","添加支付方式信息失败");
				return false;
			}
		});
		
	});
});