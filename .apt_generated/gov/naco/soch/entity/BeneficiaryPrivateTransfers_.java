package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryPrivateTransfers.class)
public abstract class BeneficiaryPrivateTransfers_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryPrivateTransfers, FacilityType> sourceFacilityType;
	public static volatile SingularAttribute<BeneficiaryPrivateTransfers, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryPrivateTransfers, Facility> sourceFacility;
	public static volatile SingularAttribute<BeneficiaryPrivateTransfers, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryPrivateTransfers, Long> id;
	public static volatile SingularAttribute<BeneficiaryPrivateTransfers, LocalDate> transferDate;
	public static volatile SingularAttribute<BeneficiaryPrivateTransfers, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryPrivateTransfers, String> privateFacilityName;

	public static final String SOURCE_FACILITY_TYPE = "sourceFacilityType";
	public static final String BENEFICIARY = "beneficiary";
	public static final String SOURCE_FACILITY = "sourceFacility";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TRANSFER_DATE = "transferDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRIVATE_FACILITY_NAME = "privateFacilityName";

}

