package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterQmsTestStatus.class)
public abstract class MasterQmsTestStatus_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterQmsTestStatus, String> code;
	public static volatile SingularAttribute<MasterQmsTestStatus, Boolean> isDelete;
	public static volatile SingularAttribute<MasterQmsTestStatus, String> name;
	public static volatile SingularAttribute<MasterQmsTestStatus, String> description;
	public static volatile SingularAttribute<MasterQmsTestStatus, Long> id;
	public static volatile SingularAttribute<MasterQmsTestStatus, Boolean> isActive;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

