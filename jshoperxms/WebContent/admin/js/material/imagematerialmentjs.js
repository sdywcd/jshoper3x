
$(function() {

	/**
	 * ui
	 */
	$('input').iCheck({
	    checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%' // optional
	});
	/**
	 * flexigrid list
	 */
		$("#imagematerialmanagement").flexigrid( {
			url : 'readAllSeverDirectory.action',
			dataType : 'json',
			cache : false,
			colModel : [ {
				display : '目录',
				name : 'directoryname',
				width : 215,
				sortable : true,
				align : 'center'
			}, {
				display : '文件数',
				name : 'count',
				width : 115,
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
				name : '上传图片',
				bclass : 'add',
				onpress : action
			}, {
				name : '创建分类',
				bclass : 'add',
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
			if (com == '上传图片') {
					if ($('.trSelected', grid).length == 1) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "imagematerial.jsp?operate=add&folder=material&imgdirpath=" + str;
					} else {
						window.location.href = "imagematerial.jsp?operate=add&folder=material";
					}
				} else if (com == '创建分类') {
//					jPrompt('请输入分类名称:', '', '分类信息', function(r) {
//						if (r != null && r != "") {
//							$.post("createDirectory.action", {
//								"imgdirpath" : r
//							}, function(data) {
//								if (data.sucflag) {
//									$('#serverimgmanagement').flexReload();
//									if (r)
//										jAlert('您创建了分类 ' + r, '信息提示');
//								} else {
//									jAlert("分类已经存在", "信息提示");
//								}
//							});
//						}
//					});

				} else if (com == '删除') {
					if ($('.trSelected', grid).length > 0) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delServerDirectoryFile.action", {
							"directoryname" : str
						}, function(data) {
							$('#imagematerialmanagement').flexReload();
						});
						return;
					} else {
						formwarning("#alerterror", "请选择一条信息");
						return false;
					}
				}

			}
		
});
