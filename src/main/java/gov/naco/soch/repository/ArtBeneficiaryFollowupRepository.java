package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface ArtBeneficiaryFollowupRepository
		extends JpaRepository<ArtBeneficiaryFollowup, Long>, JpaSpecificationExecutor<ArtBeneficiaryFollowup> {

	ArtBeneficiaryFollowup findByBeneficiaryIdAndAndIsDelete(Long beneficiaryId, boolean b);

	@Query(nativeQuery = true, value = "select f.* from soch.art_beneficiary_followup as f where f.visit_register_id = :visitRegisterId order by f.id desc limit 1")
	Optional<ArtBeneficiaryFollowup> findByVisitRegisterId(@Param("visitRegisterId") Long visitRegisterId);

	@Query(nativeQuery = true, value = "select b.* from soch.art_beneficiary_followup as b "
			+ "where b.beneficiary_id = :beneficiaryId and b.visit_register_id = :visitRegisterId order by b.id desc limit 1")
	Optional<ArtBeneficiaryFollowup> findByBeneficiaryIdAndVisitRegisterId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("visitRegisterId") Long visitRegisterId);

	ArtBeneficiaryFollowup findByBeneficiaryVisitRegisterIdAndAndIsDelete(Long id, boolean b);
	
	@Query(nativeQuery = true, value="Select * from soch.art_beneficiary_followup where is_delete=false and beneficiary_id=:beneficiary_id and visit_date= Current_Date ")
    ArtBeneficiaryFollowup findByBeneficiaryIdAndIsdeleteAndVisitDate(@Param ("beneficiary_id") Long beneficiary_id);

	@Query("select adherenceToArt from ArtBeneficiaryFollowup where beneficiary.id=:beneficiaryId and isDelete=:isDelete ")
	Long getAdherence(@Param("beneficiaryId")Long beneficiaryId,@Param("isDelete")boolean isDelete);

	@Query(nativeQuery = true, value = " select distinct(bf.beneficiary_id) from " + 
			" ( select bf.beneficiary_id,max(bf.id) m_id from soch.art_beneficiary_followup bf " + 
			" where exists (select 1 from soch.art_beneficiary_followup bfu " + 
			" where bfu.beneficiary_id = bf.beneficiary_id and bfu.clinical_stage_id is not null) " + 
			" group by beneficiary_id) r " + 
			" left join soch.art_beneficiary_followup bf on bf.id = m_id " + 
			" where clinical_stage_id in (:whoClinicalIds) ")
	Set<Long> findWhoClinicalBeneficiaryList(@Param("whoClinicalIds") Set<Long> whoClinicalIds);

	@Query(nativeQuery = true,value = "select bvr.visit_date as visitDate , bvr.weight ,mcs.name as clinicalStage , mfs.name as functionalStatus " + 
			"from soch.art_beneficiary_followup as abf " + 
			"join soch.beneficiary_visit_register as bvr on bvr.id = abf.visit_register_id " + 
			"left join soch.master_client_status as mcs on mcs.id = abf.clinical_stage_id " + 
			"left join soch.master_functional_status as mfs on mfs.id = abf.functional_status_id " + 
			"where bvr.beneficiary_id =:beneficiaryId order by bvr.id asc")
	List<WhiteCardDetailsProjection> findVisitedDateByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true,value = "select bvr.visit_date as visitDate , bvr.weight as weight, bvr.height as height , " + 
			"adl.expected_visit_date as nextDate ,mfs.name as fuctionalStatus , mcs.name as clinicalStage, " + 
			"reg.regimen_name as regimenName ,abf.any_other_medicine as otherMedicine ,bvr.four_s_symptoms as fourS , " + 
			"mtr.name as tbRegimen ,abf.remarks as remarks ,abf.visit_register_id as visitRegisterId ,abf.remaining_pills as remainingPills , " + 
			"abf.adherence_to_art as adherenceToArt ,abf.drugs_prescribed_for_opportunistic_infections_prophylaxis as cpt, " + 
			"abf.other_drugs_for_opportunistic_infections as otherWithDose " +  
			"from soch.art_beneficiary_followup as abf " + 
			"join soch.beneficiary_visit_register as bvr on bvr.id = abf.visit_register_id " + 
			"left join soch.art_beneficiary_due_list as adl on adl.visit_register_id = bvr.id " + 
			"left join soch.master_functional_status as mfs on mfs.id = abf.functional_status_id " + 
			"left join soch.master_clinical_stage as mcs on mcs.id = abf.clinical_stage_id " + 
			"left join soch.art_beneficiary_clinical_details as abc on abc.visit_register_id = bvr.id " + 
			"left join soch.regimen as reg on reg.id = abc.regimen_id " + 
			"left join soch.art_beneficiary_ipt_att_details as bia on bia.visit_register_id = bvr.id " + 
			"left join soch.master_tb_regimen as mtr on mtr.id = bia.tb_regimen_id " + 
			"where abf.beneficiary_id = :beneficiaryId order by bvr.id asc")
	List<WhiteCardDetailsProjection> findfollowDetails(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true,value = "select distinct (abf.beneficiary_id) from soch.art_beneficiary_followup as abf " + 
			" join soch.master_clinical_stage as mcs on mcs.id = abf.clinical_stage_id " + 
			" where abf.clinical_stage_id = :clinicalStageId ")
	Set<Long> findOnArtLessStableClinicalStageBeneficiaryList(@Param("clinicalStageId") Long clinicalStageId);

	
	@Query(nativeQuery = true,value = " select abf.beneficiary_id from soch.art_beneficiary_followup as abf where abf.tb_treatment =true and abf.is_active =true and abf.is_delete =false ")
	Set<Long> findOnArtUnStableHavingTbBeneficiaryList();
	
	@Query(nativeQuery = true, value="Select * from soch.art_beneficiary_followup as f where f.is_delete=false and f.beneficiary_id=:beneficiaryId and f.facility_id=:facilityId order by f.id desc limit 1 ")
    Optional<ArtBeneficiaryFollowup> findByBeneficiaryIdAndFacilityId(@Param("beneficiaryId") Long beneficiaryId,@Param("facilityId") Long facilityId);
}
