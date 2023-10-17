package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserAuth.class)
public abstract class UserAuth_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<UserAuth, UserMaster> userMaster;
	public static volatile SingularAttribute<UserAuth, LocalDateTime> lastLoginTime;
	public static volatile SingularAttribute<UserAuth, String> otpGenerated;
	public static volatile SingularAttribute<UserAuth, String> password;
	public static volatile SingularAttribute<UserAuth, Boolean> isDelete;
	public static volatile SingularAttribute<UserAuth, Long> id;
	public static volatile SingularAttribute<UserAuth, String> activeToken;
	public static volatile SingularAttribute<UserAuth, Boolean> isActive;
	public static volatile SingularAttribute<UserAuth, String> email;
	public static volatile SingularAttribute<UserAuth, LocalDateTime> otpGeneratedTime;
	public static volatile SingularAttribute<UserAuth, String> username;

	public static final String USER_MASTER = "userMaster";
	public static final String LAST_LOGIN_TIME = "lastLoginTime";
	public static final String OTP_GENERATED = "otpGenerated";
	public static final String PASSWORD = "password";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String ACTIVE_TOKEN = "activeToken";
	public static final String IS_ACTIVE = "isActive";
	public static final String EMAIL = "email";
	public static final String OTP_GENERATED_TIME = "otpGeneratedTime";
	public static final String USERNAME = "username";

}

