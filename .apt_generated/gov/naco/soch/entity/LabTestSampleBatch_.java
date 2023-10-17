package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LabTestSampleBatch.class)
public abstract class LabTestSampleBatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<LabTestSampleBatch, UserMaster> artcLabTechUser;
	public static volatile SingularAttribute<LabTestSampleBatch, LocalDateTime> dispatchDate;
	public static volatile SingularAttribute<LabTestSampleBatch, Boolean> isDelete;
	public static volatile SetAttribute<LabTestSampleBatch, LabTestSample> labTestSamples;
	public static volatile SingularAttribute<LabTestSampleBatch, Facility> lab;
	public static volatile SingularAttribute<LabTestSampleBatch, String> bdnSerialNumber;
	public static volatile SingularAttribute<LabTestSampleBatch, Long> rejectedSamples;
	public static volatile SingularAttribute<LabTestSampleBatch, UserMaster> vlLabTechUser;
	public static volatile SingularAttribute<LabTestSampleBatch, Long> acceptedSamples;
	public static volatile SingularAttribute<LabTestSampleBatch, Long> numOfSamples;
	public static volatile SingularAttribute<LabTestSampleBatch, Long> id;
	public static volatile SingularAttribute<LabTestSampleBatch, MasterBatchStatus> masterBatchStatus;
	public static volatile SingularAttribute<LabTestSampleBatch, LocalDateTime> receivedDate;
	public static volatile SingularAttribute<LabTestSampleBatch, Facility> facility;

	public static final String ARTC_LAB_TECH_USER = "artcLabTechUser";
	public static final String DISPATCH_DATE = "dispatchDate";
	public static final String IS_DELETE = "isDelete";
	public static final String LAB_TEST_SAMPLES = "labTestSamples";
	public static final String LAB = "lab";
	public static final String BDN_SERIAL_NUMBER = "bdnSerialNumber";
	public static final String REJECTED_SAMPLES = "rejectedSamples";
	public static final String VL_LAB_TECH_USER = "vlLabTechUser";
	public static final String ACCEPTED_SAMPLES = "acceptedSamples";
	public static final String NUM_OF_SAMPLES = "numOfSamples";
	public static final String ID = "id";
	public static final String MASTER_BATCH_STATUS = "masterBatchStatus";
	public static final String RECEIVED_DATE = "receivedDate";
	public static final String FACILITY = "facility";

}

