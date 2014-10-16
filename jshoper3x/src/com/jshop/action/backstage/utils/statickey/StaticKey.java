package com.jshop.action.backstage.utils.statickey;


/**
 * 这个类是用来定义一些系统使用的字符串
 * @author chenda
 *
 */
public class  StaticKey {
	/**
	 * 逗号分隔符
	 */
	public static final String SPLITDOT=",";
	/**
	 * 所有商品属性
	 */
	public static final String ALLATTRS="all";
	/**
	 * 加密方式
	 */
	public static String ALGORITHMNAME="MD5";
	
	/**
	 * 前台用户登录创建的session名称
	 */
	public static String MEMBER_SESSION_KEY = "member";
	/**
	 * 后台用户登录创建的session用户名称
	 */
	public static String BACK_USER_SESSION_KEY = "admin";
	/**
	 * 店铺信息session名称
	 */
	public static String BASIC_SHOP_INFO="basicshopinfo";
	/**
	 * 后台用户登录创建的session_key
	 */
	public static String BACK_SESSION_KEY = "sessionKey";
	/**
	 * 用户的可操作的方法权限
	 */
	public static String USERROLEFUNCTION = "userrolefunction";
	/**
	 * 所有定义的权限
	 */
	public static String ALLROLEFUNCTION = "allrolefunction";

	public static String KEYFORAUTHORITY = "keyforauthority";
	/**
	 *权限异常标记
	 */
	public static String AUTHORITYEXCEPTION="authorityexception";
	/**
	 * 系统配置标记
	 */
	public static String GLOBALPARAMS="globalparams";
	
	/**
	 * 后台首页前5条订单记录
	 */
	public static String NEWESTORDERS="newestorders";
	
	/**
	 * 系统配置文件
	 * 
	 */
	public static String SYSTEM_CONFIG_FILE="admin/jshoperconfig.properties";
	
	/**
	 * 用户注册返回字符串
	 */
	public static final String MEMBER_EXIST="用户已经存在";
	
	public static final String MEMBER_REGISTER_SUCCESS="注册成功";
	
	//flexigrid default search tag
	public static final String EMPTY="";
	
	public static final String SC="sc";
	
	public static final String ZERO="0";
	
	public static final String ONE="1";
	
	public static final String TWO="2";
	
	public static final String THREE="3";
	
//	public static final String USEING="启用";
//	
//	public static final String UNUSING="禁用";
	
//	public static final String SHOW="显示";
//	
//	public static final String HIDDEN="隐藏";
	
	public static final String SUPPORT="支持";
	
	public static final String UNSUPPORT="不支持";
	
//	public static final String FRONTUSE="前端可用";
//	
//	public static final String BACKUSE="后端可用";
	
	public static final String INTERNATIONAL="国际";
	
	public static final String INTERNAL="国内";
	
	public static final String WEIGHTMODEL="重量模式";
	//Instant to account transaction interface
	public static final String INSTANTINTERFACE="即时到帐交易接口";
	//Secured transaction interface
	public static final String SECUREDINTERFACE="担保交易接口";
	//Standard interface
	public static final String STANDARD="标准双接口";
	
	public static final String OPEN="开启";
	
	public static final String CLOSE="关闭";
	
	public static final String YES="是";
	
	public static final String NO="否";
	
	//商品属性的静态字段用于json比较取值
	public static final String GOODSATTRIBUTENAME="goodsattributename";
	
	public static final String ATTRIBUTETYPE="attributeType";
	
	public static final String ATTRIBUTELIST="attributelist";
	
	public static final String SORT="sort";
	
	public static final String GOODSATTRIBUTEID="goodsattributeid";
	
	public static final String SELECTITEM="筛选项";
	
	public static final String INPUTITEM="输入项";
	
	
	//产品规格的静态字段用于json比较取值
	public static final String SPECIFIKEY="specifikey";
	
	public static final String SPECIFIVALUE="specifivalue";
	
	public static final String SPECIFISORT="specifisort";
	
	public static final String WORTTYPE="颜色类型";
	
	public static final String IMGTYPE="图片类型";
	
	public static final String COLORTYPE="颜色类型";
	
	public static final String DEFAULTSPECIFNAME="默认规格";
	//商品分类静态字段
	public static final String TOPCA="顶级分类";
	
	public static final String TWOCA="二级分类";
	
	public static final String THREECA="三级分类";
	
	//商品属性静态字段
	public static final String ATTRVAL="attrval";
	//货物静态字段
	public static final String DEFAULT="默认";
	
	public static final String ONSALE="上架";
	
	public static final String OFFSALE="下架";

	
	//会员静态字段
	public static final String SEXMAN="男";
	
	public static final String SEXFEMAL="女";
	
	public static final String SEXWHICHMAN="同性";
	
	public static final String SEXWHICHFEMAL="异性";
	
	public static final String MERRYED="已婚";
	
	public static final String UNMERRY="未婚";
	
	public static final String BLOODA="A型";
	
	public static final String BLOODB="B型";
	
	public static final String BLOODAB="AB型";
	
	public static final String BLOODO="O型";
	
	public static final String DOACTIVE="激活";
	
	public static final String DONOTACTIVE="禁止";
	//个性化标签json标记
	public static final String TAG="tag";
	
	/**
	 * 订单部分
	 */
	
	//配送方式
	//分成快递，平邮，ems，和虚拟类购物方式
	public static final String EXPRESS="快递";
	
	public static final String POST="平邮";
	
	public static final String EMS="EMS";
	
	public static final String CARD="虚拟充值";
	
	//订单显示状态

	public static final String ORDERSTATE_ONE="已确认";

	public static final String ORDERSTATE_TWO="货到付款";
	
	public static final String ORDERSTATE_THREE="待确认收货";
	
	public static final String ORDERSTATE_FOUR="退货";
	
	public static final String ORDERSTATE_FIVE="关闭";
	
	public static final String ORDERSTATE_SIX="用户已收货";
	
	public static final String ORDERSTATE_SEVEN="缺货";
	
	public static final String ORDERSTATE_EIGHT="用户删除";

	public static final String ORDERSTATE_NINE="成功";
	
	
	//订单设置状态
	/**
	 * 订单状态0表示未确认
	 */
	public static final String ORDERSTATE_UNCONFIRMED_ZERO_NUM="0";
	/**
	 * 订单状态1表示已确认
	 */
	public static final String ORDERSTATE_ONE_NUM="1";
	/**
	 * 订单状态2表示货到付款
	 */
	public static final String ORDERSTATE_TWO_NUM="2";
	/**
	 * 订单状态3表示待确认收货
	 */
	public static final String ORDERSTATE_THREE_NUM="3";
	/**
	 * 订单状态4表示退货
	 */
	public static final String ORDERSTATE_FOUR_NUM="4";
	/**
	 * 订单状态5表示关闭
	 */
	public static final String ORDERSTATE_FIVE_NUM="5";
	/**
	 * 订单状态6表示用户已收获
	 */
	public static final String ORDERSTATE_SIX_NUM="6";
	/**
	 * 订单状态7表示缺货
	 */
	public static final String ORDERSTATE_SEVEN_NUM="7";
	/**
	 * 订单状态8表示用户删除
	 */
	public static final String ORDERSTATE_EIGHT_NUM="8";
	/**
	 * 订单状态8表示成功
	 */
	public static final String ORDERSTATE_NINE_NUM="9";
	//订单类型标记
	/**
	 * 订单标记1表示普通订单
	 */
	public static final String ORDERTAG_NORMAL="1";
	/**
	 * 订单标记2表示团购订单
	 */
	public static final String ORDERTAG_GROUPON="2";
	
	//支付状态标记
	/**
	 * 支付状态 0表示未付款
	 */
	public static final String PAYSTATE_NOT_PAID_ZERO_NUM="0";
	/**
	 * 支付状态 1等于已付款
	 */
	public static final String PAYSTATE_ONE_NUM="1";
	/**
	 * 支付状态 2=该支付由于订单被关闭而不需要支付
	 */
	public static final String PAYSTATE_TWO_NUM="2";
	
	//配送发货类型
	/**
	 * 配送发货状态 0表示配货中未发货
	 */
	public static final String SHIPPINGSTATE_NOT_DELIVER_ZERO_NUM="0";
	/**
	 * 配送发货状态 1表示已发货
	 */
	public static final String SHIPPINGSTATE_ONE_NUM="1";
	/**
	 * 配送发货状态 2表示由于订单被关闭就不需要发货
	 */
	public static final String SHIPPINGSTATE_TWO_NUM="2";
	
	//发货类型
	public static final String PAY_ON_DELIVERY="货到付款";
	
	
	//快递类型
	/**
	 * 发货类型 express表示快递
	 */
	public static final String DELIVERMODE_EXPRESS="EXPRESS";
	
	//快递单打印状态
	/**
	 * 快递单打印状态 0表示未打印
	 */
	public static final String EXPRESS_NOT_PRINT_ZERO_NUM="0";
	/**
	 * 快递单打印状态 1表示已打印
	 */
	public static final String EXPRESS_HAVE_PRINT_ONE_NUM="1";
	//发货单打印状态
	/**
	 * 发货单打印状态 0表示未打印
	 */
	public static final String INVOICE_NOT_PRINT_ZERO_NUM="0";
	
	/**
	 * 发货单打印状态 1表示已打印
	 */
	public static final String ISPRINTINVOICE_ONE_NUM="1";

	
	//发票开具状态
	/**
	 * 发票开具状态 0表示发票未开
	 */
	public static final String PINVOICE_NOT_PRINT_ZERO_NUM="0";
	/**
	 * 发票开具状态 1表示发票已开
	 */
	public static final String ISPRINTFPINVOICE_ONE_NUM="1";
	//订单错误标记状态
	/**
	 * 订单错误标记 0表示订单没有错误及问题
	 */
	public static final String ERRORORDERTAG_ZERO_NUM="0";
	/**
	 * 订单错误标记 1表示订单有错误及问题
	 */
	public static final String ERRORORDERTAG_ONE_NUM="1";
	
	
	//购物车部分静态字段
	/**
	 * 表示新加入购物车的货物 state=1
	 */
	public static final String CARTSTATE_NEWADDTOCART_NUM="1";
	/**
	 * 表示已经和订单关联的购物车 state=3
	 */
	public static final String CARTSTATE_RELBYORDER_NUM="3";
	
	
	/**
	 * 加入购物车的货物属于订单的那种标记 0=普通货物对应普通订单
	 */
	public static final String CART_ORDER_TAG_NORMALPRODUCT="0";
	/**
	 * 购物车中货物的加入来源 0表示后台增加
	 */
	public static final String CARTTAG_PRODUCTFROM="0";
	
	//发货地址表部分静态字段
	/**
	 * 表示发货地址是否有对应的订单 1表示有
	 */
	public static final String SHIPPINGSTATE_HAVEORDER="1";
	/**
	 * 表示发货地址是否有对应的订单 0表示没有
	 */
	public static final String SHIPPINGSTATE_NOORDER="0";
	
	/**
	 * 表示发货地址是否有对应的订单 2表示该地址有对应的订单并已经发过火处于可删除状态
	 */
	public static final String SHIPPINGSTATE_OLDORDER="2";
	/**
	 * 表示该发货地址是否有对应的收货地址信息，收货地址是会员自行维护的。0表示在会员的发货管理模块中没有对应的收货地址
	 */
	public static final String SHIPPINGADDRESS_DELIVERADDRESSID="0";
	/**
	 * 表示该发货地址是否已经发过货 0表示没有
	 */
	public static final String SHIPPINGISSEND_NOSEND="0";
	
	/**
	 * 表示该发货地址是否已经发过货 0表示已经发货
	 */
	public static final String SHIPPINGISSEND_HAVESEND="1";
	
	/**
	 * 该类表示支付方式的种类 PAYMENT_CODE_ALIPAY="zfb"//支付宝
	 */
	public static final String PAYMENT_CODE_ALIPAY="zfb";//支付宝
	/**
	 * 该类表示支付方式的种类 PAYMENT_CODE_TENPAY="cft";//财付通
	 */
	public static final String PAYMENT_CODE_TENPAY="cft";//财付通
	/**
	 * 支付接口类型 3表示双接口
	 */
	public static final String PAY_INTERFACE_CODE_TWOPAY="3";
			
	/**
	 * 货到付款的特殊标记
	 */
	public static final String PAY_ON_DELIVERY_TAG="-1";
	
	//会员信息静态字段
	/**
	 * 会员状态 0=未激活
	 */
	public static final String MEMBERSTATE_ZERO_NUM="0";
	/**
	 * 会员状态 1=激活
	 */
	public static final String MEMBERSTATE_ONE_NUM="1";
	
	
	//会员收货地址管理
	public static final String DELIVERADDRESSSTATE_ZERO_NUM="0";
	
	public static final String DELIVERADDRESSSTATE_ZERO="非默认";
	
	public static final String DELIVERADDRESSSTATE_ONE_NUM="1";
	
	public static final String DELIVERADDRESSSTATE_ONE="默认";
	
	//订单发票信息管理
	public static final String ORDERINVOICE_ONE_NUM="1";
	
	public static final String ORDERINVOICE_ONE="个人";
	
	public static final String ORDERINVOICE_TWO_NUM="2";
	
	public static final String ORDERINVOICE_TWO="公司";
	
	//商品评论管理
	public static final String COMMENT_STATE_ONE_NUM="1";
	
	public static final String COMMENT_REPLY_ONE_NUM="1";
	
	public static final String COMMENT_REPLY_TWO_NUM="2";
	
	public static final String COMMENT_REPLY_ONE="来自用户的评论";
	
	public static final String COMMENT_REPLY_TWO="来自官方的回复";
	public static final String COMMENT_DEFAULT_REPLYID="0";
	
	public static final String COMMENT_EMAILABLE_ONE_NUM="0";
	
	public static final String COMMENT_VIRTUALADD_ONE_NUM="1";
	
	public static final String COMMENT_VIRTULADD="虚拟";
	
	public static final String COMMENT_NOTVIRTULADD="非虚拟";
	
	//会员等级管理
	
	public static final String CREDITVALUE="信用值";
	
	public static final String EMPIRICALVALUE="经验值";
	
	//系统用户管理
	public static final String NORMALUSER="普通用户";
	
	public static final String MANAGERUSER="店铺管理员";
	
	public static final String SUPERMANAGER="超级管理员";
	
	public static final String USERSTATEACTIVE="激活";
	
	public static final String USERSTATEUNACTIVE="未激活";
	
	
	
	/**
	 * 订单创建类型标记
	 * @author sdywcd
	 *
	 */
	public enum ORDERCREATETAG{
		NORMAL("普通订单","1");
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private ORDERCREATETAG(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(DataGrade d:DataGrade.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 商品在购物车中的状态
	 * @author sdywcd
	 *
	 */
	public enum CARTGOODSSTATE{
		NEWADDTOCART_NUM("新加入购物车的商品","1");
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private CARTGOODSSTATE(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(DataGrade d:DataGrade.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	/**
	 * 数据分类等级 一级 二级 三级
	 * @author sdywcd
	 *
	 */
	public enum DataGrade{
		FIRST("一级","0"),SECOND("二级","1"),THIRD("三级","2");
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private DataGrade(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(DataGrade d:DataGrade.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 商品记录相关状态
	 * @author sdywcd
	 *
	 */
	public enum GoodsState{
		SALE("上架","1"),UNSALE("下架","0"),HOTSALE("hotsale","1"),RECOMMENDED("recommended","1"), ISMOBILEPLATFORM("ismobileplatform","1");
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private GoodsState(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(GoodsState d:GoodsState.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 用户数据状态
	 * @author sdywcd
	 *
	 */
	public enum UserState{
		DONOTACTIVE("未激活","0"),DOACTIVE("激活","1"),LOCKED("锁定","2");
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private UserState(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(UserState d:UserState.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 物流商数据状态
	 * @author sdywcd
	 *
	 */
	public enum LogisticsUsingState{
		FRONTUSE("前端可用","1"),UNUSING("禁用","0"),BACKUSE("后端可用","2");
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private LogisticsUsingState(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(LogisticsUsingState d:LogisticsUsingState.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	
	
	/**
	 * 数据使用状态
	 * @author sdywcd
	 *
	 */
	public enum DataUsingState{
		USING("启用","1"),UNUSING("禁用","0");
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private DataUsingState(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(DataUsingState d:DataUsingState.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 数据记录状态
	 * @author sdywcd
	 *
	 */
	public enum DataShowState{
		SHOW("显示","1"),HIDDEN("隐藏","0");
		private String name;
		private String state;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private DataShowState(String name,String state){
			this.name=name;
			this.state=state;
		}
		public static String getName(String tag){
			for(DataShowState d:DataShowState.values()){
				if(d.getState().equals(tag)){
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * jshop商城运行
	 * @author sdywcd
	 *
	 */
	public enum JshopOpenState{
		OPEN("运行","1"),CLOSE("关闭","0");
		private String name;
		private String openstate;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getOpenstate() {
			return openstate;
		}
		private JshopOpenState(String name,String openstate){
			this.name=name;
			this.openstate=openstate;
		}
		public void setOpenstate(String openstate) {
			this.openstate = openstate;
		}
		public static String getName(String openstate){
			for(JshopOpenState jshopOpenState:JshopOpenState.values()){
				if(jshopOpenState.getOpenstate().equals(openstate)){
					return jshopOpenState.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 网站导航显示状态 
	 * @author sdywcd
	 *
	 */
	public enum SiteNavigationState{
		SHOW("显示","1"),HIDDEN("隐藏","0");
		private String name;
		private String visible;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getVisible() {
			return visible;
		}
		public void setVisible(String visible) {
			this.visible = visible;
		}
		private SiteNavigationState(String name,String visible){
			this.name=name;
			this.visible=visible;
		}
		public static String getName(String visible){
			for(SiteNavigationState siteNavigationState:SiteNavigationState.values()){
				if(siteNavigationState.getVisible().equals(visible)){
					return siteNavigationState.getName();
				}
			}
			return "";
		}
	}
	
	
	
	
	
	
	
}
