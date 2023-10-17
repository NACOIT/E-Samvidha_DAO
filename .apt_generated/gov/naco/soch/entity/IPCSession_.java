package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IPCSession.class)
public abstract class IPCSession_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IPCSession, Long> facilityId;
	public static volatile SingularAttribute<IPCSession, Address> address;
	public static volatile SingularAttribute<IPCSession, LocalDate> sessionDate;
	public static volatile SetAttribute<IPCSession, IPCTopicMapping> ipcTopics;
	public static volatile SingularAttribute<IPCSession, Boolean> isDelete;
	public static volatile SingularAttribute<IPCSession, String> orwCode;
	public static volatile SingularAttribute<IPCSession, String> ipcCode;
	public static volatile SingularAttribute<IPCSession, Long> id;
	public static volatile SingularAttribute<IPCSession, Integer> hrgCovered;
	public static volatile SingularAttribute<IPCSession, Boolean> isActive;
	public static volatile SingularAttribute<IPCSession, String> peCode;

	public static final String FACILITY_ID = "facilityId";
	public static final String ADDRESS = "address";
	public static final String SESSION_DATE = "sessionDate";
	public static final String IPC_TOPICS = "ipcTopics";
	public static final String IS_DELETE = "isDelete";
	public static final String ORW_CODE = "orwCode";
	public static final String IPC_CODE = "ipcCode";
	public static final String ID = "id";
	public static final String HRG_COVERED = "hrgCovered";
	public static final String IS_ACTIVE = "isActive";
	public static final String PE_CODE = "peCode";

}

