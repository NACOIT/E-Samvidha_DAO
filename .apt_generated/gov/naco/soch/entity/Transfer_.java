package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transfer.class)
public abstract class Transfer_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Transfer, String> transferStatus;
	public static volatile SingularAttribute<Transfer, Facility> facilityTo;
	public static volatile SingularAttribute<Transfer, String> destinationFacilityType;
	public static volatile SingularAttribute<Transfer, TIBeneficiary> tiBeneficiary;
	public static volatile SingularAttribute<Transfer, Boolean> isActive;
	public static volatile SingularAttribute<Transfer, String> ostCode;
	public static volatile SingularAttribute<Transfer, String> dsrcCode;
	public static volatile SingularAttribute<Transfer, String> pidCode;
	public static volatile SingularAttribute<Transfer, String> sourceFacilityType;
	public static volatile SingularAttribute<Transfer, LocalDate> initiationDate;
	public static volatile SingularAttribute<Transfer, Boolean> isDeleted;
	public static volatile SingularAttribute<Transfer, LocalDateTime> acceptedTime;
	public static volatile SingularAttribute<Transfer, Beneficiary> beneficiary;
	public static volatile SingularAttribute<Transfer, String> artCode;
	public static volatile SingularAttribute<Transfer, LocalDate> reportingDate;
	public static volatile SingularAttribute<Transfer, Long> id;
	public static volatile SingularAttribute<Transfer, String> tiCode;
	public static volatile SingularAttribute<Transfer, String> category;
	public static volatile SingularAttribute<Transfer, Facility> facilityFrom;
	public static volatile SingularAttribute<Transfer, String> hivStatus;
	public static volatile SingularAttribute<Transfer, String> remarks;

	public static final String TRANSFER_STATUS = "transferStatus";
	public static final String FACILITY_TO = "facilityTo";
	public static final String DESTINATION_FACILITY_TYPE = "destinationFacilityType";
	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String IS_ACTIVE = "isActive";
	public static final String OST_CODE = "ostCode";
	public static final String DSRC_CODE = "dsrcCode";
	public static final String PID_CODE = "pidCode";
	public static final String SOURCE_FACILITY_TYPE = "sourceFacilityType";
	public static final String INITIATION_DATE = "initiationDate";
	public static final String IS_DELETED = "isDeleted";
	public static final String ACCEPTED_TIME = "acceptedTime";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ART_CODE = "artCode";
	public static final String REPORTING_DATE = "reportingDate";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String CATEGORY = "category";
	public static final String FACILITY_FROM = "facilityFrom";
	public static final String HIV_STATUS = "hivStatus";
	public static final String REMARKS = "remarks";

}

