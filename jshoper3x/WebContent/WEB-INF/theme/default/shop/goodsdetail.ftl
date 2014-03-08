<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="Author" content="OSTOCY">
<meta name="Copyright" content="OSTOCY">
<meta http-equiv="expires" content="0">
<#if (jshopbasicinfo.metaKeywords)! != "">
<meta name="keywords" content="${jshopbasicinfo.metaKeywords}" />
</#if>
		<#if (jshopbasicinfo.metaDes)! != "">
<meta name="description" content="${jshopbasicinfo.metaDes}" />
</#if>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${goodsdetail.goodsname}</title>
<link href="${basepath}/ui/default/css/global.css" rel="stylesheet" type="text/css" />
<link href="${basepath}/ui/default/css/details.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/goodshow.css"/>
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/jqzoom.css"/>
<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/tabs-accordion.css"/>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.tools.min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.jqzoom.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.dimensions.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.sexy-vote.js"></script>
<script type="text/javascript" src="${basepath}/jshop/admin/js/kindeditor-min.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jquery.cookie.js"></script>
</head><body>
<input type="hidden" id="hidurl" name="hidurl" value=""/>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">
<div id="main">
  <div class="location"> 您所在的位置： <a href="/">欧斯塔克商城</a> &gt; <a href="/">${goodsdetail.nname}</a> &gt; <a href="/">${goodsdetail.lname}</a> &gt; <a href="/">${goodsdetail.sname}</a> </div>
  <div class="content mt5">
    <div id="mainleft">
      <div class="m_leftdiv01"> <#if (secondgoodscategory??)&&(secondgoodscategory?size>0)>
        <h1> 本品类同级分类 </h1>
        <ul>
          <#list secondgoodscategory as sct> 
          <#if sct.htmlpath! !="">
          <li> <a href="${basepath}/<@sct.htmlpath?interpret />">${sct.name}</a> </li>
          </#if>
          </#list>
        </ul>
        </#if>
        <div class="m_leftdiv01foot"></div>
      </div>
      <#if (goodstypebrandt??)&&(goodstypebrandt?size>0)>
      <div class="m_leftdiv02 mt7">
        <h1> 同类品牌 </h1>
        <ul>
          <#list goodstypebrandt as gtbt>
          <li> <a href="#?brandid=${gtbt.brandid}">${gtbt.brandname}</a> </li>
          </#list>
        </ul>
        <div class="m_leftdiv02foot"></div>
      </div>
      </#if>
      <div class="m_leftdiv03 mt7" id="viewHistory"></div>
      <div class="m_leftdiv02 mt7"> <a href=""><a href='#' target='_blank'><img src='${basepath}/ui/default/images/20120302084354280.jpg'  width='200' height='240' alt='' border='0' /></a></a> </div>
      <div class="m_leftdiv02 mt7"> <a href=""><a href='#' target='_blank'><img src='${basepath}/ui/default/images/20120302084447454.jpg'  width='200' height='240' alt='' border='0' /></a></a> </div>
      <div class="m_leftdiv02 mt7"> <a href=""><a href='#' target='_blank'><img src='${basepath}/ui/default/images/20120302084732989.jpg'  width='200' height='240' alt='' border='0' /></a></a> </div>
      <div class="m_leftdiv02 mt7" id="viewHistory"><h1>浏览记录</h1></div>
      <div class="m_leftdiv02 mt7" id="goodshistory"></div>
	
	</div>
    <#if (goodsdetail??)&&(goodsdetail?size>0)>
    <div id="mainright">
      <div class="detail_info">
        <div class="title"> ${goodsdetail.goodsname} </div>
        <div class="detail_info_l">
          <div class="detail_info_lm1">
            <div class="bigpro">
              <div id="myImagesSlideBox" class="myImagesSlideBox">
                <div class="myImages"> <#list goodsdetail.pictureurl?split(",") as img> <img src="${basepath}${img}" class="myImgs" bigimg="${basepath}${img}"  jqimg="${basepath}${img}"></img> </#list> </div>
                <div class="myTxts"> <a href="#">在新窗口查看大图.</a> </div>
                <div id="scrollable"> <a class="prev" href="#" title="上一张"></a>
                  <div class="items" >
                    <div class="scrollableDiv"> <#list goodsdetail.pictureurl?split(",") as img> <a><img src="${basepath}${img}" imgb="${basepath}${img}"  bigimg="${basepath}${img}" ></a> </#list> </div>
                    <br clear="all"/>
                  </div>
                  <a class="next" href="#" title="下一张"></a> </div>
              </div>
            </div>
          </div>
          <div class="detail_info_lm2">
            <!-- JiaThis Button BEGIN -->
            <!--<div id="ckepop"> <span class="jiathis_txt">分享到：</span> <a class="jiathis_button_qzone">QQ空间</a> <a class="jiathis_button_tsina">新浪微博</a> <a class="jiathis_button_renren">人人网</a> <a class="jiathis_button_kaixin001">开心网</a> <a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" target="_blank">更多</a> <a class="jiathis_counter_style"></a> </div>
            <script type="text/javascript" src="http://v2.jiathis.com/code/jia.js" charset="utf-8"></script>-->
            <!-- JiaThis Button END -->
          </div>
        </div>
        <div class="detail_info_r" style="position: relative;">
          <div class="detail_info_rm1">
            <div class="rm1_2"> 商品编号：${goodsdetail.usersetnum} </div>
            <div class="rm1_3"> 会员价： <span id="changingmemberprice">￥<cite>${goodsdetail.memberprice}</cite> </span> </div>
            <br />
            <div class="rm1_5"> <span>购买该商品，您可获得</span><span id="integralCell" style="color: black;">${goodsdetail.points}</span> <span>积分!</span> <br>
              <br>
              <span id="erroring"></span> </div>
          </div>
          <!-- 隐藏的goodsid -->
          <input type="hidden" id="hidgoodsid" name="hidgoodsid" value="${goodsdetail.goodsid}"/>
          <input type="hidden" id="hidgoodsname" name="hidgoodsname" value="${goodsdetail.goodsname}"/>
          <input type="hidden" id="hidreadcount" name="hidreadcount" value="${goodsdetail.readcount}"/>
          <input type="hidden" id="hidprice" name="hidprice" value="${goodsdetail.price}"/>
          <input type="hidden" id="hidpictureurl" name="hidpictureurl" value="${goodsdetail.pictureurl}">
          <input type="hidden" id="hidhtmlpath" name="hidhtmlpath" value="${goodsdetail.htmlPath}">
		  <#setting number_format="0">
          <input type="hidden" id="hidmemberprice" name="hidmemberprice" value="${(goodsdetail.memberprice)}"/>
          <div class="detail_info_rm3"> <#if (goodsspecification??)&&(goodsspecification?size>0)>
            <!--隐藏的规格标记表示是否开启了规格-->
            <input type="hidden" id="hidguigeflag" name="hidguigeflag" value="1"/>
            <!--隐藏的产品id唯一且只有一个值-->
            <input type="hidden" id="hidproductid" name="hidproductid" value=""/>
            <#list goodsspecification as gs>
            <#if gs.specificationsType=='1'>
            <div class="rm3_4">
              <p>选择${gs.name}：</p>
              <cite> <#list gs.specificationsValue?split('-') as scv>
              <#assign gdata=scv?eval /> <a href="#" title="${gdata.goodsattributename}" class="text_current"> ${gdata.goodsattributename} </a> </#list> </cite> </div>
            </#if>
            <#if gs.specificationsType=='2'>
            <div class="rm3_1">
              <p>选择${gs.name}：</p>
              <cite> <#list gs.specificationsValue?split('-') as scv>
              <#assign gdata=scv?eval /> <a  href="#" title="${gdata.goodsattributename}" class="rm3_pic">
              <!--<img src="http://img.tao3c.com/601/603/78500/108400/111200/218205_1_pic60_6952.jpg">-->
              <div style="width:60px;height:60px;background-color:${gdata.attributelist}"></div>
              </a> </#list> </cite> </div>
            </#if>
            </#list>
            <div class="rm3_2">
              <!--已选择：<span id="selectedguigea"></span>-->
            </div>
            </#if>
            <div class="rm3_3">
			<#if goodsdetail.isvirtual=='1'>
				<#if goodsdetail.goodsTypeName='充值卡'>
				 <input onClick="addtovirtualgoodscart(${goodsdetail.goodsid});" type="button" name="addcart" id="addcart" value="" style="cursor:pointer;"/>
				<#else>
				<input onClick="addtovirtualgoodsmovie(${goodsdetail.goodsid});" type="button" name="addcart" id="addcart" value="" style="cursor:pointer;"/>
				
				</#if>
            <#else>
			 <input onClick="addcart();" type="button" name="addcart" id="addcart" value="" style="cursor:pointer;"/>
			</#if>
              <input onClick="addfav();" type="button" name="addfav" id="addfav" value="" style="cursor:pointer;"/>
              <span id="addfavok"></span>

			  </div>
          </div>
        </div>
		<#if (goodsbelinked??)&&(goodsbelinked?size>0)>
        <div class="setmeal mt10">
          <div class="setmeal_top">
            <p><img src="${basepath}/ui/default/images/setmeal_t_1.gif"></p>
            <cite><img src="${basepath}/ui/default//images/setmeal_t_3.gif"></cite></div>
          <h1 id="unit_h1">
            <p>该商品所有的套餐列表</p>
            <cite>总共有(goodsbelinked?size)件可选套餐 </cite></h1>
			
          <div class="set_1" id="div_set1">
            <div class="set_1_l">
              <p>
			  <#list goodsdetail.pictureurl?split(",") as mainimg>
			  <#if mainimg_index == 0>
				  <#assign firstimg = "${mainimg}" />
				   <img width="160" hight="160" src="${basepath}/${firstimg}" alt="${goodsdetail.goodsname}">
			  </#if>
				</#list>
			 </p>
              <span></span> </div>
            <div class="set_1_r">
              <div class="pageup">  </div>
              <div class="set_1_r_unit">
                <div class="smallunit" id="detail_scro1">
                  <ul>
				    <#list goodsbelinked as gbl>
                    <li id="pack_product_${gbl.belinkedgoodsid}" class="">
                      <div class="set_1_r_1"><a href="${basepath}/${gbl.htmlpath}" target="_blank;"><img width="100px" height="100px" src="${gbl.pictureurl}" alt="${gbl.goodsname} "></a></div>
                      <div class="set_1_r_2"><a href="${basepath}/${gbl.htmlpath}" target="_blank;" title="${gbl.goodsname} ">${gbl.goodsname} </a></div>
                      <div class="set_1_r_3">市场价:￥${gbl.price} </div>
                      <div class="set_1_r_4">会员价:￥${gbl.memberprice}</div>
                      <input type="hidden" id="pp_price_${gbl.belinkedgoodsid}" value="${gbl.memberprice}">
                      <div class="set_1_r_5"><img id="img_pack_product_${gbl.belinkedgoodsid}" src="${basepath}/ui/default/images/shop_1.gif" onclick="submitPack(${gbl.belinkedgoodsid});" style="cursor:pointer;"></div>
                    </li>
					</#list>
                  </ul>
                </div>
              </div>
              <div class="pagedn" style="z-index:6;"> </div>
            </div>
          </div>
          <div class="set_2" id="div_set2">
            <div class="left_div" style="display:none;">
              <p><cite>套餐选购总金额: <span id="packTotalPrice"></span></cite></p>
            </div>
            <div class="right_div"> <img id="addPackProductsToCart" src="${basepath}/ui/default/images/setmeal_btn.gif" onclick="addbelinkedGoodsTocart();" style="cursor:pointer;"> </div>
          </div>
          <div class="setmeal_bottom">
            <p><img src="${basepath}/ui/default/images/setmeal_t_4.gif"></p>
            <cite><img src="${basepath}/ui/default/images/setmeal_t_6.gif"></cite> </div>
        </div>
		</#if>
      </div>
      <div class="prodetailtext mt10">
        <div>
          <ul class="css-tabs">
            <li onClick="showdiv('0')"><a href="javascript:;">商品详情</a></li>
            <li onClick="showdiv('1')"><a href="javascript:;" >具体参数</a></li>
            <li onClick="showdiv('5')"><a href="javascript:;" >包装清单</a></li>
            <li onClick="showdiv('2')"><a href="javascript:;" >售后服务</a></li>
            <li onClick="showdiv('3')"><a href="javascript:;" >客户点评</a></li>
            <li onClick="showdiv('4')"><a href="javascript:;" >售前咨询</a></li>
          </ul>
          <div class="css-panes">
            <!--1-->
            <div id="gddiv0" class="tabother" style="display:block;">
              <div class="prodetailbox" id="cont1">
                <div class="prodetailbox_title"> ${goodsdetail.goodsname} </div>
                <div class="prodetailtext"> ${goodsdetail.detail} </div>
              </div>
            </div>
            <!--2-->
            <div id="gddiv1" style="display:none;">
              <div class="parameter mt40" id="cont2">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" class="parameter_table">
                  <tr>
                    <td colspan="2" class="parameter_title"> 重要参数 </td>
                  </tr>
                  <#if (goodsparameters??)&&(goodsparameters?size>0)>
                  <#list goodsparameters as gp>
                  <#if gp.paramValue! !="">
                  <tr>
                    <td class="parameter_td1"> ${gp.paramName} </td>
                    <td class="parameter_td2"> ${gp.paramValue} </td>
                  </tr>
                  </#if>
                  </#list>
                  </#if>
                </table>
              </div>
            </div>
            <!--5-->
            <div id="gddiv5" style="display:none;">
              <div class="prodetailbox" id="cont1">
                <div class="prodetailtext"> ${goodsdetail.commoditylist} </div>
              </div>
            </div>
            <!--3-->
            <div id="gddiv2" style="display:none;">
              <div class="after mt40" id="cont4">
                <div class="m_div1">
                  <p> 本产品全国联保，享受三包服务，质保期为：一年质保 <br>
                    因质量问题或故障，凭厂商维修中心或特约维修点的质量检测证明，享受7日内退货，15日内换货，15日以上在质保期内享受免费保修等三包服务！ </p>
                </div>
              </div>
            </div>
            <!--4-->
            <div id="gddiv3" style="display:none;">
              <div class="packing mt40" id="cont5">
                <div class="packingbox"> <#if (goodscomments??)&&(goodscomments?size>0)>
                  <#list goodscomments as gc>
                  <div class="packingtop">
                    <div class="packingpic"> <img src="${basepath}/ui/default/images/hui_60_60.jpg" alt="" width="70px" height="70px" /> </div>
                    <div class="packingname">
                      <p> <a>${gc.replyorcommentusername}</a> </p>
                      <cite>评论于${gc.posttime}</cite> </div>
                    <div class="packingcontent"> ${gc.commentcontent} </div>
                    <div class="packingbtn">
                      <!--<a href="javascript:;" onclick="repalyRemark_new(207900,368847,'jasonduzx','使用一个多月，很不错。不过最值得自豪和高兴的就是买的时候高鸿价格是最低的，行货卖水货价，2499，可惜了，本来想再买一个呢，没那个价钱了。');">回复</a><a href="javascript:;" onclick="referRemark(207900,368847,'jasonduzx','使用一个多月，很不错。不过最值得自豪和高兴的就是买的时候高鸿价格是最低的，行货卖水货价，2499，可惜了，本来想再买一个呢，没那个价钱了。');">引用</a>
											-->
                    </div>
                  </div>
                  </#list>
                  </#if> </div>
                <!--评论只获取10条-->
                <form id="addRemarks">
                  <div class="packingreview">
                    <div class="packcite" id="referDiv" style="display: none;">
                      <p id="_username"></p>
                      <div class="packingcontent" id="_content"></div>
                    </div>
                    <div class="p_re_div1">
                      <p> 我要评论 </p>
                      <cite>
                      <textarea id="commentcontent" name="commentcontent" cols="" rows=""></textarea>
                      </cite> </div>
                    <div class="p_re_div2"> <a href="javascript:;"><img src="${basepath}/ui/default/images/re_btn1.gif" onclick="addgoodscomment();" /> </a> </div>
                  </div>
                </form>
              </div>
            </div>
            <!--5-->
            <div id="gddiv4" style="display:none;"> 服务暂未开通
              <!--<div class="consult mt40" id="cont6">
									<div class="consultdiv1">
										<div class="consultdiv1_1">
											网友：lcslms 咨询：现在有货没有？
										</div>
										<div class="consultdiv1_2">

											2021：亲爱的顾客您好！有现货的，请您放心购买！感谢您的支持，祝您在高鸿商城购物愉快！ &nbsp;&nbsp;
											<font color="#2379B5">2011-10-19 08:44</font>

										</div>
									</div>
									
									<form id="addConsults" onsubmit="return false;">
										<input type="hidden" id="consultObjeId" name="consultObjeId" value="207900" />
										<input type="hidden" id="mid" name="mid" value="0" />
										<input type="hidden" id="flag" name="flag" value="consult" />
										<div class="clear"></div>
										<div class="consultdiv7">
											<p>
												咨询类别
											</p>
											<cite><input name="consultType" type="radio" value="1109051" id="consultType" checked="checked" />
											</cite>
											<span>商品类</span>
											<cite><input id="consultType" name="consultType" type="radio" value="1109052" />
											</cite>
											<span>服务类</span>

										</div>
										<div class="consultdiv3">
											<p>
												咨询内容
												<s>*</s>
											</p>
											<cite> <input id="consultContent" name="consultContent" type="text" /> <!-- <textarea rows="5" cols="50" id="consultContent" name="consultContent"></textarea> </cite>
										</div>

										<div class="consultdiv4">
											<p>
												您的邮箱
												<s>*</s>
											</p>
											<cite><input id="email" name="email" type="text" onblur="checkEmail();" /> </cite>
										</div>

										<div class="consultdiv5">
											<p>
												验证码
												<s>*</s>
											</p>
											<cite><input name="ValidateCode" id="ValidateCode" type="text" /> </cite><span><img src='/ValidateCode' name="ValidateCode" width="60" height="20" id="vValidateCode" /> </span>
											<code>
												<a href="javascript:vCodeRefresh1();">看不清，换一张</a>
											</code>
										</div>
										<div class="consultdiv6">
											<p>
												<a href="javascript:;" onclick="checkConsultForm();"><img src="/datang/templets/Default/Default/images/re_btn3.gif" /> </a>
											</p>
											<cite></cite>
										</div>
									</form>
								</div>-->
            </div>
          </div>
        </div>
      </div>
      </#if> </div>
  </div>
</div>
<#include "/WEB-INF/theme/default/shop/footer.ftl">
<script type="text/javascript" src="${basepath}/ui/default/js/jshopeasyslider.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>
