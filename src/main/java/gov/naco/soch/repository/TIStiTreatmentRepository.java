package gov.naco.soch.repository;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIStiTreatment;


/**
 * Spring Data  repository for the TIStiTreatment entity.
 */
@Repository
public interface TIStiTreatmentRepository extends JpaRepository<TIStiTreatment, Long>, JpaSpecificationExecutor<TIStiTreatment> {

	boolean existsByBeneficiary_IdAndDiagnosisType_IdAndFollowUpDate(Long beneficiaryId, Long diagnosisId,
			LocalDate now);

	@Query("select distinct firstFollowupDate from TIStiTreatment where diagnosisType.id=:diagnosisId and beneficiary.id=:beneficiaryId")
	LocalDate findByDiagnosisAndBeneficiaryId(@Param("diagnosisId")Long diagnosisId,@Param("beneficiaryId") Long beneficiaryId);
        
	@Query("select  max(id) from TIStiTreatment where diagnosisType.id=:diagnosisId and beneficiary.id=:beneficiaryId ")
	Long findLatestRecord(@Param("diagnosisId")Long diagnosisId, @Param("beneficiaryId")Long beneficiaryId);

}
