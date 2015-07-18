
/*===========================================Gorgeous split-line==============================================*/

/*===========================================Gorgeous split-line==============================================*/

/**
 * Required to initialize the page data
 */
$(function(){
	/**
	 * 根据id加载系统内容和模板文件关系
	 */
	findTemplatesetTBytsid=function(){
		var tsid=$.query.get('tsid');
		if(tsid!=""){
			$.post("findTemplatesetTBytsid.action",{"tsid":tsid},function(data){
				$('#modify').show();
				$('#submit').hide();
				$('#ssystemcontent').hide();
				var h="<input class='small' readonly id='ssystemcontent1' name='ssystemcontent1' value="+data.bean.systemcontent+" type='text'/>";
				$('#sys1 label').after(h);
				$('#modifysys').show();
				$('#tsid').attr("value",data.bean.tsid);
				$('#buildhtmlpath').val(data.bean.buildhtmlpath);
				$("#templateurl").val(data.bean.templateurl+","+data.bean.sign);
				$("#sign").attr("value",data.bean.sign);
				$("#syssign").attr("value",data.bean.sign+","+data.bean.templateurl);
			});
		}else{
			$('#modify').hide();
		}
	};
	/**
	 * 修改系统内容按钮
	 */
	$('#modifysys').click(function(){
		$('#zsys').show();
		$('#ssystemcontent').show();
	});
	
	/**
	 * 加载系统内容
	 */
	findSystemcontent=function(){
		$.ajax({
			url:"findSystemcontent.action",
			type:"post",
			dataType:"json",
			async:false,
			success:function(data){
				if(data.sucflag){
					$('#ssystemcontent').append(data.syscontentstrs);
					return;
				}
			}
		});
	},
	/**
	 * 获取所有模板
	 */
	getAllTemplate=function(){
		$.ajax({
			url:"getAllTemplate.action",
			type:"post",
			dataType:"json",
			async:false,
			success:function(data){
				if(data.sucflag){
					$('#templateurl').append(data.templatestrs);
					return;
				}
			}
		});
	},
	//当选择模板文件时填充sign
	$('#templateurl').change(function(){
		var tarray=new Array();
		tarray=$('#templateurl').val().split(',');
		$('#sign').attr("value",tarray[1]);
	});
	
	$('#ssystemcontent').change(function(){
		var ssystemcontent=$('#ssystemcontent').val();
		if(ssystemcontent=="0"){
			$('#sign').attr("value","");
			$('#syssign').attr("value","");
			$('#zsys').show();
			//$('#sign').attr("disabled",false);
		}else{
			$('#zsys').hide();
			if(ssystemcontent=="1"||ssystemcontent=="2"){
				//$('#sign').hide();
				return;
			}else{
				$('#sign').show();
				var array=new Array();
				array=ssystemcontent.split(",");
				$('#sign').attr("value",array[1]);
				$('#syssign').attr("value",array[1]);
				//$('#sign').attr("disabled",true);
			}
			
		}
	});
});
/*===========================================Gorgeous split-line==============================================*/

/**
 * main logic
 */
$(function(){
	var operate=$.query.get('operate');
	if(operate=="add"){
		findSystemcontent();//这个方法要同步
		getAllTemplate();
		return;
	}else if(operate=="edit"){
		findSystemcontent();//这个方法要同步
		getAllTemplate();
		findTemplatesetTBytsid();
		return;
	}
});


/*===========================================Gorgeous split-line==============================================*/
/**
 * flexigrid list 
 */
$(function() {
	$("#templatesetmanagement").flexigrid( {
		url : 'findAllTemplatesetT.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'所属主题',
			name:'themename',
			width:100,
			sortable:true,
			align:'center'
		},{ 
			display:'系统内容名称',
			name:'systemcontent',
			width:200,
			sortable:true,
			align:'center'
		},{ 
			display:'标示',
			name:'sign',
			width:150,
			sortable:true,
			align:'center'
		},{ 
			display:'状态',
			name:'status',
			width:50,
			sortable:true,
			align:'center'
		},{ 
			display:'模板文件路径',
			name:'templateurl',
			width:315,
			sortable:true,
			align:'center'
		},{ 
			display:'静态页面输出路径',
			name:'buildhtmlpath',
			width:315,
			sortable:true,
			align:'center'
		},{
			display : '创建时间',
			name : 'createtime',
			width : 130,
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
			window.location.href="templateset.jsp?operate=add&folder=setting";
			return;
		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href="templateset.jsp?operate=edit&folder=setting&tsid="+str;
				return;
			} else {
				formwarning("#alerterror","请选择一条信息");
				return false;
			}
		}else if(com=="删除"){
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("delTemplatesetT.action",{"tsid":str},function(data){
					if(data.sucflag){
						$('#templatesetmanagement').flexReload();
						forminfo("#alertinfo","删除模板文件成功");
					}
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
		if($('#zsys').is(":hidden")){
			var ssystemcontent=$('#ssystemcontent').find("option:selected").text();
			if(ssystemcontent=='-1'||ssystemcontent=='0'||ssystemcontent=='1'||ssystemcontent=='2'){
				formwarning("#alerterror","请选择系统内容");
				return false;
			}else{
				var systemcontent=ssystemcontent;
				var sign=$("#sign").val();
			}
		}else{
			var zsystemcontent=$('#zsystemcontent').val();
			if(zsystemcontent==""){
				formwarning("#alerterror","请输入系统内容");
				return false;
			}else{
				var systemcontent=zsystemcontent;
				var sign=$("#sign").val();
				if(sign==""){
					formwarning("#alerterror","请输入标示");
					return false;
				}
			}
		}
		var templateurl=$('#templateurl').val();
		if(templateurl=="-1"){
			formwarning("#alerterror","请选择模板文件");
			return false;
		}else{
			templateurl=$('#templateurl').find("option:selected").text();
		}
		var buildhtmlpath=$('#buildhtmlpath').val();
		if(buildhtmlpath==""){
			formwarning("#alerterror","请填写输出目录");
			return false;
		}
		this.value="提交中";
		this.disabled=true;
		$.post("addTemplatesetT.action",{"systemcontent":systemcontent,"buildhtmlpath":buildhtmlpath,"templateurl":templateurl,"sign":sign},function(data){
			if(data.sucflag){
				window.location.href="templatesetment.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","模板文件和系统内容设定失败");
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
	if($('#ssystemcontent').is(":hidden")){
		var systemcontent=$('#ssystemcontent1').val();
		
	}else{
		if($('#zsys').is(":hidden")){
			var ssystemcontent=$('#ssystemcontent').find("option:selected").text();
			if(ssystemcontent=='-1'||ssystemcontent=='0'||ssystemcontent=='1'||ssystemcontent=='2'){
				formwarning("#alerterror","请选择系统内容");
				return false;
			}else{
				var systemcontent=ssystemcontent;
				var sign=$("#sign").val();
			}
		}else{
			var zsystemcontent=$('#zsystemcontent').val();
			if(zsystemcontent==""){
				formwarning("#alerterror","请输入系统内容");
				return false;
			}else{
				var systemcontent=zsystemcontent;
				var sign=$("#sign").val();
				if(sign==""){
					formwarning("#alerterror","请输入标示");
					return false;
				}
			}
		}
	}
	var sign=$("#sign").val();
	if(sign==""){
		formwarning("#alerterror","请输入标示");
		return false;
	}
	var templateurl=$('#templateurl').val();
	if(templateurl=="-1"){
		formwarning("#alerterror","请选择模板文件");
		return false;
	}else{
		templateurl=$('#templateurl').find("option:selected").text();
	}
	var buildhtmlpath=$('#buildhtmlpath').val();
	if(buildhtmlpath==""){
		formwarning("#alerterror","请填写输出目录");
		return false;
	}
	var tsid=$('#tsid').val();
	this.value="更新提交中";
	this.disabled=true;
	$.post("updateTemplatesetT.action",{"systemcontent":systemcontent,"buildhtmlpath":buildhtmlpath,"templateurl":templateurl,"tsid":tsid,"sign":sign},function(data){
		if(data.sucflag){
			window.location.href="templatesetment.jsp?operate=find&folder=setting&tsid="+tsid;
		}else{
			formwarning("#alerterror","更新文件和系统内容关系失败");
			return false;
		}
	});
});

});

