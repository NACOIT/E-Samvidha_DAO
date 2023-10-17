package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Hiv2LabTestDetails.class)
public abstract class Hiv2LabTestDetails_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Hiv2LabTestDetails, Beneficiary> beneficiary;
	public static volatile SingularAttribute<Hiv2LabTestDetails, MasterHivType> hivType;
	public static volatile SingularAttribute<Hiv2LabTestDetails, MasterHiv2LabResultStatus> hiv2LabResultStatusId;
	public static volatile SingularAttribute<Hiv2LabTestDetails, Facility> hiv2LabFacility;
	public static volatile SingularAttribute<Hiv2LabTestDetails, Boolean> isDelete;
	public static volatile SingularAttribute<Hiv2LabTestDetails, LocalDate> resultDate;
	public static volatile SingularAttribute<Hiv2LabTestDetails, String> pid;
	public static volatile SingularAttribute<Hiv2LabTestDetails, Long> id;
	public static volatile SingularAttribute<Hiv2LabTestDetails, IctcBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<Hiv2LabTestDetails, Boolean> isActive;
	public static volatile SingularAttribute<Hiv2LabTestDetails, Facility> facility;

	public static final String BENEFICIARY = "beneficiary";
	public static final String HIV_TYPE = "hivType";
	public static final String HIV2_LAB_RESULT_STATUS_ID = "hiv2LabResultStatusId";
	public static final String HIV2_LAB_FACILITY = "hiv2LabFacility";
	public static final String IS_DELETE = "isDelete";
	public static final String RESULT_DATE = "resultDate";
	public static final String PID = "pid";
	public static final String ID = "id";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

