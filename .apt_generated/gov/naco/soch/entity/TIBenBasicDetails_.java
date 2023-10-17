package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenBasicDetails.class)
public abstract class TIBenBasicDetails_ {

	public static volatile SingularAttribute<TIBenBasicDetails, MasterHrgSecondary> hrgSecondary;
	public static volatile SingularAttribute<TIBenBasicDetails, Boolean> isDeleted;
	public static volatile SingularAttribute<TIBenBasicDetails, MasterBenSubEntity> beneficiary;
	public static volatile SingularAttribute<TIBenBasicDetails, Integer> ibTreatments;
	public static volatile SingularAttribute<TIBenBasicDetails, Integer> lapTreatments;
	public static volatile SingularAttribute<TIBenBasicDetails, Long> id;
	public static volatile SingularAttribute<TIBenBasicDetails, String> tiCode;
	public static volatile SingularAttribute<TIBenBasicDetails, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<TIBenBasicDetails, LocalDate> dateOfReg;
	public static volatile SingularAttribute<TIBenBasicDetails, MasterTiClientStatus> status;

	public static final String HRG_SECONDARY = "hrgSecondary";
	public static final String IS_DELETED = "isDeleted";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IB_TREATMENTS = "ibTreatments";
	public static final String LAP_TREATMENTS = "lapTreatments";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String DATE_OF_REG = "dateOfReg";
	public static final String STATUS = "status";

}

