package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityReceiptProductBatch;
import gov.naco.soch.projection.BatchProjection;

@Repository
public interface FacilityReceiptProductBatchRepository extends JpaRepository<FacilityReceiptProductBatch, Long> {

	@Query(nativeQuery = true, value = "select frpb.batch_number as batchNumber,frpb.batch_manufacture_date as manufactureDate,\r\n"
			+ "frpb.batch_expiry_date as expiryDate,frpb.quantity_received as receivedQuantity,frpb.damaged_quantity as damagedQuantity,\r\n"
			+ "frpb.id as receiptBatchId from soch.facility_receipt_product_batch frpb where frpb.facility_receipt_product_id=:facilityReceiptProductId")
	List<BatchProjection> findByFacilityReceiptProductId(
			@Param("facilityReceiptProductId") Long facilityReceiptProductId);

}
