
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

	$("#tobeshippedordersmanagement").flexigrid( {
		url : 'findAllTobeShippedOrders.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'订单编号',
			name:'orderid',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'订单名称',
			name:'goodsname',
			width:300,
			sortable:true,
			align:'center'
		},{
			display:'总金额',
			name:'amount',
			width:80,
			sortable:true,
			align:'center'
		},{
			display:'总件数',
			name:'needquantity',
			width:50,
			sortable:true,
			align:'center'
		},{
			display:'订单所属人',
			name:'username',
			width:200,
			sortable:true,
			align:'center'
		},{
			display:'收货人',
			name:'shippingusername',
			width:200,
			sortable:true,
			align:'center'
		},{
			display:'支付方式',
			name:'paymentname',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'配送方式',
			name:'delivermode',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'订单状态',
			name:'orderstate',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'支付状态',
			name:'paystate',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'发货状态',
			name:'shippingstate',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'下单时间',
			name:'purchasetime',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'发货时间',
			name:'deliverytime',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'开票',
			name:'invoice',
			width:100,
			sortable:true,
			align:'center'		
		},{
			display:'订单来源',
			name:'orderTag',
			width:100,
			sortable:true,
			align:'center'
		}],
		buttons : [{
			separator : true
		} ],

		searchitems : [{
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		},{
			display:'订单编号',
			name:'orderid'
		},{
			display:'收件人',
			name:'shippingusername'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '待发货订单列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width :'auto',
		height :'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});

});
/*===========================================Gorgeous split-line==============================================*/
