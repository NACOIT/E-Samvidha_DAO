package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockAdjustmentTypeReason.class)
public abstract class FacilityStockAdjustmentTypeReason_ {

	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, Timestamp> modifiedTime;
	public static volatile SetAttribute<FacilityStockAdjustmentTypeReason, FacilityStockAdjustment> facilityStockAdjustments;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, Long> createdBy;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, Timestamp> createdTime;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, String> stockAdjustmentReason;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, Long> modifiedBy;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, Long> id;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeReason, FacilityStockAdjustmentTypeMaster> facilityStockAdjustmentTypeMaster;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String FACILITY_STOCK_ADJUSTMENTS = "facilityStockAdjustments";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String STOCK_ADJUSTMENT_REASON = "stockAdjustmentReason";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_STOCK_ADJUSTMENT_TYPE_MASTER = "facilityStockAdjustmentTypeMaster";

}

