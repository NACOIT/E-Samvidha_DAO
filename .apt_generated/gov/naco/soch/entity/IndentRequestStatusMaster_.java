package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IndentRequestStatusMaster.class)
public abstract class IndentRequestStatusMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IndentRequestStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<IndentRequestStatusMaster, Long> id;
	public static volatile SingularAttribute<IndentRequestStatusMaster, String> indentRequestStatusName;
	public static volatile SingularAttribute<IndentRequestStatusMaster, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String INDENT_REQUEST_STATUS_NAME = "indentRequestStatusName";
	public static final String IS_ACTIVE = "isActive";

}

