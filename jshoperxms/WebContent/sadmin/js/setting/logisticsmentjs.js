/*
 * ===========================================Gorgeous split-line==============================================
 */
$(function(){
	/**
	 * 根据id获取物流商信息
	 */
	findLogisticsBusinessById=function(){
		var logisticsid=$.query.get('logisticsid');
		if(logisticsid!=""){
			$.post("findLogisticsBusinessById.action", {
				"logisticsid" : logisticsid
			}, function(data) {
				$('#logisticsid').attr("value", data.beanlist.logisticsid);
				$('#logisticsname').attr("value", data.beanlist.logisticsname);
				$('#city').attr("value", data.beanlist.city);
				$('#contractor').attr("value", data.beanlist.contractor);
				$('#telno').attr("value", data.beanlist.telno);
				$('#faxno').attr("value", data.beanlist.faxno);
				$('#email').attr("value", data.beanlist.email);
				$('#address').attr("value", data.beanlist.address);
				$('#receiver').attr("value", data.beanlist.receiver);
				$('#bankaccount').attr("value", data.beanlist.bankaccount);
				$('#bankaddress').attr("value", data.beanlist.bankaddress);
				$('#insure').val(data.beanlist.insure);
				$('#isCod').val(data.beanlist.isCod);
				$('#des').attr("value", data.beanlist.des);
				$('#website').attr("value", data.beanlist.website);
				$('#sendrange').val(data.beanlist.sendrange);
				$('#mobile').attr("value",data.beanlist.mobile);
				$('#submit').hide();
				$('#update').show();
			});
		}
	};
	
});
/*
 * ===========================================Gorgeous split-line==============================================
 */
/**
 * main logic
 */
$(function(){
	var operate=$.query.get('operate');
	if(operate=="edit"){
		findLogisticsBusinessById();
		return;
	}
});
/*
 * ===========================================Gorgeous split-line==============================================
 */
/**
 * flexigrid list
 */
$(function() {
	$("#logisticsmanagement").flexigrid( {
		url : 'findAllLogisticsBusiness.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '物流商名称',
			name : 'logisticsname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '所属城市',
			name : 'city',
			width : 80,
			sortable : true,
			align : 'center'
		}, {
			display : '联系人',
			name : 'contractor',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '座机',
			name : 'telno',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '传真',
			name : 'faxno',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '邮箱',
			name : 'email',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '地址',
			name : 'address',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '收款人',
			name : 'receiver',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '银行账号',
			name : 'bankaccount',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '所属银行',
			name : 'bankaddress',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '是否支持保价',
			name : 'insure',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '是否支持货到付款',
			name : 'iscod',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '是否默认显示',
			name : 'visible',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '描述',
			name : 'des',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '使用状态',
			name : 'state',
			width : 100,
			sortable : true,
			align : 'center'

		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'

		}, {
			display : '创建者编号',
			name : 'creatorid',
			width : 200,
			sortable : true,
			align : 'center'

		}, {
			display : '网址',
			name : 'website',
			width : 100,
			sortable : true,
			align : 'center'
		} ,{
			display : '范围',
			name : 'range',
			width : 100,
			sortable : true,
			align : 'center'
		} ,{
			display : '手机',
			name : 'mobile',
			width : 100,
			sortable : true,
			align : 'center'
		} ,{
			display : '操作',
			name : 'operating',
			width : 110,
			sortable : true,
			align : 'center'
		}],
		buttons : [{
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name : '编辑',
			bclass : 'edit',
			onpress : action
		}, {
			name : '删除',
			bclass : 'del',
			onpress : action
		}, {
			name : '设置配送区域及运费',
			bclass : 'edit',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '物流商名称',
			name : 'logisticsname'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox : true
	});
	function action(com, grid) {
		if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href="logistics.jsp?operate=edit&folder=setting&logisticsid="+str;
				return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		} else if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("delLogisticsBusiness.action", {
					"logisticsid" : str
				}, function(data) {
					$('#logisticsmanagement').flexReload();
					forminfo("#alertinfo","删除物流商成功");
				});
				return;
			} else {
				forminfo("#alerterror","请选择要删除的信息");
				return false;
			}
		} else if (com == '设置配送区域及运费') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "logisticsareament.jsp?operate=find&folder=setting&logisticsid=" + str;
				return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}else if(com=="添加"){
			window.location.href = "logistics.jsp?operate=add&folder=setting";
			return;
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
		var logisticsname = $('#logisticsname').val();
		if(logisticsname==""){
			formwarning("#alerterror","请先输入物流商名称");
			return false;
		}
		var city = $('#city').val();
		if(city==""){
			formwarning("#alerterror","请先输入城市");
			return false;
		}
		var contractor = $('#contractor').val();
		if(contractor==""){
			formwarning("#alerterror","请先输入联系人");
			return false;
		}
		var telno = $('#telno').val();
		if(telno==""){
			formwarning("#alerterror","请先输入座机");
			return false;
		}
		var mobile=$("#mobile").val();
		if(mobile==""){
			formwarning("#alerterror","请先输入手机");
			return false;
		}
		var faxno = $('#faxno').val();
		var email = $('#email').val();
		if(email==""){
			formwarning("#alerterror","请先输入邮箱");
			return false;
		}
		var address = $('#address').val();
		if(address==""){
			formwarning("#alerterror","请先输入地址");
			return false;
		}
		var website = $('#website').val();
		var receiver = $('#receiver').val();
		if(receiver==""){
			formwarning("#alerterror","请先输入收款人");
			return false;
		}
		var bankaccount = $('#bankaccount').val();
		if(bankaccount==""){
			formwarning("#alerterror","请先输入银行账号");
			return false;
		}
		var bankaddress = $('#bankaddress').val();
		if(bankaddress==""){
			formwarning("#alerterror","请先输入所属银行");
			return false;
		}
		var insure = $('#insure').val();
		var isCod = $('#isCod').val();
		var state = $('#state').val();
		var visible = $('#visible').val();
		var des = $('#des').val();
		var sendrange=$("#sendrange").val();
		this.value="提交中";
		this.disabled=true;
		$.post("addLogisticsBusiness.action",{
			"logisticsname" : logisticsname,
			"city" : city,
			"contractor" : contractor,
			"telno" : telno,
			"faxno" : faxno,
			"mobile":mobile,
			"email" : email,
			"address" : address,
			"receiver" : receiver,
			"bankaccount" : bankaccount,
			"bankaddress" : bankaddress,
			"insure" : insure,
			"isCod" : isCod,
			"state" : state,
			"visible" : visible,
			"des" : des,
			"website" : website,
			"sendrange":sendrange
		}, function(data) {
			if(data.sucflag){
				window.location.href="logisticsment.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","添加物流商失败");
				return false;
			}
		});
	});
});
$(function() {
	// 点击编辑更新内容
	$("#update").click(function() {
		var logisticsid = $("#logisticsid").val();
		var logisticsname = $('#logisticsname').val();
		if(logisticsname==""){
			formwarning("#alerterror","请先输入物流商名称");
			return false;
		}
		var city = $('#city').val();
		if(city==""){
			formwarning("#alerterror","请先输入城市");
			return false;
		}
		var contractor = $('#contractor').val();
		if(contractor==""){
			formwarning("#alerterror","请先输入联系人");
			return false;
		}
		var telno = $('#telno').val();
		if(telno==""){
			formwarning("#alerterror","请先输入座机");
			return false;
		}
		var mobile=$("#mobile").val();
		if(mobile==""){
			formwarning("#alerterror","请先输入手机");
			return false;
		}
		var faxno = $('#faxno').val();
		var email = $('#email').val();
		if(email==""){
			formwarning("#alerterror","请先输入邮箱");
			return false;
		}
		var address = $('#address').val();
		if(address==""){
			formwarning("#alerterror","请先输入地址");
			return false;
		}
		var website = $('#website').val();
		var receiver = $('#receiver').val();
		if(receiver==""){
			formwarning("#alerterror","请先输入收款人");
			return false;
		}
		var bankaccount = $('#bankaccount').val();
		if(bankaccount==""){
			formwarning("#alerterror","请先输入银行账号");
			return false;
		}
		var bankaddress = $('#bankaddress').val();
		if(bankaddress==""){
			formwarning("#alerterror","请先输入所属银行");
			return false;
		}
		var insure = $('#insure').val();
		var isCod = $('#isCod').val();
		var state = $('#state').val();
		var visible = $('#visible').val();
		var des = $('#des').val();
		var sendrange=$("#sendrange").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateLogisticsBusiness.action", {
			"logisticsid" : logisticsid,
			"logisticsname" : logisticsname,
			"city" : city,
			"contractor" : contractor,
			"telno" : telno,
			"mobile":mobile,
			"faxno" : faxno,
			"email" : email,
			"address" : address,
			"receiver" : receiver,
			"bankaccount" : bankaccount,
			"bankaddress" : bankaddress,
			"insure" : insure,
			"isCod" : isCod,
			"state" : state,
			"visible" : visible,
			"des" : des,
			"website" : website,
			"sendrange":sendrange
		}, function(data) {
			if(data.sucflag){
				window.location.href="logisticsment.jsp?operate=find&folder=setting&logisticsid="+logisticsid;
			}else{
				formwarning("#alerterror","更新物流商失败");
				return false;
			}
		});
	});
});

