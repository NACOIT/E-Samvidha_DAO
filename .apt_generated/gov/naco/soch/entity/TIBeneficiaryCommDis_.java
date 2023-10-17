package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBeneficiaryCommDis.class)
public abstract class TIBeneficiaryCommDis_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBeneficiaryCommDis, Long> facilityId;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Integer> needlesDistributed;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, LocalDate> distributionDate;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Integer> syringesReturned;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, MasterContactType> contactType;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Integer> needlesReturned;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Boolean> isActive;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Integer> syringesDistributed;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Boolean> isDeleted;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Integer> condomsDistributed;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Long> id;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Boolean> csm;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Boolean> condomUseDuringLastSex;
	public static volatile SingularAttribute<TIBeneficiaryCommDis, Boolean> notSharingNeedleSyringe;

	public static final String FACILITY_ID = "facilityId";
	public static final String NEEDLES_DISTRIBUTED = "needlesDistributed";
	public static final String DISTRIBUTION_DATE = "distributionDate";
	public static final String SYRINGES_RETURNED = "syringesReturned";
	public static final String CONTACT_TYPE = "contactType";
	public static final String NEEDLES_RETURNED = "needlesReturned";
	public static final String IS_ACTIVE = "isActive";
	public static final String SYRINGES_DISTRIBUTED = "syringesDistributed";
	public static final String IS_DELETED = "isDeleted";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CONDOMS_DISTRIBUTED = "condomsDistributed";
	public static final String ID = "id";
	public static final String CSM = "csm";
	public static final String CONDOM_USE_DURING_LAST_SEX = "condomUseDuringLastSex";
	public static final String NOT_SHARING_NEEDLE_SYRINGE = "notSharingNeedleSyringe";

}

