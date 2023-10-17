package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstPrescriptionV2FollowUp.class)
public abstract class OstPrescriptionV2FollowUp_ {

	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, OstFollowUp> tiOstFollowUp;
	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, MasterDrug> product;
	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, Long> facilityId;
	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, Double> dosageQty;
	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, OstBenSubEntityV2> tiOstBeneficiary;
	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, Boolean> isDelete;
	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, LocalDate> ostPrescriptionDate;
	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, Long> id;
	public static volatile SingularAttribute<OstPrescriptionV2FollowUp, Boolean> isActive;

	public static final String TI_OST_FOLLOW_UP = "tiOstFollowUp";
	public static final String PRODUCT = "product";
	public static final String FACILITY_ID = "facilityId";
	public static final String DOSAGE_QTY = "dosageQty";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String OST_PRESCRIPTION_DATE = "ostPrescriptionDate";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

