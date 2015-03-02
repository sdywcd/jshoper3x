
/**
 * Global variables
 */
var session="true";
/*===========================================Gorgeous split-line==============================================*/
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
	$("#h-menu-order").addClass("selected");
	$("#menu-order").removeClass("closed"); 
	$("#menu-order").addClass("opened");
});
/*===========================================Gorgeous split-line==============================================*/

/**
 * flexigrid list 
 */
$(function() {
	$("#orderinvoicemanagement").flexigrid( {
		url : 'findAllOrderIvoice.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '订单编号',
			name : 'orderid',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '发票类型',
			name : 'invType',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '发票抬头',
			name : 'invPayee',
			width : 300,
			sortable : true,
			align : 'center'
		}, {
			display : '发票内容',
			name : 'invContent',
			width : 300,
			sortable : true,
			align : 'center'
		}, {
			display : '总金额',
			name : 'amount',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '是否已开票',
			name : 'state',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '开票会员',
			name : 'username',
			width : 150,
			sortable : true,
			align : 'center'
		}, {
			display : '提交开票时间',
			name : 'createtime',
			width : 200,
			sortable : true,
			align : 'center'
		} ],
		buttons : [ {
			name : '删除',
			bclass : 'delete',
			onpress : action
		}, {
			name : '标记已开票',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记未开票',
			bclass : 'add',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '订单编号',
			name : 'orderid'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '需开票订单列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});

	function action(com, grid) {
		if (com == '删除') {
			if($('.trSelected',grid).length>0){
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str="";
						$('.trSelected',grid).each(function(){
							str+=this.id.substr(3)+",";
						});
						$.post("DelOrderInvoice.action", {
							"orderInvoiceid" : str
						}, function(data) {
							$('#orderinvoicemanagement').flexReload();
						});
					}
				});
				return;
			}else{
				jAlert('请选择要删除的信息!','信息提示');
				return false;
			}
		} else if (com == '标记已开票') {
			if($('.trSelected',grid).length>0){
				jConfirm('确定更新此项吗?', '信息提示', function(r) {
					if (r) {
						var str="";
						$('.trSelected',grid).each(function(){
							str+=this.id.substr(3)+",";
						});
						$.post("UpdateOrderInvoiceState.action", {
							"orderInvoiceid" : str,
							"state" : "1"
						}, function(data) {
							$('#orderinvoicemanagement').flexReload();
						});
					}
				});
				return;
			}else{
				jAlert('请选择要更新的信息!','信息提示');
				return false;
			}
		} else if (com == '标记未开票') {
			if($('.trSelected',grid).length>0){
				jConfirm('确定更新此项吗?', '信息提示', function(r) {
					if (r) {
						var str="";
						$('.trSelected',grid).each(function(){
							str+=this.id.substr(3)+",";
						});
						$.post("UpdateOrderInvoiceState.action", {
							"orderInvoiceid" : str,
							"state" : "0"
						}, function(data) {
							$('#orderinvoicemanagement').flexReload();
						});
					}
				});
				return;
			}else{
				jAlert('请选择要更新的信息!','信息提示');
				return false;
			}
		}

	}

});
/*===========================================Gorgeous split-line==============================================*/

