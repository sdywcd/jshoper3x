/*===========================================Gorgeous split-line==============================================*/
/**
 * Required to initalize the page data
 */
$(function(){
	findModuleMById=function(){
		var id=$.query.get('id');
		if(id==""){
			return false;
		}
		$.post("findModuleMById.action",{"id":id},function(data){
			if(data.bean!=null){
				$('#modulename').attr("value",data.bean.modulename);
				$('#hidid').attr("value",data.bean.id);
				$('#submit').hide();
				$('#modify').show();
			}
		});
	};
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * main logic
 */
$(function(){
	var operate=$.query.get('operate');
	if(operate=="edit"){
		findModuleMById();
		return;
	}
});


/**
 * flexigrid list 
 */
$(function() {
	$("#modulemanagement").flexigrid( {
		url : 'findAllModuleM.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '模块名称',
			name : 'modulename',
			width : 315,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'
		},{
			display:'操作',
			name:'operate',
			width:100,
			sortable:true,
			align:'center'
		}],
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
			name : '查看模块功能',
			bclass : 'edit',
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
		checkbox:true
	});

	function action(com, grid) {
		if (com == '添加') {
			window.location.href = "module.jsp?operate=add&folder=setting";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "module.jsp?operate=edit&folder=setting&id=" + str;
				return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		} else if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("delModuleM.action", {
					"id" : str
				}, function(data) {
					$('#modulemanagement').flexReload();
					forminfo("#alertinfo","删除系统模块成功");
				});
				return;
			} else {
				forminfo("#alerterror","请选择要删除的信息");
				return false;
			}
	
		}else if(com=='查看模块功能'){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "functionment.jsp?operate=find&setting&moduleid=" + str;
				return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}

	}

});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Add Function
 */

/**
 * 增加模块
 */
$(function(){
	$('#submit').click(function(){
		var modulename=$('#modulename').val();
		if(modulename==""){
			formwarning("#alerterror","模块名称必须填写");
			return false;
		}
		this.value="提交中";
		this.disabled=true;
		$.post("addModuleM.action",{"modulename":modulename},function(data){
			if(data.sucflag){
				window.location.href="modulement.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","系统模块增加失败");
				return false;
			}
		});
	});	
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Update Function
 */
$(function(){
	
	$('#modify').click(function(){
		var modulename=$('#modulename').val();
		if(modulename==""){
			formwarning("#alerterror","模块名称必须填写");
			return false;
		}
		var id=$('#hidid').val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateModuleM.action",{"modulename":modulename,"id":id},function(data){
			if(data.sucflag){
				window.location.href="modulement.jsp?operate=find&folder=setting&id="+id;
			}
		});
	});
});
/*===========================================Gorgeous split-line==============================================*/





