
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




//遍历text计算重量和总金额
var amount=0;
var thisprice=0.0;
var thisweight=0.0;
var tempamount=0;
var tempprice=0.0;
var tempweight=0.0;
var totalmemberprice=0;
var totalweight=0;
var change;
function getall(){
	 amount=0;
	 thisprice=0.0;
	 thisweight=0.0;
	 tempamount=0;
	 tempprice=0.0;
	 tempweight=0.0;
	 totalmemberprice=0;
	 totalweight=0;
	 change;
	$("input:text").each(function(){
		if(!this.name.indexOf("amount")>0){
			if(this.value=="1"){
				tempamount=1;
			}else{
				tempamount=parseInt(this.value);
			}
			change=this.name.split(',');
			tempprice=change[1];
			tempweight=change[2];
			thisprice+=(tempprice*10)*(tempamount*10)/100;
			thisweight+=(tempweight*10)*(tempamount*10)/100;
		}
	});
	
}


//获取商品数量对应的input数据
function changereduceamount(goodsid,weight,favorable){
	getall();
	var amount=$('#amount'+goodsid).val();
	if(amount=="1"){
		amount=2;
	}
	var tempamount=parseInt(amount)-1;
	$('#amount'+goodsid).attr("value",tempamount);
	//计算金额和重量
	thisprice=thisprice-(favorable*10)*(1*10)/100;
	thisweight=thisweight-(weight*10)*(1*10)/100;
	$('#totalmemberprice').html(thisprice);
	$('#totalweight').html(thisweight);
}

function changeplusamount(goodsid,weight,favorable){
	getall();
	var amount=$('#amount'+goodsid).val();
	if(amount=="1"){
		amount=2;
	}
	var tempamount=parseInt(amount)+1;
	$('#amount'+goodsid).attr("value",tempamount);
	//计算金额和重量
	thisprice=thisprice+(favorable*10)*(1*10)/100;
	thisweight=thisweight+(weight*10)*(1*10)/100;
	$('#totalmemberprice').html(thisprice);
	$('#totalweight').html(thisweight);
}

//重新计算总价和重量
function resetgetall(){
	 var ramount=0;
	 var rthisprice=0.0;
	 var rthisweight=0.0;
	 var rtempamount=0;
	 var rtempprice=0.0;
	 var rtempweight=0.0;
	 var rtotalmemberprice=0;
	 var rtotalweight=0;
	 var rchange;
	$("input:text").each(function(){
		if(!this.name.indexOf("amount")>0){
			if(this.value=="1"){
				rtempamount=1;
			}else{
				rtempamount=parseInt(this.value);
			}
			rchange=this.name.split(',');
			rtempprice=rchange[1];
			rtempweight=rchange[2];
			rthisprice+=(rtempprice*10)*(rtempamount*10)/100;
			rthisweight+=(rtempweight*10)*(rtempamount*10)/100;
		}
	});
	$('#totalmemberprice').html(rthisprice);
	$('#totalweight').html(rthisweight);
	
}
function changeinfo(goodsid,weight,favorable){
	var amount=$('#amount'+goodsid).val();
	if(amount>100){
		alert("数量超时限定");
		$('#amount'+goodsid).attr("value",1);
		//计算金额和重量
		resetgetall();
		return;
	}else{
		//计算金额和重量
		resetgetall();
		return;
	}
	if(amount<1){
		alert("数量超时限定");
		$('#amount'+goodsid).attr("value",1);
		//计算金额和重量
		resetgetall();
		return;
	}else{
		//计算金额和重量
		resetgetall();
		return;
	
	}
	
	
}
