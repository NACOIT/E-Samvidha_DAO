package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductRecipientTypeMaster.class)
public abstract class ProductRecipientTypeMaster_ {

	public static volatile SingularAttribute<ProductRecipientTypeMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<ProductRecipientTypeMaster, Integer> createdBy;
	public static volatile SingularAttribute<ProductRecipientTypeMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ProductRecipientTypeMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<ProductRecipientTypeMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<ProductRecipientTypeMaster, String> productRecipientTypeCode;
	public static volatile SingularAttribute<ProductRecipientTypeMaster, Long> id;
	public static volatile SingularAttribute<ProductRecipientTypeMaster, Boolean> isActive;
	public static volatile SingularAttribute<ProductRecipientTypeMaster, String> productRecipientTypeName;
	public static volatile SetAttribute<ProductRecipientTypeMaster, Product> products;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String PRODUCT_RECIPIENT_TYPE_CODE = "productRecipientTypeCode";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCT_RECIPIENT_TYPE_NAME = "productRecipientTypeName";
	public static final String PRODUCTS = "products";

}

