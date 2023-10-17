package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SatelliteOstParentOstMapping.class)
public abstract class SatelliteOstParentOstMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<SatelliteOstParentOstMapping, Facility> parentOst;
	public static volatile SingularAttribute<SatelliteOstParentOstMapping, Boolean> mappingStatusFlag;
	public static volatile SingularAttribute<SatelliteOstParentOstMapping, Boolean> isDelete;
	public static volatile SingularAttribute<SatelliteOstParentOstMapping, Long> id;
	public static volatile SingularAttribute<SatelliteOstParentOstMapping, LocalDateTime> mappingDate;
	public static volatile SingularAttribute<SatelliteOstParentOstMapping, Boolean> isActive;
	public static volatile SingularAttribute<SatelliteOstParentOstMapping, Facility> satelliteOst;

	public static final String PARENT_OST = "parentOst";
	public static final String MAPPING_STATUS_FLAG = "mappingStatusFlag";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String MAPPING_DATE = "mappingDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String SATELLITE_OST = "satelliteOst";

}

