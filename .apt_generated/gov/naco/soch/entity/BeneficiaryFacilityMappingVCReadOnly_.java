package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFacilityMappingVCReadOnly.class)
public abstract class BeneficiaryFacilityMappingVCReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryFacilityMappingVCReadOnly, BeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingVCReadOnly, String> artNumber;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingVCReadOnly, String> preArtNumber;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingVCReadOnly, Long> id;

	public static final String BENEFICIARY = "beneficiary";
	public static final String ART_NUMBER = "artNumber";
	public static final String PRE_ART_NUMBER = "preArtNumber";
	public static final String ID = "id";

}

