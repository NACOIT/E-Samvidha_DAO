package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GitStatusMaster.class)
public abstract class GitStatusMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<GitStatusMaster, String> gitStatusName;
	public static volatile SingularAttribute<GitStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<GitStatusMaster, Long> id;
	public static volatile SingularAttribute<GitStatusMaster, Boolean> isActive;

	public static final String GIT_STATUS_NAME = "gitStatusName";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

