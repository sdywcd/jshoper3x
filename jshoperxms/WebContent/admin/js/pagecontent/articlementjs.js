
$(function(){
	
	
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
						$('#navid').append(header);
						$('#ltypeid').hide();
						$('#stypeid').hide();
					}else{
						$('#navid').append(header).append(data.articlecategoryzero);
						$('#ltypeid').hide();
						$('#stypeid').hide();
					}
				}
			}
		});
	},
	/**
	 * 级联读取二级栏目
	 */
	$('#navid').change(function() {
		var navid = $('#navid').val();
		//navid=0表示顶级分类，navid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		if (navid != "0" && navid != "-1") {
			$.post("findArticleCategoryByparentId.action",{"parentId":navid}, function(data) {
				if (data.sucflag) {
					$('#ltypeid').html(data.articlecategorytwo);
				}
			});
		}
	});
	
	/**
	 * 级联读取二级分类对应的三级分类
	 */
	$('#ltypeid').change(function(){
		var ltypeid = $('#ltypeid').val();
		//parentid=0表示顶级分类，parentid=-1表示请选择，也就是当都不是这两个条件时执行一级栏目对应的下级栏目的搜索
		//这里再读取三级分类内容
		if (ltypeid != "0" && ltypeid != "-1") {
			$.post("findArticleCategoryByparentId.action",{"parentId":ltypeid}, function(data) {
				if (data.sucflag) {
					$('#stypeid').html(data.articlecategorytwo).show();
					
				}
			});
		}
	});

	/**
	 * 验证分类选择
	 */
	$("#navid").change(function(){
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
	 * 点击重新选择分类
	 */
	$("#reselectarticlecategory").toggle(function(){
	    	$("#selectarticlecategory").show();
	    	$("#articlecategory").hide();
	    }, function(){
	    	$("#selectarticlecategory").hide();
	    	$("#articlecategory").show();
	    });
	   
	
	/**
	 * 增加文章
	 */
	saveArticle=function(){
		var isoutsite=$("input[name='isoutsite']:checked").val();
		var outsitelink=$('#outsitelink').val();
		var title=$('#title').val();
		if(title==""){
			formwarning("#alerterror", "文章标题必须填写");
			return false;
		}
		var navid=$("#navid").val();
		if(navid=="-1"){
			formwarning("#alerterror", "请选择顶级文章分类");
			return false;
		}
		var nname=$("#navid").find("option:selected").text();
		var ltypeid=$("#ltypeid").val();
		var lname="";
		if(ltypeid=="-1"){
			ltypeid="0";
		}else{
			lname=$("#ltypeid").find("option:selected").text();
		}
		var stypeid=$("#stypeid").val();
		var sname="";
		if(stypeid=="-1"){
			stypeid="0";
		}else{
			sname=$('#stypeid').find("option:selected").text();	
		}
		var fname="";
		
		var author=$("#author").val();
		var ispublication=$("input[name='ispublication']:checked").val();
		var isrecommend=$("input[name='isrecommend']:checked").val();
		var istop=$("input[name='istop']:checked").val();
		var isnotice=$("input[name='isnotice']:checked").val();
		var mobilesync=$("input[name='mobilesync']:checked").val();
		var contentvalue=$("#contentvalue").val();
		var tipcontent=$("#tipcontent").val();
		var metaKeywords=$('#metaKeywords').val();
		var metaDes=$('#metaDes').val();
		var sort=$("#sort").val();
		 // 获主图路径集合
		var mainpicture = "";
		$(":checkbox[name='pcpath']").each(function() {
			if($(this).attr("checked")){
				mainpicture=this.value;
			}
		});
		this.value="提交中";
		this.disabled=true;
		$.post("addArticleT.action",{
			"isoutsite":isoutsite,
			"outsitelink":outsitelink,
			"navid":navid,
			"nname":nname,
			"ltypeid":ltypeid,
			"lname":lname,
			"stypeid":stypeid,
			"sname":sname,
			"fname":fname,
			"title":title,
			"author":author,
			"ispublication":ispublication,
			"isrecommend":isrecommend,
			"istop":istop,
			"isnotice":isnotice,
			"mobilesync":mobilesync,
			"contentvalue":contentvalue,
			"tipcontent":tipcontent,
			"metaKeywords":metaKeywords,
			"metaDes":metaDes,
			"sort":sort,
			"mainpicture":mainpicture
			},function(data){
			if(data.sucflag){
				window.location.href="articlement.jsp?operate=find&folder=pagecontent";
			}else{
				formwarning("#alerterror", "文章增加失败");
				return false;
			}
		});
	},
	/**
	 * 根据文章id获取文章内容
	 */
	findArticleByarticleid=function(){
		var articleid=$.query.get('articleid');
		if(articleid==""){
			return false;
		}
		$.post("findArticleByarticleid.action",{"articleid":articleid},function(data){
			if(data.bean!=null){
				$("#navid").val(data.bean.navid);
				$('#shownname').text(data.bean.nname);
				$('#showlname').text(data.bean.lname);
				$('#showsname').text(data.bean.sname);
				$('#shownavid').text(data.bean.navid);
				$('#showltypeid').text(data.bean.ltypeid);
				$('#showstypeid').text(data.bean.stypeid);
				$('#hidnavid').val(data.bean.navid);
				$('#hidnname').val(data.bean.nname);
				$('#hidltypeid').val(data.bean.ltypeid);
				$('#hidlname').val(data.bean.lname);
				$('#hidstypeid').val(data.bean.stypeid);
				$('#hidsname').val(data.bean.sname);
				$('#title').attr("value",data.bean.title);
				$('#author').attr("value",data.bean.author);
				if("1"==data.bean.ispublication){
					$("input[name='ispublication']").get(0).checked=true;
				}else{
					$("input[name='ispublication']").get(1).checked=true;
				}
				if("1"==data.bean.isrecommend){
					$("input[name='isrecommend']").get(0).checked=true;
				}else{
					$("input[name='isrecommend']").get(1).checked=true;
				}
				if("1"==data.bean.istop){
					$("input[name='istop']").get(0).checked=true;
				}else{
					$("input[name='istop']").get(1).checked=true;
				}
				if("1"==data.bean.isnotice){
					$("input[name='isnotice']").get(0).checked=true;
				}else{
					$("input[name='isnotice']").get(1).checked=true;
				}
				if("1"==data.bean.mobilesync){
					$("input[name='mobilesync']").get(0).checked=true;
				}else{
					$("input[name='mobilesync']").get(1).checked=true;
				}
				if("1"==data.bean.isoutsite){
					$("input[name='isoutsite']").get(0).checked=true;
				}else{
					$("input[name='isoutsite']").get(1).checked=true;
				}
				$("#outsitelink").attr("value",data.bean.outsitelink);
				$('#tipcontent').attr("value",data.bean.tipcontent);
				$('#sort').attr("value",data.bean.sort);
				if(data.bean.mainpicture!=""){
					 var htm = "<img id='logo' src='" + data.basepath+data.bean.mainpicture + "'/>";
			         var checkpc = "<input id='logo' name='pcpath' type='checkbox' value='" + data.bean.mainpicture+ "' checked='true' />";
			         $("#triggers").html(htm).append(checkpc);
				}
				KE.html("contentvalue",data.bean.contentvalue);
				$('#metaKeywords').attr("value",data.bean.metaKeywords);
				$('#metaDes').attr("value",data.bean.metaDes);
				$('#hidarticleid').attr("value",data.bean.articleid);
				$("#articlecategory").show();
				$("#modifyarticlecategory").show();
				$("#selectarticlecategory").hide();
				$("#submit").hide();
				$("#update").show();
			}
		});
		
	},
	
	/**
	 * 更新文章
	 * @returns
	 */
	updateArticleT=function(){
		var isoutsite=$("input[name='isoutsite']:checked").val();
		var outsitelink=$('#outsitelink').val();
		var articleid=$("#hidarticleid").val();
		var title=$('#title').val();
		if(title==""){
			formwarning("#alerterror", "文章标题必须填写");
			return false;
		}
		var navid="";
		var nname="";
		var ltypeid="";
		var lname="";
		var stypeid="";
		var sname="";
		var fname="";
		if(!$("#selectarticlecategory").is(":hidden")){
			navid=$("#navid").val();
			if(navid=="-1"){
				formwarning("#alerterror", "请选择顶级文章分类");
				return false;
			}
			nname=$("#navid").find("option:selected").text();
			ltypeid=$("#ltypeid").val();
			if(ltypeid=="-1"){
				ltypeid="0";
			}else{
				lname=$("#ltypeid").find("option:selected").text();
			}
			stypeid=$("#stypeid").val();
			if(stypeid=="-1"){
				stypeid="0";
			}else{
				sname=$('#stypeid').find("option:selected").text();	
			}
			
		}else{
			navid=$("#hidnavid").val();
			nname=$("#hidnname").val();
			ltypeid=$("#hidltypeid").val();
			lname=$("#hidlname").val();
			stypeid=$("#hidstypeid").val();
			sname=$("#hidsname").val();
		}
		var author=$("#author").val();
		var ispublication=$("input[name='ispublication']:checked").val();
		var isrecommend=$("input[name='isrecommend']:checked").val();
		var istop=$("input[name='istop']:checked").val();
		var isnotice=$("input[name='isnotice']:checked").val();
		var mobilesync=$("input[name='mobilesync']:checked").val();
		var contentvalue=$("#contentvalue").val();
		var tipcontent=$("#tipcontent").val();
		var metaKeywords=$('#metaKeywords').val();
		var metaDes=$('#metaDes').val();
		var sort=$("#sort").val();
		 // 获主图路径集合
		var mainpicture = "";
		$(":checkbox[name='pcpath']").each(function() {
			if($(this).attr("checked")){
				mainpicture=this.value;
			}
		});
		this.value="提交中";
		this.disabled=true;
		$.post("updateArticleT.action",{
			"isoutsite":isoutsite,
			"outsitelink":outsitelink,
			"articleid":articleid,
			"navid":navid,
			"nname":nname,
			"ltypeid":ltypeid,
			"lname":lname,
			"stypeid":stypeid,
			"sname":sname,
			"fname":fname,
			"title":title,
			"author":author,
			"ispublication":ispublication,
			"isrecommend":isrecommend,
			"istop":istop,
			"isnotice":isnotice,
			"mobilesync":mobilesync,
			"contentvalue":contentvalue,
			"tipcontent":tipcontent,
			"metaKeywords":metaKeywords,
			"metaDes":metaDes,
			"sort":sort,
			"mainpicture":mainpicture
			},function(data){
			if(data.sucflag){
				window.location.href="articlement.jsp?operate=find&folder=pagecontent";
			}else{
				formwarning("#alerterror", "文章更新失败");
				return false;
			}
		});
	},
	
	/**
	 * 保存文章
	 */
	$("#submit").click(function(){
		saveArticle();
	});
	
	$("#update").click(function(){
		updateArticleT();
	});
	
	findAllArticleT=function(){
		$("#articlemanagement").flexigrid( {
			url : 'findAllArticleT.action',
			dataType : 'json',
			cache : false,
			colModel : [ {
				display : '店铺名',
				name : 'shopname',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				display : '标题',
				name : 'title',
				width : 315,
				sortable : true,
				align : 'center'
			}, {
				display : '分类',
				name : 'articleCategoryName',
				width : 215,
				sortable : true,
				align : 'center'
			}, {
				display : '公告',
				name : 'isnotice',
				width : 115,
				sortable : true,
				align : 'center'
			}, {
				display : '发布',
				name : 'ispublication',
				width : 115,
				sortable : true,
				align : 'center'
			}, {
				display : '推荐',
				name : 'isrecommend',
				width : 115,
				sortable : true,
				align : 'center'
			}, {
				display : '置顶',
				name : 'istop',
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
			},{
				separator : true
			} ],

			searchitems : [ {
				display : '请选择搜索条件',
				name : 'sc',
				isdefault : true
			}, {
				display : '分类名称',
				name : 'name'
			} ],
			sortname : "createtime",
			sortorder : "desc",
			usepager : true,
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
				window.location.href = "article.jsp?operate=add&folder=pagecontent";
				return;

			} else if (com == '编辑') {
				if ($('.trSelected', grid).length == 1) {
					var str = $('.trSelected', grid)[0].id.substr(3);
					window.location.href = "article.jsp?operate=edit&folder=pagecontent&articleid=" + str;
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
					$.post("delArticleT.action", {
						"articleid" : str
					}, function(data) {
						$('#articlemanagement').flexReload();
					});
					return;
				} else {
					formwarning("#alerterror", "请选择要删除的信息");
					return false;
				}
			}

		}

	}
	
	
  	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		findArticlCategoryByGradeZeroone();
	}else if(operate=="edit"){
		findArticlCategoryByGradeZeroone();
		findArticleByarticleid();
	}else if(operate=="find"){
		findAllArticleT();
	}
	
	
	
	
	
});





