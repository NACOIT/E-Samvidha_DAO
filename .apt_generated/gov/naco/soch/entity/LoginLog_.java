package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoginLog.class)
public abstract class LoginLog_ {

	public static volatile SingularAttribute<LoginLog, LocalDateTime> dateTime;
	public static volatile SingularAttribute<LoginLog, UserMaster> userMaster;
	public static volatile SingularAttribute<LoginLog, Long> id;
	public static volatile SingularAttribute<LoginLog, Long> loginStatus;

	public static final String DATE_TIME = "dateTime";
	public static final String USER_MASTER = "userMaster";
	public static final String ID = "id";
	public static final String LOGIN_STATUS = "loginStatus";

}

