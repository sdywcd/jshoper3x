
/**
 * Global variables
 */
var session="true";
/*===========================================Gorgeous split-line==============================================*/

/**
 * flexigrid list 
 */
$(function() {
	$("#goodsmanagement").flexigrid( {
		url : 'findAllGoods.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '商品名称',
			name : 'goodsname',
			width : 500,
			sortable : true,
			align : 'center'
		}, {
			display : '商品编号',
			name : 'usersetnum',
			width : 150,
			sortable : true,
			align : 'center'
		},{
			display : '会员价',
			name : 'memberprice',
			width : 120,
			sortable : true,
			align : 'center'
		}, {
			display : '分类',
			name : 'sname',
			width : 150,
			sortable : true,
			align : 'center'
		},  {
			display : '上架',
			name : 'salestate',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '新品',
			name : 'isNew',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '特价',
			name : 'bargainprice',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '热销',
			name : 'hotsale',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '推荐',
			name : 'recommended',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '库存',
			name : 'quantity',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '操作',
			name : 'operating',
			width : 110,
			sortable : true,
			align : 'center'
		} ],
		buttons : [ {
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name:'编辑',
			bclass:'edit',
			onpress:action
		},{
			name : '删除',
			bclass : 'delete',
			onpress : action
		}, {
			name : '上架',
			bclass : 'add',
			onpress : action
		}, {
			name : '下架',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记特价',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记热销',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记推荐',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记新品',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记移动平台',
			bclass : 'add',
			onpress : action
		}, {
			name : '重置标记',
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
			display : '商品名称',
			name : 'goodsname'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '商品列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		showToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com, grid) {
		if (com == '添加') {
			window.location.href = 'addgoods.jsp?session='+session+"#goods";
			return;

		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "editgoods.jsp?session=" + session + "#goods&goodsid=" + str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('删除商品会同时删除商品对应的规格货品！确定要删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delGoods.action", {
							"goodsid" : str
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert(data.goodsid + '号商品已经删除', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		} else if (com == '标记特价') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要标记此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var bargainprice = "1";
						$.post("updateGoodsbargainprice.action", {
							"goodsid" : str,
							"bargainprice" : bargainprice
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要标记特价的信息!', '信息提示');
				return false;
			}
		} else if (com == '标记热销') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要标记此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var hotsale = "1";
						$.post("updateGoodshotsale.action", {
							"goodsid" : str,
							"hotsale" : hotsale
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要标记热销的信息!', '信息提示');
				return false;
			}
		} else if (com == '标记推荐') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要标记此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var recommended = "1";
						$.post("updateGoodsrecommended.action", {
							"goodsid" : str,
							"recommended" : recommended
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要标记推荐的信息!', '信息提示');
				return false;
			}
		} else if (com == '标记新品') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要标记此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var isNew = "1";
						$.post("updateGoodsisNew.action", {
							"goodsid" : str,
							"isNew" : isNew
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要标记新品的信息!', '信息提示');
				return false;
			}
		} else if (com == '标记移动平台') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要标记此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var ismobileplatformgoods = "1";
						$.post("updateGoodsismobileplatformgoods.action", {
							"goodsid" : str,
							"ismobileplatformgoods" : ismobileplatformgoods
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要标记移动平台的信息!', '信息提示');
				return false;
			}
		} else if (com == '重置标记') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要标记此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var recommended = "0";
						var hotsale = "0";
						var bargainprice = "0";
						var isNew = "0";
						var ismobileplatformgood = "0";
						$.post("updateFiveGoodsState.action", {
							"goodsid" : str,
							"recommended" : recommended,
							"hotsale" : hotsale,
							"bargainprice" : bargainprice,
							"isNew" : isNew,
							"ismobileplatformgoods" : ismobileplatformgoods
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要重置标记的信息!', '信息提示');
				return false;
			}
		} else if (com == '上架') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要上架此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var salestate = "1";
						$.post("updateGoodsSaleState.action", {
							"goodsid" : str,
							"salestate" : salestate
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要上架的信息!', '信息提示');
				return false;
			}
		} else if (com == '下架') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要下架此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var salestate = "0";
						$.post("updateGoodsSaleState.action", {
							"goodsid" : str,
							"salestate" : salestate
						}, function(data) {
							if (data.sucflag) {
								$('#goodsmanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要下架的信息!', '信息提示');
				return false;
			}
	
		}

	}
});
