$(function() {
	/**
	 * ui
	 */
	  $('input').iCheck({
		    checkboxClass: 'icheckbox_square-blue',
		    radioClass: 'iradio_square-blue',
		    increaseArea: '20%' // optional
		  });
	

	

	/**
	 * 获取所有产品规格值列表
	 */
	findAllSpecificationsforjson=function(data){
		$.ajax({
			url:"findAllSpecificationsforjson.action",
			type:"post",
			async:false,
			success:function(data){
				if(data.sucflag){
					var header="<option value='0'>---请选择---</option><option value='1'>默认规格</option>";
					var body="";
					$(data.specificationList).each(function(k,v){
						body+="<option value='"+v.specificationsid+"'>"+v.name+"</option>";
					});
					$("#isSpecificationsOpen").append(header).append(body);
				}
			}
		});
	},
	/**
	 * 根据规格值id获取规格值信息
	 */
	findProductSpecificationsTByspecificationsid=function(specificationsid){
		$.ajax({
    		url:'findProductSpecificationsTByspecificationsid.action', 
    		type:"post",
    		data:{"specificationsid":specificationsid},
    		dataType:'json',
    		async:false,
    		success:function(data){
    			if(data.sucflag){
    				$("#specificationtext").text(data.bean.name);
    				var html="";
    				var jsonObject=$.parseJSON(data.bean.specificationsValue);
    				if(data.bean.specificationsType=="3"){
    					//3表示颜色类型
    					$.each(jsonObject,function(k,v){
        					html+="<div style='margin-right:10px; display: inline;padding-left:90px;padding-top:5px;padding-bottom:5px;background:"+v.specifivalue+"'>" +
        								"<input  id='colortype' name='colortype' type='checkbox'  value='"+v.specifivalue+"' />" +
        								"</div>";
        				});
    				}else if(data.bean.specificationsType=="2"){
    					//2表示图片类型
    					$.each(jsonObject,function(k,v){
        					html+="<div style='margin-right:10px; display: inline;padding-top:5px;padding-bottom:5px;'>" +
        								"<img width='200px' height='200px' src='../.."+v.specifivalue+"'/>" +
        								"<input id='imgtype' name='imgtype' type='checkbox'  value='"+v.specifivalue+"' />" +
        								"</div>";
        				});
    				}else if(data.bean.specificationsType=="1"){
    					//1表示文字类型
    					$.each(jsonObject,function(k,v){
        					html+="<div style='margin-right:10px; display: inline;padding-top:5px;padding-bottom:5px;'>" +
        								"<span>"+v.specifivalue+"</span>" +
        								"<input id='texttype' name='texttype' type='checkbox'  value='"+v.specifivalue+"' />" +
        								"</div>";
        				});
    				}
    				//在页面上保存一个规格值类型的隐藏域作为增加商品时取值使用
    				var hidspecificationsType="<input type='hidden' id='hidspecificationsType' name='hidspecificationsType' value='"+data.bean.specificationsType+"'></input>";
    				$("#specificationvaluearea").text("").append(html).append(hidspecificationsType);
    			}
    		
    		}
    	 });
	},
	
	
	/**
	 * 当规格选择时动态加载产品信息填充区域
	 */
	$("#isSpecificationsOpen").change(function(){
		var isSpecificationsOpen=$("#isSpecificationsOpen").val();
		var specificationsName=$("#isSpecificationsOpen").find("option:selected").text();
		if(isSpecificationsOpen=="0"){
			return false;
		}
		if(isSpecificationsOpen=="1"){
			//加载默认产品结构信息，即不包括任何规格值，表示商品信息对应一个产品
			$("#specificationsarea").show();
			$("#spname").text(specificationsName);
		}else{
			//动态获取规格对应的值列表【1=文字类型】【2=图片类型】【3颜色类型】
			$("#specificationsarea").show();
			findProductSpecificationsTByspecificationsid(isSpecificationsOpen);
			$("#spname").text(specificationsName);
		}
	});
	
	/**
	 * 绑定需要编辑的货物数据
	 */
	findProductByProductid=function(){
		var productid = $.query.get("productid");
		if(productid==""){
			return false;
		}
		
		$.post("findProductByProductid.action",{"productid":productid},function(data){
			if(data.sucflag){
				$("#isSpecificationsOpen").val(data.bean.specificationsid);
				$("#productSn").val(data.bean.productSn);
				$("#productName").val(data.bean.productName);
				$("#cost").val(data.bean.cost);
				$("#saleprice").val(data.bean.saleprice);
				$("#memberprice").val(data.bean.memberprice);
				$("#price").val(data.bean.price);
				$("#weight").val(data.bean.weight);
				$("#unit").val(data.bean.unit);
				$("#store").val(data.bean.store);
				$("#freezeStore").val(data.bean.freezeStore);
				$("#warehouseLocation").val(data.bean.warehouseLocation);
				$("#placeStore").val(data.bean.placeStore);
				if(data.bean.isDefault=="1"){
					$("input[name='isDefault']").get(0).checked=true;
				}else{
					$("input[name='istaskschedule']").get(1).checked=true;
				}
				if(data.bean.isSalestate=="1"){
					$("input[name='isSalestate']").get(0).checked=true;
				}else{
					$("input[name='isSalestate']").get(1).checked=true;
				}
				//这里绑定选择的规格值(这里的texttype，imgtype，colortype表示的是规格值设置中的规格类型，是定死的，且是一个关键判定标记)
				findProductSpecificationsTByspecificationsid(data.bean.specificationsid);
				var jsonstr=$.parseJSON(data.bean.specificationsValue);
				$.each(jsonstr,function(k,v){
					if(v.type=="texttype"){
						$("input[name='texttype']").each(function(){
							 if($(this).attr("value")==v.specificationsValue){
								 $(this).attr("checked",true);
							 }
						});
					}else if(v.type=="imgtype"){
						$("input[name='imgtype']").each(function(){
							 if($(this).attr("value")==v.specificationsValue){
								 $(this).attr("checked",true);
							 }
						});
					}else if(v.type=="colortype"){
						$("input[name='colortype']").each(function(){
							 if($(this).attr("value")==v.specificationsValue){
								 $(this).attr("checked",true);
							 }
						});
					}
				});
				$("#hidproductid").val(data.bean.productid);
				$("#submit").hide();
				$("#update").show();
				
			}
		});
	},
	
	
	
	/**
	 * 检测规格值每次每种只能选择一个规格值
	 */
	checkSpecifications=function(){
		//这里无法读取到具体的规格值是什么类型的？是图片？文字？颜色？所以只能便利判定了
		var texttypecount=0;
		$("input[name='texttype']").each(function(){
			 if($(this).attr("checked")){
				 ++texttypecount;
			 }
		});
		var imgtypecount=0;
		$("input[name='imgtype']").each(function(){
			if($(this).attr("checked")){
				 ++imgtypecount;
			 }
		});
		var colortypecount=0;
		$("input[name='colortype']").each(function(){
			if($(this).attr("checked")){
				 ++colortypecount;
			 }
		});
		
		if(texttypecount>1||imgtypecount>1||colortypecount>1){
			formwarning("#alerterror", "规格值每次每个类别只能选择一个");
			return false;
		}
		return true;
	},
	
	
	
	
	/**
	 * 获取所选的规格值
	 */
	getselectSpecificationsVal=function(){
		//这里要获取所选的规格值
		var specificationsValue="";
		var hidspecificationsType=$("#hidspecificationsType").val();
		if(hidspecificationsType=="1"){
			//文字类型【1=文字类型】【2=图片类型】【3颜色类型】
			$("input[name='texttype']").each(function(){
				if($(this).attr("checked")){
					specificationsValue+="{\"type\":\"texttype\",\"specificationsValue\":\""+this.value+"\"},";
				}
			});
			specificationsValue="["+specificationsValue.toString().substring(0, specificationsValue.length-1)+"]";
		}else if(hidspecificationsType=="2"){
			$("input[name='imgtype']").each(function(){
				if($(this).attr("checked")){
					specificationsValue+="{\"type\":\"imgtype\",\"specificationsValue\":\""+this.value+"\"},";
				}
			});
			specificationsValue="["+specificationsValue.toString().substring(0, specificationsValue.length-1)+"]";
		}else if(hidspecificationsType=="3"){
			$("input[name='colortype']").each(function(){
				if($(this).attr("checked")){
					specificationsValue+="{\"type\":\"colortype\",\"specificationsValue\":\""+this.value+"\"},";
				}
			});
			specificationsValue="["+specificationsValue.toString().substring(0, specificationsValue.length-1)+"]";
		}
		return specificationsValue;
	},
	
	/**
	 * 保存货物
	 * @returns
	 */
	saveProductT=function(){
		
		if(!checkSpecifications()){
			return false;
		}
		var isSpecificationsOpen=$("#isSpecificationsOpen").val();//所选的规格值id
		if(isSpecificationsOpen=='0'){
			formwarning("#alerterror","请选择一个货物规格");
			return false;
		}
		var specificationsName=$("#isSpecificationsOpen").find("option:selected").text();//所选规格值名称
		//提取选择的规格值
		var specificationsValue=getselectSpecificationsVal();
		var productName=$("#productName").val();
		if(productName==""){
			formwarning("#alerterror","请填写商品名称");
			return false;
		}
		var productSn=$("#productSn").val();
		var cost=$("#cost").val();
		var saleprice=$("#saleprice").val();
		var memberprice=$("#memberprice").val();
		var price=$("#price").val();
		var weight=$("#weight").val();
		var unit=$("#unit").val();
		var store=$("#store").val();
		var freezeStore=$("#freezeStore").val();
		var warehouseLocation=$("#warehouseLocation").val();
		var placeStore=$("#placeStore").val();
		var isDefault=$("input[name='isDefault']:checked").val();
		var isSalestate=$("input[name='isSalestate']:checked").val();
		//获取商品id，判定是否从good.jsp过来的请求
		var goodsid = $.query.get("goodsid");
		this.value="提交中";
		this.disabled=true;
		$.post("saveProductT.action",{
			"goodsid":goodsid,
			"specificationsValue":specificationsValue,
			"specificationsid":isSpecificationsOpen,
			"specificationsName":specificationsName,
			"productName":productName,
			"productSn":productSn,
			"cost":cost,
			"saleprice":saleprice,
			"memberprice":memberprice,
			"price":price,
			"weight":weight,
			"unit":unit,
			"store":store,
			"freezeStore":freezeStore,
			"warehouseLocation":warehouseLocation,
			"placeStore":placeStore,
			"isDefault":isDefault,
			"isSalestate":isSalestate
		},function(data){
			if(data.sucflag){
				window.location.href="productment.jsp?operate=find&folder=goods";
			}
		});
	},
	
	/**
	 * 更新货物
	 * @returns
	 */
	updateProductT=function(){
		if(!checkSpecifications()){
			return false;
		}
		var productid=$("#hidproductid").val();
		var isSpecificationsOpen=$("#isSpecificationsOpen").val();//所选的规格值id
		if(isSpecificationsOpen=='0'){
			formwarning("#alerterror","请选择一个货物规格");
			return false;
		}
		var specificationsName=$("#isSpecificationsOpen").find("option:selected").text();//所选规格值名称
		//提取选择的规格值
		var specificationsValue=getselectSpecificationsVal();
		var productName=$("#productName").val();
		if(productName==""){
			formwarning("#alerterror","请填写商品名称");
			return false;
		}
		var productSn=$("#productSn").val();
		var cost=$("#cost").val();
		var saleprice=$("#saleprice").val();
		var memberprice=$("#memberprice").val();
		var price=$("#price").val();
		var weight=$("#weight").val();
		var unit=$("#unit").val();
		var store=$("#store").val();
		var freezeStore=$("#freezeStore").val();
		var warehouseLocation=$("#warehouseLocation").val();
		var placeStore=$("#placeStore").val();
		var isDefault=$("input[name='isDefault']:checked").val();
		var isSalestate=$("input[name='isSalestate']:checked").val();
		this.value="提交中";
		this.disabled=true;
		$.post("updateProductT.action",{
			"productid":productid,
			"specificationsValue":specificationsValue,
			"specificationsid":isSpecificationsOpen,
			"specificationsName":specificationsName,
			"productName":productName,
			"productSn":productSn,
			"cost":cost,
			"saleprice":saleprice,
			"memberprice":memberprice,
			"price":price,
			"weight":weight,
			"unit":unit,
			"store":store,
			"freezeStore":freezeStore,
			"warehouseLocation":warehouseLocation,
			"placeStore":placeStore,
			"isDefault":isDefault,
			"isSalestate":isSalestate
		},function(data){
			if(data.sucflag){
				window.location.href="productment.jsp?operate=find&folder=goods";
			}
		});
	},
	
	/**
	 * 点击更新调用更新货物方法
	 */
	$("#update").click(function(){
		updateProductT();
	});
	
	/**
	 * 点击提交调用保存货物方法
	 */
	$("#submit").click(function(){
		saveProductT();
	});
	
	/**
	 * 查询货物
	 */
	findProducts=function(param){
		$("#productsmanagement").flexigrid({
			url : 'findAllProducts.action?'+param,
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
				width : 200,
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
			}, {
				display : '操作',
				name : 'operating',
				width : 60,
				sortable : true,
				align : 'center'
			} ],
			buttons : [ {
				name : '添加',
				bclass : 'add',
				onpress : action
			}, {
				name : '编辑',
				bclass : 'edit',
				onpress : action
			}, {
				name : '删除',
				bclass : 'del',
				onpress : action
			}, {
				separator : true
			} ],

			searchitems : [ {
				display : '请选择搜索条件',
				name : 'sc',
				isdefault : true
			}, {
				display : '货号',
				name : 'productSn'
			}, {
				display : '商品ID',
				name : 'goodsid'
			} ],
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
			if (com == '添加') {
				window.location.href = "product.jsp?operate=add&folder=goods";
				return;

			} else if (com == '编辑') {
				if ($('.trSelected', grid).length == 1) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str = this.id.substr(3);
					});
					window.location.href = "product.jsp?operate=edit&folder=goods&productid="
							+ str;
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			} else if (com == '删除') {
				if ($('.trSelected', grid).length > 0) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str += this.id.substr(3) + ",";
					});
					$.post("delProductT.action", {
						"productid" : str
					}, function(data) {
						if (data.sucflag) {
							$('#productsmanagement').flexReload();
							forminfo("#alertinfo", "删除货物成功");
						}
					});
				} else {
					formwarning("#alerterror", "请选择要删除的信息");
					return false;
				}
			} 
		}
	}
	
	
	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		var goodsname=$.query.get("goodsname");
		if(goodsname!=""){
			setdttitle("#dttitle","增加"+goodsname+"的货物信息");
		}
		findAllSpecificationsforjson();
		
	}else if(operate=="edit"){
		var goodsid=$.query.get("goodsid");
		if(goodsid==""){
			findAllSpecificationsforjson();
			findProductByProductid();
		}else{
			var param="qtype=goodsid&goodsid="+goodsid;
			findProducts(param);
		}
	}else if(operate=="find"){
		var goodsname=$.query.get("goodsname");
		if(goodsname!=""){
			var param="qtype=goodsid&goodsid="+goodsname;
			setdttitle("#dttitle",goodsname+"的所有货物列表");
			findProducts(param);
		}else{
			var param="qtype=sc";
			findProducts(param);
		}
		
	}
});

