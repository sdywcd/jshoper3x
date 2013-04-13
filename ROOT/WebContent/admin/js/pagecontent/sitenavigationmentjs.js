/**
 * Global variables
 */
var session = "true";
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * ui
 */
$(function() {

	$("h6").each(function() {
		$(this).removeClass("selected");
	});
	$("ul").each(function() {
		$(this).removeClass("opened");
		$(this).addClass("closed");
	});
	$("#h-menu-pagecontent").addClass("selected");
	$("#menu-pagecontent").removeClass("closed");
	$("#menu-pagecontent").addClass("opened");
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Required to initialize the page data
 */
$(function() {
	// 获取模板输出路径
	$.post("getTemplateOutHtmlPath.action", function(data) {
		if (data.sucflag) {
			$('#syscontent').append(data.templatesetstrs);
		}
	});

	$('#syscontent').change(function() {
		var value = $('#syscontent').val();
		if (value == "-1") {
			value = "请选择系统内容";
		}
		$('#htmlPath').attr("value", value);
	});

});
/**
 * flexigrid list
 */
$(function() {
	$("#sitenavigationmanagement").flexigrid( {
		url : 'findAllSiteNavigationT.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '名称',
			name : 'name',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '位置',
			name : 'position',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '标示',
			name : 'sign',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '排序',
			name : 'sort',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '新窗口打开',
			name : 'isTargetBlank',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '显示',
			name : 'isVisible',
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
			display : '创建人',
			name : 'creatorid',
			width : 214,
			sortable : true,
			align : 'center'

		}, {
			display : '操作',
			name : 'operating',
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
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '导航列表',
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
			window.location.href = "addsitenavigation.jsp?session=" + session + "#pagecontent";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addsitenavigation.jsp?session=" + session + "#pagecontent&snid=" + str;
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
						$.post("delSiteNavigationT.action", {
							"snid" : str
						}, function(data) {
							$('#sitenavigationmanagement').flexReload();
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
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Add Function
 */
/**
 * 增加导航
 */
$(function() {
	$('#submit').click(function() {
		var name = $('#name').val();
		if (name == "") {
			jAlert('导航名称必须填写', '信息提示');
			return false;
		}
		var syscontent = $('#syscontent').val();
		if (syscontent == "-1") {
			jAlert('系统内容必须选择', '信息提示');
			return false;
		}
		var sign = $('#sign').val();
		if (sign == "") {
			jAlert('标示必须填写', '信息提示');
			return false;
		}
		var htmlPath = $('#htmlPath').val();
		var position = $("#position").val();
		var sort = $('#sort').val();
		if ($("#isTargetBlank").attr('checked')) {
			var isTargetBlank = "1";
		} else {
			var isTargetBlank = "0";
		}
		if ($("#isVisible").attr('checked')) {
			var isVisible = "1";
		} else {
			var isVisible = "0";
		}
		$.post("addSiteNavigationT.action", {
			"name" : name,
			"htmlPath" : htmlPath,
			"position" : position,
			"sort" : sort,
			"isTargetBlank" : isTargetBlank,
			"isVisible" : isVisible,
			"sign" : sign
		}, function(data) {
			if (data.sucflag) {
				window.location.href = "sitenavigationmanagement.jsp?session=" + session + "#pagecontent";
			} else {
				jAlert('导航增加失败', '信息提示');
				return false;
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
$(function() {
	var snid = $.query.get('snid');
	if (snid == "") {
		return false;
	}
	$.post("findSiteNavigationBysnid.action", {
		"snid" : snid
	}, function(data) {
		if (data.bean != null) {
			$('#submit').hide();
			$('#modify').show();
			$('#name').attr("value", data.bean.name);
			$('#syscontent').val(data.bean.htmlPath);
			$('#htmlPath').attr("value", data.bean.htmlPath);
			$('#position').val(data.bean.position);
			if (data.bean.isTargetBlank == "1") {
				$("#isTargetBlank").attr("checked", true);
			} else {
				$("#isTargetBlank").attr("checked", false);
			}
			if (data.bean.isVisible == "1") {
				$("#isVisible").attr("checked", true);
			} else {
				$("#isVisible").attr("checked", false);
			}
			$('#sort').attr("value", data.bean.sort);
			$('#sign').attr("value", data.bean.sign);
			$('#hidsnid').attr("value", data.bean.snid);
		}
	});

	$('#modify').click(function() {
		var name = $('#name').val();
		if (name == "") {
			jAlert('导航名称必须填写', '信息提示');
			return false;
		}
		var syscontent = $('#syscontent').val();
		if (syscontent == "-1") {
			jAlert('系统内容必须选择', '信息提示');
			return false;
		}
		var sign = $('#sign').val();
		if (sign == "") {
			jAlert('标示必须填写', '信息提示');
			return false;
		}
		var htmlPath = $('#htmlPath').val();
		var position = $("#position").val();
		var sort = $('#sort').val();
		if ($("#isTargetBlank").attr('checked')) {
			var isTargetBlank = "1";
		} else {
			var isTargetBlank = "0";
		}
		if ($("#isVisible").attr('checked')) {
			var isVisible = "1";
		} else {
			var isVisible = "0";
		}
		var snid = $('#hidsnid').val();
		$.post("updateSiteNavigationT.action", {
			"snid" : snid,
			"name" : name,
			"htmlPath" : htmlPath,
			"position" : position,
			"sort" : sort,
			"isTargetBlank" : isTargetBlank,
			"isVisible" : isVisible,
			"sign" : sign
		}, function(data) {
			if (data.sucflag) {
				window.location.href = "sitenavigationmanagement.jsp?session=" + session + "#pagecontent";
			} else {
				jAlert('导航更新失败', '信息提示');
				return false;
			}
		});
	});
});
