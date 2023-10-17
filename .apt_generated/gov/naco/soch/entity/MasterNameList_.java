package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterNameList.class)
public abstract class MasterNameList_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterNameList, String> saveEndpoint;
	public static volatile SingularAttribute<MasterNameList, Boolean> isDelete;
	public static volatile SingularAttribute<MasterNameList, Integer> masterType;
	public static volatile SingularAttribute<MasterNameList, Long> id;
	public static volatile SingularAttribute<MasterNameList, Boolean> isActive;
	public static volatile SingularAttribute<MasterNameList, String> fetchEndpoint;
	public static volatile SingularAttribute<MasterNameList, String> masterDescription;
	public static volatile SingularAttribute<MasterNameList, String> masterName;

	public static final String SAVE_ENDPOINT = "saveEndpoint";
	public static final String IS_DELETE = "isDelete";
	public static final String MASTER_TYPE = "masterType";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FETCH_ENDPOINT = "fetchEndpoint";
	public static final String MASTER_DESCRIPTION = "masterDescription";
	public static final String MASTER_NAME = "masterName";

}

