$(function(){

	$("#submit").on("click",function(){
		var goodsid=$("#hidgoodsid").val();
		var goodsname=$("#hidgoodsname").val();
		if(goodsid===""||goodsname===""){
			formwarning("#alerterror", "请选择一个商品");
			return false;
		}
		var cardname=$("#cardname").val();
		if(cardname===""){
			formwarning("#alerterror", "请输入卡名");
			return false;
		}
		var amount=$("#amount").val();
		if(amount===""){
			formwarning("#alerterror", "请输入生成数量");
			return false;
		}
		$.post("saveGoodsCardsT.action",{
			"goodsid":goodsid,
			"goodsname":goodsname,
			"amount":amount,
			"cardname":cardname
		},function(data){
			if(data.sucflag){
				window.location.href="goodscardsment.jsp?operate=find&folder=goods";
				return;
			}
		});
	});


	
	
	findAllGoodsCards=function(){
		$("#goodscardsmanagement").flexigrid({
			url : 'findAllGoodsCards.action',
			dataType : 'json',
			cache : false,
			colModel : [ {
				display : '卡名',
				name : 'cardname',
				width : 300,
				sortable : true,
				align : 'center'
			}, {
				display : '数量',
				name : 'amount',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				display : '关联的购物卡商品',
				name : 'goodsname',
				width : 300,
				sortable : true,
				align : 'center'
			}, {
				display : '创建时间',
				name : 'createtime',
				width : 150,
				sortable : true,
				align : 'center'
			} ],
			buttons : [ {
				name : '添加购物卡',
				bclass : 'add',
				onpress : action
			},{
				name : '查看密钥',
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
			if (com == '添加购物卡') {
				window.location.href="goodscards.jsp?operate=add&folder=goods";
				return;
			}else if(com=='删除'){
				if($('.trSelected',grid).length>0){
					var str="";
					$('.trSelected',grid).each(function(){
						str+=this.id.substr(3)+",";
					});
					$.post("delGoodsCards.action",{"id":str},function(data){
						$('#goodscardsmanagement').flexReload();
						forminfo("#alertinfo","删除成功");
					});
					return;
				}else{
					formwarning("#alerterror", "请选择要删除的信息");
					return false;
				}
			}else if(com=="查看密钥"){
				if($('.trSelected',grid).length>0){
					var str="";
					$('.trSelected',grid).each(function(){
						str=this.id.substr(3);
					});
					window.location.href="goodscardspasswordment.jsp?id="+str+"&operate=find&folder=goods";
					return;
				}else{
					formwarning("#alerterror", "请选择要查看的信息");
					return false;
				}
			
			}

		}
	},
	findAllVirtualGoods=function(){
		$("#goodsmanagement").flexigrid({
			url : 'findAllVirtualGoods.action',
			dataType : 'json',
			cache : false,
			colModel : [ {
				display : '商品名称',
				name : 'goodsname',
				width : 300,
				sortable : true,
				align : 'center'
			}, {
				display : '分类',
				name : 'category',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				display : '创建时间',
				name : 'createtime',
				width : 150,
				sortable : true,
				align : 'center'
			} ],
			buttons : [ {
				name : '选择该商品生成购物卡',
				bclass : 'add',
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
			if (com == '选择该商品生成购物卡') {
				var str="";
				$('.trSelected',grid).each(function(){
					str=this.id.substr(3);
				});
				$("#hidgoodsid").val(str);
				$(".trSelected td:nth-child(2) div", $('#goodsmanagement')).each(function(i){
					$("#goodsname").val(this.innerHTML);
					$("#hidgoodsname").val(this.innerHTML);
				});
			}else if(com=='删除'){
				if($('.trSelected',grid).length>0){
					var str="";
					$('.trSelected',grid).each(function(){
						str+=this.id.substr(3)+",";
					});
					$.post("delGoodsCards.action",{"id":str},function(data){
						$('#goodscardsmanagement').flexReload();
						forminfo("#alertinfo","删除成功");
					});
					return;
				}else{
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
		findAllVirtualGoods();
	}else if(operate=="find"){
		findAllGoodsCards();
	}
	
	
});