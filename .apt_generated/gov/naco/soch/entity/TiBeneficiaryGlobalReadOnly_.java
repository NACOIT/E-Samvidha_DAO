package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBeneficiaryGlobalReadOnly.class)
public abstract class TiBeneficiaryGlobalReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBeneficiaryGlobalReadOnly, BeneficiaryGlobalReadOnly> beneficiary;
	public static volatile SingularAttribute<TiBeneficiaryGlobalReadOnly, String> numberOfPartners;
	public static volatile SingularAttribute<TiBeneficiaryGlobalReadOnly, Long> id;

	public static final String BENEFICIARY = "beneficiary";
	public static final String NUMBER_OF_PARTNERS = "numberOfPartners";
	public static final String ID = "id";

}

