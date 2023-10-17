package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiarySocialWelfareScheme.class)
public abstract class BeneficiarySocialWelfareScheme_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiarySocialWelfareScheme, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiarySocialWelfareScheme, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiarySocialWelfareScheme, Long> id;
	public static volatile SingularAttribute<BeneficiarySocialWelfareScheme, MasterSocialWelfare> masterSocialWelfare;
	public static volatile SingularAttribute<BeneficiarySocialWelfareScheme, Boolean> isActive;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String MASTER_SOCIAL_WELFARE = "masterSocialWelfare";
	public static final String IS_ACTIVE = "isActive";

}

