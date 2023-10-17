package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityReceiptStatusMaster;

@Repository
public interface FacilityReceiptStatusMasterRepository extends JpaRepository<FacilityReceiptStatusMaster, Long> {

	@Query(nativeQuery = true, value = "select status from soch.facility_receipt_status_master where id=:id")
	String findNameById(@Param("id") Long id);

	List<FacilityReceiptStatusMaster> findByIsDelete(Boolean false1);

}
