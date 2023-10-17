package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Division.class)
public abstract class Division_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Division, String> npoMobileNumber;
	public static volatile SingularAttribute<Division, String> code;
	public static volatile SingularAttribute<Division, String> sccMobileNumber;
	public static volatile SingularAttribute<Division, Boolean> isDelete;
	public static volatile SingularAttribute<Division, String> sccName;
	public static volatile SingularAttribute<Division, Boolean> isActive;
	public static volatile SetAttribute<Division, Product> products;
	public static volatile SingularAttribute<Division, String> npoEmailId;
	public static volatile SetAttribute<Division, FacilityTypeDivisionMapping> facilityTypeDivisionMappings;
	public static volatile SingularAttribute<Division, String> npoName;
	public static volatile SingularAttribute<Division, String> name;
	public static volatile SetAttribute<Division, DivisionAdminDivisionMapping> divisionAdminDivisionMappings;
	public static volatile SingularAttribute<Division, Long> id;
	public static volatile SingularAttribute<Division, String> sccEmailId;
	public static volatile SetAttribute<Division, Facility> facilities;
	public static volatile SetAttribute<Division, UserMaster> userMasters;

	public static final String NPO_MOBILE_NUMBER = "npoMobileNumber";
	public static final String CODE = "code";
	public static final String SCC_MOBILE_NUMBER = "sccMobileNumber";
	public static final String IS_DELETE = "isDelete";
	public static final String SCC_NAME = "sccName";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCTS = "products";
	public static final String NPO_EMAIL_ID = "npoEmailId";
	public static final String FACILITY_TYPE_DIVISION_MAPPINGS = "facilityTypeDivisionMappings";
	public static final String NPO_NAME = "npoName";
	public static final String NAME = "name";
	public static final String DIVISION_ADMIN_DIVISION_MAPPINGS = "divisionAdminDivisionMappings";
	public static final String ID = "id";
	public static final String SCC_EMAIL_ID = "sccEmailId";
	public static final String FACILITIES = "facilities";
	public static final String USER_MASTERS = "userMasters";

}

