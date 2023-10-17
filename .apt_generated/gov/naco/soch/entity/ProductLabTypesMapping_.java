package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductLabTypesMapping.class)
public abstract class ProductLabTypesMapping_ {

	public static volatile SingularAttribute<ProductLabTypesMapping, LabTypesMaster> labTypesMaster;
	public static volatile SingularAttribute<ProductLabTypesMapping, Product> product;
	public static volatile SingularAttribute<ProductLabTypesMapping, Boolean> isDelete;
	public static volatile SingularAttribute<ProductLabTypesMapping, Integer> id;

	public static final String LAB_TYPES_MASTER = "labTypesMaster";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";

}

