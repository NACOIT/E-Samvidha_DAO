package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TransferReadOnly.class)
public abstract class TransferReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TransferReadOnly, String> transferStatus;
	public static volatile SingularAttribute<TransferReadOnly, FacilityReadOnly> facilityTo;
	public static volatile SingularAttribute<TransferReadOnly, String> destinationFacilityType;
	public static volatile SingularAttribute<TransferReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<TransferReadOnly, String> ostCode;
	public static volatile SingularAttribute<TransferReadOnly, String> dsrcCode;
	public static volatile SingularAttribute<TransferReadOnly, String> pidCode;
	public static volatile SingularAttribute<TransferReadOnly, String> sourceFacilityType;
	public static volatile SingularAttribute<TransferReadOnly, LocalDate> initiationDate;
	public static volatile SingularAttribute<TransferReadOnly, Boolean> isDeleted;
	public static volatile SingularAttribute<TransferReadOnly, BeneficiaryReadOnly> beneficiary;
	public static volatile SingularAttribute<TransferReadOnly, LocalDate> reportingDate;
	public static volatile SingularAttribute<TransferReadOnly, Long> id;
	public static volatile SingularAttribute<TransferReadOnly, String> tiCode;
	public static volatile SingularAttribute<TransferReadOnly, Long> facilityFrom;
	public static volatile SingularAttribute<TransferReadOnly, String> remarks;

	public static final String TRANSFER_STATUS = "transferStatus";
	public static final String FACILITY_TO = "facilityTo";
	public static final String DESTINATION_FACILITY_TYPE = "destinationFacilityType";
	public static final String IS_ACTIVE = "isActive";
	public static final String OST_CODE = "ostCode";
	public static final String DSRC_CODE = "dsrcCode";
	public static final String PID_CODE = "pidCode";
	public static final String SOURCE_FACILITY_TYPE = "sourceFacilityType";
	public static final String INITIATION_DATE = "initiationDate";
	public static final String IS_DELETED = "isDeleted";
	public static final String BENEFICIARY = "beneficiary";
	public static final String REPORTING_DATE = "reportingDate";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String FACILITY_FROM = "facilityFrom";
	public static final String REMARKS = "remarks";

}

