package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ReceiptStatusMaster;

@Repository
public interface ReceiptStatusRepository  extends JpaRepository<ReceiptStatusMaster, Integer> {

	@Query(nativeQuery=true,value="select status from soch.facility_receipt_status_master where id=:id")
	String findStatusById(@Param("id")Long id);

	List<ReceiptStatusMaster> findByIsDelete(Boolean false1);

}
