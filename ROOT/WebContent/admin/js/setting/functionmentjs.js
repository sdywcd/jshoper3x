/*===========================================Gorgeous split-line==============================================*/
/**
 * Required to initialize the page data
 */
$(function(){
	/**
	 * 获取模块下拉列表(同步)
	 */
	findAllModuleForselect=function(){
		$.ajax({
			url:"findAllModuleForselect.action",
			type:"post",
			dataType:"json",
			async:false,
			success:function(data){
				if(data.sucflag){
					$('#moduleid').append(data.moduleselectstr);
					return;
				}
			}
		});
	},
	/**
	 * 根据模块id查询模块功能列表
	 */
	findFunctionMById=function(){
		var id=$.query.get('id');
		if(id!=""){
			$.post("findFunctionMById.action",{"id":id},function(data){
				if(data.bean!=null){
					$('#moduleid').attr("value",data.bean.moduleid);
					$('#functionname').attr("value",data.bean.functionname);
					$('#visiturl').attr("value",data.bean.visiturl);
					$('#visitmethodname').attr("value",data.bean.visitmethodname);
					$('#hidid').attr("value",data.bean.id);
					$('#submit').hide();
					$('#modify').show();
				}
			});
		}
	};
	
	
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * main logic
 */
$(function(){
	var operate=$.query.get('operate');
	if(operate=="edit"){
		findAllModuleForselect();
		findFunctionMById();
		return;
	}else if(operate=="add"){
		findAllModuleForselect();
		return;
	}
});
/**
 * flexigrid list 
 */
$(function() {
	var moduleid=$.query.get('moduleid');
	$("#functionmanagement").flexigrid( {
		url : 'findAllFunctionMBymoduleid.action?moduleid='+moduleid,
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '功能名称',
			name : 'functionname',
			width : 215,
			sortable : true,
			align : 'center'
		},{
			display : '可访问路径',
			name : 'visiturl',
			width : 415,
			sortable : true,
			align : 'center'
		}, {
			display : '可访问方法',
			name : 'visitmethodname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'

		},{
			display : '操作',
			name : 'operating',
			width : 110,
			sortable : true,
			align : 'center'
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
			window.location.href = "function.jsp?operate=add&folder=setting&moduleid="+moduleid;
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "function.jsp?operate=edit&folder=setting&id=" + str;
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
				$.post("delFunctionM.action", {
					"id" : str
				}, function(data) {
					$('#functionmanagement').flexReload();
					forminfo("#alertinfo","删除模块权限成功");
				});
				return;
			} else {
				forminfo("#alerterror","请选择要删除的信息");
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
 * 增加模块功能
 */
$(function(){
	$('#submit').click(function(){
		var moduleid=$('#moduleid').val();
		if(moduleid=="0"){
			formwarning("#alerterror","功能所属系统模块必须选择");
			return false;
		}
		var functionname=$('#functionname').val();
		var visiturl=$('#visiturl').val();
		var visitmethodname=$('#visitmethodname').val();
		this.value="提交中";
		this.disabled=true;
		$.post("addFunctionM.action",{"moduleid":moduleid,"functionname":functionname,"visiturl":visiturl,"visitmethodname":visitmethodname},function(data){
			if(data.sucflag){
				window.location.href="functionment.jsp?operate=find&folder=setting&moduleid="+moduleid;
			}else{
				formwarning("#alerterror","系统模块功能增加失败");
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
		var moduleid=$('#moduleid').val();
		if(moduleid=="0"){
			formwarning("#alerterror","功能所属系统模块必须选择");
			return false;
		}
		var functionname=$('#functionname').val();
		var visiturl=$('#visiturl').val();
		var visitmethodname=$('#visitmethodname').val();
		var id=$('#hidid').val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateFunctionM.action",{"moduleid":moduleid,"functionname":functionname,"visiturl":visiturl,"visitmethodname":visitmethodname,"id":id},function(data){
			if(data.sucflag){
				window.location.href="functionment.jsp?operate=find&folder=setting&moduleid="+moduleid;
			}else{
				formwarning("#alerterror","系统模块功能更新失败");
				return false;
			}
		});
	});
});
/*===========================================Gorgeous split-line==============================================*/





