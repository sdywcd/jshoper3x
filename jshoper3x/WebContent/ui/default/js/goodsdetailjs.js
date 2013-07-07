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
						"</div>+"
						"<div class='username'>+"
							"<a>"+v.replyorcommentusername+"/></a>"+
						"</div>"+
					"</div>"+
					"<div class='right_comment'>"+
						"<div class='right_comment_toptitle'>"+
							"<div class='right_comment_singlecomment'></div>"+
							"<div class='right_comment_commenttime'>"+v.posttime+"</div>"+
						"</div>"+
						"<div class='right_comment_content'>"+v.commentcontent+"</div>"+
						"<div  class='right_comment_content_reply'></div>"
						"<div class='right_comment_replyarea'>"+
							"<div class='right_comment_replylink>"+
								"<a>回复</a>"+
								"<span style='display:none;'><a>收起</a></span>"+
							"</div>"+
							"<div style='display:none;' class='right_comment_replycounttoshow' >"+
								"<div class='replycountleft'>"+
									"共有<span>1</span>回复了此评论"+
								"</div>"+
								"<div class='getreply'>"+
									"<input type='button' id='getreply' name='getreply' value='加载回复'></input>"+
								"</div>"+
							"</div>"+
						"</div>"+
						"<div style='display:none;' class='reply_comment'>"+
							"<s:form theme='simple'>"+
							"</s:form>"+
							"<div class='reply_comment_title'>"+
								"<span>我要发表回复</span>"+
								"&nbsp;&nbsp;&nbsp;请您先以会员身份登录后再进行评论 | <a target='_blank' href='../../usercenter/register.jsp'>马上注册</a>"+
							"</div>"+
							"<div class='reply_comment_form'>"+
								"<div class='reply_comment_text'>内容：</div>"+
								"<textarea rows='8' cols='100'></textarea>"+
							"</div>"+
						"</div>"+
					"</div>"+	
				"</div>";
				});
				$('#goodcommentarea').html(h1+h2);
			}
		});
		
	}
	
	
	
	//点击加入购物车
	$('#addcart').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var needquantity=$('#needquantity').val();
		var hidurl=$('#hidurl').val();
		$.post("addCart.action",{"goodsid":goodsid,"needquantity":needquantity,"hidurl":hidurl},function(data){
			if(data.slogin){
				//跳转到登录页面
				window.location.href="../../../html/default/shop/login.html?redirecturl="+hidurl;
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
		var hidurl=$('#hidurl').val();
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
				window.location.href="../../../html/default/shop/login.html?redirecturl="+hidurl;
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