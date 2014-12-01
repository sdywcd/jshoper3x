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
            <#if memberinfo?exists>
            <div class="grid_5">
                <div class="add_comments">
                    <h1 class="page_title">个人信息</h1>
                    <div>
                        <strong>用户名：</strong><sup class="surely">*</sup><br/>
                        <input type="text" id="loginname" name="loginname" class="" value="${memberinfo.loginname}" disabled="true" />
                    </div>
                    <br>
                    <div>
                        <strong>密码：</strong><sup class="surely">*</sup><br/>
                        <input type="password" id="loginpwd" name="loginpwd" class="" value="******" disabled="true" />
                    </div>
                    <br>
                    <div>
                        <strong>昵称：</strong><sup class="surely">*</sup><br/>
                        <input type="text" id="nick" name="nick" class="" value="${memberinfo.nick}" />
                        <span></span>
                    </div>
                    <br>
                    <div>
                        <strong>姓名<strong><sup class="surely">*</sup><br/>
                        <input type="text" id="realname" name="realname" value="${memberinfo.realname}" /><span></span>
                    </div>
                    <br>
                    <div>
                        <strong>性别：</strong><sup class="surely">*</sup><br/>
                        <#if memberinfo.sex=="1">
                        <input type="radio" id="sex" name="sex" value="1" checked>男
                        <input type="radio" id="sex" name="sex" value="0">女
                        <input type="radio" id="sex" name="sex" value="2">保密
                        <#elseif memberinfo.sex=="0">
                        <input type="radio" id="sex" name="sex" value="1" >男
                        <input type="radio" id="sex" name="sex" value="0" checked>女
                        <input type="radio" id="sex" name="sex" value="2">保密
                        <#else>
                        <input type="radio" id="sex" name="sex" value="1" >男
                        <input type="radio" id="sex" name="sex" value="0" >女
                        <input type="radio" id="sex" name="sex" value="2" checked>保密
                        </#if>
                    </div>
                    <br>
                    <div>
                        <strong>所在城市：</strong><sup class="surely">*</sup><br/>
                        <input type="text" id="city" name="city" class="" value="${memberinfo.city}" /><span></span>
                    </div>
                    <br>
                    <div>
                        <strong>所在区县：</strong><sup class="surely">*</sup><br/>
                        <input type="text" id="district" name="district" class="" value="${memberinfo.district}" /><span></span>
                    </div>
                    <br>
                    <div>
                        <strong>性取向：</strong><sup class="surely">*</sup><br/>
                        <#if memberinfo.whichsex=="0">
                        <input type="radio" id="whichsex" name="whichsex" value="0" checked>异性恋
                        <input type="radio" id="whichsex" name="whichsex" value="1">同性恋
                        <input type="radio" id="whichsex" name="whichsex" value="2">双性恋
                        <#elseif memberinfo.whichsex=="1">
                        <input type="radio" id="whichsex" name="whichsex" value="0" >异性恋
                        <input type="radio" id="whichsex" name="whichsex" value="1" checked>同性恋
                        <input type="radio" id="whichsex" name="whichsex" value="2">双性恋
                        <#else>
                        <input type="radio" id="whichsex" name="whichsex" value="0" >异性恋
                        <input type="radio" id="whichsex" name="whichsex" value="1" >同性恋
                        <input type="radio" id="whichsex" name="whichsex" value="2" checked>双性恋
                        </#if>
                    </div>
                    <br>
                    <div>
                        <strong>婚姻状况：</strong><sup class="surely">*</sup><br/>
                        <#if memberinfo.merrystatus=="0">
                        <input type="radio" id="merrystatus" name="merrystatus" value="0" checked>已婚
                        <input type="radio" id="merrystatus" name="merrystatus" value="1" >未婚
                        <#else>
                        <input type="radio" id="merrystatus" name="merrystatus" value="0" >已婚
                        <input type="radio" id="merrystatus" name="merrystatus" value="1" checked>未婚
                        </#if>
                    </div>
                    <br>
                    <div>
                        <strong>生日(1990/1/1)：</strong><sup class="surely">*</sup><br/>
                        <input type="text" id="birthday" name="birthday" class="" value="${memberinfo.birthday}" /><span></span>
                    </div>
                    <br>
                    <div>
                        <strong>血型：</strong><sup class="surely">*</sup><br/>
                        <#if memberinfo.blood=="a">
                        <input type="radio" id="blood" name="blood" value="a" checked="true">A型
                        <input type="radio" id="blood" name="blood" value="b">B型
                        <input type="radio" id="blood" name="blood" value="o">O型
                        <input type="radio" id="blood" name="blood" value="ab">AB型
                        <input type="radio" id="blood" name="blood" value="x">其他稀有血型
                        <#elseif memberinfo.blood=="b">
                        <input type="radio" id="blood" name="blood" value="a" >A型
                        <input type="radio" id="blood" name="blood" value="b" checked="true">B型
                        <input type="radio" id="blood" name="blood" value="o">O型
                        <input type="radio" id="blood" name="blood" value="ab">AB型
                        <input type="radio" id="blood" name="blood" value="x">其他稀有血型
                        <#elseif memberinfo.blood=="o">
                        <input type="radio" id="blood" name="blood" value="a" >A型
                        <input type="radio" id="blood" name="blood" value="b" >B型
                        <input type="radio" id="blood" name="blood" value="o" checked="true">O型
                        <input type="radio" id="blood" name="blood" value="ab">AB型
                        <input type="radio" id="blood" name="blood" value="x">其他稀有血型
                        <#elseif memberinfo.blood=="ab">
                        <input type="radio" id="blood" name="blood" value="a" >A型
                        <input type="radio" id="blood" name="blood" value="b" >B型
                        <input type="radio" id="blood" name="blood" value="o" >O型
                        <input type="radio" id="blood" name="blood" value="ab" checked="true">AB型
                        <input type="radio" id="blood" name="blood" value="x">其他稀有血型
                        <#else>
                        <input type="radio" id="blood" name="blood" value="a" >A型
                        <input type="radio" id="blood" name="blood" value="b" >B型
                        <input type="radio" id="blood" name="blood" value="o" >O型
                        <input type="radio" id="blood" name="blood" value="ab" >AB型
                        <input type="radio" id="blood" name="blood" value="x" checked="true">其他稀有血型
                        </#if>
                    </div>
                    <br>
                    <div>
                        <strong>星座：</strong><sup class="surely">*</sup><br/>
                        <input type="text" id="constellation" name="constellation" class="" value="${memberinfo.constellation}" />
                    </div>
                    <br>
                </div>
            </div>
            <div class="grid_5">
                <div class="add_comments">
                    <div style="padding:20px;">
                        <div>
                            <strong>自我介绍：</strong><sup class="surely">*</sup><br/>
                            <textarea id="des" name="des" cols="50" rows="12">${memberinfo.des}</textarea>
                        </div>
                        <br>
                        <div>
                            <strong>手机：</strong><sup class="surely">*</sup><br/>
                            <input type="text" id="mobile" name="mobile" class="" value="${memberinfo.mobile}" /><span></span>
                        </div>
                        <br>
                        <div>
                            <strong>固定电话：</strong><sup class="surely">*</sup><br/>
                            <input type="text" id="telno" name="telno" class="" value="${memberinfo.telno}" />
                        </div>
                        <br>
                        <div>
                            <strong>邮箱：</strong><sup class="surely">*</sup><br/>
                            <input type="text" id="email" name="email" class="" value="${memberinfo.email}" /><span></span>
                        </div>
                        <br>
                        <div>
                            <strong>QQ：</strong><sup class="surely">*</sup><br/>
                            <input type="text" id="qq" name="qq" class="" value="${memberinfo.qq}" /><span></span>
                        </div>
                        <br>
                        <div>
                            <strong>微信：</strong><sup class="surely">*</sup><br/>
                            <input type="text" id="weixin" name="weixin" class="" value="${memberinfo.weixin}" />
                        </div>
                        <br>
                        <div>
                            <strong>sina微博：</strong><sup class="surely">*</sup><br/>
                            <input type="text" id="sinaweibo" name="sinaweibo" class="" value="${memberinfo.sinaweibo}" />
                        </div>
                        <br>
                        <div class="clear"></div>
                        <input type="submit" id="doupdatememberinfo" name="doupdatememberinfo" value="更新" />
                    </div>
                </div>
            </div>
            </#if>
        </div>
        <div class="clear"></div>
        <#include "/WEB-INF/theme/default/shop/footer.ftl">
        <!--用于重新登录后的跳转链接-->
        <input type="hidden" id="hidurl" name="hidurl" value=""/>
        <script type="text/javascript" src="${basepath}/ui/default/js/location.js"></script>
        <script type="text/javascript" src="${basepath}/ui/default/js/YLChinaArea.js"></script>
    </body>
</html>