/**
 * Global variables
 */
var session = "true";
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * Required to initialize the page data
 */

/**
 * 获取商品类型下拉框
 */
$(function() {
	$.post("findGoodsTypeTNForSelect.action", function(data) {
		if (data.goodstypetnlist != "") {
			var temp = "<select id='goodstypetn' name='goodstypetn'>";
			var temp1 = "</select>";
			$('#goodstypetnselect').after(temp + data.goodstypetnlist + temp1);
		}
	});
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * flexigrid list
 */
$(function() {
	$("#brandsmanagement").flexigrid( {
		url : 'findAllBrandt.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '商品品牌名称',
			name : 'brandname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '排序',
			name : 'sort',
			width : 115,
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
		} ],
		buttons : [ {
			name : '添加',
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
			display : '商品品牌名称',
			name : 'brandname'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '商品品牌列表',
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
		if (com == '添加') {

			var str1 = "";
			var str2 = "";
			if ($('.trSelected', grid).length > 0) {
				$('.trSelected', grid).each(function() {
					str1 += this.id.substr(3) + ",";
				});
				$(".trSelected td:nth-child(2) div", $('#brandmanagement')).each(function(i) {
					str2 += this.innerHTML + ",";
				});
				
				jConfirm('确定要增加此品牌吗?', '信息提示', function(r) {
					if (r) {
						var goodstypetn = $('#goodstypetn').val();
						if(goodstypetn=='0'){
							jAlert('请选择商品类型', '信息提示');
							return false;
						}
						var goodstypetname = $('#goodstypetn').find("option:selected").text();
						$.post("addGoodsTypeBrand", {
							"brandid" : str1,
							"brandname" : str2,
							"goodsTypeId" : goodstypetn,
							"name" : goodstypetname
						}, function(data) {
							window.location.href = "goodstypetnbrandmanagement.jsp?session=" + session + "#goods";
						});
						return;
					}
				});
			} else {
				jAlert('请选择需要添加的信息', '信息提示');
				return false;
			}
		}
	}
});

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
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name : '删除',
			bclass : 'delete',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '商品类型名称',
			name : 'name'
		} ],
		sortname : "name",
		sortorder : "desc",
		usepager : true,
		title : '商品品牌类型列表',
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
		if (com == '添加') {
			window.location.href = "addgoodstypetnbrand.jsp?session=" + session + "#goods";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addgoodsbrand.jsp?session=" + session + "#goods&brandid=" + str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		} else if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("DelGoodsTypeBrand.action", {
							"goodsTypeBrandTid" : str
						}, function(data) {
							$('#goodstypetnbrandmanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		}

	}

});
