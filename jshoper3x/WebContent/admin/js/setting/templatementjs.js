
/*===========================================Gorgeous split-line==============================================*/

/**
 * Required to initialize the page data
 */
$(function(){
	/**
	 * 在页面数据完全加载完毕后填充
	 * @return
	 */
	findTemplateByTid=function(){
		var tid=$.query.get('tid');
		if(tid!=""){
			$.post("findTemplateByTid.action",{"tid":tid},function(data){
				$('#modify').show();
				$('#submit').hide();
				$('#name').attr("value",data.bean.name);
				$('#url').attr("value",data.bean.url);
				$('#note').attr("value",data.bean.note);
				$('#tid').attr("value",data.bean.tid);
				$('#type').val(data.bean.type);
				$("#tvalue").val(data.bean.tvalue);
				$('#sign').attr("value",data.bean.sign);
				$('#themename').attr("value",data.bean.themename);
				$('#status').attr("value",data.bean.status);
				var tarray=new Array();
				tarray=data.bean.sign.split('_');
				$('#templatetheme').val(data.bean.themeid+","+tarray[0]);
			});
		}else{
			$('#modify').hide();
			return;
		}
	},
	/**
	 * 加载模板主题
	 */
	findAllTemplatetheme=function(){
		$.ajax({
			url:"getAllTemplatetheme.action",
			type:"post",
			dataType:"json",
			async:false,
			success:function(data){
				if(data.sucflag){
					$('#templatetheme').append(data.templatethemestrs);
					return;
				}
			}
		});
	},
	
	$('#templatetheme').focusout(function(){
		var templatetheme=$('#templatetheme').find("option:selected").text();
		var url="WEB-INF/theme/"+templatetheme+"/shop/";
		$('#url').attr("value",url);
	});
	
	$('#name').focus(function(){
		var templatetheme=$('#templatetheme').val();
		if(templatetheme=='-1'){
			formwarning("#alerterror","请先选择主题");
			return false;
		}
	});
	
	$('#url').focus(function(){
		var name=$('#name').val();
		if(name==""){
			formwarning("#alerterror","请填写模板名称");
			return false;
		}
	});
	
	$('#name').focusout(function(){
		var templatetheme=$('#templatetheme').find("option:selected").text();
		var name=$('#name').val();
		var url="WEB-INF/theme/"+templatetheme+"/shop/"+name+".ftl";
		$('#url').attr("value",url);
		//生成标示
		var tarray=new Array();
		tarray=$('#templatetheme').val().split(',');
		$('#sign').attr("value",tarray[1]+"_"+name);
	});
	
	$('#url').focusout(function(){
		var templatetheme=$('#templatetheme').find("option:selected").text();
		var name=$('#name').val();
		var url="WEB-INF/theme/"+templatetheme+"/shop/"+name+".ftl";
		$('#url').attr("value",url);
		//生成标示
		var tarray=new Array();
		tarray=$('#templatetheme').val().split(',');
		$('#sign').attr("value",tarray[1]+"_"+name);
	});
	
	
	
});

/*===========================================Gorgeous split-line==============================================*/
/**
 * main logic
 */
$(function(){
	var operate=$.query.get('operate');
	if(operate=="edit"){
		findAllTemplatetheme();//这个方法要同步
		findTemplateByTid();
		return;
	}else if(operate=="add"){
		findAllTemplatetheme();//这个方法要同步
		return;
	}
});

/*===========================================Gorgeous split-line==============================================*/
/**
 * flexigrid list 
 */
$(function() {
	$("#templatemanagement").flexigrid( {
		url : 'findAllTemplate.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'标示',
			name:'sign',
			width:220,
			sortable:true,
			align:'center'
		},{ 
			display:'主题',
			name:'themename',
			width:115,
			sortable:true,
			align:'center'
		},{ 
			display:'模板名称',
			name:'name',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'类型',
			name:'type',
			width:115,
			sortable:true,
			align:'center'
		},{
			display : '模板说明',
			name : 'note',
			width : 150,
			sortable : true,
			align : 'center'	
		},{
			display : '状态',
			name : 'status',
			width : 80,
			sortable : true,
			align : 'center'
				
		},{ display:'模板文件路径',
			name:'url',
			width:300,
			sortable:true,
			align:'center'
		},{
			display : '操作',
			name : 'operating',
			width : 80,
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
			name:'删除',
			bclass:'del',
			onpress:action
		},{
			name:'预览模板',
			bclass:'add',
			onpress:action
		},{
			name:'首页静态化',
			bclass:'edit',
			onpress:action
		},{
			name:'测试静态化',
			bclass:'edit',
			onpress:action
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
			window.location.href="template.jsp?operate=add&folder=setting";
			return;
		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
					var str = $('.trSelected', grid)[0].id.substr(3);
					window.location.href="template.jsp?operate=edit&folder=setting&tid="+str;
					return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}else if(com=="更新模板文件"){
			$.post("recreateTemplate.action",function(data){
				if(data.sucflag){
					forminfo("#alertinfo","更新模板文件成功");
					return;
				}
			});
		}else if(com=="删除"){
			if ($('.trSelected', grid).length > 0) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str += this.id.substr(3) + ",";
					});
					$.post("delTemplate.action", {
						"tid" : str
					}, function(data) {
						$('#templatemanagement').flexReload();
						forminfo("#alertinfo","删除模板文件成功");
					});
				return;
			} else {
				forminfo("#alerterror","请选择要删除的信息");
				return false;
			}
		}else if(com=="测试静态化"){
			$.post("buildAllHtml.action", function(data) {
				$('#templatemanagement').flexReload();
			});
		}else if(com=="预览模板"){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				$.post("previewTemplate.action",
				{
					"tid":str
				}, function(data) {
					if(data.templatehtml!=null&&data.templatehtml!=""){
						window.open(data.templatehtml,'');
						return;
					}
				});
				return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}else if(com=="首页静态化"){
			$.post("buildIndexHtml.action", function(data) {
				forminfo("#alertinfo","首页静态化成功");
			});
		}
	}
});
/*===========================================Gorgeous split-line==============================================*/

/**
 * Add Function
 */
$(function(){
	$('#submit').click(function(){
		var templatetheme=$('#templatetheme').val();
		if(templatetheme=='-1'){
			formwarning("#alerterror","请先选择主题");
			return false;
		}else{
			var tarray=new Array();
			tarray=$('#templatetheme').val().split(',');
			var themeid=tarray[0];
			var themename=$('#templatetheme').find("option:selected").text();
			var templatetheme=$('#templatetheme').find("option:selected").text();
			var name=$('#name').val();
			var url="WEB-INF/theme/"+templatetheme+"/shop/"+name+".ftl";
			$('#url').attr("value",url);
			//生成标示
			$('#sign').attr("value",tarray[1]+"_"+name);
		}
		var name=$('#name').val();
		if(name==""){
			formwarning("#alerterror","请填写模板名称");
			return false;
		}
		var url=$('#url').val();
		if(url==""){
			formwarning("#alerterror","请填写模板路径");
			return false;
		}
		var note=$("#note").val();
		if(note==""){
			formwarning("#alerterror","请填写描述");
			return false;
		}
		var tvalue=$('#tvalue').val();
		if(tvalue==""){
			formwarning("#alerterror","请填写模板内容");
			return false;
		}
		var type=$('#type').val();
		if(type=="0"){
			formwarning("#alerterror","请选择模板类型");
			return false;
		}
		var sign=$('#sign').val();
		if(sign==""){
			formwarning("#alerterror","标示出现获取异常请重新选择模板主题和输入模板名称");
			return false;
		}
		this.value="提交中";
		this.disabled=true;
		$.post("addTemplate.action",{"sign":sign,"themeid":themeid,"themename":themename,"name":name,"url":url,"note":note,"tvalue":tvalue,"type":type},function(data){
			if(data.sucflag){
				window.location.href="templatement.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","模板增加失败");
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
		var tid=$('#tid').val();
		var templatetheme=$('#templatetheme').val();
		if(templatetheme=='-1'){
			formwarning("#alerterror","请先选择主题");
			return false;
		}else{
			var tarray=new Array();
			tarray=$('#templatetheme').val().split(',');
			var themeid=tarray[0];
			var themename=$('#templatetheme').find("option:selected").text();
			var templatetheme=$('#templatetheme').find("option:selected").text();
			var name=$('#name').val();
			var url="WEB-INF/theme/"+templatetheme+"/shop/"+name+".ftl";
			$('#url').attr("value",url);
			//生成标示
			$('#sign').attr("value",tarray[1]+"_"+name);
		}
		var name=$('#name').val();
		if(name==""){
			formwarning("#alerterror","请填写模板名称");
			return false;
		}
		var url=$('#url').val();
		if(url==""){
			formwarning("#alerterror","请填写模板路径");
			return false;
		}
		var note=$("#note").val();
		if(note==""){
			formwarning("#alerterror","请填写描述");
			return false;
		}
		var tvalue=$('#tvalue').val();
		if(tvalue==""){
			formwarning("#alerterror","请填写模板内容");
			return false;
		}
		var type=$('#type').val();
		if(type=="0"){
			formwarning("#alerterror","请选择模板类型");
			return false;
		}
		var sign=$('#sign').val();
		if(sign==""){
			formwarning("#alerterror","标示出现获取异常请重新选择模板主题和输入模板名称");
			return false;
		}
		var status=$('#status').val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateTemplate.action",{"sign":sign,"themeid":themeid,"themename":themename,"name":name,"url":url,"note":note,"tid":tid,"tvalue":tvalue,"type":type,"status":status},function(data){
			if(data.sucflag){
				window.location.href="templatement.jsp?operate=find&folder=setting&tid="+tid;
			}else{
				formwarning("#alerterror","模板更新失败");
				return false;
			}
		});
	});
});
