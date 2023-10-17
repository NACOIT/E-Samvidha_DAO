package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterTbType.class)
public abstract class MasterTbType_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterTbType, String> code;
	public static volatile SingularAttribute<MasterTbType, Boolean> isDelete;
	public static volatile SingularAttribute<MasterTbType, String> name;
	public static volatile SingularAttribute<MasterTbType, String> description;
	public static volatile SingularAttribute<MasterTbType, Long> id;
	public static volatile SingularAttribute<MasterTbType, Boolean> isActive;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

