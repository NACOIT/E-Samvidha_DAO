package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.projection.FacilityDispatchDetailProjection;
import gov.naco.soch.projection.FacilityDispatchHistoryProjection;

@Repository
public interface FacilityDispatchRepository extends JpaRepository<FacilityDispatch, Long>, CustomRepository {

	@Query(value = "select f.* from soch.facility_dispatch f where  f.consignor_facility_id = :consignorId", nativeQuery = true)
	List<FacilityDispatch> findAllByConsignorId(@Param("consignorId") Long consignorId);

	FacilityDispatch findByFacilityDispatchId(Long facilityDispatchId);

	@Query(value = "select fd.facility_dispatch_id as facilityDispatchId,\r\n"
			+ "fd.stn_number as stnNumber,fd.expected_dispatch_date as dispatchdate,date(fd.created_time) as relocateRequestDate,\r\n"
			+ "fd.awb_num as awbNumberOld,fd.transporter_name as transporterNameOld,\r\n"
			+ "fdsm.status as status,frsm.status as requestStatus,f1.id as consigneeId,f1.name as consignee,\r\n"
			+ "f2.name as consignor,f2.id consignorId,sum(fdpb.quantity_dispatched) as totalQuantity,\r\n"
			+ "fdtd.awb_number as awbNumber,mts.name as statusCode,\r\n"
			+ "fdtd.transportation_status_message as statusMessage,fdtd.booking_city as bookingCity,\r\n"
			+ "fdtd.delivery_city as deliveryCity,fdtd.estimated_delivery_date as estimatedDeliveryDate,\r\n"
			+ "fdtd.booking_date as bookingDate,fdtd.actual_delivery_date as actualDeliveryDate,\r\n"
			+ "tr.id as transporterId,tr.name as transporterName,fr.grn_date as receiptDate\r\n"
			+ "from soch.facility_dispatch fd join soch.facility_dispatch_status_master fdsm\r\n"
			+ "on(fd.facility_dispatch_status_id=fdsm.id) join soch.facility f1\r\n"
			+ "on(fd.consignee_facility_id=f1.id) join soch.facility f2 on(fd.consignor_facility_id=f2.id)join soch.facility_dispatch_product fdp\r\n"
			+ "on(fdp.facility_dispatch_id=fd.facility_dispatch_id)\r\n"
			+ "join soch.facility_dispatch_product_batch fdpb\r\n"
			+ "on(fdpb.facility_dispatch_product_id=fdp.facility_dispatch_product_id)\r\n"
			+ "join soch.facility_relocation_request_status_master frsm on(frsm.id=fd.facility_relocation_request_status_id)\r\n"
			+ "left join soch.facility_dispatch_transport_details fdtd on(fd.facility_dispatch_id=fdtd.facility_dispatch_id)\r\n"
			+ "left join soch.facility tr on (fdtd.transporter_id=tr.id)\r\n"
			+ "left join soch.master_transportation_status mts on(fdtd.transportation_status_id=mts.id) "
			+ "left join soch.facility_receipt fr on(fd.facility_dispatch_id=fr.facility_dispatch_id) "
			+ "where fd.consignor_facility_id IN (:consignorIds) and LOWER(fd.dispatch_type)='relocate' group by\r\n"
			+ "fd.facility_dispatch_id ,fd.stn_number,fd.expected_dispatch_date,\r\n"
			+ "fdsm.status,f1.id,f1.name,f2.id,f2.name,frsm.status,fdtd.awb_number,mts.name,fdtd.transportation_status_message,fdtd.booking_city,\r\n"
			+ "fdtd.delivery_city,fdtd.estimated_delivery_date,fdtd.actual_delivery_date,fdtd.booking_date,tr.id,tr.name,fr.grn_date", nativeQuery = true)
	Page<FacilityDispatchHistoryProjection> findByConsignorIdsForRelocate(
			@Param("consignorIds") List<Long> consignorIds, Pageable paging);

	@Query(value = "select fd.facility_dispatch_id as facilityDispatchId,\r\n"
			+ "fd.stn_number as stnNumber,fd.expected_dispatch_date as dispatchdate,date(fd.created_time) as relocateRequestDate,\r\n"
			+ "fdsm.status as status,frsm.status as requestStatus,f1.id as consigneeId,f1.name as consignee,\r\n"
			+ "f2.name as consignor,f2.id consignorId,\r\n" + "sum(fdpb.quantity_dispatched) as totalQuantity,\r\n"
			+ "fdtd.awb_number as awbNumber,mts.name as statusCode,\r\n"
			+ "fdtd.transportation_status_message as statusMessage,fdtd.booking_city as bookingCity,\r\n"
			+ "fdtd.delivery_city as deliveryCity,fdtd.estimated_delivery_date as estimatedDeliveryDate,\r\n"
			+ "fdtd.booking_date as bookingDate,fdtd.actual_delivery_date as actualDeliveryDate,\r\n"
			+ "tr.id as transporterId,tr.name as transporterName,fr.grn_date as receiptDate\r\n"
			+ "from soch.facility_dispatch fd join soch.facility_dispatch_status_master fdsm\r\n"
			+ "on(fd.facility_dispatch_status_id=fdsm.id) join soch.facility f1\r\n"
			+ "on(fd.consignee_facility_id=f1.id) left join soch.address a1 on(f1.address_id=a1.id)\r\n"
			+ "left join soch.district d1 on(a1.district_id=d1.id) join soch.facility f2 on(fd.consignor_facility_id=f2.id)\r\n"
			+ "left join soch.address a2 on(f2.address_id=a2.id) left join soch.district d2 on(a2.district_id=d2.id) join soch.facility_dispatch_product fdp\r\n"
			+ "on(fdp.facility_dispatch_id=fd.facility_dispatch_id) join soch.product p on(fdp.product_id=p.id)\r\n"
			+ "join soch.facility_dispatch_product_batch fdpb\r\n"
			+ "on(fdpb.facility_dispatch_product_id=fdp.facility_dispatch_product_id)\r\n"
			+ "join soch.facility_relocation_request_status_master frsm on(frsm.id=fd.facility_relocation_request_status_id)\r\n"
			+ "left join soch.facility_dispatch_transport_details fdtd on(fd.facility_dispatch_id=fdtd.facility_dispatch_id)\r\n"
			+ "left join soch.facility tr on (fdtd.transporter_id=tr.id)\r\n"
			+ "left join soch.master_transportation_status mts on(fdtd.transportation_status_id=mts.id) "
			+ "left join soch.facility_receipt fr on(fd.facility_dispatch_id=fr.facility_dispatch_id) "
			+ "where fd.consignor_facility_id IN (:consignorIds) and LOWER(fd.dispatch_type)='relocate'\r\n"
			+ "and (LOWER(fd.stn_number) like :searchValue% OR LOWER(fd.indent_num) like :searchValue% OR LOWER(f1.name) like :searchValue% \r\n"
			+ "OR LOWER(f2.name) like :searchValue% OR LOWER(p.product_name) like :searchValue% OR LOWER(d1.name) like :searchValue% OR LOWER(d2.name) like :searchValue%) group by\r\n"
			+ "fd.facility_dispatch_id ,fd.stn_number,fd.expected_dispatch_date,\r\n"
			+ "fdsm.status,f1.id,f1.name,f2.id,f2.name,frsm.status,fdtd.awb_number,mts.name,fdtd.transportation_status_message,fdtd.booking_city,\r\n"
			+ "fdtd.delivery_city,fdtd.estimated_delivery_date,fdtd.actual_delivery_date,fdtd.booking_date,tr.id,tr.name,fr.grn_date", nativeQuery = true)
	Page<FacilityDispatchHistoryProjection> findByConsignorIdsForRelocateByNormalSearch(
			@Param("consignorIds") List<Long> consignorIds, @Param("searchValue") String searchValue, Pageable paging);

	List<FacilityDispatch> findAllByConsignee_IdAndFacilityDispatchStatusMaster_IdInAndConsignor_FacilityType_IdNotInOrderByFacilityDispatchIdDesc(
			Long facilityId, List<Long> statusIds, List<Long> excludedFacilityTypeIds);

	@Query(value = "select fd.facility_dispatch_id as facilityDispatchId,fd.stn_number as stnNumber,fd.expected_dispatch_date as dispatchdate,\r\n"
			+ "fdsm.status as status,f.id as consigneeId,f.name as consignee,u.id as unregFacilityId,u.source_name as unregFacilityName,\r\n"
			+ "sum(fdpb.quantity_dispatched) as totalQuantity,\r\n" + "sum(fdpb.boxes_no) as totalBox,\r\n"
			+ "fdtd.awb_number as awbNumber,mts.name as statusCode,\r\n"
			+ "fdtd.transportation_status_message as statusMessage,fdtd.booking_city as bookingCity,\r\n"
			+ "fdtd.delivery_city as deliveryCity,fdtd.estimated_delivery_date as estimatedDeliveryDate,\r\n"
			+ "fdtd.booking_date as bookingDate,fdtd.actual_delivery_date as actualDeliveryDate,\r\n"
			+ "tr.id as transporterId,tr.name as transporterName,fr.grn_date as receiptDate\r\n"
			+ "from soch.facility_dispatch fd join soch.facility_dispatch_status_master fdsm\r\n"
			+ "on(fd.facility_dispatch_status_id=fdsm.id) left join soch.facility f\r\n"
			+ "on(fd.consignee_facility_id=f.id) left join soch.facility_dispatch_product fdp\r\n"
			+ "on(fdp.facility_dispatch_id=fd.facility_dispatch_id) left join soch.facility_dispatch_product_batch fdpb\r\n"
			+ "on(fdpb.facility_dispatch_product_id=fdp.facility_dispatch_product_id)\r\n"
			+ "left join soch.master_inventory_unregistered_source u on(fd.unregistered_source_id=u.id)"
			+ "left join soch.facility_dispatch_transport_details fdtd on(fd.facility_dispatch_id=fdtd.facility_dispatch_id)\r\n"
			+ "left join soch.facility tr on (fdtd.transporter_id=tr.id)\r\n"
			+ "left join soch.master_transportation_status mts on(fdtd.transportation_status_id=mts.id) "
			+ "left join soch.facility_receipt fr on(fd.facility_dispatch_id=fr.facility_dispatch_id) "
			+ "where fd.consignor_facility_id =:consignorId and LOWER(fd.dispatch_type)='dispatch' group by\r\n"
			+ "fd.facility_dispatch_id ,fd.stn_number,fd.expected_dispatch_date,u.id,u.source_name,\r\n"
			+ "fdsm.status,f.id,f.name,fdtd.awb_number,mts.name,fdtd.transportation_status_message,fdtd.booking_city,\r\n"
			+ "fdtd.delivery_city,fdtd.estimated_delivery_date,fdtd.actual_delivery_date,fdtd.booking_date,tr.id,tr.name,fr.grn_date", nativeQuery = true)
	Page<FacilityDispatchHistoryProjection> findDispatchHistoryByConsignorId(@Param("consignorId") Long consignorId,
			Pageable paging);

	@Query(value = "select fd.facility_dispatch_id as facilityDispatchId,fd.stn_number as stnNumber,fd.expected_dispatch_date as dispatchdate,\r\n"
			+ "fdsm.status as status,f.id as consigneeId,f.name as consignee,u.id as unregFacilityId,u.source_name as unregFacilityName,\r\n"
			+ "sum(fdpb.quantity_dispatched) as totalQuantity,\r\n" + "sum(fdpb.boxes_no) as totalBox,\r\n"
			+ "fdtd.awb_number as awbNumber,mts.name as statusCode,\r\n"
			+ "fdtd.transportation_status_message as statusMessage,fdtd.booking_city as bookingCity,\r\n"
			+ "fdtd.delivery_city as deliveryCity,fdtd.estimated_delivery_date as estimatedDeliveryDate,\r\n"
			+ "fdtd.booking_date as bookingDate,fdtd.actual_delivery_date as actualDeliveryDate,\r\n"
			+ "tr.id as transporterId,tr.name as transporterName,fr.grn_date as receiptDate\r\n"
			+ "from soch.facility_dispatch fd join soch.facility_dispatch_status_master fdsm\r\n"
			+ "on(fd.facility_dispatch_status_id=fdsm.id) left join soch.facility f\r\n"
			+ "on(fd.consignee_facility_id=f.id) left join soch.facility_dispatch_product fdp\r\n"
			+ "on(fdp.facility_dispatch_id=fd.facility_dispatch_id) join soch.product p on(fdp.product_id=p.id) left join soch.facility_dispatch_product_batch fdpb\r\n"
			+ "on(fdpb.facility_dispatch_product_id=fdp.facility_dispatch_product_id)\r\n"
			+ "left join soch.master_inventory_unregistered_source u on(fd.unregistered_source_id=u.id)"
			+ "left join soch.facility_dispatch_transport_details fdtd on(fd.facility_dispatch_id=fdtd.facility_dispatch_id)\r\n"
			+ "left join soch.master_transportation_status mts on(fdtd.transportation_status_id=mts.id)\r\n"
			+ "left join soch.facility tr on (fdtd.transporter_id=tr.id)\r\n"
			+ "left join soch.facility_receipt fr on(fd.facility_dispatch_id=fr.facility_dispatch_id) "
			+ "where fd.consignor_facility_id =:consignorId and LOWER(fd.dispatch_type)='dispatch' and \r\n"
			+ "(LOWER(fd.stn_number) like :searchValue% OR LOWER(fd.indent_num) like :searchValue% OR LOWER(f.name) like :searchValue% OR LOWER(p.product_name) like :searchValue%) group by\r\n"
			+ "fd.facility_dispatch_id ,fd.stn_number,fd.expected_dispatch_date,u.id,u.source_name,\r\n"
			+ "fdsm.status,f.id,f.name,tr.id,tr.name,fdtd.awb_number,mts.name,fdtd.transportation_status_message,\r\n"
			+ "fdtd.booking_city,fdtd.delivery_city,fdtd.estimated_delivery_date,fdtd.booking_date,fdtd.actual_delivery_date,fdtd.booking_date,tr.id,tr.name,fr.grn_date", nativeQuery = true)
	Page<FacilityDispatchHistoryProjection> findDispatchHistoryByConsignorIdByNormalSearch(
			@Param("consignorId") Long consignorId, @Param("searchValue") String searchValue, Pageable paging);

	@Query(nativeQuery = true, value = "select fd.facility_dispatch_id as facilityDispatchId,fd.stn_number as stnNumber,fd.expected_dispatch_date as dispatchDate,\r\n"
			+ "fd.indent_num as indentNumber,consignor.name as consignor from soch.facility_dispatch fd join soch.facility consignor on (fd.consignor_facility_id=consignor.id)\r\n"
			+ "join soch.facility f2 on(fd.consignor_facility_id=f2.id)\r\n"
			+ "where fd.consignee_facility_id=:consigneeId and fd.facility_dispatch_status_id IN :statusIds and consignor.facility_type_id IN :facilityTypeIds  ")
	Page<FacilityDispatchHistoryProjection> findDispatchedListByFacilitytype(@Param("consigneeId") Long consigneeId,
			@Param("statusIds") List<Long> statusIds, @Param("facilityTypeIds") List<Long> facilityTypeIds,
			Pageable paging);

	@Query(nativeQuery = true, value = "select fd.facility_dispatch_id as facilityDispatchId,fd.stn_number as stnNumber,fd.expected_dispatch_date as dispatchDate,\r\n"
			+ "fd.indent_num as indentNumber,consignor.name as consignor from soch.facility_dispatch fd join soch.facility consignor on (fd.consignor_facility_id=consignor.id)\r\n"
			+ "join soch.facility_dispatch_product fdp on(fd.facility_dispatch_id=fdp.facility_dispatch_id) join soch.product p on(fdp.product_id=p.id)\r\n"
			+ "where fd.consignee_facility_id=:consigneeId and fd.facility_dispatch_status_id IN :statusIds and consignor.facility_type_id IN :facilityTypeIds\r\n"
			+ "and (LOWER(fd.stn_number) like :searchValue% OR LOWER(fd.indent_num) like :searchValue% OR LOWER(consignor.name) like :searchValue% OR LOWER(p.product_name) like :searchValue%)")
	Page<FacilityDispatchHistoryProjection> findDispatchedListByFacilitytypeByNormalSearch(
			@Param("consigneeId") Long consigneeId, @Param("statusIds") List<Long> statusIds,
			@Param("facilityTypeIds") List<Long> facilityTypeIds, @Param("searchValue") String searchValue,
			Pageable paging);

	@Query(nativeQuery = true, value = "select fd.facility_dispatch_id as facilityDispatchId,fd.stn_number as stnNumber,fd.expected_dispatch_date as dispatchDate,\r\n"
			+ "fd.indent_num as indentNumber,consignor.name as consignor from soch.facility_dispatch fd join soch.facility consignor on (fd.consignor_facility_id=consignor.id)\r\n"
			+ "join soch.facility f2 on(fd.consignor_facility_id=f2.id)\r\n"
			+ "where fd.consignee_facility_id=:consigneeId and fd.facility_dispatch_status_id IN :statusIds and consignor.facility_type_id NOT IN :excludedFacilityTypeIds  ")
	Page<FacilityDispatchHistoryProjection> findDispatchedListForFacilities(@Param("consigneeId") Long consigneeId,
			@Param("statusIds") List<Long> statusIds,
			@Param("excludedFacilityTypeIds") List<Long> excludedFacilityTypeIds, Pageable paging);

	@Query(nativeQuery = true, value = "select fd.facility_dispatch_id as facilityDispatchId,fd.stn_number as stnNumber,fd.expected_dispatch_date as dispatchDate,\r\n"
			+ "fd.indent_num as indentNumber,consignor.name as consignor from soch.facility_dispatch fd join soch.facility consignor on (fd.consignor_facility_id=consignor.id)\r\n"
			+ "join soch.facility_dispatch_product fdp on(fd.facility_dispatch_id=fdp.facility_dispatch_id) join soch.product p on(fdp.product_id=p.id)\r\n"
			+ "where fd.consignee_facility_id=:consigneeId and fd.facility_dispatch_status_id IN :statusIds and consignor.facility_type_id NOT IN :excludedFacilityTypeIds\r\n"
			+ "and (LOWER(fd.stn_number) like :searchValue% OR LOWER(fd.indent_num) like :searchValue% OR LOWER(consignor.name) like :searchValue% OR LOWER(p.product_name) like :searchValue%)")
	Page<FacilityDispatchHistoryProjection> findDispatchedListForFacilitiesByNormalSearch(
			@Param("consigneeId") Long consigneeId, @Param("statusIds") List<Long> statusIds,
			@Param("excludedFacilityTypeIds") List<Long> excludedFacilityTypeIds,
			@Param("searchValue") String searchValue, Pageable paging);

	@Query(nativeQuery = true, value = "select fd.facility_dispatch_id as facilityDispatchId,fd.stn_number as stnNumber,\r\n"
			+ "fd.expected_dispatch_date as dispatchDate,fd.expected_arrival_date as expectedDeliveyDate,fd.indent_num as indentNumber,\r\n"
			+ "fd.indent_date as indentDate,fd.transporter_name as transporterName,\r\n"
			+ "fd.awb_num as awbNumber,fd.contact_num as contactNumber,fd.driver_name as driverName,\r\n"
			+ "consignee.id as consigneeId,consignee.name as consigneeName,ft1.facility_type_name as consigneeType,\r\n"
			+ "a1.address_line_one as consigneeAddressOne,\r\n"
			+ "a1.address_line_two as consigneeAddressTwo,s1.name as consigneeStateName,\r\n"
			+ "d1.name as consigneeDistrictName,a1.pincode as consigneePincode,\r\n"
			+ "sd1.subdistrict_name as consigneeSubdistrictName,t1.town_name as consigneeTownName, \r\n"
			+ "consignor.id as consignorId,consignor.name as consignorName,ft2.facility_type_name as consignorType,\r\n"
			+ "a2.address_line_one as consignorAddressOne,\r\n"
			+ "a2.address_line_two as consignorAddressTwo,s2.name as consignorStateName,\r\n"
			+ "d2.name as consignorDistrictName,a2.pincode as consignorPincode,\r\n"
			+ "sd2.subdistrict_name as consignorSubdistrictName,t2.town_name as consignorTownName, \r\n"
			+ "mus.id as sourceId,mus.source_name as sourceName,\r\n"
			+ "a3.address_line_one as unregAddress,s3.name as unregStateName,\r\n"
			+ "d3.name as unregDistrictName,a3.pincode as unregPincode,\r\n"
			+ "sd3.subdistrict_name as unregSubdistrictName,t3.town_name as unregTownName,\r\n"
			+ "csm.status as consignmentStatus,dsm.status as dispatchStatus,rsm.status as relocationRequestStatus,\r\n"
			+ "fdtd.awb_number as externalAwbNumber,mts.name as statusCode,\r\n"
			+ "fdtd.transportation_status_message as statusMessage,fdtd.booking_city as bookingCity,\r\n"
			+ "fdtd.delivery_city as deliveryCity,fdtd.estimated_delivery_date as estimatedDeliveryDate,\r\n"
			+ "fdtd.booking_date as bookingDate,fdtd.actual_delivery_date as actualDeliveryDate,\r\n"
			+ "tr.id as transporterId,tr.name as transporter, \r\n"
			+ "(concat(u.firstname,' ', coalesce(u.lastname, '') )) as consigneeUserName,\r\n"
			+ "consignor.facility_type_id as consignorFacilityTypeId,consignee.facility_type_id as consigneeFacilityTypeId,"
			+ "u.landline_number as consigneeLandlineNumber,u.mobile_number as consigneeMobileNumber from soch.facility_dispatch as fd \r\n"
			+ "LEFT OUTER JOIN soch.facility consignee on(fd.consignee_facility_id=consignee.id)\r\n"
			+ "LEFT OUTER JOIN(select u.id,u.facility_id from soch.user_master u join soch.user_role_mapping urm on(u.id=urm.user_id)\r\n"
			+ "join soch.role r on(urm.role_id=r.id) where r.is_primary=true)res on(consignee.id=res.facility_id) "
			+ "LEFT OUTER JOIN soch.user_master u on(u.id=res.id)"
			+ "LEFT OUTER JOIN soch.address a1 on(consignee.address_id=a1.id)\r\n"
			+ "LEFT OUTER JOIN soch.state s1 on(a1.state_id=s1.id)\r\n"
			+ "LEFT OUTER JOIN soch.district d1 on(a1.district_id=d1.id)\r\n"
			+ "LEFT OUTER JOIN soch.subdistrict sd1 on(a1.subdistrict_id=sd1.subdistrict_id )\r\n"
			+ "LEFT OUTER JOIN soch.town t1 on(a1.town_id=t1.town_id )\r\n"
			+ "LEFT OUTER JOIN soch.facility_type ft1 on(consignee.facility_type_id=ft1.id)\r\n"
			+ "LEFT OUTER JOIN soch.facility consignor on(fd.consignor_facility_id=consignor.id)\r\n"
			+ "LEFT OUTER JOIN soch.address a2 on(consignor.address_id=a2.id)\r\n"
			+ "LEFT OUTER JOIN soch.state s2 on(a2.state_id=s2.id)\r\n"
			+ "LEFT OUTER JOIN soch.district d2 on(a2.district_id=d2.id)\r\n"
			+ "LEFT OUTER JOIN soch.subdistrict sd2 on(a2.subdistrict_id=sd2.subdistrict_id )\r\n"
			+ "LEFT OUTER JOIN soch.town t2 on(a2.town_id=t2.town_id )\r\n"
			+ "LEFT OUTER JOIN soch.facility_type ft2 on(consignor.facility_type_id=ft2.id)\r\n"
			+ "LEFT OUTER JOIN soch.master_inventory_unregistered_source mus on(fd.unregistered_source_id=mus.id)\r\n"
			+ "LEFT OUTER JOIN soch.address a3 on(mus.address_id=a3.id)\r\n"
			+ "LEFT OUTER JOIN soch.state s3 on(a3.state_id=s3.id)\r\n"
			+ "LEFT OUTER JOIN soch.district d3 on(a3.district_id=d3.id)\r\n"
			+ "LEFT OUTER JOIN soch.subdistrict sd3 on(a3.subdistrict_id=sd3.subdistrict_id )\r\n"
			+ "LEFT OUTER JOIN soch.town t3 on(a3.town_id=t3.town_id )\r\n"
			+ "LEFT OUTER JOIN soch.facility_consignment_status_master csm on(fd.facility_consignment_status_id=csm.id)\r\n"
			+ "LEFT OUTER JOIN soch.facility_dispatch_status_master dsm on(fd.facility_dispatch_status_id=dsm.id)\r\n"
			+ "LEFT OUTER JOIN soch.facility_relocation_request_status_master rsm on(fd.facility_relocation_request_status_id=rsm.id)\r\n"
			+ "LEFT OUTER JOIN soch.facility_dispatch_transport_details fdtd on(fd.facility_dispatch_id=fdtd.facility_dispatch_id)\r\n"
			+ "LEFT OUTER JOIN soch.master_transportation_status mts on(fdtd.transportation_status_id=mts.id)\r\n"
			+ "LEFT OUTER JOIN soch.facility tr on (fdtd.transporter_id=tr.id)\r\n"
			+ "where fd.facility_dispatch_id=:facilityDispatchId ORDER BY u.created_time asc LIMIT 1")
	FacilityDispatchDetailProjection findDetailsByFacilityDispatchId(
			@Param("facilityDispatchId") Long facilityDispatchId);

	@Query(nativeQuery = true, value = "select fd.stn_number as stnNumber,fdtd.transporter_id as transporterId from soch.facility_dispatch fd\r\n"
			+ "join soch.facility_dispatch_transport_details fdtd\r\n"
			+ "on(fd.facility_dispatch_id=fdtd.facility_dispatch_id)\r\n"
			+ "where fdtd.transporter_id in (:facilityIds) and fd.expected_dispatch_date between :startDate and :endDate")
	List<FacilityDispatchHistoryProjection> findStnNumbersByTransporterIds(@Param("facilityIds") List<Long> facilityIds,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

	@Query(value = "select fd from FacilityDispatch fd JOIN FETCH fd.facilityDispatchTransportDetails")
	List<FacilityDispatch> findAll();

}
