package com.jshop.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-23T01:04:45.135+0800")
@StaticMetamodel(InvoicePrintingT.class)
public class InvoicePrintingT_ {
	public static volatile SingularAttribute<InvoicePrintingT, String> invoicePrintingId;
	public static volatile SingularAttribute<InvoicePrintingT, Date> createPrintingTime;
	public static volatile SingularAttribute<InvoicePrintingT, String> operatorname;
	public static volatile SingularAttribute<InvoicePrintingT, String> orderid;
}
