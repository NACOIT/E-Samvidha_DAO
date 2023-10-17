package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DummyMaster.class)
public abstract class DummyMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DummyMaster, LocalDate> dateofbirth;
	public static volatile SingularAttribute<DummyMaster, LocalDateTime> createdDate;
	public static volatile SingularAttribute<DummyMaster, LocalDateTime> submittedTime;
	public static volatile SingularAttribute<DummyMaster, String> name;
	public static volatile SetAttribute<DummyMaster, DummyDetail> dummyDetails;
	public static volatile SingularAttribute<DummyMaster, Long> id;
	public static volatile SingularAttribute<DummyMaster, String> email;

	public static final String DATEOFBIRTH = "dateofbirth";
	public static final String CREATED_DATE = "createdDate";
	public static final String SUBMITTED_TIME = "submittedTime";
	public static final String NAME = "name";
	public static final String DUMMY_DETAILS = "dummyDetails";
	public static final String ID = "id";
	public static final String EMAIL = "email";

}

