package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TownReadOnly.class)
public abstract class TownReadOnly_ {

	public static volatile SingularAttribute<TownReadOnly, String> townName;
	public static volatile SingularAttribute<TownReadOnly, String> townCode;
	public static volatile SingularAttribute<TownReadOnly, Long> townId;

	public static final String TOWN_NAME = "townName";
	public static final String TOWN_CODE = "townCode";
	public static final String TOWN_ID = "townId";

}

