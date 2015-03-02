package com.jshop.action.backstage.utils.enums;

public class BaseEnums {

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
		ORDERSTATE_UNCONFIRMED_ZERO_NUM("未确认", "0");
		private String name;
		private String value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		private OrderState(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public static String getName(String value) {
			for (OrderState orderstate : OrderState.values()) {
				if (orderstate.getValue().equals(value)) {
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
		NORMAL("普通订单", "1");
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
		NEWADDTOCART_NUM("新加入购物车的商品", "1");
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
	

	

}
