package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstPrescription.class)
public abstract class TiOstPrescription_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstPrescription, TiOstFollowUp> tiOstFollowUp;
	public static volatile SingularAttribute<TiOstPrescription, MasterDrug> product;
	public static volatile SingularAttribute<TiOstPrescription, Double> dosageQty;
	public static volatile SingularAttribute<TiOstPrescription, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<TiOstPrescription, Boolean> isDelete;
	public static volatile SetAttribute<TiOstPrescription, TiOstDispensationItem> tiOstDispensationItems;
	public static volatile SingularAttribute<TiOstPrescription, LocalDate> ostPrescriptionDate;
	public static volatile SingularAttribute<TiOstPrescription, Long> id;
	public static volatile SingularAttribute<TiOstPrescription, TiOstAssessment> tiOstAssessment;
	public static volatile SingularAttribute<TiOstPrescription, Boolean> isActive;
	public static volatile SingularAttribute<TiOstPrescription, Facility> facility;

	public static final String TI_OST_FOLLOW_UP = "tiOstFollowUp";
	public static final String PRODUCT = "product";
	public static final String DOSAGE_QTY = "dosageQty";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String TI_OST_DISPENSATION_ITEMS = "tiOstDispensationItems";
	public static final String OST_PRESCRIPTION_DATE = "ostPrescriptionDate";
	public static final String ID = "id";
	public static final String TI_OST_ASSESSMENT = "tiOstAssessment";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

