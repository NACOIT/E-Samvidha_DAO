package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryAppointment.class)
public abstract class BeneficiaryAppointment_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryAppointment, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryAppointment, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryAppointment, MasterAppointmentStatus> appointmentStatus;
	public static volatile SingularAttribute<BeneficiaryAppointment, Long> facilityTypeId;
	public static volatile SingularAttribute<BeneficiaryAppointment, LocalDateTime> dateOfAppointment;
	public static volatile SingularAttribute<BeneficiaryAppointment, Long> id;
	public static volatile SingularAttribute<BeneficiaryAppointment, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryAppointment, Facility> facility;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String APPOINTMENT_STATUS = "appointmentStatus";
	public static final String FACILITY_TYPE_ID = "facilityTypeId";
	public static final String DATE_OF_APPOINTMENT = "dateOfAppointment";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

