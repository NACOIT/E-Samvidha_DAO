package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityStockTransfer;

@Repository
public interface FacilityStockTransferRepository extends JpaRepository<FacilityStockTransfer, Long> {

	
	@EntityGraph(value = "FacilityStockTransferGraph")
	Optional<FacilityStockTransfer> findByStnNumber(String stnNumber);

	@EntityGraph(value = "FacilityStockTransferGraph")
	List<FacilityStockTransfer> findByFacility2_IdAndFacility1_FacilityType_IdIn(Long facilityId,
			List<Long> facilityTypeId);

	@EntityGraph(value = "FacilityStockTransferGraph")
	List<FacilityStockTransfer> findByFacility2_IdAndFacility1_FacilityType_IdNotIn(Long facilityId,
			List<Long> facilityTypeIds);
	
	@EntityGraph(value = "FacilityStockTransferGraph")
	Optional<FacilityStockTransfer> findByIdAndFacilityStockTransferDetails_Product_IdAndFacilityStockTransferDetails_BatchNumber(
			Long stockTransferId, Long productId, String batchNumber);

	@EntityGraph(value = "FacilityStockTransferGraph")
	List<FacilityStockTransfer> findAllByStatusInAndFacility2_Id(List<String> reconcileScreenList, Long facilityId);

}
