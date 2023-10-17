package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MappingLabFacility.class)
public abstract class MappingLabFacility_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MappingLabFacility, Boolean> isDelete;
	public static volatile SingularAttribute<MappingLabFacility, Long> id;
	public static volatile SingularAttribute<MappingLabFacility, Facility> lab;
	public static volatile SingularAttribute<MappingLabFacility, Facility> facility;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String LAB = "lab";
	public static final String FACILITY = "facility";

}

