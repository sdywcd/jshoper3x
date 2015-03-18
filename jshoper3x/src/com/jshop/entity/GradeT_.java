package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-17T18:48:28.760+0800")
@StaticMetamodel(GradeT.class)
public class GradeT_ {
	public static volatile SingularAttribute<GradeT, String> gradeid;
	public static volatile SingularAttribute<GradeT, Date> createtime;
	public static volatile SingularAttribute<GradeT, String> creatorid;
	public static volatile SingularAttribute<GradeT, Double> discount;
	public static volatile SingularAttribute<GradeT, String> gradename;
	public static volatile SingularAttribute<GradeT, String> gradevalue;
	public static volatile SingularAttribute<GradeT, Double> needcost;
}
