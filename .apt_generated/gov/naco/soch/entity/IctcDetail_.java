package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcDetail.class)
public abstract class IctcDetail_ {

	public static volatile SingularAttribute<IctcDetail, Timestamp> modifiedTime;
	public static volatile SingularAttribute<IctcDetail, String> hivTestType;
	public static volatile SingularAttribute<IctcDetail, Beneficiary> beneficiary;
	public static volatile SingularAttribute<IctcDetail, Integer> createdBy;
	public static volatile SingularAttribute<IctcDetail, String> patientPid;
	public static volatile SingularAttribute<IctcDetail, Boolean> isDelete;
	public static volatile SingularAttribute<IctcDetail, Timestamp> createdTime;
	public static volatile SingularAttribute<IctcDetail, Integer> modifiedBy;
	public static volatile SingularAttribute<IctcDetail, Integer> id;
	public static volatile SingularAttribute<IctcDetail, Boolean> isActive;
	public static volatile SingularAttribute<IctcDetail, LocalDate> hivTestDate;
	public static volatile SingularAttribute<IctcDetail, String> ictcCenters;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String HIV_TEST_TYPE = "hivTestType";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CREATED_BY = "createdBy";
	public static final String PATIENT_PID = "patientPid";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String HIV_TEST_DATE = "hivTestDate";
	public static final String ICTC_CENTERS = "ictcCenters";

}

