package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.SacepReferralInformation;
import gov.naco.soch.projection.SacepReferralRrfPdfProjection;
import gov.naco.soch.projection.SacepPlanAppointmentDetailsProjection;
import gov.naco.soch.projection.SacepReferralInformationProjection;

@Repository
public interface SacepReferralInformationRepository extends JpaRepository<SacepReferralInformation, Long> {

	@Query(nativeQuery = true, value = "Select * from soch.sacep_referral_information as s where s.is_delete=false and s.is_active=true and s.beneficiary_referral_id=:beneficiaryReferralId order by s.id desc limit 1")
	Optional<SacepReferralInformation> findByBenefciaryReferralId(
			@Param("beneficiaryReferralId") Long beneficiaryReferralId);

	@Query(nativeQuery = true, value = "select beneficiary_referral_id as BeneficiaryReferralId,is_referred_via_nodalofficer as IsReferredViaNodalofficer,adherence_remarks_id as AdherenceRemarksId,"
			+ " referral_type_id as ReferralTypeId,SACEP_referral_reason_id as SACEPReferralReasonId,OI_remarks as OIRemarks,"
			+ " is_beneficiary_know_sacep_appointment_date as IsBeneficiaryKnowSacepAppointmentDate,is_beneficiary_attended_sacep_appointment as IsBeneficiaryAttendedSacepAppointment,"
			+ " beneficiary_sacep_not_attended_reason as BeneficiarySacepNotAttendedReason,beneficiary_sacep_visit_date as BeneficiarySacepVisitDate,adherence_others_remarks as adherenceOthersRemarks,referral_type_others as referralTypeOthers,SACEP_referral_reason_others as sacepReferralReasonOthers,sacep_first_appointment_date as sacepFirstAppointmentDate,sacep_second_appointment_date as sacepSecondAppointmentDate from soch.sacep_referral_information where beneficiary_referral_id=:referralId and is_active =true and is_delete =false")
	SacepReferralInformationProjection findSacepReferralInformationById(@Param("referralId") Long referralId);

	/**
	 * @param referralId
	 * @return
	 */
	@Query(nativeQuery = true, value = "select br.refer_date as referDate,br.refered_to as referedTo,br.refered_from as referdFrom,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,b.id as beneficiaryId, "
			+ "b.date_of_birth as dob,b.uid as uid,mg.name as gender,b.caregiver_name as careGiver,b.art_number as artNumber,b.pre_art_number as preArtNumber,ab.art_registration_date as artRegistrationDate,b.caregiver_phone_number as caregiverPhoneNumber,b.mobile_number as mobile,a.address_line_one as addressOne,a.address_line_two as addressTwo,ab.facility_id as facilityId, "
			+ "mabs.name as artStatus,msrr.name as reasonName,srr.sacep_review_feedback as feedback,mtl.name as regimenRecommended,r.regimen_name as regimen,srr.is_beneficiary_started_new_regimen as startedRegimen, " 
			+ "srr.reason_for_no_new_regimen as reasonForNewRegimen from soch.beneficiary_referral br left join soch.sacep_referral_information sri on sri.beneficiary_referral_id = br.id left join soch.master_sacep_referral_reason msrr on "
			+ "msrr.id = sri.sacep_referral_reason_id inner join soch.beneficiary b on b.id = br.beneficiary_id inner join soch.master_gender mg on mg.id = b.gender_id left join soch.address a on a.id = b.address_id inner join soch.art_beneficiary ab on "
			+ "ab.beneficiary_id = b.id left join soch.master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id left join soch.sacep_referral_review srr on srr.beneficiary_referral_id = br.id "
			+ "left join soch.master_treatment_line mtl on mtl.id = srr.recommended_regimen_line_id left join soch.regimen r on r.id = srr.recommended_regimen_id where br.id = :referralId ")
	SacepReferralRrfPdfProjection getRrfPdfDetails(@Param("referralId") Integer referralId);

	
	
	@Query(nativeQuery = true, value = "select s.id as sacepReferralInformationId,s.beneficiary_referral_id as beneficiaryReferralId,\r\n"
			+ "s.is_beneficiary_accepted_for_sacep as isAcceptedForSacep,\r\n"
			+ "s.sacep_first_appointment_date as firstAppdate,\r\n"
			+ "s.sacep_second_appointment_date as secondAppdate,\r\n"
			+ "s.beneficiary_sacep_not_accepted_reason as notAcceptedReason,\r\n"
			+ "s.is_beneficiary_know_sacep_appointment_date as isBeneficiaryInformed,\r\n"
			+ "s.is_beneficiary_attended_sacep_appointment as isBeneficiaryAttendedSacep,\r\n"
			+ "s.beneficiary_sacep_visit_date as dateOfVisit,\r\n"
			+ "s.beneficiary_sacep_not_attended_reason as notAttendedReason,\r\n"
			+ "s.other_remarks as remarks,s.type_of_sacep_review_id as sacepReviewTypeId,srt.name as sacepReviewType\r\n"
			+ "from soch.sacep_referral_information s left join soch.master_type_of_sacep_review srt on(srt.id=s.type_of_sacep_review_id) where s.beneficiary_referral_id=:beneficiaryReferralId")
	SacepPlanAppointmentDetailsProjection findSacepPlanDetailsByBeneficiaryReferralId(@Param("beneficiaryReferralId") Long beneficiaryReferralId);

	@Query(nativeQuery = true ,value = "select * from soch.sacep_referral_information sr where sr.beneficiary_referral_id = :beneficiaryReferralId")
	Optional<SacepReferralInformation> findArtPlusSacepReferral(@Param("beneficiaryReferralId") Long beneficiaryReferralId);

}
