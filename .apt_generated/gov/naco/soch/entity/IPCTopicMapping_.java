package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IPCTopicMapping.class)
public abstract class IPCTopicMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IPCTopicMapping, Boolean> isDelete;
	public static volatile SingularAttribute<IPCTopicMapping, IPCSession> ipcSession;
	public static volatile SingularAttribute<IPCTopicMapping, Long> id;
	public static volatile SingularAttribute<IPCTopicMapping, MasterIPCTopic> ipcTopic;
	public static volatile SingularAttribute<IPCTopicMapping, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String IPC_SESSION = "ipcSession";
	public static final String ID = "id";
	public static final String IPC_TOPIC = "ipcTopic";
	public static final String IS_ACTIVE = "isActive";

}

