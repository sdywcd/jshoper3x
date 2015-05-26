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
            <aside class="right-side">                
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        页面错误
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">
                 
                    <div class="error-page">
                        <h2 class="headline">500</h2>
                        <div class="error-content">
                            <h3><i class="fa fa-warning text-yellow"></i> 对不起页面没找到</h3>
                            <p>
                               我们将马上去找页面
                               
                            </p>
                        </div>
                    </div><!-- /.error-page -->

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->

    <#include "/WEB-INF/theme/default/xms/footer.ftl">
    </body>
</html>