package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExtDetailsTimeAvailabilityMapping.class)
public abstract class ExtDetailsTimeAvailabilityMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityMapping, TIBeneficiaryExtDetails> tiBeneficiaryExtDetails;
	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityMapping, MasterBenificiaryTimeAvailability> masterBenificiaryTimeAvailability;
	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityMapping, Boolean> isDelete;
	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityMapping, Long> id;
	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityMapping, Boolean> isActive;

	public static final String TI_BENEFICIARY_EXT_DETAILS = "tiBeneficiaryExtDetails";
	public static final String MASTER_BENIFICIARY_TIME_AVAILABILITY = "masterBenificiaryTimeAvailability";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

