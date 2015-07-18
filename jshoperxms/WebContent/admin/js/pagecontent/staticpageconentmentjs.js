/**
 * main logic
 */
$(function() {
	/**
	 * 读取商品一级分类
	 */
	findGoodsCategoryByGradeZeroone = function() {
		$.ajax({
			url : "findGoodsCategoryByGradeZeroone.action",
			type : "post",
			dataType : 'json',
			async : false,
			success : function(data) {
				if (data.sucflag) {
					var header = "<option value='-1'>---请选择---</option>";
					if (data.goodscategoryzero == "") {
						$('#navid').append(header);
						$('#ltypeid').hide();
						$('#stypeid').hide();
					} else {
						$('#navid').append(header).append(
								data.goodscategoryzero);
						$('#ltypeid').hide();
						$('#stypeid').hide();
					}

				}
			}
		});
	},
	/**
	 * 级联读取一级分类的二级栏目
	 */
	$('#navid').change(function() {
		var navid = $('#navid').val();
		// navid=0表示顶级分类，navid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		// 这里再读取二级分类内容
		if (navid != "0" && navid != "-1") {
			$.post("findGoodscategoryByparentId.action", {
				"parentId" : navid
			}, function(data) {
				if (data.sucflag) {
					$('#ltypeid').html(data.goodscategorytwo);
				}
			});
		}
	});
	/**
	 * 级联读取二级分类对应的三级分类
	 */
	$('#ltypeid').change(function() {
		var ltypeid = $('#ltypeid').val();
		// parentid=0表示顶级分类，parentid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		// 这里再读取三级分类内容
		if (ltypeid != "0" && ltypeid != "-1") {
			$.post("findGoodscategoryStypeid.action", {
				"parentId" : ltypeid
			}, function(data) {
				if (data.sucflag) {
					$('#stypeid').html(data.stypeidlist).show();

				}
			});
		}
	});
	/**
	 * 验证分类选择
	 */
	$("#navid").change(function() {
		var navid = $('#navid').val();
		var ltypeid = $('#ltypeid').val();
		var stypeid = $('#stypeid').val();
		if (navid == '-1') {
			$('#ltypeid').hide();
			$('#stypeid').hide();
		} else {
			$('#ltypeid').show();
		}
		if (ltypeid == "-1") {
			$('#stypeid').hide();
		}
	});

	/**
	 * 重新生成模板文件
	 */
	$("#recreatetemplate").on("click",function(){
		$.post("recreateTemplate.action",function(data){
			if(data.sucflag){
				forminfo("#alertinfo","更新模板文件成功");
				return;
			}
		});
	});
	
	/**
	 * 全站静态化
	 */
	$("#startbuildallhtml").on("click",function(){
		$.post("buildAllHtml.action", function(data) {
			forminfo("#alertinfo","全站静态化正在执行，请等待一会查看前台相应页面");
			return;
		});
	});
	/**
	 * 静态化首页
	 */
	$("#startbuildindexhtml").on("click",function(){
		$.post("buildIndexHtml.action", function(data) {
			forminfo("#alertinfo","首页静态化正在执行，请等待一会查看前台相应页面");
		});
	});

	/**
	 * 按照商品分类静态化商品
	 */
	$("#startbuildgoodshtml").on("click", function() {
		var navid = $('#navid').val();
		if (navid === "-1") {
			formwarning("#alerterror", "请选择商品分类");
			return false;
		}
		var ltypeid = $('#ltypeid').val();
		var stypeid = $('#stypeid').val();
		$.post("buildGoodsdetailHtml.action", {
			"navid" : navid,
			"ltypeid":ltypeid,
			"stypeid":stypeid
		}, function(data) {
			if (data.sucflag) {
				forminfo("#alertinfo", "商品静态页正在生成，请等待一会查看前台相应页面");
			}
		});
	});
	/**
	 * 静态化所有商品详情页
	 */
	$("#startbuildallgoodshtml").on('click',function(){
		$.post("buildAllGoodsdetailHtml.action",function(data) {
			if (data.sucflag) {
				forminfo("#alertinfo", "所有商品静态页正在生成，请等待一会查看前台相应页面");
			}
		});
	});
	
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
					var header="<option value='-1'>---请选择---</option>";
					if(data.articlecategoryzero==""){
						$('#articlenavid').append(header);
						$('#articleltypeid').hide();
						$('#articlestypeid').hide();
					}else{
						$('#articlenavid').append(header).append(data.articlecategoryzero);
						$('#articleltypeid').hide();
						$('#articlestypeid').hide();
					}
				}
			}
		});
	},
	/**
	 * 级联读取二级栏目
	 */
	$('#articlenavid').change(function() {
		var navid = $('#articlenavid').val();
		//navid=0表示顶级分类，navid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		if (navid != "0" && navid != "-1") {
			$.post("findArticleCategoryByparentId.action",{"parentId":navid}, function(data) {
				if (data.sucflag) {
					$('#articleltypeid').html(data.articlecategorytwo);
				}
			});
		}
	});
	
	/**
	 * 级联读取二级分类对应的三级分类
	 */
	$('#articleltypeid').change(function(){
		var ltypeid = $('#articleltypeid').val();
		//parentid=0表示顶级分类，parentid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		//这里再读取三级分类内容
		if (ltypeid != "0" && ltypeid != "-1") {
			$.post("findArticleCategoryByparentId.action",{"parentId":ltypeid}, function(data) {
				if (data.sucflag) {
					$('#articlestypeid').html(data.articlecategorytwo).show();
					
				}
			});
		}
	});

	/**
	 * 验证分类选择
	 */
	$("#articlenavid").change(function(){
		var navid = $('#articlenavid').val();
		var ltypeid = $('#articleltypeid').val();
		var stypeid = $('#articlestypeid').val();
		if (navid == '-1') {
			$('#articleltypeid').hide();
			$('#articlestypeid').hide();
		} else {
			$('#articleltypeid').show();
		}
		if (ltypeid == "-1") {
			$('#articlestypeid').hide();
		}
	});
	
	/**
	 * 按照文章分类静态化文章
	 */
	$("#startbuildarticleshtml").on("click", function() {
		var navid = $('#articlenavid').val();
		if (navid === "-1") {
			formwarning("#alerterror", "请选择文章分类");
			return false;
		}
		var ltypeid = $('#articleltypeid').val();
		var stypeid = $('#articlestypeid').val();
		$.post("buildArticledetailHtml.action", {
			"navid" : navid,
			"ltypeid":ltypeid,
			"stypeid":stypeid
		}, function(data) {
			if (data.sucflag) {
				forminfo("#alertinfo", "文章静态页正在生成，请等待一会查看前台响应页面");
			}
		});
	});
	/**
	 * 静态化所有文章详情页
	 */
	$("#startbuildallarticleshtml").on('click',function(){
		$.post("buildAllArticledetailHtml.action",function(data) {
			if (data.sucflag) {
				forminfo("#alertinfo", "所有文章静态页正在生成，请等待一会查看前台响应页面");
			}
		});
	});
	
	var operate = $.query.get("operate");
	if (operate == "find") {
		findGoodsCategoryByGradeZeroone();
		findArticlCategoryByGradeZeroone();
	}
	

});
