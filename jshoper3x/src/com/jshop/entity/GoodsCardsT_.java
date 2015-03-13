package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-12T19:19:09.646+0800")
@StaticMetamodel(GoodsCardsT.class)
public class GoodsCardsT_ {
	public static volatile SingularAttribute<GoodsCardsT, String> id;
	public static volatile SingularAttribute<GoodsCardsT, Date> createtime;
	public static volatile SingularAttribute<GoodsCardsT, Date> updatetime;
	public static volatile SingularAttribute<GoodsCardsT, Integer> amount;
	public static volatile SingularAttribute<GoodsCardsT, String> cardname;
	public static volatile SingularAttribute<GoodsCardsT, String> creatorid;
	public static volatile SingularAttribute<GoodsCardsT, String> goodsid;
	public static volatile SingularAttribute<GoodsCardsT, String> goodsname;
	public static volatile SingularAttribute<GoodsCardsT, String> status;
}
