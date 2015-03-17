package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-17T16:18:57.746+0800")
@StaticMetamodel(NoticeT.class)
public class NoticeT_ {
	public static volatile SingularAttribute<NoticeT, String> noticeid;
	public static volatile SingularAttribute<NoticeT, String> content;
	public static volatile SingularAttribute<NoticeT, Date> createtime;
	public static volatile SingularAttribute<NoticeT, String> creatorid;
	public static volatile SingularAttribute<NoticeT, String> noticenlid;
	public static volatile SingularAttribute<NoticeT, String> noticenlname;
	public static volatile SingularAttribute<NoticeT, String> title;
}
