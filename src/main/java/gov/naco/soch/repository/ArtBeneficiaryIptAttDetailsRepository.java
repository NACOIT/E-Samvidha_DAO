package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryIptAttDetails;
import gov.naco.soch.projection.ArtBeneficiaryIptAttDetailsProjection;
import gov.naco.soch.projection.SacepReferralRrfPdfProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface ArtBeneficiaryIptAttDetailsRepository extends JpaRepository<ArtBeneficiaryIptAttDetails, Long> {
	
	@Query(nativeQuery = true, value = "select b.* from soch.art_beneficiary_ipt_att_details as b "
			+ " where b.beneficiary_id = :beneficiaryId and b.visit_register_id = :visterId order by b.id desc limit 1")
	Optional<ArtBeneficiaryIptAttDetails> findByBeneficiaryIdAndVisitRegisterId(@Param("beneficiaryId")Long beneficiaryId,
			@Param("visterId")Long visterId);

	@Query(nativeQuery = true, value = " select " + 
			" distinct(beneficiary_id) " + 
			" from " + 
			" ( " + 
			" select " + 
			" beneficiary_id, ipt_status_id " + 
			" from " + 
			" soch.art_beneficiary_ipt_att_details " + 
			" where " + 
			" id in ( " + 
			" select " + 
			" max(id) as id " + 
			" from " + 
			" soch.art_beneficiary_ipt_att_details " + 
			" group by " + 
			" beneficiary_id ) ) as result " + 
			" where " + 
			" ipt_status_id in (:statusId) ")
	Set<Long> findOnIptBeneficiaryList(@Param("statusId") List<Long> statusId);

	@Query(nativeQuery = true, value = " select " + 
			" distinct(beneficiary_id) " + 
			" from " + 
			" ( " + 
			" select " + 
			" beneficiary_id, tb_treatment_status_id " + 
			" from " + 
			" soch.art_beneficiary_ipt_att_details " + 
			" where " + 
			" id in ( " + 
			" select " + 
			" max(id) as id " + 
			" from " + 
			" soch.art_beneficiary_ipt_att_details " + 
			" group by " + 
			" beneficiary_id ) ) as result " + 
			" where " + 
			" tb_treatment_status_id in (:statusId) ")
	Set<Long> findOnAttBeneficiaryList(@Param("statusId")  List<Long> statusId);

	@Query(nativeQuery = true, value ="	select ipt.beneficiary_id as beneficiaryId,ipt.att_start_date as attStartDate,ipt.cpt_start_date as cptStartDate," + 
			"	ipt.entry_date as entryDate,ipt.four_s_screening_id as masterFourSScreening,ipt.ipt_end_date as iptEndDate," + 
			"	ipt.ipt_restart_date as iptRestartDate,ipt.ipt_start_date as iptStartDate,ipt.ipt_status_id as masterIptStatus," + 
			"	ipt.ipt_stop_date as iptStopDate,ipt.is_active as isActive,ipt.is_delete as isDelete,ipt.nikshay_id as nikshayId," + 
			"	ipt.rif_resistance as rifResistance,ipt.tb_diagnosis as tbDiagnosis,ipt.tb_diagnosis_id as masterTbResult," + 
			"	ipt.tb_history as tbHistory,ipt.tb_regimen_id as masterTbRegimen,ipt.tb_treatment_completion_date as tbTreatmentCompletionDate," + 
			"	ipt.tb_treatment_status_id as masterTbTreatmentStatus,ipt.treatment_under_id as treatmentUnderId,ipt.tb_test_type_id as tbTestTypeId," + 
			"	ipt.tb_test_referred_date as tbTestReferredDate,ipt.tb_test_type_other as tbTestTypeOther," + 
			"	ipt.treatment_outcome_id as masterTreatmentOutcome " + 
			"	from soch.art_beneficiary_ipt_att_details ipt " + 
			"	where beneficiary_id =:beneficiaryId order by visit_register_id desc limit 1")
	ArtBeneficiaryIptAttDetailsProjection getIptAttDetailsProjection(@Param("beneficiaryId")Long beneficiaryId);

	@Query(nativeQuery = true, value ="select mtr.name as diseaseClass ,reg.name as tbRegimen ,ipt.att_start_date as startOfRx ," + 
			"ipt.tb_treatment_completion_date as completionDate , mto.name as treatmentOutcome,ipt.ipt_start_date as iptStartDate,ipt.ipt_end_date as iptEndDate " + 
			"from soch.art_beneficiary_ipt_att_details as ipt " + 
			"join soch.beneficiary_visit_register as bvr on bvr.id = ipt.visit_register_id " + 
			"left join soch.master_tb_result as mtr on mtr.id = ipt.tb_diagnosis_id " + 
			"left join soch.master_tb_regimen as reg on reg.id = ipt.tb_regimen_id " + 
			"left join soch.master_treatment_outcome as mto on mto.id = ipt.treatment_outcome_id " + 
			"where bvr.beneficiary_id =:beneficiaryId order by bvr.id asc")
	List<WhiteCardDetailsProjection> findTbtreatmentDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select ipt.drugs_prescribed_for_oi_others as drugsPrescribedOiOthers,fs.name as fourSScreening, abf.any_other_medicine as anyOtherMedicine,mcs.name as clinicalStageName from soch.art_beneficiary_ipt_att_details as ipt\r\n" + 
			"left join soch.art_beneficiary_followup as abf on abf.beneficiary_id=ipt.beneficiary_id left join soch.master_clinical_stage as mcs on mcs.id=abf.clinical_stage_id  left join soch.master_four_s_screening as fs on fs.id=ipt.four_s_screening_id \r\n" + 
			"where ipt.beneficiary_id=:beneficiaryId order by ipt.id desc limit 1")
	SacepReferralRrfPdfProjection findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
}
