package gov.naco.soch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.BeneficiaryTransitFacility;

@Repository
public interface BeneficiaryTransitFacilityRepository extends JpaRepository<BeneficiaryTransitFacility, Long>, JpaSpecificationExecutor<BeneficiaryTransitFacility>{

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_transit_facility as b where b.beneficiary_id = :beneficiaryId and b.is_Delete =:isDelete and b.is_active=true")
	List<BeneficiaryTransitFacility> findByBeneficiaryIdAndIsDelete(@Param("beneficiaryId")Long beneficiaryId, @Param("isDelete")boolean isDelete);
	
	List<BeneficiaryTransitFacility> findByBeneficiaryId(Long beneficiaryId);

}
