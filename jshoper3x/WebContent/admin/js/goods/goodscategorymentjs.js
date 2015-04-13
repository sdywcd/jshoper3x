
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
	 * 读取商品一级分类
	 */
	findGoodsCategoryByGradeZeroone=function(){
		$('#addfl').show();
		$('#modfl').hide();
		$.ajax({
			url:"findGoodsCategoryByGradeZeroone.action",
			type:"post",
			dataType:'json',
			async:false,
			success:function(data){
				if (data.sucflag) {
					var header="<option value='-1'>---请选择---</option><option value='0'>顶级分类</option>";
					
					if (data.goodscategoryzero == "") {
						$('#parentId').append(header);
						$('#parentId1').hide();
					} else {
						$('#parentId').append(header).append(data.goodscategoryzero);
						$('#parentId1').hide();
					}

				}
			}
		});
	},
	/**
	 * 级联读取一级分类的二级栏目
	 */
	$('#parentId').change(function() {
		var parentId = $('#parentId').val();
		//parentid=0表示顶级分类，parentid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		if (parentId != "0" && parentId != "-1") {
			$.post("findGoodscategoryByparentId.action",{"parentId":parentId}, function(data) {
				if (data.sucflag) {
					$('#parentId1').html(data.goodscategorytwo);
				}
			});
		}
	});
	/**
	 * 获取商品类型下拉框
	 */
	findGoodsTypeTNForSelect=function(){
		$.ajax({
			url:"findGoodsTypeTNForSelect.action",
			type:"post",
			dataType:'json',
			async:false,
			success:function(data){
			if(data.goodstypetnlist!=""){
				var temp = "<option value='1'>通用商品类型</option>";
				$('#goodsTypeId').html(data.goodstypetnlist+temp);
				}
			}
		});
	},

	/**
	 * 验证分类选择
	 */
	$("#parentId").change(function() {
		var parentId = $('#parentId').val();
		var parentId1 = $('#parentId1').val();
		var parentId2 = $('#parentId2').val();
		if (parentId == '0') {
			$('#parentId1').hide();
			$('#parentId2').hide();
		} else {
			$('#parentId1').show();
		}
		if (parentId1 == "-1") {
			$('#parentId2').hide();
		}
	});
	
	

	/**
	 * 增加商品分类
	 */
	$('#submit').click(function() {
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","请填写分类名称");
			return false;
		}
		var parentId = $('#parentId').val();
		var parentName = $('#parentId').find("option:selected").text();
		var parentId1 = $('#parentId1').val();
		var parentName1 = $('#parentId1').find("option:selected").text();
		var grade="";
		if (parentId == "0") {
			grade = "0";
		} else if (parentId != "0" && parentId != "-1" && parentId1 == "-1") {
			grade = "1";

		} else if (parentId != "0" && parentId != "-1" && parentId1 != "-1") {
			grade = "2";
		} else if (parentId == "-1") {
			formwarning("#alerterror","请选择分类");
			return false;
		}
		var goodsTypeId = $('#goodsTypeId').val();
		if (goodsTypeId == "0") {
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var sort = $('#sort').val();
		if (sort == "") {
			formwarning("#alerterror","请填写排序");
			return false;
		}
		var sign = $('#sign').val();
		if (sign == "") {
			formwarning("#alerterror","请填写静态化标示");
			return false;
		}
		var metaKeywords = $('#metaKeywords').val();
		var metaDes = $('#metaDes').val();
        // 获logo路径集合
		var logoPath = "";
		$(":checkbox[name='mainpc']").each(function() {
			if($(this).attr("checked")){
				logoPath=this.value;
			}
		});
		
		//获取缩略logo路径
		var smallLogo="";
		$(":checkbox[name='maincompresspc']").each(function() {
			if($(this).attr("checked")){
				smallLogo=this.value;
			}
		});
		var mobilesync=$("input[name='mobilesync']:checked").val();
		if (grade == "0") {
			$.post("addGoodsCategory.action", {
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"goodsTypeId" : goodsTypeId,
                "logo":logoPath,
                "smallLogo":smallLogo,
                "mobilesync":mobilesync
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "goodscategoryment.jsp?operate=find&folder=goods";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		} else if (grade=="1") {
			$.post("addGoodsCategoryTwo.action", {
				"parentName" : parentName,
				"parentId" : parentId,
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"goodsTypeId" : goodsTypeId,
                "logo":logoPath,
                "smallLogo":smallLogo,
                "mobilesync":mobilesync
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "goodscategoryment.jsp?operate=find&folder=goods";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		} else if (grade=="2") {
			$.post("addGoodsCategoryThree.action", {
				"parentName1" : parentName1,
				"parentId" : parentId,
				"parentId1" : parentId1,
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"goodsTypeId" : goodsTypeId,
                "logo":logoPath,
                "smallLogo":smallLogo,
                "mobilesync":mobilesync
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "goodscategoryment.jsp?operate=find&folder=goods";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		}
	});
	
	/**
	 * 根据商品分类id获取分类信息
	 */
	findGoodscategoryBygoodscategoryId=function(){
		var goodsCategoryTid = $.query.get('goodsCategoryTid');
		if (goodsCategoryTid == "") {
			return false;
		}
		$.post("findGoodscategoryBygoodscategoryId.action", {
			"goodsCategoryTid" : goodsCategoryTid
		}, function(data) {
			if (data.bean != null) {
				$('#name').attr("value", data.bean.name);
				var grade=data.bean.grade;
				if(grade=="0"){
					$('#parentName').attr("value", "顶级分类");
				}else{
					$('#parentName').attr("value", data.bean.parentName);
				}
				$("#hidgrade").val(grade);
				$('#goodsTypeId').val(data.bean.goodsTypeId);
				$('#sign').attr("value", data.bean.sign);
				$('#sort').attr("value", data.bean.sort);
				$('#metaKeywords').attr("value", data.bean.metaKeywords);
				$('#metaDes').attr("value", data.bean.metaDes);
				$('#hidgoodsCategoryTid').attr("value", data.bean.goodsCategoryTid);
				//显示logo
				var mainPicture=data.bean.logo;
				var mainPHtml="<img id='0' src='"+data.basepath+mainPicture+"'/><input id='0' name='mainpc' type='checkbox' value='"+mainPicture+"' checked/>";
				//显示缩略图logo
				var mainSmallPicture=data.bean.smallLogo;
				mainPHtml+="<img id='1' src='"+data.basepath+mainSmallPicture+"'/><input id='0' name='maincompresspc' type='checkbox' value='"+mainSmallPicture+"' checked/>";
				$("#maintriggers").append(mainPHtml);
				
	            if(data.bean.mobilesync=="1"){
	            	$("input[name='mobilesync']").get(0).checked=true;
	            }else{
	            	$("input[name='mobilesync']").get(1).checked=true;
	            }
	            $('#submit').hide();
				$('#addfl').hide();
				$('#modfl').show();//上级分类显示区域
				$('#update').show();
			}
		});
	},
	
	
	/**
	 * 更新商品分类
	 */
	$('#update').click(function() {
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","请填写分类名称");
			return false;
		}
		var goodsTypeId = $('#goodsTypeId').val();
		if (goodsTypeId == "0") {
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var sort = $('#sort').val();
		var sign = $('#sign').val();
		var metaKeywords = $('#metaKeywords').val();
		var metaDes = $('#metaDes').val();
		var goodsCategoryTid = $('#hidgoodsCategoryTid').val();
		// 获logo路径集合
		var logoPath = "";
		$(":checkbox[name='mainpc']").each(function() {
			if($(this).attr("checked")){
				logoPath=this.value;
			}
		});
		
		//获取缩略logo路径
		var smallLogo="";
		$(":checkbox[name='maincompresspc']").each(function() {
			if($(this).attr("checked")){
				smallLogo=this.value;
			}
		});
		//这里需要重新定义
		var parentId = $('#parentId').val();
		var parentName = $('#parentId').find("option:selected").text();
		var parentId1 = $('#parentId1').val();
		var parentName1 = $('#parentId1').find("option:selected").text();
		var grade=$("#hidgrade").val();
		switch(grade){
		case "0":
			if (parentId == "0") {
				grade = "0";
				
			} else if (parentId != "0" && parentId != "-1" && parentId1 == "-1") {
				grade = "1";
				
				if(parentId===""||parentId==="-1"){
					parentName=$("#parentName").val();
				}
				
			} else if (parentId != "0" && parentId != "-1" && parentId1 != "-1") {
				grade = "2";
				if(parentId===""||parentId==="-1"){
					parentName1=$("#parentName").val();
				}
			} else if (parentId == "-1") {
				if(grade==""){
					formwarning("#alerterror","请选择分类");
					return false;
				}
			}
			break;
		case "1":
			if (parentId == "0") {
				grade = "0";
				
			} else if (parentId != "0" && parentId != "-1" && parentId1 == "-1") {
				grade = "1";
				
				if(parentId===""||parentId==="-1"){
					parentName=$("#parentName").val();
				}
				
			} else if (parentId != "0" && parentId != "-1" && parentId1 != "-1") {
				grade = "2";
				if(parentId===""||parentId==="-1"){
					parentName1=$("#parentName").val();
				}
			} else if (parentId == "-1") {
				if(grade==""){
					formwarning("#alerterror","请选择分类");
					return false;
				}
				parentName=$("#parentName").val();
			}
			break;
		case "2":
			if (parentId == "0") {
				grade = "0";
				
			} else if (parentId != "0" && parentId != "-1" && parentId1 == "-1") {
				grade = "1";
				
				if(parentId===""||parentId==="-1"){
					parentName=$("#parentName").val();
				}
				
			} else if (parentId != "0" && parentId != "-1" && parentId1 != "-1") {
				grade = "2";
				if(parentId===""||parentId==="-1"){
					parentName1=$("#parentName").val();
				}
			} else if (parentId == "-1") {
				if(grade==""){
					formwarning("#alerterror","请选择分类");
					return false;
				}
				parentName1=$("#parentName").val();
			}
			break;
		}
		
		var mobilesync=$("input[name='mobilesync']:checked").val();
		if (grade == "0") {
			$.post("updateGoodsCategory.action", {
				"goodsCategoryTid":goodsCategoryTid,
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"goodsTypeId" : goodsTypeId,
                "logo":logoPath,
                "smallLogo":smallLogo,
                "mobilesync":mobilesync
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "goodscategoryment.jsp?operate=find&folder=goods";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		} else if (grade=="1") {
			$.post("updateGoodsCategoryTwo.action", {
				"goodsCategoryTid":goodsCategoryTid,
				"parentName" : parentName,
				"parentId" : parentId,
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"goodsTypeId" : goodsTypeId,
                "logo":logoPath,
                "smallLogo":smallLogo,
                "mobilesync":mobilesync
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "goodscategoryment.jsp?operate=find&folder=goods";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		} else if (grade=="2") {
			$.post("updateGoodsCategoryThree.action", {
				"goodsCategoryTid":goodsCategoryTid,
				"parentName1" : parentName1,
				"parentId" : parentId,
				"parentId1" : parentId1,
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"goodsTypeId" : goodsTypeId,
                "logo":logoPath,
                "smallLogo":smallLogo,
                "mobilesync":mobilesync
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "goodscategoryment.jsp?operate=find&folder=goods";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		}
	});
});

/**
 * main logic
 */
$(function(){
	var operate=$.query.get("operate");
	if(operate=="edit"){
		findGoodsTypeTNForSelect();
		findGoodsCategoryByGradeZeroone();
		findGoodscategoryBygoodscategoryId();
		
	}else if(operate=="add"){
		findGoodsTypeTNForSelect();
		findGoodsCategoryByGradeZeroone();
		return;
	}
});
/*===========================================Gorgeous split-line==============================================*/

/**
 * flexigrid list 
 */
$(function() {
	$("#goodscategorymanagement").flexigrid( {
		url : 'findAllGoodsCategoryT.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '分类名称',
			name : 'name',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '上级分类',
			name : 'parentName',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '分类等级',
			name : 'grade',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '标示',
			name : 'sign',
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
			name : 'operating',
			width : 200,
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
			display : '分类名称',
			name : 'name',
			isdefault : true
		}, {
			display : '分类等级',
			name : 'grade',
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
			window.location.href = "goodscategory.jsp?operate=add&folder=goods";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "goodscategory.jsp?operate=edit&folder=goods&goodsCategoryTid=" + str;
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
				$.post("delGoodscategoryT.action", {
					"goodsCategoryTid" : str
				}, function(data) {
					if(data.sucflag){
						$('#goodscategorymanagement').flexReload();
					}else{
						formwarning("#alerterror", "请不要删除顶级分类,请通过编辑修改内容");
						$('#goodscategorymanagement').flexReload();
					}
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要删除的信息");
				return false;
			}
			
		}

	}

});
/*===========================================Gorgeous split-line==============================================*/


