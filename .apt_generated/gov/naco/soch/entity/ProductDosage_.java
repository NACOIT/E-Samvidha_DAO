package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductDosage.class)
public abstract class ProductDosage_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ProductDosage, Product> product;
	public static volatile SingularAttribute<ProductDosage, Boolean> isDelete;
	public static volatile SingularAttribute<ProductDosage, MasterWeightBand> masterWeightBand;
	public static volatile SingularAttribute<ProductDosage, ProductDosageCategoryMaster> productDosageCategoryMaster;
	public static volatile SingularAttribute<ProductDosage, Float> dosageQtyPerMonth;
	public static volatile SingularAttribute<ProductDosage, Long> id;
	public static volatile SingularAttribute<ProductDosage, Boolean> isActive;
	public static volatile SingularAttribute<ProductDosage, String> status;

	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String MASTER_WEIGHT_BAND = "masterWeightBand";
	public static final String PRODUCT_DOSAGE_CATEGORY_MASTER = "productDosageCategoryMaster";
	public static final String DOSAGE_QTY_PER_MONTH = "dosageQtyPerMonth";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

