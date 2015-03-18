package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-17T18:48:28.740+0800")
@StaticMetamodel(EcouponT.class)
public class EcouponT_ {
	public static volatile SingularAttribute<EcouponT, String> eid;
	public static volatile SingularAttribute<EcouponT, Date> begintime;
	public static volatile SingularAttribute<EcouponT, Date> endtime;
	public static volatile SingularAttribute<EcouponT, String> ecouponstate;
	public static volatile SingularAttribute<EcouponT, Double> favourableprices;
	public static volatile SingularAttribute<EcouponT, String> goodsid;
	public static volatile SingularAttribute<EcouponT, String> goodsname;
	public static volatile SingularAttribute<EcouponT, String> note;
	public static volatile SingularAttribute<EcouponT, Double> pricededuction;
	public static volatile SingularAttribute<EcouponT, String> state;
}
