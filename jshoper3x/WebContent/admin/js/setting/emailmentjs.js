/*===========================================Gorgeous split-line==============================================*/
/**
 * Required to initialize the page data
 */
$(function() {
	findSysmailByid = function() {
		var id = $.query.get("id");
		if (id != "") {
			$.post("findSysmailByid.action", {
				"id" : id
			}, function(data) {
				$('#update').show();
				$('#submit').hide();
				$("#email").attr("value", data.bean.email);
				$("#pwd").attr("value", data.bean.pwd);
				$("#smtp").attr("value", data.bean.smtp);
				$("#port").attr("value", data.bean.port);
				if (data.bean.isssl == "1") {
					$("input[name='isssl']").get(0).checked = true;
				} else {
					$("input[name='isssl']").get(1).checked = true;
				}
				if (data.bean.isdefault == "1") {
					$("input[name='isdefault']").get(0).checked = true;
				} else {
					$("input[name='isdefault']").get(1).checked = true;
				}
				if (data.bean.state == "1") {
					$("input[name='state']").get(0).checked = true;
				} else {
					$("input[name='state']").get(1).checked = true;
				}
				$("#hidid").attr("value", data.bean.id);
			});
		}
	}
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * main logic
 */
$(function() {
	var operate = $.query.get("operate");
	if (operate == "edit") {
		findSysmailByid();
		return;
	}
});

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * flexigrid list
 */
$(function() {
	$("#systememailmanagement").flexigrid({
		url : 'findAllSystemMail.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '店铺名',
			name : 'shopname',
			width : 200,
			sortable : true,
			align : 'center'
		}, {
			display : '邮箱账号',
			name : 'email',
			width : 220,
			sortable : true,
			align : 'center'
		}, {
			display : 'SMTP',
			name : 'smtp',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '端口',
			name : 'port',
			width : 100,
			sortable : true,
			align : 'center'
		},  {
			display : 'SSL',
			name : 'isssl',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '默认',
			name : 'isdefault',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '状态',
			name : 'state',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '创建人',
			name : 'creatorid',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 150,
			sortable : true,
			align : 'center'
		}, {
			display : '操作',
			name : 'operate',
			width : 100,
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
			window.location.href = "email.jsp?operate=add&folder=setting";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "email.jsp?operate=edit&folder=setting&id="+ str;
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
				$.post("delSystemMail.action", {
					"id" : str
				}, function(data) {
					$('#systememailmanagement').flexReload();
					forminfo("#alertinfo","删除邮箱成功");
				});
				return;
			} else {
				forminfo("#alerterror","请选择要删除的信息");
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
$(function() {
	$("#submit").click(function(){
		var email=$("#email").val();
		if(email==""){
			formwarning("#alerterror","请填写邮箱账号");
			return false;
		}
		var pwd=$("#pwd").val();
		if(pwd==""){
			formwarning("#alerterror","请填写邮箱密码");
			return false;
		}
		var smtp=$("#smtp").val();
		if(smtp==""){
			formwarning("#alerterror","请填写smtp协议地址");
			return false;
		}
		var port=$("#port").val();
		if(port==""){
			formwarning("#alerterror","请填写端口");
			return false;
		}
		var isssl=$("input[name='isssl']:checked").val();
		var isdefault=$("input[name='isdefault']:checked").val();
		var state=$("input[name='state']:checked").val();
		this.value="提交中";
		this.disabled=true;
		$.post("addSystemMail.action",{"email":email,"pwd":pwd,"smtp":smtp,"port":port,"isssl":isssl,"isdefault":isdefault,"state":state},function(data){
			if(data.sucflag){
				window.location.href="emailment.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","邮箱信息增加失败");
				return false;
			}
		});
	});
	
	/**
	 * 更新邮箱
	 */
	$("#update").click(function(){
		var email=$("#email").val();
		if(email==""){
			formwarning("#alerterror","请填写邮箱账号");
			return false;
		}
		var pwd=$("#pwd").val();
		if(pwd==""){
			formwarning("#alerterror","请填写邮箱密码");
			return false;
		}
		var smtp=$("#smtp").val();
		if(smtp==""){
			formwarning("#alerterror","请填写smtp协议地址");
			return false;
		}
		var port=$("#port").val();
		if(port==""){
			formwarning("#alerterror","请填写端口");
			return false;
		}
		var isssl=$("input[name='isssl']:checked").val();
		var isdefault=$("input[name='isdefault']:checked").val();
		var state=$("input[name='state']:checked").val();
		var id=$("#hidid").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateSystemMail.action",{"id":id,"email":email,"pwd":pwd,"smtp":smtp,"port":port,"isssl":isssl,"isdefault":isdefault,"state":state},function(data){
			if(data.sucflag){
				window.location.href="emailment.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","邮箱信息增加失败");
				return false;
			}
		});
	});
	
});
