package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryIctcStatusTracking;

//repository mapped with entity class RoleAccessMapping
@Repository
public interface BeneficiaryIctcStatusTrackingRepository extends JpaRepository<BeneficiaryIctcStatusTracking, Long> {
	
	@Query(nativeQuery = true,value = "select * from soch.beneficiary_ictc_status_tracking ist where ist.beneficiary_id =:beneficiaryId"
			+ " order by id desc limit 1 ")
	BeneficiaryIctcStatusTracking getPreviousStatus(@Param("beneficiaryId")Long beneficiaryId);

}
