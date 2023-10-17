package gov.naco.soch.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContractProductScheduleSacsLot.class)
public abstract class ContractProductScheduleSacsLot_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<ContractProductScheduleSacsLot, Dispatch> dispatches;
	public static volatile SingularAttribute<ContractProductScheduleSacsLot, Long> quantity;
	public static volatile SingularAttribute<ContractProductScheduleSacsLot, Date> endDate;
	public static volatile SingularAttribute<ContractProductScheduleSacsLot, Boolean> isDelete;
	public static volatile SingularAttribute<ContractProductScheduleSacsLot, Long> id;
	public static volatile SingularAttribute<ContractProductScheduleSacsLot, String> lotNumber;
	public static volatile SingularAttribute<ContractProductScheduleSacsLot, Boolean> isActive;
	public static volatile SingularAttribute<ContractProductScheduleSacsLot, ContractProductScheduleSac> contractProductScheduleSac;
	public static volatile SingularAttribute<ContractProductScheduleSacsLot, Date> startDate;

	public static final String DISPATCHES = "dispatches";
	public static final String QUANTITY = "quantity";
	public static final String END_DATE = "endDate";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String LOT_NUMBER = "lotNumber";
	public static final String IS_ACTIVE = "isActive";
	public static final String CONTRACT_PRODUCT_SCHEDULE_SAC = "contractProductScheduleSac";
	public static final String START_DATE = "startDate";

}

