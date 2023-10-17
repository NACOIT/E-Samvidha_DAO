package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBeneficiaryHotspotMapping.class)
public abstract class TiBeneficiaryHotspotMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBeneficiaryHotspotMapping, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<TiBeneficiaryHotspotMapping, TIHotspot> hotspot;
	public static volatile SingularAttribute<TiBeneficiaryHotspotMapping, Boolean> isDelete;
	public static volatile SingularAttribute<TiBeneficiaryHotspotMapping, TIBeneficiary> tiBeneficiary;
	public static volatile SingularAttribute<TiBeneficiaryHotspotMapping, Long> id;
	public static volatile SingularAttribute<TiBeneficiaryHotspotMapping, Boolean> isActive;

	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String HOTSPOT = "hotspot";
	public static final String IS_DELETE = "isDelete";
	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

