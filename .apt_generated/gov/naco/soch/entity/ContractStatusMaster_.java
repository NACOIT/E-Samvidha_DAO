package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContractStatusMaster.class)
public abstract class ContractStatusMaster_ {

	public static volatile SingularAttribute<ContractStatusMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<ContractStatusMaster, Integer> createdBy;
	public static volatile SingularAttribute<ContractStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ContractStatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<ContractStatusMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<ContractStatusMaster, Long> id;
	public static volatile SingularAttribute<ContractStatusMaster, Boolean> isActive;
	public static volatile SetAttribute<ContractStatusMaster, Contract> contracts;
	public static volatile SingularAttribute<ContractStatusMaster, String> status;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String CONTRACTS = "contracts";
	public static final String STATUS = "status";

}

