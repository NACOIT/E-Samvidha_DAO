package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LabTypesMaster.class)
public abstract class LabTypesMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<LabTypesMaster, ProductLabTypesMapping> productLabTypesMappings;
	public static volatile SingularAttribute<LabTypesMaster, Boolean> isDelete;
	public static volatile SingularAttribute<LabTypesMaster, Long> id;
	public static volatile SingularAttribute<LabTypesMaster, String> labTypeName;

	public static final String PRODUCT_LAB_TYPES_MAPPINGS = "productLabTypesMappings";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String LAB_TYPE_NAME = "labTypeName";

}

