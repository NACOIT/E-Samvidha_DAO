package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DummyDetail.class)
public abstract class DummyDetail_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DummyDetail, String> address;
	public static volatile SingularAttribute<DummyDetail, DummyMaster> dummyMaster;
	public static volatile SingularAttribute<DummyDetail, String> mobile;
	public static volatile SingularAttribute<DummyDetail, Long> id;

	public static final String ADDRESS = "address";
	public static final String DUMMY_MASTER = "dummyMaster";
	public static final String MOBILE = "mobile";
	public static final String ID = "id";

}

