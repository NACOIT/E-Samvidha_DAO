package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TransferMiniProfile.class)
public abstract class TransferMiniProfile_ {

	public static volatile SingularAttribute<TransferMiniProfile, FacilityMiniProfile> facilityTo;
	public static volatile SingularAttribute<TransferMiniProfile, String> transferStatus;
	public static volatile SingularAttribute<TransferMiniProfile, Boolean> isDeleted;
	public static volatile SingularAttribute<TransferMiniProfile, BeneficiaryMiniProfile> beneficiary;
	public static volatile SingularAttribute<TransferMiniProfile, LocalDateTime> acceptedTime;
	public static volatile SingularAttribute<TransferMiniProfile, Long> id;
	public static volatile SingularAttribute<TransferMiniProfile, Boolean> isActive;
	public static volatile SingularAttribute<TransferMiniProfile, FacilityMiniProfile> facilityFrom;

	public static final String FACILITY_TO = "facilityTo";
	public static final String TRANSFER_STATUS = "transferStatus";
	public static final String IS_DELETED = "isDeleted";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ACCEPTED_TIME = "acceptedTime";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_FROM = "facilityFrom";

}

