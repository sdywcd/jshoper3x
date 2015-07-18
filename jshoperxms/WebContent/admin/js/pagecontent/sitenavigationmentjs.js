
/**
 * flexigrid list
 */
$(function() {

	$("#sitenavigationmanagement").flexigrid( {
		url : 'findAllSiteNavigationT.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '店铺名',
			name : 'shopname',
			width : 200,
			sortable : true,
			align : 'center'
		},  {
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
			bclass : 'del',
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
		if (com == '添加') {
			window.location.href = "sitenavigation.jsp?operate=add&folder=pagecontent";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "sitenavigation.jsp?operate=edit&folder=pagecontent&snid="+ str;
				return;
			} else {
				formwarning("#alerterror", "请选择一条信息");
				return false;
			}
		} else if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("delSiteNavigationT.action", {
					"snid" : str
				}, function(data) {
					$('#sitenavigationmanagement').flexReload();
					forminfo("#alertinfo", "删除品牌成功");
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要删除的信息");
				return false;
			}
		}
	}

});

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
$(function(){
	getTemplateOutHtmlPath=function(){
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
	},
	findSiteNavigationBysnid=function(){
		var snid = $.query.get('snid');
		if (snid == "") {
			return false;
		}
		$.post("findSiteNavigationBysnid.action", {
			"snid" : snid
		}, function(data) {
			if (data.bean != null) {
				$('#submit').hide();
				$('#update').show();
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
	},
	$('#submit').click(function() {
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","导航名称必须填写");
			return false;
		}
		var syscontent = $('#syscontent').val();
		if (syscontent == "-1") {
			formwarning("#alerterror","系统内容必须选择");
			return false;
		}
		var sign = $('#sign').val();
		if (sign == "") {
			formwarning("#alerterror","标示必须填写");
			return false;
		}
		var htmlPath = $('#htmlPath').val();
		var position = $("#position").val();
		var sort = $('#sort').val();
		var isTargetBlank=$("input[name='isTargetBlank']:checked").val();
		var isVisible=$("input[name='isVisible']:checked").val();
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
				window.location.href = "sitenavigationment.jsp?operate=find&folder=pagecontent";
			} else {
				formwarning("#alerterror","导航增加失败");
				return false;
			}
		});
	});
	
	$('#update').click(function() {
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","导航名称必须填写");
			return false;
		}
		var syscontent = $('#syscontent').val();
//		if (syscontent == "-1") {
//			formwarning("#alerterror","系统内容必须选择");
//			return false;
//		}
		var sign = $('#sign').val();
		if (sign == "") {
			formwarning("#alerterror","标示必须填写");
			return false;
		}
		var htmlPath = $('#htmlPath').val();
		var position = $("#position").val();
		var sort = $('#sort').val();
		var isTargetBlank=$("input[name='isTargetBlank']:checked").val();
		var isVisible=$("input[name='isVisible']:checked").val();
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
				window.location.href = "sitenavigationment.jsp?operate=find&folder=pagecontent";
			} else {
				formwarning("#alerterror","更新导航失败");
				return false;
			}
		});
	});
});

/**
 * main logic
 */
$(function(){
	var operate=$.query.get("operate");
	if(operate=="add"){
		getTemplateOutHtmlPath();
	
	}else if(operate=="edit"){
		getTemplateOutHtmlPath();
		findSiteNavigationBysnid();
	}
	
	
});

