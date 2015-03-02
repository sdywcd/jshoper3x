package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-02T23:47:48.860+0800")
@StaticMetamodel(GroupOrder_T.class)
public class GroupOrder_T_ {
	public static volatile SingularAttribute<GroupOrder_T, String> orderid;
	public static volatile SingularAttribute<GroupOrder_T, Double> amount;
	public static volatile SingularAttribute<GroupOrder_T, Date> createtime;
	public static volatile SingularAttribute<GroupOrder_T, String> customernotes;
	public static volatile SingularAttribute<GroupOrder_T, String> deliveraddressid;
	public static volatile SingularAttribute<GroupOrder_T, String> delivermode;
	public static volatile SingularAttribute<GroupOrder_T, String> deliverynumber;
	public static volatile SingularAttribute<GroupOrder_T, Date> deliverytime;
	public static volatile SingularAttribute<GroupOrder_T, String> expressnumber;
	public static volatile SingularAttribute<GroupOrder_T, Double> freight;
	public static volatile SingularAttribute<GroupOrder_T, String> goodid;
	public static volatile SingularAttribute<GroupOrder_T, String> goodsname;
	public static volatile SingularAttribute<GroupOrder_T, String> hasprintexpress;
	public static volatile SingularAttribute<GroupOrder_T, String> hasprintfpinvoice;
	public static volatile SingularAttribute<GroupOrder_T, String> hasprintinvoice;
	public static volatile SingularAttribute<GroupOrder_T, String> invoice;
	public static volatile SingularAttribute<GroupOrder_T, String> logisticsid;
	public static volatile SingularAttribute<GroupOrder_T, String> logisticswebaddress;
	public static volatile SingularAttribute<GroupOrder_T, Integer> needquantity;
	public static volatile SingularAttribute<GroupOrder_T, String> orderTag;
	public static volatile SingularAttribute<GroupOrder_T, String> orderstate;
	public static volatile SingularAttribute<GroupOrder_T, String> paymentid;
	public static volatile SingularAttribute<GroupOrder_T, String> paymentname;
	public static volatile SingularAttribute<GroupOrder_T, String> paystate;
	public static volatile SingularAttribute<GroupOrder_T, Date> paytime;
	public static volatile SingularAttribute<GroupOrder_T, Double> points;
	public static volatile SingularAttribute<GroupOrder_T, Date> purchasetime;
	public static volatile SingularAttribute<GroupOrder_T, String> shippingaddressid;
	public static volatile SingularAttribute<GroupOrder_T, String> shippingstate;
	public static volatile SingularAttribute<GroupOrder_T, String> shippingusername;
	public static volatile SingularAttribute<GroupOrder_T, Double> shouldpay;
	public static volatile SingularAttribute<GroupOrder_T, String> toBuyer;
	public static volatile SingularAttribute<GroupOrder_T, String> tradeNo;
	public static volatile SingularAttribute<GroupOrder_T, Double> usepoints;
	public static volatile SingularAttribute<GroupOrder_T, String> userid;
	public static volatile SingularAttribute<GroupOrder_T, String> username;
	public static volatile SingularAttribute<GroupOrder_T, String> vouchersid;
}
