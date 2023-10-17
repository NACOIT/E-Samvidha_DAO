package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcSampleCollection.class)
public abstract class IctcSampleCollection_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile ListAttribute<IctcSampleCollection, IctcTestResult> ictcTestResult;
	public static volatile SingularAttribute<IctcSampleCollection, Boolean> isEighteenPlus;
	public static volatile SingularAttribute<IctcSampleCollection, LocalDateTime> sampleCollectionDate;
	public static volatile SingularAttribute<IctcSampleCollection, Boolean> isDispatched;
	public static volatile SingularAttribute<IctcSampleCollection, IctcSampleBatch> batch;
	public static volatile SingularAttribute<IctcSampleCollection, Long> testType;
	public static volatile SingularAttribute<IctcSampleCollection, Boolean> isActive;
	public static volatile SingularAttribute<IctcSampleCollection, IctcBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<IctcSampleCollection, Long> sampleCollectionStatus;
	public static volatile SingularAttribute<IctcSampleCollection, Boolean> isDeleted;
	public static volatile SingularAttribute<IctcSampleCollection, LocalDateTime> sampleReceivedDate;
	public static volatile SingularAttribute<IctcSampleCollection, Long> id;
	public static volatile SingularAttribute<IctcSampleCollection, IctcVisit> visit;
	public static volatile SingularAttribute<IctcSampleCollection, String> barcode;
	public static volatile SingularAttribute<IctcSampleCollection, Facility> facility;

	public static final String ICTC_TEST_RESULT = "ictcTestResult";
	public static final String IS_EIGHTEEN_PLUS = "isEighteenPlus";
	public static final String SAMPLE_COLLECTION_DATE = "sampleCollectionDate";
	public static final String IS_DISPATCHED = "isDispatched";
	public static final String BATCH = "batch";
	public static final String TEST_TYPE = "testType";
	public static final String IS_ACTIVE = "isActive";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String SAMPLE_COLLECTION_STATUS = "sampleCollectionStatus";
	public static final String IS_DELETED = "isDeleted";
	public static final String SAMPLE_RECEIVED_DATE = "sampleReceivedDate";
	public static final String ID = "id";
	public static final String VISIT = "visit";
	public static final String BARCODE = "barcode";
	public static final String FACILITY = "facility";

}

