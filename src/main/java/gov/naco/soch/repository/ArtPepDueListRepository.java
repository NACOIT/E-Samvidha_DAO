package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtPepDueList;
import gov.naco.soch.projection.ArtPepProjection;

@Repository
public interface ArtPepDueListRepository  extends JpaRepository<ArtPepDueList , Long> {

	
	@Query(nativeQuery=true , value="select ap.id as id, ap.exposed_staff_name as pepName, ap.gender as gender, " + 
			" ap.mobile_number as contactNumber, " + 
			" ap.date_of_birth as dob, ap.pep_number as pepNumber,ap.exposed_staff_designation as exposedStaffDesignation,    " + 
			" ap.mode_of_injury_or_exposure as modeOfInjuryOrExposure , ap.date_of_accidental_exposure as dateOfAccidentalExposure,   " + 
			" ap.consent_taken as consentTaken, ap.severity_of_exposure as severityOfExposureId, ap.hiv_exposure_code as hivExposureCodeId,  " + 
			" ap.hiv_source_status as hivSourceStatusId , ap.pep_prescription_id as pepPrescriptionId , ap.pep_start_date as pepStartDate, " + 
			" ap.pep_course_days as pepCourseDays, ap.baseline_test_conducted_hiv as baselineTestConductedHiv, " + 
			" ap.baseline_test_conducted_hbv as baselineTestConductedHbv,ap.baseline_test_conducted_hcv as baselineTestConductedHcv,  " + 
			" ap.baseline_test_conducted_hiv_result as baselineTestConductedHivResultId, " + 
			" ap.baseline_test_conducted_hcv_result as baselineTestConductedHcvResultId, " + 
			" ap.baseline_test_conducted_hbv_result as baselineTestConductedHbvResultId,  " + 
			" ap.exposed_person_sero_status_three_months as exposedPersonSeroStatusThreeMonthsId, " + 
			" ap.exposed_person_sero_status_six_months as exposedPersonSeroStatusSixMonthsId, ap.registration_date as registrationDate, " + 
			" ap.pep_course_completed as pepCourseCompleted , ap.exposed_staff_facility_id as exposedStaffFacilityId, fc.name as  exposedStaffFacilityName," + 
			" ad.id as addressId, st.id as stateId, dt.id as districtId, sd.subdistrict_id as subdistrictId ,  tn.town_id as townId, " + 
			" ad.address_line_one as addressLineOne , ad.address_line_two as addressLineTwo, pc.pincode as pincode, " + 
			" apdl.id as pepdueid " + 
			" from soch.art_pep_due_list as apdl " + 
			" left join soch.art_pep as ap on ap.id=apdl.pep_id " + 
			" left join soch.address as ad on ad.id=ap.address_id  " + 
			" left join soch.state as st on st.id=ad.state_id " + 
			" left join soch.district as dt on dt.id = ad.district_id " + 
			" left join soch.subdistrict as sd on sd.subdistrict_id = ad.subdistrict_id " + 
			" left join soch.town as tn on tn.town_id = ad.town_id " + 
			" left join soch.pincode as pc on pc.id = ad.pincode_id " + 
			" left join soch.facility as fc on fc.id = ap.exposed_staff_facility_id " + 
			" where apdl.is_active = true and apdl.is_delete = false and apdl.facility_id = :facilityId and apdl.expected_visit_date = Current_Date and apdl.is_visited = false and " + 
			" (lower(ap.pep_number) like %:searchText% or lower(ap.exposed_staff_name) like %:searchText% or lower(ap.mobile_number) like %:searchText% )")
	 List<ArtPepProjection> findbyFacilityIdAndSearchText(@Param("facilityId") Long facilityId, @Param("searchText") String searchText);

	
	@Query(nativeQuery = true , value= "select ap.id as id, ap.exposed_staff_name as pepName, ap.gender as gender, " + 
			"ap.mobile_number as contactNumber, " + 
			"ap.date_of_birth as dob, ap.pep_number as pepNumber,ap.exposed_staff_designation as exposedStaffDesignation,    " + 
			"ap.mode_of_injury_or_exposure as modeOfInjuryOrExposure , ap.date_of_accidental_exposure as dateOfAccidentalExposure,   " + 
			"ap.consent_taken as consentTaken, ap.severity_of_exposure as severityOfExposureId, ap.hiv_exposure_code as hivExposureCodeId,  " + 
			"ap.hiv_source_status as hivSourceStatusId , ap.pep_prescription_id as pepPrescriptionId , ap.pep_start_date as pepStartDate, " + 
			"ap.pep_course_days as pepCourseDays, ap.baseline_test_conducted_hiv as baselineTestConductedHiv, " + 
			"ap.baseline_test_conducted_hbv as baselineTestConductedHbv,ap.baseline_test_conducted_hcv as baselineTestConductedHcv,  " + 
			"ap.baseline_test_conducted_hiv_result as baselineTestConductedHivResultId, " + 
			"ap.baseline_test_conducted_hcv_result as baselineTestConductedHcvResultId, " + 
			"ap.baseline_test_conducted_hbv_result as baselineTestConductedHbvResultId,  " + 
			"ap.exposed_person_sero_status_three_months as exposedPersonSeroStatusThreeMonthsId, " + 
			"ap.exposed_person_sero_status_six_months as exposedPersonSeroStatusSixMonthsId, ap.registration_date as registrationDate, " + 
			"ap.pep_course_completed as pepCourseCompleted , ap.exposed_staff_facility_id as exposedStaffFacilityId, fc.name as  exposedStaffFacilityName," + 
			"ad.id as addressId, st.id as stateId, dt.id as districtId, sd.subdistrict_id as subdistrictId ,  tn.town_id as townId, " + 
			"ad.address_line_one as addressLineOne , ad.address_line_two as addressLineTwo, pc.pincode as pincode, " + 
			"apdl.id as pepdueid " + 
			"from soch.art_pep_due_list as apdl " + 
			"left join soch.art_pep as ap on ap.id=apdl.pep_id " + 
			"left join soch.address as ad on ad.id=ap.address_id  " + 
			"left join soch.state as st on st.id=ad.state_id " + 
			"left join soch.district as dt on dt.id = ad.district_id " + 
			"left join soch.subdistrict as sd on sd.subdistrict_id = ad.subdistrict_id " + 
			"left join soch.town as tn on tn.town_id = ad.town_id " + 
			"left join soch.pincode as pc on pc.id = ad.pincode_id " + 
			"left join soch.facility as fc on fc.id = ap.exposed_staff_facility_id " + 
			"where apdl.is_active = true and apdl.is_delete = false " + 
			"and apdl.facility_id =:facilityId and apdl.expected_visit_date =Current_Date and apdl.is_visited =false " + 
			"and ap.is_active = true and ap.is_delete= false")
	List<ArtPepProjection> findbyFacilityIdAndCurrentDate(@Param("facilityId") Long facilityId);
	

}
