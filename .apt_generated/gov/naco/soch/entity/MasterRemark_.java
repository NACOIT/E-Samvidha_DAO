package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterRemark.class)
public abstract class MasterRemark_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterRemark, Boolean> isDelete;
	public static volatile SetAttribute<MasterRemark, LabTestSample> labTestSamples;
	public static volatile SingularAttribute<MasterRemark, Long> id;
	public static volatile SingularAttribute<MasterRemark, String> remarks;

	public static final String IS_DELETE = "isDelete";
	public static final String LAB_TEST_SAMPLES = "labTestSamples";
	public static final String ID = "id";
	public static final String REMARKS = "remarks";

}

