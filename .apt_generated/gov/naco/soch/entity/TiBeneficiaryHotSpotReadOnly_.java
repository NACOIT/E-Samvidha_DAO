package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBeneficiaryHotSpotReadOnly.class)
public abstract class TiBeneficiaryHotSpotReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBeneficiaryHotSpotReadOnly, OstBeneficiaryReadOnly> tiOstBeneficiary;
	public static volatile SingularAttribute<TiBeneficiaryHotSpotReadOnly, TIHotspot> hotspot;
	public static volatile SingularAttribute<TiBeneficiaryHotSpotReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<TiBeneficiaryHotSpotReadOnly, TiBeneficiaryReadOnly> tiBeneficiary;
	public static volatile SingularAttribute<TiBeneficiaryHotSpotReadOnly, Long> id;
	public static volatile SingularAttribute<TiBeneficiaryHotSpotReadOnly, Boolean> isActive;

	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String HOTSPOT = "hotspot";
	public static final String IS_DELETE = "isDelete";
	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

