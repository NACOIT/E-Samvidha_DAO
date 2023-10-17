package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBeneficiaryReadOnly.class)
public abstract class TiBeneficiaryReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterMigrantOccupation> migrantOccupation;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Integer> ibTreatments;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Integer> hotspot;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Integer> noOfSexualActivity;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterDestinationDuration> masterDestinationDuration;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, String> orwCode;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, String> peCode;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterBeneficiaryDeleteReason> deletedReason;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterHrgSecondary> hrgSecondary;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Boolean> isDeleted;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Integer> noYearsInSexWork;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterIDUSubCategory> iduSubCategory;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Integer> lapTreatments;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Long> id;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, String> tiCode;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Integer> alcoholConsDaysInWeek;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterMigrationPattern> migrationPattern;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterFSWSubCategory> fswSubCategory;
	public static volatile SetAttribute<TiBeneficiaryReadOnly, TiBenChildDetailsReadOnly> tiBenChildren;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Long> facilityId;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterMSMSubCategory> msmSubCategory;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, String> otherEmploymentStatus;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Integer> avgNoSexualActsUponReg;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, String> numberOfPartners;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Boolean> consumeAlcohol;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Long> ipcId;
	public static volatile SetAttribute<TiBeneficiaryReadOnly, TiBeneficiaryHotSpotReadOnly> hotspotBenMapping;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, LocalDate> dateOfReg;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Integer> distancePerDay;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, Boolean> sexOtherThanSpouse;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterTruckerOccupation> truckerOccupation;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterRegistrationDoneAt> masterRegistrationDoneAt;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, BeneficiaryReadOnly> beneficiary;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterTGSubCategory> tgSubCategory;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, TiBenExtDetailsReadOnly> tiBeneficiaryExtDetails;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, String> regularPartners;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterMobilityType> masterMobilityType;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterStayingWith> masterStayingWith;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<TiBeneficiaryReadOnly, MasterTiClientStatus> status;

	public static final String MIGRANT_OCCUPATION = "migrantOccupation";
	public static final String IB_TREATMENTS = "ibTreatments";
	public static final String HOTSPOT = "hotspot";
	public static final String NO_OF_SEXUAL_ACTIVITY = "noOfSexualActivity";
	public static final String MASTER_DESTINATION_DURATION = "masterDestinationDuration";
	public static final String ORW_CODE = "orwCode";
	public static final String IS_ACTIVE = "isActive";
	public static final String PE_CODE = "peCode";
	public static final String DELETED_REASON = "deletedReason";
	public static final String HRG_SECONDARY = "hrgSecondary";
	public static final String IS_DELETED = "isDeleted";
	public static final String NO_YEARS_IN_SEX_WORK = "noYearsInSexWork";
	public static final String IDU_SUB_CATEGORY = "iduSubCategory";
	public static final String LAP_TREATMENTS = "lapTreatments";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String ALCOHOL_CONS_DAYS_IN_WEEK = "alcoholConsDaysInWeek";
	public static final String MIGRATION_PATTERN = "migrationPattern";
	public static final String FSW_SUB_CATEGORY = "fswSubCategory";
	public static final String TI_BEN_CHILDREN = "tiBenChildren";
	public static final String FACILITY_ID = "facilityId";
	public static final String MSM_SUB_CATEGORY = "msmSubCategory";
	public static final String OTHER_EMPLOYMENT_STATUS = "otherEmploymentStatus";
	public static final String AVG_NO_SEXUAL_ACTS_UPON_REG = "avgNoSexualActsUponReg";
	public static final String NUMBER_OF_PARTNERS = "numberOfPartners";
	public static final String CONSUME_ALCOHOL = "consumeAlcohol";
	public static final String IPC_ID = "ipcId";
	public static final String HOTSPOT_BEN_MAPPING = "hotspotBenMapping";
	public static final String DATE_OF_REG = "dateOfReg";
	public static final String DISTANCE_PER_DAY = "distancePerDay";
	public static final String SEX_OTHER_THAN_SPOUSE = "sexOtherThanSpouse";
	public static final String TRUCKER_OCCUPATION = "truckerOccupation";
	public static final String MASTER_REGISTRATION_DONE_AT = "masterRegistrationDoneAt";
	public static final String BENEFICIARY = "beneficiary";
	public static final String TG_SUB_CATEGORY = "tgSubCategory";
	public static final String TI_BENEFICIARY_EXT_DETAILS = "tiBeneficiaryExtDetails";
	public static final String REGULAR_PARTNERS = "regularPartners";
	public static final String MASTER_MOBILITY_TYPE = "masterMobilityType";
	public static final String MASTER_STAYING_WITH = "masterStayingWith";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String STATUS = "status";

}

