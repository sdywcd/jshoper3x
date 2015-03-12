//首页左侧导航条延迟加载
$(function(){
	var lid="";
	$('#categoryvalue li').hover(function(){
		var i="";
		var tempid=$(this).attr("id");
		lid=tempid;
		var ddfirst="<dd id='1f"+lid+"'>";
		var ddend="</dd>";
		t=setTimeout(function(){
			$.post("GetLeftMenu.action",{"ltypeid":lid},function(data){
				$.each(data.leftmenu,function(index,item){
					i+="<i id='f"+lid+"'><a target='_blank' href=\"goods/goodslist.jsp?stypeid="+item.stypeid+"\">"+item.sname+"</a></i>";
				});
				$("#1r"+lid).after(ddfirst+i+ddend);
			});
		  },1000);
		},
		function(){
			  $("#1f"+lid).remove('#1f'+lid);
			  //$("#1f"+lid).empty('#1f'+lid);
			  clearTimeout(t);
			  return true;
		  });	
	/*获取url参数提供自定义页面编辑区域*/
	var navid = $.query.get('navid');
	var ltypeid=$.query.get('ltypeid');
	var stypeid=$.query.get('stypeid');
	var nlstypeid="";
	if(""!=navid){
		nlstypeid=navid;
	}
	if(""!=ltypeid){
		nlstypeid=ltypeid;
	}
	if(""!=stypeid){
		nlstypeid=stypeid;
	}
	/*增加新品上市的更多链接*/
	var newproductamore="<span><a href='GetGoodslistmoreByGoodsType.action?nlstypeid="+nlstypeid+"'>更多</a></span>";
	$("#newproducta").append(newproductamore);
	/*读取用户自定义页面编辑数据*/
	$.post("GetGoodslistEditarea.action",{"nlstypeid":nlstypeid},function(data){
		$.each(data.editarea,function(index,item){
			if("2"==item.editflag){
				/*品牌推荐*/
				$('#area2title').text(item.editareatitle);
				$('#area2').append(item.editareavalue);
				return;
			}
			if("3"==item.editflag){
				$('#area3title').text(item.editareatitle);
				$('#area3title').css({
					background:"url('ui/default/images_green/menu_title_bg.gif') no-repeat scroll center center transparent"
				});
				$('#area3').append(item.editareavalue);
				return;
			}
			if("4"==item.editflag){
				/*滚动广告*/
				$('#area4title').text(item.editareatitle);
				$('#slider ul').append(item.editareavalue);
				return;
			}
			if("5"==item.editflag){
				$('#area5').append(item.editareavalue);
				return;
			}
			if("6"==item.editflag){
				/*明星产品*/
				$('#area6title').text(item.editareatitle);
				//$('#area6title').append("<span><a href='GetAllGoodslistMoreByStarProduct.action?nlstypeid="+nlstypeid+"'>更多</a></span>");
				$('#area6title').append("<span><a href='GetGoodslistmoreByGoodsType.action?nlstypeid="+nlstypeid+"'>更多</a></span>");
				
				
				$('#area6title').after(item.editareavalue);
				return;
			}
			if("7"==item.editflag){
				/*热卖商品*/
				$('#area7title').text(item.editareatitle);
				$('#area7title').append("<span><a href='GetAllGoodslistMoreHotSale.action?nlstypeid="+nlstypeid+"'>更多</a></span>");
				$('#area7title').after(item.editareavalue);
				return;
			}
			if("8"==item.editflag){
				/*特价商品*/
				$('#area8title').text(item.editareatitle);
				$('#area8title').append("<span><a href='GetAllGoodslistMoreByBargainPrice.action?nlstypeid="+nlstypeid+"'>更多</a></span>");
				$('#area8title').after(item.editareavalue);
				return;
			}
			if("9"==item.editflag){
				$('#area9title').text(item.editareatitle);
				$('#area9title').css({
					background:"url('ui/default/images_green/menu_title_bg.gif') no-repeat scroll center center transparent"
				});
				$('#area9title').after(item.editareavalue);
				return;
			}
			if("10"==item.editflag){
				/*排行榜*/
				$('#area10title').text(item.editareatitle);
				$('#area10title').css({
					background:"url('ui/default/images_green/menu_title_bg.gif') no-repeat scroll center center transparent"
				});
					
				$('#accordion').append(item.editareavalue);
				return;
			}
			if("11"==item.editflag){
				/*特价商品*/
				$('#area11title').text(item.editareatitle);
				$('#area11title').append("<span><a href='GetAllGoodslistMoreByBargainPrice.action?nlstypeid="+nlstypeid+"'>更多</a></span>");
				$('#area11title').after(item.editareavalue);
				return;
			}
		});
		/*商品tabs*/
		 // setup ul.tabs to work as tabs for each div directly under div.panes
        $("ul.tabs").tabs("div.panes > div");
        
		/*首页互动sliderjs*/
		$("#slider").easySlider({
			auto: true, 
			continuous: true,
			numeric: true
		});
		/*排行榜js*/
		$("#accordion").tabs("#accordion div.pane", {tabs: 'h2', effect: 'slide', initialIndex: null});
 
		
		
	});
	//控制购物车显示
	$("#download_now").hover(function(){
		$('.tooltip').css("display","block");
	},
	function(){
		$('.tooltip').css("display","block");
	});
	$('#cartmark').hover(function(){
		$('.tooltip').css("display","block");
	},
	function(){
		$('.tooltip').css("display","none");
	});
	

		
});

	