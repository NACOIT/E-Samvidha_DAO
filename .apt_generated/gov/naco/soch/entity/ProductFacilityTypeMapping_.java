package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductFacilityTypeMapping.class)
public abstract class ProductFacilityTypeMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ProductFacilityTypeMapping, Product> product;
	public static volatile SingularAttribute<ProductFacilityTypeMapping, FacilityType> facilityType;
	public static volatile SingularAttribute<ProductFacilityTypeMapping, Boolean> isDelete;
	public static volatile SingularAttribute<ProductFacilityTypeMapping, Long> id;
	public static volatile SingularAttribute<ProductFacilityTypeMapping, Boolean> isActive;

	public static final String PRODUCT = "product";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

