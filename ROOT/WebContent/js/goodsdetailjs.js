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
	
	//获取url地址用来让用户登录时跳转
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);
	
	
	//获取商品评论
	var goodsid=$("#hidgoodsid").val();
	if(goodsid!=""){
		$.post("GetGoodsCommentById.action",{"goodsid":goodsid},function(data){
			if(data.sucflag){
				var h1="<div class='righttitle'>商品评论</div>";
				var h2="";
				
				$.each(data.beanlist,function(k,v){
					h2+="<div class='comment'>"+
					"<div class='left_comment'>"+
						"<div class='left_comment_img'>"+
							"<img src='ui/default/images_green/hui.jpg' alt='' />"+
						"</div>"+
						"<div class='username'>"+
							"<a>"+v.replyorcommentusername+"</a>"+
						"</div>"+
					"</div>"+
					"<div class='right_comment'>"+
						"<div class='right_comment_toptitle'>"+
							"<div class='right_comment_singlecomment'></div>"+
							"<div class='right_comment_commenttime'>"+v.posttime+"</div>"+
						"</div>"+
						"<div class='right_comment_content'>"+v.commentcontent+"</div>"+
						"<div class='right_comment_replyarea'>"+
						"</div>"+
					"</div>"+	
				"</div>";
				});
				$('#goodcommentarea').html(h1+h2);
			}
		});
		
	}

	//获取商品cookie
	var goodsid=$("#hidgoodsid").val();
	var goodsname=$("#hidgoodsname").val();
	var price=$("#hidprice").val();
	var memberprice=$("#hidmemberprice").val();
	var pictureurl=$("#hidpictureurl").val();
	var htmlPath=$("#hidhtmlpath").val();
	$.post("getGoodsCookie.action",{"goodsid":goodsid,"goodsname":goodsname,"price":price,"memberprice":memberprice,"pictureurl":pictureurl,"htmlPath":htmlPath},function(data){
		if(data.cookielist!=null){
			var h1="<div class='normaltitle'>您曾经浏览过</div>";
			var h2="";
			$.each(data.cookielist,function(k,v){
				h2+="<div class='sameprice'>"+
                          "<div class='product_title'><a target='_blank' href="+v.htmlPath+">"+v.goodsname+"</a></div>"+
                          "<div class='product_img'><a target='_blank' href="+v.htmlPath+"><img height='120px' border='0' width='120px' alt='商品图片' src="+v.pictureurl+"></a></div>"+
                          "<div class='prod_price'><span class='reduce'>￥"+v.price+"</span><span class='price'>￥"+v.memberprice+"</span></div>"+
                    "</div>";
			});
			$('#goodscookiearea').html(h1+h2);
		}
	});
	
	
	//增加用户评论
	$('#addgoodscomment').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var goodsname=$('#hidgoodsname').val();
		var commentcontent=$('#commentcontent').val();
		var hidurl=window.location;
		if(goodsid!=""&&goodsname!=""&&commentcontent!=""){
			$.post("addGoodsComment.action",{"goodsid":goodsid,"goodsname":goodsname,"commentcontent":commentcontent},function(data){
				if(data.sucflag){
					window.location.href=hidurl;
				}else{
					window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
				}
			});
		}
	});
	
	
	
	//点击加入购物车
	$('#addcart').click(function(){
		var goodsid=$('#goodsid').val();
		var needquantity=$('#needquantity').val();
		var hidurl=window.location;
		$.post("addCart.action",{"goodsid":goodsid,"needquantity":needquantity,"hidurl":hidurl},function(data){
			if(data.slogin){
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			}else if(data.sflag){
				//跳转到购物车页面
				window.location.href="findAllCartByUserId.action?redirecturl=http://"+location.host+"/usercenter/cart/cart.jsp";
			}else{
				//跳转到商品页面
				window.location.href=data.hidurl;
			}
		});
	});
	
	//点击商品组合购买
	$('#buyzuhe').click(function(){
		var str="";
		var needquantity=1;
		$(":checkbox[name='relatedgoodsid'][checked=true]").each(function(){
			str+=this.value+',';
		});
		var hidurl=window.location;
		$.post("addCart.action",{"goodsid":str,"needquantity":needquantity,"hidurl":hidurl},function(data){
			if(data.slogin){
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			}else if(data.sflag){
				//跳转到购物车页面
				window.location.href="findAllCartByUserId.action?redirecturl=http://"+location.host+"/usercenter/cart/cart.jsp";
			}else{
				//跳转到商品页面
				window.location.href=data.hidurl;
			}
		});
	});
	
	
	//点击收藏改商品
	$('#addfav').click(function(){
		var hidurl=$('#hidurl').val();
		var title=$('#hidgoodsname').val();
		var goodsid=$('#hidgoodsid').val();
		var readcount=$('#hidreadcount').val();
		var memberprice=$('#hidmemberprice').val();
		$.post("addFavorite.action",{"title":title,"goodsid":goodsid,"readcount":readcount,"memberprice":memberprice,"hidurl":hidurl},function(data){
			if(data.slogin){
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			}else{
				//跳转到商品页面
				//window.location.href=data.hidurl;
				$('#addfavok').html("收藏成功");
			}
		});
	});
	//增加商品咨询
	$('#question').click(function (){
		var question =$('#goodconsult').val();
		var hidurl=$('#hidurl').val();
		
		$.post("addQuestion.action",{"question":question},function(data){
			if(data.flag){
				alert("提交成功！管理会在1-3天内把答案回复到您的邮箱，请注意查看");
				window.location.href=windowsurl;
			}else{
				alert("提交失败 ，请先登录");
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			}
		});
	});

});


