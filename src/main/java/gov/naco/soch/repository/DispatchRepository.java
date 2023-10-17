package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.Dispatch;
import gov.naco.soch.projection.DispatchHistoryProjection;
import gov.naco.soch.projection.ProductProjcetion;

public interface DispatchRepository extends JpaRepository<Dispatch, Long>, CustomRepository {

	@Query(value = "select d from Dispatch d JOIN FETCH d.dispatchBatches JOIN FETCH d.contract c JOIN FETCH d.contractProduct cp JOIN FETCH cp.product "
			+ "JOIN FETCH d.contractProductSchedule cps JOIN FETCH d.contractProductSceduleSacsLot cpssl "
			+ "JOIN FETCH d.billToConsignee b JOIN FETCH b.address ba LEFT JOIN FETCH ba.town LEFT JOIN FETCH ba.state LEFT JOIN FETCH ba.district LEFT JOIN FETCH ba.subdistrict JOIN FETCH d.shipToConsignee s JOIN FETCH s.address sa "
			+ "LEFT JOIN FETCH sa.town LEFT JOIN FETCH sa.state LEFT JOIN FETCH sa.district LEFT JOIN FETCH sa.subdistrict JOIN FETCH d.consignor cr JOIN FETCH cr.address ca "
			+ "LEFT JOIN FETCH ca.town LEFT JOIN FETCH ca.state LEFT JOIN FETCH ca.district LEFT JOIN FETCH ca.subdistrict LEFT JOIN FETCH d.dispatchStatusMaster dsm LEFT JOIN FETCH d.consignmentStatusMaster "
			+ "LEFT JOIN FETCH d.dispatchReceiptRemarks r LEFT JOIN FETCH r.userMaster1  where d.dispatchId=:dispatchId  ")
	Dispatch findByDispatchId(@Param("dispatchId") Long dispatchId);

	@EntityGraph(value = "DispatchGraph")
	List<Dispatch> findAllByShipToConsignee_IdAndDispatchStatusMaster_IdAndConsignor_FacilityType_IdIn(Long facilityId,
			int i, List<Long> facilityTypeIds);

	@Query(nativeQuery = true, value = "SELECT d.dispatch_id as dispatchId,d.stn_number as stnNumber,d.invoice_number as invoiceNumber,\r\n"
			+ "d.invoice_date as invoiceDate,c.noa_number as noaNumber,\r\n"
			+ "p.product_name as productName,cpssl.lot_number as lotNumber,\r\n"
			+ "f2.name as consignee,csm.status as consignmentStatus,\r\n"
			+ "dsm.status as dispatchStatus,SUM(db.quantity_number) as quantity\r\n"
			+ "FROM soch.dispatch d JOIN soch.facility f1\r\n" + "on(f1.id=d.consignor_id) JOIN soch.contract c \r\n"
			+ "on(c.contract_id=d.contract_id) JOIN soch.contract_product cp\r\n"
			+ "on(d.contract_product_id=cp.id) JOIN soch.product p\r\n"
			+ "on(cp.product_id=p.id) JOIN soch.contract_product_schedule_sacs_lot cpssl\r\n"
			+ "on(cpssl.id=d.lot_id) JOIN soch.facility f2 \r\n"
			+ "on(f2.id=d.ship_consignee_id) LEFT JOIN soch.consignment_status_master csm\r\n"
			+ "on(csm.id=d.consignment_status_id)JOIN soch.dispatch_status_master dsm\r\n"
			+ "on(dsm.id=d.dispatch_status_id) JOIN soch.dispatch_batch db\r\n" + "on(d.dispatch_id=db.dispatch_id)\r\n"
			+ "where f1.id=:consignorId and db.is_active=true group by d.stn_number,d.invoice_number,\r\n"
			+ "d.invoice_date,c.noa_number,p.product_name,cpssl.lot_number,d.dispatch_id,\r\n"
			+ "f2.name,csm.status,dsm.status")
	Page<DispatchHistoryProjection> findAllByConsignorId(@Param("consignorId") Long consignorId, Pageable paging);

	@Query(nativeQuery = true, value = "SELECT d.dispatch_id as dispatchId,d.stn_number as stnNumber,d.invoice_number as invoiceNumber,\r\n"
			+ "d.invoice_date as invoiceDate,c.noa_number as noaNumber,\r\n"
			+ "p.product_name as productName,cpssl.lot_number as lotNumber,\r\n"
			+ "f2.name as consignee,csm.status as consignmentStatus,\r\n"
			+ "dsm.status as dispatchStatus,SUM(db.quantity_number) as quantity\r\n"
			+ "FROM soch.dispatch d JOIN soch.facility f1\r\n" + "on(f1.id=d.consignor_id) JOIN soch.contract c \r\n"
			+ "on(c.contract_id=d.contract_id) JOIN soch.contract_product cp\r\n"
			+ "on(d.contract_product_id=cp.id) JOIN soch.product p\r\n"
			+ "on(cp.product_id=p.id) JOIN soch.contract_product_schedule_sacs_lot cpssl\r\n"
			+ "on(cpssl.id=d.lot_id) JOIN soch.facility f2 \r\n"
			+ "on(f2.id=d.ship_consignee_id) LEFT JOIN soch.consignment_status_master csm\r\n"
			+ "on(csm.id=d.consignment_status_id)JOIN soch.dispatch_status_master dsm\r\n"
			+ "on(dsm.id=d.dispatch_status_id) JOIN soch.dispatch_batch db\r\n" + "on(d.dispatch_id=db.dispatch_id)\r\n"
			+ "where f1.id=:consignorId and (LOWER(d.stn_number) like :searchValue% OR LOWER(d.invoice_number) like :searchValue%\r\n"
			+ " OR LOWER(f2.name) like :searchValue% OR LOWER(p.product_name) like :searchValue%)group by d.stn_number,d.invoice_number,\r\n"
			+ "d.invoice_date,c.noa_number,p.product_name,cpssl.lot_number,d.dispatch_id,\r\n"
			+ "f2.name,csm.status,dsm.status")
	Page<DispatchHistoryProjection> findAllByConsignorIdByNormalSearch(@Param("consignorId") Long consignorId, @Param("searchValue")String searchValue,
			Pageable paging);

	List<Dispatch> findAllByContract_ContractId(Long contarctId);

	List<Dispatch> findAllByConsignor_Id(Long consignorId);

	List<Dispatch> findAllByContract_ContractIdAndContractProduct_Product_Id(Long contractId, Long productId);

	List<Dispatch> findAllByContract_ContractIdAndContractProduct_Product_IdAndContractProductSchedule_Id(
			Long contractId, Long id, Long scheduleId);

	@Query(nativeQuery = true, value = "select count(d.invoice_number) from soch.dispatch d where LOWER(d.invoice_number)=LOWER(:invoiceNumber)")
	Long existsByInvoiceNumber(@Param("invoiceNumber") String invoiceNumber);

	@Query(nativeQuery = true, value = "SELECT d.dispatch_id as dispatchId,d.stn_number as stnNumber,d.invoice_number as invoiceNumber,"
			+ "f2.name as consignor,d.invoice_date as invoiceDate\r\n"
			+ "FROM soch.dispatch d JOIN soch.facility f1\r\n"
			+ "on(f1.id=d.ship_consignee_id) JOIN soch.dispatch_status_master dsm\r\n"
			+ "on(d.dispatch_status_id=dsm.id) JOIN soch.facility f2 \r\n"
			+ "on(f2.id=d.consignor_id) where f1.id=:facilityId and dsm.id=:id and f2.facility_type_id IN :facilityTypeIds")
	Page<DispatchHistoryProjection> findSupplierDipsatchedStocks(@Param("facilityId") Long facilityId,
			@Param("id") int id, @Param("facilityTypeIds") List<Long> facilityTypeIds, Pageable paging);

	@Query(nativeQuery = true, value = "SELECT db.quantity_number as quantity,d.contract_product_id as productId from soch.dispatch_batch db join soch.dispatch d"
			+ " on(d.dispatch_id=db.dispatch_id) join soch.contract c on (c.contract_id=d.contract_id) where d.contract_product_id in (:contractProductIds)")
	List<ProductProjcetion> findDispatchQuantityByContractIdAndProductId(
			@Param("contractProductIds") List<Long> contractProductIds);

	@Query(nativeQuery = true, value = "SELECT d.dispatch_id as dispatchId,d.stn_number as stnNumber,d.invoice_number as invoiceNumber,"
			+ "f2.name as consignor,d.invoice_date as invoiceDate\r\n"
			+ "FROM soch.dispatch d JOIN soch.facility f1\r\n"
			+ "on(f1.id=d.ship_consignee_id) JOIN soch.dispatch_status_master dsm\r\n"
			+ "on(d.dispatch_status_id=dsm.id) JOIN soch.facility f2 \r\n"
			+ "on(f2.id=d.consignor_id) join soch.contract_product cp on(d.contract_product_id=cp.id) join soch.product p on(cp.product_id=p.id) where f1.id=:facilityId and dsm.id=:id and f2.facility_type_id IN :facilityTypeIds\r\n"
			+ "and (LOWER(d.stn_number) like :searchValue% OR LOWER(d.invoice_number) like :searchValue% OR LOWER(f2.name) like :searchValue% OR LOWER(p.product_name) like :searchValue%)")
	Page<DispatchHistoryProjection> findSupplierDipsatchedStocksByNormalSearch(@Param("facilityId") Long facilityId,
			@Param("id") int id, @Param("facilityTypeIds") List<Long> facilityTypeIds,
			@Param("searchValue") String searchValue, Pageable paging);

	

}
