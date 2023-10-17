package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIHotspot.class)
public abstract class TIHotspot_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIHotspot, TypologyMaster> typology;
	public static volatile SingularAttribute<TIHotspot, Boolean> isDelete;
	public static volatile SingularAttribute<TIHotspot, String> hotspotStatus;
	public static volatile SingularAttribute<TIHotspot, Long> id;
	public static volatile SingularAttribute<TIHotspot, String> hotspotCode;
	public static volatile SingularAttribute<TIHotspot, Boolean> isActive;
	public static volatile SingularAttribute<TIHotspot, Facility> facility;
	public static volatile SingularAttribute<TIHotspot, Address> hotspotAddress;
	public static volatile SingularAttribute<TIHotspot, String> hotspotName;
	public static volatile SingularAttribute<TIHotspot, String> status;

	public static final String TYPOLOGY = "typology";
	public static final String IS_DELETE = "isDelete";
	public static final String HOTSPOT_STATUS = "hotspotStatus";
	public static final String ID = "id";
	public static final String HOTSPOT_CODE = "hotspotCode";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String HOTSPOT_ADDRESS = "hotspotAddress";
	public static final String HOTSPOT_NAME = "hotspotName";
	public static final String STATUS = "status";

}

