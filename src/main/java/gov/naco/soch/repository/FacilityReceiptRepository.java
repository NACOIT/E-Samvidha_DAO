package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.projection.FacilityReconciliationListProjection;
import gov.naco.soch.projection.ReconciliationProjection;
import gov.naco.soch.projection.UnregisteredSourceReceiptProjection;

@Repository
public interface FacilityReceiptRepository extends JpaRepository<FacilityReceipt, Long>, CustomRepository {

	FacilityReceipt findByFacilityDispatch_FacilityDispatchId(Long facilityDispatchId);

	FacilityReceipt findByFacilityReceiptId(Long facilityReceiptId);

	@Query(nativeQuery = true, value = "select sum(frpb.git) as git,fr.facility_receipt_id as facilityReceiptId,\r\n"
			+ "fd.facility_dispatch_id as facilityDispatchId,\r\n"
			+ "fd.stn_number as stnNumber ,rsm.status as reconciliationStatus,\r\n"
			+ "f1.id as consignorId,f1.name as consignorName,\r\n" + "f2.id as consigneeId,f2.name as consigneeName\r\n"
			+ "from soch.facility_receipt fr \r\n"
			+ "join soch.facility_dispatch fd on(fr.facility_dispatch_id=fd.facility_dispatch_id)\r\n"
			+ "join soch.reconciliation_status_master rsm on(fr.reconciliation_status_id=rsm.id)\r\n"
			+ "join soch.facility f1 on(fd.consignor_facility_id=f1.id)\r\n"
			+ "join soch.facility f2 on(fd.consignee_facility_id=f2.id)\r\n"
			+ "join soch.facility_receipt_product frp on(frp.facility_receipt_id=fr.facility_receipt_id)\r\n"
			+ "join soch.facility_receipt_product_batch frpb on (frpb.facility_receipt_product_id=frp.id)\r\n"
			+ "where (fd.consignor_facility_id IN :consignorIds OR fd.consignee_facility_id IN :consignorIds) AND\r\n"
			+ "fr.facility_receipt_status_id IN (5,8) group by\r\n"
			+ "fr.facility_receipt_id,fd.facility_dispatch_id,fd.stn_number,rsm.status,\r\n"
			+ "f1.id,f1.name,f2.id,f2.name")
	Page<FacilityReconciliationListProjection> findReconcilationList(@Param("consignorIds") List<Long> consignorIds,
			Pageable paging);

	@Query(nativeQuery = true, value = "select sum(frpb.git) as git,fr.facility_receipt_id as facilityReceiptId,\r\n"
			+ "fd.facility_dispatch_id as facilityDispatchId,\r\n"
			+ "fd.stn_number as stnNumber ,rsm.status as reconciliationStatus,\r\n"
			+ "f1.id as consignorId,f1.name as consignorName,\r\n" + "f2.id as consigneeId,f2.name as consigneeName\r\n"
			+ "from soch.facility_receipt fr \r\n"
			+ "join soch.facility_dispatch fd on(fr.facility_dispatch_id=fd.facility_dispatch_id)\r\n"
			+ "join soch.reconciliation_status_master rsm on(fr.reconciliation_status_id=rsm.id)\r\n"
			+ "join soch.facility f1 on(fd.consignor_facility_id=f1.id)\r\n"
			+ "join soch.facility f2 on(fd.consignee_facility_id=f2.id)\r\n"
			+ "join soch.facility_receipt_product frp on(frp.facility_receipt_id=fr.facility_receipt_id)\r\n"
			+ "join soch.facility_receipt_product_batch frpb on (frpb.facility_receipt_product_id=frp.id)\r\n"
			+ "where (fd.consignor_facility_id IN :consignorIds OR fd.consignee_facility_id IN :consignorIds) AND\r\n"
			+ "fr.facility_receipt_status_id IN (5,8) and (LOWER(fd.stn_number) like :searchValue% OR LOWER(f1.name) like :searchValue% OR LOWER(f2.name) like :searchValue%) group by\r\n"
			+ "fr.facility_receipt_id,fd.facility_dispatch_id,fd.stn_number,rsm.status,\r\n"
			+ "f1.id,f1.name,f2.id,f2.name")
	Page<FacilityReconciliationListProjection> findReconcilationListByNormalSearch(
			@Param("consignorIds") List<Long> consignorIds, @Param("searchValue") String searchValue, Pageable paging);

	@Query(value = "select r.* from soch.facility_receipt as r where r.facility_dispatch_id IN :facilityDispatchIds", nativeQuery = true)
	List<FacilityReceipt> findByFacilityDispatchIds(@Param("facilityDispatchIds") List<Long> facilityDispatchIds);

	@Query(value = "select fr from FacilityReceipt fr join fetch fr.facilityReceiptProducts frp join fetch "
			+ "fr.facilityGrnStatusMaster join fetch fr.facilityReceiptStatusMaster join fetch fr.facilityDispatch fd join fetch frp.product where fr.facilityDispatch.consignee.id=:facilityId and "
			+ "fr.facilityDispatch.consignor.facilityType.id NOT IN :excludedFacilityTypeIds", countQuery = "select count(fr) from FacilityReceipt fr"
					+ "	where fr.facilityDispatch.consignee.id=:facilityId and"
					+ " fr.facilityDispatch.consignor.facilityType.id NOT IN :excludedFacilityTypeIds")
	Page<FacilityReceipt> findFacilityReceiptHistoryForFacility(@Param("facilityId") Long facilityId,
			@Param("excludedFacilityTypeIds") List<Long> excludedFacilityTypeIds, Pageable paging);

	@Query(value = "select fr from FacilityReceipt fr join fetch fr.facilityReceiptProducts frp join fetch "
			+ "fr.facilityGrnStatusMaster fg join fetch fr.facilityReceiptStatusMaster join fetch fr.facilityDispatch fd join fetch frp.product p where fd.consignee.id=:facilityId and "
			+ "fd.consignor.facilityType.id NOT IN :excludedFacilityTypeIds and (LOWER(fd.stnNumber) like :searchValue% OR LOWER(fd.indentNum) like :searchValue% OR LOWER(p.productName) like :searchValue%)", countQuery = "select count(fr) from FacilityReceipt fr\r\n"
					+ "	join fr.facilityReceiptProducts frp join fr.facilityDispatch fd join frp.product p where fd.consignee.id=:facilityId and"
					+ " fd.consignor.facilityType.id NOT IN :excludedFacilityTypeIds and (LOWER(fd.stnNumber) like :searchValue% OR LOWER(fd.indentNum) like :searchValue% OR LOWER(p.productName) like :searchValue%)")
	Page<FacilityReceipt> findFacilityReceiptHistoryForFacilityByNormalSearch(@Param("facilityId") Long facilityId,
			@Param("excludedFacilityTypeIds") List<Long> excludedFacilityTypeIds,
			@Param("searchValue") String searchValue, Pageable paging);

	@Query(value = "select fr from FacilityReceipt fr join fetch fr.facilityReceiptProducts frp join fetch "
			+ "fr.facilityGrnStatusMaster join fetch fr.facilityReceiptStatusMaster join fetch fr.facilityDispatch fd join fetch frp.product where fr.facilityDispatch.consignee.id=:facilityId and "
			+ "fr.facilityDispatch.consignor.facilityType.id IN :facilityTypeIds", countQuery = "select count(fr) from FacilityReceipt fr"
					+ "	where fr.facilityDispatch.consignee.id=:facilityId and"
					+ " fr.facilityDispatch.consignor.facilityType.id IN :facilityTypeIds")
	Page<FacilityReceipt> findFacilityReceiptHistoryExceptForFacility(@Param("facilityId") Long facilityId,
			@Param("facilityTypeIds") List<Long> facilityTypeIds, Pageable paging);

	@Query(value = "select fr from FacilityReceipt fr join fetch fr.facilityReceiptProducts frp join fetch "
			+ "fr.facilityGrnStatusMaster fg join fetch fr.facilityReceiptStatusMaster frs join fetch fr.facilityDispatch fd join fetch frp.product p where fd.consignee.id=:facilityId and "
			+ "fd.consignor.facilityType.id IN :facilityTypeIds and (LOWER(fd.stnNumber) like :searchValue% OR LOWER(fd.indentNum) like :searchValue% OR LOWER(p.productName) like :searchValue%)", countQuery = "select count(fr) from FacilityReceipt fr\r\n"
					+ "	join fr.facilityReceiptProducts frp join fr.facilityDispatch fd join frp.product p where fd.consignee.id=:facilityId and"
					+ " fd.consignor.facilityType.id IN :facilityTypeIds and (LOWER(fd.stnNumber) like :searchValue% OR LOWER(fd.indentNum) like :searchValue% OR LOWER(p.productName) like :searchValue%)")
	Page<FacilityReceipt> findFacilityReceiptHistoryExceptForFacilityByNormalSearch(
			@Param("facilityId") Long facilityId, @Param("facilityTypeIds") List<Long> facilityTypeIds,
			@Param("searchValue") String searchValue, Pageable paging);

	@Query(value = "select fr.facility_receipt_id as receiptid,fr.created_time as receiptDate, fr.unregistered_source_indent_number as unregSourceIndentNumber,\r\n"
			+ "frsm.status as receiptstatus,fgsm.status as grnstatus,\r\n"
			+ "ms.source_name as sourcename,a.address as address\r\n" + "from soch.facility_receipt fr \r\n"
			+ "left join soch.facility_receipt_status_master frsm\r\n"
			+ "on(fr.facility_receipt_status_id=frsm.id) left join soch.facility_grn_status_master fgsm\r\n"
			+ "on(fr.facility_grn_status_id=fgsm.id) left join soch.master_inventory_unregistered_source ms\r\n"
			+ "on(fr.unregistered_source_id=ms.id) left join soch.address a on(ms.address_id=a.id)\r\n"
			+ "where fr.received_facility_id =:facilityId and fr.unregistered_source_id is not null and exists (\r\n"
			+ "select * from soch.facility_receipt_product frp where frp.facility_receipt_id =fr.facility_receipt_id )", nativeQuery = true)
	Page<UnregisteredSourceReceiptProjection> findByReceivedFacilityIds(@Param("facilityId") Long facilityId,
			Pageable paging);

	@Query(nativeQuery = true, value = " select count(*) as pendingReconcileCount, coalesce(ROUND(avg(extract(day from now() - fd.expected_arrival_date))),0) as avgReconcileDays from soch.facility_receipt fr \r\n"
			+ "			join soch.facility_dispatch fd on(fr.facility_dispatch_id=fd.facility_dispatch_id)\r\n"
			+ "			join soch.reconciliation_status_master rsm on(fr.reconciliation_status_id=rsm.id)\r\n"
			+ "			where rsm.status ='In Transit' \r\n"
			+ "			and (fd.consignor_facility_id IN :consignorIds OR fd.consignee_facility_id IN :consignorIds) \r\n"
			+ "			AND fr.facility_receipt_status_id IN (5,8)")
	ReconciliationProjection findReconcilationListInTransit(@Param("consignorIds") List<Long> consignorIds);

	@Query(value = "select distinct on(fr.facility_receipt_id) fr.facility_receipt_id as receiptid,fr.created_time as receiptDate, fr.unregistered_source_indent_number as unregSourceIndentNumber,\r\n"
			+ "frsm.status as receiptstatus,fgsm.status as grnstatus,\r\n"
			+ "ms.source_name as sourcename,a.address as address\r\n" + "from soch.facility_receipt fr \r\n"
			+ "join soch.facility_receipt_product frp on(fr.facility_receipt_id=frp.facility_receipt_id)\r\n"
			+ "join soch.product p on(frp.product_id=p.id) left join soch.facility_receipt_status_master frsm\r\n"
			+ "on(fr.facility_receipt_status_id=frsm.id) left join soch.facility_grn_status_master fgsm\r\n"
			+ "on(fr.facility_grn_status_id=fgsm.id) left join soch.master_inventory_unregistered_source ms\r\n"
			+ "on(fr.unregistered_source_id=ms.id) left join soch.address a on(ms.address_id=a.id)\r\n"
			+ "where fr.received_facility_id =:facilityId and fr.unregistered_source_id is not null and exists (\r\n"
			+ "select * from soch.facility_receipt_product frp where frp.facility_receipt_id =fr.facility_receipt_id \r\n"
			+ ") and (LOWER(fr.unregistered_source_indent_number) like :searchvalue% OR LOWER(p.product_name) like :searchvalue%)", nativeQuery = true)
	Page<UnregisteredSourceReceiptProjection> findByReceivedFacilityIdsByNormalSearch(
			@Param("facilityId") Long facilityId, @Param("searchvalue") String searchvalue, Pageable paging);



}
