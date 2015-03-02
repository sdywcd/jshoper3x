package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-23T01:04:45.143+0800")
@StaticMetamodel(MemberRechargeRecordsT.class)
public class MemberRechargeRecordsT_ {
	public static volatile SingularAttribute<MemberRechargeRecordsT, String> id;
	public static volatile SingularAttribute<MemberRechargeRecordsT, Date> createtime;
	public static volatile SingularAttribute<MemberRechargeRecordsT, String> memberid;
	public static volatile SingularAttribute<MemberRechargeRecordsT, String> membername;
	public static volatile SingularAttribute<MemberRechargeRecordsT, Double> money;
	public static volatile SingularAttribute<MemberRechargeRecordsT, String> shopid;
	public static volatile SingularAttribute<MemberRechargeRecordsT, String> type;
}
