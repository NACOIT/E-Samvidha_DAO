package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NgoProjectTypologyMapping.class)
public abstract class NgoProjectTypologyMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NgoProjectTypologyMapping, Boolean> isDelete;
	public static volatile SingularAttribute<NgoProjectTypologyMapping, Long> id;
	public static volatile SingularAttribute<NgoProjectTypologyMapping, Long> typologyId;
	public static volatile SingularAttribute<NgoProjectTypologyMapping, Boolean> isActive;
	public static volatile SingularAttribute<NgoProjectTypologyMapping, Long> projectId;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TYPOLOGY_ID = "typologyId";
	public static final String IS_ACTIVE = "isActive";
	public static final String PROJECT_ID = "projectId";

}

