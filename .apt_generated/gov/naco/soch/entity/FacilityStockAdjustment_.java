package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockAdjustment.class)
public abstract class FacilityStockAdjustment_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityStockAdjustment, Long> qaQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, Product> product;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> beneficiaryQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> wastageQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> controlQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, String> remark;
	public static volatile SingularAttribute<FacilityStockAdjustment, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockAdjustment, FacilityStockAdjustmentTypeMaster> facilityStockAdjustmentTypeMaster;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> adjustStockQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> bulkDispenseQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, FacilityStockAdjustmentTypeReason> facilityStockAdjustmentTypeReason;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> totalQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> testingQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> otherQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, LocalDate> dateOfAdditionOrConsumption;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> id;
	public static volatile SingularAttribute<FacilityStockAdjustment, Long> currentQuantity;
	public static volatile SingularAttribute<FacilityStockAdjustment, Facility> facility;
	public static volatile SingularAttribute<FacilityStockAdjustment, String> batchNumber;

	public static final String QA_QUANTITY = "qaQuantity";
	public static final String PRODUCT = "product";
	public static final String BENEFICIARY_QUANTITY = "beneficiaryQuantity";
	public static final String IS_DELETE = "isDelete";
	public static final String WASTAGE_QUANTITY = "wastageQuantity";
	public static final String CONTROL_QUANTITY = "controlQuantity";
	public static final String REMARK = "remark";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_STOCK_ADJUSTMENT_TYPE_MASTER = "facilityStockAdjustmentTypeMaster";
	public static final String ADJUST_STOCK_QUANTITY = "adjustStockQuantity";
	public static final String BULK_DISPENSE_QUANTITY = "bulkDispenseQuantity";
	public static final String FACILITY_STOCK_ADJUSTMENT_TYPE_REASON = "facilityStockAdjustmentTypeReason";
	public static final String TOTAL_QUANTITY = "totalQuantity";
	public static final String TESTING_QUANTITY = "testingQuantity";
	public static final String OTHER_QUANTITY = "otherQuantity";
	public static final String DATE_OF_ADDITION_OR_CONSUMPTION = "dateOfAdditionOrConsumption";
	public static final String ID = "id";
	public static final String CURRENT_QUANTITY = "currentQuantity";
	public static final String FACILITY = "facility";
	public static final String BATCH_NUMBER = "batchNumber";

}

