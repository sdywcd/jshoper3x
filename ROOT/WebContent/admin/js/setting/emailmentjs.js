
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
