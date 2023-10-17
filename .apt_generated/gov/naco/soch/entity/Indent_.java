package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Indent.class)
public abstract class Indent_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Indent, LocalDate> indentDate;
	public static volatile SingularAttribute<Indent, IndentStatusMaster> indentStatusMaster;
	public static volatile SingularAttribute<Indent, UserMaster> rejectedBy;
	public static volatile SingularAttribute<Indent, LocalDateTime> rejectedTime;
	public static volatile SingularAttribute<Indent, String> rejectRemarks;
	public static volatile SingularAttribute<Indent, String> indentNumber;
	public static volatile SingularAttribute<Indent, Boolean> isDelete;
	public static volatile SingularAttribute<Indent, Long> indentId;
	public static volatile SingularAttribute<Indent, Facility> procurementAgent;
	public static volatile SetAttribute<Indent, IndentProduct> indentProducts;
	public static volatile SingularAttribute<Indent, Boolean> isActive;

	public static final String INDENT_DATE = "indentDate";
	public static final String INDENT_STATUS_MASTER = "indentStatusMaster";
	public static final String REJECTED_BY = "rejectedBy";
	public static final String REJECTED_TIME = "rejectedTime";
	public static final String REJECT_REMARKS = "rejectRemarks";
	public static final String INDENT_NUMBER = "indentNumber";
	public static final String IS_DELETE = "isDelete";
	public static final String INDENT_ID = "indentId";
	public static final String PROCUREMENT_AGENT = "procurementAgent";
	public static final String INDENT_PRODUCTS = "indentProducts";
	public static final String IS_ACTIVE = "isActive";

}

