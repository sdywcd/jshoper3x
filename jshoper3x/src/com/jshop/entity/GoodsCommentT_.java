package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-17T16:18:57.717+0800")
@StaticMetamodel(GoodsCommentT.class)
public class GoodsCommentT_ {
	public static volatile SingularAttribute<GoodsCommentT, String> commentid;
	public static volatile SingularAttribute<GoodsCommentT, Date> posttime;
	public static volatile SingularAttribute<GoodsCommentT, String> commentcontent;
	public static volatile SingularAttribute<GoodsCommentT, String> emailable;
	public static volatile SingularAttribute<GoodsCommentT, String> goodsid;
	public static volatile SingularAttribute<GoodsCommentT, String> goodsname;
	public static volatile SingularAttribute<GoodsCommentT, String> replyid;
	public static volatile SingularAttribute<GoodsCommentT, String> replyorcomment;
	public static volatile SingularAttribute<GoodsCommentT, String> replyorcommentuserid;
	public static volatile SingularAttribute<GoodsCommentT, String> replyorcommentusername;
	public static volatile SingularAttribute<GoodsCommentT, Integer> score;
	public static volatile SingularAttribute<GoodsCommentT, String> shopid;
	public static volatile SingularAttribute<GoodsCommentT, String> state;
	public static volatile SingularAttribute<GoodsCommentT, String> title;
	public static volatile SingularAttribute<GoodsCommentT, String> virtualadd;
}
