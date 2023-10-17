package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.DsrcBeneficiary;
import gov.naco.soch.projection.DsrcBeneficiaryDiagnosisDetailsProjection;
import gov.naco.soch.projection.DsrcBeneficiaryFamilyDetailsProjection;
import gov.naco.soch.projection.DsrcBeneficiaryListProjection;
import gov.naco.soch.projection.DsrcBeneficiaryProjection;
import gov.naco.soch.projection.DsrcBeneficiaryReferralProjection;
import gov.naco.soch.projection.DsrcBeneficiaryViewCardProjection;

@Repository
public interface DsrcBeneficiaryRepository extends JpaRepository<DsrcBeneficiary, Long> , CustomRepository {


    @Query(nativeQuery = true, value ="select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason,mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join ( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false ) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id")
	Page<DsrcBeneficiaryListProjection> findAllDsrcBeneficiaries(@Param("facilityId") Long facilityId, Pageable pageable);

    @Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason, mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and b.category_id >= :categoryId and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id ")
	Page<DsrcBeneficiaryListProjection> findDsrcBeneficiariesForAdults(@Param("facilityId") Long facilityId, Pageable pageable,@Param("categoryId") Long categoryId );

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason,mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and b.category_id >= :categoryId and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id where b.mobile_number = :searchParam")
	Page<DsrcBeneficiaryListProjection> searchDsrcAdultBeneficiariesByMobile(@Param("facilityId") Long facilityId, Pageable pageable,@Param("categoryId") Long categoryId,@Param("searchParam") String searchParam);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason,mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and b.category_id >= :categoryId and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join ( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false ) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id where b.uid = :searchParam")
	Page<DsrcBeneficiaryListProjection> searchDsrcAdultBeneficiariesByUid(@Param("facilityId") Long facilityId, Pageable pageable,@Param("categoryId") Long categoryId,@Param("searchParam") String searchParam);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason,mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and b.category_id >= :categoryId and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join ( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false ) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id "
			+ " where ( b.benf_search_str ilike %:searchParam% or concat(b.first_name, ' ', b.last_name) ilike %:searchParam% )  "
			+ "")
	Page<DsrcBeneficiaryListProjection> searchBasicDsrcBeneficiariesForAdults(@Param("facilityId") Long facilityId, Pageable pageable,@Param("categoryId") Long categoryId,@Param("searchParam") String searchParam);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason,mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and b.category_id = :categoryId and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join ( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false ) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id ")
	Page<DsrcBeneficiaryListProjection> findDsrcBeneficiariesForInfants(@Param("facilityId") Long facilityId,@Param("categoryId") Long categoryId ,Pageable pageable);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason,mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and b.category_id = :categoryId and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join ( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false ) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id where b.mobile_number =:searchParam")
	Page<DsrcBeneficiaryListProjection> searchDsrcInfantBeneficiariesByMobile(@Param("facilityId") Long facilityId, Pageable pageable,@Param("categoryId") Long categoryId,@Param("searchParam") String searchParam);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason,mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and b.category_id = :categoryId and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join ( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false ) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id where b.uid =:searchParam")
	Page<DsrcBeneficiaryListProjection> searchDsrcInfantBeneficiariesByUid(@Param("facilityId") Long facilityId, Pageable pageable,@Param("categoryId") Long categoryId,@Param("searchParam") String searchParam);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName, b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth, b.dsrc_beneficiary_code as dsrcCode, b.hiv_status_id as hivStatusId, bg.name as gender, bs.name as status, v.is_pregnant as ispregnant, dbs.dsrc_reg_date as dateOfRegistration, dbs.infant_code as infantCode, c.ClinicalTreatmentType as clinicalTreatmentType, mdbdr.name as deleteReason,mdbdr.id as deletereasonId from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and b.is_delete = false and b.category_id = :categoryId and(dbs.deleted_reason_id is null or dbs.deleted_reason_id <> 5) join soch.master_gender bg on b.gender_id = bg.id left join soch.master_dsrc_beneficiary_delete_reason mdbdr on dbs.deleted_reason_id = mdbdr.id join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id join ( select bv.beneficiary_id, bv.is_pregnant, bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id, max(id) as visit_id from soch.beneficiary_visit_register where facility_id =:facilityId group by beneficiary_id) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id = bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id left join( select bc.beneficiary_id , case when count(bc.clinical_treatment_type_id) = 2 then 0 else max(bc.clinical_treatment_type_id) end as ClinicalTreatmentType from ( select distinct clinical_treatment_type_id, bct.beneficiary_id from soch.beneficiary_clinical_treatment bct where bct.facility_id = :facilityId and bct.is_delete = false ) bc group by bc.beneficiary_id ) c on b.id = c.beneficiary_id where ( b.benf_search_str ilike %:searchParam% or concat(b.first_name, ' ', b.last_name) ilike %:searchParam% ) "
			+ "")
	Page<DsrcBeneficiaryListProjection> searchBasicDsrcBeneficiariesForInfants(@Param("facilityId") Long facilityId,@Param("categoryId") Long categoryId,Pageable pageable,@Param("searchParam") String searchParam);

	@Query(value = "select * from soch.dsrc_beneficiary db where db.beneficiary_id=:beneficiaryId and db.is_delete=:isDelete ", nativeQuery = true)
	DsrcBeneficiary findByBeneficiaryIdAndAndIsDelete(@Param("beneficiaryId") Long beneficiaryId,
													 @Param("isDelete") boolean isDelete);

	@Query(value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, \n" +
			"b.last_name as lastName,b.mobile_number as contactNumber,b.date_of_birth as dateOfBirth,b.category_id as categoryId,\n" +
			"b.dsrc_beneficiary_code as dsrcBeneficiaryCode,b.age as age, b.occupation_id as occupationId, \n" +
			"b.education_level_id as educationLevelId, b.marital_status_id as maritalStatusId,\n" +
			"db.infant_code as infantCode, db.infant_mother_facility_id as infantMotherFacilityId,\n" +
			"db.infant_mother_beneficiary_id as infantMotherBeneficiaryId, db.is_counselling_done as counsellingDone,\n" +
			"db.is_beneficiary_hrg beneficiaryHrg,db.is_tb_symptoms as tbSymptoms,\n" +
			"bg.id as genderId,bs.id as dsrcBeneficiaryStatusId,db.dsrc_reg_date as regDate, bv.is_pregnant as pregnant,\n" +
			"bv.pregnant_case_type_id as pregnantCaseTypeId, bv.lmp as lmp, bv.edd as edd, bv.pregnancy_month as pregnancyMonth, \n" +
			"ad.address_line_one as addressLineOne, ad.address_line_two as addressLineTwo, ad.state_id as stateId,ad.district_id as districtId,\n" +
			"ad.subdistrict_id as subDistrictId, ad.town_id as townId, ad.country as country,ad.pincode as pinCode \n" +
			"from soch.beneficiary b \n" +
			"join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and b.is_delete=false and db.is_delete = false and db.is_active=true\n" +
			"join soch.master_gender bg on b.gender_id = bg.id\n" +
			"join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id\n" +
			"join soch.address ad on ad.id=b.address_id\n" +
			"join soch.beneficiary_visit_register bv on b.id = bv.beneficiary_id\n" +
			"where db.beneficiary_id=:beneficiaryId order by bv.id desc limit 1", nativeQuery = true)
	DsrcBeneficiaryProjection findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select count(*) from soch.beneficiary b join soch.dsrc_beneficiary db on b.id=db.beneficiary_id where b.dsrc_beneficiary_code=:dsrcBeneficiaryCode and b.is_delete=false and b.is_active=true and (db.deleted_reason_id is null or db.deleted_reason_id <> 5)")
	Long findDsrcBeneficiaryCodeByIsDeleteAndIsActive(@Param("dsrcBeneficiaryCode") String dsrcBeneficiaryCode);

	@Query(nativeQuery = true, value = "select count(*) from soch.dsrc_beneficiary db where db.infant_code=:dsrcInfantCode and (db.deleted_reason_id is null or db.deleted_reason_id <> 5)")
	Long findDsrcInfantCodeByIsDeleteAndIsActive(@Param("dsrcInfantCode") String dsrcInfantCode);

	@Query(nativeQuery = true, value = "select count(*) from soch.beneficiary b join soch.dsrc_beneficiary db on b.id=db.beneficiary_id where b.id!=:beneficiaryId and b.dsrc_beneficiary_code=:dsrcBeneficiaryCode and b.is_delete=false and b.is_active=true and (db.deleted_reason_id is null or db.deleted_reason_id <> 5)")
	Long findDsrcBeneficiaryCodeExistsForOtherBeneficiaries(@Param("beneficiaryId") Long beneficiaryId,@Param("dsrcBeneficiaryCode") String dsrcBeneficiaryCode);

	@Query(nativeQuery = true, value = "select count(*) from soch.dsrc_beneficiary db where db.beneficiary_id!=:beneficiaryId and db.infant_code=:dsrcInfantCode and (db.deleted_reason_id is null or db.deleted_reason_id <> 5)")
	Long findDsrcInfantCodeExistsForOtherBeneficiaries(@Param("beneficiaryId") Long beneficiaryId,@Param("dsrcInfantCode") String dsrcInfantCode);

	@Query(nativeQuery = true, value = "select b.id as beneficiaryId,ab.facility_id as facilityId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,\r\n"
			+ " b.category_id as categoryId,(SELECT mbc.name from soch.master_beneficiary_category mbc WHERE mbc.id = b.category_id fetch first row only ) as categoryName,  \r\n"
			+ " b.dsrc_beneficiary_code as dsrcCode,bg.name as gender,b.age as age,date_of_birth as dateOfBirth, \r\n"
			+ " ad.address_line_one as addressLineOne, ad.address_line_two as addressLineTwo, \r\n"
			+ " (SELECT dt.name from soch.district dt WHERE dt.id = ad.district_id fetch first row only ) as district,\r\n"
			+ " (SELECT st.name from soch.state st WHERE st.id = ad.state_id fetch first row only )as state,\r\n"
			+ " ad.pincode as pinCode,b.mobile_number as contactNumber,bs.name as currentStatus,\r\n"
			+ " bv.is_pregnant as pregnant,bv.pregnant_case_type_id as pregnantCaseTypeId, \r\n"
			+ " bv.lmp as lmp, bv.edd as edd, bv.pregnancy_month as pregnancyMonth,ab.infant_code as infantCode, \r\n"
			+ " ab.infant_mother_facility_id as infantMotherFacilityId,(SELECT f.name from soch.facility f WHERE f.id = ab.infant_mother_facility_id fetch first row only ) as infantMotherFacilityName, \r\n"
			+ " ab.infant_mother_beneficiary_id as infantMotherBeneficiaryId, (SELECT concat(bc.first_name, ' ', bc.last_name) from soch.beneficiary bc WHERE bc.id = ab.infant_mother_beneficiary_id fetch first row only ) as infantMotherBeneficiaryName, \r\n"
			+ " (SELECT mo.name from soch.master_occupation mo WHERE mo.id = b.occupation_id fetch first row only )  as occupation, \r\n"
			+ " (SELECT dt.name from soch.master_education_level dt WHERE dt.id = b.education_level_id fetch first row only )  as educationLevel, \r\n"
			+ " (SELECT dt.name from soch.master_marital_status dt WHERE dt.id = b.marital_status_id fetch first row only )  as maritalStatus \r\n"
			+ " from soch.beneficiary b  \r\n"
			+ " left join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id and (ab.deleted_reason_id is null or ab.deleted_reason_id <> 5) \r\n "
			+ " left join soch.beneficiary_visit_register bv on ab.beneficiary_id = bv.beneficiary_id \r\n"
			+ " left join soch.address ad on ad.id=b.address_id  \r\n"
			+ " left join soch.master_gender bg on b.gender_id = bg.id  \r\n"
			+ " left join soch.master_dsrc_beneficiary_status bs on ab.benficiary_status_id = bs.id  \r\n"
			+ " where b.is_delete = false and b.id = :beneficiaryId  order by bv.id desc limit 1 ; ")
	DsrcBeneficiaryViewCardProjection findViewCardId(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = " SELECT bfd.beneficiary_id as beneficiaryId,bfd.member_beneficiary_id as relationBeneficiaryId, b.first_name as relationFirstName, b.middle_name as relationMiddleName,b.last_name as relationLastName \r\n"
			+ " , (SELECT mr.name from soch.master_relationship mr WHERE mr.id=bfd.relationship_id fetch first row only ) as relation \r\n"
			+ " , dpc.partner_followup_date as partnerTestFollowupDate \r\n"
			+ " from soch.dsrc_beneficiary ab \r\n"
			+ " join soch.beneficiary_family_details bfd on bfd.is_delete = false and bfd.beneficiary_id = ab.beneficiary_id \r\n"
			+ " join soch.beneficiary b on b.id = bfd.member_beneficiary_id and b.is_delete = false \r\n"
			+ " left join soch.dsrc_partner_case_details  dpc on dpc.beneficiary_id = bfd.member_beneficiary_id and dpc.facility_id = ab.facility_id \r\n "
			+ " where  ab.beneficiary_id = :beneficiaryId and (ab.deleted_reason_id is null or ab.deleted_reason_id <> 5) order by dpc.modified_time desc \r\n")
	Page<DsrcBeneficiaryFamilyDetailsProjection> findRelationBasedOnBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select b.uid as uid, f.name as referredToFacility,f.code as referredToFacilityCode, concat(b.first_name, ' ', b.last_name) as name, bg.name as sex, \r\n"
			+ "b.date_of_birth as dateOfBirth, b.mobile_number as mobileNumber, br.refer_date as dateOfReferral, mhs.name as hivStatus, mrs.name as referralStatus \r\n"
			+ "from soch.beneficiary b \r\n" 
			+ "join soch.beneficiary_referral br on br.beneficiary_id = b.id \r\n"
			+ "join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id \r\n"
			+ "left join soch.facility f on f.id = br.refered_to \r\n"
			+ "left join soch.master_gender bg on bg.id = b.gender_id \r\n"
			+ "left join soch.master_hiv_status mhs on mhs.id = b.hiv_status_id \r\n"
			+ "left join soch.master_referral_status mrs on mrs.id = br.referral_status_id \r\n"
			+ "where ab.beneficiary_id =:beneficiaryId and (ab.deleted_reason_id is null or ab.deleted_reason_id <> 5)")
	Page<DsrcBeneficiaryReferralProjection> findDsrcReferralsBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId,Pageable pageable);
	
	@Query(nativeQuery = true, value = "SELECT mct.name as treatmentType,bct.treatment_date as diagnosisDate,  \r\n "
			+ " string_agg(srdt.name,',') as stirtiDiagnosisResult, \r\n "
			+ " string_agg((SELECT p.product_name from soch.product p WHERE p.id=bsrt.sti_rti_prod_id fetch first row only ),',')  as stirtiTreatmentKit , \r\n "
			+ " bsrt.followup_date as stirtiFollowupDate \r\n "
			+ " from soch.dsrc_beneficiary ab \r\n "
			+ " join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = ab.beneficiary_id \r\n "
			+ " join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id \r\n "
			+ " join soch.beneficiary_sti_rti_treatment_details bsrt on bct.id = bsrt.clinical_treatment_id \r\n "
			+ " left join soch.master_diagnosis_type srdt on srdt.id = bsrt.sti_rti_diagnosis_type_id \r\n "
			+ " where bct.clinical_treatment_type_id = 1 and ab.beneficiary_id  = :beneficiaryId and (ab.deleted_reason_id is null or ab.deleted_reason_id <> 5) \r\n "
			+ " group by mct.name ,bct.treatment_date,bsrt.followup_date \r\n"
			+ " order by bsrt.followup_date desc limit 1;")
	Page<DsrcBeneficiaryDiagnosisDetailsProjection> findDsrcDiagnosisStiRtiDetailsBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId,Pageable pageable);
	
	@Query(nativeQuery = true, value = "SELECT mct.name as treatmentType,bct.treatment_date as diagnosisDate, \r\n "
			+ " case when syphilis_test_result_id =1 then 'Reactive' else 'Non-Reactive' end  as SyphilisDiagnosisResult, \r\n "
			+ " string_agg((SELECT p.product_name from soch.product p WHERE p.id=bstd.syphilis_prod_id fetch first row only ),',') as syphilisTreatmentKit, \r\n "
			+ " bstd.syphilis_followup_date as syphilisFollowupDate \r\n "
			+ " from soch.dsrc_beneficiary ab \r\n "
			+ " join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = ab.beneficiary_id \r\n "
			+ " join soch.master_clinical_treatment_type mct on mct.id = bct.clinical_treatment_type_id \r\n "
			+ " left join soch.beneficiary_syphilis_treatment_details bstd on bct.id = bstd.clinical_treatment_id \r\n "
			+ " where bct.clinical_treatment_type_id = 5 and  ab.beneficiary_id  = :beneficiaryId and (ab.deleted_reason_id is null or ab.deleted_reason_id <> 5) \r\n "
			+ " group by ab.beneficiary_id,mct.name ,bct.treatment_date,bstd.syphilis_followup_date,case when syphilis_test_result_id =1 then 'Reactive' else 'Non-Reactive' end   \r\n "
			+ " order by bstd.syphilis_followup_date desc limit 1;")
	Page<DsrcBeneficiaryDiagnosisDetailsProjection> findDsrcDiagnosisSyphilisDetailsBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId,Pageable pageable);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,b.hiv_status_id as hivStatusId,  bg.name as gender,bs.name as status, v.is_pregnant as ispregnant,dbs.dsrc_reg_date as dateOfRegistration,dbs.infant_code as infantCode \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and dbs.is_delete = false and b.is_delete =false\r\n" + 
			"join soch.master_gender bg on b.gender_id = bg.id \r\n" + 
			"join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id \r\n" + 
			"join  ( select  bv.beneficiary_id,bv.is_pregnant,bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id,max(id) as visit_id  from soch.beneficiary_visit_register where facility_id=:facilityId group by beneficiary_id ) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id=bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id  where b.mobile_number =:searchParam")
	Page<DsrcBeneficiaryListProjection> searchDsrcBeneficiariesByMobile(@Param("facilityId") Long facilityId, Pageable pageable,
			@Param("searchParam") String searchParam);
	
	@Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,b.hiv_status_id as hivStatusId,  bg.name as gender,bs.name as status, v.is_pregnant as ispregnant,dbs.dsrc_reg_date as dateOfRegistration,dbs.infant_code as infantCode \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and dbs.is_delete = false and b.is_delete =false\r\n" + 
			"join soch.master_gender bg on b.gender_id = bg.id \r\n" + 
			"join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id \r\n" + 
			"join  ( select  bv.beneficiary_id,bv.is_pregnant,bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id,max(id) as visit_id  from soch.beneficiary_visit_register where facility_id=:facilityId group by beneficiary_id ) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id=bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id  where b.uid =:searchParam")
	Page<DsrcBeneficiaryListProjection> searchDsrcBeneficiariesByUid(@Param("facilityId") Long facilityId, Pageable pageable,
			@Param("searchParam") String searchParam);

	@Query(nativeQuery = true, value = "Select b.id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,b.hiv_status_id as hivStatusId,  bg.name as gender,bs.name as status, v.is_pregnant as ispregnant,dbs.dsrc_reg_date as dateOfRegistration,dbs.infant_code as infantCode \r\n" + 
			"from soch.beneficiary b \r\n" + 
			"join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id = :facilityId and dbs.is_delete = false and b.is_delete =false\r\n" + 
			"join soch.master_gender bg on b.gender_id = bg.id \r\n" + 
			"join soch.master_dsrc_beneficiary_status bs on dbs.benficiary_status_id = bs.id \r\n" + 
			"join  ( select  bv.beneficiary_id,bv.is_pregnant,bv.facility_id from soch.beneficiary_visit_register bv join ( select beneficiary_id,max(id) as visit_id  from soch.beneficiary_visit_register where facility_id=:facilityId group by beneficiary_id ) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id=bv.id and bv.is_delete = false)) v on b.id = v.beneficiary_id  "
			+ " where ( b.benf_search_str ilike %:searchParam% or concat(b.first_name, ' ', b.last_name) ilike %:searchParam% )"
			+ " ")
	Page<DsrcBeneficiaryListProjection> searchBasicDsrcBeneficiariesForAll(@Param("facilityId") Long facilityId, Pageable pageable,
			@Param("searchParam") String searchParam);

	@Query(nativeQuery = true, value ="select mabs.name "
			+ "from soch.dsrc_beneficiary ab "
			+ "inner join soch.beneficiary b on b.id = ab.beneficiary_id "
			+ "inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "inner join soch.master_dsrc_beneficiary_status mabs on mabs.id = ab.benficiary_status_id "
			+ "where ab.beneficiary_id = :beneficiaryId and bfm.facility_id = :facilityId "
			+ "and ab.is_active = true and ab.is_delete = false")
	String getBenficiaryStatus(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value =" select case  "
			+ " when COALESCE(bsrtd.is_treatment_completed,bstd.is_treatment_completed ) = false then 'Ongoing Treatment' "
			+ " when COALESCE(bsrtd.is_treatment_completed,bstd.is_treatment_completed ) = true  then 'Completed Treatment' "
			+ " else 'Registered' END as treatmentCompleted "
			+ " from soch.beneficiary b "
			+ " join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.is_delete = false "
			+ " left join soch.beneficiary_clinical_treatment bct on bct.beneficiary_id = b.id and  bct.is_delete= false "
			+ " left join soch.beneficiary_sti_rti_treatment_details bsrtd on bsrtd.clinical_treatment_id = bct.id "
			+ " left join soch.beneficiary_syphilis_treatment_details bstd on bstd.clinical_treatment_id = bct.id "
			+ " where b.id = :beneficiaryId and b.is_delete =false  and b.is_active = true order by bct.id desc limit 1")
	String getBenficiaryLatestClinicalStatus(@Param("beneficiaryId") Long beneficiaryId) ;
	
	@Query(nativeQuery = true, value =" select case when count(bct.clinical_treatment_type_id) = 2 then 0 "
			+ " else max(clinical_treatment_type_id) END  "
			+ " from (select distinct clinical_treatment_type_id "
			+ " from soch.beneficiary_clinical_treatment bct"
			+ " where bct.beneficiary_id = :beneficiaryId and is_delete= false) bct")
	Long getBenficiaryClinicalTreatmentId(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value ="select b.id as beneficiaryId,b.first_name as firstName,b.middle_name as middleName,b.last_name as lastName,b.uid as uid from soch.beneficiary b join soch.dsrc_beneficiary dbs on dbs.beneficiary_id = b.id and dbs.facility_id =:facilityId and dbs.is_delete =false and b.is_delete =false and b.gender_id=2 and concat(b.first_name, ' ',b.middle_name,' ', b.last_name) ilike %:searchParam% ")
	List<Object[]> findMotherDsrcBeneficiaries(@Param("facilityId") Long facilityId, @Param("searchParam") String searchParam);

	
	
}