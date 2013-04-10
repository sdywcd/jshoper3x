

/**
 * flexigrid list
 */
$(function() {
	$("#goodsunitmanagement").flexigrid( {
		url : 'findAllGoodsunit.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'商品单位名称',
			name:'unitname',
			width:215,
			sortable:true,
			align:'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'
				
		},{ display:'创建者编号',
			name:'creatorid',
			width:200,
			sortable:true,
			align:'center'
		}],
		buttons : [{
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name : '编辑',
			bclass : 'edit',
			onpress : action
		},{
			name:'删除',
			bclass:'delete',
			onpress:action
		},{
			separator : true
		} ],

		searchitems : [ {
			display : '商品单位名称',
			name : 'unitname',
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
		width :'auto',
		height : 200,
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox : true
	});

	function action(com, grid) {
		if (com == '添加') {
			$("#submit").show();
			$("#modify").hide();
			return;

		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if(r){
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("findGoodsunitById.action",{"unitid":str},function(data){
							$("#submit").hide();
							$("#modify").show();
							$("#unitname").attr("value",data.beanlist.unitname);
							$("#unitid").attr("value",data.beanlist.unitid);
							return;
						});
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=='删除'){
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("DelGoodsunit.action",{"unitid":str},function(data){
							$('#goodsunitmanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
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
 * Update Function
 */
//点击编辑更新内容
$(function(){
	$("#modify").click(function(){
		var unitid=$("#unitid").val();
		var unitname=$("#unitname").val();
		$.post("UpdateGoodsunit.action",{"unitid":unitid,"unitname":unitname},function(data){
			$('#goodsunitmanagement').flexReload();
		});
	});
});