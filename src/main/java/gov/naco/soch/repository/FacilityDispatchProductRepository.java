package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityDispatchProduct;
import gov.naco.soch.projection.DispatchBatchProjection;
import gov.naco.soch.projection.FacilityDispatchHistoryProjection;

@Repository
public interface FacilityDispatchProductRepository extends JpaRepository<FacilityDispatchProduct, Long> {

	@Query(nativeQuery = true, value = "select fd.facility_dispatch_id as facilityDispatchId,p.product_name as productName\r\n"
			+ "from soch.facility_dispatch fd join soch.facility_dispatch_product fdp\r\n"
			+ "on(fd.facility_dispatch_id=fdp.facility_dispatch_id) join soch.product p\r\n"
			+ "on(p.id=fdp.product_id) where fd.facility_dispatch_id IN :facilityDispatchIds")
	List<FacilityDispatchHistoryProjection> findByFacilityDispatchId(
			@Param("facilityDispatchIds") List<Long> facilityDispatchIds);

	@Query(nativeQuery = true, value = "select fdp.product_id as productId,p.product_name as productName,\r\n"
			+ "fdpb.batch_number as batchNumber,\r\n"
			+ "fdpb.batch_expiry_date as expiredDate,fdpb.batch_manufacture_date as manufacturingDate,\r\n"
			+ "fdpb.quantity_dispatched as quantityDispatched,fdpb.boxes_no as numberOfBoxes\r\n"
			+ "from soch.facility_dispatch_product fdp join soch.product p on(fdp.product_id=p.id)\r\n"
			+ "join soch.facility_dispatch_product_batch fdpb\r\n"
			+ "on(fdpb.facility_dispatch_product_id=fdp.facility_dispatch_product_id)\r\n"
			+ "where fdp.facility_dispatch_id=:facilityDispatchId")
	List<DispatchBatchProjection> findFacilityDispatchProductDetails(
			@Param("facilityDispatchId") Long facilityDispatchId);

}
