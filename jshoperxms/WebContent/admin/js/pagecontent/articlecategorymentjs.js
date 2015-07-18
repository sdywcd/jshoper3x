
/**
 * flexigrid list 
 */
$(function() {
	/*
	 * 删除图片按钮
	 */
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
	
	
	$("#articlecategorymanagement").flexigrid( {
		url : 'findAllArticleCategoryT.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '店铺名',
			name : 'shopname',
			width : 200,
			sortable : true,
			align : 'center'
		}, {
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
			display : '页脚显示',
			name : 'position',
			width : 105,
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
		}],
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
		checkbox:true
	});
	function action(com, grid) {
		if (com == '添加') {
			window.location.href = "articlecategory.jsp?operate=add&folder=pagecontent";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "articlecategory.jsp?operate=edit&folder=pagecontent&articleCategoryTid=" + str;
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
				$.post("delArticleCategoryT.action", {
					"articleCategoryTid" : str
				}, function(data) {
					$('#articlecategorymanagement').flexReload();
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
/**
 * Add Function
 */
/**
 * 增加文章分类
 */
$(function() {
	$('#submit').click(function() {
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","分类名称必须填写");
			return false;
		}
		var parentId = $('#parentId').val();
		var parentName = $('#parentId').find("option:selected").text();
		var parentId1 = $('#parentId1').val();
		var parentName1 = $('#parentId1').find("option:selected").text();
		var grade = "0";
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
		var sort = $('#sort').val();
		var sign = $('#sign').val();
		if (sign == "") {
			formwarning("#alerterror","标示必须填写");
			return false;
		}
		var position = "0";
		if ($('#position').attr('checked')) {
			position = "1";
		}
		var metaKeywords = $('#metaKeywords').val();
		var metaDes = $('#metaDes').val();
		var mobilesync=$("input[name='mobilesync']:checked").val();
		 // 获logo路径集合
		var logoPath = "";
		$(":checkbox[name='pcpath']").each(function() {
			if($(this).attr("checked")){
				logoPath=this.value;
			}
		});
		if (grade == "0") {
			$.post("addArticleCategoryT.action",
			{
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"position" : position,
				"mobilesync":mobilesync,
				"logo":logoPath
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "articlecategoryment.jsp?operate=find&folder=pagecontent";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		} else if (grade="1") {
			$.post("addArticleCategoryTwo.action",

			{
				"parentName" : parentName,
				"parentId" : parentId,
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"position" : position,
				"mobilesync":mobilesync,
				"logo":logoPath
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "articlecategoryment.jsp?operate=find&folder=pagecontent";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		} else if (grade="2") {
			$.post("addArticleCategoryThree.action",
			{
				"parentName1" : parentName1,
				"parentId" : parentId,
				"parentId1" : parentId1,
				"grade" : grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"position" : position,
				"mobilesync":mobilesync,
				"logo":logoPath
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "articlecategoryment.jsp?operate=find&folder=pagecontent";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		}
	});
});
/*===========================================Gorgeous split-line==============================================*/


/**
 * Update Function
 */
$(function() {

	$('#update').click(function() {
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","分类名称必须填写");
			return false;
		}
		var sort = $('#sort').val();
		var sign = $('#sign').val();
		var position = "0";
		if ($('#position').attr('checked')) {
			position = "1";
		} else {
			position = "0";
		}
		var metaKeywords = $('#metaKeywords').val();
		var metaDes = $('#metaDes').val();
		var articleCategoryTid = $('#hidarticleCategoryTid').val();
		//这里需要重新定义
		var parentId = $('#parentId').val();
		var parentName = $('#parentId').find("option:selected").text();
		var parentId1 = $('#parentId1').val();
		var parentName1 = $('#parentId1').find("option:selected").text();
		var grade=$("#hidgrade").val();
		if (parentId == "0") {
			grade = "0";
		} else if (parentId != "0" && parentId != "-1" && parentId1 == "-1") {
			grade = "1";

		} else if (parentId != "0" && parentId != "-1" && parentId1 != "-1") {
			grade = "2";
		} else if (parentId == "-1") {
			if(grade==""){
				formwarning("#alerterror","请选择分类");
				return false;
			}
		}
		var mobilesync=$("input[name='mobilesync']:checked").val();
		// 获logo路径集合
		var logoPath = "";
		$(":checkbox[name='pcpath']").each(function() {
			if($(this).attr("checked")){
				logoPath=this.value;
			}
		});
		if (grade == "0") {
			$.post("updateArticleCategory.action",{
				"grade":grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"articleCategoryTid" : articleCategoryTid,
				"position" : position,
				"mobilesync":mobilesync,
				"logo":logoPath
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "articlecategoryment.jsp?operate=find&folder=pagecontent";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		}else if(grade=="1"){
			$.post("updateArticleCategoryTwo.action",{
				"grade":grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"articleCategoryTid" : articleCategoryTid,
				"position" : position,
				"parentName" : parentName,
				"parentId" : parentId,
				"mobilesync":mobilesync,
				"logo":logoPath
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "articlecategoryment.jsp?operate=find&folder=pagecontent";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		}else if(grade=="2"){
			$.post("updateArticleCategoryThree.action",{
				"grade":grade,
				"metaKeywords" : metaKeywords,
				"metaDes" : metaDes,
				"name" : name,
				"sort" : sort,
				"sign" : sign,
				"articleCategoryTid" : articleCategoryTid,
				"position" : position,
				"parentName1" : parentName1,
				"parentId" : parentId,
				"parentId1" : parentId1,
				"mobilesync":mobilesync,
				"logo":logoPath
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "articlecategoryment.jsp?operate=find&folder=pagecontent";
				} else {
					formwarning("#alerterror","分类名称或者标示不能和其他分类和标示重复");
					return false;
				}
			});
		}
		
		
		
	});
});
/*===========================================Gorgeous split-line==============================================*/

$(function(){

	  findArticleCategoryByarticleCategoryTid=function(){
		  var articleCategoryTid = $.query.get('articleCategoryTid');
			if (articleCategoryTid == "") {
				return false;
			}
		  $.post("findArticleCategoryByarticleCategoryTid.action", {
				"articleCategoryTid" : articleCategoryTid
			}, function(data) {
				if (data.bean != null) {
					$('#submit').hide();
					$('#update').show();
					$('#name').attr("value", data.bean.name);
					var grade=data.bean.grade;
					if(grade=="0"){
						$('#parentName').attr("value", "顶级分类");
					}else{
						$('#parentName').attr("value", data.bean.parentName);
					}
					$("#hidgrade").val(grade);
					$('#sign').attr("value", data.bean.sign);
					$('#sort').attr("value", data.bean.sort);
					$('#metaKeywords').attr("value", data.bean.metaKeywords);
					$('#metaDes').attr("value", data.bean.metaDes);
					if (data.bean.position == "1") {
						$("#position").attr("checked", true);
					} else {
						$("#position").attr("checked", false);
					}
					if(data.bean.logo!=""){
						 var htm = "<img id='logo' src='" + data.basepath+data.bean.logo + "'/>";
				         var checkpc = "<input id='logo' name='pcpath' type='checkbox' value='" + data.bean.logo+ "' checked='true' />";
				         $("#triggers").html(htm).append(checkpc);
					}
		            if(data.bean.mobilesync=="1"){
		            	$("input[name='mobilesync']").get(0).checked=true;
		            }else{
		            	$("input[name='mobilesync']").get(1).checked=true;
		            }
					$('#hidarticleCategoryTid').attr("value", data.bean.articleCategoryTid);
				}
			});
	  },
	  /**
		 * 读取文章一级分类
		 */
		findArticlCategoryByGradeZeroone=function(){
			$.ajax({
				url:"findArticlCategoryByGradeZeroone.action",
				type:"post",
				dataType:'json',
				async:false,
				success:function(data){
					if(data.sucflag){
						var header="<option value='-1'>---请选择---</option><option value='0'>顶级分类</option>";
						if(data.articlecategoryzero==""){
							$('#parentId').append(header);
							$('#parentId1').hide();
						}else{
							$('#parentId').append(header).append(data.articlecategoryzero);
							$('#parentId1').hide();
						}
					}
				}
			});
		},
		/**
		 * 级联读取二级栏目
		 */
		$('#parentId').change(function() {
			var parentId = $('#parentId').val();
			//parentid=0表示顶级分类，parentid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
			if (parentId != "0" && parentId != "-1") {
				$.post("findArticleCategoryByparentId.action",{"parentId":parentId}, function(data) {
					if (data.sucflag) {
						$('#parentId1').html(data.articlecategorytwo);
					}
				});
			}
		});
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
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		findArticlCategoryByGradeZeroone();
			
	}else if(operate=="edit"){
		findArticlCategoryByGradeZeroone();
		findArticleCategoryByarticleCategoryTid();
	}
	
});



