package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppointmentPurposeOfVisitMappingEntity.class)
public abstract class AppointmentPurposeOfVisitMappingEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<AppointmentPurposeOfVisitMappingEntity, Long> appointmentId;
	public static volatile SingularAttribute<AppointmentPurposeOfVisitMappingEntity, Long> id;
	public static volatile SingularAttribute<AppointmentPurposeOfVisitMappingEntity, Long> purposeOfVisitId;

	public static final String APPOINTMENT_ID = "appointmentId";
	public static final String ID = "id";
	public static final String PURPOSE_OF_VISIT_ID = "purposeOfVisitId";

}

