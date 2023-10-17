package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExtDetailsTimeAvailabilityReadOnly.class)
public abstract class ExtDetailsTimeAvailabilityReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityReadOnly, TiBenExtDetailsReadOnly> tiBeneficiaryExtDetails;
	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityReadOnly, MasterBenificiaryTimeAvailability> masterBenificiaryTimeAvailability;
	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityReadOnly, Long> id;
	public static volatile SingularAttribute<ExtDetailsTimeAvailabilityReadOnly, Boolean> isActive;

	public static final String TI_BENEFICIARY_EXT_DETAILS = "tiBeneficiaryExtDetails";
	public static final String MASTER_BENIFICIARY_TIME_AVAILABILITY = "masterBenificiaryTimeAvailability";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

