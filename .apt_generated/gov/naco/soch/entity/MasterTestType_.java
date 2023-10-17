package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterTestType.class)
public abstract class MasterTestType_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterTestType, String> labType;
	public static volatile SingularAttribute<MasterTestType, Boolean> isDelete;
	public static volatile SingularAttribute<MasterTestType, String> testGroup;
	public static volatile SetAttribute<MasterTestType, LabTestSample> labTestSamples;
	public static volatile SingularAttribute<MasterTestType, String> testType;
	public static volatile SingularAttribute<MasterTestType, Long> id;

	public static final String LAB_TYPE = "labType";
	public static final String IS_DELETE = "isDelete";
	public static final String TEST_GROUP = "testGroup";
	public static final String LAB_TEST_SAMPLES = "labTestSamples";
	public static final String TEST_TYPE = "testType";
	public static final String ID = "id";

}

