package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TransporterSacsMapping.class)
public abstract class TransporterSacsMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TransporterSacsMapping, Boolean> mappingStatusFlag;
	public static volatile SingularAttribute<TransporterSacsMapping, Boolean> isDelete;
	public static volatile SingularAttribute<TransporterSacsMapping, Facility> transporter;
	public static volatile SingularAttribute<TransporterSacsMapping, Long> id;
	public static volatile SingularAttribute<TransporterSacsMapping, LocalDate> mappingDate;
	public static volatile SingularAttribute<TransporterSacsMapping, Facility> sacs;
	public static volatile SingularAttribute<TransporterSacsMapping, Boolean> isActive;

	public static final String MAPPING_STATUS_FLAG = "mappingStatusFlag";
	public static final String IS_DELETE = "isDelete";
	public static final String TRANSPORTER = "transporter";
	public static final String ID = "id";
	public static final String MAPPING_DATE = "mappingDate";
	public static final String SACS = "sacs";
	public static final String IS_ACTIVE = "isActive";

}

