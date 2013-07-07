/**
 * ui
 */


/*===========================================Gorgeous split-line==============================================*/

/**
 * Global variables
 */
var session ="true";
/*===========================================Gorgeous split-line==============================================*/

/**
 * Required to initialize the page data
 */
/**
 * 切换到重新选择文章分类
 */
$(function(){
	$('#modifycategory').toggle(function(){
		$('#addfl').show();
	},function(){
		$('#addfl').hide();
	}
);
});

/**
 * 读取商品一级分类
 */
$(function(){
	$('#addfl').show();
	$('#modfl').hide();
	var articleCategoryTid=$.query.get('articleCategoryTid');
	if(articleCategoryTid==""){
		$.post("findArticlCategoryByGradeZeroone.action",function(data){
			if(data.sucflag){
				if(data.articlecategoryzero==""){
					$('#parentId').append("<option value='0'>顶级分类</option>");
					$('#parentId1').hide();
				}else{
					$('#parentId').append(data.articlecategoryzero);
					$('#parentId1').hide();
				}
				
			}
		});
	}

	/**
	 * 级联读取二级栏目
	 */
	$('#parentId').change(function(){
		var parentId=$('#parentId').val();
		if(parentId!="0"&&parentId!="-1"){
			$.post("findArticleCategoryByGradeTwo.action",function(data){
				if(data.sucflag){
					$('#parentId1').html(data.articlecategorytwo);
				}
			});
		}
	});
});


/**
 * 验证分类选择
 */
$(function(){
	$("#parentId").change(function(){
		var parentId=$('#parentId').val();
		var parentId1=$('#parentId1').val();
		var parentId2=$('#parentId2').val();
		if(parentId=='0'){
			$('#parentId1').hide();
			$('#parentId2').hide();
		}else{
			$('#parentId1').show();
		}
		if(parentId1=="-1"){
			$('#parentId2').hide();
		}
	});
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * flexigrid list 
 */
$(function() {
	$("#articlemanagement").flexigrid( {
		url : 'findAllArticleT.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
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
			bclass : 'delete',
			onpress : action
		}, {
			name : '生成PDF文件',
			bclass : 'edit',
			onpress : action
		}, {
			name : '下载PDF文件',
			bclass : 'edit',
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
			window.location.href = "addarticle.jsp?session="+session+"#pagecontent";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addarticle.jsp?session="+session+"#pagecontent&articleid=" + str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		} else if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delArticleT.action", {
							"articleid" : str
						}, function(data) {
							$('#articlemanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
	
		}else if(com=="生成PDF文件"){
			if($('.trSelected',grid).length==1){
				jConfirm('确定生成此项?','信息提示',function(r){
					if(r){
						var str=$('.trSelected',grid)[0].id.substr(3);
						$.post("PDF.action",{"articleid":str},function(){
							$('#articlemanagement').flexReload();
						});
					}
					
				});
				return ;
			}else{
				jAlert('请选择要生成的信息!', '信息提示');
				return false;
			}
			
		}else if(com=="下载PDF文件"){
			if($('.trSelected',grid).length==1){
				jConfirm('确定下载此项?','信息提示',function(r){
					if(r){
						var str=$('.trSelected',grid)[0].id.substr(3);
                        window.location.href="download.action?articleid="+str;
                        $('#articlemanagement').flexReload();
					}
					
				});
				return ;
			}else{
				jAlert('请选择要下载的信息!', '信息提示');
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
$(function(){
	$('#submit').click(function(){
		var title=$('#title').val();
		if(title==""){
			jAlert('文章标题必须填写', '信息提示');
			return false;
		}
		var parentId=$('#parentId').val();
		var parentName=$('#parentId').find("option:selected").text();
		var parentId1=$('#parentId1').val();
		var parentName1=$('#parentId1').find("option:selected").text();
		if(parentId=="0"){
			var articleCategoryTid="0";
			var articleCategoryName=parentName;
		}else if(parentId!="0"&&parentId!="-1"&&parentId1=="-1"){
			var articleCategoryTid=parentId;
			var articleCategoryName=parentName;
		}else if(parentId!="0"&&parentId!="-1"&&parentId1!="-1"){
			var articleCategoryTid=parentId1;
			var articleCategoryName=parentName1;
		}else if(parentId=="-1"){
			jAlert('请选择分类', '信息提示');
			return false;
		}
		var author=$("#author").val();
		if($("#ispublication").attr('checked')){
			var ispublication="1";
		}else{
			var ispublication="0";
		}
		if($("#isrecommend").attr('checked')){
			var isrecommend="1";
		}else{
			var isrecommend="0";
		}
		if($("#istop").attr('checked')){
			var istop="1";
		}else{
			var istop="0";
		}
		if($("#isnotice").attr('checked')){
			var isnotice="1";
		}else{
			var isnotice="0";
		}
		var pageCount=1;
		var contentvalue=$("#contentvalue").val();
		var metaKeywords=$('#metaKeywords').val();
		var metaDes=$('#metaDes').val();
		$.post("addArticleT.action",{"articleCategoryTid":articleCategoryTid,"articleCategoryName":articleCategoryName,"metaKeywords":metaKeywords,"metaDes":metaDes,"title":title,"contentvalue":contentvalue,"author":author,"ispublication":ispublication,"isrecommend":isrecommend,"istop":istop,"pageCount":pageCount,"isnotice":isnotice},function(data){
			if(data.sucflag){
				window.location.href="articlemanagement.jsp?session="+session+"#pagecontent";
			}else{
				jAlert('文章增加失败', '信息提示');
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
	var articleid=$.query.get('articleid');
	if(articleid==""){
		return false;
	}
	$.post("findArticleByarticleid.action",{"articleid":articleid},function(data){
		if(data.bean!=null){
			$('#submit').hide();
			$('#addfl').hide();
			$('#modfl').show();
			$('#modify').show();
			$('#title').attr("value",data.bean.title);
			$('#parentName').attr("value",data.bean.articleCategoryName);
			$('#author').attr("value",data.bean.author);
			if("1"==data.bean.ispublication){
				$("input[name='ispublication'][value=1]").attr("checked",'checked');
			}else{
				$("input[name='ispublication'][value=0]").attr("checked",'checked');
			}
			if("1"==data.bean.isrecommend){
				$("input[name='isrecommend'][value=1]").attr("checked",'checked');
			}else{
				$("input[name='isrecommend'][value=0]").attr("checked",'checked');
			}
			if("1"==data.bean.istop){
				$("input[name='istop'][value=1]").attr("checked",'checked');
			}else{
				$("input[name='istop'][value=0]").attr("checked",'checked');
			}
			if("1"==data.bean.isnotice){
				$("input[name='isnotice'][value=1]").attr("checked",'checked');
			}else{
				$("input[name='isnotice'][value=0]").attr("checked",'checked');
			}
			$('#sort').attr("value",data.bean.sort);
			KE.html("contentvalue",data.bean.contentvalue);
			$('#metaKeywords').attr("value",data.bean.metaKeywords);
			$('#metaDes').attr("value",data.bean.metaDes);
			$('#hidarticleid').attr("value",data.bean.articleid);
			$('#hidarticleCategoryTid').attr("value",data.bean.articleCategoryTid);
			$('#hidreadcount').attr("value",data.bean.readcount);
		}
	});
	
	$('#modify').click(function(){
		var title=$('#title').val();
		if(title==""){
			jAlert('文章标题必须填写', '信息提示');
			return false;
		}
		if($('#parentId').is(":hidden")){
			var parentName=$('#parentName').val();
			var articleCategoryName=parentName;
			var articleCategoryTid=$('#hidarticleCategoryTid').val();
		}else{
			var parentId=$('#parentId').val();
			var parentName=$('#parentId').find("option:selected").text();
			var parentId1=$('#parentId1').val();
			var parentName1=$('#parentId1').find("option:selected").text();
			if(parentId=="0"){
				var articleCategoryTid="0";
				var articleCategoryName=parentName;
			}else if(parentId!="0"&&parentId!="-1"&&parentId1=="-1"){
				var articleCategoryTid=parentId;
				var articleCategoryName=parentName;
			}else if(parentId!="0"&&parentId!="-1"&&parentId1!="-1"){
				var articleCategoryTid=parentId1;
				var articleCategoryName=parentName1;
			}else if(parentId=="-1"){
				jAlert('请选择分类', '信息提示');
				return false;
			}
		}
		
		var author=$("#author").val();
		if($("#ispublication").attr('checked')){
			var ispublication="1";
		}else{
			var ispublication="0";
		}
		if($("#isrecommend").attr('checked')){
			var isrecommend="1";
		}else{
			var isrecommend="0";
		}
		if($("#istop").attr('checked')){
			var istop="1";
		}else{
			var istop="0";
		}
		if($("#isnotice").attr('checked')){
			var isnotice="1";
		}else{
			var isnotice="0";
		}
		var pageCount=1;
		var contentvalue=$("#contentvalue").val();
		var metaKeywords=$('#metaKeywords').val();
		var metaDes=$('#metaDes').val();
		var articleid=$('#hidarticleid').val();
		var readcount=$('#hidreadcount').val();
		$.post("updateArticleT.action",{"articleCategoryTid":articleCategoryTid,"articleid":articleid,"articleCategoryName":articleCategoryName,"metaKeywords":metaKeywords,"metaDes":metaDes,"title":title,"contentvalue":contentvalue,"author":author,"ispublication":ispublication,"isrecommend":isrecommend,"istop":istop,"pageCount":pageCount,"readcount":readcount,"isnotice":isnotice},function(data){
			if(data.sucflag){
				window.location.href="articlemanagement.jsp?session="+session+"#pagecontent";
			}else{
				jAlert('文章更新失败', '信息提示');
				return false;
			}
		});
	});
});
/*===========================================Gorgeous split-line==============================================*/





