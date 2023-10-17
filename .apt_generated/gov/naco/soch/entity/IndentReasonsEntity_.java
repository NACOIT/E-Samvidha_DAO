package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IndentReasonsEntity.class)
public abstract class IndentReasonsEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IndentReasonsEntity, String> indentReasonsName;
	public static volatile SingularAttribute<IndentReasonsEntity, Boolean> is_active;
	public static volatile SingularAttribute<IndentReasonsEntity, Integer> id;
	public static volatile SingularAttribute<IndentReasonsEntity, Boolean> is_delete;

	public static final String INDENT_REASONS_NAME = "indentReasonsName";
	public static final String IS_ACTIVE = "is_active";
	public static final String ID = "id";
	public static final String IS_DELETE = "is_delete";

}

