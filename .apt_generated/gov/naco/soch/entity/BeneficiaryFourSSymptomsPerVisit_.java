package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFourSSymptomsPerVisit.class)
public abstract class BeneficiaryFourSSymptomsPerVisit_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryFourSSymptomsPerVisit, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryFourSSymptomsPerVisit, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<BeneficiaryFourSSymptomsPerVisit, Long> id;
	public static volatile SingularAttribute<BeneficiaryFourSSymptomsPerVisit, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryFourSSymptomsPerVisit, MasterFourSsymptom> masterFourSSymptom;

	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_FOUR_SSYMPTOM = "masterFourSSymptom";

}

