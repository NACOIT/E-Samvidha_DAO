package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiarySideEffect.class)
public abstract class ArtBeneficiarySideEffect_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiarySideEffect, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiarySideEffect, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiarySideEffect, Integer> id;
	public static volatile SingularAttribute<ArtBeneficiarySideEffect, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiarySideEffect, MasterSideEffect> masterSideEffect;

	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_SIDE_EFFECT = "masterSideEffect";

}

