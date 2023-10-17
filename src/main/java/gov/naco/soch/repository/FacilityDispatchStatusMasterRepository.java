package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityDispatchStatusMaster;

@Repository
public interface FacilityDispatchStatusMasterRepository extends JpaRepository<FacilityDispatchStatusMaster, Long> {

	FacilityDispatchStatusMaster findByStatusAndIsDelete(String status, Boolean isDelete);

}
