package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterResultType.class)
public abstract class MasterResultType_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterResultType, String> labType;
	public static volatile SingularAttribute<MasterResultType, Boolean> isDelete;
	public static volatile SetAttribute<MasterResultType, LabTestSample> labTestSamples;
	public static volatile SingularAttribute<MasterResultType, Long> id;
	public static volatile SingularAttribute<MasterResultType, String> resultType;

	public static final String LAB_TYPE = "labType";
	public static final String IS_DELETE = "isDelete";
	public static final String LAB_TEST_SAMPLES = "labTestSamples";
	public static final String ID = "id";
	public static final String RESULT_TYPE = "resultType";

}

