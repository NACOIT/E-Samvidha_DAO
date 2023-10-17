package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterCmssROStatus.class)
public abstract class MasterCmssROStatus_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterCmssROStatus, Boolean> isDelete;
	public static volatile SingularAttribute<MasterCmssROStatus, Long> id;
	public static volatile SingularAttribute<MasterCmssROStatus, Boolean> isActive;
	public static volatile SingularAttribute<MasterCmssROStatus, String> status;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

