package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstBeneficiaryTransferReadOnly.class)
public abstract class TiOstBeneficiaryTransferReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstBeneficiaryTransferReadOnly, BeneficiaryTransferReadOnly> beneficiary;
	public static volatile SingularAttribute<TiOstBeneficiaryTransferReadOnly, String> ostNumber;
	public static volatile SingularAttribute<TiOstBeneficiaryTransferReadOnly, Long> id;

	public static final String BENEFICIARY = "beneficiary";
	public static final String OST_NUMBER = "ostNumber";
	public static final String ID = "id";

}

