package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Auditable.class)
public abstract class Auditable_ {

	public static volatile SingularAttribute<Auditable, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<Auditable, Object> createdBy;
	public static volatile SingularAttribute<Auditable, LocalDateTime> createdTime;
	public static volatile SingularAttribute<Auditable, Object> modifiedBy;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";

}

