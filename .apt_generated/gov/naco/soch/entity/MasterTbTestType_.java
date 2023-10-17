package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterTbTestType.class)
public abstract class MasterTbTestType_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterTbTestType, String> code;
	public static volatile SingularAttribute<MasterTbTestType, Boolean> isDelete;
	public static volatile SingularAttribute<MasterTbTestType, String> name;
	public static volatile SingularAttribute<MasterTbTestType, String> description;
	public static volatile SingularAttribute<MasterTbTestType, Long> id;
	public static volatile SingularAttribute<MasterTbTestType, Boolean> isActive;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

