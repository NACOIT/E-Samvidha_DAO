package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContractProductSchedule.class)
public abstract class ContractProductSchedule_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ContractProductSchedule, Double> unitPrice;
	public static volatile SetAttribute<ContractProductSchedule, Dispatch> dispatches;
	public static volatile SingularAttribute<ContractProductSchedule, Long> quantity;
	public static volatile SingularAttribute<ContractProductSchedule, Boolean> isDelete;
	public static volatile SetAttribute<ContractProductSchedule, ContractProductScheduleSac> contractProductScheduleSacs;
	public static volatile SingularAttribute<ContractProductSchedule, Long> id;
	public static volatile SingularAttribute<ContractProductSchedule, String> scheduleNumber;
	public static volatile SingularAttribute<ContractProductSchedule, Boolean> isActive;
	public static volatile SingularAttribute<ContractProductSchedule, ContractProduct> contractProduct;

	public static final String UNIT_PRICE = "unitPrice";
	public static final String DISPATCHES = "dispatches";
	public static final String QUANTITY = "quantity";
	public static final String IS_DELETE = "isDelete";
	public static final String CONTRACT_PRODUCT_SCHEDULE_SACS = "contractProductScheduleSacs";
	public static final String ID = "id";
	public static final String SCHEDULE_NUMBER = "scheduleNumber";
	public static final String IS_ACTIVE = "isActive";
	public static final String CONTRACT_PRODUCT = "contractProduct";

}

