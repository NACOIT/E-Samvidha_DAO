package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstDispensation.class)
public abstract class TiOstDispensation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstDispensation, LocalDate> ostDispensationDate;
	public static volatile SingularAttribute<TiOstDispensation, Product> product;
	public static volatile SingularAttribute<TiOstDispensation, Boolean> isDeleted;
	public static volatile SingularAttribute<TiOstDispensation, Double> totalDosageQty;
	public static volatile SingularAttribute<TiOstDispensation, FacilityStock> facilityStock;
	public static volatile SingularAttribute<TiOstDispensation, Long> id;
	public static volatile SingularAttribute<TiOstDispensation, Double> availableQty;
	public static volatile SingularAttribute<TiOstDispensation, Boolean> isActive;
	public static volatile SingularAttribute<TiOstDispensation, Double> totalDispensedQty;
	public static volatile SingularAttribute<TiOstDispensation, Facility> facility;
	public static volatile SingularAttribute<TiOstDispensation, TiOstBulkDispensation> tiOstBulkDispensation;
	public static volatile SingularAttribute<TiOstDispensation, String> batchNumber;

	public static final String OST_DISPENSATION_DATE = "ostDispensationDate";
	public static final String PRODUCT = "product";
	public static final String IS_DELETED = "isDeleted";
	public static final String TOTAL_DOSAGE_QTY = "totalDosageQty";
	public static final String FACILITY_STOCK = "facilityStock";
	public static final String ID = "id";
	public static final String AVAILABLE_QTY = "availableQty";
	public static final String IS_ACTIVE = "isActive";
	public static final String TOTAL_DISPENSED_QTY = "totalDispensedQty";
	public static final String FACILITY = "facility";
	public static final String TI_OST_BULK_DISPENSATION = "tiOstBulkDispensation";
	public static final String BATCH_NUMBER = "batchNumber";

}

