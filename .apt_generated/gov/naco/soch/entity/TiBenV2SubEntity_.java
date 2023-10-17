package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBenV2SubEntity.class)
public abstract class TiBenV2SubEntity_ {

	public static volatile SingularAttribute<TiBenV2SubEntity, MasterBenSubEntity> beneficiary;
	public static volatile SingularAttribute<TiBenV2SubEntity, Long> id;
	public static volatile SingularAttribute<TiBenV2SubEntity, String> tiCode;
	public static volatile SingularAttribute<TiBenV2SubEntity, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<TiBenV2SubEntity, Boolean> isActive;
	public static volatile SingularAttribute<TiBenV2SubEntity, MasterTiClientStatus> status;

	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

