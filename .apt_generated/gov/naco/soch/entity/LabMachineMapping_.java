package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LabMachineMapping.class)
public abstract class LabMachineMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<LabMachineMapping, Boolean> isDelete;
	public static volatile SingularAttribute<LabMachineMapping, Machine> machine;
	public static volatile SingularAttribute<LabMachineMapping, Long> id;
	public static volatile SingularAttribute<LabMachineMapping, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String MACHINE = "machine";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

