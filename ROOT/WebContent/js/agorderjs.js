
$(function(){
	//获取url地址用来让用户登录时跳转
	var windowsurl=window.location;
	$('#hidurl').attr("value",windowsurl);
	
	$('#hidarea').html(windowsurl);
	
	//控制新增地址区域的显示和关闭
	$('#addnewa').click(function(){
		$('#addnewaddressarea').show();
		$('#addressarea').hide();
	});
	$('#closenewa').click(function(){
		$('#addnewaddressarea').hide();
		$('#addressarea').show();
	});
	//控制配送方式的显示和关闭
	$('#modifylogistics').click(function(){
		$('#closelogistics').show();
		$('#otherlogistics').show();
	});
	$('#closelogistics').click(function(){
		$('#otherlogistics').hide();
	});
	//控制订单备注显示和修改
	$('#modifyorderbz').click(function(){
		$('#firsttr1').hide();
		$('#secondtr2').show();
	});
	//控制抵用券显示和关闭
	$("#usedyq").toggle(
		  function () {
		    $('#dyqdaima').show();
		  },
		  function () {
		    $('#dyqdaima').hide();
		  }
	); 
	//控制开发票是否显示和关闭
	$("#fpinvoice").toggle(
			function(){
				$('#fp_type').show();
				$('#fp_payee').show();
			},
			function(){
				$('#fp_type').hide();
				$('#fp_payee').hide();
			}
	)

	
	//在结算前更新购物车中的商品数量数据ajax
	
	
	
	$('#addaddress').click(function(){
		var hidurl=$('#hidurl').val();
		var username=$('#username').val();
		var country=$("#country").find("option:selected").text();
		var province=$('#province').find("option:selected").text();
	    var city=$('#city').find("option:selected").text();
	    var district=$('#district').find("option:selected").text();
		var street=$('#street').val();
		var mobile=$('#mobile').val();
		var telno=$('#telno').val();
		var email=$('#email').val();
		var postcode=$('#postcode').val();
		if(username==""&&street==""&&mobile==""){
			alert("请填写收货信息");
			return;
		}
		$.post("addDeliveraddress.action",{"username":username,"country":country,"province":province,"city":city,"district":district,"street":street,"mobile":mobile,"telno":telno,"email":email,"postcode":postcode},function(data){
			
			if(data.slogin){
				//跳转到登录页面
				window.location.href="/usercenter/login.jsp";
			}
			if(data.sflag){
				window.location.href="GetUserDeliverAddress.action";
			}
		});
		
	});
	
	$('#submitvoucher').click(function(){
		var vouchername=$('#vouchername').val();
		if(vouchername==""){
			alert("抵用券代码不能为空");
			return;
		}
		$.post("GetVouchersByname.action",{"vouchername":vouchername},function(data){
			if(data.svoucher){
				//跳转到登录页面
				var hidurl=$('#hidurl').val();
				window.location.href="/usercenter/login.jsp?redirecturl="+hidurl;
			
			}else{
				$('#vouchersprice').html(data.vouchercontent);
				var totalprice=$('#goodstotalprice').html();
				var freightprice=$('#goodsfreightprice').html();
				var shouldtotalprice=$('#shouldtotalprice').html();
				$('#shouldtotalprice').html(parseInt(totalprice)+parseInt(freightprice)-data.vouchercontent);
			}
		});
	});

	/**
	 * 初始化支付宝所需的资料信息
	 */
	$('#submitorder').click(function(){
		InitAgAlipayandUpdateOrder();
	});
	function InitAgAlipayandUpdateOrder(){
		var orderid=$('#hidorderid').val();
		var paymentid=$('input[name="paymentid"]:checked').val(); 
		var logisticsid=$('input[name="logisticsid"]:checked').val(); 
		var freight=$('#goodsfreightprice').html();
		var deliveraddressid=$('input[name="checkaddress"]:checked').val(); 
		var customernotes=$('#customernotes').val();
		var logisticswebaddress=$('#hd'+logisticsid).val();
		if(logisticsid==null){
			alert("请选择配送方式");
			return;
		}
		if(deliveraddressid==null){
			alert("请选择 收获地址");
			return;
		}
		if(paymentid!=null){
			$.post("InitAgAlipayandUpdateOrder.action",{"orderid":orderid,"paymentid":paymentid,"logisticsid":logisticsid,"logisticswebaddress":logisticswebaddress,"addressid":deliveraddressid,"customernotes":customernotes,"orderTag":"2"},function(data){
				if(data.spayment){
					alert("支付方式获取失败");
					return;
				}
				
				if(data.supdateorder){
					alert("更新订单出错");
					window.location.href="/usercenter/login.jsp";
				}else{
					//增加发票到发票记录表
					var inv_Payee=$('#inv_payee').val();
					var orderid=data.orderid;
					var inv_Type=$('#inv_type').val();
					var amount=$('#shouldtotalprice').text();
					if(inv_Payee==""){
						
						window.location.href="/alipay/alipayto.jsp";
						
					}else{
						$.post("addOrderInvoice.action",{"orderid":orderid,"invType":inv_Type,"invPayee":inv_Payee,"amount":amount,"invContent":"0"},function(data){
							if(data.saddflag){
								window.location.href="/alipay/alipayto.jsp";
							}else{
								alert("发票提交有误请联系客服处理开发票事宜");
								window.location.href="/alipay/alipayto.jsp";
								
							}
						});
					}
				}
				
			});
		}else{
			alert("请选择支付方式");
		}
	}
	
});


