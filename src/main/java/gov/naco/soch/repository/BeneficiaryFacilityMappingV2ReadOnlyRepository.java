package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.BeneficiaryFacilityMappingV2ReadOnly;



public interface BeneficiaryFacilityMappingV2ReadOnlyRepository  extends JpaRepository<BeneficiaryFacilityMappingV2ReadOnly, Long>, JpaSpecificationExecutor<BeneficiaryFacilityMappingV2ReadOnly>{

	
	 String query ="\r\n" + 
	 		"   select * \r\n" + 
	 		"   from soch.beneficiary_facility_mapping bfm\r\n" + 
	 		"   left outer join soch.facility fac on bfm.facility_id=fac.id\r\n" + 
	 		"   left outer join soch.facility_type ft on ft.id = fac.facility_type_id\r\n" + 
	 		"   where  bfm.beneficiary_id=:beneficiaryId and bfm.is_delete=false\r\n" + 
	 		"   \r\n" + 
	 		"   ";
	 @Query(nativeQuery = true, value = query)
	    List<BeneficiaryFacilityMappingV2ReadOnly> findBeneficiaryFacilityMappingV2ReadOnlyByBenID(
				@Param("beneficiaryId") Long beneficiaryId);
}
