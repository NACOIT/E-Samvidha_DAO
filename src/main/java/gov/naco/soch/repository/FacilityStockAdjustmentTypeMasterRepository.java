package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityStockAdjustmentTypeMaster;

@Repository
public interface FacilityStockAdjustmentTypeMasterRepository
		extends JpaRepository<FacilityStockAdjustmentTypeMaster, Long> {

}
