package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.SacepReferralInvestigationTestDetails;
import gov.naco.soch.projection.SacepPlanTestDetailsProjection;

@Repository
public interface SacepReferralInvestigationTestDetailsRepository
		extends JpaRepository<SacepReferralInvestigationTestDetails, Long> {

	@Query(nativeQuery = true, value = "select si.id as sacepReferralInvestigationId,"
			+ "si.sacep_referral_information_id as sacepReferralInformationId,\r\n"
			+ "si.investigation_test_date as investigationTestDate,\r\n"
			+ "si.investigation_test_value as investigationTestValue,\r\n"
			+ "si.investigation_test_type_id as investigationTestTypeId,\r\n" + "mi.name as investigationTestType\r\n"
			+ "from soch.sacep_referral_investigation_test_details si\r\n"
			+ "join soch.master_investigation mi on(si.investigation_test_type_id=mi.id)\r\n"
			+ "where si.sacep_referral_information_id=:sacepReferralInformationId")
	List<SacepPlanTestDetailsProjection> findTestDetailsBySacepReferralInformationId(
			@Param("sacepReferralInformationId") Long sacepReferralInformationId);

	List<SacepReferralInvestigationTestDetails> findAllBySacepReferralInformation_Id(Long sacepReferralInformationId);

	
}
