/*===========================================Gorgeous split-line==============================================*/
$(function(){
	/**
	 * 根据id加载主题数据并填充页面
	 */
	findTemplatethemeByttid=function(){
		var ttid=$.query.get('ttid');
		if(ttid!=""){
			$.post("findTemplatethemeByttid.action",{"ttid":ttid},function(data){
				$('#modify').show();
				$('#submit').hide();
				$('#themename').attr("value",data.bean.themename);
				$('#note').attr("value",data.bean.note);
				$('#ttid').attr("value",data.bean.ttid);
				$('#sign').attr("value",data.bean.sign);
				if(data.bean.status=="1"){
					$("#status").attr("checked",true);
				}else{
					$("#status").attr("checked",false);
				}
			});
		}else{
			$('#modify').hide();
			return;
		}
	};
	
});

/**
 * main logic
 */
$(function(){
	var operate=$.query.get('operate');
	if(operate=="edit"){
		findTemplatethemeByttid();
	};
});

/**
 * flexigrid list 
 */
$(function() {
	$("#templatethememanagement").flexigrid( {
		url : 'findAllTemplatetheme.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'主题名称',
			name:'themename',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'说明',
			name:'note',
			width:300,
			sortable:true,
			align:'center'
		},{
			display : '标示',
			name : 'sign',
			width : 214,
			sortable : true,
			align : 'center'
				
		},{
			display : '状态',
			name : 'status',
			width : 114,
			sortable : true,
			align : 'center'
				
		},{
			display : '创建时间',
			name : 'createtime',
			width : 210,
			sortable : true,
			align : 'center'
		},{
			display : '创建人',
			name : 'creatorid',
			width : 110,
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
		}],
		searchitems : [{
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		}],
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
	function action(com, grid) {
		if (com == '添加') {
			window.location.href="templatetheme.jsp?operate=add&folder=setting";
			return;
		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href="templatetheme.jsp?operate=edit&folder=setting&ttid="+str;
				return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}else if(com=='删除'){
			if ($('.trSelected', grid).length > 0) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str += this.id.substr(3) + ",";
					});
					$.post("delTemplatetheme.action",{"ttid":str},function(data){
						$('#templatethememanagement').flexReload();
						forminfo("#alertinfo","删除模板主题成功");
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
$(function(){
	$('#submit').click(function(){
		var themename=$('#themename').val();
		if(themename==""){
			formwarning("#alerterror","请填写主题名称");
			return false;
		}
		var note=$("#note").val();
		if(note==""){
			formwarning("#alerterror","请填写说明");
			return false;
		}
		var sign=$('#sign').val();
		if(sign==""){
			formwarning("#alerterror","请填写标示");
			return false;
		}
		var status="0";
		if($("#status").attr('checked')){
			status="1";
		}
		this.value="提交中";
		this.disabled=true;
		$.post("addTemplatetheme.action",{"themename":themename,"note":note,"sign":sign,"status":status},function(data){
			if(data.sucflag){
				window.location.href="templatethemement.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","模板主题增加失败");
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
		var themename=$('#themename').val();
		if(themename==""){
			formwarning("#alerterror","请填写主题名称");
			return false;
		}
		var note=$("#note").val();
		if(note==""){
			formwarning("#alerterror","请填写说明");
			return false;
		}
		var sign=$('#sign').val();
		if(sign==""){
			formwarning("#alerterror","请填写标示");
			return false;
		}
		var status="0";
		if($("#status").attr("checked")){
			  status="1";
		}
		var ttid=$("#ttid").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateTemplatetheme.action",{"themename":themename,"note":note,"sign":sign,"ttid":ttid,"status":status},function(data){
			if(data.sucflag){
				window.location.href="templatethemement.jsp?operate=find&folder=setting&ttid="+ttid;
			}else{
				formwarning("#alerterror","模板主题更新失败");
				return false;
			}
		});
	});
	
});

/*===========================================Gorgeous split-line==============================================*/




