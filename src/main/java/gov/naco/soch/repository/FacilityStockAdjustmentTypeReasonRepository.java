package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityStockAdjustmentTypeReason;

@Repository
public interface FacilityStockAdjustmentTypeReasonRepository extends JpaRepository<FacilityStockAdjustmentTypeReason, Long>{

	List<FacilityStockAdjustmentTypeReason> findAllByIsDelete(boolean b);

}
