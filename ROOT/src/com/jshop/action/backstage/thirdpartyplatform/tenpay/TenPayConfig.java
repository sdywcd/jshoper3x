package com.jshop.action.backstage.thirdpartyplatform.tenpay;

public class TenPayConfig {

	
	public static String partner; //商户号
	
	public static String key; //密钥
	
	public static String return_url; //交易完成后跳转的URL
	
	public static String notify_url; //接收财付通通知的URL
	
	public static String out_trade_no; //商家订单号
	
	public static String total_fee; //商品金额,以分为单位
	
	public static String body; //商品描述
	
	public static String bank_type; //银行类型(中介担保时此参数无效)
	
	public static String spbill_create_ip; //用户的公网ip，不是商户服务器IP
	
	public static String fee_type; //币种，1人民币
	
	public static String subject; //商品名称(中介交易时必填)
	
	public static String sign_type; //签名类型,默认：MD5
	
	public static String service_version; //版本号，默认为1.0
	
	public static String input_charset; //字符编码
	
	public static String sign_key_index; //密钥序号
	
	public static String attach; //附加数据，原样返回
	
	public static String product_fee; //商品费用，必须保证transport_fee + product_fee=total_fee
	
	public static String transport_fee; //物流费用，必须保证transport_fee + product_fee=total_fee
	
	public static String time_start; //订单生成时间，格式为yyyymmddhhmmss
	
	public static String time_expire; //订单失效时间，格式为yyyymmddhhmmss
	
	public static String buyer_id; //买方财付通账号
	
	public static String goods_tag; //商品标记
	
	public static String trade_mode; //交易模式，1即时到账(默认)，2中介担保，3后台选择（买家进支付中心列表选择）
	
	public static String transport_desc; //物流说明
	
	public static String trans_type; //交易类型，1实物交易，2虚拟交易
	
	public static String agentid; //平台ID
	
	public static String agent_type; //代理模式，0无代理(默认)，1表示卡易售模式，2表示网店模式
	
	public static String seller_id; //卖家商户号，为空则等同于partner
	
	public static String mobile;//虚拟充值卡要用的手机号
	
	public static String email;//邮箱地址
	
}
