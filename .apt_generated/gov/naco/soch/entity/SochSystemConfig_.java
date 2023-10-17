package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SochSystemConfig.class)
public abstract class SochSystemConfig_ {

	public static volatile SingularAttribute<SochSystemConfig, LocalDateTime> startDateTime;
	public static volatile SingularAttribute<SochSystemConfig, Boolean> isDelete;
	public static volatile SingularAttribute<SochSystemConfig, String> name;
	public static volatile SingularAttribute<SochSystemConfig, Long> id;
	public static volatile SingularAttribute<SochSystemConfig, LocalDateTime> endDateTime;
	public static volatile SingularAttribute<SochSystemConfig, Boolean> isActive;
	public static volatile SingularAttribute<SochSystemConfig, Boolean> enabled;

	public static final String START_DATE_TIME = "startDateTime";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String END_DATE_TIME = "endDateTime";
	public static final String IS_ACTIVE = "isActive";
	public static final String ENABLED = "enabled";

}

