package com.jshop.action.backstage.utils.order;

public class AllOrderState {
//
//	0：未确认 1:已确认
//	2:货到付款  3：待确认收货    
//	4:退货订单    5:关闭    6:用户已确认收货  7：缺货   8：用户删除 9：成功订单（所有订单交易结束）
//ORDERSTATE
	
   
	/**
	 * 订单状态
	 */
	public static final String ORDERSTATE_ZERO="未确认";
	
	public static final String ORDERSTATE_ONE="已确认";

	public static final String ORDERSTATE_TWO="货到付款";
	
	public static final String ORDERSTATE_THREE="待确认收货";
	
	public static final String ORDERSTATE_FOUR="退货";
	
	public static final String ORDERSTATE_FIVE="关闭";
	
	public static final String ORDERSTATE_SIX="用户已收货";
	
	public static final String ORDERSTATE_SEVEN="缺货";
	
	public static final String ORDERSTATE_EIGHT="用户删除";

	public static final String ORDERSTATE_NINE="成功";
	
	public static final String ORDERSTATE_TEN="菜品制作中";
	
	public static final String ORDERSTATE_ELEVEN="菜制作完成并已上齐";
	//0：未付款 1：已付款 2：订单关闭
	/**
	 * 支付状态
	 */
	public static final String PAYSTATE_ZERO="未付款";
	
	public static final String PAYSTATE_ONE="已付款";
	
	public static final String PAYSTATE_TWO="订单关闭";
	
	//SHIPPINGSTATE 0：配货中（未发货） 1：已发货 2：订单关闭
	/**
	 * 配送状态
	 */
	public static final String SHIPPINGSTATE_ZERO="配货中(未发货)";
	
	public static final String SHIPPINGSTATE_ONE="已发货";
	
	public static final String SHIPPINGSTATE_TWO="订单关闭";
	
	//配送方式
	public static final String EXPRESS="快递";
	
	public static final String POST="平邮";
	
	public static final String EMS="EMS";
	
	//订单来源
	public static final String ORDERTAG_ONE="普通订单";

	public static final String ORDERTAG_TWO="团购订单";
	
	public static final String ORDERTAG_THREE="拍卖订单";
	
	public static final String ORDERTAG_FOUR="手机订单";
	
	public static final String ORDERTAG_FIVE="组合商品订单";

	
	//开票
	public static final String INVOICE_ZERO="不开";
	
	public static final String INVOICE_ONE="开";
	//烹调状态
	public static final String COOKINGSTATE_ZERO="未烹调";
	
	public static final String COOKINGSTATE_ONE="已烹调";
	
	public static final String COOKINGSTATE_TWO="已完成上菜";


	//用餐状态
	public static final String TABLESTATE_ZERO="空闲";
	
	public static final String TABLESTATE_ONE="使用中";

	
	//订单状态的数字对应
	//
//	0：未确认 1:已确认
//	2:货到付款  3：待确认收货    
//	4:退货订单    5:关闭    6:用户已确认收货  7：缺货   8：用户删除 9：成功订单（所有订单交易结束）
//ORDERSTATE
	public static final String ORDERSTATE_ZERO_NUM="0";
	
	public static final String ORDERSTATE_ONE_NUM="1";
	
	public static final String ORDERSTATE_TWO_NUM="2";
	
	public static final String ORDERSTATE_THREE_NUM="3";
	
	public static final String ORDERSTATE_FOUR_NUM="4";
	
	public static final String ORDERSTATE_FIVE_NUM="5";
	
	public static final String ORDERSTATE_SIX_NUM="6";
	
	public static final String ORDERSTATE_SEVEN_NUM="7";
	
	public static final String ORDERSTATE_EIGHT_NUM="8";

	public static final String ORDERSTATE_NINE_NUM="9";
	
	public static final String ORDERSTATE_NINE_TEN="10";
	
	public static final String ORDERSTATE_NINE_ELEVEN="11";
	
	//0：未付款 1：已付款 2：订单关闭
	/**
	 * 支付状态
	 */
	public static final String PAYSTATE_ZERO_NUM="0";
	
	public static final String PAYSTATE_ONE_NUM="1";
	
	public static final String PAYSTATE_TWO_NUM="2";
	//SHIPPINGSTATE 0：配货中（未发货） 1：已发货 2：订单关闭
	/**
	 * 配送状态
	 */
	public static final String SHIPPINGSTATE_ZERO_NUM="0";
	
	public static final String SHIPPINGSTATE_ONE_NUM="1";
	
	public static final String SHIPPINGSTATE_TWO_NUM="2";
	/**
	 * 烹饪状态
	 */
	//cookingstate 0:未烹饪     1：已烹饪     2：菜已完成
	public static final String COOKINGSTATE_ZERO_NUM="0";
	
	public static final String COOKINGSTATE_ONE_NUM="1";
	
	public static final String COOKINGSTATE_TWO_NUM="2";

	
	/**
	 * 餐桌使用状态
	 */
	//tablestate  0:空闲   1：使用中
	public static final String TABLESTATE_ZERO_NUM="0";
	
	public static final String TABLESTATE_ONE_NUM="1";

	
	
	
}
