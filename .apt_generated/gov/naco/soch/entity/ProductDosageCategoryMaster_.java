package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductDosageCategoryMaster.class)
public abstract class ProductDosageCategoryMaster_ {

	public static volatile SingularAttribute<ProductDosageCategoryMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<ProductDosageCategoryMaster, Integer> createdBy;
	public static volatile SingularAttribute<ProductDosageCategoryMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ProductDosageCategoryMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<ProductDosageCategoryMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<ProductDosageCategoryMaster, Long> id;
	public static volatile SingularAttribute<ProductDosageCategoryMaster, Boolean> isActive;
	public static volatile SingularAttribute<ProductDosageCategoryMaster, String> productDosageCategoryName;
	public static volatile SetAttribute<ProductDosageCategoryMaster, ProductDosage> productDosages;
	public static volatile SingularAttribute<ProductDosageCategoryMaster, String> productDosageCategoryCode;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCT_DOSAGE_CATEGORY_NAME = "productDosageCategoryName";
	public static final String PRODUCT_DOSAGES = "productDosages";
	public static final String PRODUCT_DOSAGE_CATEGORY_CODE = "productDosageCategoryCode";

}

