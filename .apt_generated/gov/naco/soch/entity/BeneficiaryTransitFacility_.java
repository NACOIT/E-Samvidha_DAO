package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryTransitFacility.class)
public abstract class BeneficiaryTransitFacility_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryTransitFacility, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<BeneficiaryTransitFacility, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryTransitFacility, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryTransitFacility, Long> id;
	public static volatile SingularAttribute<BeneficiaryTransitFacility, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryTransitFacility, Facility> facility;
	public static volatile SingularAttribute<BeneficiaryTransitFacility, String> status;

	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String STATUS = "status";

}

