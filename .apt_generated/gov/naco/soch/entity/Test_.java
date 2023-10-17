package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Test.class)
public abstract class Test_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Test, String> testingCenter;
	public static volatile SingularAttribute<Test, Boolean> isDelete;
	public static volatile SingularAttribute<Test, String> collectionCenter;
	public static volatile SetAttribute<Test, LabTestSample> labTestSamples;
	public static volatile SingularAttribute<Test, Long> id;
	public static volatile SingularAttribute<Test, Boolean> isBarcodeRequired;
	public static volatile SingularAttribute<Test, Boolean> isActive;
	public static volatile SingularAttribute<Test, String> status;
	public static volatile SingularAttribute<Test, String> typeOfTest;

	public static final String TESTING_CENTER = "testingCenter";
	public static final String IS_DELETE = "isDelete";
	public static final String COLLECTION_CENTER = "collectionCenter";
	public static final String LAB_TEST_SAMPLES = "labTestSamples";
	public static final String ID = "id";
	public static final String IS_BARCODE_REQUIRED = "isBarcodeRequired";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";
	public static final String TYPE_OF_TEST = "typeOfTest";

}

