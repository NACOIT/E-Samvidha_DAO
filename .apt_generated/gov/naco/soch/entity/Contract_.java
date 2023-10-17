package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contract.class)
public abstract class Contract_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<Contract, Dispatch> dispatches;
	public static volatile SingularAttribute<Contract, ContractStatusMaster> contractStatusMaster;
	public static volatile SingularAttribute<Contract, String> indentNum;
	public static volatile SingularAttribute<Contract, Boolean> isDelete;
	public static volatile SetAttribute<Contract, ContractStatusTracking> contractStatusTrackings;
	public static volatile SingularAttribute<Contract, Long> contractId;
	public static volatile SingularAttribute<Contract, LocalDate> allotmentDate;
	public static volatile SingularAttribute<Contract, Boolean> isActive;
	public static volatile SetAttribute<Contract, ContractProduct> contractProducts;
	public static volatile SingularAttribute<Contract, String> noaNumber;
	public static volatile SingularAttribute<Contract, Facility> facility;

	public static final String DISPATCHES = "dispatches";
	public static final String CONTRACT_STATUS_MASTER = "contractStatusMaster";
	public static final String INDENT_NUM = "indentNum";
	public static final String IS_DELETE = "isDelete";
	public static final String CONTRACT_STATUS_TRACKINGS = "contractStatusTrackings";
	public static final String CONTRACT_ID = "contractId";
	public static final String ALLOTMENT_DATE = "allotmentDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String CONTRACT_PRODUCTS = "contractProducts";
	public static final String NOA_NUMBER = "noaNumber";
	public static final String FACILITY = "facility";

}

