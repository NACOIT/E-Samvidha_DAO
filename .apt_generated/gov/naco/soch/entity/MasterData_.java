package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterData.class)
public abstract class MasterData_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterData, String> code;
	public static volatile SingularAttribute<MasterData, Boolean> isDelete;
	public static volatile SingularAttribute<MasterData, String> name;
	public static volatile SingularAttribute<MasterData, String> description;
	public static volatile SingularAttribute<MasterData, String> masterType;
	public static volatile SingularAttribute<MasterData, Long> id;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String MASTER_TYPE = "masterType";
	public static final String ID = "id";

}

