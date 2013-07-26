/* 彦磊基于jQuery省市县联动插件(2009.04)
 * 在IE6/IE7/Mozilla 5.0（Firefox 3.0.5）中测试通过
 * 
 * 
 * 此插件要求运行在jQuery v1.3 或更高版本上
 * 插件改编自RayChou（http://www.raychou.com）的“全国省市区三级联动下拉菜单”插件。
 * 插件使用简单，不需要复杂设置，可设置初始选中的省市区，同时通过简单的步骤可以让ASP.NET获取到您选择的省市县数据。
 * 更多JQUERY插件请访问彦磊的百度博客：HTTP://HI.BAIDU.COM/DPXDQX,
 * 此为自由拷贝版本，您可以在此基础上添加任何功能
 * 彦磊建议您将修改过的版本或发布地址发到彦磊博客上以共享，也建议您保留部分彦磊的信息
 * 
 * 
 * 使用前您一定要引入jQurey及压缩包中的两个脚本文件,如
 *  <script type="text/javascript" src="js/jquery_last.js"></script>
 *  <script type="text/javascript" src="js/location.js"></script>
 *  <script type="text/javascript" src="js/YlChinaArea.js"></script>
 * 使用方法：
 * 
 * 1、为您要设置省市县联动下拉框设置容器，如"ChinaArea"
 * 2、在容器中添加三个select元素，请不要再添加其它任何元素，同时按省、市、县区的顺序安排三个选择框。
 *  <div class="ChinaArea">
 *     <select id="province" name="province" style="width: 100px;"></select>
 *     <select id="city" name="city" style="width: 100px;"></select>
 *     <select id="county"  name="county" style="width: 120px;"> </select>         
 *  </div>
 * 在ASP.NET中，您需要多添加三个服务器控件：隐藏字段，您选择的省市县数据将在客户端由程序分别写入三个隐藏字段中
 * 请您注意三个隐藏字段按顺序分别存储省、市、县区的数据，顺序不能随意调整，同时您不要在容器中添加其它元素，特别是select和input元素。
 * <div class="ChinaArea">
 *      <select id="province" style="width: 100px;"></select>
 *      <select id="city" style="width: 100px;"></select>
 *      <select id="county" style="width: 120px;"> </select> 
 *      <asp:HiddenField runat="server" ID="Tprovince" />
 *      <asp:HiddenField runat="server" ID="TCity" />
 *      <asp:HiddenField runat="server" ID="TCounty" /> 
 * </div>
 * 在asp.net的代码页中您可以通过获取三个隐藏字段的value值来获取您选择的省市县。
 * 3、在页面中添加jQuery语句，调用此插件，并对相关参数进行设置,如：
 * <script type="text/javascript">
 *   $(document).ready(function() {
 *       $("#ChinaArea").jChinaArea();
 *   });
 * </script>
 * 4、在ASP.NET中，您需要通过下面语句来调用,即设置参数aspnet的值为true.
 * <script type="text/javascript">
 *   $(document).ready(function() {
 *       $("#ChinaArea").jChinaArea({aspnet:true});
 *   });
 * 5、初始化时您可以定义选择哪些省市县，如
 * <script type="text/javascript">    
 *       $(document).ready(function() {
 *	        $("#ChinaArea").jChinaArea({
 *	            aspnet:true,
 *	            s1:"河南省",//默认选中的省名
 *	            s2:"安阳市",//默认选中的市名
 *	            s3:"文峰区"//默认选中的县区名
 *	        });
 *       });
 *   </script>
 * 具体参数：
 *    aspnet-true或false.默认为false。即是否在ASP.NET中使用，
 *           如果在asp.net中使用，则设为true,并按照第2步中所说方法添加三个隐藏字段，程序会把选择的内容分别写入三个控件中
 *           从而使asp.net可以获取您选择的省、市、县区内容。
 *    s1-默认选中的省名称，在程序中您可以用这个值来初始省份的选中项，如s1:<%=rs("Province")%>
 *    s2-默认选中的市名称，用法同上。
 *    s3-默认选中的县区名称，用法同省。
 */
(function($) { 
    $.fn.jChinaArea = function(o) {
		o = $.extend({
			aspnet:false,
			s1:null,
			s2:null,
			s3:null
    }, o || {});
        var wrap=$(this);
		var sel=$("select",wrap);
		var sProvince=sel.eq(0);
		var sCity=sel.eq(1);
		var sCounty=sel.eq(2);
		var loc	= new Location();

		sProvince.empty();
		sCity.empty();
		sCounty.empty();
		loc.fillOption(sProvince , '0',o.s1);
		loc.fillOption(sCity , '0,'+sProvince.val(),o.s2);
		loc.fillOption(sCounty , '0,' + sProvince.val() + ',' + sCity.val(),o.s3);
		
		if(o.aspnet){
			var input=$("input",wrap);
			var tProvince=input.eq(0);
			var tCity=input.eq(1);
			var tCounty=input.eq(2);
			writeInput();
		}
		
		sProvince.change(function() {
		sCity.empty();
		loc.fillOption(sCity , '0,'+sProvince.val());
		sCounty.empty();
		loc.fillOption(sCounty , '0,' + sProvince.val() + ',' + sCity.val());
		if(o.aspnet){
			writeInput();
		}
	})
	
	sCity.change(function() {
		sCounty.empty();
		loc.fillOption(sCounty , '0,' + sProvince.val() + ',' + sCity.val());
		if(o.aspnet){
			writeInput();
		}
	})
	sCounty.change(function(){
		if(o.aspnet){
			writeInput();
		}
	})
	
	function writeInput(){
			tProvince.val($(":selected",sProvince).text());
			tCity.val($(":selected",sCity).text());
			tCounty.val($(":selected",sCounty).text());
	}
	};
		
})(jQuery);
