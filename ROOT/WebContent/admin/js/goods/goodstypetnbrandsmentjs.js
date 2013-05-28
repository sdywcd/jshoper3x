
$(function() {
	$("#goodstypetnbrandmanagement").flexigrid( {
		url : 'findAllGoodsTypeBrand.action',
		dataType : 'json',
		colModel : [ {
			display : '商品品牌名称',
			name : 'brandname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '商品类型名称',
			name : 'name',
			width : 115,
			sortable : true,
			align : 'center'
		} ],
		buttons : [ {
			name : '删除',
			bclass : 'del',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}],
		sortname : "name",
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
		if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("DelGoodsTypeBrand.action", {
					"goodsTypeBrandTid" : str
				}, function(data) {
					$('#goodstypetnbrandmanagement').flexReload();
					forminfo("#alertinfo","删除品牌类型关系成功");
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要删除的信息");
				return false;
			}
		}

	}

});
