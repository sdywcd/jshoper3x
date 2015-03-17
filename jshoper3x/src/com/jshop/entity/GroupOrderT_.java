package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-17T16:18:57.728+0800")
@StaticMetamodel(GroupOrderT.class)
public class GroupOrderT_ {
	public static volatile SingularAttribute<GroupOrderT, String> orderid;
	public static volatile SingularAttribute<GroupOrderT, Date> createtime;
	public static volatile SingularAttribute<GroupOrderT, Date> deliverytime;
	public static volatile SingularAttribute<GroupOrderT, String> orderTag;
	public static volatile SingularAttribute<GroupOrderT, Date> paytime;
	public static volatile SingularAttribute<GroupOrderT, Date> purchasetime;
	public static volatile SingularAttribute<GroupOrderT, String> toBuyer;
	public static volatile SingularAttribute<GroupOrderT, String> tradeNo;
	public static volatile SingularAttribute<GroupOrderT, Double> amount;
	public static volatile SingularAttribute<GroupOrderT, String> customernotes;
	public static volatile SingularAttribute<GroupOrderT, String> deliveraddressid;
	public static volatile SingularAttribute<GroupOrderT, String> delivermode;
	public static volatile SingularAttribute<GroupOrderT, String> deliverynumber;
	public static volatile SingularAttribute<GroupOrderT, String> expressnumber;
	public static volatile SingularAttribute<GroupOrderT, Double> freight;
	public static volatile SingularAttribute<GroupOrderT, String> goodid;
	public static volatile SingularAttribute<GroupOrderT, String> goodsname;
	public static volatile SingularAttribute<GroupOrderT, String> hasprintexpress;
	public static volatile SingularAttribute<GroupOrderT, String> hasprintfpinvoice;
	public static volatile SingularAttribute<GroupOrderT, String> hasprintinvoice;
	public static volatile SingularAttribute<GroupOrderT, String> invoice;
	public static volatile SingularAttribute<GroupOrderT, String> logisticsid;
	public static volatile SingularAttribute<GroupOrderT, String> logisticswebaddress;
	public static volatile SingularAttribute<GroupOrderT, Integer> needquantity;
	public static volatile SingularAttribute<GroupOrderT, String> orderstate;
	public static volatile SingularAttribute<GroupOrderT, String> paymentid;
	public static volatile SingularAttribute<GroupOrderT, String> paymentname;
	public static volatile SingularAttribute<GroupOrderT, String> paystate;
	public static volatile SingularAttribute<GroupOrderT, Double> points;
	public static volatile SingularAttribute<GroupOrderT, String> shippingaddressid;
	public static volatile SingularAttribute<GroupOrderT, String> shippingstate;
	public static volatile SingularAttribute<GroupOrderT, String> shippingusername;
	public static volatile SingularAttribute<GroupOrderT, Double> shouldpay;
	public static volatile SingularAttribute<GroupOrderT, Double> usepoints;
	public static volatile SingularAttribute<GroupOrderT, String> userid;
	public static volatile SingularAttribute<GroupOrderT, String> username;
	public static volatile SingularAttribute<GroupOrderT, String> vouchersid;
}
