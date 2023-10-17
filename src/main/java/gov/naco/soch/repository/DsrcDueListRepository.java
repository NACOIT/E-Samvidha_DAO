package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.projection.DsrcDueListProjection;
import java.time.LocalDate;

@Repository
public interface DsrcDueListRepository extends JpaRepository<BeneficiaryReferral, Long>, CustomRepository {
	
	@Query(nativeQuery = true, value = "select dpc.id as partnerId,dpc.partner_code as partnerCode,b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,dpc.partner_followup_date as followUpDate, bg.name as gender,mbc.name as category,db.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and db.facility_id = :facilityId and db.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id join soch.dsrc_partner_case_details dpc on dpc.beneficiary_id = b.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id where b.is_delete = false and dpc.partner_followup_date BETWEEN :lclFollowUpdate AND :lclfollowUpEnddate and dpc.is_partner_registered = false")
    Page<DsrcDueListProjection> findDsrcDueListPartnerFollowUp(@Param("facilityId") Long facilityId ,Pageable pageable,@Param("lclFollowUpdate") LocalDate lclFollowUpdate,@Param("lclfollowUpEnddate") LocalDate lclfollowUpEnddate);
	
    @Query(nativeQuery = true, value = "select dpc.id as partnerId,dpc.partner_code as partnerCode,b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,dpc.partner_followup_date as followUpDate, bg.name as gender,mbc.name as category,db.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and db.facility_id = :facilityId and db.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id join soch.dsrc_partner_case_details dpc on dpc.beneficiary_id = b.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id where b.is_delete = false and dpc.partner_followup_date < :lclfollowUpMisseddate and dpc.is_partner_registered = false")
    Page<DsrcDueListProjection> findDsrcDueListMissedFollowUp(@Param("facilityId") Long facilityId ,Pageable pageable,@Param("lclfollowUpMisseddate") LocalDate lclfollowUpMisseddate);
	
    @Query(nativeQuery = true, value = "select dpc.id as partnerId,dpc.partner_code as partnerCode,b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,dpc.partner_followup_date as followUpDate, bg.name as gender,mbc.name as category,db.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and db.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id join soch.dsrc_partner_case_details dpc on dpc.beneficiary_id = b.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id where b.is_delete = false and dpc.partner_followup_date < :lclfollowUpMisseddate and dpc.is_partner_registered = false and b.mobile_number=:searchParam")
    Page<DsrcDueListProjection> searchBasicMissedPartnerFollowUpByMobile(Pageable pageable,@Param("searchParam") String searchParam,@Param("lclfollowUpMisseddate") LocalDate lclfollowUpMisseddate);
	
    @Query(nativeQuery = true, value = "select dpc.id as partnerId,dpc.partner_code as partnerCode,b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,dpc.partner_followup_date as followUpDate, bg.name as gender,mbc.name as category,db.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and db.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id join soch.dsrc_partner_case_details dpc on dpc.beneficiary_id = b.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id where b.is_delete = false and dpc.partner_followup_date < :lclfollowUpMisseddate and dpc.is_partner_registered = false and b.uid=:searchParam")
    Page<DsrcDueListProjection> searchBasicMissedPartnerFollowUpByUid(Pageable pageable,@Param("searchParam") String searchParam,@Param("lclfollowUpMisseddate") LocalDate lclfollowUpMisseddate);
    
    @Query(nativeQuery = true, value = "select dpc.id as partnerId,dpc.partner_code as partnerCode,b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,dpc.partner_followup_date as followUpDate, bg.name as gender,mbc.name as category,db.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and db.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id join soch.dsrc_partner_case_details dpc on dpc.beneficiary_id = b.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id where b.is_delete = false and dpc.partner_followup_date < :lclfollowUpMisseddate and dpc.is_partner_registered = false and b.benf_search_str ilike :searchParam")
    Page<DsrcDueListProjection> searchBasicMissedPartnerFollowUp(Pageable pageable,@Param("searchParam") String searchParam,@Param("lclfollowUpMisseddate") LocalDate lclfollowUpMisseddate);
	
  
    @Query(nativeQuery = true, value = "select dpc.id as partnerId,dpc.partner_code as partnerCode,b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,dpc.partner_followup_date as followUpDate, bg.name as gender,mbc.name as category,db.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and db.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id join soch.dsrc_partner_case_details dpc on dpc.beneficiary_id = b.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id where b.is_delete = false and b.mobile_number=:searchParam and dpc.is_partner_registered = false")
    Page<DsrcDueListProjection> searchBasicPartnerFollowUpByMobile(Pageable pageable,@Param("searchParam") String searchParam);
	
    @Query(nativeQuery = true, value = "select dpc.id as partnerId,dpc.partner_code as partnerCode,b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,dpc.partner_followup_date as followUpDate, bg.name as gender,mbc.name as category,db.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and db.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id join soch.dsrc_partner_case_details dpc on dpc.beneficiary_id = b.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id where b.is_delete = false and b.uid=:searchParam and dpc.is_partner_registered = false")
    Page<DsrcDueListProjection> searchBasicPartnerFollowUpByUid(Pageable pageable,@Param("searchParam") String searchParam);
    
    @Query(nativeQuery = true, value = "select dpc.id as partnerId,dpc.partner_code as partnerCode,b.id as beneficiaryId, b.uid as uid, b.first_name as firstName,b.middle_name as middleName, b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode,dpc.partner_followup_date as followUpDate, bg.name as gender,mbc.name as category,db.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary db on db.beneficiary_id = b.id and db.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on db.benficiary_status_id = bs.id join soch.dsrc_partner_case_details dpc on dpc.beneficiary_id = b.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id where b.is_delete = false "
    		+ " and b.benf_search_str ilike :searchParam and dpc.is_partner_registered = false "
    		+ " ")
    Page<DsrcDueListProjection> searchBasicPartnerFollowUp(Pageable pageable,@Param("searchParam") String searchParam);
	
    
    @Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid,b.first_name as firstName, b.middle_name as middleName,b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode, bg.name as gender,v.lmp as lmpDate, v.edd as eddDate,mbc.name as category,ab.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on ab.benficiary_status_id = bs.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id join ( select  bv.beneficiary_id,bv.is_pregnant,bv.facility_id,bv.lmp,bv.edd,bv.delivery_outcome_id from soch.beneficiary_visit_register bv join ( select beneficiary_id,max(id) as visit_id  from soch.beneficiary_visit_register where facility_id=:facilityId group by beneficiary_id ) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id=bv.id and bv.facility_id =:facilityId and bv.is_pregnant=true)) v on b.id = v.beneficiary_id and v.edd <= :edd and v.delivery_outcome_id IS NULL")
    Page<DsrcDueListProjection> findDsrcDeliveryDueList(@Param("facilityId") Long facilityId ,Pageable pageable,@Param("edd") LocalDate edd);
	
    @Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid,b.first_name as firstName, b.middle_name as middleName,b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode, bg.name as gender,v.lmp as lmpDate, v.edd as eddDate,mbc.name as category,ab.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on ab.benficiary_status_id = bs.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id join ( select  bv.beneficiary_id,bv.is_pregnant,bv.facility_id,bv.lmp,bv.edd,bv.delivery_outcome_id from soch.beneficiary_visit_register bv join ( select beneficiary_id,max(id) as visit_id  from soch.beneficiary_visit_register where facility_id=:facilityId group by beneficiary_id ) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id=bv.id and bv.facility_id =:facilityId and bv.is_pregnant=true)) v on b.id = v.beneficiary_id and v.edd <= :edd and b.mobile_number =:searchParam and v.delivery_outcome_id IS NULL")
    Page<DsrcDueListProjection> searchDsrcDeliveryDueListByMobile(@Param("facilityId") Long facilityId ,Pageable pageable,@Param("searchParam") String searchParam,@Param("edd") LocalDate edd);
	
    @Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid,b.first_name as firstName, b.middle_name as middleName,b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode, bg.name as gender,v.lmp as lmpDate, v.edd as eddDate,mbc.name as category,ab.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on ab.benficiary_status_id = bs.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id join ( select  bv.beneficiary_id,bv.is_pregnant,bv.facility_id,bv.lmp,bv.edd,bv.delivery_outcome_id from soch.beneficiary_visit_register bv join ( select beneficiary_id,max(id) as visit_id  from soch.beneficiary_visit_register where facility_id=:facilityId group by beneficiary_id ) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id=bv.id and bv.facility_id =:facilityId and bv.is_pregnant=true)) v on b.id = v.beneficiary_id and v.edd <= :edd and b.uid =:searchParam and v.delivery_outcome_id IS NULL")
    Page<DsrcDueListProjection> searchDsrcDeliveryDueListByUid(@Param("facilityId") Long facilityId ,Pageable pageable,@Param("searchParam") String searchParam,@Param("edd") LocalDate edd);
	
    @Query(nativeQuery = true, value = "select b.id as beneficiaryId, b.uid as uid,b.first_name as firstName, b.middle_name as middleName,b.last_name as lastName,b.mobile_number as mobileNumber, b.date_of_birth as dateOfBirth,b.dsrc_beneficiary_code as dsrcCode, bg.name as gender,v.lmp as lmpDate, v.edd as eddDate,mbc.name as category,ab.dsrc_reg_date as dateOfRegistration from soch.beneficiary b join soch.dsrc_beneficiary ab on ab.beneficiary_id = b.id and ab.facility_id =:facilityId and ab.is_delete = false join soch.master_gender bg on b.gender_id = bg.id join soch.master_dsrc_beneficiary_status bs on ab.benficiary_status_id = bs.id join soch.master_beneficiary_category mbc on mbc.id=b.category_id join ( select  bv.beneficiary_id,bv.is_pregnant,bv.facility_id,bv.lmp,bv.edd,bv.delivery_outcome_id from soch.beneficiary_visit_register bv join ( select beneficiary_id,max(id) as visit_id  from soch.beneficiary_visit_register where facility_id=:facilityId group by beneficiary_id ) vr on (vr.beneficiary_id = bv.beneficiary_id and vr.visit_id=bv.id and bv.facility_id =:facilityId and bv.is_pregnant=true)) v on b.id = v.beneficiary_id and v.edd <= :edd "
    		+ " and b.benf_search_str ilike :searchParam and v.delivery_outcome_id IS NULL")
    Page<DsrcDueListProjection> basicSearchDsrcDeliveryDueList(@Param("facilityId") Long facilityId ,Pageable pageable,@Param("searchParam") String searchParam,@Param("edd") LocalDate edd);


}