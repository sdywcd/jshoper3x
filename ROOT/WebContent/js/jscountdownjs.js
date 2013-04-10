var strs;
var flag=true;
var goodsid;
//var  status;
$(function () {
	$.post("findGoodsLimitStatus.action",function(data){
		if(data.goodslimitlist==null){
			 var a="限时抢购已结束";
		    	$('#defaultCountdown').html(a);
	    }else{
	    	  var a=
	    			"<div id='t7_timer'>"+
	    			"<div id='t7_bg'>"+
	    			"<div id='t7_vals'>"+
	    				
	    			"</div>"+
	    			"</div>"+
	    			"<img src='Uploads/"+data.goodslimitlist.pictureurl+"' style='width:150px;height:100px;'/><br>"+
	    			"<div><a id='getlimit' name='getlimit' href='GetGoodsLimitdetailBygoodsid.action?goodsid="+data.goodslimitlist.goodsid+"'>"+data.goodslimitlist.goodsname+"</a><br><br>"+"原价：￥"+data.goodslimitlist.price+"&nbsp;&nbsp;&nbsp;抢购价：￥"+data.goodslimitlist.rushprice+"</div>"+
	    		 "</div>"+"<input id='goodsLimitbuyId' name='goodsLimitbuyId' type='hidden' value="+data.goodslimitlist.goodsLimitbuyId+">";
	    		goodsid=data.goodslimitlist.goodsid;
	    		strs=data.goodslimitlist.endtime.split("-");
	    		$('#defaultCountdown').html(a);
	    	  
	    		showtime();   			
	   }
   })
});

var timerID = null;
var timerRunning = false;
function showtime(){
 Today = new Date();
 
 var NowSecond = Today.getSeconds();    //秒 
 var NowMinute = Today.getMinutes();    //分钟
 var NowHour = Today.getHours();        //小时
 var NowDate = Today.getDate();         //日
 var NowMonth = Today.getMonth();       //月
 var NowYear = Today.getYear();         //年

 
 if(NowYear < 2000){
  NowYear = 1900 + NowYear;     
 }
 Today = null;
 var y;
 var m;
 var d;
 var h;
 var f;
 y =strs[0];
 m=strs[1];
 d=strs[2];
 h=strs[3];
 f=strs[4];
 
 Secondmyclock = 59 - NowSecond;   //秒
 Minutemyclock = f- NowMinute-1;   //分钟
 Hourmyclock = h - NowHour;       //小时
 Datemyclock = d - NowDate;        //日
 Monthmyclock = m - NowMonth - 1;  //月
 Yearmyclock = y - NowYear;     //年
 

 if(Secondmyclock<10){
	 Secondmyclock="0"+Secondmyclock;
 }
 if(Secondmyclock < 0){
  Secondmyclock = 60 + Secondmyclock;
  Minutemyclock = Minutemyclock - 1;
  
 }

 if(Minutemyclock <0){
  Minutemyclock = 60 + Minutemyclock;
  Hourmyclock = Hourmyclock - 1;
 
  if(Minutemyclock<1){
	  Minutemyclock="0"+"0";
  }
 }
 if(Minutemyclock<10){
	  Minutemyclock="0"+Minutemyclock;
}

 
 if(Datemyclock>0&&Hourmyclock <0){
	  Hourmyclock = 24 + Hourmyclock;
	  Datemyclock = Datemyclock - 1;
	  Hourmyclock=Hourmyclock+Datemyclock*24;
	 }
	 if(Datemyclock>0&&Hourmyclock>0){
		 Hourmyclock=Hourmyclock+Datemyclock*24;
	 }
	 if(Datemyclock<0&&Hourmyclock <0){
	  Hourmyclock = 24 + Hourmyclock;
	  Datemyclock = Datemyclock - 1;
	  Datemyclock=31+Datemyclock;
	  Hourmyclock=Hourmyclock+Datemyclock*24;
	   Monthmyclock = Monthmyclock - 1;
	 }
	 if(Datemyclock==0&&Hourmyclock <10){
		 Hourmyclock="0"+Hourmyclock;
	 }
	 if(Datemyclock==0&&Hourmyclock <1){
		 Hourmyclock="0"+"0";
	 }
	    
 if(Datemyclock < 0){
  Datemyclock = 31 + Datemyclock;
  Monthmyclock = Monthmyclock - 1;
 }
 if(Monthmyclock < 0){
  Monthmyclock = 12 + Monthmyclock;
  Yearmyclock = Yearmyclock - 1;
 }

 
 var Temp = 
	 "<div id='t7_h' class='t7_numbs'><div style='font-size:12px'>剩余<font size='5' color='#FB7510'>"+Hourmyclock+"</font>时</div></div>"+
	 "<div id='t7_m' class='t7_numbs'><div style='font-size:12px'><font size='5' color='#FB7510'>"+Minutemyclock+"</font>分</div></div> "+
	 "<div id='t7_s' class='t7_numbs'><div style='font-size:12px'><font size='5' color='#FB7510'>"+Secondmyclock+"</font>秒</div></div>";
	 //Yearmyclock + "年" + Monthmyclock + "个月" + Datemyclock + "天" + Hourmyclock + "小时" + Minutemyclock + "分" + Secondmyclock + "秒";
 if(Hourmyclock<=00&&Minutemyclock<=00&&Secondmyclock<=01){
		Temp ="限时抢购已结束";
	
		var goodsLimitbuyId=$('#goodsLimitbuyId').val();
		$.post("updateStatus.action",{"goodsLimitbuyId":goodsLimitbuyId},function(data){
			flag=false;
		});
		var h="GetGoodsdetailBygoodsid.action?goodsid="+goodsid;
		$('#getlimit').attr("href",h);
//		h= document.getElementById("getlimit");
//		h.href="GetGoodsdetailBygoodsid.action?goodsid=";
		
		
	}
 if(Hourmyclock>72){
	 Temp="限时抢购已结束";
 }
// if(data.goodslimitlist.length()==0)
//	{
//		Temp ="限时抢购已结束";
//		flag=false;
//	}
 
 $('#t7_vals').html(Temp);

// document.form1.endtime.value = end;
 if(flag){
 timerID = setTimeout("showtime()",1000);
 timerRunning = true;
 }
}




