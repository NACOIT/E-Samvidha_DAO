package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterBatchStatus.class)
public abstract class MasterBatchStatus_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<MasterBatchStatus, LabTestSampleBatch> labTestSampleBatches;
	public static volatile SingularAttribute<MasterBatchStatus, Boolean> isDelete;
	public static volatile SingularAttribute<MasterBatchStatus, Long> id;
	public static volatile SingularAttribute<MasterBatchStatus, String> status;

	public static final String LAB_TEST_SAMPLE_BATCHES = "labTestSampleBatches";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

