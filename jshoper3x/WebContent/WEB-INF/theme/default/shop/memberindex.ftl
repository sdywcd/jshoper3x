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
                <div class="m1top"><span>会员信息</span></div>
                <#if Session??&&Session["member"]?exists>
                <div class="m1">
                    <div class="r">
                        <ul>
                            <li>
                                您好！<span class="name">${member.loginname}</span>&nbsp;&nbsp;欢迎您回来！
                            </li>
                            <li>您现在拥有的积分为：【<b><span class="huiind_s2">${member.integration}</span></b>】</li>
                            <li>
                            你的会员等级为：【<b><span class="huiind_s2"> 注册会员</span></b>】 </li>
                            </#if>
                        </ul>
                    </div>
                </div>
                <div class="grid_10">
                    <div class="cart_check">
                        <h1 class="page_title">我的最新订单</h1>
                         <!--载入上部分页-->
        <#include "/WEB-INF/theme/default/shop/ordersplitpage.ftl">
                        <table class="cart_product">
                            <tr>
                                <th class="bg subtotal">订单号</th>
                                <th class="bg name"></th>
                                <th class="bg name">名称</th>
                                <th class="bg price">下单时间</th>
                                <th class="bg price">数量</th>
                                <th class="bg price">订单金额</th>
                                <th class="bg subtotal">订单状态</th>
                                <th class="bg subtotal">操作</th>
                            </tr>
                            <#if (userorderon??)&&(userorderon?size>0)>
                            <#list userorderon as uo>
                            <tr>
                                <td class="bg subtotal">
                                    ${uo.orderid}
                                </td>
                                <td class="bg name">
                                    
                                </td>
                                <td class="bg name">
                                    <a target='_blank' href="InitMyOrdersDetail.action?orderid=${uo.orderid}">${uo.ordername}</a>
                                </td>
                                <td class="bg price">${uo.purchasetime}</td>
                                <td class="bg price">${uo.needquantity}</td>
                                <td class="bg price">${uo.shouldpay}</td>
                                <td class="bg subtotal">
                                    <#if (uo.paystate=='1')>
                                    <span>您已付款</span><br/>
                                    </#if>
                                    <#if (uo.shippingstate=='1')>
                                    <span>商家已发货</span><br>
                                    </#if>
                                    <#if (uo.shippingstate=='0')>
                                    <span>配货中</span><br>
                                    <#else>
                                    <span>您未付款</span><br>
                                    </#if>
                                <br/></td>
                                <td class="bg subtotal">
                                    <#if (uo.orderstate=='0')>
                                    <span>等待商家确认</span><br/>
                                    <#elseif (uo.orderstate=='1')>
                                    <span>已确认配货中</span><br/>
                                    <#elseif (uo.orderstate=='4')>
                                    <span>退货</span><br/>
                                    <#elseif (uo.orderstate=='5')>
                                    <span>关闭</span><br/>
                                    <#elseif (uo.orderstate=='7')>
                                    <span>缺货</span><br/>
                                    <#elseif (uo.orderstate=='9')>
                                    <span>成功</span><br/>
                                    <#elseif (uo.orderstate=='3')>
                                    <a href="http://www.alipay.com" target="_blank"><font color="red">确认收货</font></a>
                                    <br/>
                                    </#if>
                                    <#if (uo.paystate=='0')>
                                    <!--InitPayPage.action InitMyOrdersDetail-->
                                    <a href="InitPayPage.action?redirecturl=findAllUserOrderOn.action&orderid=${uo.orderid}"><font color="red">付款</font></a><br/>
                                    <a href="InitMyOrdersDetail.action?orderid=${uo.orderid}" target="_blank">订单详细</a><br/>
                                    <a href="${uo.logisticswebaddress}" target="_blank">追踪物流</a><br/>
                                    </#if>
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