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
	 * 增加用户分组
	 */
	saveMemberGroupT=function(){
		var name=$("#name").val();
		if(name==""){
			formwarning("#alerterror", "分组名称必须填写");
			return false;
		}
		var status=$("input[name='status']:checked").val();
		var attrs="";
		$.post("saveMemberGroupT.action",{
			"name":name,
			"status":status,
			"attrs":attrs
		},function(data){
			if(data.sucflag){
				window.location.href="membergroupment.jsp?operate=find&folder=member";
				return;
			}else{
				formwarning("#alerterror", "用户分组增加失败");
				return false;
			}
		});
	},
	
	findMembergroupByid=function(){
		var id=$.query.get("id");
		if(id==""){
			return false;
		}
		$.post("findMemberGroupTById.action",{"id":id},function(data){
			if(data.sucflag){
				$("#hidmembergroupid").val(data.bean.id);
				$("#name").val(data.bean.name);
				if("1"==data.bean.status){
					$("input[name='status']").get(0).checked=true;
				}else{
					$("input[name='status']").get(1).checked=true;
				}
				$("#submit").hide();
				$("#update").show();
			}
		});
		
	},
	
	updateMembergroup=function(){
		var name=$("#name").val();
		if(name==""){
			formwarning("#alerterror", "分组名称必须填写");
			return false;
		}
		var status=$("input[name='status']:checked").val();
		var id=$("#hidmembergroupid").val();
		var attrs="";
		$.post("updateMemberGroupT.action",{
			"name":name,
			"status":status,
			"id":id,
			"attrs":attrs
		},function(data){
			if(data.sucflag){
				window.location.href="membergroupment.jsp?operate=find&folder=member";
				return;
			}else{
				formwarning("#alerterror", "用户分组更新失败");
				return false;
			}
		});
		
	},
	
	
	$("#submit").click(function(){
		saveMemberGroupT();
	});
	$("#update").click(function(){
		updateMembergroup();
	});
	
	findAllmembergroupt=function(){
			$("#membergroupmanagement").flexigrid( {
			url : 'findAllMemberGroupT.action',
			dataType : 'json',
			cache : false,
			colModel : [{ 
				display:'店铺名',
				name:'shopname',
				width:215,
				sortable:true,
				align:'center'
			}, { 
				display:'分组名称',
				name:'name',
				width:215,
				sortable:true,
				align:'center'
			}, { 
				display:'状态',
				name:'status',
				width:100,
				sortable:true,
				align:'center'
			},{ display:'创建时间',
				name:'createtime',
				width:200,
				sortable:true,
				align:'center'
			},{ display:'创建者',
				name:'creatorid',
				width:200,
				sortable:true,
				align:'center'
			}],
			buttons : [ {
				name : '添加',
				bclass : 'add',
				onpress : action
			},{
				name : '编辑',
				bclass : 'edit',
				onpress : action
			},{
				name:'删除',
				bclass:'del',
				onpress:action
			},{
				separator : true
			} ],
	
			searchitems : [{
				display:'请选择搜索条件',
				name:'sc',
				isdefault : true
			}, {
				display : '用户名',
				name : 'username'
			} ],
			sortname : "createtime",
			sortorder : "desc",
			usepager : true,
			title : '',
			useRp : true,
			rp : 20,
			rpOptions : [ 5, 20, 40, 100 ],
			showTableToggleBtn : true,
			width :'auto',
			height : 'auto',
			pagestat : '显示{from}到{to}条，共{total}条记录',
			procmsg : '正在获取数据，请稍候...',
			checkbox:true
		});
		function action(com, grid){
			if(com=='编辑'){
				if ($('.trSelected', grid).length == 1) {
					var str = $('.trSelected', grid)[0].id.substr(3);
					window.location.href="membergroup.jsp?operate=edit&folder=member&id="+str;
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}else if(com=='删除'){
				if ($('.trSelected', grid).length > 0) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str += this.id.substr(3) + ",";
					});
					$.post("delMemberGroupT.action",{"id":str},function(data){
						$('#membergroupmanagement').flexReload();
					});
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}else if(com=="添加"){
				window.location.href="membergroup.jsp?operate=add&folder=member";
				return;
			}
		}

	}
	
  	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		
	}else if(operate=="edit"){
		findMembergroupByid();
	}else if(operate=="find"){
		findAllmembergroupt();
	}
	
	
});

