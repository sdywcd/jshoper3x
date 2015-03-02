/*
 * ===========================================Gorgeous split-line==============================================
 */

$(function(){
	/**
	 *	获取物流商id注入到页面中
	 */
	setLogisticsid=function(){
		// 获取物流商id
		var logisticsid = $.query.get("logisticsid");
		$('#logisticsid').attr("value", logisticsid);
	},
	/**
	 * 根据物流商id获取区域价格信息
	 */
	findLogisticsbusinessareaTById=function(){
		var logbusareaid=$.query.get('logbusareaid');
		if(logbusareaid!=""){
			$.post("findLogisticsbusinessareaTById.action", {
				"logbusareaid" : logbusareaid
			}, function(data) {
				$('#logbusareaid').attr("value", data.beanlist.logbusareaid);
				$('#costway').val(data.beanlist.costway);
				$('#normalcost').attr("value", data.beanlist.normalcost);
				$('#normalvalue').attr("value",data.beanlist.normalvalue);
				$('#overvalue').attr("value", data.beanlist.overvalue);
				$('#overcost').attr("value", data.beanlist.overcost);
				$('#sendarea').attr("value", data.beanlist.sendarea);
				$('#submit').hide();
				$('#update').show();
				return;
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
	if(operate=="add"){
		setLogisticsid();
	}else if(operate=="edit"){
		setLogisticsid();
		findLogisticsbusinessareaTById();
	}
});

/**
 * flexigrid list
 */
$(function() {
	var logisticsid=$.query.get("logisticsid");
	if(logisticsid==""){
		return;
	}
	$("#logisticsareamanagement").flexigrid( {
		url : 'findAllLogisticsbusinessareaT.action?logisticsid='+logisticsid,
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '配送地区',
			name : 'sendarea',
			width : 115,
			sortable : true,
			align : 'center'
		},{
			display : '计算模式',
			name : 'costway',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '标准运费',
			name : 'normalcost',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '标准重量（kg）',
			name : 'normalvalue',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '续费基准',
			name : 'overcost',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '续重基准（kg）',
			name : 'overvalue',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '状态',
			name : 'state',
			width : 115,
			sortable : true,
			align : 'center'
		},{
			display : '操作',
			name : 'operate',
			width : 115,
			sortable : true,
			align : 'center'
		}],
		buttons : [ {
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
			name : '启用区域价格',
			bclass : 'edit',
			onpress : action
		}, {
			name : '禁用区域价格',
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
			display : '配送范围',
			name : 'sendarea'
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
				var logisticsid=$.query.get("logisticsid");
				window.location.href="logisticsarea.jsp?operate=edit&folder=setting&logbusareaid="+str+"&logisticsid="+logisticsid;	
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
				$.post("delLogisticsbusinessarea.action", {
					"logbusareaid" : str
				}, function(data) {
					$('#logisticsareamanagement').flexReload();
					forminfo("#alertinfo","删除区域运费成功");
				});
				return;
			} else {
				forminfo("#alerterror","请选择要删除的信息");
				return false;
			}
		} else if (com == '启用区域价格') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("updateLogisticsbusinessareaBystate.action", {
					"logbusareaid" : str,
					"state" : "1"
				}, function(data) {
					$('#logisticsareamanagement').flexReload();
					forminfo("#alertinfo","启用区域价格成功");
				});
				return;
			} else {
				formwarning("#alerterror","请选择要启用的信息");
				return false;
			}
		} else if (com == '禁用区域价格') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("updateLogisticsbusinessareaBystate.action", {
					"logbusareaid" : str,
					"state" : "0"
				}, function(data) {
					$('#logisticsareamanagement').flexReload();
					forminfo("#alertinfo","禁用区域价格成功");
				});
				return;
			} else {
				formwarning("#alerterror","请选择要禁用的信息");
				return false;
			}

		}else if(com=="添加"){
			var logisticsid=$.query.get("logisticsid");
			window.location.href = "logisticsarea.jsp?operate=add&folder=setting&logisticsid="+logisticsid;
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
		var costway=$("#costway").val();
		var normalcost=$("#normalcost").val();
		if(normalcost==""){
			formwarning("#alerterror","请先输入标准运费");
			return false;
		}
		var normalvalue=$("#normalvalue").val();
		if(normalvalue==""){
			formwarning("#alerterror","请先输入标准重量");
			return false;
		}
		var overcost=$("#overcost").val();
		if(overcost==""){
			formwarning("#alerterror","请先输入续费基准");
			return false;
		}
		var overvalue=$("#overvalue").val();
		if(overvalue==""){
			formwarning("#alerterror","请先输入续重基准");
			return false;
		}
		var sendarea=$("#sendarea").val();
		if(sendarea==""){
			formwarning("#alerterror","请先输入续重基准");
			return false;
		}
		var state=$("#state").val();
		var logisticsid=$.query.get("logisticsid");
		this.value="提交中";
		this.disabled=true;
		$.post("addLogisticsbusinessarea.action",{
			"costway":costway,
			"normalcost":normalcost,
			"normalvalue":normalvalue,
			"overcost":overcost,
			"overvalue":overvalue,
			"sendarea":sendarea,
			"state":state,
			"logisticsid":logisticsid
		},function(data){
			if(data.sucflag){
				window.location.href="logisticsareament.jsp?operate=find&folder=setting&logisticsid="+logisticsid;
			}else{
				formwarning("#alerterror","添加物流商区域价格失败");
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
		var costway=$("#costway").val();
		var normalcost=$("#normalcost").val();
		if(normalcost==""){
			formwarning("#alerterror","请先输入标准运费");
			return false;
		}
		var normalvalue=$("#normalvalue").val();
		if(normalvalue==""){
			formwarning("#alerterror","请先输入标准重量");
			return false;
		}
		var overcost=$("#overcost").val();
		if(overcost==""){
			formwarning("#alerterror","请先输入续费基准");
			return false;
		}
		var overvalue=$("#overvalue").val();
		if(overvalue==""){
			formwarning("#alerterror","请先输入续重基准");
			return false;
		}
		var sendarea=$("#sendarea").val();
		if(sendarea==""){
			formwarning("#alerterror","请先输入续重基准");
			return false;
		}
		var state=$("#state").val();
		var logisticsid=$.query.get("logisticsid");
		var logbusareaid=$("#logbusareaid").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateLogisticsbusinessarea.action",{
			"costway":costway,
			"normalcost":normalcost,
			"normalvalue":normalvalue,
			"overcost":overcost,
			"overvalue":overvalue,
			"sendarea":sendarea,
			"state":state,
			"logisticsid":logisticsid,
			"logbusareaid":logbusareaid
		},function(data){
			if(data.sucflag){
				window.location.href="logisticsareament.jsp?operate=find&folder=setting&logisticsid="+logisticsid;
			}else{
				formwarning("#alerterror","添加物流商区域价格失败");
				return false;
			}
		});
	});
});

