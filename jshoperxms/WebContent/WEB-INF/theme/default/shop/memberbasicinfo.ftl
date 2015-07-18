<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>基本资料</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
<script type="text/javascript"  src="${basepath}/ui/default/js/location.js"></script>
<script type="text/javascript"  src="${basepath}/ui/default/js/YLChinaArea.js"></script>
<script type="text/javascript"  src="${basepath}/jshop/admin/js/jquery.form.js"></script>

</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<div id="ind_main" style="display:block;background-color:#ffffff">
<div id="ind_fix">
<#include "/WEB-INF/theme/default/shop/usermenu.ftl">

<div id="mem_right" name="mem_right" style="display:block">
<div id="mem_position"><a href="/Member/index.jsp" target="_parent">会员专区</a> &gt; <a href="/Member/UserUpdateForm.do">我的资料</a></div>
<div id="hui_r">
  <div class="m1top"><span>我的资料</span></div>
  <div class="mem_bor_006194" style="height:1%;">
  <#if Session??&&Session["user"]?exists>
    <div style="padding:0px 15px">
        <div class="myinfo_rtoptxt">我当前的个性头像：</div>
        <div class="myinfo_rm1">
          <div class="myinfo_rm1l"> <img id="fileChecker" name="fileChecker" src="${user.headpath}" alt=""> </div>
          <div class="myinfo_rm1r">
            <div class="myinfo_rm1rt1">选择你的个性头像，<br>
              请点击“浏览”后，选择需要上传的图片！</div>
            	<input name="providerInnerName" value="userBaseDatum" type="hidden">
           		<input name="deleteTopPic" id="deleteTopPic" type="hidden">
            <div class="myinfo_rm1rt2">上传新头像：
             	<form id="form2" action="uploadFile" method="post" enctype="multipart/form-data">              
                <tr>                      
				<td>  
                        <input id="fileupload" name="fileupload" type="file" />  
						<div id="tipDiv"></div>
						<input type="submit" class="right-button02"   value="上传" />  
                          
                    </td>  
                </tr>  
                
             
        </form>  
            </div>
            <div class="myinfo_rm1rt3">要求：图片尺寸最大100*100像素，文件大小100k以内（支持JPG，GIF）。</div>
          </div>
        </div>
        <div class="myinfo_rtoptxt">基本联系方式：</div>
        <div>
          <ul>
			
            <li class="mem_data01">用 户 名：</li>
            <li class="mem_data02" style="height:25px;padding-top:5px;">${user.username}</li>
            <li class="mem_data01">电子邮件：</li>
            <li class="mem_data02 mem_w_gray" style="height:25px;padding-top:5px;">
			   ${user.email}
            </li>
            <li class="mem_data01">真实姓名：</li>
            <li class="mem_data02 mem_w_gray" style="float:left;width:19%;">
			   <#if user.realname??>
              <input id="realname" name="realname" class="mem_bor_9e9e9e" style="width:129px;" value="${user.realname}" type="text">
			  <#else>
			  <input id="realname" name="realname" class="mem_bor_9e9e9e" style="width:129px;" value="" type="text">
			  </#if>
            </li>
            <li class="mem_data02 mem_w_gray" style="width:64%; float:left; line-height:18px; height:auto">( 为保障您的利益，请务必填写真实姓名，因为领取奖金、奖品和收货都要验证真实身份。真实姓名设置之后不可以修改，需要修改请联系客服。 )</li>
            <div class="clear"></div>
            <li class="mem_data01">性别：</li>
            <li class="mem_data02 mem_w_gray">
			<#if (user.sex??)&&(user.sex=='1')>
              <input id="sex" name="sex" value="1" type="radio" checked>
              &nbsp;
              <label>男</label>
              <input id="sex" name="sex" value="0" type="radio">
              &nbsp;
              <label>女</label>
			<#else>
			  <input id="sex" name="sex" value="1" type="radio">
              &nbsp;
              <label>男</label>
              <input id="sex" name="sex" value="0" type="radio" checked>
              &nbsp;
              <label>女</label>
			</#if>
            </li>
            <li class="mem_data01">出生日期：</li>
            <li class="mem_data02 mem_w_gray">
              <div id="displaybir"><font size="2">
                <select name="birYear" id="birYear" onchange='javascript:resetYearInnerHtml(this,"bir")'>
                  <option value="-1" selected="selected">请选择</option>
                  <option value="2012" selected="selected">2012</option>
                  <option value="2011">2011</option>
                  <option value="2010">2010</option>
                  <option value="2009">2009</option>
                  <option value="2008">2008</option>
                  <option value="2007">2007</option>
                  <option value="2006">2006</option>
                  <option value="2005">2005</option>
                  <option value="2004">2004</option>
                  <option value="2003">2003</option>
                  <option value="2002">2002</option>
                  <option value="2001">2001</option>
                  <option value="2000">2000</option>
                  <option value="1999">1999</option>
                  <option value="1998">1998</option>
                  <option value="1997">1997</option>
                  <option value="1996">1996</option>
                  <option value="1995">1995</option>
                  <option value="1994">1994</option>
                  <option value="1993">1993</option>
                  <option value="1992">1992</option>
                  <option value="1991">1991</option>
                  <option value="1990">1990</option>
                  <option value="1989">1989</option>
                  <option value="1988">1988</option>
                  <option value="1987">1987</option>
                  <option value="1986">1986</option>
                  <option value="1985">1985</option>
                  <option value="1984">1984</option>
                  <option value="1983">1983</option>
                  <option value="1982">1982</option>
                  <option value="1981">1981</option>
                  <option value="1980">1980</option>
                  <option value="1979">1979</option>
                  <option value="1978">1978</option>
                  <option value="1977">1977</option>
                  <option value="1976">1976</option>
                  <option value="1975">1975</option>
                  <option value="1974">1974</option>
                  <option value="1973">1973</option>
                  <option value="1972">1972</option>
                  <option value="1971">1971</option>
                  <option value="1970">1970</option>
                  <option value="1969">1969</option>
                  <option value="1968">1968</option>
                  <option value="1967">1967</option>
                  <option value="1966">1966</option>
                  <option value="1965">1965</option>
                  <option value="1964">1964</option>
                  <option value="1963">1963</option>
                  <option value="1962">1962</option>
                  <option value="1961">1961</option>
                  <option value="1960">1960</option>
                  <option value="1959">1959</option>
                  <option value="1958">1958</option>
                  <option value="1957">1957</option>
                  <option value="1956">1956</option>
                  <option value="1955">1955</option>
                  <option value="1954">1954</option>
                  <option value="1953">1953</option>
                  <option value="1952">1952</option>
                  <option value="1951">1951</option>
                  <option value="1950">1950</option>
                  <option value="1949">1949</option>
                  <option value="1948">1948</option>
                  <option value="1947">1947</option>
                  <option value="1946">1946</option>
                  <option value="1945">1945</option>
                  <option value="1944">1944</option>
                  <option value="1943">1943</option>
                  <option value="1942">1942</option>
                  <option value="1941">1941</option>
                  <option value="1940">1940</option>
                  <option value="1939">1939</option>
                  <option value="1938">1938</option>
                  <option value="1937">1937</option>
                  <option value="1936">1936</option>
                  <option value="1935">1935</option>
                  <option value="1934">1934</option>
                  <option value="1933">1933</option>
                </select>
                年
                <select name="birMonth" id="birMonth" onchange='javascript:resetMonthInnerHtml(this,"bir")'>
                  <option value="-1" selected="selected"></option>
                  <option value="01">01</option>
                  <option value="02">02</option>
                  <option value="03">03</option>
                  <option value="04">04</option>
                  <option value="05">05</option>
                  <option value="06">06</option>
                  <option value="07">07</option>
                  <option value="08">08</option>
                  <option value="09">09</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
                </select>
                月
                <select name="birDay" id="birDay">
                  <option value="-1" selected="selected"></option>
                  <option value="01">01</option>
                  <option value="02">02</option>
                  <option value="03">03</option>
                  <option value="04">04</option>
                  <option value="05">05</option>
                  <option value="06">06</option>
                  <option value="07">07</option>
                  <option value="08">08</option>
                  <option value="09">09</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
                  <option value="13">13</option>
                  <option value="14">14</option>
                  <option value="15">15</option>
                  <option value="16">16</option>
                  <option value="17">17</option>
                  <option value="18">18</option>
                  <option value="19">19</option>
                  <option value="20">20</option>
                  <option value="21">21</option>
                  <option value="22">22</option>
                  <option value="23">23</option>
                  <option value="24">24</option>
                  <option value="25">25</option>
                  <option value="26">26</option>
                  <option value="27">27</option>
                  <option value="28">28</option>
                  <option value="29">29</option>
                </select>
                日</font></div>
            </li>
            <li class="mem_data01">手 &nbsp;&nbsp;&nbsp;机：</li>
            <li class="mem_data02 mem_w_gray">
			  <#if user.mobile??>
              <input id="mobile" name="mobile" class="mem_bor_9e9e9e" style="width:129px;" value="${user.mobile}" type="text">
			  <#else>
			  <input id="mobile" name="mobile" class="mem_bor_9e9e9e" style="width:129px;" value="" type="text">
			  </#if>
			</li>
            <li class="mem_data01">固定电话：</li>
            <li class="mem_data02 mem_w_gray">
			   <#if user.telno??>
              <input id="telno" name="telno" class="mem_bor_9e9e9e" style="width:129px;" value="${user.telno}" type="text">
			  <#else>
			  <input id="telno" name="telno" class="mem_bor_9e9e9e" style="width:129px;" value="" type="text">
			  </#if>
              <span>( 区号+号码 )</span></li>
            <li class="mem_data01">所在地区：</li>
            <li class="mem_data02 mem_w_gray">
				<div id="ChinaArea">
					<select id="province" name="province" style="width: 100px;"></select>
					<select id="city" name="city" style="width: 100px;"></select>
					<select id="district" name="district" style="width: 120px;"> </select>      
				</div>
              <input nodepath="1601,1602" value="1602" id="regionId" name="RegionId" treename="region" treebean="regionTree" class="selectTree" type="hidden">
              <input id="region_0" valueelemid="regionId" value="1601" level="0" type="hidden">
            </li>
            <li class="mem_data01">详细地址：</li>
            <li class="mem_data02 mem_w_gray">
			  <#if user.address??>
              <input id="address" name="address" class="mem_bor_9e9e9e" style="width:400px;" value="${user.address}" type="text">
              <#else>
			  <input id="address" name="address" class="mem_bor_9e9e9e" style="width:400px;" value="" type="text">
			  </#if>
			</li>
            <li class="mem_data01">邮政编码：</li>
            <li class="mem_data02 mem_w_gray">
			   <#if user.postcode??>
              <input id="postcode" name="postcode" class="mem_bor_9e9e9e" style="width:129px;" value="${user.postcode}" type="text">
			  <#else>
			  <input id="postcode" name="postcode" class="mem_bor_9e9e9e" style="width:129px;" value="" type="text">
              </#if>
            </li>
          </ul>
        </div>
        <br>
        <input value="userBaseDatum" name="providerInnerName" type="hidden">
        <div class="myinfo_rtoptxt">我的其它资料： <span class="mem_w_gray">( 填写更多资料可以让人更了解你 )</span></div>
        <div style="padding-top:10px;">
          <ul>
            <li class="mem_data01">qq：</li>
            <li class="mem_data02 mem_w_gray" id="testqq">
             
			  <#if user.qq??>
              <input id="qq" name="qq" size="50" value="${user.qq}" type="text">
			  <#else>
			  <input id="qq" name="qq" size="50" value="" type="text">
			  </#if>
            </li>
            <li class="mem_data01">msn：</li>
            <li class="mem_data02 mem_w_gray" id="testmsn">
			<#if user.msn??>
              <input id="msn" name="msn" size="50" value="${user.msn}" type="text">
			  <#else>
			  <input id="msn" name="msn" size="50" value="" type="text">
			  </#if>
            </li>
            
            <li class="mem_data01">微博地址：</li>
            <li class="mem_data02 mem_w_gray" id="testweb">
			<#if user.othercontract??>
              <input id="othercontract" name="othercontract" size="50" value="${user.othercontract}" type="text">
            <#else>
			<input id="othercontract" name="othercontract" size="50" value="" type="text">
			</#if>
			</li>
			<li class="mem_data01">兴趣爱好：</li>
            <li class="mem_data02 mem_w_gray" id="testweb">
			<#if user.hobby??>
              <input id="hobby" name="hobby" size="50" value="${user.hobby}" type="text">
            <#else>
			<input id="hobby" name="hobby" size="50" value="" type="text">
			</#if>
			</li>
			</#if>
          </ul>
        </div>
		<div style="padding-top:25px;">
          <ul>
            <li class="Determined">
<input type="button" id="userbascinfosubmit" name="userbascinfosubmit" value="提交更新"/>
            </li>
            <li class="Re_fill" style="padding-left:40px;">
			
			</li>
            <li id="p_last">&nbsp;</li>
          </ul>
        </div>
		<div id="showMsg" style="font-weight:bold;height:20px;width:200px;color:#fff;line-height:20px;margin-left:260px;background:#ef8f00;visibility:hidden;" align="center"></div>
     </div>
  </div>
</div>
</div>
  <div class="mem_fixHeight"></div>
</div>
</div>
<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
 <script type="text/javascript">  
function uploadImage() {  
    $(document).ready(function() {  
                        var options = {  
                            url : "${basepath}//uploadFile.action",  
                            type : "POST",  
                            dataType : "script",  
                            success : function(msg) {  
                                if (msg.indexOf("#") > 0) {  
                                    var data = msg.split("#");  
                                    $("#tipDiv").html(data[0]);  
									//图片浏览
                                  <!--  $("#showImage").html("<img src='<%=basepath%>/showImage.action?imageUrl="+data[1]+"'/>");  -->
                                } else {  
                                    $("#tipDiv").html(msg);  
                                }  
                            }  
                        };  
                        $("#form2").ajaxSubmit(options);  
                        return false;  
                    });  
}  
</script>  
</body>
</html>