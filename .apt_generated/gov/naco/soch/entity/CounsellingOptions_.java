package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CounsellingOptions.class)
public abstract class CounsellingOptions_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CounsellingOptions, String> counsellingOption;
	public static volatile SingularAttribute<CounsellingOptions, Boolean> isDelete;
	public static volatile SingularAttribute<CounsellingOptions, Long> id;
	public static volatile SingularAttribute<CounsellingOptions, Boolean> isActive;
	public static volatile SingularAttribute<CounsellingOptions, CounsellingNote> counsellingNote;

	public static final String COUNSELLING_OPTION = "counsellingOption";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String COUNSELLING_NOTE = "counsellingNote";

}

