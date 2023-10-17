package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenBasicDetailsForMobile.class)
public abstract class TIBenBasicDetailsForMobile_ {

	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, MasterHrgSecondary> hrgSecondary;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, Boolean> isDeleted;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, MasterBenSubEntity> beneficiary;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, Integer> ibTreatments;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, Integer> lapTreatments;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, Long> id;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, String> tiCode;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, LocalDate> dateOfReg;
	public static volatile SingularAttribute<TIBenBasicDetailsForMobile, MasterTiClientStatus> status;

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

