package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryCoexistingCondition.class)
public abstract class ArtBeneficiaryCoexistingCondition_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryCoexistingCondition, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryCoexistingCondition, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryCoexistingCondition, MasterOtherAilment> masterOtherAilment;
	public static volatile SingularAttribute<ArtBeneficiaryCoexistingCondition, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryCoexistingCondition, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String MASTER_OTHER_AILMENT = "masterOtherAilment";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

