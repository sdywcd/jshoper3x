
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head>
     <title>${(goodscategory.name)}--商品列表--Powered By OSTOCY</title>
	<meta name="Author" content="OSTOCY">
	<meta name="Copyright" content="OSTOCY">
	<meta http-equiv="expires" content="0">    
	<#if (jshopbasicinfo.metaKeywords)! != ""><meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/></#if>
	<#if (jshopbasicinfo.metaDes)! != ""><meta name="description" content="${jshopbasicinfo.metaDes}"/></#if>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
	<link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/list.css" />
	<script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
  </head>
  
  <body>

<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

<!--页面标识-->
<input type="hidden" id="hidurl" name="hidurl" value=""/>
<input type="hidden" id="hidsign" name="hidsign" value="${goodscategory.sign}"/>
<div id="main">
  <div class="content2 mt5">
    <div id="mainleft">
      <div class="sortnav">
		<#if (secondgoodscategory??)&&(secondgoodscategory?size>0)>
        <div class="sortnav_t"><a target="_blank" href="#">本品类同级分类</a></div>
        <ul>
		  <#list secondgoodscategory as sct>
		  <#if sct.htmlpath! !="">
		  <li><a href="${basepath}/<@sct.htmlpath?interpret />">${sct.name}</a></li>
          
		  </#if>
		  </#list>
		</ul>
		</#if>
      </div>
      <div class="sortnav_b">
        <p><img src="${basepath}/ui/default/images/sortnav7.gif" /></p>
        <cite><img src="${basepath}/ui/default/images/sortnav9.gif" /></cite></div>
     
    </div>
    <!-- 搜索条件开始 -->
    <div id="mainright">
      <div class="classify">
        <h1>
          <p></p>
          <cite></cite> </h1>
        <div class="classify_box">
          <ul>
		    <#if (goodstypebrandt??)&&(goodstypebrandt?size>0)>
            <li>
              <p>按品牌选择</p>
              <span>
			  <a class="curr" href="#">全部</a>
			  <#list goodstypebrandt as gtbt>
			    <a href="#?brandid=${gtbt.brandid}">${gtbt.brandname}</a> 
			  </#list>
			  </span>
			</li>
			</#if>
			<#if (goodsattrs??)&&(goodsattrs?size>0)>
            <#list goodsattrs as ga>
			<li>
              <p>${ga.goodsattributename}</p>
              <span> <a class="curr" href="#">全部</a>
			  <#list ga.attributelist?split(",") as attr>
			  <a href="#?attrs=${attr}">${attr}</a>
			  </#list>
			  </span>
			</li>
			</#list>
			</#if>
          </ul>
          <!-- 搜索条件结束 -->
        </div>
        <div class="classifyfoot">
          <p></p>
          <cite></cite></div>
      </div>
      <div class="productlist mt10">
        <h1>
          <div class="productlist_l1">您所搜索的商品共有<span>${goods.totalRecord}</span>个商品 共<span>${goods.bottomPages}</span>页</div>
          <div class="productlist_r1">
            <div class="mode">
              <!--<p>显示方式：</p>
              <span><a href="/ProductList.do?displayType=1&amp;pageSize=24&amp;Cid=51302&amp;Keywords=&amp;ppath=ZiwscHVzaHR5cGUwLCwvLCwxLCw7O2MsLGNpZCws56yU6K6w5pysLCw1MTMwMiws"><img src="${basepath}/ui/default/images/listbtn2.gif" /></a></span> <span><a href="/ProductList.do?displayType=2&amp;pageSize=10&amp;Cid=51302&amp;Keywords=&amp;ppath=ZiwscHVzaHR5cGUwLCwvLCwxLCw7O2MsLGNpZCws56yU6K6w5pysLCw1MTMwMiws"><img src="${basepath}/ui/default/images/listbtn1a.gif" /></a></span>
				-->
			</div>
            <div class="plmiddle">|</div>
            <div class="position"><code>排序：</code>
			<a class="positionbtn1" id="hotsale" name="hotsale" href="#">热销</a>
              <div style="float:left"> <a class="positionbtn1" href="#">价格</a>
                <div style="display: none; z-index: 100;" id="listPriceSort" class="position2">
                  <!--<div><a href="/ProductList.do?OrderBy=price0-string&amp;IsAsc=false&amp;displayType=1&amp;Keywords=&amp;ppath=ZiwscHVzaHR5cGUwLCwvLCwxLCw7O2MsLGNpZCws56yU6K6w5pysLCw1MTMwMiws&amp;Cid=51302">低-高</a></div>
                  <div><a href="/ProductList.do?OrderBy=price0-string&amp;IsAsc=true&amp;displayType=1&amp;Keywords=&amp;ppath=ZiwscHVzaHR5cGUwLCwvLCwxLCw7O2MsLGNpZCws56yU6K6w5pysLCw1MTMwMiws&amp;Cid=51302">高-低</a></div>
					-->
				</div>
              </div>
              <a class="positionbtn21" href="#">上架时间</a> </div>
          </div>
        </h1>

        <form style="margin:0px;" id="plist" name="plist">
          <ul>
			<#if (goods.getList()??)&&(goods.getList()?size>0)>
			<#list goods.getList() as g>
            <li>
              <div class="pd1">
                <div style="position:relative;">
				<a target="_blank" href="${basepath}/<@g.htmlPath?interpret />">
				<#list g.pictureurl?split(",") as img>
				<#if img_index=0>
				<img border="0" alt="${g.goodsname}" style="width:120px;height:120px;" src="${basepath}${img}" id="imgbox_${g.goodsid}" />
				</#if>
				</#list>
				</a>
                  <!--促销-->
                  <div class="iconQg">
				  <#if g.recommended="1">
				  <img border="0" src="${basepath}/ui/default/images/promotion_6.png" />
				  <#elseif g.hotsale="1">
				  <img border="0" src="${basepath}/ui/default/images/promotion_6.png" />
				  <#elseif g.bargainprice="1">
				  <img border="0" src="${basepath}/ui/default/images/promotion_6.png" />
				  <#elseif g.isNew="1">
				  <img border="0" src="${basepath}/ui/default/images/promotion_6.png" />
				  <#else>
				  <img border="0" src="${basepath}/ui/default/images/promotion_6.png" />
				  </#if>
				  </div>
                  <!--促销-->
                </div>
              </div>
              <div class="pd2"> <a title="${g.goodsname}" target="_blank" href="${basepath}/<@g.htmlPath?interpret />"> ${g.goodsname}</a> </div>
              <div class="pd4"> 会员价：<span>￥${g.memberprice}</span> </div>
              <div class="pd5"> 
			  <a onclick="addtocart(${g.goodsid})" id="addtocart${g.goodsid}" name="addtocart${g.goodsid}" class="list_buy" href="javascript:;">购买</a>
			  
			  <a onclick="addtofav('${g.goodsid}','${g.goodsname}','${g.readcount}','${g.memberprice}')"  id="addtofav${g.goodsid}" name="addtofav${g.goodsid}" class="list_fav" href="javascript:;">收藏</a>
			  
                <input type="checkbox" style="display:none;" value="${g.goodsid}" name="compare" id="compare${g.goodsid}" />
              </div>
            </li>
			</#list>
			<#else>
				<div id="errorinfo">
				对不起，未找到合适的商品信息
				</div>
            </#if>
			
          </ul>
        </form>
        <div class="clear"></div>
        <div class="listbottom">
          	<!-- 读取分页控件 -->
				
				 <#include "/WEB-INF/theme/default/shop/splitpage.ftl">
				
        </div>
      </div>
    </div>
  </div>
</div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">
	<script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
</body>
</html>
