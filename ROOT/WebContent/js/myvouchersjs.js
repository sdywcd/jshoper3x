
$(function(){
	//获取url地址用来让用户登录时跳转
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);
	
	$('#hidarea').html(windowsurl);
	
	//在结算前更新购物车中的商品数量数据ajax
	
	$('#gotojs').click(function(){
		var hidurl=$('#hidurl').val();
		var hidgoodsid="";
		var needquantity=0;
		var sendstring="";

		$("input:text").each(function(){
			if(!this.id.indexOf("amount")>0){
				needquantity=this.value;
				hidgoodsid=this.id.substring(this.name.indexOf("amount")+6,this.id.length);
				sendstring+=""+hidgoodsid+","+needquantity+":";
				
			}
		});
	
		$.post("PlusCartNeedquantityByGoodsid.action",{"sendstring":sendstring},function(data){
			
			if(data.slogin){
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			}
			if(data.sflag){
				//跳转到购物车页面
				window.location.href="InitOrder.action?redirecturl=findAllCartByUserId.action";
			}
		});
		
	});
	


});


