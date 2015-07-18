/**
 * Global variables
 */
var session = "true";
var flag = false;
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * Function
 */
// 验证商品传递的参数
function validatethenpostinfotokeyword() {
	var keywordname = $('#keywordname').val();
	var type = $('#type').val();
	var typename = $('#type').find("option:selected").text();
	var state = $('#state').val();
	var statename = $('#state').find("option:selected").text();
	var sort = $('#sort').val();
	if ("" == keywordname) {
		jAlert("名称不能为空", "信息提示");
		return false;
	}
	if ("0" == type) {
		jAlert("类型不能为空", "信息提示");
		return false;
	}
	if ("" == sort) {
		jAlert("顺序不能为空", "信息提示");
		return false;
	}
	flag = true;

}

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * flexigrid list
 */
$(function() {
	$("#keywordmanagement").flexigrid( {
		url : 'findAllKeywordT.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '关键字名称',
			name : 'keywordname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '类型',
			name : 'type',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '显示状态',
			name : 'state',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '显示顺序',
			name : 'sort',
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
			display : '关键字名称',
			name : 'keywordname',
			isdefault : true
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '商品关键字列表',
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
			$("#submit").show();
			$("#modify").hide();
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str = this.id.substr(3) ;
				});
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						$.post("findKeywordById.action", {
							"keywordid" : str
						}, function(data) {
							$("#submit").hide();
							$("#modify").show();
							$("#keywordname").attr("value", data.beanlist.keywordname);
							$("#keywordid").attr("value", data.beanlist.keywordid);
							$("#sort").attr("value", data.beanlist.sort);
							if ("1" == data.beanlist.state) {
								$("#state").val(1);
							}
							if ("2" == data.beanlist.state) {
								$("#state").val(2);
							}
							if ("1" == data.beanlist.type) {
								$("#type").val(1);
							}
							if ("2" == data.beanlist.type) {
								$("#type").val(2);
							}
							return;
						});
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		} else if (com = '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("DelKeywordT.action", {
							"keywordid" : str
						}, function(data) {
							$('#keywordmanagement').flexReload();
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
/*===========================================Gorgeous split-line==============================================*/



/**
 * Add Function
 */
$(function() {
	// 添加关键字
	$('#submit').click(function() {
		validatethenpostinfotokeyword();
		if (flag) {
			var keywordname = $('#keywordname').val();
			var type = $('#type').val();
			var typename = $('#type').find("option:selected").text();
			var state = $('#state').val();
			var statename = $('#state').find("option:selected").text();
			var sort = $('#sort').val();
			$.post("addKeywordT.action", {
				"keywordname" : keywordname,
				"type" : type,
				"state" : state,
				"sort" : sort
			}, function(data) {
				if (data.slogin) {
					jAlert("添加成功", "信息提示");
					$('#keywordmanagement').flexReload();
				} else {
					jAlert("添加失败", "信息提示");
					$('#keywordmanagement').flexReload();
				}
			});
		}

	});
});
/*===========================================Gorgeous split-line==============================================*/


/**
 * Update Function
 */
//点击编辑更新内容
$(function() {
	$("#modify").click(function() {
		var keywordid = $("#keywordid").val();
		var keywordname = $("#keywordname").val();
		var type = $("#type").val();
		var state = $("#state").val();
		var sort = $("#sort").val();
		$.post("UpdateKeywordT.action", {
			"keywordid" : keywordid,
			"keywordname" : keywordname,
			"type" : type,
			"state" : state,
			"sort" : sort
		}, function(data) {
			$('#keywordmanagement').flexReload();
		});
	});
});