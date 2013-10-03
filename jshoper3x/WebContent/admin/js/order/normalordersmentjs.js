
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
		  }
		  findProducts(productName);
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
				cache : false,
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
		}
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
		
		$("#normalordersmanagement").flexigrid( {
			url : 'findAllOrders.action',
			dataType : 'json',
			cache : false,
			colModel : [{
				display : '订单编号',
				name : 'orderid',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '订单名称',
				name : 'ordername',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				display : '总金额',
				name : 'amount',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				display : '总件数',
				name : 'needquantity',
				width : 50,
				sortable : true,
				align : 'center'
			}, {
				display : '订单购买人',
				name : 'membername',
				width : 150,
				sortable : true,
				align : 'center'
			}, {
				display : '收货人',
				name : 'shippingusername',
				width : 150,
				sortable : true,
				align : 'center'
			}, {
				display : '支付方式',
				name : 'paymentname',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '配送方式',
				name : 'delivermode',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '订单状态',
				name : 'orderstate',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '支付状态',
				name : 'paystate',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '发货状态',
				name : 'shippingstate',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '下单时间',
				name : 'purchasetime',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '发货时间',
				name : 'deliverytime',
				width : 100,
				sortable : true,
				align : 'center'
			},{
				display : '订单来源',
				name : 'orderTag',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '开票',
				name : 'invoice',
				width : 80,
				sortable : true,
				align : 'center'
			} ],
			buttons : [ {
				separator : true
			} ],
			buttons:[{
				name:'添加普通订单',
				bclass:'add',
				onpress:action
			}],
			searchitems : [ {
				display : '请选择搜索条件',
				name : 'sc',
				isdefault : true
			}, {
				display : '订单编号',
				name : 'orderid'
			}, {
				display : '收件人',
				name : 'shippingusername'
			} ],
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
			if(com=='添加普通订单'){
				window.location.href = "normalorder.jsp?operate=add&folder=orders";
				return;
			}
		}

		
		
		/**
		 * 增加普通订单
		 */
		saveNormalOrder=function(){
			
		},
		
		$("#submitorder").click(function(){
			
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
//			$.post("findMemberByloginname.action",{"loginname":loginname},function(data){
//				if(data.sucflag){
//					$("#hidmemberid").val(data.bean.memberid);
//					return true;
//				}else{
//					$("#accountcheckinfo").text("账号不存在");
//					return true;
//				}
//			});
			
		});
		/**
		 * main logic
		 */
		var operate = $.query.get("operate");
		if (operate == "add") {
			
		}else if(operate=="edit"){
		
		}else if(operate=="find"){
			
		}
});
