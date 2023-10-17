package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Receipt;
import gov.naco.soch.projection.ReceiptHistoryProjection;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer>, CustomRepository {

	Receipt findByDispatch_DispatchId(Long dispatchId);

	Optional<Receipt> findById(Long receiptId);

	@Query(nativeQuery = true, value = "select rsm.status as receiptStatus from soch.receipt r \r\n"
			+ "join soch.receipt_status_master rsm on(r.receipt_status_id=rsm.id) \r\n"
			+ "where r.dispatch_id=:dispatchId order by r.created_time DESC LIMIT 1")
	String findReceiptStatusByLatestByDispatchId(@Param("dispatchId") Long dispatchId);

	@Query(nativeQuery = true, value = "select * from soch.receipt r \r\n"
			+ "where r.dispatch_id=:dispatchId order by r.created_time DESC LIMIT 1")
	Receipt findByLatestByDispatchId(@Param("dispatchId") Long dispatchId);

	@Query(nativeQuery = true, value = "select r.id as receiptId,r.dispatch_id as dispatchId,\r\n"
			+ "r.modified_time as lastActionDate,\r\n"
			+ "d.stn_number as stnNumber,d.invoice_number as invoiceNumber,\r\n"
			+ "g1.status as grn1,g2.status as grn2,rs.status as receiptStatus,\r\n"
			+ "p.product_name as productName\r\n"
			+ "from soch.receipt r join soch.dispatch d on(r.dispatch_id=d.dispatch_id)\r\n"
			+ "left join soch.grn1_status_master g1 on(r.grn1_status_id=g1.id)\r\n"
			+ "left join soch.grn2_status_master g2 on(r.grn2_status_id=g2.id)\r\n"
			+ "left join soch.receipt_status_master rs on(r.receipt_status_id=rs.id)\r\n"
			+ "left join soch.contract_product cp on(d.contract_product_id=cp.id)\r\n"
			+ "join soch.product p on (cp.product_id=p.id) where d.ship_consignee_id IN :consigneeIdList\r\n"
			+ "and d.is_delete=false")
	Page<ReceiptHistoryProjection> findAllByDispatch_ShipToConsignee_IdInOrderByIdDesc(@Param("consigneeIdList")List<Long> consigneeIdList,
			Pageable paging);

	@Query(nativeQuery = true, value = "select * from soch.receipt r \r\n"
			+ "where r.dispatch_id=:dispatchId order by r.created_time ASC LIMIT 1")
	Receipt findByOldestByDispatchId(@Param("dispatchId") Long dispatchId);

	@Query(nativeQuery = true, value = "select r.id as receiptId,r.dispatch_id as dispatchId,\r\n"
			+ "r.modified_time as lastActionDate,\r\n"
			+ "d.stn_number as stnNumber,d.invoice_number as invoiceNumber,\r\n"
			+ "g1.status as grn1,g2.status as grn2,rs.status as receiptStatus,\r\n"
			+ "p.product_name as productName\r\n"
			+ "from soch.receipt r join soch.dispatch d on(r.dispatch_id=d.dispatch_id)\r\n"
			+ "left join soch.grn1_status_master g1 on(r.grn1_status_id=g1.id)\r\n"
			+ "left join soch.grn2_status_master g2 on(r.grn2_status_id=g2.id)\r\n"
			+ "left join soch.receipt_status_master rs on(r.receipt_status_id=rs.id)\r\n"
			+ "left join soch.contract_product cp on(d.contract_product_id=cp.id)\r\n"
			+ "join soch.product p on (cp.product_id=p.id) where d.ship_consignee_id IN :consigneeIdList\r\n"
			+ "and d.is_delete=false and (LOWER(d.stn_number) like :searchValue% OR LOWER(d.invoice_number) like :searchValue% OR LOWER(p.product_name) like :searchValue%)")
	Page<ReceiptHistoryProjection> findAllByDispatch_ShipToConsignee_IdNormalSearch(@Param("consigneeIdList")List<Long> consigneeIdList,
			@Param("searchValue")String searchValue,Pageable paging);

	

}
