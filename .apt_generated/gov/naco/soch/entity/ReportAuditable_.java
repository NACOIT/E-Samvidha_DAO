package gov.naco.soch.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReportAuditable.class)
public abstract class ReportAuditable_ {

	public static volatile SingularAttribute<ReportAuditable, Date> createdDate;
	public static volatile SingularAttribute<ReportAuditable, UserMaster> modifiedUser;
	public static volatile SingularAttribute<ReportAuditable, Date> modifiedDate;
	public static volatile SingularAttribute<ReportAuditable, UserMaster> createdUser;

	public static final String CREATED_DATE = "createdDate";
	public static final String MODIFIED_USER = "modifiedUser";
	public static final String MODIFIED_DATE = "modifiedDate";
	public static final String CREATED_USER = "createdUser";

}

