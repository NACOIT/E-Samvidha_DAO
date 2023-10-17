package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DsrcBeneficiary.class)
public abstract class DsrcBeneficiary_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DsrcBeneficiary, String> infantCode;
	public static volatile SingularAttribute<DsrcBeneficiary, MasterDsrcBeneficiaryStatus> dsrcBeneficiaryStatus;
	public static volatile SingularAttribute<DsrcBeneficiary, Boolean> isDelete;
	public static volatile SingularAttribute<DsrcBeneficiary, Boolean> isCounsellingDone;
	public static volatile SingularAttribute<DsrcBeneficiary, LocalDate> dsrcRegDate;
	public static volatile SingularAttribute<DsrcBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<DsrcBeneficiary, Boolean> isBeneficiaryHrg;
	public static volatile SingularAttribute<DsrcBeneficiary, Beneficiary> infantMotherBeneficiaryId;
	public static volatile SingularAttribute<DsrcBeneficiary, MasterDsrcBeneficiaryDeleteReason> dsrcBeneficiaryDeleteReason;
	public static volatile SingularAttribute<DsrcBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<DsrcBeneficiary, Boolean> tbSymptoms;
	public static volatile SingularAttribute<DsrcBeneficiary, Facility> infantMotherFacilityId;
	public static volatile SingularAttribute<DsrcBeneficiary, Long> id;
	public static volatile SingularAttribute<DsrcBeneficiary, Facility> facility;

	public static final String INFANT_CODE = "infantCode";
	public static final String DSRC_BENEFICIARY_STATUS = "dsrcBeneficiaryStatus";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_COUNSELLING_DONE = "isCounsellingDone";
	public static final String DSRC_REG_DATE = "dsrcRegDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_BENEFICIARY_HRG = "isBeneficiaryHrg";
	public static final String INFANT_MOTHER_BENEFICIARY_ID = "infantMotherBeneficiaryId";
	public static final String DSRC_BENEFICIARY_DELETE_REASON = "dsrcBeneficiaryDeleteReason";
	public static final String BENEFICIARY = "beneficiary";
	public static final String TB_SYMPTOMS = "tbSymptoms";
	public static final String INFANT_MOTHER_FACILITY_ID = "infantMotherFacilityId";
	public static final String ID = "id";
	public static final String FACILITY = "facility";

}

