$(function() {
	
	$("#delpc").click(function() {
		var str = "";
		var sum = 0;
		$(":checkbox[name='pcpath']").each(function() {
			if ($(this).attr("checked")) {
				sum++;
				str += this.id + ",";
			}
		});
		if (sum == 0) {
			alert('只有在选择图片后才能删除');
			return false;
		}
		var array = new Array();
		array = str.split(",");
		$(array).each(function(k, v) {
			$("#triggers img").remove("img[id=" + v + "]");
			$("#triggers input[name='pcpath']").remove("input[id=" + v + "]");
		});
	});
	/*
	 * Get Goods Type for select elements
	 */
	findGoodsTypeTNForSelect=function(){
		$.ajax({
			url:"findGoodsTypeTNForSelect.action",
			type:"post",
			dataType:'json',
			async:false,
			success:function(data){
			if(data.goodstypetnlist!=""){
				$('#goodstypetn').append(data.goodstypetnlist);
				}
			}
		});
	},
	/**
	 * 增加品牌
	 */
	$('#submit').click(function() {
		var goodsTypeId=$('#goodstypetn').val();
		if(goodsTypeId=="0"){
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var goodsTypeName=$('#goodstypetn').find("option:selected").text();
		var brandname = $('#brandname').val();
		if (brandname == "") {
			formwarning("#alerterror","请填写品牌名称");
			return false;
		}
		var url = $('#url').val();
		// 获logo路径集合
		var logoPath = "";
		var sum=0;
		$(":checkbox[name='pcpath']").each(function() {
			if($(this).attr("checked")){
				sum++;
				logoPath=this.value;
			}
		});
		var sort = $('#sort').val();
		if (sort == "") {
			formwarning("#alerterror","请填写排序");
			return false;
		}
		var intro = $('#intro').val();
		$.post("addBrandt.action", {
			"brandname" : brandname,
			"url" : url,
			"logoPath" : logoPath,
			"sort" : sort,
			"intro" : intro,
			"goodsTypeId":goodsTypeId,
			"goodsTypeName":goodsTypeName
		}, function(data) {
			if (data.sucflag) {
				window.location.href = "brandsment.jsp?operate=find&folder=goods";
			}
		});
	});
	
	/**
	 * 获取品牌详细
	 */
	findBrandById=function(){
		var brandid = $.query.get('brandid');
		if (brandid == "") {
			return false;
		}
		$.post("findBrandById.action",{"brandid" : brandid},function(data) {
			if (data.sucflag) {
				$('#brandname').attr("value", data.bean.brandname);
				$('#url').attr("value", data.bean.url);
				$('#hidbrandid').attr("value", data.bean.brandid);
				if (data.bean.logoPath == "") {
					return;
				}else{
					
					var htm = "<img id='logoPath' src='../.."
							+ data.bean.logoPath + "'/>";
					var checkpc = "<input id='logoPath' name='pcpath' type='checkbox' value='"
							+ data.bean.logoPath
							+ "' checked />";
					$("#triggers").html(htm).append(checkpc);
				}
				$('#sort').attr("value", data.bean.sort);
				if (data.bean.intro == null) {
					KE.html("intro", "");
				} else {
					KE.html("intro", data.bean.intro);
				}
				$("#goodstypetn").val(data.goodsTypeId);
				$('#submit').hide();
				$('#update').show();
			}
		});
	},
	
	$('#update').click(function() {
		var goodsTypeId=$('#goodstypetn').val();
		if(goodsTypeId=="0"){
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var goodsTypeName=$('#goodstypetn').find("option:selected").text();
		var brandname = $('#brandname').val();
		if (brandname == "") {
			formwarning("#alerterror","请填写品牌名称");
			return false;
		}
		var url = $('#url').val();
		// 获logo路径集合
		var logoPath = "";
		var sum=0;
		$(":checkbox[name='pcpath']").each(function() {
			if($(this).attr("checked")){
				sum++;
				logoPath=this.value;
			}
		});
		if(sum==0){
			formwarning("#alerterror","请选择一个商店LOGO");
			return false;
		}
		var sort = $('#sort').val();
		if (sort == "") {
			formwarning("#alerterror","请填写排序");
			return false;
		}
		var intro = $('#intro').val();
		var hidbrandid = $('#hidbrandid').val();
		$.post("updateBrandt.action", {
			"brandid" : hidbrandid,
			"brandname" : brandname,
			"url" : url,
			"logoPath" : logoPath,
			"sort" : sort,
			"intro" : intro,
			"goodsTypeId":goodsTypeId,
			"goodsTypeName":goodsTypeName
		}, function(data) {
			if (data.sucflag) {
				window.location.href = "brandsment.jsp?operate=find&folder=goods";
			}
		});
	});
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

$(function(){
	var operate = $.query.get("operate");
	if (operate == "edit") {
		findGoodsTypeTNForSelect();
		findBrandById();
		return;
	}else if(operate=="add"){
		findGoodsTypeTNForSelect();
		return;
	}
});
/*
 * 
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * flexigrid list
 */
$(function() {
	$("#brandsmanagement").flexigrid({
		url : 'findAllBrandt.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '商品品牌名称',
			name : 'brandname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '排序',
			name : 'sort',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'

		}, {
			display : '创建者编号',
			name : 'creatorid',
			width : 200,
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
		}, {
			display : '商品品牌名称',
			name : 'brandname'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		showToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox : true
	});
	function action(com, grid) {
		if (com == '添加') {
			window.location.href = "brands.jsp?operate=add&folder=goods";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "brands.jsp?operate=edit&folder=goods&brandid="+ str;
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
				$.post("delBrandt.action", {
					"brandid" : str
				}, function(data) {
					$('#brandsmanagement').flexReload();
					forminfo("#alertinfo", "删除品牌成功");
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要删除的信息");
				return false;
			}

		}

	}

});
