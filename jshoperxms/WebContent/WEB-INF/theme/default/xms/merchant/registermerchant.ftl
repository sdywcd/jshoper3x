<!DOCTYPE HTML>
<html>
    <head>
    </head>
    <!--载入公共头文件-->
     <#include "/WEB-INF/theme/default/xms/header.ftl">
     <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="${basepath}/index.action" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
               Yooxi Moving Service
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <#include "/WEB-INF/theme/default/xms/topnavigation.ftl">
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <#include "/WEB-INF/theme/default/xms/leftnavigation.ftl">


            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        注册服务商
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="box box-warning">
                                <div class="box-header">
                                    <h3 class="box-title">填写注册信息</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                     <form action="${basepath}/merchant/saveMerchantApply.action" method="post" class="form">
                                        <!-- text input -->
                                        <div class="form-group">
                                            <label>店名</label>
                                            <input id="jshopname" name="jshopname" type="text" class="form-control" placeholder="请输入您的实体店铺名称" maxlength="45"/>
                                        </div>
                                        <!-- textarea -->
                                        <div class="form-group">
                                            <label>地址</label>
                                            <input id="street" name="street" type="text" class="form-control" placeholder="请输入您的实体店铺地址" maxlength="45"/>
                                        </div>
                                        <div class="form-group">
                                            <label>电话</label>
                                            <input id="phoneservice" name="phoneservice" type="text" class="form-control" placeholder="请输入您的实体店铺电话" maxlength="45"/>
                                        </div>
                                        <div class="form-group">
                                            <label>微信订阅号或者服务号</label>
                                            <input id="weixinservice" name="weixinservice" type="text" class="form-control" placeholder="如您有微信服务号或者订阅号，请在此输入" maxlength="45"/>
                                        </div>
                                        <div class="box-footer">
                                            <button type="submit" class="btn btn-primary">提交</button>
                                        </div>
                                        </div>
                                    </form>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->

                        </div>
                    </div>
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->

    <#include "/WEB-INF/theme/default/xms/footer.ftl">
    </body>
</html>