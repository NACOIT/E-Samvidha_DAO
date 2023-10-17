package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.projection.SacepReferralRrfPdfProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface ArtBeneficiaryClinicalDetailRepository extends JpaRepository<ArtBeneficiaryClinicalDetail, Long> {

	@Query(nativeQuery = true, value = "select b.* from soch.art_beneficiary_clinical_details as b "
			+ "where b.beneficiary_id = :beneficiaryId and b.visit_register_id = :visitRegisterId order by b.id desc limit 1")
	Optional<ArtBeneficiaryClinicalDetail> findByBeneficiaryIdAndVisitRegisterId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("visitRegisterId") Long visitRegisterId);
	
	@Query("select b from ArtBeneficiaryClinicalDetail b left join fetch b.regimen "
			+ "where b.beneficiary.id = :beneficiaryId and b.beneficiaryVisitRegister.id = :visitRegisterId and b.regimen.isDelete=false order by b.id desc")
	List<ArtBeneficiaryClinicalDetail> findRegimenByBeneficiaryIdAndVisitRegisterId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("visitRegisterId") Long visitRegisterId);


	/*@Query(nativeQuery = true, value = "select " + " beneficiary_id " + " from " + " ( " + " select "
			+ " beneficiary_id, treatment_line_id " + " from " + " soch.art_beneficiary_clinical_details " + " where "
			+ " id in ( " + " select " + " max(id) as id " + " from " + " soch.art_beneficiary_clinical_details "
			+ " group by " + " beneficiary_id ) ) as result " + " where "
			+ " treatment_line_id in (:lineOfTreatmentIds)")*/
	
	@Query(nativeQuery = true, value = "select " + 
			" distinct(beneficiary_id) " + 
			" from " + 
			" ( " + 
			" select " + 
			" beneficiary_id, treatment_line_id " + 
			" from " + 
			" soch.art_beneficiary_clinical_details " + 
			" where " + 
			" id in ( " + 
			" select " + 
			" max(id) as id " + 
			" from " + 
			" soch.art_beneficiary_clinical_details " + 
			" group by " + 
			" beneficiary_id ) ) as result " + 
			" where " + 
			" treatment_line_id in (:lineOfTreatmentIds)")
	Set<Long> findLineOfTreatmentBeneficiaryList(@Param("lineOfTreatmentIds") Set<Long> lineOfTreatmentIds);

	@Query(nativeQuery = true, value = "select reg.regimen_name as regimenName ,mar.name as regimenAction, "
			+ "rar.name as regimenActionReason ,acd.art_regimen_action_reason_id as reasonCode ,bvr.visit_date as visitDate ,acd.art_regimen_action_id as actionId "
			+ "from soch.art_beneficiary_clinical_details as acd "
			+ "join soch.beneficiary_visit_register as bvr on bvr.id = acd.visit_register_id "
			+ "left join soch.regimen as reg on reg.id = acd.regimen_id "
			+ "left join soch.master_art_regimen_action as mar on mar.id = acd.art_regimen_action_id "
			+ "left join soch.master_art_regimen_action_reasons as rar on rar.id = acd.art_regimen_action_reason_id "
			+ "where bvr.beneficiary_id =:beneficiaryId order by acd.visit_register_id asc")
	List<WhiteCardDetailsProjection> findTreatmentDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select bvr.visit_date ,mha.name as alcoholHabit,mhs.name as smokingHabit ,mtu.name as tobaccoUse ,moa.name as coexistingCondition "
			+ "	from soch.art_beneficiary_clinical_details as abc "
			+ "	join soch.beneficiary_visit_register as bvr on bvr.id = abc.visit_register_id "
			+ "	left join soch.art_beneficiary_coexisting_conditions as bcc on bcc.visit_register_id = bvr.id "
			+ "	left join soch.master_other_ailments as moa on moa.id = bcc.coexisting_condition_id "
			+ "	left join soch.master_habits_alcohol_use as mha on mha.id = abc.habits_alcohol_use "
			+ "	left join soch.master_habits_smoking as mhs on mhs.id = abc.habits_smoking "
			+ "	left join soch.master_tobacco_use as mtu on mtu.id = abc.tobacco_use "
			+ "	where abc.beneficiary_id = :beneficiaryId order by bvr.id desc limit 1")
	WhiteCardDetailsProjection findHabitByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_clinical_details abcd \r\n"
			+ "join soch.beneficiary_visit_register bvr on abcd.visit_register_id =bvr.id \r\n"
			+ "where abcd.beneficiary_id=:beneficiaryId and abcd.is_delete=false and abcd.is_active=true \r\n"
			+ "and bvr.is_delete=false and bvr.is_active=true \r\n" + "order by bvr.id desc limit 1")
	ArtBeneficiaryClinicalDetail findByBeneficiaryIdAndMaxOfVistRegisterId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select bcd.other_clinical_notes as otherClinicalNotes, bcd.obstetric_gravida_value as obstetricGravidaValue , bcd.obstetric_parity_value as obstetricParityValue, bcd.obstetric_abortus_value as obstetricAbortusValue , r.regimen_name as regimenName ,"
			+ "bvr.is_pregnant as isPregnant " 
			+ "from soch.art_beneficiary_clinical_details bcd "
			+ "left join soch.regimen as r on r.id = bcd.regimen_id "
			+ "left join soch.beneficiary_visit_register as bvr on bvr.id = bcd.visit_register_id "
			+ "where bcd.beneficiary_id = :beneficiaryId order by bcd.visit_register_id desc limit 1")
	SacepReferralRrfPdfProjection findDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

}
