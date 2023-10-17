package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFacilityMappingGlobalReadOnly.class)
public abstract class BeneficiaryFacilityMappingGlobalReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryFacilityMappingGlobalReadOnly, BeneficiaryGlobalReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingGlobalReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingGlobalReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingGlobalReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingGlobalReadOnly, FacilityReadOnly> facility;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

