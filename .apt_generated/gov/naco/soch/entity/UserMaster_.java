package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserMaster.class)
public abstract class UserMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<UserMaster, String> firstname;
	public static volatile SingularAttribute<UserMaster, String> mobileNumber;
	public static volatile SingularAttribute<UserMaster, Boolean> whatsappEnabled;
	public static volatile SingularAttribute<UserMaster, String> orwCode;
	public static volatile SetAttribute<UserMaster, DispatchReceiptRemark> dispatchReceiptRemarks2;
	public static volatile SetAttribute<UserMaster, ArtDispensation> artDispensations;
	public static volatile SingularAttribute<UserMaster, String> landlineNumber;
	public static volatile SetAttribute<UserMaster, DispatchReceiptRemark> dispatchReceiptRemarks1;
	public static volatile SingularAttribute<UserMaster, String> peCode;
	public static volatile SingularAttribute<UserMaster, Boolean> isActive;
	public static volatile SingularAttribute<UserMaster, Boolean> activeRole;
	public static volatile SingularAttribute<UserMaster, MasterYesOrNo> yesNo;
	public static volatile SingularAttribute<UserMaster, Division> division;
	public static volatile SetAttribute<UserMaster, DispatchStatusTracking> dispatchStatusTrackings;
	public static volatile SingularAttribute<UserMaster, MasterTrainingType> typeOfTraining;
	public static volatile SingularAttribute<UserMaster, LocalDateTime> lastDisclaimerShownDate;
	public static volatile SingularAttribute<UserMaster, UserAuth> userAuths;
	public static volatile SetAttribute<UserMaster, DivisionAdminDivisionMapping> divisionAdminDivisionMappings;
	public static volatile SingularAttribute<UserMaster, Long> id;
	public static volatile SingularAttribute<UserMaster, String> email;
	public static volatile SingularAttribute<UserMaster, String> isBeneficiary;
	public static volatile SetAttribute<UserMaster, TypologyUserMapping> typologyUserMappings;
	public static volatile SetAttribute<UserMaster, OrwPeMapping> peUsers;
	public static volatile SingularAttribute<UserMaster, FacilityType> facilityType;
	public static volatile SingularAttribute<UserMaster, Long> designationId;
	public static volatile SingularAttribute<UserMaster, Boolean> isDelete;
	public static volatile SingularAttribute<UserMaster, LocalDate> lastDateOfTraining;
	public static volatile SetAttribute<UserMaster, OrwPeMapping> orwUsers;
	public static volatile SetAttribute<UserMaster, ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;
	public static volatile SingularAttribute<UserMaster, String> lastname;
	public static volatile SetAttribute<UserMaster, ContractStatusTracking> contractStatusTrackings;
	public static volatile SetAttribute<UserMaster, UserRoleMapping> userRoleMappings;
	public static volatile SingularAttribute<UserMaster, Boolean> smsEnabled;
	public static volatile SingularAttribute<UserMaster, Facility> facility;
	public static volatile SingularAttribute<UserMaster, MasterStatus> status;

	public static final String FIRSTNAME = "firstname";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String WHATSAPP_ENABLED = "whatsappEnabled";
	public static final String ORW_CODE = "orwCode";
	public static final String DISPATCH_RECEIPT_REMARKS2 = "dispatchReceiptRemarks2";
	public static final String ART_DISPENSATIONS = "artDispensations";
	public static final String LANDLINE_NUMBER = "landlineNumber";
	public static final String DISPATCH_RECEIPT_REMARKS1 = "dispatchReceiptRemarks1";
	public static final String PE_CODE = "peCode";
	public static final String IS_ACTIVE = "isActive";
	public static final String ACTIVE_ROLE = "activeRole";
	public static final String YES_NO = "yesNo";
	public static final String DIVISION = "division";
	public static final String DISPATCH_STATUS_TRACKINGS = "dispatchStatusTrackings";
	public static final String TYPE_OF_TRAINING = "typeOfTraining";
	public static final String LAST_DISCLAIMER_SHOWN_DATE = "lastDisclaimerShownDate";
	public static final String USER_AUTHS = "userAuths";
	public static final String DIVISION_ADMIN_DIVISION_MAPPINGS = "divisionAdminDivisionMappings";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String IS_BENEFICIARY = "isBeneficiary";
	public static final String TYPOLOGY_USER_MAPPINGS = "typologyUserMappings";
	public static final String PE_USERS = "peUsers";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String DESIGNATION_ID = "designationId";
	public static final String IS_DELETE = "isDelete";
	public static final String LAST_DATE_OF_TRAINING = "lastDateOfTraining";
	public static final String ORW_USERS = "orwUsers";
	public static final String ART_BENEFICIARY_COUNSELLING_NOTES = "artBeneficiaryCounsellingNotes";
	public static final String LASTNAME = "lastname";
	public static final String CONTRACT_STATUS_TRACKINGS = "contractStatusTrackings";
	public static final String USER_ROLE_MAPPINGS = "userRoleMappings";
	public static final String SMS_ENABLED = "smsEnabled";
	public static final String FACILITY = "facility";
	public static final String STATUS = "status";

}

