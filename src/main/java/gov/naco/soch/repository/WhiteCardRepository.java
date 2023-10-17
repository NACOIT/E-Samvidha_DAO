package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface WhiteCardRepository extends JpaRepository<Beneficiary, Long>, JpaSpecificationExecutor<Beneficiary> {

	@Query(nativeQuery=true, value="select concat(b.first_name,' ',b.middle_name,' ',b.last_name) as beneficiaryName ,g.name as gender,b.date_of_birth as dateOfBirth,b.age as age, " + 
			"mbc.name as category,b.mobile_number as mobileNumber,concat(ma.address_line_one,' ',ma.address_line_two ,' ',st.name ,' ',pc.pincode) as address, " + 
			"st.name as stateName,dt.name as district,sb.subdistrict_name as subDistrict,tn.town_name as city,b.caregiver_name as caregiverName, " + 
			"b.caregiver_phone_number as caregiverContactNumber,b.caregiver_address_id as caregiverAddressId , mht.name as hivType,ab.art_registration_date as registrationDate,mas.name as registrationTreatmentStatus, " + 
			"ib.pid as beneficiaryPID ,b.occupation_id as occupationId,itr.tested_date as testedDate,flb.link_date as linkDate,flb.is_linked as linkedOut ,b.death_date as deathDate ,b.death_reason as deathReason ," + 
			"f.name as facilityName ,f.code as facilityCode ,sa.name as facilityState ,tw.town_name as facilityCity,bfm.art_previous_clinic as previousClinic ,mat.name as transferredFrom , " + 
			"mel.name as beneficiaryEducation , ab.facility_id as facilityId , b.guardian_caregiver_highest_education_id as caregiverEducationId ,fl.name as lacName ,b.art_number as artNumber,b.uid as beneficiaryUID, " + 
			"mmi.name as monthlyIncome ,ab.art_beneficiary_status_id as beneficiaryStatus, mms.name as maritalStatus, mrf.name as riskFactor ,msw.name as caregiverRelation ,fy.name as testPlace, b.paediatric_other_vaccines as otherVaccines " + 
			"from soch.beneficiary b " + 
			"left join soch.master_gender as g on g.id = b.gender_id " + 
			"left join soch.master_beneficiary_category as mbc on mbc.id = b.category_id " + 
			"left join soch.address as ma on ma.id = b.address_id " + 
			"left join soch.state as st on st.id = ma.state_id " + 
			"left join soch.district as dt on dt.id = ma.district_id " + 
			"left join soch.subdistrict as sb on sb.subdistrict_id = ma.subdistrict_id " + 
			"left join soch.town as tn on tn.town_id = ma.town_id " + 
			"left join soch.pincode as pc on pc.id = ma.pincode_id " + 
			"left join soch.art_beneficiary as ab on ab.beneficiary_id = b.id " + 
			"left join soch.facility as f on f.id = ab.facility_id " + 
			"left join soch.master_hiv_type as mht on mht.id = b.hiv_type_id " + 
			"left join soch.beneficiary_facility_mapping as bfm on bfm.beneficiary_id  = b.id " + 
			"left join soch.address as ad on ad.id = f.address_id " + 
			"left join soch.state as sa on sa.id = ad.state_id " + 
			"left join soch.town as tw on tw.town_id = ad.town_id " + 
			"left join soch.facility_linked_facility_beneficiary as flb on flb.beneficiary_id = b.id " + 
			"left join soch.facility as fl on fl.id = flb.linked_facility_id " + 
			"left join soch.master_education_level as mel on mel.id = b.education_level_id " + 
			"left join soch.ictc_beneficiary as ib on ib.beneficiary_id = b.id  " + 
			"left join soch.ictc_test_result as itr on ib.id = itr.ictc_beneficiary_id " +
			"left join soch.facility as fy on fy.id = ib.facility_id " +
			"left join soch.ictc_details as icd on icd.beneficiary_id = b.id " + 
			"left join soch.master_beneficiary_art_transferred_from as mat on mat.id = ab.art_transferred_from " + 
			"left join soch.master_art_treatment_status as mas on mas.id = ab.registration_treatment_status " + 
			"left join soch.master_monthly_income as mmi on mmi.id = b.monthly_income " + 
			"left join soch.master_marital_status as mms on mms.id = b.marital_status_id " + 
			"left join soch.master_risk_factor as mrf on mrf.id = ab.hiv_risk_factor_id " + 
			"left join soch.master_staying_with as msw on msw.id = b.staying_with_id " + 
			"where b.id = :beneficiaryId order by ib.id desc limit 1")
	WhiteCardDetailsProjection findBeneficiaryDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select b.birth_weight as birthWeight ,b.neo_natal_complications as complications,  \r\n" + 
			"mbh.name as birthHistory ,mif.name as infantFeeding ,mdpr.name as  pcrResults " + 
			"from soch.beneficiary as b  " + 
			"left join soch.master_birth_history as mbh on mbh.id = b.birth_history_id  " + 
			"left join soch.art_beneficiary_followup as abf on abf.beneficiary_id = b.id " + 
			"left join soch.master_infant_feeding as mif on mif.id = abf.infant_feeding_id " + 
			"left join soch.art_beneficiary_dna_pcr_result as abd on abd.beneficiary_id = b.id " + 
			"left join soch.master_dna_pcr_result as mdpr on mdpr.id = abd.dna_pcr_result_id " + 
			"where b.id = :beneficiaryId order by abf.visit_register_id desc limit 1")
	WhiteCardDetailsProjection findPediatricDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
}
