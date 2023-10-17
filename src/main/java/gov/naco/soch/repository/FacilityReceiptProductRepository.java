package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityReceiptProduct;
import gov.naco.soch.projection.DispatchBatchProjection;
import gov.naco.soch.projection.ProductProjcetion;

@Repository
public interface FacilityReceiptProductRepository extends JpaRepository<FacilityReceiptProduct, Long> {

	@Query(nativeQuery = true, value = "select p.id as productId,p.product_name as productName,frp.id as facilityReceiptProductId from soch.product p\r\n"
			+ "join soch.facility_receipt_product frp on(frp.product_id=p.id) where frp.facility_receipt_id=:receiptId")
	List<ProductProjcetion> findByFacilityReceiptId(@Param("receiptId") Long receiptId);

	@Query(nativeQuery = true, value = "select fr.grn_date as receiptDate,frsm.status as receiptStatus,\r\n"
			+ "fr.facility_receipt_id as facilityReceiptId,fr.grn_date as grnDate,fgsm.status as grnStatus,\r\n"
			+ "fd.facility_relocation_request_status_id as requestStatusId,\r\n"
			+ "frp.product_id as productId,p.product_name as productName,frpb.batch_number as batchNumber,\r\n"
			+ "frpb.batch_expiry_date as expiredDate,frpb.batch_manufacture_date as manufacturingDate,\r\n"
			+ "frpb.dispatched_quantity as QuantityDispatched,frpb.quantity_received as receivedQuantity,\r\n"
			+ "frpb.git as git,frpb.id as facilityReceiptBatchId,frpb.reconciliation_date as reconciliationDate,\r\n"
			+ "bs.status receiptBatchStatus,frpb.damaged_quantity as damagedQuantity\r\n"
			+ "from soch.facility_receipt_product frp\r\n"
			+ "join soch.facility_receipt fr on(frp.facility_receipt_id=fr.facility_receipt_id)\r\n"
			+ "join soch.facility_receipt_status_master frsm on(fr.facility_receipt_status_id=frsm.id)\r\n"
			+ "join soch.facility_grn_status_master fgsm on(fr.facility_grn_status_id=fgsm.id)\r\n"
			+ "join soch.product p on(frp.product_id=p.id)\r\n"
			+ "join soch.facility_receipt_product_batch frpb on (frpb.facility_receipt_product_id=frp.id)\r\n"
			+ "join soch.facility_dispatch fd on (fr.facility_dispatch_id=fd.facility_dispatch_id)"
			+ "LEFT OUTER JOIN soch.receipt_batch_status_master bs on (frpb.receipt_batch_status_id=bs.id)"
			+ "where fr.facility_dispatch_id=:facilityDispatchId")
	List<DispatchBatchProjection> findByFacilitydispatchId(@Param("facilityDispatchId") Long facilityDispatchId);

}
