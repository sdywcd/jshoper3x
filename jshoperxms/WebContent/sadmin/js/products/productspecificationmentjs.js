$(function(){
	var rid = "";
	/*
	 * To obtain random rid
	 */
	getIdforradom=function(){
		var myDate = new Date();
		rid = myDate.getSeconds().toString() + myDate.getMilliseconds().toString();
	},
	/*
	 * Get Goods Type for select elements
	 */
	findGoodsTypeTNForSelect=function(){
		$.ajax({
			url:"findGoodsTypeTNForSelect.action",
			type:"post",
			dataType:'json',
			async:false,
			success:function(data){
			if(data.goodstypetnlist!=""){
				$('#goodstypetn').append(data.goodstypetnlist);
				}
			}
		});
	},
	/*
	 * Delete Page elements According to rid 
	 */
	delParamPChild=function(rid){
		$('#add' + rid).remove();
	},
	createUploader=function(rid){
	    var uploader = new qq.FileUploader({
	        element: document.getElementById("uploadguigepc"+rid),
	        action: 'ajaxFileUploads.action',
	        debug: true,
	        minSizeLimit:1024,
	        sizeLimit: 1073741824,
	        allowedExtensions: ['jpeg','jpg','gif','png'],
	        onComplete: function(id, fileName, responseJSON){
			var pcpath=responseJSON.success;
			var htm="<img class='attribute' style='width:100px;height:100px' name='showguigepc"+rid+"' id='"+id+"' src='../.."+pcpath+"' rel='#"+fileName+"'/><input class='attribute' id='getguigepc"+rid+"' name='getguigepc"+rid+"' type='hidden' value='"+pcpath+"'/>";
			$("#showguigepc"+rid).html(htm);
	        },
	      
	    });  
	},
	/**
	 * 点击增加规格值按钮
	 */
	$('#addparam').click(function() {
		getIdforradom();
		var html = "<tr id='add"+rid+"'>"
		+ "<td class='title'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistname"+rid+"' name='paramlistname"+rid+"' value='' type='text'/></div></div></div></div></td>" 
		+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><div style='display:none;' id='uploadguigepc"+rid+"'></div><input class='attribute' id='attributelists"+rid+"' name='attributelists"+rid+"' type='text' value=''/></div></div></div></div></td>"
		+ "<td id='specpcparaminput'  class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><div id='showguigepc"+rid+"' name='showguigepc"+rid+"' style='width:100px;height:100px;'></div></div></div></div></div></td>"
		+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistsort"+rid+"' name='paramlistsort"+rid+"' type='text' value='' /></div></div></div></div></td>"
		+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input  class='attribute btn btn-success' id='delbutton"+rid+"' name='delbutton"+rid+"' type='button' value='删除' onClick='delParamPChild("+rid+")'/></div></div></div></div></td>" + "</tr>";
		$('.table tbody').append(html);

		var specificationsType = $('#specificationsType').val();
		if (specificationsType == "1") {//文字类型 规格名称
			$('#selectcolordiv').hide();
			$("#specpc").remove();
			$("#specpcparaminput").each(function(){
				$(this).remove();
			});
		} else if(specificationsType=="2"){//图片类型
			var attributelists = "attributelists";
			$(".attribute").each(function() {
				if (this.name.substring(0, 14) == attributelists) {
					this.style.display="none";//隐藏显示上传组件
					$("#uploadguigepc"+rid).show();
					createUploader(rid);
				}
			});
			$("#specvalue").text("请上传图片");
		}else{
			$('#selectcolordiv').show();//颜色类型
			var paramlistname = "paramlistname";
			$(".attribute").each(function() {
				if (this.name.substring(0, paramlistname.length) == paramlistname) {
					this.disabled=true;
					this.value="颜色RGB值填写入规格值参数中";
					$("#specpc").remove();
				}
			});
			$("#specpc").remove();
			$("#specpcparaminput").each(function(){
				$(this).remove();
			});
		}

	});
	
	/**
	 * 检查规格值，参数，排序字段(文字类型)
	 */
	checkspecificationsTypeWord=function(){
		var check=true;
		var paramlistname = "paramlistname";
		var attributelists = "attributelists";
		var paramlistsort = "paramlistsort";
		$(".attribute").each(function() {
			if(this.name.substring(0,paramlistname.length)==paramlistname){
				if(this.value==""){
					formwarning("#alerterror","规格值名称必须填写");
					check=false;
				}else{
					var str = this.value;
					var reg = /[\-\[\{\}\]:"]+/;
					if((result = reg.exec(str)) !=null){
						formwarning("#alerterror",'规格值名称有非法字符"[","]","{","}",":","-"');
						check=false;
					}
				}
			}
			if(this.name.substring(0,attributelists.length)==attributelists){
				if(this.value==""){
					formwarning("#alerterror","规格值参数必须填写");
					check=false;
				}else{
					var str = this.value;
					var reg = /[\-\[\{\}\]:"]+/;
					if((result = reg.exec(str)) !=null){
						formwarning("#alerterror",'规格值参数有非法字符"[","]","{","}",":","-"');
						check=false;
					}
				}
			}
			if(this.name.substring(0,paramlistsort.length)==paramlistsort){
				if(this.value==""){
					formwarning("#alerterror",'排序必须填写');
					check=false;
				}else{
					var str = this.value;
					var reg = /\D/;
					if((result = reg.exec(str)) !=null){
						formwarning("#alerterror",'排序只能是数字');
						check=false;
					}
				}
			}
		});
		return check;
	},
	/**
	 * 检查规格值，参数，排序字段（图片类型）
	 */
	checkspecificationsTypePicture=function(){
		var check=true;
		var paramlistname = "paramlistname";
		var showguigepc="showguigepc";
		var paramlistsort = "paramlistsort";
		$(".attribute").each(function() {
			if(this.name.substring(0,paramlistname.length)==paramlistname){
				if(this.value==""){
					formwarning("#alerterror","规格值名称必须填写");
					check=false;
				}else{
					var str = this.value;
					var reg = /[\-\[\{\}\]:"]+/;
					if((result = reg.exec(str)) !=null){
						formwarning("#alerterror",'规格值名称有非法字符"[","]","{","}",":","-"');
						check=false;
					}
				}
			}
			if(this.name.substring(0,showguigepc.length)==showguigepc){
				if(this.src==""){
					formwarning("#alerterror",'请上传图片');
					check=false;
				}
			}
			if(this.name.substring(0,paramlistsort.length)==paramlistsort){
				if(this.value==""){
					formwarning("#alerterror",'排序必须填写');
					check=false;
				}else{
					var str = this.value;
					var reg = /\D/;
					if((result = reg.exec(str)) !=null){
						formwarning("#alerterror",'排序只能是数字');
						check=false;
					}
				}
			}
		});
		return check;
	},
	/**
	 * 检查参数，排序字段（颜色类型）
	 */
	checkspecificationsTypeColor=function(){
		var check=true;
		var attributelists="attributelists";
		var paramlistsort = "paramlistsort";
		$(".attribute").each(function() {
			if(this.name.substring(0,attributelists.length)==attributelists){
				if(this.value==""){
					formwarning("#alerterror","规格值参数必须填写");
					check=false;
				}else{
					var str = this.value;
					var reg = /[\-\[\{\}\]:"]+/;
					if((result = reg.exec(str)) !=null){
						formwarning("#alerterror",'规格值参数有非法字符"[","]","{","}",":","-"');
						check=false;
					}
				}
			}
			if(this.name.substring(0,paramlistsort.length)==paramlistsort){
				if(this.value==""){
					formwarning("#alerterror",'排序必须填写');
					check=false;
				}else{
					var str = this.value;
					var reg = /\D/;
					if((result = reg.exec(str)) !=null){
						formwarning("#alerterror",'排序只能是数字');
						check=false;
					}
				}
			}
		});
		return check;
	},
	
	
	/**
	 * 增加文字类型规格参数
	 */
	addspecificationsTypeWord=function(){
		var goodsTypeId=$('#goodstypetn').val();
		if(goodsTypeId=="0"){
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var goodsTypeName=$('#goodstypetn').find("option:selected").text();
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","请填写规格名称");
			return false;
		}
		var specificationsType = $('#specificationsType').val();
		var note = $('#note').val();
		var sort= $('#sort').val();
		var paramlistname="paramlistname";
		var attributelists="attributelists";
		var paramlistsort="paramlistsort";
		var id = "";
		var specifikey="";
		var specifivalue="";
		var specifisort="";
		var delbutton = "delbutton";
		var sub = "";
		var rjson = "";
		var id = "";
		//检查所需参数
		if(checkspecificationsTypeWord()){
			$(".attribute").each(function(){
				if(this.name.substring(0,13)==paramlistname){
					id = this.name.substring(paramlistname.length, this.name.length);
					specifikey=this.value;
				}
				if(this.name.substring(0,14)==attributelists){
					specifivalue=this.value;
				}
				if(this.name.substring(0,13)==paramlistsort){
					specifisort=this.value;
				}
				if (this.name.substring(0, 9) == delbutton) {
					sub += "{\"id\":\"" + id + "\",\"specifikey\":\"" + specifikey + "\",\"specifivalue\":\"" + specifivalue + "\",\"specifisort\":\"" + specifisort + "\"},";
					id = "";
					specifikey = "";
					specifivalue = "";
					specifisort = "";
				}
			});
			rjson="["+sub.toString().substring(0, sub.length-1)+"]";
			$.post("addProductSpecification.action", {
				"name" : name,
				"sort" : sort,
				"specificationsType" : specificationsType,
				"specificationsValue" : rjson,
				"note" : note,
				"goodsTypeId":goodsTypeId,
				"goodsTypeName":goodsTypeName
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "productspecificationment.jsp?operate=find&folder=goods";
				}
			});
		}
	},
	/**
	 * 更新文字类型规格参数
	 */
	updatespecificationsTypeWord=function(){
		var goodsTypeId=$('#goodstypetn').val();
		if(goodsTypeId=="0"){
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var goodsTypeName=$('#goodstypetn').find("option:selected").text();
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","请填写规格名称");
			return false;
		}
		var specificationsType = $('#specificationsType').val();
		var note = $('#note').val();
		var sort= $('#sort').val();
		var specificationsid = $('#hidspecificationsid').val();
		var paramlistname="paramlistname";
		var attributelists="attributelists";
		var paramlistsort="paramlistsort";
		var id = "";
		var specifikey="";
		var specifivalue="";
		var specifisort="";
		var delbutton = "delbutton";
		var sub = "";
		var rjson = "";
		var id = "";
		//检查所需参数
		if(checkspecificationsTypeWord()){
			$(".attribute").each(function(){
				if(this.name.substring(0,13)==paramlistname){
					id = this.name.substring(paramlistname.length, this.name.length);
					specifikey=this.value;
				}
				if(this.name.substring(0,14)==attributelists){
					specifivalue=this.value;
				}
				if(this.name.substring(0,13)==paramlistsort){
					specifisort=this.value;
				}
				if (this.name.substring(0, 9) == delbutton) {
					sub += "{\"id\":\"" + id + "\",\"specifikey\":\"" + specifikey + "\",\"specifivalue\":\"" + specifivalue + "\",\"specifisort\":\"" + specifisort + "\"},";
					id = "";
					specifikey = "";
					specifivalue = "";
					specifisort = "";
				}
			});
			rjson="["+sub.toString().substring(0, sub.length-1)+"]";
			$.post("updateProductSpecification.action", {
				"name" : name,
				"sort" : sort,
				"specificationsType" : specificationsType,
				"specificationsValue" : rjson,
				"note" : note,
				"specificationsid":specificationsid,
				"goodsTypeId":goodsTypeId,
				"goodsTypeName":goodsTypeName
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "productspecificationment.jsp?operate=find&folder=goods";
				}
			});
		}
	},
	
	/**
	 * 增加图片规格
	 */
	addspecificationsTypePicture=function(){
		var goodsTypeId=$('#goodstypetn').val();
		if(goodsTypeId=="0"){
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var goodsTypeName=$('#goodstypetn').find("option:selected").text();
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","请填写规格名称");
			return false;
		}
		var specificationsType = $('#specificationsType').val();
		var note = $('#note').val();
		var sort= $('#sort').val();
		var paramlistname="paramlistname";
		var getguigepc="getguigepc";
		var paramlistsort="paramlistsort";
		var id = "";
		var specifikey="";
		var specifivalue="";
		var specifisort="";
		var delbutton = "delbutton";
		var sub = "";
		var rjson = "";
		var id = "";
		//检查所需参数
		if(checkspecificationsTypePicture()){
			$(".attribute").each(function(){
				if(this.name.substring(0,paramlistname.length)==paramlistname){
					id = this.name.substring(paramlistname.length, this.name.length);
					specifikey=this.value;
				}
				if(this.name.substring(0,getguigepc.length)==getguigepc){
					specifivalue=this.value;
				}
				if(this.name.substring(0,paramlistsort.length)==paramlistsort){
					specifisort=this.value;
				}
				if (this.name.substring(0, delbutton.length) == delbutton) {
					sub += "{\"id\":\"" + id + "\",\"specifikey\":\"" + specifikey + "\",\"specifivalue\":\"" + specifivalue + "\",\"specifisort\":\"" + specifisort + "\"},";
					id = "";
					specifikey = "";
					specifivalue = "";
					specifisort = "";
				}
			});
			rjson="["+sub.toString().substring(0, sub.length-1)+"]";
			$.post("addProductSpecification.action", {
				"name" : name,
				"sort" : sort,
				"specificationsType" : specificationsType,
				"specificationsValue" : rjson,
				"note" : note,
				"goodsTypeId":goodsTypeId,
				"goodsTypeName":goodsTypeName
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "productspecificationment.jsp?operate=find&folder=goods";
				}
			});
		}
	},
	/**
	 * 更新图片规格
	 */
	updatespecificationsTypePicture=function(){
		var goodsTypeId=$('#goodstypetn').val();
		if(goodsTypeId=="0"){
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var goodsTypeName=$('#goodstypetn').find("option:selected").text();
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","请填写规格名称");
			return false;
		}
		var specificationsType = $('#specificationsType').val();
		var note = $('#note').val();
		var sort= $('#sort').val();
		var specificationsid = $('#hidspecificationsid').val();
		var paramlistname="paramlistname";
		var getguigepc="getguigepc";
		var paramlistsort="paramlistsort";
		var id = "";
		var specifikey="";
		var specifivalue="";
		var specifisort="";
		var delbutton = "delbutton";
		var sub = "";
		var rjson = "";
		var id = "";
		//检查所需参数
		if(checkspecificationsTypePicture()){
			$(".attribute").each(function(){
				if(this.name.substring(0,paramlistname.length)==paramlistname){
					id = this.name.substring(paramlistname.length, this.name.length);
					specifikey=this.value;
				}
				if(this.name.substring(0,getguigepc.length)==getguigepc){
					specifivalue=this.value;
				}
				if(this.name.substring(0,paramlistsort.length)==paramlistsort){
					specifisort=this.value;
				}
				if (this.name.substring(0, delbutton.length) == delbutton) {
					sub += "{\"id\":\"" + id + "\",\"specifikey\":\"" + specifikey + "\",\"specifivalue\":\"" + specifivalue + "\",\"specifisort\":\"" + specifisort + "\"},";
					id = "";
					specifikey = "";
					specifivalue = "";
					specifisort = "";
				}
			});
			rjson="["+sub.toString().substring(0, sub.length-1)+"]";
			$.post("updateProductSpecification.action", {
				"name" : name,
				"sort" : sort,
				"specificationsType" : specificationsType,
				"specificationsValue" : rjson,
				"note" : note,
				"specificationsid":specificationsid,
				"goodsTypeId":goodsTypeId,
				"goodsTypeName":goodsTypeName
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "productspecificationment.jsp?operate=find&folder=goods";
				}
			});
		}
	},
	/**
	 * 增加颜色类型规格参数
	 */
	addspecificationsTypeColor=function(){
		var goodsTypeId=$('#goodstypetn').val();
		if(goodsTypeId=="0"){
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var goodsTypeName=$('#goodstypetn').find("option:selected").text();
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","请填写规格名称");
			return false;
		}
		var specificationsType = $('#specificationsType').val();
		var note = $('#note').val();
		var sort= $('#sort').val();
		var attributelists="attributelists";
		var paramlistsort="paramlistsort";
		var id = "";
		var specifikey="color";//统一用颜色标注
		var specifivalue="";
		var specifisort="";
		var delbutton = "delbutton";
		var sub = "";
		var rjson = "";
		var id = "";
		//检查所需参数
		if(checkspecificationsTypeColor()){
			$(".attribute").each(function(){
				if(this.name.substring(0,attributelists.length)==attributelists){
					id = this.name.substring(attributelists.length, this.name.length);
					specifivalue=this.value;
				}
				if(this.name.substring(0,paramlistsort.length)==paramlistsort){
					specifisort=this.value;
				}
				if (this.name.substring(0,delbutton.length) == delbutton) {
					sub += "{\"id\":\"" + id + "\",\"specifikey\":\"" + specifikey + "\",\"specifivalue\":\"" + specifivalue + "\",\"specifisort\":\"" + specifisort + "\"},";
					id = "";
					specifikey = "";
					specifivalue = "";
					specifisort = "";
				}
			});
			rjson="["+sub.toString().substring(0, sub.length-1)+"]";
			$.post("addProductSpecification.action", {
				"name" : name,
				"sort" : sort,
				"specificationsType" : specificationsType,
				"specificationsValue" : rjson,
				"note" : note,
				"goodsTypeId":goodsTypeId,
				"goodsTypeName":goodsTypeName
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "productspecificationment.jsp?operate=find&folder=goods";
				}
			});
		}
	},/**
	 * 更新颜色类型规格参数
	 */
	updatespecificationsTypeColor=function(){
		var goodsTypeId=$('#goodstypetn').val();
		if(goodsTypeId=="0"){
			formwarning("#alerterror","请选择商品类型");
			return false;
		}
		var goodsTypeName=$('#goodstypetn').find("option:selected").text();
		var name = $('#name').val();
		if (name == "") {
			formwarning("#alerterror","请填写规格名称");
			return false;
		}
		var specificationsType = $('#specificationsType').val();
		var note = $('#note').val();
		var sort= $('#sort').val();
		var specificationsid = $('#hidspecificationsid').val();
		var attributelists="attributelists";
		var paramlistsort="paramlistsort";
		var id = "";
		var specifikey="color";//统一用颜色标注
		var specifivalue="";
		var specifisort="";
		var delbutton = "delbutton";
		var sub = "";
		var rjson = "";
		var id = "";
		//检查所需参数
		if(checkspecificationsTypeColor()){
			$(".attribute").each(function(){
				if(this.name.substring(0,attributelists.length)==attributelists){
					id = this.name.substring(attributelists.length, this.name.length);
					specifivalue=this.value;
				}
				if(this.name.substring(0,paramlistsort.length)==paramlistsort){
					specifisort=this.value;
				}
				if (this.name.substring(0,delbutton.length) == delbutton) {
					sub += "{\"id\":\"" + id + "\",\"specifikey\":\"" + specifikey + "\",\"specifivalue\":\"" + specifivalue + "\",\"specifisort\":\"" + specifisort + "\"},";
					id = "";
					specifikey = "";
					specifivalue = "";
					specifisort = "";
				}
			});
			rjson="["+sub.toString().substring(0, sub.length-1)+"]";
			$.post("updateProductSpecification.action", {
				"name" : name,
				"sort" : sort,
				"specificationsType" : specificationsType,
				"specificationsValue" : rjson,
				"note" : note,
				"specificationsid":specificationsid,
				"goodsTypeId":goodsTypeId,
				"goodsTypeName":goodsTypeName
			}, function(data) {
				if (data.sucflag) {
					window.location.href = "productspecificationment.jsp?operate=find&folder=goods";
				}
			});
		}
	},
	/**
	 * 根据规格值id获取规格值参数列表
	 */
	findProductSpecificationsTByspecificationsid=function(){
		var specificationsid = $.query.get('specificationsid');
		if (specificationsid == "") {
			return false;
		}
		$.post("findProductSpecificationsTByspecificationsid.action", {
			"specificationsid" : specificationsid
		}, function(data) {
			if (data.sucflag) {
				var html = "";
				var rid = "";
				$('#name').val(data.bean.name);
				$('#note').val(data.bean.note);
				$('#sort').val(data.bean.sort);
				$('#specificationsType').val(data.bean.specificationsType);
				$('#hidspecificationsid').val(data.bean.specificationsid);
				$('#goodstypetn').val(data.bean.goodsTypeId);
				var specificationsid=data.bean.specificationsid;
				var jsonstr;//js处理json
				jsonstr = $.parseJSON(data.bean.specificationsValue);
				$.each(jsonstr,function(k,v){
					if (data.bean.specificationsType == "1") {//文字类型
						rid = v.id;
						html += "<tr id='add" + rid + "'>" 
						+ "<td class='title'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistname" + rid + "' name='paramlistname" + rid + "' value='" + v.specifikey + "' class='small' type='text'/></div></div></div></div></td>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='attributelists" + rid + "' name='attributelists'" + rid + "' value='" + v.specifivalue + "' type='text'></input></div></div></div></div></td>"
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistsort" + rid + "' name='paramlistsort" + rid + "' value='" + v.specifisort + "' type='text'/></div></div></div></div></td>"
						+ "<input type='hidden' class='attribute' id='paramattributeid' name='paramattributeid' value='" + specificationsid + "'></input>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input  class='attribute btn btn-success' id='delbutton" + rid+ "' name='delbutton" + rid + "' type='button' value='删除' onClick='delParamPChild(" + rid + ")'/></div></div></div></div></td>" + "</tr>";
						$("#specpc").remove();
					} else if(data.bean.specificationsType=="2"){// 图片类型
						rid = v.id;
						html += "<tr id='add" + rid + "'>" 
						+ "<td class='title'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistname" + rid + "' name='paramlistname" + rid + "' value='" + v.specifikey + "' class='small' type='text'/></div></div></div></div></td>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><div id='uploadguigepc"+rid+"'></div></div></div></div></div></td>"
						+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><div id='showguigepc"+rid+"' style='width:100px;height:100px;'><img name='showguigepc"+rid+"' src='../.."+v.specifivalue+"' class='attribute' style='width:100px;height:100px'/><input class='attribute' id='getguigepc"+rid+"' name='getguigepc"+rid+"' type='hidden' value='"+v.specifivalue+"'/></div></div></div></div></div></td>"
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistsort" + rid + "' name='paramlistsort" + rid + "' value='" + v.specifisort + "' type='text'/></div></div></div></div></td>"
						+ "<input type='hidden' class='attribute' id='paramattributeid' name='paramattributeid' value='" +specificationsid + "'></input>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input  class='attribute btn btn-success' id='delbutton" + rid+ "' name='delbutton" + rid + "' type='button' value='删除' onClick='delParamPChild(" + rid + ")'/></div></div></div></div></td>" + "</tr>";
						$("#uploadguigepc"+rid).show();
						$("#specvalue").text("请上传图片");
					}else{
						rid = v.id;
						html += "<tr id='add" + rid + "'>" 
						+ "<td class='title'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistname" + rid + "' name='paramlistname" + rid + "' value='颜色RGB值填写入规格值参数中' class='small' type='text' disabled/></div></div></div></div></td>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='attributelists" + rid + "' name='attributelists'" + rid + "' value='" + v.specifivalue + "' type='text' style='background:"+v.specifivalue+"'></input></div></div></div></div></td>"
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistsort" + rid + "' name='paramlistsort" + rid + "' value='" + v.specifisort + "' type='text'/></div></div></div></div></td>"
						+ "<input type='hidden' class='attribute' id='paramattributeid' name='paramattributeid' value='" + specificationsid + "'></input>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input  class='attribute btn btn-success' id='delbutton" + rid+ "' name='delbutton" + rid + "' type='button' value='删除' onClick='delParamPChild(" + rid + ")'/></div></div></div></div></td>" + "</tr>";
						$("#specpc").remove();
					}
				});
				var specificationsType = $('#specificationsType').val();
				if (specificationsType == "1") {
					$('#selectcolordiv').hide();
				} else {
					$('#selectcolordiv').show();
				}
				
				$('.table tbody').append(html);
				
			}
			// 显示修改按钮
			$('#update').show();
			// $('#modifyparam').show();
			// 隐藏增加按钮
			$('#submit').hide();
			// $('#submitparam').hide();
		});
		
	},
	
	
	/**
	 * 增加产品规格值
	 */
	$('#submit').click(function() {
		var specificationsType = $('#specificationsType').val();
		if (specificationsType == "1") {//文字类型 规格名称
			//如果是文字类型就进行对应该类型的取值方式
			addspecificationsTypeWord();
		}else if(specificationsType=="2"){//图片类型
			addspecificationsTypePicture();
		}else{
			//颜色类型
			addspecificationsTypeColor();
		}
	});
	/**
	 * 更新产品规格值
	 */
	$('#update').click(function() {
		var specificationsType = $('#specificationsType').val();
		if (specificationsType == "1") {//文字类型 规格名称
			//如果是文字类型就进行对应该类型的取值方式
			updatespecificationsTypeWord();
		}else if(specificationsType=="2"){//图片类型
			updatespecificationsTypePicture();
		}else{
			//颜色类型
			updatespecificationsTypeColor();
		}
	});
	/**
	 * 取色控件
	 */
	initfarbtastic=function(){
		$('#demo').hide();
		var f = $.farbtastic('#picker');
		var p = $('#picker').css('opacity', 0.25);
		var selected;
		$('.colorwell').each(function() {
			f.linkTo(this);
			$(this).css('opacity', 0.75);
		}).focus(function() {
			if (selected) {
				$(selected).css('opacity', 0.75).removeClass('colorwell-selected');
			}
			f.linkTo(this);
			p.css('opacity', 1);
			$(selected = this).css('opacity', 1).addClass('colorwell-selected');
		});
		
	}
});


/*===========================================Gorgeous split-line==============================================*/
$(function(){
	var operate = $.query.get("operate");
	if (operate == "add") {
		findGoodsTypeTNForSelect();
		initfarbtastic();
		return;
	}else if(operate=="edit"){
		findGoodsTypeTNForSelect();
		initfarbtastic();
		findProductSpecificationsTByspecificationsid();
	}
});

/*===========================================Gorgeous split-line==============================================*/


/**
 * Required to initialize the page data
 */
/**
 * 切换规格值类型
 */
$(function() {
	$('#selectcolordiv').hide();
	$('#specificationsType').change(function() {
		var specificationsType = $('#specificationsType').val();
		if (specificationsType == "1") {
			var attributelists = "attributelists";
			$('#selectcolordiv').hide();
			$(".attribute").each(function() {
				if (this.name.substring(0, attributelists.length) == attributelists) {
					this.disabled = true;
				}
			});
		} else if(specificationsType=="3"){
			var attributelists = "attributelists";
			$('#selectcolordiv').show();
			$(".attribute").each(function() {
				if (this.name.substring(0,attributelists.length) == attributelists) {
					this.disabled = false;
				}
			});
		}
	});
});
/*===========================================Gorgeous split-line==============================================*/

/**
 * flexigrid list 
 */
$(function() {
	$("#productspecificationmanagement").flexigrid( {
		url : 'findAllProductSpecificationsT.action',
		dataType : 'json',
		colModel : [{
			display : '规格名称',
			name : 'name',
			width : 315,
			sortable : true,
			align : 'center'
		}, {
			display : '规格类型',
			name : 'specificationsType',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '规格值列表',
			name : 'specificationsValue',
			width : 415,
			sortable : true,
			align : 'center'
		}, {
			display : '排序',
			name : 'sort',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 300,
			sortable : true,
			align : 'center'
		}, {
			display : '操作',
			name : 'operate',
			width : 100,
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
		checkbox : true
	});

	function action(com, grid) {
		if (com == '添加') {
			window.location.href = "productspecification.jsp?operate=add&folder=goods";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "productspecification.jsp?operate=edit&folder=goods&specificationsid=" + str;
				return;
			} else {
				formwarning("#alerterror", "请选择一条信息");
				return false;
			}
		} else if (com = '删除') {
			if ($('.trSelected', grid).length > 0) {
				var str = "";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("delProductSpecification.action", {
					"specificationsid" : str
				}, function(data) {
					$('#productspecificationmanagement').flexReload();
					forminfo("#alertinfo","删除商品规格成功");
				});
				return;
			} else {
				formwarning("#alerterror", "请选择要删除的信息");
				return false;
			}
		}
	}

});
/*===========================================Gorgeous split-line==============================================*/


/**
 * Update Function
 */


	// 更新商品属性，完善商品品牌处理
	/**
	 * 修改商品规格数据
	 */

	$('#modify').click(function() {
		var name = $('#name').val();
		if (name == "") {
			jAlert('规格名称必须填写', '信息提示');
			return false;
		}
		var specificationsid = $('#hidspecificationsid').val();
		var note = $('#note').val();
		var sort1 = $('#sort').val();
		var specificationsType = $('#specificationsType').val();
		var paramlistname = "paramlistname";
		var attributetype = "attributetype";
		var attributelists = "attributelists";
		var paramlistsort = "paramlistsort";
		var showguigepc="showguigepc";
		var delbutton = "delbutton";
		var goodsattributename;
		var attributeType;
		var attributelist;
		var sort;
		var attributeIndex = 1;
		var addflag = 0;
		var sucflag = true;
		var sub = "";
		var rjson = "";
		var id = "";
		var disflag=false;
		$(".attribute").each(function() {
			if (this.name.substring(0, 13) == paramlistname) {
				if (this.value == "") {
					jAlert('规格值名称必须填写', '信息提示');
					return false;
				}
				id = this.name.substring(13, this.name.length);
				goodsattributename = this.value;
				addflag = 1;
			}
			if (this.name.substring(0, 14) == attributelists) {
				if (this.disabled) {
					disflag=true;
					attributelist = this.value;
					addflag = 3;
				} else {
					disflag=false;
					attributelist = this.value;
					addflag = 3;
				}

			}
			if(this.name.substring(0,11)==showguigepc){
				if(!disflag){
					attributelist = this.src;
					addflag = 3;
				}
			}
			if (this.name.substring(0, 13) == paramlistsort) {
				if (this.value == "") {
					this.value=0;
					//jAlert('商品属性排序必须填写', '信息提示');
					addflag = 4;
				}
				sort = this.value;
				addflag = 4;
			}
			if (this.name.substring(0, 9) == delbutton) {
				if (addflag == 4) {
					sub += "{\"id\":\"" + id + "\",\"goodsattributename\":\"" + goodsattributename + "\",\"attributelist\":\"" + attributelist + "\",\"sort\":\"" + sort + "\"}-";
					addflag = 0;
					goodsattributename = "";
					attributeType = "";
					attributelist = "";
					id = "";
					sort = "";
				}
			}
		});

		if (sucflag == true) {
			rjson = sub.toString().substring(0, sub.length - 1);
			$.post("updateProductSpecification.action", {
				"specificationsid" : specificationsid,
				"name" : name,
				"sort" : sort1,
				"specificationsType" : specificationsType,
				"specificationsValue" : rjson,
				"note" : note
			}, function(data) {
				if (data.sucflag) {
					sucflag = true;
					window.location.href = "productspecificationmanagement.jsp?session=" + session+"#goods";
				} else {
					sucflag = false;
				}
			});
		} else {
			return false;
		}

	});





