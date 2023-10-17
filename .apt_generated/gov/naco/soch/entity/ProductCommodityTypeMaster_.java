package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductCommodityTypeMaster.class)
public abstract class ProductCommodityTypeMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ProductCommodityTypeMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ProductCommodityTypeMaster, Long> id;
	public static volatile SingularAttribute<ProductCommodityTypeMaster, Boolean> isActive;
	public static volatile SingularAttribute<ProductCommodityTypeMaster, String> productCommodityTypeCode;
	public static volatile SingularAttribute<ProductCommodityTypeMaster, String> productCommodityTypeName;
	public static volatile SetAttribute<ProductCommodityTypeMaster, Product> products;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCT_COMMODITY_TYPE_CODE = "productCommodityTypeCode";
	public static final String PRODUCT_COMMODITY_TYPE_NAME = "productCommodityTypeName";
	public static final String PRODUCTS = "products";

}

