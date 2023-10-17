package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TiOstFollowUp;
import gov.naco.soch.projection.OstFollowUpProjection;

/**
 * Spring Data repository for the TIBenFollowUp entity.
 */
@Repository
public interface TIOstFollowUpRepository
		extends JpaRepository<TiOstFollowUp, Long>, JpaSpecificationExecutor<TiOstFollowUp> {

	@Override
	@EntityGraph(value = "tiOstFollowUpGraph")
	Page<TiOstFollowUp> findAll(Specification<TiOstFollowUp> spec, Pageable pageable);

	TiOstFollowUp findByTiOstBeneficiary_IdAndNextFollowupDate(Long id, LocalDate date);

	@Query(nativeQuery = true, value = missedFollowUpQuery)
	Page<OstFollowUpProjection> findOstMissedFollowupListByBasicSearchWithTsVector(@Param("facilityId") Long facilityId,
			@Param("status") List<Long> status, @Param("followUpDate") LocalDate nextFollowUpDate,
			@Param("isDelete") Boolean isDelete, @Param("isEarly") Boolean isEarly,
			@Param("searchString") String searchString, Pageable pageable);

	@Query(nativeQuery = true, value = todaysFollowUpQuery)
	Page<OstFollowUpProjection> findOstTodaysFollowupListByBasicSearchWithTsVector(@Param("facilityId") Long facilityId,
			@Param("status") List<Long> status, @Param("followUpDate") LocalDate nextFollowUpDate,
			@Param("isDelete") Boolean isDelete, @Param("isEarly") Boolean isEarly,
			@Param("searchString") String searchString, Pageable pageable);
	
	@Query(nativeQuery = true, value = missedFollowUpQueryWithoutTsVector)
	Page<OstFollowUpProjection> findOstMissedFollowupListByBasicSearch(@Param("facilityId") Long facilityId,
			@Param("status") List<Long> status, @Param("followUpDate") LocalDate nextFollowUpDate,
			@Param("isDelete") Boolean isDelete, @Param("isEarly") Boolean isEarly, Pageable pageable);

	@Query(nativeQuery = true, value = todaysFollowUpQueryWithoutTsVector)
	Page<OstFollowUpProjection> findOstTodaysFollowupListByBasicSearch(@Param("facilityId") Long facilityId,
			@Param("status") List<Long> status, @Param("followUpDate") LocalDate nextFollowUpDate,
			@Param("isDelete") Boolean isDelete, @Param("isEarly") Boolean isEarly, Pageable pageable);

	String todaysFollowUpQuery = "select fb.id as followUpId,mfb.id as followUpById,mfb.name as followUpBy,ostfollow.id as id,ostfollow.follow_up_date as followUpDate,\r\n"
			+ "ostfollow.is_active as isActive,ostfollow.is_delete as isDelete,\r\n"
			+ "ostfollow.is_early as isEarly,ostfollow.next_followup_date as nextFollowUpDate,\r\n"
			+ "ostfollow.follow_up_type_id as followUpTypeId,ft.name as followUpType,\r\n"
			+ "ostfollow.frequency_of_other_drug_use as frequencyOfOtherDrugUse, \r\n"
			+ "ostfollow.frequency_of_primary_drug_use as frequencyOfPrimaryDrugUse, \r\n"
			+ "ostfollow.last_dose_of_primary_drug as lastDoseOfPrimaryDrug,\r\n"
			+ "ostfollow.last_dose_of_other_drug as lastDoseOfOtherDrug,\r\n"
			+ "ostfollow.other_drug_id as otherDrugId,mod.name as otherDrug,\r\n"
			+ "ostfollow.primary_drug_id as primaryDrugId,mpd.name as primaryDrug,\r\n"
			+ "ostfollow.no_side_effects as noSideEffects,\r\n"
			+ "ostfollow.ti_ost_beneficiary_id as tiOstBeneficiaryId,\r\n"
			+ "ostben.beneficiary_id as beneficiaryId,\r\n"
			+ "ostben.ost_code as ostCode,ostben.ost_number as ostNumber,\r\n"
			+ "ostben.ost_status_id as ostStatusId,ostben.status_id as statusId,\r\n"
			+ "mcs.name as ostStatus,mos.name as status,\r\n"
			+ "ben.first_name as firstName,ben.last_name as lastname,\r\n"
			+ "ben.middle_name as middleName,ben.age as age,ben.date_of_birth as dateOfBirth,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.uid as uid,ben.gender_id as genderId,g.name as gender\r\n"
			+ "from soch.ti_ost_follow_up ostfollow\r\n"
			+ "left join soch.master_follow_up_type ft on(ostfollow.follow_up_type_id=ft.id)\r\n"
			+ "left join soch.master_primary_drug mod on(ostfollow.other_drug_id=mod.id)\r\n"
			+ "left join soch.master_primary_drug mpd on(ostfollow.primary_drug_id=mpd.id)\r\n"
			+ "left join soch.ti_ost_beneficiary ostben on (ostfollow.ti_ost_beneficiary_id = ostben.id)\r\n"
			+ "cross join soch.beneficiary ben \r\n"
			+ "left join soch.master_ost_status_beneficiary mos on (ostben.ost_status_id=mos.id)\r\n"
			+ "left join soch.master_client_status_ost mcs on (ostben.status_id=mcs.id)\r\n"
			+ "left join soch.beneficiary_facility_mapping bfm \r\n"
			+ "on ben.id = bfm.beneficiary_id AND ( bfm.is_active =true ) \r\n"
			+ "left outer join soch.ti_ost_follow_up_by fb on(ostfollow.id=fb.followup_id)\r\n"
			+ "left outer join soch.master_followup_by mfb on(fb.follow_up_by_id=mfb.id)\r\n"
			+ "join soch.master_gender g on(ben.gender_id=g.id)\r\n"
			+ "where ostben.beneficiary_id=ben.id and ben.is_delete=:isDelete and ostfollow.is_delete=:isDelete \r\n"
			+ "and ostfollow.is_early=:isEarly and (mcs.id in :status) \r\n"
			+ "and bfm.facility_id=:facilityId and ostfollow.next_followup_date=:followUpDate\r\n"
			+ "and (lower(ben.ost_benf_search_str) like %:searchString%)";
	String missedFollowUpQuery = "select fb.id as followUpId,mfb.id as followUpById,mfb.name as followUpBy,ostfollow.id as id,ostfollow.follow_up_date as followUpDate,\r\n"
			+ "ostfollow.is_active as isActive,ostfollow.is_delete as isDelete,\r\n"
			+ "ostfollow.is_early as isEarly,ostfollow.next_followup_date as nextFollowUpDate,\r\n"
			+ "ostfollow.follow_up_type_id as followUpTypeId,ft.name as followUpType,\r\n"
			+ "ostfollow.frequency_of_other_drug_use as frequencyOfOtherDrugUse, \r\n"
			+ "ostfollow.frequency_of_primary_drug_use as frequencyOfPrimaryDrugUse, \r\n"
			+ "ostfollow.last_dose_of_primary_drug as lastDoseOfPrimaryDrug,\r\n"
			+ "ostfollow.last_dose_of_other_drug as lastDoseOfOtherDrug,\r\n"
			+ "ostfollow.other_drug_id as otherDrugId,mod.name as otherDrug,\r\n"
			+ "ostfollow.primary_drug_id as primaryDrugId,mpd.name as primaryDrug,\r\n"
			+ "ostfollow.no_side_effects as noSideEffects,\r\n"
			+ "ostfollow.ti_ost_beneficiary_id as tiOstBeneficiaryId,\r\n"
			+ "ostben.beneficiary_id as beneficiaryId,\r\n"
			+ "ostben.ost_code as ostCode,ostben.ost_number as ostNumber,\r\n"
			+ "ostben.ost_status_id as ostStatusId,ostben.status_id as statusId,\r\n"
			+ "mcs.name as ostStatus,mos.name as status,\r\n"
			+ "ben.first_name as firstName,ben.last_name as lastname,\r\n"
			+ "ben.middle_name as middleName,ben.age as age,ben.date_of_birth as dateOfBirth,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.uid as uid,ben.gender_id as genderId,g.name as gender\r\n"
			+ "from soch.ti_ost_follow_up ostfollow\r\n"
			+ "left join soch.master_follow_up_type ft on(ostfollow.follow_up_type_id=ft.id)\r\n"
			+ "left join soch.master_primary_drug mod on(ostfollow.other_drug_id=mod.id)\r\n"
			+ "left join soch.master_primary_drug mpd on(ostfollow.primary_drug_id=mpd.id)\r\n"
			+ "left join soch.ti_ost_beneficiary ostben on (ostfollow.ti_ost_beneficiary_id = ostben.id)\r\n"
			+ "cross join soch.beneficiary ben \r\n"
			+ "left join soch.master_ost_status_beneficiary mos on (ostben.ost_status_id=mos.id)\r\n"
			+ "left join soch.master_client_status_ost mcs on (ostben.status_id=mcs.id)\r\n"
			+ "left join soch.beneficiary_facility_mapping bfm \r\n"
			+ "on ben.id = bfm.beneficiary_id AND ( bfm.is_active =true ) \r\n"
			+ "left outer join soch.ti_ost_follow_up_by fb on(ostfollow.id=fb.followup_id)\r\n"
			+ "left outer join soch.master_followup_by mfb on(fb.follow_up_by_id=mfb.id)\r\n"
			+ "join soch.master_gender g on(ben.gender_id=g.id)\r\n"
			+ "where ostben.beneficiary_id=ben.id and ben.is_delete=:isDelete and ostfollow.is_delete=:isDelete \r\n"
			+ "and ostfollow.is_early=:isEarly and (mcs.id in :status) \r\n"
			+ "and bfm.facility_id=:facilityId and ostfollow.next_followup_date < :followUpDate\r\n"
			+ "and (lower(ben.ost_benf_search_str) like %:searchString%)";
	
	
	String todaysFollowUpQueryWithoutTsVector = "select fb.id as followUpId,mfb.id as followUpById,mfb.name as followUpBy,ostfollow.id as id,ostfollow.follow_up_date as followUpDate,\r\n"
			+ "ostfollow.is_active as isActive,ostfollow.is_delete as isDelete,\r\n"
			+ "ostfollow.is_early as isEarly,ostfollow.next_followup_date as nextFollowUpDate,\r\n"
			+ "ostfollow.follow_up_type_id as followUpTypeId,ft.name as followUpType,\r\n"
			+ "ostfollow.frequency_of_other_drug_use as frequencyOfOtherDrugUse, \r\n"
			+ "ostfollow.frequency_of_primary_drug_use as frequencyOfPrimaryDrugUse, \r\n"
			+ "ostfollow.last_dose_of_primary_drug as lastDoseOfPrimaryDrug,\r\n"
			+ "ostfollow.last_dose_of_other_drug as lastDoseOfOtherDrug,\r\n"
			+ "ostfollow.other_drug_id as otherDrugId,mod.name as otherDrug,\r\n"
			+ "ostfollow.primary_drug_id as primaryDrugId,mpd.name as primaryDrug,\r\n"
			+ "ostfollow.no_side_effects as noSideEffects,\r\n"
			+ "ostfollow.ti_ost_beneficiary_id as tiOstBeneficiaryId,\r\n"
			+ "ostben.beneficiary_id as beneficiaryId,\r\n"
			+ "ostben.ost_code as ostCode,ostben.ost_number as ostNumber,\r\n"
			+ "ostben.ost_status_id as ostStatusId,ostben.status_id as statusId,\r\n"
			+ "mcs.name as ostStatus,mos.name as status,\r\n"
			+ "ben.first_name as firstName,ben.last_name as lastname,\r\n"
			+ "ben.middle_name as middleName,ben.age as age,ben.date_of_birth as dateOfBirth,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.uid as uid,ben.gender_id as genderId,g.name as gender\r\n"
			+ "from soch.ti_ost_follow_up ostfollow\r\n"
			+ "left join soch.master_follow_up_type ft on(ostfollow.follow_up_type_id=ft.id)\r\n"
			+ "left join soch.master_primary_drug mod on(ostfollow.other_drug_id=mod.id)\r\n"
			+ "left join soch.master_primary_drug mpd on(ostfollow.primary_drug_id=mpd.id)\r\n"
			+ "left join soch.ti_ost_beneficiary ostben on (ostfollow.ti_ost_beneficiary_id = ostben.id)\r\n"
			+ "cross join soch.beneficiary ben \r\n"
			+ "left join soch.master_ost_status_beneficiary mos on (ostben.ost_status_id=mos.id)\r\n"
			+ "left join soch.master_client_status_ost mcs on (ostben.status_id=mcs.id)\r\n"
			+ "left join soch.beneficiary_facility_mapping bfm \r\n"
			+ "on ben.id = bfm.beneficiary_id AND ( bfm.is_active =true ) \r\n"
			+ "left outer join soch.ti_ost_follow_up_by fb on(ostfollow.id=fb.followup_id)\r\n"
			+ "left outer join soch.master_followup_by mfb on(fb.follow_up_by_id=mfb.id)\r\n"
			+ "join soch.master_gender g on(ben.gender_id=g.id)\r\n"
			+ "where ostben.beneficiary_id=ben.id and ben.is_delete=:isDelete and ostfollow.is_delete=:isDelete \r\n"
			+ "and ostfollow.is_early=:isEarly and (mcs.id in :status) \r\n"
			+ "and bfm.facility_id=:facilityId and ostfollow.next_followup_date=:followUpDate\r\n";
	String missedFollowUpQueryWithoutTsVector = "select fb.id as followUpId,mfb.id as followUpById,mfb.name as followUpBy,ostfollow.id as id,ostfollow.follow_up_date as followUpDate,\r\n"
			+ "ostfollow.is_active as isActive,ostfollow.is_delete as isDelete,\r\n"
			+ "ostfollow.is_early as isEarly,ostfollow.next_followup_date as nextFollowUpDate,\r\n"
			+ "ostfollow.follow_up_type_id as followUpTypeId,ft.name as followUpType,\r\n"
			+ "ostfollow.frequency_of_other_drug_use as frequencyOfOtherDrugUse, \r\n"
			+ "ostfollow.frequency_of_primary_drug_use as frequencyOfPrimaryDrugUse, \r\n"
			+ "ostfollow.last_dose_of_primary_drug as lastDoseOfPrimaryDrug,\r\n"
			+ "ostfollow.last_dose_of_other_drug as lastDoseOfOtherDrug,\r\n"
			+ "ostfollow.other_drug_id as otherDrugId,mod.name as otherDrug,\r\n"
			+ "ostfollow.primary_drug_id as primaryDrugId,mpd.name as primaryDrug,\r\n"
			+ "ostfollow.no_side_effects as noSideEffects,\r\n"
			+ "ostfollow.ti_ost_beneficiary_id as tiOstBeneficiaryId,\r\n"
			+ "ostben.beneficiary_id as beneficiaryId,\r\n"
			+ "ostben.ost_code as ostCode,ostben.ost_number as ostNumber,\r\n"
			+ "ostben.ost_status_id as ostStatusId,ostben.status_id as statusId,\r\n"
			+ "mcs.name as ostStatus,mos.name as status,\r\n"
			+ "ben.first_name as firstName,ben.last_name as lastname,\r\n"
			+ "ben.middle_name as middleName,ben.age as age,ben.date_of_birth as dateOfBirth,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.uid as uid,ben.gender_id as genderId,g.name as gender\r\n"
			+ "from soch.ti_ost_follow_up ostfollow\r\n"
			+ "left join soch.master_follow_up_type ft on(ostfollow.follow_up_type_id=ft.id)\r\n"
			+ "left join soch.master_primary_drug mod on(ostfollow.other_drug_id=mod.id)\r\n"
			+ "left join soch.master_primary_drug mpd on(ostfollow.primary_drug_id=mpd.id)\r\n"
			+ "left join soch.ti_ost_beneficiary ostben on (ostfollow.ti_ost_beneficiary_id = ostben.id)\r\n"
			+ "cross join soch.beneficiary ben \r\n"
			+ "left join soch.master_ost_status_beneficiary mos on (ostben.ost_status_id=mos.id)\r\n"
			+ "left join soch.master_client_status_ost mcs on (ostben.status_id=mcs.id)\r\n"
			+ "left join soch.beneficiary_facility_mapping bfm \r\n"
			+ "on ben.id = bfm.beneficiary_id AND ( bfm.is_active =true ) \r\n"
			+ "left outer join soch.ti_ost_follow_up_by fb on(ostfollow.id=fb.followup_id)\r\n"
			+ "left outer join soch.master_followup_by mfb on(fb.follow_up_by_id=mfb.id)\r\n"
			+ "join soch.master_gender g on(ben.gender_id=g.id)\r\n"
			+ "where ostben.beneficiary_id=ben.id and ben.is_delete=:isDelete and ostfollow.is_delete=:isDelete \r\n"
			+ "and ostfollow.is_early=:isEarly and (mcs.id in :status) \r\n"
			+ "and bfm.facility_id=:facilityId and ostfollow.next_followup_date < :followUpDate\r\n";


}
