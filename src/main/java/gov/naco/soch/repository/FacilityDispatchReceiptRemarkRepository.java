package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityDispatchReceiptRemark;
import gov.naco.soch.projection.RemarkProjection;

@Repository
public interface FacilityDispatchReceiptRemarkRepository extends JpaRepository<FacilityDispatchReceiptRemark, Long> {

	@Query(nativeQuery=true,value="select r.remarks as remarks,r.created_time as date,u.firstname as userName\r\n"
			+ "from soch.facility_dispatch_receipt_remarks r join soch.user_master u on (r.created_by=u.id) where r.facility_receipt_id=:receiptId")
	List<RemarkProjection> findByFacilityReceiptId(@Param("receiptId")Long receiptId);
	
	@Query(nativeQuery=true,value="select r.remarks as remarks,r.created_time as date,u.firstname as userName\r\n"
			+ "from soch.facility_dispatch_receipt_remarks r join soch.user_master u on (r.created_by=u.id) where r.facility_dispatch_id=:facilityDispatchId")
	List<RemarkProjection> findByFacilityDispatchId(@Param("facilityDispatchId")Long facilityDispatchId);

}
