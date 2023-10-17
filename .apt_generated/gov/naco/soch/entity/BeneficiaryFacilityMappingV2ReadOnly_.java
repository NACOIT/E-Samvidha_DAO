package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFacilityMappingV2ReadOnly.class)
public abstract class BeneficiaryFacilityMappingV2ReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryFacilityMappingV2ReadOnly, BeneficiaryV2ReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingV2ReadOnly, Boolean> isTransferred;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingV2ReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingV2ReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingV2ReadOnly, FacilityReadOnly> facility;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_TRANSFERRED = "isTransferred";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

