package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IndentStatusMaster.class)
public abstract class IndentStatusMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<IndentStatusMaster, Indent> indents;
	public static volatile SingularAttribute<IndentStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<IndentStatusMaster, Long> id;
	public static volatile SingularAttribute<IndentStatusMaster, Boolean> isActive;
	public static volatile SingularAttribute<IndentStatusMaster, String> status;

	public static final String INDENTS = "indents";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

