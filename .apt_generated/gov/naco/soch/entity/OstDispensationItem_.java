package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstDispensationItem.class)
public abstract class OstDispensationItem_ {

	public static volatile SingularAttribute<OstDispensationItem, Double> dispensedQty;
	public static volatile SingularAttribute<OstDispensationItem, Double> dosageQty;
	public static volatile SingularAttribute<OstDispensationItem, Boolean> isDeleted;
	public static volatile SingularAttribute<OstDispensationItem, LocalDate> takeHomeDate;
	public static volatile SingularAttribute<OstDispensationItem, OstBenSubEntity> tiOstBeneficiary;
	public static volatile SingularAttribute<OstDispensationItem, LocalDate> dispensationDate;
	public static volatile SingularAttribute<OstDispensationItem, OstPrescription> tiOstPrescription;
	public static volatile SingularAttribute<OstDispensationItem, Long> id;
	public static volatile SingularAttribute<OstDispensationItem, Boolean> isActive;
	public static volatile SingularAttribute<OstDispensationItem, Integer> takeHomeDays;
	public static volatile SingularAttribute<OstDispensationItem, FacilityReadOnly> facility;
	public static volatile SingularAttribute<OstDispensationItem, LocalDate> lastDispensationDate;

	public static final String DISPENSED_QTY = "dispensedQty";
	public static final String DOSAGE_QTY = "dosageQty";
	public static final String IS_DELETED = "isDeleted";
	public static final String TAKE_HOME_DATE = "takeHomeDate";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String DISPENSATION_DATE = "dispensationDate";
	public static final String TI_OST_PRESCRIPTION = "tiOstPrescription";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String TAKE_HOME_DAYS = "takeHomeDays";
	public static final String FACILITY = "facility";
	public static final String LAST_DISPENSATION_DATE = "lastDispensationDate";

}

