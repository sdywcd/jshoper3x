
/**
 * flexigrid list 
 */
$(function() {
	$().button('loading');
	/**
	 * ui
	 */
	  $('input').iCheck({
		    checkboxClass: 'icheckbox_square-blue',
		    radioClass: 'iradio_square-blue',
		    increaseArea: '20%' // optional
		  });
	 
	  $("#searchproduct").click(function(){
		  var productName=$("#productName").val();
		  if(productName==""){
			  formwarning("#alerterror", "请输入内容再进行查询");
				return false;
		  }else{
			  findProducts(productName);
		  }
		 
	  });
	  /**
	   * 重新计算商品件数
	   */
	  recaluatemneedquantity=function(){
		//商品件数
		var oldneedquantity=$("#needquantity").text()*1;
		$("#needquantity").text(oldneedquantity-1);
		
	  },
	  /**
	   * 重新计算订单商品总价格
	   */
	  recaluatememberprice=function(memberprice){
		//总金额
		var oldamount=$("#amount").text()*1.0;
		$("#amount").text(oldamount-memberprice*1.0)
	  },
	  /**
	   * 重新计算订单商品应支付
	   */
	  recaluateshouldpay=function(memberprice){
		 var oldshouldpay=$("#shouldpayspan").text()*1.0;
		 $("#shouldpayspan").text(oldshouldpay-memberprice*1.0);
		 $("#shouldpay").val(oldshouldpay-memberprice*1.0);
	  },

	  
	  /*
		 * Delete Page elements According to rid 
		 */
	  delParamPChild=function(rid){
		$('#orderinfo'+rid).remove();
	  },
	
	  /**
	   * 重新计算订单信心并删除页面订单中的商品
	   */
	  delParamPChildAndReOrderInfo=function(productSn,memberprice){
		  delParamPChild(productSn);
		  recaluatemneedquantity();
		  recaluatememberprice(memberprice);
		  recaluateshouldpay(memberprice);
	  }

	  	/**
		 * 查询货物
		 */
		findProducts=function(param){
			$("#productsmanagement").flexigrid({
				url : "findProductByproductName.action?productName="+param,
				dataType : 'json',
				cache : true,
				colModel : [ {
					display : '货号',
					name : 'productSn',
					width : 100,
					sortable : true,
					align : 'center'
				}, {
					display : '货物名称',
					name : 'productName',
					width : 500,
					sortable : true,
					align : 'center'
				}, {
					display : '市场价',
					name : 'price',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '会员价',
					name : 'memberprice',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '成本价',
					name : 'cost',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '销售价',
					name : 'saleprice',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '预警库存',
					name : 'freezeStore',
					width : 60,
					sortable : true,
					align : 'center'
				}, {
					display : '库存',
					name : 'store',
					width : 60,
					sortable : true,
					align : 'center'
				}, {
					display : '重量',
					name : 'weight',
					width : 40,
					sortable : true,
					align : 'center'
				}, {
					display : '创建时间',
					name : 'createtime',
					width : 150,
					sortable : true,
					align : 'center'
				} ],
				buttons : [ {
					name : '加入订单',
					bclass : 'add',
					onpress : action
				}, {
					separator : true
				} ],

				searchitems : [ {
					display : '请选择搜索条件',
					name : 'sc',
					isdefault : true
				}],
				sortname : "createtime",
				sortorder : "desc",
				usepager : true,
				title : '',
				useRp : true,
				rp : 20,
				rpOptions : [ 5, 20, 40, 100 ],
				showTableToggleBtn : true,
				showToggleBtn : true,
				width : 'auto',
				height : 'auto',
				pagestat : '显示{from}到{to}条，共{total}条记录',
				procmsg : '正在获取数据，请稍候...',
				checkbox : true
			});
			function action(com, grid) {
				if (com == '加入订单') {
					setGoodsToOrderForm(grid);
				} 
			}
		},
		/**
		 * 将商品加入订单试图中
		 * @param grid
		 * @returns
		 */
		setGoodsToOrderForm=function(grid){
			if($('.trSelected',grid).length==1){
				var html="";
				var productId="";
				var productSn="";
				var productName="";
				var memberprice=0.0;
				var store="";
				var needquantity=1;
				$('.trSelected', grid).each(function() {
					productId = this.id.substr(3);
				});
				$(".trSelected td:nth-child(2) div", $('#productsmanagement')).each(function(i){
					productSn=this.innerHTML;
				});
				$(".trSelected td:nth-child(3) div", $('#productsmanagement')).each(function(i){
					productName=this.innerHTML;
				});
				$(".trSelected td:nth-child(4) div", $('#productsmanagement')).each(function(i){
					memberprice=this.innerHTML;
				});
				$(".trSelected td:nth-child(8) div", $('#productsmanagement')).each(function(i){
					store=this.innerHTML;
				});
				html+="<tr id='orderinfo"+productSn+"' class='success'><td >"+productSn+"</td><td>"+productName+"</td><td>"+memberprice+"</td><td>1</td><td>"+store+"</td><td><a href='javascript:delParamPChildAndReOrderInfo("+productSn+","+memberprice+");'>删除</a></td></tr>"
				$("#orderinfo").append(html);
				//设置隐藏的货物id字符串
				var oldproductid=$("#hidproductid").val();
				$("#hidproductid").val(oldproductid+productId+",");
				//商品件数
				var oldneedquantity=$("#needquantity").text()*1;
				if(oldneedquantity==0){
					$("#needquantity").text(needquantity);
				}else{
					$("#needquantity").text(oldneedquantity+needquantity);
				}
				//总金额
				var oldamount=$("#amount").text()*1.0;
				if(oldamount==0.0){
					$("#amount").text(memberprice);
				}else{
					$("#amount").text(oldamount+memberprice*1);
				}
				//应支付 总金额+运费=订单总价（应支付）
				var oldshouldpay=$("#shouldpayspan").text()*1.0;
				if(oldshouldpay==0.0){
					$("#shouldpayspan").text(memberprice);
				}else{
					$("#shouldpayspan").text(oldshouldpay+memberprice*1);
				}
				
				//设置订单名称
				var ordername=$("#ordername").val();
				if(ordername==""){
					$("#ordername").val(productName);
				}
				//设置运费
				var freightspan=$("#freightspan").text()*1.0;
				$("#freight").val(freightspan);
				//应支付
				$("#shouldpay").val(freightspan+$("#shouldpayspan").text()*1.0);
			
				
			}else{
				formwarning("#alerterror", "请选择一条商品");
				return false;
			}
		},
		
		/**
		 * 根据会员名称查询可用的收货地址
		 */
		findDeliverAddressBymemberName=function(membername){
			$("#deliveraddressmanagement").flexigrid( {
				url : 'findDeliverAddressBymemberName.action?membername='+membername,
				dataType : 'json',
				cache : false,
				colModel : [{
					display : '收货人',
					name : 'shippingusername',
					width : 100,
					sortable : true,
					align : 'center'
				}, {
					display : '国家',
					name : 'country',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '省份',
					name : 'province',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '城市',
					name : 'city',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '区域',
					name : 'district',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '街道',
					name : 'street',
					width : 150,
					sortable : true,
					align : 'center'
				}, {
					display : '邮编',
					name : 'postcode',
					width : 80,
					sortable : true,
					align : 'center'
				}, {
					display : '手机号码',
					name : 'mobile',
					width : 100,
					sortable : true,
					align : 'center'
				}, {
					display : '状态',
					name : 'state',
					width : 100,
					sortable : true,
					align : 'center'
				}, {
					display : '会员ID',
					name : 'memberid',
					width : 100,
					sortable : true,
					align : 'center'
				},{
					display : '创建时间',
					name : 'createtime',
					width : 100,
					sortable : true,
					align : 'center'
				}],
				buttons : [ {
					separator : true
				} ],
				buttons:[{
					name:'选择这个收货地址',
					bclass:'add',
					onpress:action
				}],
				searchitems : [ {
					display : '请选择搜索条件',
					name : 'sc',
					isdefault : true
				}],
				sortname : "createtime",
				sortorder : "desc",
				usepager : true,
				title : '',
				useRp : true,
				rp : 20,
				rpOptions : [ 5, 20, 40, 100 ],
				showTableToggleBtn : true,
				width : 'auto',
				height : 'auto',
				pagestat : '显示{from}到{to}条，共{total}条记录',
				procmsg : '正在获取数据，请稍候...',
				checkbox:true
			});
			function action(com,grid){
				if(com=="选择这个收货地址"){
					if($('.trSelected',grid).length==1){
						var str="";
						$('.trSelected',grid).each(function(){
							str=this.id.substr(3);
						});
						$("#hidshippingaddressid").val(str);
						var str1="";
						$(".trSelected td:nth-child(11) div", $('#deliveraddressmanagement')).each(function(i){
							str1=this.innerHTML;
						});
						$("#hidmemberid").val(str1);
						return;
					}else{
						formwarning("#alerterror", "请选择一条发货地址信息");
						return false;
					}
					
				}
			}
		},
		
		
		
		/**
		 * 增加普通订单
		 */
		saveNormalOrder=function(){
			//获取货物id字符串
			var productid=$("#hidproductid").val();
			productid=productid.substring(0,productid.length-1);
			//检查是否选择了发货地址
			var hidshippingaddressid=$("#hidshippingaddressid").val();
			if(hidshippingaddressid==""){
				formwarning("#alerterror","请先搜索并选择可用的发货地址");
				return false;
			}
			//获取隐藏的会员id通过搜索发货地址获取
			var memberid=$("#hidmemberid").val();
			//获取搜索收货地址填写的会员名称
			var membername=$("#membername").val();
			//获取选择的支付方式
			var paymentid=$("input[name='paystate']:checked").val();
			//获取物流商id
			var logisticsid=$("input[name='delivermode']:checked").val();
			//获取运费
			var freight=$("#freight").val()*1.0;
			//获取总金额
			var amount=$("#amount").text()*1.0;
			//获取是否开票
			var isinvoice=$("input[name='isinvoice']:checked").val();
			//获取订单备注
			var customerordernotes=$("#customerordernotes").val();
			if(customerordernotes==""){
				customerordernotes="";
			}
			//获取订单类型
			var orderTag=$("input[name='orderTag']:checked").val();
			//获取应支付金额
			var shouldpay=$("#shouldpay").val()*1.0;
			//获取订单名称
			var ordername=$("#ordername").val();
			//获取发票相关信息
			var invPayee=$("#invPayee").val();
			$.post("InitNormalOrderNeedInfoBack.action",{
				"productid":productid,
				"hidshippingaddressid":hidshippingaddressid,
				"memberid":memberid,
				"membername":membername,
				"paymentid":paymentid,
				"logisticsid":logisticsid,
				"freight":freight,
				"amount":amount,
				"isinvoice":isinvoice,
				"customerordernotes":customerordernotes,
				"orderTag":orderTag,
				"shouldpay":shouldpay,
				"ordername":ordername,
				"invPayee":invPayee
			},function(data){
				if(data.sucflag){
					window.location.href = "normalordersment.jsp?operate=find&folder=orders";
					return;
				}
			})
			
			
		}
		/**
		 * 点击提交订单
		 */
		$("#submitorder").click(function(){
			saveNormalOrder();
		});
	
		/**
		 * 点击修改订单总价
		 */
		$("#tomodifyshouldpay").click(function(){
			$("#modifyshouldpay").show();
		});
		/**
		 * 显示是否确认修改订单价格空间
		 */
		$("#confirmtoupdateshouldpay").click(function(){
			$('#myModal').modal('hide');
			//把填写的修改订单价格写入到页面
			var mshouldpay=$("#mshouldpay").val();
			$("#shouldpay").val(mshouldpay);
		});
		/**
		 * 点击搜索可用发货地址
		 */
		$("#searchdeliveraddress").click(function(){
			var membername=$("#membername").val();
			if(membername==""){
				$("#accountcheckinfo").text("请输入账号");
				return false;
			}
			findDeliverAddressBymemberName(membername);
			
		});
		/**
		 * 获取系统中的物流商信息填充到页面中去
		 */
		findAllLogisticsBusinessForbsOrder=function(){
			$.get("findAllLogisticsBusinessForbsOrder.action",function(data){
				if(data.sucflag){
					var html="";
					$.each(data.logisticsbusiness,function(k,v){
						html+="<input type='radio' id='delivermode' name='delivermode' value='"+v.logisticsid+"' />" +
								"<label for='radio-1'>"+v.logisticsname+"</label>";
					});
					$("#delivermodearea").html(html);
					
				}
			});
		},
		/**
		 * 获取系统中的支付支持信息填充到页面中去
		 */
		findAllPaymentForbsOrder=function(){
			$.get("findAllPaymentForbsOrder.action",function(data){
				if(data.sucflag){
					var html="";
					$.each(data.beanlist,function(k,v){
						html+="<input type='radio' id='paystate' name='paystate' value='"+v.paymentid+"' />" +
						"<label for='radio-1'>"+v.paymentname+"</label>";
					});
					$("#paystatearea").html(html);
				}
			});
		}
		/**
		 * 点击保存收货地址
		 */
		$("#savedeliveraddress").click(function(){
			var membername=$("#membername").val();
			if(membername==""){
				formwarning("#alerterror","请填写一个会员名称以便新增的收货地址可以成功增加");
				return false;
			}
			var shippingusername=$("#shippingusername").val();
			if(shippingusername==""){
				formwarning("#alerterror","请填写一个收货人");
				return false;
			}
			var country=$("#country").val();
			if(country==""){
				formwarning("#alerterror","请填写国家");
				return false;
			}
			var province=$("#province").val();
			if(province==""){
				formwarning("#alerterror","请填写省份");
				return false;
			}
			var city=$("#city").val();
			if(city==""){
				formwarning("#alerterror","请填写城市");
				return false;
			}
			var district=$("#district").val();
			var street=$("#street").val();
			if(street==""){
				formwarning("#alerterror","请填写详细地址");
				return false;
			}
			var postcode=$("#postcode").val();
			var mobile=$("#mobile").val();
			if(mobile==""){
				formwarning("#alerterror","请填写手机号码");
				return false;
			}
			var telno=$("#telno").val();
			var email=$("#email").val();
			this.value="提交中";
			$.post("saveDeliverAddressbsOrder.action",{
				"membername":membername,
				"shippingusername":shippingusername,
				"country":country,
				"province":province,
				"city":city,
				"street":street,
				"postcode":postcode,
				"mobile":mobile,
				"telno":telno,
				"email":email,
				"district":district
			},function(data){
				if(data.sucflag){
					$("#deliveraddressmanagement").flexReload();
				}
			});
		});
		
		
		/**
		 * main logic
		 */
		var operate = $.query.get("operate");
		if (operate == "add") {
			//调用查询物流商方法
			findAllLogisticsBusinessForbsOrder();
			//调用查询支付方式方法
			findAllPaymentForbsOrder();
		}else if(operate=="edit"){
		
		}else if(operate=="find"){
			
		}
});
