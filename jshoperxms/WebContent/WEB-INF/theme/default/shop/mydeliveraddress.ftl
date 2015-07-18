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
            <div class="grid_10">
                <div class="cart_check">
                    <h1 class="page_title">收货地址</h1>
                    <table class="cart_product">
                        <tr>
                            <th class="bg subtotal">收货人</th>
                            <th class="bg name">详细地址</th>
                            <th class="bg name">邮编</th>
                            <th class="bg price">固定电话</th>
                            <th class="bg price">手机</th>
                            <th class="bg price">操作</th>
                        </tr>
                        <#if (deliveraddress??)&&(deliveraddress?size>0)>
                        <#list deliveraddress as addr>
                        <tr>
                            <td class="bg subtotal">
                                ${addr.shippingusername}
                            </td>
                            <td class="bg name">
                                ${addr.province} ${addr.street} ${addr.district}${addr.street}
                            </td>
                            <td class="bg name">
                                ${addr.postcode}
                            </td>
                            <td class="bg price">${addr.telno}</td>
                            <td class="bg price">${addr.mobile}</td>
                            <td class="bg price"><a href="javascript:void();" onclick="finddeliveraddressbyid('${addr.addressid}');" class="thickbox myad_s1">修改</a>
                            <a href="javascript:void();" onclick="delmyaddress('${addr.addressid}');"  class="myad_s2">删除</a></td>
                        </tr>
                        </#list>
                        </#if>
                    </table>
                    <div id="addnewaddressarea">
                        <div id="newaddress">
                            <div>
                                <strong>收货人姓名:</strong><sup class="surely">*</sup><br/>
                                <input type="text" name="membername" id="membername" value="">
                            </div>
                            <div>
                                <strong>国家:</strong><sup class="surely">*</sup><br/>
                                <select id="country" name="country">
                                    <option value="1">中国</option>
                                </select>
                            </div>
                            <div id="ChinaArea">
                                <strong>省份:</strong><sup class="surely">*</sup><br/>
                            <select id="province" name="province" style="width: 100px;"></select>
                        <select id="city" name="city" style="width: 100px;"></select>
                    <select id="district" name="district" style="width: 120px;"> </select>
                </div>
                <div>
                    <strong>地址:</strong><sup class="surely">*</sup><br/>
                    <input type="text" class="input2" maxlength="40" name="street" id="street" value="" style="width: 400px;"/>
                </div>
                <div>
                    <strong>邮政编码:</strong><br/>
                    <input type="text" name="postcode"  id="postcode" value="">
                    <cite >有助于快速确定送货地址</cite>
                </div>
                <div>
                    <strong>手机号码:</strong><sup class="surely">*</sup><br/>
                    <input type="text"  name="mobile" id="mobile" maxlength="11" value="" />
                    <cite >用于接收发货通知短信及送货前确认</cite>
                </div>
                <div>
                    <strong>固定电话:</strong><br/>
                    <input type="text" name="telno" id="telno" maxlength="11" value="" />
                    <cite >有助于快速确定送货地址</cite>
                </div>
                <div>
                    <strong>电子邮件:</strong><sup class="surely">*</sup><br/>
                    <input type="text" name="email"  id="email" value="" />
                    <cite >方便您及时获取虚拟物品信息</cite>
                </div>
                 <div>
                 <!--隐藏的地址id-->
                   <input type="hidden" id="hidaddressid" name="hidaddressid" value="" />
                </div>
                <div>
                    <input style="display:none;" id="updatemyaddressinmc" name="updatemyaddressinmc" type="button" value="更新收货人信息"  />
                </div>
                <div>
                    <input id="savemyaddressinmc" name="savemyaddressinmc" type="button" value="保存收货人信息"  /><cite id="addressmsg"></cite>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<div class="clear"></div>
<#include "/WEB-INF/theme/default/shop/footer.ftl">
<!--用于重新登录后的跳转链接-->
<input type="hidden" id="hidurl" name="hidurl" value=""/>
<script type="text/javascript" src="${basepath}/ui/default/js/location.js"></script>
<script type="text/javascript" src="${basepath}/ui/default/js/YLChinaArea.js"></script>
</body>
</html>