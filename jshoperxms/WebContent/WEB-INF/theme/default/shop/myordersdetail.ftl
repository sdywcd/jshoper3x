<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>用户中心</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/global.css" />
        <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/css.css" />
        <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/huiyuan.css" />
        <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/tabs-accordion-usercenter.css"/>
        <link rel="stylesheet" type="text/css" href="${basepath}/ui/default/css/myorderdetail.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="text/javascript"  src="${basepath}/ui/default/js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="${basepath}/js/jquery.query.js"></script>
    </head>
    <body>
        <!--载入公共头文件-->
        <#include "/WEB-INF/theme/default/shop/header.ftl">
        <div class="clear"></div>
        <section id="main" class="entire_width">
            <div class="container_12">
                <#if myorder.myorderdetail??>
                <div class="grid_12">
                    <h1 class="page_title">订单状态</h1>
                    <div class="cart_check">
                        <div id="orders_infom1" class="consignee_info">
                            <div class="bd">
                                <div class="order_state">
                                    <strong>当前订单状态：<span>${myorder.myorderdetail.orderstate}</span></strong>
                                </div>
                                <div class="order_state">
                                    <strong>当前付款状态：<span id="nowpaystate">${myorder.myorderdetail.paystate}</span></strong>
                                </div>
                                <div class="order_state">
                                    <strong>当前发货状态：<span>${myorder.myorderdetail.shippingstate}</span></strong>
                                </div>
                                <div class="action">
                                    <input type="hidden" id="hidorderid" name="hidorderid" value="${myorder.myorderdetail.orderid}"/>
                                </div>
                                <div class="tbnotes">
                                    <span>温馨提醒</span>
                                    <p>1、交易已成功，如果你还未收到货物，或者收到的货物无法正常使用，请及时联系卖家协商处理。
                                </div>
                            </div>
                        </div>
                    </div>
                    <h1 class="page_title">订单详细</h1>
                    <div class="cart_check">
                        <h5>买家信息</h5>
                        <table class="cart_product">
                            <tr>
                                <th class="subtotal">用户名称</th>
                                <th class="price">真实姓名</th>
                                <th class="price">联系电话</th>
                                <th class="price">邮件</th>
                                <th class="price">支付方式</th>
                            </tr>
                            <tr>
                                <td class="subtotal">
                                    ${myorder.myorderbuyerinfo.loginname}
                                </td>
                                <td class="price">
                                    ${myorder.myorderbuyerinfo.realname}
                                </td>
                                <td class="price">
                                    <#if myorder.myorderbuyerinfo.mobile?exists>
                                    [${myorder.myorderbuyerinfo.mobile}]
                                    </#if>
                                    <#if myorder.myorderbuyerinfo.telno?exists>
                                    [${myorder.myorderbuyerinfo.telno}]
                                    </#if>
                                </td>
                                <td class="price">${myorder.myorderbuyerinfo.email}</td>
                                <td class="price">${myorder.myorderdetail.paymentname}</td>
                            </tr>
                        </table>
                        <h5>订单信息</h5>
                        <table class="cart_product">
                            <tr>
                                <th class="subtotal">订单编号</th>
                                <th class="price">订单来源</th>
                                <th class="price">下单时间</th>
                                <th class="price">订单状态</th>
                                <th class="price">发货单号</th>
                                <th class="price">发货时间</th>
                                <th class="price">发货状态</th>
                            </tr>
                            <tr>
                                <td class="subtotal">
                                    ${myorder.myorderdetail.orderid}
                                </td>
                                <td class="price">
                                    ${myorder.myorderdetail.orderTag}
                                </td>
                                <td class="price">
                                    ${myorder.myorderdetail.purchasetime}
                                </td>
                                <td class="price">
                                    ${myorder.myorderdetail.orderstate}
                                </td>
                                <td class="price"><#if myorder.myorderdetail.deliverynumber?exists>${myorder.myorderdetail.deliverynumber}</#if></td>
                                <td class="price"><#if myorder.myorderdetail.deliverytime?exists>${myorder.myorderdetail.deliverytime}</#if></td>
                                <td class="price">${myorder.myorderdetail.shippingstate}</td>
                            </tr>
                        </table>
                        <table class="cart_product">
                            <tr>
                                <th class="subtotal">商品编号</th>
                                <th class="bg name">商品名称</th>
                                <th class="price">货号</th>
                                <th class="price">价格</th>
                                <th class="price">赠送积分</th>
                                <th class="price">数量</th>
                                <th class="price">商品重量</th>
                                <th class="price">运费</th>
                            </tr>
                            <#if (myorder.myordergoods??)&&(myorder.myordergoods?size>0)>
                            <#list myorder.myordergoods as mog>
                            <tr>
                                <td class="subtotal">
                                    ${mog.goodsid}
                                </td>
                                <td class="bg name">
                                    <div class="pic">
                                        <!--这里以后修改成订单快照地址-->
                                        <a title="商品图片" target="_blank" href="${basepath}/html/default/shop/${mog.goodsid}.html">
                                        <img src="${mog.picture}" alt="${mog.goodsname}">
                                        </a>
                                    </div>
                                </td>
                                <td class="price">
                                    ${mog.usersetnum}
                                </td>
                                <td class="price">${mog.favorable}</td>
                                <td class="price">${mog.points}</td>
                                <td class="price">${mog.needquantity}</td>
                                <td class="price"> <#if mog.weight?exists>
                                    ${mog.weight}
                                </#if></td>
                                <td class="price">${myorder.myorderdetail.freight}</td>
                            </tr>
                            </#list>
                            </#if>
                        </table>
                        <h5>总价：<span>${myorder.myorderdetail.shouldpay}</span></h5>
                        <h5>物流信息</h5>
                        <table class="cart_product">
                            <tr>
                                <th class="bg name">发货地址</th>
                                <th class="bg name">运送方式</th>
                                <th class="bg name">买家留言</th>

                            </tr>

                            <tr>
                                <td class="bg name">
                                    ${myorder.myshipping.province},${myorder.myshipping.city},${myorder.myshipping.district},${myorder.myshipping.street},${myorder.myshipping.postcode},${myorder.myshipping.mobile},${myorder.myshipping.telno},
                                </td>
                                <td class="bg name">
                                    ${myorder.myorderdetail.delivermode}
                                </td>
                                <td class="bg name">
                                    <#if myorder.myorderdetail.toBuyerNotes?exists>
                                    ${myorder.myorderdetail.toBuyerNotes}
                                    </#if>
                                </td>

                            </tr>

                        </table>
                    </div>

                </div>
                </#if>
            </div>
        </section>
        <div class="clear"></div>
        <#include "/WEB-INF/theme/default/shop/footer.ftl">
        <script type="text/javascript" src="${basepath}/ui/default/js/jshop.js"></script>
    </body>
</html>