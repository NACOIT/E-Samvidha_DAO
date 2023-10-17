package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenCounselling.class)
public abstract class TIBenCounselling_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenCounselling, Integer> noOfCondomsDistributed;
	public static volatile SingularAttribute<TIBenCounselling, LocalDate> lastCounsellingDate;
	public static volatile SingularAttribute<TIBenCounselling, Boolean> isDelete;
	public static volatile SingularAttribute<TIBenCounselling, LocalDate> counsellingDate;
	public static volatile SingularAttribute<TIBenCounselling, LocalDate> nextCounsellingDate;
	public static volatile SingularAttribute<TIBenCounselling, Boolean> isActive;
	public static volatile SetAttribute<TIBenCounselling, TiBenCounsellingType> tiBenCounsellingType;
	public static volatile SingularAttribute<TIBenCounselling, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBenCounselling, Integer> durationOfCounselling;
	public static volatile SingularAttribute<TIBenCounselling, Long> id;
	public static volatile SingularAttribute<TIBenCounselling, Boolean> isEarly;
	public static volatile SingularAttribute<TIBenCounselling, Boolean> csm;
	public static volatile SingularAttribute<TIBenCounselling, Facility> facility;
	public static volatile SingularAttribute<TIBenCounselling, String> remarks;

	public static final String NO_OF_CONDOMS_DISTRIBUTED = "noOfCondomsDistributed";
	public static final String LAST_COUNSELLING_DATE = "lastCounsellingDate";
	public static final String IS_DELETE = "isDelete";
	public static final String COUNSELLING_DATE = "counsellingDate";
	public static final String NEXT_COUNSELLING_DATE = "nextCounsellingDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String TI_BEN_COUNSELLING_TYPE = "tiBenCounsellingType";
	public static final String BENEFICIARY = "beneficiary";
	public static final String DURATION_OF_COUNSELLING = "durationOfCounselling";
	public static final String ID = "id";
	public static final String IS_EARLY = "isEarly";
	public static final String CSM = "csm";
	public static final String FACILITY = "facility";
	public static final String REMARKS = "remarks";

}

