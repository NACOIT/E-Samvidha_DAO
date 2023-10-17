package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityType.class)
public abstract class FacilityType_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<FacilityType, BeneficiaryPrivateTransfers> beneficiaryPrivateTransfers;
	public static volatile SingularAttribute<FacilityType, String> facilityTypeName;
	public static volatile SetAttribute<FacilityType, FacilityTypeDivisionMapping> facilityTypeDivisionMappings;
	public static volatile SetAttribute<FacilityType, DesignationFacilityTypeMapping> designationFacilityTypeMappings;
	public static volatile SingularAttribute<FacilityType, Boolean> isDelete;
	public static volatile SetAttribute<FacilityType, Role> roles;
	public static volatile SingularAttribute<FacilityType, String> description;
	public static volatile SingularAttribute<FacilityType, Long> id;
	public static volatile SingularAttribute<FacilityType, Boolean> isActive;
	public static volatile SetAttribute<FacilityType, Facility> facilities;
	public static volatile SetAttribute<FacilityType, UserMaster> userMasters;
	public static volatile SetAttribute<FacilityType, ProductFacilityTypeMapping> ProductFacilityTypeMappings;

	public static final String BENEFICIARY_PRIVATE_TRANSFERS = "beneficiaryPrivateTransfers";
	public static final String FACILITY_TYPE_NAME = "facilityTypeName";
	public static final String FACILITY_TYPE_DIVISION_MAPPINGS = "facilityTypeDivisionMappings";
	public static final String DESIGNATION_FACILITY_TYPE_MAPPINGS = "designationFacilityTypeMappings";
	public static final String IS_DELETE = "isDelete";
	public static final String ROLES = "roles";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITIES = "facilities";
	public static final String USER_MASTERS = "userMasters";
	public static final String PRODUCT_FACILITY_TYPE_MAPPINGS = "ProductFacilityTypeMappings";

}

