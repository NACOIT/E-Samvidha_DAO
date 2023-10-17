package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmssStoreSacsMapping.class)
public abstract class CmssStoreSacsMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CmssStoreSacsMapping, String> cmssStoreName;
	public static volatile SingularAttribute<CmssStoreSacsMapping, String> cmssStoreId;
	public static volatile SingularAttribute<CmssStoreSacsMapping, Boolean> isDelete;
	public static volatile SingularAttribute<CmssStoreSacsMapping, Long> id;
	public static volatile SingularAttribute<CmssStoreSacsMapping, Boolean> isActive;
	public static volatile SingularAttribute<CmssStoreSacsMapping, Facility> facility;

	public static final String CMSS_STORE_NAME = "cmssStoreName";
	public static final String CMSS_STORE_ID = "cmssStoreId";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

