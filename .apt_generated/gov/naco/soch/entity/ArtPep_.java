package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtPep.class)
public abstract class ArtPep_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtPep, LocalDate> pepStartDate;
	public static volatile SingularAttribute<ArtPep, MasterHivStatus> exposedPersonSeroStatusSixMonths;
	public static volatile SingularAttribute<ArtPep, MasterHivStatus> exposedPersonSeroStatusThreeMonths;
	public static volatile SingularAttribute<ArtPep, String> mobileNumber;
	public static volatile SingularAttribute<ArtPep, String> exposedStaffDesignation;
	public static volatile SingularAttribute<ArtPep, MasterHivSourceStatus> hivSourceStatus;
	public static volatile SingularAttribute<ArtPep, Boolean> isActive;
	public static volatile SingularAttribute<ArtPep, MasterGender> masterGender;
	public static volatile SingularAttribute<ArtPep, Boolean> pepCourseCompleted;
	public static volatile SingularAttribute<ArtPep, LocalDate> registrationDate;
	public static volatile SingularAttribute<ArtPep, MasterPepPrescription> pepPrescription;
	public static volatile SingularAttribute<ArtPep, Long> id;
	public static volatile SingularAttribute<ArtPep, Boolean> baselineTestConductedHbv;
	public static volatile SingularAttribute<ArtPep, MasterHbvStatus> baselineTestConductedHbvResult;
	public static volatile SingularAttribute<ArtPep, Boolean> baselineTestConductedHcv;
	public static volatile SingularAttribute<ArtPep, Boolean> consentTaken;
	public static volatile SingularAttribute<ArtPep, MasterHcvStatus> baselineTestConductedHcvResult;
	public static volatile SingularAttribute<ArtPep, Address> address;
	public static volatile SingularAttribute<ArtPep, Boolean> isDelete;
	public static volatile SingularAttribute<ArtPep, Boolean> baselineTestConductedHiv;
	public static volatile SingularAttribute<ArtPep, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<ArtPep, String> exposedStaffName;
	public static volatile SingularAttribute<ArtPep, UserMaster> entryUser;
	public static volatile SetAttribute<ArtPep, ArtPepDispensation> artPepDispensations;
	public static volatile SingularAttribute<ArtPep, MasterHivExposureCode> hivExposureCode;
	public static volatile SingularAttribute<ArtPep, MasterHivStatus> baselineTestConductedHivResult;
	public static volatile SingularAttribute<ArtPep, MasterExposureSeverity> severityOfExposure;
	public static volatile SingularAttribute<ArtPep, Long> exposedStaffFacilityId;
	public static volatile SingularAttribute<ArtPep, Long> pepCourseDays;
	public static volatile SingularAttribute<ArtPep, String> modeOfInjuryOrExposure;
	public static volatile SingularAttribute<ArtPep, String> pepNumber;
	public static volatile SingularAttribute<ArtPep, LocalDate> dateOfAccidentalExposure;
	public static volatile SingularAttribute<ArtPep, Facility> facility;

	public static final String PEP_START_DATE = "pepStartDate";
	public static final String EXPOSED_PERSON_SERO_STATUS_SIX_MONTHS = "exposedPersonSeroStatusSixMonths";
	public static final String EXPOSED_PERSON_SERO_STATUS_THREE_MONTHS = "exposedPersonSeroStatusThreeMonths";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String EXPOSED_STAFF_DESIGNATION = "exposedStaffDesignation";
	public static final String HIV_SOURCE_STATUS = "hivSourceStatus";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_GENDER = "masterGender";
	public static final String PEP_COURSE_COMPLETED = "pepCourseCompleted";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String PEP_PRESCRIPTION = "pepPrescription";
	public static final String ID = "id";
	public static final String BASELINE_TEST_CONDUCTED_HBV = "baselineTestConductedHbv";
	public static final String BASELINE_TEST_CONDUCTED_HBV_RESULT = "baselineTestConductedHbvResult";
	public static final String BASELINE_TEST_CONDUCTED_HCV = "baselineTestConductedHcv";
	public static final String CONSENT_TAKEN = "consentTaken";
	public static final String BASELINE_TEST_CONDUCTED_HCV_RESULT = "baselineTestConductedHcvResult";
	public static final String ADDRESS = "address";
	public static final String IS_DELETE = "isDelete";
	public static final String BASELINE_TEST_CONDUCTED_HIV = "baselineTestConductedHiv";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String EXPOSED_STAFF_NAME = "exposedStaffName";
	public static final String ENTRY_USER = "entryUser";
	public static final String ART_PEP_DISPENSATIONS = "artPepDispensations";
	public static final String HIV_EXPOSURE_CODE = "hivExposureCode";
	public static final String BASELINE_TEST_CONDUCTED_HIV_RESULT = "baselineTestConductedHivResult";
	public static final String SEVERITY_OF_EXPOSURE = "severityOfExposure";
	public static final String EXPOSED_STAFF_FACILITY_ID = "exposedStaffFacilityId";
	public static final String PEP_COURSE_DAYS = "pepCourseDays";
	public static final String MODE_OF_INJURY_OR_EXPOSURE = "modeOfInjuryOrExposure";
	public static final String PEP_NUMBER = "pepNumber";
	public static final String DATE_OF_ACCIDENTAL_EXPOSURE = "dateOfAccidentalExposure";
	public static final String FACILITY = "facility";

}

