package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterSampleStatus.class)
public abstract class MasterSampleStatus_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterSampleStatus, Boolean> isDelete;
	public static volatile SetAttribute<MasterSampleStatus, LabTestSample> labTestSamples;
	public static volatile SingularAttribute<MasterSampleStatus, Long> id;
	public static volatile SingularAttribute<MasterSampleStatus, Boolean> isSelectable;
	public static volatile SingularAttribute<MasterSampleStatus, String> status;

	public static final String IS_DELETE = "isDelete";
	public static final String LAB_TEST_SAMPLES = "labTestSamples";
	public static final String ID = "id";
	public static final String IS_SELECTABLE = "isSelectable";
	public static final String STATUS = "status";

}

