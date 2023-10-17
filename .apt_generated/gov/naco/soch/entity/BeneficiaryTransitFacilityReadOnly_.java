package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryTransitFacilityReadOnly.class)
public abstract class BeneficiaryTransitFacilityReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryTransitFacilityReadOnly, Long> facilityId;
	public static volatile SingularAttribute<BeneficiaryTransitFacilityReadOnly, OstBenSubEntity> tiOstBeneficiary;
	public static volatile SingularAttribute<BeneficiaryTransitFacilityReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryTransitFacilityReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryTransitFacilityReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryTransitFacilityReadOnly, String> status;

	public static final String FACILITY_ID = "facilityId";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

