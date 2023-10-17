package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductUomMaster.class)
public abstract class ProductUomMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ProductUomMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ProductUomMaster, String> uomName;
	public static volatile SingularAttribute<ProductUomMaster, Long> id;
	public static volatile SingularAttribute<ProductUomMaster, Boolean> isActive;
	public static volatile SetAttribute<ProductUomMaster, Product> products;

	public static final String IS_DELETE = "isDelete";
	public static final String UOM_NAME = "uomName";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCTS = "products";

}

