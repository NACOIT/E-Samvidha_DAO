package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBenSubEntityRVAssessmentV2.class)
public abstract class TiBenSubEntityRVAssessmentV2_ {

	public static volatile SingularAttribute<TiBenSubEntityRVAssessmentV2, MasterBenSubEntityRVAssessmentV2> beneficiary;
	public static volatile SingularAttribute<TiBenSubEntityRVAssessmentV2, String> orwCode;
	public static volatile SingularAttribute<TiBenSubEntityRVAssessmentV2, Long> id;
	public static volatile SingularAttribute<TiBenSubEntityRVAssessmentV2, String> tiCode;
	public static volatile SingularAttribute<TiBenSubEntityRVAssessmentV2, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<TiBenSubEntityRVAssessmentV2, Boolean> isActive;
	public static volatile SingularAttribute<TiBenSubEntityRVAssessmentV2, LocalDate> dateOfReg;
	public static volatile SingularAttribute<TiBenSubEntityRVAssessmentV2, MasterTiClientStatus> status;

	public static final String BENEFICIARY = "beneficiary";
	public static final String ORW_CODE = "orwCode";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String IS_ACTIVE = "isActive";
	public static final String DATE_OF_REG = "dateOfReg";
	public static final String STATUS = "status";

}

