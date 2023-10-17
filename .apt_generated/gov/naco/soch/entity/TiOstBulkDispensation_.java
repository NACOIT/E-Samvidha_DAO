package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstBulkDispensation.class)
public abstract class TiOstBulkDispensation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<TiOstBulkDispensation, TiOstDispensation> tiOstDispensations;
	public static volatile SingularAttribute<TiOstBulkDispensation, LocalDate> ostBulkDispensationDate;
	public static volatile SingularAttribute<TiOstBulkDispensation, Boolean> isDeleted;
	public static volatile SetAttribute<TiOstBulkDispensation, TiOstDispensationItem> tiOstDispensationItems;
	public static volatile SingularAttribute<TiOstBulkDispensation, Long> ostBulkDispensationId;
	public static volatile SingularAttribute<TiOstBulkDispensation, Boolean> isActive;
	public static volatile SingularAttribute<TiOstBulkDispensation, Facility> facility;
	public static volatile SingularAttribute<TiOstBulkDispensation, MasterDrug> masterDrug;

	public static final String TI_OST_DISPENSATIONS = "tiOstDispensations";
	public static final String OST_BULK_DISPENSATION_DATE = "ostBulkDispensationDate";
	public static final String IS_DELETED = "isDeleted";
	public static final String TI_OST_DISPENSATION_ITEMS = "tiOstDispensationItems";
	public static final String OST_BULK_DISPENSATION_ID = "ostBulkDispensationId";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String MASTER_DRUG = "masterDrug";

}

