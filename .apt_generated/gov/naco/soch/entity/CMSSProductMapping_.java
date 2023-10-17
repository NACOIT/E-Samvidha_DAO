package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CMSSProductMapping.class)
public abstract class CMSSProductMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CMSSProductMapping, String> cmssProductName;
	public static volatile SingularAttribute<CMSSProductMapping, String> cmssDrugId;
	public static volatile SingularAttribute<CMSSProductMapping, String> productCode;
	public static volatile SingularAttribute<CMSSProductMapping, Boolean> isDelete;
	public static volatile SingularAttribute<CMSSProductMapping, Long> id;
	public static volatile SingularAttribute<CMSSProductMapping, Boolean> isActive;

	public static final String CMSS_PRODUCT_NAME = "cmssProductName";
	public static final String CMSS_DRUG_ID = "cmssDrugId";
	public static final String PRODUCT_CODE = "productCode";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

