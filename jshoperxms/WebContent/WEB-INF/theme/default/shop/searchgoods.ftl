<!DOCTYPE HTML>
<html>
<head>
    <title>${(jshopbasicinfo.jshopname)}</title>
    <meta name="Author" content="jshoper3x">
    <meta name="Copyright" content="jshoper3x">
    <meta http-equiv="expires" content="0">
    <#if (jshopbasicinfo.metaKeywords)! != "">
    <meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/>
</#if>
<#if (jshopbasicinfo.metaDes)! != "">
<meta name="description" content="${jshopbasicinfo.metaDes}"/>
</#if>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">
<div class="clear"></div>
<!--载入主导航文件-->
<#include "/WEB-INF/theme/default/shop/mainnavigation.ftl">
<div class="clear"></div>
<div class="container_12">
<div class="grid_12">
    <div class="breadcrumbs">
        <#if goodscategorypath?exists>
        <#list goodscategorypath as gp>
        <span class="current">
            <a href="${basepath}/<@gp.url?interpret/>">${gp.name}</a>
        </span>
        </#list>
        </#if>
    </div>
    <!-- .breadcrumbs -->
</div>
<!-- .grid_12 -->
</div>
<!-- .container_12 -->
<div class="clear"></div>
<section id="main">
<div class="container_12">
    <div id="sidebar" class="grid_3">
        <aside id="categories_nav">
            <nav class="left_menu">
                <ul>
                    <h3>返回二级类目</h3>
                    <#if secondgoodscategory?exists>
                    <#list secondgoodscategory as sct>
                    <li>
                        <a href="#">
                            ${sct.name}
                        </a>
                    </li>
                    </#list>
                    </#if>
                </ul>
            </nav>
        </aside>
        <aside id="shop_by">
         <#if (goodstypebrandt??)&&(goodstypebrandt?size>0)>
            <div class="left_filter">
               <!--  <h3>条件筛选</h3>
                <div class="currently_shopping">
                    <p>已选择条件：</p>
                    <ul>
                        <li>
                            <a title="close" class="close" href="#"></a>
                            价格区间:
                            <span>$0.00 - $999.99</span>
                        </li>
                        <li>
                            <a title="close" class="close" href="#"></a>
                            分类:
                            <span>Apple</span>
                        </li>
                    </ul>
                    <a class="clear_all" href="#">清除所有条件</a>
                    <div class="clear"></div>
                </div> -->
               
                <h4>品牌</h4>
                <form action="#" class="check_opt">
                    <p><a style="color:#777777"  class="curr" href="#">全部</a></p>
                    <#list goodstypebrandt as gtbt>
                    <p><a style="color:#777777" href="#?brandid=${gtbt.brandid}">${gtbt.brandname}</a> </p>
                    </#list>
                </form>
                </#if>

                <#if (goodsattrs??)&&(goodsattrs?size>0)>
                    <#list goodsattrs as ga>
                      <h4>${ga.goodsattributename}</h4>

                      <span><a style="color:#777777"  class="curr" href="#">全部</a></span>
                      <#list ga.attributelist?split(",") as attr>
                      <a style="color:#777777" href="#?attrs=${attr}">${attr}</a>
                      </#list>
                    </#list>
                </#if>

            </div>
        </aside>
        <#if (hotsalegoodslist??)&&(hotsalegoodslist?size>0)>
        <aside id="specials" class="specials">
            <div class="left_recommend">
                <h3>热销商品</h3>
                <ul>
                <#list hotsalegoodslist as g>
                    <li>
                        <div class="prev">
                        <#list g.pictureurl?split(",") as img>
                <#if img_index=0>
                            <a href="${basepath}/<@g.htmlPath?interpret />">
                                <img src="${basepath}${img}" alt="" title="${g.goodsname}" />
                            </a>
                            </#if>
                            </#list>
                        </div>
                        <div class="cont">
                            <a href="${basepath}/<@g.htmlPath?interpret />">${g.goodsname}</a>
                            <div class="prise">￥${g.memberprice}</div>
                        </div>
                    </li>
                </#list>
                </ul>
            </div>
        </aside>
        </#if>
    </div>
</div>
<div class="container_12">
    <div id="content" class="grid_9">
        <!--载入上部分页-->
        <#include "/WEB-INF/theme/default/shop/splitpage.ftl">
        <div class="grid_product">
        <#if goods?exists>
        <#list goods.getList() as g>
            <div class="grid_3 product">
                <img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale"/>
                <div class="title">
                    <span class="maintitle"> ${g.brandname}</span>
                    ${g.goodsname}
                    <span class="price">￥ ${g.memberprice}</span>
                </div>
                <#list g.pictureurl?split(",") as img>
                <#if img_index=0>
                <div class="prev">
                    <a href="${basepath}/<@g.htmlPath?interpret />">
                        <img src="${basepath}${img}" alt="" title="${g.goodsname}" />
                    </a>
                </div>
                </#if>
                </#list>
                <div class="product_nav">
                    <a class="p_li" href="#">加入购物车</a>
                </div>
                <div class="cart">
                    <a href="#" class="like">收藏</a>
                    |
                    <a href="#" class="obn">对比</a>
                </div>
                <!-- .cart --> </div>
                </#list>
                </#if>
            <div class="clear"></div>
        </div>
        <!-- .grid_product -->
        <div class="clear"></div>
        <div class="pagination">
            <div class="pagin fr">
                
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<!-- .container_12 -->
</section>
<!-- #main -->
<div class="clear"></div>
<#include "/WEB-INF/theme/default/shop/footer.ftl"></body>
</html>