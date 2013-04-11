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
/*
 * 删除图片按钮
 */
$(function() {
	$("#delpc").click(function() {
		var str = "";
		var sum = 0;
		$(":checkbox[name='pcpath'][checked=true]").each(function() {
			sum++;
			str = this.id;
		});
		if (sum == 0) {
			jAlert('只有在选择图片后才能删除', '信息提示');
			return false;
		}
		if (sum > 1) {
			jAlert('不能选择多个图片', '信息提示');
			return false;
		}
		$('#triggers img').each(function() {
			if (this.id == str) {
				this.style.display = "none";
				$(":checkbox[name='pcpath'][checked=true]").each(function() {
					if (this.id == str) {
						this.style.display = "none";
						this.name = "dispcpath";
					}

				});
			}

		});

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
			name : '编辑',
			bclass : 'edit',
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
		showToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox : true
	});

	function action(com, grid) {
		if (com == '添加') {
			window.location.href = "addgoodsbrand.jsp?session=" + session + "#goods";
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
						$.post("DelBrandt.action", {
							"brandid" : str
						}, function(data) {
							$('#brandmanagement').flexReload();
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
/*
 * ===========================================Gorgeous split-line==============================================
 */
/**
 * Add Function
 */
/**
 * 增加品牌
 */
$(function() {
	$('#submit').click(function() {
		var brandname = $('#brandname').val();
		var url = $('#url').val();
		// 获logo路径集合
			var logoPath = "";
			$(":checkbox[name='pcpath'][checked=true]").each(function() {
				logoPath = this.value
			});
			var sort = $('#sort').val();
			var intro = $('#intro').val();
			if (brandname == "") {
				jAlert('品牌名称必须填写', '信息提示');
				return false;
			}
			if (sort == "") {
				jAlert('排序必须填写', '信息提示');
				return false;
			}
			$.post("addBrandt.action", {
				"brandname" : brandname,
				"url" : url,
				"logoPath" : logoPath,
				"sort" : sort,
				"intro" : intro
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "brandmanagement.jsp?session=" + session + "#goods";
				}
			});
		});
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * Update Function
 */
/**
 * 更新商品品牌
 */
$(function() {
	var brandid = $.query.get('brandid');
	if (brandid == "") {
		return false;
	}
	$.post("findBrandById.action", {
		"brandid" : brandid
	}, function(data) {
		if (data.bean != null) {
			$('#submit').hide();
			$('#modify').show();
			$('#brandname').attr("value", data.bean.brandname);
			$('#url').attr("value", data.bean.url);
			$('#hidbrandid').attr("value", data.bean.brandid);
			if (data.bean.url == null) {
				var htm = "<img id='logoPath' src=''/>";
			} else {
				var htm = "<img id='logoPath' src='" + data.bean.logoPath + "'/>";
				var checkpc = "<input id='logoPath' name='pcpath' type='checkbox' value='" + data.bean.logoPath + "' checked='true' />";
			}
			$("#triggers").html(htm).append(checkpc);
			$('#sort').attr("value", data.bean.sort);
			if (data.bean.intro == null) {
				KE.html("intro", "");
			} else {
				KE.html("intro", data.bean.intro);
			}

		}
	});
	$('#modify').click(function() {
		var brandname = $('#brandname').val();
		var url = $('#url').val();
		// 获logo路径集合
			var logoPath = "";
			$(":checkbox[name='pcpath'][checked=true]").each(function() {
				logoPath = this.value
			});
			var sort = $('#sort').val();
			var intro = $('#intro').val();
			var hidbrandid = $('#hidbrandid').val();
			if (brandname == "") {
				jAlert('品牌名称必须填写', '信息提示');
				return false;
			}
			if (sort == "") {
				jAlert('排序必须填写', '信息提示');
				return false;
			}
			if (logoPath == undefined) {
				logoPath = "#";
			}
			$.post("UpdateBrandt.action", {
				"brandid" : hidbrandid,
				"brandname" : brandname,
				"url" : url,
				"logoPath" : logoPath,
				"sort" : sort,
				"intro" : intro
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "brandmanagement.jsp?session=" + session + "#goods";
				}
			});
		});
});
