$(function() {
	/**
	 * 获取商品类型下拉框
	 */
	findGoodsTypeTNForSelect = function() {
		$.ajax({
			url : "findGoodsTypeTNForSelect.action",
			type : "post",
			dataType : 'json',
			async : false,
			success : function(data) {
				if (data.goodstypetnlist != "") {
					var temp = "<option value='1'>通用商品类型</option>";
					$('#goodsTypeId').html(data.goodstypetnlist + temp);
				}
			}
		});
	},
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
					var header="<option value='-1'>---请选择---</option>";
					if (data.goodscategoryzero == "") {
						$('#parentId').append(header);
						$('#parentId1').hide();
						$('#parentId2').hide();
					} else {
						$('#parentId').append(header).append(data.goodscategoryzero);
						$('#parentId1').hide();
						$('#parentId2').hide();
					}

				}
			}
		});
	},
	/**
	 * 根据传入的商品类型id获取商品属性select类型的
	 */
	findGoodsAttributeTBygoodsTypeId = function(val) {
		$.post("findGoodsAttributeTBygoodsTypeId.action", {
			"goodsTypeId" : val
		}, function(data) {
			if (data.sucflag) {
				$('#gat').text("");
				var gathtmlheader="<div class='well'><h4>商品属性选择区域</h4></div>";
				var gathtml = "";
				var gathtmlfooter="</div>";
				var option = "";
				var attributelist = new Array();
				var length;
				if (data.gatbeanlist != null) {
					$.each(data.gatbeanlist, function(i, item) {
						attributelist = item.attributelist.split(",");
						length=attributelist.length;
						option = "<option value='0'>---请选择---</option>";
						for ( var j = 0; j <length ; j++) {
							option += "<option value='" + attributelist[j]+ "'>" + attributelist[j] + "</option>";
						}
						gathtml += "<div class='form-inline'>"
								+ "<span class='label label-required'>"
								+ item.goodsattributename + "</span>"
								+ "<select id='goodsAttrVal" + i
								+ "' name='goodsAttrVal" + i + "'>" + option
								+ "</select>" + "</div>";
						option = "";
					});
					$('#gat').append(gathtmlheader).append(gathtml).append(gathtmlfooter).show();
				}
			}
		});
	},
	/**
	 * 获取所有商品品牌列表
	 */
	findAllBrandtjson=function(data){
		$.post("findAllBrandtjson.action",function(data){
			if(data.sucflag){
				var header="<option value='0'>---请选择---</option>";
				$("#brandname").append(header).append(data.brandjson);
			}else{
				$("#brandname").append(header);
			}
		});
	},
	/**
	 * 获取所有产品规格值列表
	 */
	findAllSpecificationsforjson=function(data){
		$.post("findAllSpecificationsforjson.action",function(data){
			if(data.sucflag){
				var header="<option value='0'>---请选择---</option><option value='1'>默认规格</option>";
				var body="";
				$(data.specificationList).each(function(k,v){
					body+="<option value='"+v.specificationsid+"'>"+v.name+"</option>";
				});
				$("#isSpecificationsOpen").append(header).append(body);
			}
		});
	},
	
	/**
	 * 当规格选择时动态加载产品信息填充区域
	 */
	$("#isSpecificationsOpen").change(function(){
		var isSpecificationsOpen=$("#isSpecificationsOpen").val();
		if(isSpecificationsOpen=="0"){
			$("#specificationsarea").hide();
			return false;
		}
		if(isSpecificationsOpen=="1"){
			//加载默认产品结构信息，即不包括任何规格值，表示商品信息对应一个产品
			$("#specificationsarea").show();
			var specificationsname=$("#isSpecificationsOpen").find("option:selected").text();
			$("#spname").text(specificationsname);
		}
	});
	
	
	/*
	 * 当商品类型被选择时调用动态加载商品属性方法
	 */
	$('#goodsTypeId').change(function(){
		var goodsTypeId=$('#goodsTypeId').val();
		findGoodsAttributeTBygoodsTypeId(goodsTypeId);
	});
	/**
	 * 级联读取一级分类的二级栏目
	 */
	$('#parentId').change(function() {
		var parentId = $('#parentId').val();
		//parentid=0表示顶级分类，parentid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		//这里再读取二级分类内容
		if (parentId != "0" && parentId != "-1") {
			$.post("findGoodscategoryByparentId.action",{"parentId":parentId}, function(data) {
				if (data.sucflag) {
					$('#parentId1').html(data.goodscategorytwo);
				}
			});
		}
	});
	/**
	 * 级联读取二级分类对应的三级分类
	 */
	$('#parentId1').change(function(){
		var parentId = $('#parentId1').val();
		//parentid=0表示顶级分类，parentid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		//这里再读取三级分类内容
		if (parentId != "0" && parentId != "-1") {
			$.post("findGoodscategoryStypeid.action",{"parentId":parentId}, function(data) {
				if (data.sucflag) {
					$('#parentId2').html(data.stypeidlist).show();
					
				}
			});
		}
	});
	
	
	/**
	 * 验证分类选择
	 */
	$("#parentId").change(function() {
		var parentId = $('#parentId').val();
		var parentId1 = $('#parentId1').val();
		var parentId2 = $('#parentId2').val();
		if (parentId == '-1') {
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
		findGoodsTypeTNForSelect();
		findGoodsCategoryByGradeZeroone();
		findAllBrandtjson();
		findAllSpecificationsforjson();
	}
});

/**
 * flexigrid list
 */
$(function() {
	$("#goodsmanagement").flexigrid({
		url : 'findAllGoods.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '商品名称',
			name : 'goodsname',
			width : 500,
			sortable : true,
			align : 'center'
		}, {
			display : '商品编号',
			name : 'usersetnum',
			width : 150,
			sortable : true,
			align : 'center'
		}, {
			display : '会员价',
			name : 'memberprice',
			width : 120,
			sortable : true,
			align : 'center'
		}, {
			display : '分类',
			name : 'sname',
			width : 150,
			sortable : true,
			align : 'center'
		}, {
			display : '上架',
			name : 'salestate',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '新品',
			name : 'isNew',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '特价',
			name : 'bargainprice',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '热销',
			name : 'hotsale',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '推荐',
			name : 'recommended',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '库存',
			name : 'quantity',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '操作',
			name : 'operating',
			width : 110,
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
			bclass : 'delete',
			onpress : action
		}, {
			name : '上架',
			bclass : 'add',
			onpress : action
		}, {
			name : '下架',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记特价',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记热销',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记推荐',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记新品',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记移动平台',
			bclass : 'add',
			onpress : action
		}, {
			name : '重置标记',
			bclass : 'add',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '商品名称',
			name : 'goodsname'
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
			window.location.href = "goods.jsp?operate=add&folder=goods";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str = this.id.substr(3);
				});
				window.location.href = "goods.jsp?operate=edit&folder=goods&goodsid="
						+ str;
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
				$.post("delGoods.action", {
					"goodsid" : str
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "删除商品成功");
					}
				});
			} else {
				formwarning("#alerterror", "请选择要删除的信息");
				return false;
			}
		} else if (com == '标记特价') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var bargainprice = "1";
				$.post("updateGoodsbargainprice.action", {
					"goodsid" : str,
					"bargainprice" : bargainprice
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "标记特价成功");
					}
				});

			} else {
				formwarning("#alerterror", "请选择要标记特价的信息");
				return false;
			}
		} else if (com == '标记热销') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var hotsale = "1";
				$.post("updateGoodshotsale.action", {
					"goodsid" : str,
					"hotsale" : hotsale
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "标记热销成功");
					}
				});

			} else {
				formwarning("#alerterror", "请选择要标记热销的信息");
				return false;
			}
		} else if (com == '标记推荐') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var recommended = "1";
				$.post("updateGoodsrecommended.action", {
					"goodsid" : str,
					"recommended" : recommended
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "标记推荐成功");
					}
				});

				return;
			} else {
				formwarning("#alerterror", "请选择要标记推荐的信息");
				return false;
			}
		} else if (com == '标记新品') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var isNew = "1";
				$.post("updateGoodsisNew.action", {
					"goodsid" : str,
					"isNew" : isNew
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "标记新品成功");
					}
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要标记新品的信息");
				return false;
			}
		} else if (com == '标记移动平台') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var ismobileplatformgoods = "1";
				$.post("updateGoodsismobileplatformgoods.action", {
					"goodsid" : str,
					"ismobileplatformgoods" : ismobileplatformgoods
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "标记移动平台成功");
					}
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要标记移动平台的信息");
				return false;
			}
		} else if (com == '重置标记') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var recommended = "0";
				var hotsale = "0";
				var bargainprice = "0";
				var isNew = "0";
				var ismobileplatformgoods = "0";
				$.post("updateFiveGoodsState.action", {
					"goodsid" : str,
					"recommended" : recommended,
					"hotsale" : hotsale,
					"bargainprice" : bargainprice,
					"isNew" : isNew,
					"ismobileplatformgoods" : ismobileplatformgoods
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "重置标记成功");
					}
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要重置标记的信息");
				return false;
			}
		} else if (com == '上架') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var salestate = "1";
				$.post("updateGoodsSaleState.action", {
					"goodsid" : str,
					"salestate" : salestate
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "上架成功");
					}
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要上架的信息");
				return false;
			}
		} else if (com == '下架') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				var salestate = "0";
				$.post("updateGoodsSaleState.action", {
					"goodsid" : str,
					"salestate" : salestate
				}, function(data) {
					if (data.sucflag) {
						$('#goodsmanagement').flexReload();
						forminfo("#alertinfo", "下架成功");
					}
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要下架的信息");
				return false;
			}

		}

	}
});
