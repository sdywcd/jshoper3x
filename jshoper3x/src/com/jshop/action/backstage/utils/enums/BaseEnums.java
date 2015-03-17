package com.jshop.action.backstage.utils.enums;

public class BaseEnums {
	/**
	 * 订单开票状态
	 * 
	 * @ClassName: OrderIsInvoice
	 * @Description: TODO(这里用一句话描述这个类的作用)
	 * @author jcchen
	 * @date 2015年2月17日 下午11:10:28
	 *
	 */
	public enum OrderIsInvoice {
		ORDERISINVOICE_DO_ONE_NUM("开票", "1"),
		ORDERISINVOICE_UNDO_ZERO_NUM("不开票","0");	
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

		private OrderIsInvoice(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String state) {
			for (OrderIsInvoice orderstate : OrderIsInvoice.values()) {
				if (orderstate.getState().equals(state)) {
					return orderstate.getName();
				}
			}
			return "";
		}
	}
	/**
	 * 订单配送方式
	 * 
	 * @ClassName: OrderDeliverMode
	 * @Description: TODO(这里用一句话描述这个类的作用)
	 * @author jcchen
	 * @date 2015年2月17日 下午11:10:28
	 *
	 */
	public enum OrderDeliverMode {
		ORDERDELIVERMODE_EXPRESS("快递", "EXPRESS"),
		ORDERDELIVERMODE_POST("平邮","POST"),
		ORDERDELIVERMODE_EMS("EMS","EMS");
		
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

		private OrderDeliverMode(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String state) {
			for (OrderDeliverMode orderstate : OrderDeliverMode.values()) {
				if (orderstate.getState().equals(state)) {
					return orderstate.getName();
				}
			}
			return "";
		}
	}

	
	/**
	 * 订单配送状态
	 * 
	 * @ClassName: OrderShippingState
	 * @Description: TODO(这里用一句话描述这个类的作用)
	 * @author jcchen
	 * @date 2015年2月17日 下午11:10:28
	 *
	 */
	public enum OrderShippingState {
		ORDERSHIPPINGSTATE_UNDELIVER_GOODS_ZERO_NUM("配货中(未发货)", "0"),
		ORDERSHIPPINGSTATE_HAVE_DELIVER_GOODS_ONE_NUM("已发货","1"),
		ORDERSHIPPINGSTATE_CLOSE_TWO_NUM("订单关闭","2");
		
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

		private OrderShippingState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String state) {
			for (OrderShippingState orderstate : OrderShippingState.values()) {
				if (orderstate.getState().equals(state)) {
					return orderstate.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 订单支付状态
	 * 
	 * @ClassName: OrderPayState
	 * @Description: TODO(这里用一句话描述这个类的作用)
	 * @author jcchen
	 * @date 2015年2月17日 下午11:10:28
	 *
	 */
	public enum OrderPayState {
		ORDERPAYSTATE_UNPAY_ZERO_NUM("未付款", "0"),
		ORDERPAYSTATE_HAVEPAY_ONE_NUM("已付款","1"),
		ORDERPAYSTATE_CLOSE_TWO_NUM("订单关闭","2");
		
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

		private OrderPayState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String state) {
			for (OrderPayState orderstate : OrderPayState.values()) {
				if (orderstate.getState().equals(state)) {
					return orderstate.getName();
				}
			}
			return "";
		}
	}

	
	/**
	 * 订单状态
	 * 
	 * @ClassName: OrderState
	 * @Description: TODO(这里用一句话描述这个类的作用)
	 * @author jcchen
	 * @date 2015年2月17日 下午11:10:28
	 *
	 */
	public enum OrderState {
		ORDERSTATE_UNCONFIRMED_ZERO_NUM("未确认", "0"),
		ORDERSTATE_CONFIRMED_ONE_NUM("已确认","1"),
		ORDERSTATE_PAYMENT_AFTER_ARRIVAL_OF_GOODS_TWO_NUM("货到付款","2"),
		ORDERSTATE_WAIT_CONFIRM_RECEIVE_THREE_NUM("待确认收货","3"),
		ORDERSTATE_RETURN_GOODS_FOUR_NUM("退货","4"),
		ORDERSTATE_CLOSE_FIVE_NUM("订单关闭","5"),
		ORDERSTATE_MEMBER_HAVE_REVEIVE_GOODS_SIX_NUM("用户已收货","6"),
		ORDERSTATE_OUT_OF_STACK_SEVEN_NUM("缺货","7"),
		ORDERSTATE_MEMBER_DELETE_EIGHT_NUM("用户删除","8"),
		ORDERSTATE_SUCCESS_NINE_NUM("成功","9");
		
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

		private OrderState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String state) {
			for (OrderState orderstate : OrderState.values()) {
				if (orderstate.getState().equals(state)) {
					return orderstate.getName();
				}
			}
			return "";
		}
	}

	
	/**
	 * 订单创建类型标记
	 * 
	 * @author sdywcd
	 *
	 */
	public enum ORDERCREATETAG {
		ORDERTAG_NORMAL_ONE_NUM("普通订单", "1"),
		ORDERTAG_GROUPON_TWO_NUM("团购订单","2"),
		ORDERTAG_AUCTION_THREE_NUM("拍卖订单","3"),
		ORDERTAG_MOBILE_FOUR_NUM("手机订单","4"),
		ORDERTAG_GROUP_GOODS_FIVE_NUM("组合商品订单","5");
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

		private ORDERCREATETAG(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (ORDERCREATETAG d : ORDERCREATETAG.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 商品在购物车中的状态
	 * 
	 * @author sdywcd
	 *
	 */
	public enum CARTGOODSSTATE {
		NEWADDTOCART_BACKSTAGE_ZERO_NUM("从后台加入购物车的商品","0"),NEWADDTOCART_NUM("新加入购物车的商品", "1");
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

		private CARTGOODSSTATE(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (CARTGOODSSTATE d : CARTGOODSSTATE.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 发货地址是否绑定了订单
	 * 
	 * @author sdywcd
	 *
	 */
	public enum ShippingIsOrderState {
		SHIPPING_BIND_ORDER("发货地址已经绑定订单","1"),SHIPPING_UNBIND_ORDER("发货地址未绑定订单", "0");
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

		private ShippingIsOrderState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (ShippingIsOrderState d : ShippingIsOrderState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	
	/**
	 * 发货地址是否和收获地址绑定
	 * 
	 * @author sdywcd
	 *
	 */
	public enum ShippingHaveDeliverAddress {
		SHIPPING_HAVE_DA_ONE_NUM("发货地址有对应收获地址","1"),SHIPPING_UNHAVE_DA_ZERO_NUM("发货地址没有对应收获地址", "0");
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

		private ShippingHaveDeliverAddress(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (ShippingHaveDeliverAddress d : ShippingHaveDeliverAddress.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 在发货地址中是否已经发货
	 * 
	 * @author sdywcd
	 *
	 */
	public enum ShippingIsSend {
		SHIPPING_HAVESEND("已发货","1"),SHIPPING_UNSEND("未发货", "0");
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

		private ShippingIsSend(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (ShippingIsSend d : ShippingIsSend.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	
	/**
	 * 快递单打印状态
	 * 
	 * @author sdywcd
	 *
	 */
	public enum PrintExpressState {
		EXPRESS_NOT_PRINT_ZERO_NUM("未打印", "0"), EXPRESS_HAVE_PRINT_ONE_NUM("已打印", "1");
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

		private PrintExpressState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (PrintExpressState d : PrintExpressState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	
	/**
	 * 数据分类等级 一级 二级 三级
	 * 
	 * @author sdywcd
	 *
	 */
	public enum CategoryGrade {
		FIRST("一级", "0"), SECOND("二级", "1"), THIRD("三级", "2");
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

		private CategoryGrade(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (CategoryGrade d : CategoryGrade.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 商品记录相关状态
	 * 
	 * @author sdywcd
	 *
	 */
	public enum GoodsState {
		SALE("上架", "1"), UNSALE("下架", "0"), HOTSALE("hotsale", "1"), RECOMMENDED(
				"recommended", "1"), ISMOBILEPLATFORM("ismobileplatform", "1");
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

		private GoodsState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (GoodsState d : GoodsState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 用户数据状态
	 * 
	 * @author sdywcd
	 *
	 */
	public enum UserState {
		ACTIVE("激活", "1"), UNACTIVE("未激活", "0"), LOCK("锁定", "2");
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

		private UserState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (UserState d : UserState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 物流商数据状态
	 * 
	 * @author sdywcd
	 *
	 */
	public enum LogisticsUsingState {
		FRONTUSE("前端可用", "1"), UNUSING("禁用", "0"), BACKUSE("后端可用", "2");
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

		private LogisticsUsingState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (LogisticsUsingState d : LogisticsUsingState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 数据使用状态
	 * 
	 * @author sdywcd
	 *
	 */
	public enum DataUsingState {
		USING("启用", "1"), UNUSING("禁用", "0");
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

		private DataUsingState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (DataUsingState d : DataUsingState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	
	/**
	 * 数据记录有效性状态
	 * 
	 * @author sdywcd
	 *
	 */
	public enum DataEffectiveState {
		EFFECTIVE("有效", "1"), DISEFFECTIVE("失效", "0");
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

		private DataEffectiveState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (DataEffectiveState d : DataEffectiveState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	
	
	/**
	 * 数据记录状态
	 * 
	 * @author sdywcd
	 *
	 */
	public enum DataShowState {
		SHOW("显示", "1"), HIDDEN("隐藏", "0");
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

		private DataShowState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (DataShowState d : DataShowState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * jshop商城运行
	 * 
	 * @author sdywcd
	 *
	 */
	public enum JshopOpenState {
		OPEN("运行", "1"), CLOSE("关闭", "0");
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

		private JshopOpenState(String name, String openstate) {
			this.name = name;
			this.openstate = openstate;
		}

		public void setOpenstate(String openstate) {
			this.openstate = openstate;
		}

		public static String getName(String openstate) {
			for (JshopOpenState jshopOpenState : JshopOpenState.values()) {
				if (jshopOpenState.getOpenstate().equals(openstate)) {
					return jshopOpenState.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 用户账号类型
	 * 
	 * @author sdywcd
	 *
	 */
	public enum UserType {
		NORMALMANAGER("普通用户", "1"), SHOPMANAGER("店铺管理员", "2"), SUPERMANAGER(
				"超级管理员", "3");

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

		private UserType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (UserType d : UserType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	/**
	 * 模版类型
	 * 
	 * @author sdywcd
	 *
	 */
	public enum TemplateType {
		PAGETEMPLATE("页面模版", "1"), MAILTEMPLATE("邮件模版", "2"), PRINTTEMPLATE(
				"打印模版", "3");

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

		private TemplateType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (TemplateType d : TemplateType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 支持类型
	* @ClassName: SupportType 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年2月22日 下午6:38:38 
	*
	 */
	public enum SupportType {
		SUPPORT("支持", "1"),UNSUPPORT("不支持","0");

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

		private SupportType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (SupportType d : SupportType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 支付方式类型
	* @ClassName: PayMentType 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年2月22日 下午11:25:19 
	*
	 */
	public enum PayMentType {
		INSTANTINTERFACE("即时到帐交易接口", "1"),SECUREDINTERFACE("担保交易接口","2"),STANDARD("标准双接口","3");

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

		private PayMentType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (PayMentType d : PayMentType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	

	/**
	 * 物流商配送范围
	* @ClassName: LogisticsSupportRange 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年2月23日 下午4:05:14 
	*
	 */
	public enum LogisticsSupportRange {
		INTERNATIONAL("国际", "1"),INTERNAL("国内","0");

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

		private LogisticsSupportRange(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (LogisticsSupportRange d : LogisticsSupportRange.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 物流商显示范围
	* @ClassName: LogisticsShowRange 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年2月23日 下午4:05:14 
	*
	 */
	public enum LogisticsShowRange {
		FRONTSTAGE("用户可见（前台可见）", "1"),BACKSTAGE("物流商可见（后台可见）","2");

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

		private LogisticsShowRange(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (LogisticsShowRange d : LogisticsShowRange.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 物流商显示范围
	* @ClassName: SiteNavPosition 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年2月23日 下午4:05:14 
	*
	 */
	public enum SiteNavPosition {
		PAGETOP("页面上部", "1"),PAGEMIDDLE("页面中部","2"),PAGEBOTTOM("页面下部","3");

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

		private SiteNavPosition(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (SiteNavPosition d : SiteNavPosition.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	/**
	 * 用户等级类型
	* @ClassName: MemberGradeType 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年3月6日 下午10:42:19 
	*
	 */
	public enum MemberGradeType {
		CREDITVALUE("信用值", "1"),EMPIRICALVALUE("经验值","2");

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

		private MemberGradeType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (MemberGradeType d : MemberGradeType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	

	/**
	 * 开票类型类型
	* @ClassName: InvType 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年3月6日 下午10:42:19 
	*
	 */
	public enum InvType {
		PERSONAL("个人", "1"),COMPANY("公司","2");

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

		private InvType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (InvType d : InvType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	
	/**
	 * 开票否
	* @ClassName: InvState 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年3月6日 下午10:42:19 
	*
	 */
	public enum InvState {
		DO("开", "1"),UNDO("未开","0");

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

		private InvState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (InvState d : InvState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	
	/**
	 * 是否打印了发货单
	* @ClassName: PrintInvoiceState 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年3月6日 下午10:42:19 
	*
	 */
	public enum PrintInvoiceState{
		INVOICE_NOT_PRINT_ZERO_NUM("未打印", "0"),INVOICE_HAVE_PRINT_ZERO_NUM("已打印","1");

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

		private PrintInvoiceState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (PrintInvoiceState d : PrintInvoiceState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	

	/**
	 * 是否打印发票
	* @ClassName: PrintInvoiceState 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年3月6日 下午10:42:19 
	*
	 */
	public enum PrintFaPiaoInvoiceState{
		FAPIAOINVOICE_NOT_PRINT_ZERO_NUM("未打印", "0"),FAPIAOINVOICE_HAVE_PRINT_ZERO_NUM("已打印","1");

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

		private PrintFaPiaoInvoiceState(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (PrintFaPiaoInvoiceState d : PrintFaPiaoInvoiceState.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	
	
	/**
	 * 商品类型
	* @ClassName: GoodsType 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年3月6日 下午10:42:19 
	*
	 */
	public enum GoodsType{
		VIRTUALGOODS("虚拟商品", "0"),NORMALGOODS("普通商品","1");

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

		private GoodsType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (GoodsType d : GoodsType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
	/**
	 * 商品评论类型
	* @ClassName: GoodsCommentType 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年3月6日 下午10:42:19 
	*
	 */
	public enum GoodsCommentType{
		VIRTULADD("虚拟评论", "1"),NOTVIRTULADD("会员评论","2");

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

		private GoodsCommentType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (GoodsCommentType d : GoodsCommentType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}

	
	/**
	 * 商品评论回复类型
	* @ClassName: GoodsCommentReplyType 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author jcchen
	* @date 2015年3月6日 下午10:42:19 
	*
	 */
	public enum GoodsCommentReplyType{
		MEMBERREPLY("来自会员的评论", "1"),OFFICIALRELPY("来自官方的回复","2");

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

		private GoodsCommentReplyType(String name, String state) {
			this.name = name;
			this.state = state;
		}

		public static String getName(String tag) {
			for (GoodsCommentReplyType d : GoodsCommentReplyType.values()) {
				if (d.getState().equals(tag)) {
					return d.getName();
				}
			}
			return "";
		}
	}
}
