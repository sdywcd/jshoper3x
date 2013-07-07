//首页左侧导航条延迟加载
$(function(){
	
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
 
		$(".hotview").hover(function(){
			var $tabs=$(this).find(".container").children("a");
			var $bar=$(this).find(".hoverbar");
			var $view=$(this).find(".view_l");
			var tab_len=$tabs.length;
			$bar.attr("href",$tabs.eq(0).attr("href"));
			$tabs.bind("mouseover",function(){
				$(this).addClass("select").siblings().removeClass("select");
				var index=$tabs.index($(this));
				if(index==0){
					$(this).parent().parent().parent().find(".switch-top").addClass("prevno").removeClass("prev");
					$(this).parent().parent().parent().find(".switch-bottom").addClass("next").removeClass("nextno");
				}
				if(index==tab_len-1){
					$(this).parent().parent().parent().find(".switch-top").addClass("prev").removeClass("prevno");
					$(this).parent().parent().parent().find(".switch-bottom").addClass("nextno").removeClass("next");
				}
				if(index>0&&index<tab_len-1){
					$(this).parent().parent().parent().find(".switch-top").addClass("prev").removeClass("prevno");
					$(this).parent().parent().parent().find(".switch-bottom").addClass("next").removeClass("nextno");
				}
				var tab_width=$bar.height()+4;
				$view.css("display","none").eq(index).css("display","block");
				$bar.stop().animate({"top":index*tab_width+(index*2+1)*4},500).attr("href",$(this).attr("href"));
			});
		},function(){
			$(this).find(".container").children("a").unbind("mouseover");
		});
});

function change(id) {
	var ulBox = document.getElementById("topList");
	var list = ulBox.getElementsByTagName("li");
	for (var i=0; i<list.length; i++) {
	document.getElementById('li'+i).className = "";
	document.getElementById('big'+i).style.display = "none";
	document.getElementById('small'+i).style.display = "";
	}
	document.getElementById('li'+id).className = "mouseover";
	document.getElementById('big'+id).style.display = "block";
	document.getElementById('small'+id).style.display = "none";
	}

	
	