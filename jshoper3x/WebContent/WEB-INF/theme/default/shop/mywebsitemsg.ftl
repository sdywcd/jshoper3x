<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/message.css"  />

<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/commmail.css"  />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
<script type="text/javascript" src="${basepath}/js/mywebsitemsgjs.js"></script>
<script type="text/javascript" >
function titleOnclick(msgtextid){

	
		$.post("findMsgtextById.action",{"msgtextid":msgtextid},function(data){
			$('#webtitle').attr("value",data.webbean.title);
			$('#msgfromusrname').attr("value",data.webbean.msgfromusrname);
			$('#createtime').attr("value",data.webbean.createtime);
			$('#msgtousername').attr("value",data.webbean.msgtousername);
			$('#msgtext').attr("value",data.msgbean.text);
		});
		$('#text1').show();
		$('#inbox').hide();
		$('#write').hide();
		
}
</script>
</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">
<#include "/WEB-INF/theme/default/shop/usermenu.ftl">

<div id="mem_right" name="mem_right"  width="100%" height="606" frameborder="0" scrolling="no" onload="javascript:dyniframesize('mem_right');" style=
"display: block; ">
 

	<div class="toolbg toolbgline toolheight" style="position:relative;z-index:2;">    
    <div class="nowrap qm_left">
      <input name="del" type="button" id="quick_del" class=" wd1 btn" value="删除" onclick="">
      <input type="button"  class="wd3 btn" value="标记为未读" onclick="" id="markasunread" name="markasunread">
      <input type="button" class="wd3 btn" value="标记为已读" onclick="" id="markasread">
      <input type="button" class="wd1 btn" value="发信息" onclick="" id="btn_reportSpam">
      <input id="setAllReaded" type="button" class="wd4 btn" value="收件箱" onclick="">
      </div>     
    </div>
    <div></div>
<div style="display:block" id="inbox">
<table cellspacing="0" cellpadding="0" style="table-layout:fixed;width:100%;*width:auto;" class="O2">
    <tbody>
      <tr>
        <td style="padding:1px 0 1px 5px;" width="27"><input type="checkbox" onclick="" title="选中/取消选中"></td>
        <td class="o_title2" style="width:6px;font-size:1px;padding:0;">&nbsp;</td>        
        <td class="o_title2" style="width:135px;*width:134px;">发件人</td>
        <td class="o_title2">主题</td>
        <td style="width:20px;font-size:1px;padding-left:2px">&nbsp;</td>
      </tr>
    </tbody>
  </table>
  
 <table>
<#if (websitemsg??)&&(websitemsg?size>0)> 
			<#list websitemsg as web>
<tr>
<td class="tl tf" style="padding:1px 0 1px 5px;" width="27">
<input type="checkbox"  style="padding:1px 0 1px 5px;" unread="true" fn="${web.title}" name="mailid" id="mailid" value="${web.msgid}" colid="" ssystag="" init="true" />
</td>
 <td class="o_title2" style="width:6px;font-size:1px;padding:0;">&nbsp;</td>   
<td class="l" onclick="">
<table cellspacing="0" class="i">
<tbody>
<tr>
<td title="${web.msgfromusrname}" class="tl tf"><nobr>${web.msgfromusrname}</nobr>
</td>

<td class="gt tf">
<div>
<u class="black " tabindex="0">&nbsp;&nbsp;&nbsp; <a id="${web.msgid}" name="${web.msgid}" onClick="titleOnclick(${web.msgtextid})">${web.title}</a></u>
&nbsp;</div>
<div class="TagDiv"></div></td>
</tr>
</tbody>
</table>
</td>
</tr>
 </#list>
			</#if>
</table>
  </div>
  
  <div style="display:none" id="write">
	<table>
	<tr>
	<td>收件人：</td>
	<td><input type="text" id="addressee" name="addressee"width="400px"/></td>
	</tr> 
	<tr>
	<td>标题：</td>
	<td><input type="text" id="title" name="title"width="400px"/></td>
	</tr>
	<tr>
	<td>内容：</td>
	<td><textarea id="detail" name="detail" width="450px" rows="10" ></textarea></td>
	</tr>
	<tr><td> </td> <td align="center"> 
	<input type="button" id="add" name="add" value="提交"/>
	</td></tr>
	</table>
	</div>
	
	<div style="display:none" id="text1">
	
	<div>
		<table cellspacing="0" cellpadding="0" border="0" style="height:24px">
			<tbody>	
				<tr> 
					<td class="txt_left settingtable readmail_subject" valign="middle" height="24" style="word-break:break-all;padding:9px 8px 2px 14px;">
							<div class="qm_left" style="padding-bottom:3px;">
								<span  id="subject" class="sub_title s1">塔克商城--<input class="sub_title s1" type="text" id="webtitle" style= "border:#FF0000   0px   solid;  color: #2131A1; " readonly="readonly"/></span> </div>
							<div id="tagContainer" class="TagDiv TagReadmail" style="overflow:visible;margin-top:0;" ck="tag"></div>
						<div class="clr"></div>
					</td>

				</tr>
			</tbody>
		</table>
	</div>
	<div>
	<table cellspacing="0" cellpadding="0" border="0" style="height:24px">
	<tbody>
	<tr>
	<td>
	<span class="addrtitle">发件人：</span>
	<input type="text" id="msgfromusrname" style= "border:#FF0000   0px   solid; width:300px;  "readonly="readonly"/>
	</td>
	</tr>
	</tbody>
	</table>
	</div>
	<div>
	<table cellspacing="0" cellpadding="0" border="0" style="height:24px">
	<tbody>
	<tr>
	<td>
	<span class="addrtitle">时间：</span><input type="text" id="createtime" style= "width:300px;border:#FF0000   0px   solid; "readonly="readonly"/> 
	</td>
	</tr>
	</tbody>
	</table>
	</div>
	<div>
	<table cellspacing="0" cellpadding="0" border="0" style="height:24px">
	<tbody>
	<tr>
	<td>
	<span class="addrtitle">收件人：</span><input type="text" id="msgtousername" style= "width:300px; border:#FF0000   0px   solid; "readonly="readonly"/> 
	</td>
	</tr>	
	</tbody>
	</table>	
	</div>
	<div>
	<table cellspacing="0" cellpadding="0" border="0" style="height:24px">
	<tbody>
	<tr> <div><textarea id="msgtext" name="msgtext"   style= "border:#FF0000   0px   solid; width: 832px ; "readonly="readonly" style='overflow:scroll;overflow-y:hidden;;overflow-x:hidden'
onfocus="window.activeobj=this;this.clock=setInterval(function(){activeobj.style.height=activeobj.scrollHeight+'px';},200);" onblur="clearInterval(this.clock);" ></textarea> </div></tr>
		</tbody>
	</table>	
	</div>
	
  </div>
  
</div>
<div id="dtmem_bot" class="dtmem_bot_ind"></div>
</div>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">

</body>
</html>