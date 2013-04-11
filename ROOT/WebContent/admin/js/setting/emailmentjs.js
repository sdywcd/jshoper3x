
/*===========================================Gorgeous split-line==============================================*/
/**
 * Function
 */
/**
 * Required to initialize the page data
 */

/**
 * flexigrid list 
 */
	$(function() {
		$("#systememailmanagement").flexigrid( {
			url : 'findAllSystemMail.action',
			dataType : 'json',
			cache : false,
			colModel : [{
				display:'邮箱',
				name:'email',
				width:220,
				sortable:true,
				align:'center'
			},{ 
				display:'SMTP',
				name:'smtp',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'端口',
				name:'port',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'SMTP用户名',
				name:'smtpusername',
				width:120,
				sortable:true,
				align:'center'
			},{
				display:'SSL',
				name:'isssl',
				width:60,
				sortable:true,
				align:'center'
			},{
				display:'默认',
				name:'isdefault',
				width:60,
				sortable:true,
				align:'center'
			},{
				display:'状态',
				name:'state',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'创建人',
				name:'creatorid',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'创建时间',
				name:'createtime',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'操作',
				name:'operate',
				width:100,
				sortable:true,
				align:'center'
			}],
			buttons : [{
				name : '添加',
				bclass : 'add',
				onpress : action
			},{
				name : '编辑',
				bclass : 'edit',
				onpress : action
			},{
				name : '删除',
				bclass : 'del',
				onpress : action
			},{
				separator : true
			} ],			
			sortname : "createtime",
			sortorder : "desc",
			usepager : true,
			title : '',
			useRp : true,
			rp : 20,
			rpOptions :[ 5, 20, 40, 100 ],
			showTableToggleBtn : true,
			width :'auto',
			height : 'auto',
			pagestat : '显示{from}到{to}条，共{total}条记录',
			procmsg : '正在获取数据，请稍候...',
			checkbox:true
		});
		function action(com, grid) {
			if (com == '添加') {
				window.location.href="email.jsp?operate=add&folder=setting";
				return;
			}
		}
});
	/*===========================================Gorgeous split-line==============================================*/

/**
 * Add Function
 */
$(function(){
	$('#submit').click(function(){
		var sysSendmail=$('#sysSendmail').val();
		var sysMailSmtp=$('#sysMailSmtp').val();
		var sysMailPort=$('#sysMailPort').val();
		var smtpusername=$('#smtpusername').val();
		var smtppwd=$('#smtppwd').val();
		$.post("updateEmailProperties.action",{"sysSendmail":sysSendmail,"sysMailSmtp":sysMailSmtp,"sysMailPort":sysMailPort,"smtpusername":smtpusername,"smtppwd":smtppwd},function(){

			window.location.href='systememailmanagement.jsp?session='+session+"#settings";
		});
	});
	
	$('#submitactivity').click(function(){
		var detail = $('#detail').val();
		if(detail==""){
			jAlert("内容不能为空","信息提示");
			return false;
		}
		$.post("sendActivityEmail.action",{"detail":detail},function(data){
		
		});
	});
});

=======

/*===========================================Gorgeous split-line==============================================*/
/**
 * Function
 */
/**
 * Required to initialize the page data
 */

/**
 * flexigrid list 
 */
	$(function() {
		$("#systememailmanagement").flexigrid( {
			url : 'findAllSystemMail.action',
			dataType : 'json',
			cache : false,
			colModel : [{
				display:'邮箱',
				name:'email',
				width:220,
				sortable:true,
				align:'center'
			},{ 
				display:'SMTP',
				name:'smtp',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'端口',
				name:'port',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'SSL',
				name:'isssl',
				width:60,
				sortable:true,
				align:'center'
			},{
				display:'默认',
				name:'isdefault',
				width:60,
				sortable:true,
				align:'center'
			},{
				display:'状态',
				name:'state',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'创建人',
				name:'creatorid',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'创建时间',
				name:'createtime',
				width:150,
				sortable:true,
				align:'center'
			},{
				display:'操作',
				name:'operate',
				width:100,
				sortable:true,
				align:'center'
			}],
			buttons : [{
				name : '添加',
				bclass : 'add',
				onpress : action
			},{
				name : '编辑',
				bclass : 'edit',
				onpress : action
			},{
				name : '删除',
				bclass : 'del',
				onpress : action
			},{
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
			rpOptions :[ 5, 20, 40, 100 ],
			showTableToggleBtn : true,
			width :'auto',
			height : 'auto',
			pagestat : '显示{from}到{to}条，共{total}条记录',
			procmsg : '正在获取数据，请稍候...',
			checkbox:true
		});
		function action(com, grid) {
			if (com == '添加') {
				window.location.href="email.jsp?operate=add&folder=setting";
				return;
			}
		}
});
	/*===========================================Gorgeous split-line==============================================*/

/**
 * Add Function
 */
$(function(){
	$('#submit').click(function(){
		var email=$("#email").val();
		if(email==""){
			formwarning("#alerterror","请填写邮箱地址");
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
			formwarning("#alerterror","请填写邮件服务端口");
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
});


