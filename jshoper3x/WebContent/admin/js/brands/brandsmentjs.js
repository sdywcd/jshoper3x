$(function() {
	
	/**
	 * 删除主图片和缩略图片，采用假删除
	 */
	deleteMainPicture=function(){
		var str = "";
		var sum = 0;
		//主图片遍历
		$(":checkbox[name='mainpc']").each(function() {
			if ($(this).attr("checked")) {
				sum++;
				str += this.id + ",";
			}
		});
		//主压缩图片遍历
		$(":checkbox[name='maincompresspc']").each(function(){
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
			$("#maintriggers img").remove("img[id=" + v + "]");
			$("#maintriggers input[name='mainpc']").remove("input[id=" + v + "]");
			$("#maintriggers input[name='maincompresspc']").remove("input[id=" + v + "]");
		});
	},
	$("#maindelpc").on("click",function(){
		deleteMainPicture();
	});

	/**
	 * 增加品牌
	 */
	$('#submit').click(function() {
		var brandname = $('#brandname').val();
		if (brandname == "") {
			formwarning("#alerterror","请填写品牌名称");
			return false;
		}
		var url = $('#url').val();
		//获取品牌logo路径
		var logoPath = "";
		var sum=0;
		$(":checkbox[name='mainpc']").each(function() {
			if($(this).attr("checked")){
				sum++;
				logoPath=this.value;
			}
		});
		//获取品牌logo缩略图路径
		var smallLogoPath="";
		$(":checkbox[name='maincompresspc']").each(function() {
			if($(this).attr("checked")){
				sum++;
				smallLogoPath=this.value;
			}
		});
		if(sum==0){
			formwarning("#alerterror","请选择一个LOGO");
			return false;
		}
		var sort = $('#sort').val();
		if (sort == "") {
			formwarning("#alerterror","请填写排序");
			return false;
		}
		var intro = $('#intro').val();
		var remark=$("#remark").val();
		$.post("addBrandt.action", {
			"brandname" : brandname,
			"url" : url,
			"logoPath" : logoPath,
			"smallLogoPath":smallLogoPath,
			"sort" : sort,
			"intro" : intro,
			"remark":remark
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
				//显示logo
				var mainPicture=data.bean.logoPath;
				var mainPHtml="<img id='0' src='"+data.basepath+mainPicture+"'/><input id='0' name='mainpc' type='checkbox' value='"+mainPicture+"' checked/>";
				//显示缩略图logo
				var mainSmallPicture=data.bean.smallLogoPath;
				mainPHtml+="<img id='1' src='"+data.basepath+mainSmallPicture+"'/><input id='0' name='mainpc' type='checkbox' value='"+mainSmallPicture+"' checked/>";
				$("#maintriggers").append(mainPHtml);
				$('#sort').attr("value", data.bean.sort);
				if (data.bean.intro == null) {
					KE.html("intro", "");
				} else {
					KE.html("intro", data.bean.intro);
				}
				$("#remark").val(data.bean.remark);
				$('#submit').hide();
				$('#update').show();
			}
		});
	},
	
	$('#update').click(function() {
		var brandname = $('#brandname').val();
		if (brandname == "") {
			formwarning("#alerterror","请填写品牌名称");
			return false;
		}
		var url = $('#url').val();
		//获取品牌logo路径
		var logoPath = "";
		var sum=0
		$(":checkbox[name='mainpc']").each(function() {
			if($(this).attr("checked")){
				sum++;
				logoPath=this.value;
			}
		});
		//获取品牌logo缩略图路径
		var smallLogoPath="";
		$(":checkbox[name='maincompresspc']").each(function() {
			if($(this).attr("checked")){
				sum++;
				smallLogoPath=this.value;
			}
		});
		if(sum==0){
			formwarning("#alerterror","请选择一个LOGO");
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
		findBrandById();
		return;
	}else if(operate=="add"){
		
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
		colModel : [{
			display : '店铺名称',
			name : 'shopname',
			width : 200,
			sortable : true,
			align : 'center'
		}, {
			display : '商品品牌名称',
			name : 'brandname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '排序',
			name : 'sort',
			width : 80,
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
