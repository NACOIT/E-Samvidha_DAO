package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockAdjustmentTypeMaster.class)
public abstract class FacilityStockAdjustmentTypeMaster_ {

	public static volatile SingularAttribute<FacilityStockAdjustmentTypeMaster, Timestamp> modifiedTime;
	public static volatile SetAttribute<FacilityStockAdjustmentTypeMaster, FacilityStockAdjustment> facilityStockAdjustments;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeMaster, Long> createdBy;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeMaster, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeMaster, Timestamp> createdTime;
	public static volatile SetAttribute<FacilityStockAdjustmentTypeMaster, FacilityStockAdjustmentTypeReason> facilityStockAdjustmentTypeReasons;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeMaster, Long> modifiedBy;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeMaster, Long> id;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeMaster, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockAdjustmentTypeMaster, String> type;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String FACILITY_STOCK_ADJUSTMENTS = "facilityStockAdjustments";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String FACILITY_STOCK_ADJUSTMENT_TYPE_REASONS = "facilityStockAdjustmentTypeReasons";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String TYPE = "type";

}

