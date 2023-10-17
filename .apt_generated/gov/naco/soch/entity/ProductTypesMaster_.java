package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductTypesMaster.class)
public abstract class ProductTypesMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ProductTypesMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ProductTypesMaster, String> productTypeName;
	public static volatile SingularAttribute<ProductTypesMaster, Long> id;
	public static volatile SingularAttribute<ProductTypesMaster, Boolean> isActive;
	public static volatile SetAttribute<ProductTypesMaster, Product> products;

	public static final String IS_DELETE = "isDelete";
	public static final String PRODUCT_TYPE_NAME = "productTypeName";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCTS = "products";

}

