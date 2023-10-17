package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcTestResult.class)
public abstract class IctcTestResult_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IctcTestResult, Boolean> isTestedForTb;
	public static volatile SingularAttribute<IctcTestResult, LocalDate> testedDate;
	public static volatile SingularAttribute<IctcTestResult, Boolean> isTestedForSyphilis;
	public static volatile SingularAttribute<IctcTestResult, LocalDate> reportReceivedDate;
	public static volatile SingularAttribute<IctcTestResult, Boolean> isActive;
	public static volatile SingularAttribute<IctcTestResult, IctcBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<IctcTestResult, LocalDate> reportDeliveryDate;
	public static volatile SingularAttribute<IctcTestResult, Long> tbTestResult;
	public static volatile SingularAttribute<IctcTestResult, IctcSampleCollection> sample;
	public static volatile SingularAttribute<IctcTestResult, Long> resultStatus;
	public static volatile SingularAttribute<IctcTestResult, Long> hivType;
	public static volatile SingularAttribute<IctcTestResult, Boolean> isDeleted;
	public static volatile SingularAttribute<IctcTestResult, Long> syphilisTestResult;
	public static volatile SingularAttribute<IctcTestResult, Long> id;
	public static volatile SingularAttribute<IctcTestResult, IctcVisit> visit;
	public static volatile SingularAttribute<IctcTestResult, Long> hivStatus;

	public static final String IS_TESTED_FOR_TB = "isTestedForTb";
	public static final String TESTED_DATE = "testedDate";
	public static final String IS_TESTED_FOR_SYPHILIS = "isTestedForSyphilis";
	public static final String REPORT_RECEIVED_DATE = "reportReceivedDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String REPORT_DELIVERY_DATE = "reportDeliveryDate";
	public static final String TB_TEST_RESULT = "tbTestResult";
	public static final String SAMPLE = "sample";
	public static final String RESULT_STATUS = "resultStatus";
	public static final String HIV_TYPE = "hivType";
	public static final String IS_DELETED = "isDeleted";
	public static final String SYPHILIS_TEST_RESULT = "syphilisTestResult";
	public static final String ID = "id";
	public static final String VISIT = "visit";
	public static final String HIV_STATUS = "hivStatus";

}

