package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CounsellingType.class)
public abstract class CounsellingType_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CounsellingType, String> counsellingType;
	public static volatile SetAttribute<CounsellingType, CounsellingNote> counsellingNotes;
	public static volatile SingularAttribute<CounsellingType, Boolean> isDelete;
	public static volatile SingularAttribute<CounsellingType, Long> id;
	public static volatile SingularAttribute<CounsellingType, Boolean> isActive;

	public static final String COUNSELLING_TYPE = "counsellingType";
	public static final String COUNSELLING_NOTES = "counsellingNotes";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

