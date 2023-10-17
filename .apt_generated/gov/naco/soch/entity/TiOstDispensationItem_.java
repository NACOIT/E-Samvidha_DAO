package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstDispensationItem.class)
public abstract class TiOstDispensationItem_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstDispensationItem, Product> product;
	public static volatile SingularAttribute<TiOstDispensationItem, LocalDate> takeHomeDate;
	public static volatile SingularAttribute<TiOstDispensationItem, TiOstPrescription> tiOstPrescription;
	public static volatile SingularAttribute<TiOstDispensationItem, Boolean> isActive;
	public static volatile SingularAttribute<TiOstDispensationItem, Integer> takeHomeDays;
	public static volatile SingularAttribute<TiOstDispensationItem, TiOstBulkDispensation> tiOstBulkDispensation;
	public static volatile SingularAttribute<TiOstDispensationItem, LocalDate> lastDispensationDate;
	public static volatile SingularAttribute<TiOstDispensationItem, Double> dispensedQty;
	public static volatile SingularAttribute<TiOstDispensationItem, Double> dosageQty;
	public static volatile SingularAttribute<TiOstDispensationItem, Boolean> isDeleted;
	public static volatile SingularAttribute<TiOstDispensationItem, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<TiOstDispensationItem, LocalDate> actualDispensationDate;
	public static volatile SingularAttribute<TiOstDispensationItem, LocalDate> dispensationDate;
	public static volatile SingularAttribute<TiOstDispensationItem, Long> id;
	public static volatile SingularAttribute<TiOstDispensationItem, Facility> facility;

	public static final String PRODUCT = "product";
	public static final String TAKE_HOME_DATE = "takeHomeDate";
	public static final String TI_OST_PRESCRIPTION = "tiOstPrescription";
	public static final String IS_ACTIVE = "isActive";
	public static final String TAKE_HOME_DAYS = "takeHomeDays";
	public static final String TI_OST_BULK_DISPENSATION = "tiOstBulkDispensation";
	public static final String LAST_DISPENSATION_DATE = "lastDispensationDate";
	public static final String DISPENSED_QTY = "dispensedQty";
	public static final String DOSAGE_QTY = "dosageQty";
	public static final String IS_DELETED = "isDeleted";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String ACTUAL_DISPENSATION_DATE = "actualDispensationDate";
	public static final String DISPENSATION_DATE = "dispensationDate";
	public static final String ID = "id";
	public static final String FACILITY = "facility";

}

