/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryImmunizationReport;
import gov.naco.soch.projection.ArtBeneficiaryImmunizationReportProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface ArtBeneficiaryImmunizationReportRepository
		extends JpaRepository<ArtBeneficiaryImmunizationReport, Long> {

	/**
	 * @param beneficiaryid
	 * @return
	 */
	@Query(nativeQuery = true, value = " select abir.id as id, mvs.id as vaccineStageId, mvs.name as vaccineStageName, mvt.id as vaccineTypeId," + 
			" mvt.name as vaccineTypeName , abir.due_date as dueDate, abir.given_date as givenDate" + 
			" from soch.art_beneficiary_immunization_report as abir" + 
			" left join soch.master_vaccine_stage as mvs on mvs.id = abir.vaccine_stage_id" + 
			" left join soch.master_vaccine_type as mvt on mvt.id= abir.vaccine_type_id" + 
			" where abir.beneficiary_id=:beneficiaryId")
	List<ArtBeneficiaryImmunizationReportProjection> findArtBeneficiaryImmunizationReportsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	/*@Modifying
	@Query(nativeQuery = true, value = "delete from soch.art_beneficiary_immunization_report where beneficiary_id=:beneficiaryId ")*/
	void deleteByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select count(*) from soch.art_beneficiary_immunization_report where beneficiary_id=:beneficiaryId ")
	int findCountByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select bir.due_date as dueDate, bir.given_date as givenDate, mvs.name as vaccineStage, mvt.name as vaccineType " + 
			"from soch.art_beneficiary_immunization_report as bir " + 
			"left join soch.master_vaccine_stage as mvs on mvs.id = bir.vaccine_stage_id " + 
			"left join soch.master_vaccine_type as mvt on mvt.id = bir.vaccine_type_id " + 
			"where bir.beneficiary_id = :beneficiaryId")
	List<WhiteCardDetailsProjection> findAllImmunizationDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

}
