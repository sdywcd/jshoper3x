/*===========================================Gorgeous split-line==============================================*/
/**
 * Required to initialize the page data
 */
$(function(){
	/**
	 * 获取模块下拉列表
	 */
	findAllFunction=function(){
		$.ajax({
			url:"findAllFunction.action",
			type:"post",
			dataType:"json",
			async:false,
			success:function(data){
				if (data.beanlist!=null) {
					var html="";
					$.each(data.beanlist,function(n,value){
						html+="<div class='form-inline'><label class='label label-submit'></label><input type='checkbox' id='functions' name='functions' value='"+value.id+"'/>"+value.functionname+"</div>";
					});
					$('#functionsdiv').append(html);
				}
			}
		});
	},
	/**
	 * 绑定角色权限
	 */
	bindfunction=function(value){
		$("input:checkbox").each(function(i){
		   if(value==this.value){
			   $(this).attr("checked",true);
		   }
		});
	},
	findRoleMById=function(){
		var id=$.query.get('id');
		if(id!=""){
			$.post("findRoleMById.action",{"id":id},function(data){
				if(data.bean!=null){
					$('#rolename').attr("value",data.bean.rolename);
					$('#note').attr("value",data.bean.note);
					$('#hidid').attr("value",data.bean.id);
					//绑定角色权限
					$.each(data.rfmbean,function(n,value){
						bindfunction(value.functionid);
					});
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
	if(operate=="add"){
		findAllFunction();
		return;
	}else if(operate=="edit"){
		findAllFunction();
		findRoleMById();
	}
});
/**
 * flexigrid list 
 */

$(function() {
	$("#rolemanagement").flexigrid( {
		url : 'findAllRoleM.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '角色名称',
			name : 'rolename',
			width : 215,
			sortable : true,
			align : 'center'
		},{
			display : '说明',
			name : 'note',
			width : 415,
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
			name : '添加角色',
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
		if (com == '添加角色') {
			window.location.href = "role.jsp?operate=add&folder=setting";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "role.jsp?operate=edit&folder=setting&id=" + str;
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
				$.post("delRoleM.action", {
					"id" : str
				}, function(data) {
					$('#rolemanagement').flexReload();
					forminfo("#alertinfo","删除角色成功");
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
 * 增加角色
 */
$(function(){
	$('#submit').click(function(){
		var functionid="";
		$("input:checkbox").each(function(i){
		    if($(this).attr("checked")) {
		      functionid+=this.value+",";
		   }
		});
		var rolename=$('#rolename').val();
		var note=$('#note').val();
		this.value="提交中";
		this.disabled=true;
		$.post("addRoleM.action",{"functionid":functionid,"rolename":rolename,"note":note},function(data){
			if(data.sucflag){
				window.location.href="rolement.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","角色权限增加失败");
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
		var functionid="";
		$("input:checkbox").each(function(i){
		    if($(this).attr("checked")) {
		      functionid+=this.value+",";
		   }
		});
		var rolename=$('#rolename').val();
		var note=$('#note').val();
		var id=$('#hidid').val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateRoleM.action",{"functionid":functionid,"rolename":rolename,"note":note,"id":id},function(data){
			if(data.sucflag){
				window.location.href="rolement.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","角色权限更新失败");
				return false;
			}
		});
	});
});
/*===========================================Gorgeous split-line==============================================*/





