package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstPrescription.class)
public abstract class OstPrescription_ {

	public static volatile SingularAttribute<OstPrescription, OstFollowUp> tiOstFollowUp;
	public static volatile SingularAttribute<OstPrescription, MasterDrug> product;
	public static volatile SingularAttribute<OstPrescription, Long> facilityId;
	public static volatile SingularAttribute<OstPrescription, Double> dosageQty;
	public static volatile SingularAttribute<OstPrescription, OstBenSubEntity> tiOstBeneficiary;
	public static volatile SingularAttribute<OstPrescription, Boolean> isDelete;
	public static volatile SingularAttribute<OstPrescription, LocalDate> ostPrescriptionDate;
	public static volatile SingularAttribute<OstPrescription, Long> id;
	public static volatile SingularAttribute<OstPrescription, OstAssessment> tiOstAssessment;
	public static volatile SingularAttribute<OstPrescription, Boolean> isActive;

	public static final String TI_OST_FOLLOW_UP = "tiOstFollowUp";
	public static final String PRODUCT = "product";
	public static final String FACILITY_ID = "facilityId";
	public static final String DOSAGE_QTY = "dosageQty";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String OST_PRESCRIPTION_DATE = "ostPrescriptionDate";
	public static final String ID = "id";
	public static final String TI_OST_ASSESSMENT = "tiOstAssessment";
	public static final String IS_ACTIVE = "isActive";

}

