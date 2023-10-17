package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductDrugLineMaster.class)
public abstract class ProductDrugLineMaster_ {

	public static volatile SingularAttribute<ProductDrugLineMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<ProductDrugLineMaster, Integer> createdBy;
	public static volatile SingularAttribute<ProductDrugLineMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ProductDrugLineMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<ProductDrugLineMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<ProductDrugLineMaster, Long> id;
	public static volatile SingularAttribute<ProductDrugLineMaster, String> productDrugLineCode;
	public static volatile SingularAttribute<ProductDrugLineMaster, Boolean> isActive;
	public static volatile SingularAttribute<ProductDrugLineMaster, String> productDrugLineName;
	public static volatile SetAttribute<ProductDrugLineMaster, Product> products;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String PRODUCT_DRUG_LINE_CODE = "productDrugLineCode";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCT_DRUG_LINE_NAME = "productDrugLineName";
	public static final String PRODUCTS = "products";

}

