//商品评论列表
$(function() {
			/**
			 * 搜索商品
			 */
			searchGoodsBygoodsname = function(param) {
				$("#goodsmanagement").flexigrid({
					url : 'searchGoodsBygoodsname.action?goodsname=' + param,
					dataType : 'json',
					cache : false,
					colModel : [ {
						display : '商品名称',
						name : 'goodsname',
						width : 400,
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
						name : '选择该商品进行评论',
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
					if (com == '选择该商品进行评论') {
						if ($('.trSelected', grid).length == 1) {
							var str = "";
							var name = "";
							$('.trSelected', grid).each(function() {
								str = this.id.substr(3);
							});
							$(".trSelected td:nth-child(2) div",
									$('#goodsmanagement')).each(function(i) {
								name = this.innerHTML;
							});
							$("#commentgoods").val(name);
							$("#hidgoodsid").val(str);
							return;
						} else {
							formwarning("#alerterror", "请选择需要评论的商品");
							return false;
						}
					}
				}

			},

			findAllGoodsComment = function() {
				$("#goodscommentmanagement").flexigrid({
					url : 'findAllGoodsComment.action',
					dataType : 'json',
					cache : false,
					colModel : [ {
						display : '被评论的商品',
						name : 'goodsname',
						width : 300,
						sortable : true,
						align : 'center'
					}, {
						display : '状态',
						name : 'state',
						width : 100,
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
						name : '查看该商品所有评论',
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
					sortname : "posttime",
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
					if (com == '查看该商品所有评论') {
						if ($('.trSelected', grid).length == 1) {
							var str = "";
							var name = "";
							$('.trSelected', grid).each(function() {
								str = this.id.substr(3);
							});
							$(".trSelected td:nth-child(2) div",
									$('#goodsmanagement')).each(function(i) {
								name = this.innerHTML;
							});
							window.location.href = "goodscommentlistment.jsp?operate=edit&goodsname="
									+ name + "&goodsid=" + str;
							return;
						} else {
							formwarning("#alerterror", "请选择一条信息");
							return false;
						}
						return;
					}
				}
			},
			findAllGoodsCommentByGoodsid = function(param) {
				$("#goodscommentlistmanagement")
						.flexigrid(
								{
									url : 'findAllGoodsCommentListByGoodsId.action?goodsid='
											+ param,
									dataType : 'json',
									cache : false,
									colModel : [ {
										display : '评论内容',
										name : 'commentcontent',
										width : 300,
										sortable : true,
										align : 'center'
									}, {
										display : '评论人',
										name : 'replyorcommentusername',
										width : 150,
										sortable : true,
										align : 'center'
									}, {
										display : '分数',
										name : 'score',
										width : 50,
										sortable : true,
										align : 'center'
									}, {
										display : '回复内容',
										name : 'replyorcomment',
										width : 150,
										sortable : true,
										align : 'center'
									}, {
										display : '虚拟增加',
										name : 'virtualadd',
										width : 150,
										sortable : true,
										align : 'center'
									}, {
										display : '状态',
										name : 'state',
										width : 150,
										sortable : true,
										align : 'center'
									}, {
										display : '发布时间',
										name : 'posttime',
										width : 180,
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
										name : '增加评论',
										bclass : 'add',
										onpress : action
									}, {
										name : '编辑',
										bclass : 'edit',
										onpress : action
									}, {
										name : '审核通过',
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
									} ],
									sortname : "posttime",
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
					if (com == "增加评论") {
						window.location.href = "goodscomment.jsp?operate=add";
						return;
					} else if (com == '编辑') {
						if ($('.trSelected', grid).length == 1) {
							var str = "";
							var name = "";
							$('.trSelected', grid).each(function() {
								str = this.id.substr(3);
							});
							window.location.href = "goodscommentdetail.jsp?operate=editdetail&commentid="
									+ str;
							return;
						} else {
							formwarning("#alerterror", "请选择一条信息");
							return false;
						}
						return;
					} else if (com == '删除') {
						if ($('.trSelected', grid).length > 0) {
							var str = "";
							var name = "";
							$('.trSelected', grid).each(function() {
								str = this.id.substr(3)+",";
							});
							$.post("delGoodsComment.action",{"commentid":str},function(data){
								$('#goodscommentlistmanagement').flexReload();
								forminfo("#alertinfo","删除商品评论成功");
							});
							return;
						} else {
							formwarning("#alerterror", "请选择一条信息");
							return false;
						}
						return;
					}
				}
			}
	/**
	 * 点击查询商品
	 */
	$("#searchgoods").click(function() {
		var goodsname = $("#goodsname").val();
		if ("" == goodsname) {
			formwarning("#alerterror", "请输入商品名称再查询");
			return false;
		}
		searchGoodsBygoodsname(goodsname);
	});
			/**
			 * 增加虚拟评论
			 */
			savevirtualGoodsComment = function() {
				var goodsid = $("#hidgoodsid").val();
				if ("" == goodsid) {
					formwarning("#alerterror", "请查询需要添加评论的商品");
					return false;
				}
				var goodsname = $("#commentgoods").val();
				var replyorcommentusername = $("#replyorcommentusername").val();
				if ("" == replyorcommentusername) {
					formwarning("#alerterror", "请填写评论人");
					return false;
				}
				var commentcontent = $("#commentcontent").val();
				if ("" == commentcontent) {
					formwarning("#alerterror", "请填写评论内容");
					return false;
				}
				var score = $("input[name='score']:checked").val();
				this.value = "提交中";
				this.disabled = true;
				$
						.post(
								"addvirtualGoodsComment.action",
								{
									"goodsid" : goodsid,
									"goodsname" : goodsname,
									"replyorcommentusername" : replyorcommentusername,
									"commentcontent" : commentcontent,
									"score" : score
								},
								function(data) {
							
										window.location.href = "goodscommentlistment.jsp?operate=edit&goodsid="
												+ goodsid
												+ "&goodsname="
												+ goodsname;
										return;
									
								});
			},
			/**
			 * 根据id获取商品评论详细
			 */
			findGoodsCommentById = function() {
				var commentid = $.query.get("commentid");
				if (commentid == "") {
					return;
				}
				$.post("findGoodsCommentById.action", {
					"commentid" : commentid
				}, function(data) {
				
						$("#replyorcommentusername").val(
								data.bean.replyorcommentusername);
						KE.html("commentcontent", data.bean.commentcontent);
						switch (data.bean.score) {
						case "1":
							$("input[name='score']").get(0).checked = true;
							break;
						case "2":
							$("input[name='score']").get(1).checked = true;
							break;
						case "3":
							$("input[name='score']").get(2).checked = true;
							break;
						case "4":
							$("input[name='score']").get(3).checked = true;
							break;
						case "5":
							$("input[name='score']").get(4).checked = true;
							break;
						case "6":
							$("input[name='score']").get(5).checked = true;
							break;
						case "7":
							$("input[name='score']").get(6).checked = true;
							break;
						case "8":
							$("input[name='score']").get(7).checked = true;
							break;
						case "9":
							$("input[name='score']").get(8).checked = true;
							break;
						case "10":
							$("input[name='score']").get(9).checked = true;
							break;
							
						}
						$("#hidgoodsid").val(data.bean.goodsid);
						$("#hidgoodsname").val(data.bean.goodsname);
						$("#hidcommentid").val(data.bean.commentid);
						$("#submit").hide();
						$("#update").show();
				});
			},
			/**
			 * 更新评论
			 */
			updateGoodsComment=function(){
				var commentid=$("#hidcommentid").val();
				var goodsid = $("#hidgoodsid").val();
				var goodsname=$("#hidgoodsname").val();
				var replyorcommentusername = $("#replyorcommentusername").val();
				if ("" == replyorcommentusername) {
					formwarning("#alerterror", "请填写评论人");
					return false;
				}
				var commentcontent = $("#commentcontent").val();
				if ("" == commentcontent) {
					formwarning("#alerterror", "请填写评论内容");
					return false;
				}
				var score = $("input[name='score']:checked").val();
				this.value = "提交中";
				this.disabled = true;
				$.post("updateGoodsComment.action",{
					"replyorcommentusername":replyorcommentusername,
					"commentcontent":commentcontent,
					"score":score,
					"commentid":commentid
					},function(data){
						if(data.sucflag){
							window.location.href = "goodscommentlistment.jsp?operate=edit&goodsid="
								+ goodsid
								+ "&goodsname="
								+ goodsname;
						return;
						}
				});
			}
			

	/**
	 * 增加商品虚拟评论
	 */
	$("#submit").click(function() {
		savevirtualGoodsComment();
	});
	/**
	 * 更新商品评论
	 */
	$("#update").click(function(){
		updateGoodsComment();
	});
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * main logic
 */
$(function() {
	var operate = $.query.get("operate");
	if (operate == "add") {
		$("#goodstypetnparamsarea").hide();
		return;
	} else if (operate == "edit") {
		var goodsname = $.query.get("goodsname");
		var goodsid = $.query.get("goodsid");
		if (goodsname != "" && goodsid != "") {
			$("#dttitle").text(goodsname + "的所有评论");
			findAllGoodsCommentByGoodsid(goodsid);
		}
		return;
	} else if (operate == "find") {
		findAllGoodsComment();
	} else if (operate == "editdetail") {
		findGoodsCommentById();
	}
});

/**
 * 获取商品详细的评论数据
 */
$(function() {
	var goodsid = $.query.get("goodsid");
	if (goodsid == "") {
		return false;
	}
	$.post("getGoodscommentDetails.action", {
		"goodsid" : goodsid
	}, function(data) {
		if (data.sucflag) {
			var temp = "";
			$(".title h5").text(data.beanlist[0].goodsname);
			$.each(data.beanlist,
					function(i, v) {
						temp += "<h4>" + v.commentcontent + "</h4>";
						temp += "<ul class='square'>";
						temp += "<li>" + v.replyorcommentusername + "于"
								+ v.posttime + "对" + v.goodsname + "进行评论</li>";
						temp += "<li>评分等级" + v.score + "</li>";
						if (v.state == "1") {
							temp += "<li id='hideview" + v.commentid
									+ "'><input onclick='hidcomment("
									+ v.commentid
									+ ");' type='button' id='hidecomment"
									+ v.commentid + "' name='hidecomment"
									+ v.commentid + "' value='隐藏'/></li>";
						} else {
							temp += "<li id='showview" + v.commentid
									+ "'><input onclick='showcomment("
									+ v.commentid
									+ ");' type='button' id='showcomment"
									+ v.commentid + "' name='showcomment"
									+ v.commentid + "' value='显示'/></li>";
						}
						temp += "<input type='hidden' id='hidecommentid'+"
								+ v.commentid + " name='hidecommentid'+"
								+ v.commentid + " value='" + v.commentid
								+ "'/>";
						temp += "<li><input onclick='openDialog(" + v.commentid
								+ ");' type='button' id='reply" + v.commentid
								+ "' name='reply" + v.commentid
								+ "' value='回复'/></li>";
						temp += "</ul>";
					});
			$("#detailcomments").html(temp);
		}
	});
});

// 这里开始写隐藏和显示评论
function hidcomment(commentid) {
	var state = "0";
	$.post("updateGoodsCommentorReplyByState.action", {
		"state" : state,
		"commentid" : commentid + ","
	}, function(data) {
		$("#hidecomment" + commentid).hide();
		$("#hideview" + commentid).html(
				"<li id='showview" + commentid
						+ "'><input onclick='showcomment(" + commentid
						+ ");' type='button' id='showcomment" + commentid
						+ "' name='showcomment" + commentid
						+ "' value='显示'/></li>");
	});
}
function showcomment(commentid) {
	var state = "1";
	$.post("updateGoodsCommentorReplyByState.action", {
		"state" : state,
		"commentid" : commentid + ","
	}, function(data) {
		$("#showcomment" + commentid).hide();
		$("#showview" + commentid).html(
				"<li id='hideview" + commentid
						+ "'><input onclick='hidcomment(" + commentid
						+ ");' type='button' id='hidecomment" + commentid
						+ "' name='hidecomment" + commentid
						+ "' value='隐藏'/></li>");

	});
}
