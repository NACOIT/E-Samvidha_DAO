package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BenRefScrDetails.class)
public abstract class BenRefScrDetails_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BenRefScrDetails, MasterInfectionType> infection;
	public static volatile SingularAttribute<BenRefScrDetails, BeneficiaryReferralOutRefReadOnly> beneficiaryReferral;
	public static volatile SingularAttribute<BenRefScrDetails, Long> id;

	public static final String INFECTION = "infection";
	public static final String BENEFICIARY_REFERRAL = "beneficiaryReferral";
	public static final String ID = "id";

}

