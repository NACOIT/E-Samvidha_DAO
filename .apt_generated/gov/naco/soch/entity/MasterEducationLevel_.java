package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterEducationLevel.class)
public abstract class MasterEducationLevel_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterEducationLevel, String> code;
	public static volatile SingularAttribute<MasterEducationLevel, Boolean> isDelete;
	public static volatile SingularAttribute<MasterEducationLevel, String> name;
	public static volatile SingularAttribute<MasterEducationLevel, String> description;
	public static volatile SingularAttribute<MasterEducationLevel, Long> id;
	public static volatile SingularAttribute<MasterEducationLevel, Boolean> isActive;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

