package com.jshop.action.backstage.staticspage;

/**
 * 该类标示静态页生成所需要的标记和内容
 * 
 * 如下的静态值必须和模板文件中的sign一致，系统才可以正确找到进行静态化，这里的设计有待改进，有一定的写死的代码和逻辑
 * @author cd
 *
 */
public class ContentTag {
	
	public static final String CREATORID="20100721001";
	
	/**
	 * 文章详细
	 */
	public static final String TEMPLATENAMEFORARTICLE="articlecontent";
	/**
	 * 公告详细，包括页脚帮助详细
	 */
	public static final String TEMPLATENAMEFORNOTICE="noticecontent";
	/**
	 * 商品详情
	 */
	public static final String TEMPLATENAMEFORGOODSDETAIL="goodsdetail";
	/**
	 * 商品分类
	 */
	public static final String TEMPLATENAMEFORGOODSCATEGORYLIST="goodscategorylist";
	/**
	 * 公告列表，包括页脚帮助列表页
	 */
	public static final String TEMPLATENAME4NOTICELIST="noticelist";
	/**
	 * 文章列表页
	 */
	public static final String TEMPLATENAME4ARTICLESLIST="articleslist";
	
	public static final String TEMPLATENAMEFORINDEX="index";
	public static final String SYSTEMCONTENTINDEX="首页";
	public static final String TEMPLATENAMEFORLOGIN="login";
	public static final String TEMPLATEFORREGISTER="register";
	public static final String SYSTEMCONTENTREGISTER="用户注册";
	public static final String TEMPLATENAMEFOREMAIL="useractivates";//激活邮件
	public static final String TEMPLATENAMEFORUSERACTIVATESCALLBACK="useractivatescallback";//用户激活回调页面
	public static final String TEMPLATENAMEFOREMAILTEMPLATE="emailtemplate";//邮件模板
	public static final String TEMPLATENAMEFORGOODSGROUPT="goodsgroupt";//团购商品页
	
	
	
	
	
	
	
	
	
	
	
}
