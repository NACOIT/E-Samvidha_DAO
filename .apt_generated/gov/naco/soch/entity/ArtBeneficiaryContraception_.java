package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryContraception.class)
public abstract class ArtBeneficiaryContraception_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryContraception, MasterContraception> masterContraception;
	public static volatile SingularAttribute<ArtBeneficiaryContraception, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryContraception, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryContraception, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryContraception, Boolean> isActive;

	public static final String MASTER_CONTRACEPTION = "masterContraception";
	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

