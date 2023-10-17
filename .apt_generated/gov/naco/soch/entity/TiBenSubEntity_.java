package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBenSubEntity.class)
public abstract class TiBenSubEntity_ {

	public static volatile SingularAttribute<TiBenSubEntity, MasterHrgSecondary> hrgSecondary;
	public static volatile SingularAttribute<TiBenSubEntity, Integer> ibTreatments;
	public static volatile SingularAttribute<TiBenSubEntity, MasterBenSubEntity> beneficiary;
	public static volatile SingularAttribute<TiBenSubEntity, String> orwCode;
	public static volatile SingularAttribute<TiBenSubEntity, Integer> lapTreatments;
	public static volatile SingularAttribute<TiBenSubEntity, Long> id;
	public static volatile SingularAttribute<TiBenSubEntity, String> tiCode;
	public static volatile SingularAttribute<TiBenSubEntity, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<TiBenSubEntity, Boolean> isActive;
	public static volatile SingularAttribute<TiBenSubEntity, LocalDate> dateOfReg;
	public static volatile SingularAttribute<TiBenSubEntity, MasterTiClientStatus> status;

	public static final String HRG_SECONDARY = "hrgSecondary";
	public static final String IB_TREATMENTS = "ibTreatments";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ORW_CODE = "orwCode";
	public static final String LAP_TREATMENTS = "lapTreatments";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String IS_ACTIVE = "isActive";
	public static final String DATE_OF_REG = "dateOfReg";
	public static final String STATUS = "status";

}

