package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryOpportunisticInfection.class)
public abstract class ArtBeneficiaryOpportunisticInfection_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryOpportunisticInfection, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryOpportunisticInfection, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryOpportunisticInfection, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryOpportunisticInfection, MasterOpportunisticInfection> masterOpportunisticInfection;
	public static volatile SingularAttribute<ArtBeneficiaryOpportunisticInfection, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String ID = "id";
	public static final String MASTER_OPPORTUNISTIC_INFECTION = "masterOpportunisticInfection";
	public static final String IS_ACTIVE = "isActive";

}

