package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBeneficiaryOutRefReadOnly.class)
public abstract class TiBeneficiaryOutRefReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBeneficiaryOutRefReadOnly, BeneficiaryOutRefReadOnly> beneficiary;
	public static volatile SingularAttribute<TiBeneficiaryOutRefReadOnly, Long> id;
	public static volatile SingularAttribute<TiBeneficiaryOutRefReadOnly, TypologyMaster> hrgPrimary;

	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";
	public static final String HRG_PRIMARY = "hrgPrimary";

}

