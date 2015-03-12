
/**
 * flexigrid list
 */
$(function() {
	var directoryname = $.query.get("directoryname");
	if (directoryname == "") {
		return false;
	}
	$("#imagematerialfolderlistmanagement").flexigrid( {
		url : 'readAllSeverDirectoryFile.action?directoryname=' + directoryname,
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '文件名',
			name : 'imgfilepath',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
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
		if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var directoryname=$.query.get('directoryname');
				$.post("delServerFile.action", {
					"filestrs" : str,
					"directoryname":directoryname
				}, function(data) {
					$('#imagematerialfolderlistmanagement').flexReload();
				});
				
				return;
			} else {
				formwarning("#alerterror", "请选择一条信息");
				return false;
			}
		}
	}
});
