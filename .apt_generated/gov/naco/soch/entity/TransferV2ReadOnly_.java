package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TransferV2ReadOnly.class)
public abstract class TransferV2ReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TransferV2ReadOnly, String> transferStatus;
	public static volatile SingularAttribute<TransferV2ReadOnly, FacilityReadOnly> facilityTo;
	public static volatile SingularAttribute<TransferV2ReadOnly, BeneficiaryV2ReadOnly> beneficiary;
	public static volatile SingularAttribute<TransferV2ReadOnly, Long> id;
	public static volatile SingularAttribute<TransferV2ReadOnly, FacilityReadOnly> facilityFrom;

	public static final String TRANSFER_STATUS = "transferStatus";
	public static final String FACILITY_TO = "facilityTo";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";
	public static final String FACILITY_FROM = "facilityFrom";

}

