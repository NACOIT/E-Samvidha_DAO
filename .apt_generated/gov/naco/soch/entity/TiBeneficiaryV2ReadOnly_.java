package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBeneficiaryV2ReadOnly.class)
public abstract class TiBeneficiaryV2ReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBeneficiaryV2ReadOnly, Long> facilityId;
	public static volatile SingularAttribute<TiBeneficiaryV2ReadOnly, BeneficiaryV2ReadOnly> beneficiary;
	public static volatile SingularAttribute<TiBeneficiaryV2ReadOnly, Boolean> isDeleted;
	public static volatile SingularAttribute<TiBeneficiaryV2ReadOnly, Long> id;
	public static volatile SingularAttribute<TiBeneficiaryV2ReadOnly, String> tiCode;
	public static volatile SingularAttribute<TiBeneficiaryV2ReadOnly, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<TiBeneficiaryV2ReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<TiBeneficiaryV2ReadOnly, MasterTiClientStatus> status;

	public static final String FACILITY_ID = "facilityId";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETED = "isDeleted";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

