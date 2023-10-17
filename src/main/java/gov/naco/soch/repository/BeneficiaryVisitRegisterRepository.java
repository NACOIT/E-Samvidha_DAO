package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.projection.ArtBeneficiaryListByIdProjection;
import gov.naco.soch.projection.ArtRegistrationProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

import javax.transaction.Transactional;

@Repository
public interface BeneficiaryVisitRegisterRepository extends JpaRepository<BeneficiaryVisitRegister, Long> {

	@Query(value = "select * from soch.beneficiary_visit_register bvr where bvr.visit_date=:localDate and bvr.beneficiary_id=:beneficiaryId and bvr.facility_id = :facilityId and is_delete=false and is_active=true order by bvr.id desc LIMIT 1", nativeQuery = true)
	Optional<BeneficiaryVisitRegister> findByfacilityIdAndBeneficiaryId(@Param("facilityId") Long facilityId,
			@Param("beneficiaryId") Long beneficiaryId, @Param("localDate") LocalDate localDate);

	List<BeneficiaryVisitRegister> findAllByIsDelete(boolean b);

	@Query(value = "select * from soch.beneficiary_visit_register bvr where bvr.beneficiary_id=:beneficiaryId and is_delete=:b order by bvr.id desc LIMIT 1", nativeQuery = true)
	BeneficiaryVisitRegister findAllByBeneficiaryIdAndIsDelete(@Param("beneficiaryId") Long beneficiaryId,
			@Param("b") boolean b);

	BeneficiaryVisitRegister findByBeneficiaryId(Long beneficiaryId);

	List<BeneficiaryVisitRegister> findByBeneficiaryIdAndIsDelete(Long beneficiaryId, boolean b);

	@Query(value = "select * from soch.beneficiary_visit_register where beneficiary_id=:beneficiaryId "
			+ "and facility_id=:facilityId order by id DESC limit 4", nativeQuery = true)
	List<BeneficiaryVisitRegister> getVisitedId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value="select * from soch.beneficiary_visit_register bvr where bvr.beneficiary_id=:beneficiaryId and bvr.facility_id=:facilityId ")
	Optional<List<BeneficiaryVisitRegister>> findBeneficiaryVisitRegisterList(@Param("beneficiaryId") Long beneficiaryId,@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value="	select bvr.id,bvr.beneficiary_id as beneficiaryId,bq.assigned_to as assignedTo,dq.expected_visit_date as expectedVisitDate," + 
			"	ad.dispense_date as dispenseDate, adi.dispense_quantity as dispenseQuantity," + 
			"	adi.adherence_to_art as adherenceToArt,adi.remaining_pills as remainingPills," + 
			"	adi.dosage_qty as dosageQty, adi.regimen_id as regimen," + 
			"	mfs.name as functionStatusName, mcs.name as clinicaName, abf.ili_symptoms as iliSymptoms," + 
			"	abf.contact_with_covid as contactWithCovid,bcd.treatment_line_id as masterTreatmentLine," +
			"   bcd.pap_smear as papSmear,bcd.pptct_referred as ispptctReferred,bcd.pptct_pregnancy_remarks as pptctPregnancyRemarks, " + 
			"   rbc.regimen_name as regimenName,bcd.regimen_id as regimenId"+
			"	from soch.beneficiary_visit_register as bvr " + 
			"	left join soch.beneficiary_social_welfare_schemes as sws on sws.beneficiary_id=bvr.beneficiary_id" + 
			"	left join soch.art_beneficiary_followup as abf on abf.visit_register_id = bvr.id" + 
			"	left join soch.art_beneficiary_clinical_details as bcd on bcd.visit_register_id = bvr.id" + 
			"   left join soch.regimen as rbc on rbc.id = bcd.regimen_id"+
			"	left join soch.art_dispensation as ad on ad.visit_register_id = bvr.id" + 
			"	left join soch.art_beneficiary_queue as bq on bq.visit_register_id = bvr.id" + 
			"	left join soch.art_beneficiary_due_list as dq on dq.visit_register_id = bvr.id" + 
			"	left join soch.art_dispensation_item as adi on adi.art_dispensation_id=ad.id" + 
			"	left join soch.master_functional_status as mfs on mfs.id = abf.functional_status_id" + 
			"	left join soch.master_clinical_stage as mcs on mcs.id = abf.clinical_stage_id" + 
			"	where bvr.beneficiary_id =:beneficiaryId and bvr.facility_id =:facilityId order by bvr.id desc limit 1")
	ArtBeneficiaryListByIdProjection findListByIdDetails(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value= "select bvr.lmp as lmpDate FROM soch.beneficiary_visit_register as bvr where bvr.is_pregnant ='true' and bvr.beneficiary_id =:beneficiaryId group by bvr.lmp order by bvr.lmp asc")
	List<WhiteCardDetailsProjection> findPregnancyDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value= "select bvr.lmp as lmpDate FROM soch.beneficiary_visit_register as bvr where bvr.beneficiary_id =:beneficiaryId group by bvr.lmp order by bvr.lmp desc")
	List<WhiteCardDetailsProjection> findlmpDateByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value=" select bvr.beneficiary_id from soch.beneficiary_visit_register as bvr " + 
			" where bvr.is_pregnant =true and bvr.is_active =true and bvr.is_delete =false ")
	Set<Long> findOnArtUnStablePregnantWomenIdsBeneficiaryList();
	
	@Modifying
	@Transactional
	@Query(value = "update soch.beneficiary_visit_register bv set delivery_outcome_id =:deliveryOutcomeId where bv.id = \n" +
			" (select id from soch.beneficiary_visit_register where beneficiary_id=:motherBeneficiaryId  order by id desc limit 1)", nativeQuery = true)
	int updateDeliveryOutCome(@Param("deliveryOutcomeId") Long deliveryOutcomeId,@Param("motherBeneficiaryId") Long motherBeneficiaryId);

	@Query(nativeQuery = true, value = "select bvr.visit_date from soch.beneficiary_visit_register as bvr where bvr.beneficiary_id = :beneficiaryId order by bvr.id desc")
	LocalDate findLastVisitedDateByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select count(bvr.visit_date) from soch.beneficiary_visit_register as bvr where bvr.beneficiary_id = :beneficiaryId ")
	Long findTotalCountOfVisitedDate(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select bvr.visit_date from soch.beneficiary_visit_register bvr where bvr.id = :visitId")
	LocalDate findLastVisitedDateByVisitRegisterId(@Param("visitId") Long visitId);

	@Query(nativeQuery = true, value = "select bvr.id from soch.beneficiary_visit_register bvr where bvr.visit_date = :historyDate and bvr.beneficiary_id = :beneficiaryId and bvr.facility_id = :facilityId")
	Long findVisitRegisterIdByVisitedDate(@Param("historyDate") LocalDate historyDate,@Param("beneficiaryId") Long beneficiaryId,@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select mdo.name as deliveryOutcome , bvr.lmp as lmpDate , bvr.is_pregnant as isPregnant " + 
			"from soch.beneficiary_visit_register as bvr  " + 
			"left join soch.master_delivery_outcome as mdo on mdo.id = bvr.delivery_outcome_id " + 
			"where bvr.beneficiary_id =:beneficiaryId and bvr.is_pregnant = true  order by bvr.lmp asc")
	List<WhiteCardDetailsProjection> findDeliveryDetails(@Param("beneficiaryId") Long beneficiaryId);

	@Query(value = "select * from soch.beneficiary_visit_register where beneficiary_id=:beneficiaryId "
			+ "order by id DESC limit 4", nativeQuery = true)
	List<BeneficiaryVisitRegister> getVisitedId(@Param("beneficiaryId") Long beneficiaryId);

	

}
