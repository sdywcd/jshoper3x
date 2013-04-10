var session ="true";
$(function(){

	$("h6").each(function(){
		$(this).removeClass("selected"); 
	});
	$("ul").each(function(){
		$(this).removeClass("opened"); 
		$(this).addClass("closed"); 
	});
	$("#h-menu-settings").addClass("selected");
	$("#menu-settings").removeClass("closed"); 
	$("#menu-settings").addClass("opened");
});


$(function(){
	$('#isautolockaccount').change(function(){
		var isautolockaccount=$('#isautolockaccount').val();
		if(isautolockaccount=='1'){
			$('#maxloginnump').show();
			$('#unlocktimep').show();
		}else{
			$('#maxloginnump').hide();
			$('#unlocktimep').hide();
		}
	});
	
	
	$.post("findsafeSet.action",function(data){
		$('#isusercanregister').val(data.isusercanregister);
		$('#isautolockaccount').val(data.isautolockaccount);
		if(data.isautolockaccount=='1'){
			$('#maxloginnum').attr("value",data.maxloginnum);
			$('#unlocktime').attr("value",data.unlocktime);
			$('#maxloginnump').show();
			$('#unlocktimep').show();
		}else{
			$('#maxloginnum').attr("value","0");
			$('#unlocktime').attr("value","0");
			$('#maxloginnump').hide();
			$('#unlocktimep').hide();
		}
	});
	

	
});

