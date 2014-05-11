$(function() {
	$(".grid_4 img_slid").jqueryzoom( {
		xzoom : 300, // zooming div default width(default width value is 200)
		yzoom : 300, // zooming div default width(default height value is
		// 200)
		offset : 20, // zooming div default offset(default offset value is
		// 10)
		position : "right", // zooming div position(default position value is
		// "right")
		preload : 1
	});

});
jQuery.fn.loadthumb = function(options) {
	options = $.extend( {
		src : ""
	}, options);
	var _self = this;
	_self.hide();
	var img = new Image();
	$(img).load(function() {
		_self.attr("src", options.src);
		_self.fadeIn("slow");
	}).attr("src", options.src); // .atte("src",options.src)要放在load后面，
	return _self;
}

$(function() {
	var i = 5; // 已知显示的<a>元素的个数
	var m = 5; // 用于计算的变量
	var $content = $("#myImagesSlideBox .scrollableDiv");
	var count = $content.find("a").length;// 总共的<a>元素的个数
	// 下一张
	$(".next").live("click", function() {
		var $scrollableDiv = $(this).siblings(".items").find(".scrollableDiv");
		if (!$scrollableDiv.is(":animated")) { // 判断元素是否正处于动画，如果不处于动画状态，则追加动画。
				if (m < count) { // 判断 i 是否小于总的个数
				m++;
				$scrollableDiv.animate( {
					left : "-=50px"
				}, 600);
			}
		}
		return false;
	});
	// 上一张
	$(".prev").live("click", function() {
		var $scrollableDiv = $(this).siblings(".items").find(".scrollableDiv");
		if (!$scrollableDiv.is(":animated")) {
			if (m > i) { // 判断 i 是否小于总的个数
				m--;
				$scrollableDiv.animate( {
					left : "+=50px"
				}, 600);
			}
		}
		return false;
	});

	$(".scrollableDiv a").live("click", function() {

		var src = $(this).find("img").attr("imgb");
		var bigimgSrc = $(this).find("img").attr("bigimg");
		$(this).parents(".myImagesSlideBox").find(".myImgs").loadthumb( {
			src : src
		}).attr("bigimg", bigimgSrc);
		$(this).parents(".myImagesSlideBox").find(".myImgs").loadthumb( {
			src : src
		}).attr("jqimg", bigimgSrc);
		$(this).addClass("active").siblings().removeClass("active");
	});
	$(".scrollableDiv a:nth-child(1)").trigger("click");

	$(".myTxts a").live("click", function() {
		var bigimgSrc = $(this).parents(".myImagesSlideBox").find(".myImgs").attr("bigimg");
		popZoom(bigimgSrc, "500", "500");
		return false;
	});

	// 以新窗口的方式打开图片
	var windowWidth = $(window).width();
	var windowHeight = $(window).height();
	function popZoom(pictURL, pWidth, pHeight) {
		var sWidth = windowWidth;
		var sHeight = windowHeight;
		var x1 = pWidth;
		var y1 = pHeight;
		var opts = "height=" + y1 + ",width=" + x1 + ",left=" + ((sWidth - x1) / 2) + ",top=" + ((sHeight - y1) / 2) + ",scrollbars=0,menubar=0";
		pZoom = window.open("", "", opts);
		pZoom.document.open();
		pZoom.document.writeln("<html><body bgcolor=\"skyblue\"" + " onblur='self.close();' style='margin:0;padding:0;'>");
		pZoom.document.writeln("<img src=\"" + pictURL + "\" width=\"" + pWidth + "px\" height=\"" + pHeight + "px\">");
		pZoom.document.writeln("</body></html>");
		pZoom.document.close();
	}

	/* 关闭遮罩层 */
	$(".closeMyDiv a").live("click", function() {
		$("#MyDiv").empty().hide();
		$("#BigDiv").hide();
		return false;
	}).focus(function() {
		$(this).blur();
		return false;
	});

	/* 使用遮罩层 */
	$("#myImagesSlideBox .myImages img").click(function() {
		/* 遮罩层居中 和 宽度 高度设置 */
		$("#BigDiv").css( {
			width : $("body").width(),
			height : ($("body").height() > $("html").height()) ? $("body").height() : $("html").height()
		});
		$("#MyDiv").css( {
			left : (($(window).width() - 300) / 2),
			top : (($(window).height() - 390) / 2)
		});

		var $myDiv = $("#MyDiv").html($("#myImagesSlideBox").html()).show();
		$('<div class="closeMyDiv"><a href="#">关闭</a></div>').prependTo($myDiv);
		$("#BigDiv").show();
		return false;
	});
});