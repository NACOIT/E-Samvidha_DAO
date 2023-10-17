package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcSampleBatch.class)
public abstract class IctcSampleBatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IctcSampleBatch, Boolean> isDeleted;
	public static volatile SingularAttribute<IctcSampleBatch, LocalDateTime> dispatchDate;
	public static volatile SetAttribute<IctcSampleBatch, IctcSampleCollection> sampleCollection;
	public static volatile SingularAttribute<IctcSampleBatch, String> consignmentId;
	public static volatile SingularAttribute<IctcSampleBatch, Long> id;
	public static volatile SingularAttribute<IctcSampleBatch, Boolean> isActive;
	public static volatile SingularAttribute<IctcSampleBatch, Facility> lab;
	public static volatile SingularAttribute<IctcSampleBatch, Long> batchStatus;
	public static volatile SingularAttribute<IctcSampleBatch, Facility> facility;

	public static final String IS_DELETED = "isDeleted";
	public static final String DISPATCH_DATE = "dispatchDate";
	public static final String SAMPLE_COLLECTION = "sampleCollection";
	public static final String CONSIGNMENT_ID = "consignmentId";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String LAB = "lab";
	public static final String BATCH_STATUS = "batchStatus";
	public static final String FACILITY = "facility";

}

