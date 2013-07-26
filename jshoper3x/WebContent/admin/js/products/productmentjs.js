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
		$.post("findAllSpecificationsforjson.action",function(data){
			if(data.sucflag){
				var header="<option value='0'>---请选择---</option><option value='1'>默认规格</option>";
				var body="";
				$(data.specificationList).each(function(k,v){
					body+="<option value='"+v.specificationsid+"'>"+v.name+"</option>";
				});
				$("#isSpecificationsOpen").append(header).append(body);
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
        								"<input  id='colortype' name='colortype' type='checkbox'  value="+v.specifivalue+"/>" +
        								"</div>";
        				});
    				}else if(data.bean.specificationsType=="2"){
    					//2表示图片类型
    					$.each(jsonObject,function(k,v){
        					html+="<div style='margin-right:10px; display: inline;padding-top:5px;padding-bottom:5px;'>" +
        								"<img width='200px' height='200px' src='../.."+v.specifivalue+"'/>" +
        								"<input id='imgtype' name='imgtype' type='checkbox'  value="+v.specifivalue+"/>" +
        								"</div>";
        				});
    				}else if(data.bean.specificationsType=="1"){
    					//1表示文字类型
    					$.each(jsonObject,function(k,v){
        					html+="<div style='margin-right:10px; display: inline;padding-top:5px;padding-bottom:5px;'>" +
        								"<span>"+v.specifivalue+"</span>" +
        								"<input id='texttype' name='texttype' type='checkbox'  value="+v.specifivalue+"/>" +
        								"</div>";
        				});
    				}
    				//在页面上保存一个规格值类型的隐藏域作为增加商品时取值使用
    				var hidspecificationsType="<input type='hidden' id='specificationsType' name='specificationsType' value='"+data.bean.specificationsType+"'></input>";
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
	 * 增加商品
	 */
	saveGoods=function(){
		var goodsTypeId=$("#goodsTypeId").val();//商品类型id
		var goodsTypeName=$("#goodsTypeId").find("option:selected").text();//所选商品类型名称
		//这里需要调用获取商品类型属性和参数填写的值方法
		var goodsParameterValue=getGoodsParameter(goodsTypeId);
		var goodsAttrsVals=getgoodsAttrVals(goodsTypeId);
		var navid=$("#parentId").val();
		if(navid=="-1"){
			formwarning("#alerterror", "请选择顶级商品分类");
			return false;
		}
		var nname=$("#parentId").find("option:selected").text();
		var ltypeid=$("#parentId1").val();
		if(ltypeid=="-1"){
			ltypeid=0;
			lname="";
		}
		var lname=$("#parentId1").find("option:selected").text();
		var stypeid=$("#parentId2").val();
		if(stypeid=="-1"){
			stypeid=0;
			sname="";
		}
		var sname=$('#parentId2').find("option:selected").text();
		var fname="";
		var goodsname=$("#goodsname").val();
		var usersetnum=$("#usersetnum").val();
		var brandid=$("#brandname").val();
		if(brandid=="-1"){
			formwarning("#alerterror", "请选择商品品牌");
			return false;
		}
		var brandname=$("#brandname").find("option:selected").text();
		var points=$("#points").val();
		var sort=$("#sort").val();
		var isNew=$("input[name='isNew']:checked").val();
		var recommended=$("input[name='recommended']:checked").val();
		var hotsale=$("input[name='hotsale']:checked").val();
		var bargainprice=$("input[name='bargainprice']:checked").val();
		var ismobileplatformgoods=$("input[name='ismobileplatformgoods']:checked").val();
		var salestate=$("input[name='salestate']:checked").val();
		var isSpecificationsOpen=$("#isSpecificationsOpen").val();
		if(isSpecificationsOpen=="-1"){
			formwarning("#alerterror", "请选择一个规格");
			return false;
		}
		var specificationsName=$("#isSpecificationsOpen").find("option:selected").text();//所选规格值名称
		var productName=$("#goodsname").val();
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
		var unit=$("#unit").find("option:selected").text();
		var store=$("#store").val();
		var freezeStore=$("#freezeStore").val();
		var warehouseLocation=$("#warehouseLocation").val();
		var placeStore=$("#placeStore").val();
		var isDefault=$("input[name='isDefault']:checked").val();
		var isSalestate=$("input[name='isSalestate']:checked").val();
		//这里要获取所选的规格值
		var specificationsValue="";
		var hidspecificationsType=$("#hidspecificationsType").val();
		if(hidspecificationsType=="1"){
			//文字类型【1=文字类型】【2=图片类型】【3颜色类型】
			$(":checkbox[name='texttype'][checked=true]").each(function(){
				specificationsValue+="{\"specificationsValue\":\""+this.value+"\"},";
			});
			specificationsValue=specificationsValue.toString().substring(0, specificationsValue.length-1);
		}else if(hidspecificationsType=="2"){
			$(":checkbox[name='imgtype'][checked=true]").each(function(){
				specificationsValue+="{\"specificationsValue\":\""+this.value+"\"},";
			});
			specificationsValue=specificationsValue.toString().substring(0, specificationsValue.length-1);
		}else if(hidspecificationsType=="3"){
			$(":checkbox[name='colortype'][checked=true]").each(function(){
				specificationsValue+="{\"specificationsValue\":\""+this.value+"\"},";
			});
			specificationsValue=specificationsValue.toString().substring(0, specificationsValue.length-1);
		}
		//获取商品图片路径集合
		var pictureurl="";
		$(":checkbox[name='pcpath'][checked=true]").each(function(){
			pictureurl+=this.value+",";
		});
		pictureurl=pictureurl.toString().substring(0, pictureurl.length-1);
		var detail=$('#detail').val();
		var commoditylist=$('#commoditylist').val();
		var metaKeywords=$('#metaKeywords').val();
		var metaDescription=$('#metaDescription').val();
		this.value="提交中";
		this.disabled=true;
		$.post("saveGoods.action",{
			"goodsTypeId":goodsTypeId,
			"goodsTypeName":goodsTypeName,
			"goodsParameterValue":goodsParameterValue,
			"goodsAttrsVals":goodsAttrsVals,
			"navid":navid,
			"nname":nname,
			"ltypeid":ltypeid,
			"lname":lname,
			"stypeid":stypeid,
			"sname":sname,
			"fname":fname,
			"goodsname":goodsname,
			"usersetnum":usersetnum,
			"brandid":brandid,
			"brandname":brandname,
			"points":points,
			"sort":sort,
			"isNew":isNew,
			"recommended":recommended,
			"hotsale":hotsale,
			"bargainprice":bargainprice,
			"ismobileplatformgoods":ismobileplatformgoods,
			"salestate":salestate,
			"isSpecificationsOpen":isSpecificationsOpen,
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
			"isSalestate":isSalestate,
			"specificationsValue":specificationsValue,
			"pictureurl":pictureurl,
			"detail":detail,
			"commoditylist":commoditylist,
			"metaKeywords":metaKeywords,
			"metaDescription":metaDescription
		},function(data){
			if(data.sucflag){
				window.location.href="goodsment.jsp?operate=find&folder=goods";
			}
		});
		
	},
	
	
	
	/**
	 * 获取30个属性值
	 */
	getgoodsAttrVals=function(goodsTypeId){
		var goodsAttrsVals="";
		if(goodsTypeId!=""){
			$("input[id^='goodsAttrVal']").each(function(){
				goodsAttrsVals+="{\"attrval\":\""+this.value+"\"},";
			});
		}
		goodsAttrsVals=goodsAttrsVals.toString().substring(0, goodsAttrsVals.length-1);
		return	goodsAttrsVals;	
	},
	
	
	/**
	 * 从页面上获取被赋值的商品参数值
	 */
	getGoodsParameter=function(goodsTypeId){
		var goodsParameterValue="";
		if(goodsTypeId!=""){
			$("input[id^='paramlistname']").each(function(){
				goodsParameterValue+="{\"id\":\""+this.name+"\",\"value\":\""+this.value+"\"},";
			});
		}
		goodsParameterValue=goodsParameterValue.toString().substring(0, goodsParameterValue.length-1);
		return goodsParameterValue;
	},
	
	$("#submit").click(function(){
		saveGoods();
	});
	
	//可能取消
	saveProductT=function(){
		var isSpecificationsOpen=$("#isSpecificationsOpen").val();//所选的规格值id
		var specificationsName=$("#isSpecificationsOpen").find("option:selected").text();//所选规格值名称
		var productName=$("#goodsname").val();
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
		var unit=$("#unit").find("option:selected").text();
		var store=$("#store").val();
		var freezeStore=$("#freezeStore").val();
		var warehouseLocation=$("#warehouseLocation").val();
		var placeStore=$("#placeStore").val();
		var isDefault=$("input[name='isDefault']:checked").val();
		var isSalestate=$("input[name='isSalestate']:checked").val();
		this.value="提交中";
		this.disabled=true;
		$.post("saveProductT.action",{
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
				$("#submitp").attr("disabled",false);
			}
		});
	}
	
	
	
	
	
	
	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		
		findAllSpecificationsforjson();
		
	}else if(operate=="edit"){
		findGoodsTypeTNForSelect();
		findGoodsCategoryByGradeZeroone();
		findAllBrandtjson();
		findAllSpecificationsforjson();
	}
});

/**
 * flexigrid list
 */
$(function() {
	$("#productsmanagement").flexigrid({
		url : 'findAllProducts.action',
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
				window.location.href = "products.jsp?operate=edit&folder=goods&productid="
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
				$.post("delProductTByproductid.action", {
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
});
