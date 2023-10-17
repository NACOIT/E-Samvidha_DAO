package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenReferral.class)
public abstract class TIBenReferral_ {

	public static volatile SingularAttribute<TIBenReferral, ZonedDateTime> modifiedTime;
	public static volatile SingularAttribute<TIBenReferral, Integer> referredFacility;
	public static volatile SingularAttribute<TIBenReferral, String> transferFrom;
	public static volatile SingularAttribute<TIBenReferral, String> transferStatus;
	public static volatile SingularAttribute<TIBenReferral, String> referralStatus;
	public static volatile SingularAttribute<TIBenReferral, Boolean> isDelete;
	public static volatile SingularAttribute<TIBenReferral, Integer> refferalRequestorId;
	public static volatile SingularAttribute<TIBenReferral, String> transferTo;
	public static volatile SingularAttribute<TIBenReferral, LocalDate> transferDate;
	public static volatile SingularAttribute<TIBenReferral, Boolean> isActive;
	public static volatile SingularAttribute<TIBenReferral, ZonedDateTime> timeOfAppointment;
	public static volatile SingularAttribute<TIBenReferral, Integer> referralFacility;
	public static volatile SingularAttribute<TIBenReferral, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBenReferral, Integer> createdBy;
	public static volatile SingularAttribute<TIBenReferral, ZonedDateTime> createdTime;
	public static volatile SingularAttribute<TIBenReferral, LocalDate> dateOfReferral;
	public static volatile SingularAttribute<TIBenReferral, Integer> modifiedBy;
	public static volatile SingularAttribute<TIBenReferral, Long> id;
	public static volatile SingularAttribute<TIBenReferral, String> hivStatus;
	public static volatile SingularAttribute<TIBenReferral, Integer> isCompleted;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String REFERRED_FACILITY = "referredFacility";
	public static final String TRANSFER_FROM = "transferFrom";
	public static final String TRANSFER_STATUS = "transferStatus";
	public static final String REFERRAL_STATUS = "referralStatus";
	public static final String IS_DELETE = "isDelete";
	public static final String REFFERAL_REQUESTOR_ID = "refferalRequestorId";
	public static final String TRANSFER_TO = "transferTo";
	public static final String TRANSFER_DATE = "transferDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String TIME_OF_APPOINTMENT = "timeOfAppointment";
	public static final String REFERRAL_FACILITY = "referralFacility";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String DATE_OF_REFERRAL = "dateOfReferral";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String HIV_STATUS = "hivStatus";
	public static final String IS_COMPLETED = "isCompleted";

}

