package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBeneficiaryTransferReadOnly.class)
public abstract class TiBeneficiaryTransferReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBeneficiaryTransferReadOnly, BeneficiaryTransferReadOnly> beneficiary;
	public static volatile SingularAttribute<TiBeneficiaryTransferReadOnly, Long> id;
	public static volatile SingularAttribute<TiBeneficiaryTransferReadOnly, String> tiCode;
	public static volatile SingularAttribute<TiBeneficiaryTransferReadOnly, TypologyMaster> hrgPrimary;

	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String HRG_PRIMARY = "hrgPrimary";

}

