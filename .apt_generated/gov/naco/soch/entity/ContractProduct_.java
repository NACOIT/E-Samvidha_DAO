package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContractProduct.class)
public abstract class ContractProduct_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<ContractProduct, ContractProductSchedule> contractProductSchedules;
	public static volatile SingularAttribute<ContractProduct, Product> product;
	public static volatile SetAttribute<ContractProduct, Dispatch> dispatches;
	public static volatile SingularAttribute<ContractProduct, Boolean> isDelete;
	public static volatile SingularAttribute<ContractProduct, Contract> contract;
	public static volatile SingularAttribute<ContractProduct, Long> id;
	public static volatile SingularAttribute<ContractProduct, Boolean> isActive;

	public static final String CONTRACT_PRODUCT_SCHEDULES = "contractProductSchedules";
	public static final String PRODUCT = "product";
	public static final String DISPATCHES = "dispatches";
	public static final String IS_DELETE = "isDelete";
	public static final String CONTRACT = "contract";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

