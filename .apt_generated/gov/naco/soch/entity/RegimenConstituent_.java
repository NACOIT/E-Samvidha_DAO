package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegimenConstituent.class)
public abstract class RegimenConstituent_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<RegimenConstituent, Product> product;
	public static volatile SingularAttribute<RegimenConstituent, Integer> quantity;
	public static volatile SingularAttribute<RegimenConstituent, Boolean> isDelete;
	public static volatile SingularAttribute<RegimenConstituent, ProductUomMaster> productUomMaster;
	public static volatile SingularAttribute<RegimenConstituent, Long> id;
	public static volatile SingularAttribute<RegimenConstituent, Boolean> isActive;
	public static volatile SingularAttribute<RegimenConstituent, Regimen> regimen;

	public static final String PRODUCT = "product";
	public static final String QUANTITY = "quantity";
	public static final String IS_DELETE = "isDelete";
	public static final String PRODUCT_UOM_MASTER = "productUomMaster";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String REGIMEN = "regimen";

}

