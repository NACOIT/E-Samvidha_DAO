package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBenExtDetailsReadOnly.class)
public abstract class TiBenExtDetailsReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> referredFacility;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Long> facilityId;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> withinTheDistrictNoOfDays;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> outsideTheStateNoOfTimes;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> referralStatus;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Boolean> isOutwardReferal;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> withinTheDistrictNoOfTimes;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Boolean> fridayAvbl;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Boolean> sundayAvbl;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> guardianContactNumber;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Boolean> thursdayAvbl;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> relation;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> withinTheStateNoOfDays;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Boolean> wednesdayAvbl;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> withinTheStateNoOfTimes;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> referredTo;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, TiBeneficiaryReadOnly> beneficiary;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> guardianName;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Boolean> tuesdayAvbl;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Long> id;
	public static volatile SetAttribute<TiBenExtDetailsReadOnly, ExtDetailsTimeAvailabilityReadOnly> extDetailsTimeAvailabilityMapping;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, String> outsideTheStateNoOfDays;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Boolean> saturdayAvbl;
	public static volatile SingularAttribute<TiBenExtDetailsReadOnly, Boolean> mondayAvbl;

	public static final String REFERRED_FACILITY = "referredFacility";
	public static final String FACILITY_ID = "facilityId";
	public static final String WITHIN_THE_DISTRICT_NO_OF_DAYS = "withinTheDistrictNoOfDays";
	public static final String OUTSIDE_THE_STATE_NO_OF_TIMES = "outsideTheStateNoOfTimes";
	public static final String REFERRAL_STATUS = "referralStatus";
	public static final String IS_OUTWARD_REFERAL = "isOutwardReferal";
	public static final String WITHIN_THE_DISTRICT_NO_OF_TIMES = "withinTheDistrictNoOfTimes";
	public static final String FRIDAY_AVBL = "fridayAvbl";
	public static final String SUNDAY_AVBL = "sundayAvbl";
	public static final String GUARDIAN_CONTACT_NUMBER = "guardianContactNumber";
	public static final String THURSDAY_AVBL = "thursdayAvbl";
	public static final String RELATION = "relation";
	public static final String WITHIN_THE_STATE_NO_OF_DAYS = "withinTheStateNoOfDays";
	public static final String WEDNESDAY_AVBL = "wednesdayAvbl";
	public static final String WITHIN_THE_STATE_NO_OF_TIMES = "withinTheStateNoOfTimes";
	public static final String REFERRED_TO = "referredTo";
	public static final String BENEFICIARY = "beneficiary";
	public static final String GUARDIAN_NAME = "guardianName";
	public static final String TUESDAY_AVBL = "tuesdayAvbl";
	public static final String ID = "id";
	public static final String EXT_DETAILS_TIME_AVAILABILITY_MAPPING = "extDetailsTimeAvailabilityMapping";
	public static final String OUTSIDE_THE_STATE_NO_OF_DAYS = "outsideTheStateNoOfDays";
	public static final String SATURDAY_AVBL = "saturdayAvbl";
	public static final String MONDAY_AVBL = "mondayAvbl";

}

