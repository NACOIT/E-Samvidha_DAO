package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityConsignmentStatusMaster;

@Repository
public interface FacilityConsignmentStatusMasterRepository
		extends JpaRepository<FacilityConsignmentStatusMaster, Long> {

	FacilityConsignmentStatusMaster findByStatusAndIsDelete(String status, Boolean isDelete);

	List<FacilityConsignmentStatusMaster> findByIsDelete(Boolean false1);

}
