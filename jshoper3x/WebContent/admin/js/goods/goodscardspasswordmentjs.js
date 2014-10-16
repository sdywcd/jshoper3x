$(function(){
	findAllGoodsCardsPassword=function(param){
		$("#goodscardspasswordmanagement").flexigrid({
			url : 'findAllGoodsCardsPassword.action'+param,
			dataType : 'json',
			cache : false,
			colModel : [ {
				display : '密钥',
				name : 'password',
				width : 300,
				sortable : true,
				align : 'center'
			}, {
				display : '使用状态',
				name : 'status',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				display : '创建时间',
				name : 'createtime',
				width : 150,
				sortable : true,
				align : 'center'
			} ],
			buttons : [ {
				separator : true
			} ],

			searchitems : [ {
				display : '请选择搜索条件',
				name : 'sc',
				isdefault : true
			} ],
			sortname : "createtime",
			sortorder : "desc",
			usepager : true,
			title : '',
			useRp : true,
			rp : 20,
			rpOptions : [ 5, 20, 40, 100 ],
			showTableToggleBtn : true,
			showToggleBtn : true,
			width : 'auto',
			height : 'auto',
			pagestat : '显示{from}到{to}条，共{total}条记录',
			procmsg : '正在获取数据，请稍候...',
			checkbox : true
		});
	};
	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if(operate=="find"){
		var id=$.query.get("id");
		if(id!=""){
			var param="?goodsCardsId="+id;
			findAllGoodsCardsPassword(param);
		}
		
	}
	
	
});