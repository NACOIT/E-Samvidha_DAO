package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SampleTest.class)
public abstract class SampleTest_ {

	public static volatile SingularAttribute<SampleTest, Date> dateofbirth;
	public static volatile SingularAttribute<SampleTest, Timestamp> submittedTime;
	public static volatile SingularAttribute<SampleTest, String> name;
	public static volatile SingularAttribute<SampleTest, Timestamp> createdTime;
	public static volatile SingularAttribute<SampleTest, Integer> id;
	public static volatile SingularAttribute<SampleTest, String> email;
	public static volatile SingularAttribute<SampleTest, String> status;

	public static final String DATEOFBIRTH = "dateofbirth";
	public static final String SUBMITTED_TIME = "submittedTime";
	public static final String NAME = "name";
	public static final String CREATED_TIME = "createdTime";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String STATUS = "status";

}

