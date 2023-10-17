package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcBeneficiaryVCReadOnly.class)
public abstract class IctcBeneficiaryVCReadOnly_ {

	public static volatile SingularAttribute<IctcBeneficiaryVCReadOnly, BeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SingularAttribute<IctcBeneficiaryVCReadOnly, String> pid;
	public static volatile SingularAttribute<IctcBeneficiaryVCReadOnly, Long> id;
	public static volatile SingularAttribute<IctcBeneficiaryVCReadOnly, FacilityReadOnly> facility;

	public static final String BENEFICIARY = "beneficiary";
	public static final String PID = "pid";
	public static final String ID = "id";
	public static final String FACILITY = "facility";

}

