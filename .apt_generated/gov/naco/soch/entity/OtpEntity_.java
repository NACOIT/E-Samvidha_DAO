package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OtpEntity.class)
public abstract class OtpEntity_ {

	public static volatile SingularAttribute<OtpEntity, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<OtpEntity, String> mobileNumber;
	public static volatile SingularAttribute<OtpEntity, Boolean> isDelete;
	public static volatile SingularAttribute<OtpEntity, String> otp;
	public static volatile SingularAttribute<OtpEntity, String> deviceOsType;
	public static volatile SingularAttribute<OtpEntity, Boolean> isActive;
	public static volatile SingularAttribute<OtpEntity, LocalDateTime> otpGeneratedTime;
	public static volatile SingularAttribute<OtpEntity, String> deviceToken;
	public static volatile SingularAttribute<OtpEntity, Integer> createdBy;
	public static volatile SingularAttribute<OtpEntity, LocalDateTime> createdTime;
	public static volatile SingularAttribute<OtpEntity, Integer> modifiedBy;
	public static volatile SingularAttribute<OtpEntity, Long> id;
	public static volatile SingularAttribute<OtpEntity, Long> beneficiaryId;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String IS_DELETE = "isDelete";
	public static final String OTP = "otp";
	public static final String DEVICE_OS_TYPE = "deviceOsType";
	public static final String IS_ACTIVE = "isActive";
	public static final String OTP_GENERATED_TIME = "otpGeneratedTime";
	public static final String DEVICE_TOKEN = "deviceToken";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String BENEFICIARY_ID = "beneficiaryId";

}

