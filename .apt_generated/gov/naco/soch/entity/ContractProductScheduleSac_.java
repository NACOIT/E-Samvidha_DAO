package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContractProductScheduleSac.class)
public abstract class ContractProductScheduleSac_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ContractProductScheduleSac, ContractProductSchedule> contractProductSchedule;
	public static volatile SingularAttribute<ContractProductScheduleSac, Boolean> isDelete;
	public static volatile SingularAttribute<ContractProductScheduleSac, Integer> id;
	public static volatile SingularAttribute<ContractProductScheduleSac, Boolean> isActive;
	public static volatile SingularAttribute<ContractProductScheduleSac, Facility> facility;
	public static volatile SetAttribute<ContractProductScheduleSac, ContractProductScheduleSacsLot> contractProductSceduleSacsLots;

	public static final String CONTRACT_PRODUCT_SCHEDULE = "contractProductSchedule";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String CONTRACT_PRODUCT_SCEDULE_SACS_LOTS = "contractProductSceduleSacsLots";

}

