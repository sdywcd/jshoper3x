//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}

/**
 * 支付宝发货同步
 * @return
 */
function CheckForm()
{
	if ($('#trade_no').val()=="") {
		alert("请输入支付宝交易号.");
		return false;
	}
	if ($('#logistics_name').val()=="") {
		alert("请输入物流公司名称.");
		return false;
	}
	if ($('#invoice_no').val()=="") {
		alert("请输入物流发货单号.");
		return false;
	}


}  




//获取系统时间
var invoicenumber="";

function getSytimeForInvoiceNumber(){
	var myDate=new Date();
	invoicenumber=myDate.getFullYear().toString()+myDate.getMonth().toString()+myDate.getDate().toString()+myDate.getDay().toString()+myDate.getHours().toString()+myDate.getMinutes().toString()+myDate.getSeconds().toString()+myDate.getMilliseconds().toString();
}


//flexigrid
$(function() {
	$('#orderupdatemsg').html("");
	$.post("CheckLogin.action",function(data){
		if(data.slogin){
			top.location.href="jshop/admin/adminlogin.jsp";
		}
	});
	
	/**
	 * 点击更新发货单号
	 */
	$('#updateinvoicenumber').click(function(){
		var orderid=$('#hidorderid').val();
		var invoicenumber=$('#invoicenumber').val();
		$.post("UpdateInvoicenumberByOrderId.action",{"orderid":orderid,"invoicenumber":invoicenumber},function(data){
			window.location.href="InitOrdersDetail.action?orderid="+data.orderid;
		});
	});
	/**
	 * 点击更新快递单号
	 */
	$('#updateexpressnumber').click(function(){
		var orderid=$('#hidorderid').val();
		var expressnumber=$('#expressnumber').val();
		$.post("UpdateExpressnumberByOrderId.action",{"orderid":orderid,"expressnumber":expressnumber},function(data){
			window.location.href="InitOrdersDetail.action?orderid="+data.orderid;
		});
	});
	
//	/**
//	 * 同步发货
//	 */
//	$("#shipping_order").toggle(
//			  function(){
//			    $("#tbfh").show();
//			  },
//			  function(){
//				  $("#tbfh").hide();
//			  }
//	); 
	
	/**
	 * 点击输入发货单号
	 */
	$("#set_invoicenumber").toggle(
			  function(){
			    $("#setinvoicenumberarea").show();
			  },
			  function(){
				  $("#setinvoicenumberarea").hide();
			  }
	); 

	/**
	 * 点击输入快递单号
	 */
	$("#set_expressnumber").toggle(
			  function(){
			    $("#setexpressnumberarea").show();
			  },
			  function(){
				  $("#setexpressnumberarea").hide();
			  }
	); 
	
	/**
	 * 点击生成发货单号
	 * 
	 */
	$('#getrandominvoicenumber').click(function(){
		getSytimeForInvoiceNumber();
		$('#invoicenumber').val(invoicenumber);
	});
	
	/**
	 * 点击关闭按钮
	 */
	$('#close_order').click(function(){
		var orderid=$('#hidorderid').val();
		$.post("UpdateOrderToClose.action",{"orderid":orderid},function(data){
			
			window.location.href="InitOrdersDetail.action?orderid="+data.orderid;			
				jAlert('订单关闭成功','信息提示');			
		});
	});
	/**
	 * 点击确认按钮
	 */
	$('#confirm_order').click(function(){
		var orderid=$('#hidorderid').val();
		$.post("UpdateOrderToConfirm.action",{"orderid":orderid},function(data){
			window.location.href="InitOrdersDetail.action?orderid="+data.orderid;
			jAlert('订单确认成功','信息提示');	
			
		});
	});
	/**
	 * 点击发货按钮
	 */
//	$('#shipping_order').click(function(){
//		var orderid=$('#hidorderid').val();
//		var nowpaystate=$('#nowpaystate').html();
//		var paystate="";
//		if(nowpaystate=="未付款"){
//			paystate="0";
//		}
//		if(nowpaystate=="已付款"){
//			paystate="1";
//		}
			
//		$.post("UpdateOrderToDelivery.action",{"orderid":orderid,"paystate":paystate},function(data){
//			window.location.href="InitOrdersDetail.action?orderid="+data.orderid;
//			$('#orderupdatemsg').html("订单发货成功");
//		});
//	});
	/**
	 * 点击同步发货按钮获取数据
	 */
	$('#shipping_order').click(function(){
		var orderid=$('#hidorderid').val();
		$.post("GetAlipayFhNeedParams.action",{"orderid":orderid},function(data){
			$('#trade_no').attr("value",data.tradeno);
			$('#transprot_type').val(data.delivermode);
			$('#logistics_name').attr("value",data.logisticsname);
			$('#invoice_no').attr("value",data.expressnumber);
			$('#hidpaymentid').attr("value",data.paymentid);
		});
		
	});
	
	
	
	/**
	 * 点击付款按钮
	 */
	$('#pay_order').click(function(){
		var orderid=$('#hidorderid').val();
		$.post("UpdateOrderToPay.action",{"orderid":orderid},function(data){
			window.location.href="InitOrdersDetail.action?orderid="+data.orderid;
			jAlert('订单付款成功','信息提示');
			
		});
	});
	
	/**
	 * 点击打印快递单
	 */
	$('#print_express').click(function(){
		$.post("CheckLogin.action",function(data){
			if(data.slogin){
				top.location.href="jshop/admin/adminlogin.jsp";
			}
		});
		var orderid=$('#hidorderid').val();
		window.open("jshop/admin/order/printexpress.jsp?orderid="+orderid, "打印快递单"); 
		
		
		
	});
	
	/**
	 * 点击打印快递单
	 */
	$('#print_invoice').click(function(){
		$.post("CheckLogin.action",function(data){
			if(data.slogin){
				top.location.href="jshop/admin/adminlogin.jsp";
			}
		});
		var orderid=$('#hidorderid').val();
		window.open("jshop/admin/order/printinvoice.jsp?orderid="+orderid, "打印发货单"); 
		
		
		
	});
	
	/**
	 * 同步发货
	 */
	
	$('#alipaysendgoods').click(function(){
		CheckForm();
		var paymentid=$('#hidpaymentid').val();
		var trade_no=$('#trade_no').val();
		var transport_type=$('#transport_type').val();
		alert(transport_type);
		var logistics_name=$('#logistics_name').val();
		var invoice_no=$('#invoice_no').val();
		$.post("GetFhPaymentinfo.action",{"paymentid":paymentid},function(data){
			if(data.spaymentflag){
				window.location.href="jshop/admin/alipay/fh/sendgoods.jsp?trade_no="+trade_no+"&transport_type="+transport_type+"&logistics_name="+logistics_name+"&invoice_no="+invoice_no+"";
			}
		});
		
	});
	
	
	
});
