package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IndentProduct.class)
public abstract class IndentProduct_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IndentProduct, Product> product;
	public static volatile SingularAttribute<IndentProduct, Indent> indent;
	public static volatile SingularAttribute<IndentProduct, Boolean> isDelete;
	public static volatile SingularAttribute<IndentProduct, Long> id;
	public static volatile SingularAttribute<IndentProduct, Boolean> isActive;
	public static volatile SetAttribute<IndentProduct, IndentProductSchedule> indentProductSchedules;

	public static final String PRODUCT = "product";
	public static final String INDENT = "indent";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String INDENT_PRODUCT_SCHEDULES = "indentProductSchedules";

}

