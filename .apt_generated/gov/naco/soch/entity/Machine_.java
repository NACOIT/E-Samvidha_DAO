package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Machine.class)
public abstract class Machine_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<Machine, LabMachineMapping> labMachineMappings;
	public static volatile SingularAttribute<Machine, Boolean> isDelete;
	public static volatile SingularAttribute<Machine, String> description;
	public static volatile SingularAttribute<Machine, Long> id;
	public static volatile SingularAttribute<Machine, Boolean> isActive;
	public static volatile SingularAttribute<Machine, String> machineName;
	public static volatile SingularAttribute<Machine, String> status;

	public static final String LAB_MACHINE_MAPPINGS = "labMachineMappings";
	public static final String IS_DELETE = "isDelete";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String MACHINE_NAME = "machineName";
	public static final String STATUS = "status";

}

