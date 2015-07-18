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
        <div class="container_12">
            <!--载入用户中心左侧导航-->
            <#include "/WEB-INF/theme/default/shop/membercentermenu.ftl">
            <div id="content" class="grid_10">
                <div class="grid_10">
                    <div class="cart_check">
                        <h1 class="page_title">我的收藏</h1>
                        <!--载入上部分页-->
                        <#include "/WEB-INF/theme/default/shop/ordersplitpage.ftl">
                        <table class="cart_product">
                            <tr>
                                <th class="bg name">标题</th>
                                <th class="bg price">收藏时间</th>
                                <th class="bg subtotal">操作</th>
                            </tr>
                            <#if (favorite??)&&(favorite?size>0)>
                            <#list favorite as f>
                            <tr>
                                <td class="bg name">
                                <a target="_blank" href="${basepath}/<@f.htmlpath?interpret />">${f.title}</a>
                                </td>
                                <td class="bg price">
                                    ${f.addtime}
                                </td>
                                <td class="bg subtotal">
                                    <a href="${basepath}/delMyFavorite.action?favoriteid=${f.favoriteid}">删除</a><br/>
                                </td>
                            </tr>
                            </#list>
                            </#if>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
        <#include "/WEB-INF/theme/default/shop/footer.ftl">
    </body>
</html>