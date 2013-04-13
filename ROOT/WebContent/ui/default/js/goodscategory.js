
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
});

/**
 * 搜索排序
 */
$(function(){
	var sign=$('#hidsign').val();
	$('#default').click(function(){
		window.location.href=""+sign+"_1.html";
	});
	$('#sales').click(function(){
		window.location.href=""+sign+"sales_1.html";
	});
	$('#memberprice').click(function(){
		window.location.href=""+sign+"memberprice_1.html";
	});
	$('#totalcomment').click(function(){
		window.location.href=""+sign+"totalcomment_1.html";
	});
	$("#bargainprice").click(function(){   
        if($("#bargainprice").attr("checked")==true){   
        	window.location.href=""+sign+"bargainprice_1.html";
        }else{   
            return false;
        }   
    });
	$("#hotsale").click(function(){   
        if($("#hotsale").attr("checked")==true){   
        	window.location.href=""+sign+"hotsale_1.html";
        }else{   
            return false;
        }   
    });
	$("#recommended").click(function(){   
        if($("#recommended").attr("checked")==true){   
        	window.location.href=""+sign+"recommended_1.html";
        }else{   
            return false;
        }   
    });
	$("#isNew").click(function(){   
        if($("#isNew").attr("checked")==true){   
        	window.location.href=""+sign+"isNew_1.html";
        }else{   
            return false;
        }   
    });
	
	//获取url地址用来让用户登录时跳转
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);

});


//点击加入购物车
function addtocart(goodsid){
	var needquantity=1;
	var hidurl=$('#hidurl').val();
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

}
function addtofav(goodsid,title,readcount,memberprice){
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);
	var hidurl=$('#hidurl').val();

		$.post("addFavorite.action",{"title":title,"goodsid":goodsid,"readcount":readcount,"memberprice":memberprice,"hidurl":hidurl},function(data){
			if(data.slogin){
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			}else{
				//跳转到商品页面
				//window.location.href=data.hidurl;
				alert("收藏成功");
			}
		});
}

	