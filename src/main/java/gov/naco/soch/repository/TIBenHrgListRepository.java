package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenScrDetails;
import gov.naco.soch.projection.TiBeneficiaryHrgListProjection;

@Repository
public interface TIBenHrgListRepository
		extends PagingAndSortingRepository<TIBenScrDetails, Long>, JpaSpecificationExecutor<TIBenScrDetails> {
	@Query(nativeQuery = true, value = "SELECT distinct(ben.uid) AS uid,ben.id as beneficiaryId, ben.first_name AS firstName,ben.middle_name AS middleName    ,\r\n" + 
			"ben.last_name AS lastName,ben.mobile_number AS mobileNumber,CONCAT('PE', tiben.pe_code) AS peCode,\r\n" + 
			"tiben.ti_code AS tiCode,tiben.id AS tiBeneficiaryId, bg.name AS gender, date_part('year',AGE(ben.date_of_birth)) as age,tm.typology_name AS typologyName,\r\n" + 
			"msc.name AS STATUS,mhss.name AS hivScreeningStatus,mhs.name AS hivConfirmatoryStatus\r\n" + 
			"FROM soch.beneficiary ben\r\n" + 
			"LEFT OUTER JOIN soch.ti_beneficiary tiben ON tiben.beneficiary_id = ben.id\r\n" + 
			"LEFT OUTER JOIN soch.master_client_status_ticore msc ON tiben.status_id = msc.id\r\n" + 
			"LEFT OUTER JOIN soch.typology_master tm ON tm.typology_id = tiben.master_hrg_primary_id\r\n" + 
			"LEFT OUTER JOIN soch.master_gender bg ON ben.gender_id = bg.id\r\n" + 
			"LEFT OUTER JOIN soch.ti_ben_scr_details tbsd ON tbsd.beneficiary_id = tiben.id\r\n" + 
			"LEFT OUTER JOIN soch.master_hiv_screening_status mhss ON mhss.id = tbsd.screening_status_hiv_id\r\n" + 
			"LEFT OUTER JOIN soch.master_hiv_status mhs ON mhs.id = ben.hiv_status_id\r\n" + 
			"WHERE tiben.facility_id = :facilityId     AND tiben.is_deleted = :isDeleted\r\n" + 
			"AND tiben.orw_code = :orwCode    AND tiben.master_hrg_primary_id = :typologyId\r\n" + 
			"AND tbsd.infection_id=1")
	List<TiBeneficiaryHrgListProjection> getTIBenHrgList(@Param("facilityId") Long facilityId,
			@Param("orwCode") String orwCode, @Param("typologyId") Long typologyId,
			@Param("isDeleted") boolean isDeleted, Pageable pageable);

	@Query(nativeQuery = true, value = "select count(distinct tiben.beneficiary_id) as ti_beneficiaries_count\n"
			+ "from soch.ti_beneficiary tiben\n"
			+ "left outer join soch.beneficiary ben on tiben.beneficiary_id = ben.id\n"
			+ "left outer join soch.beneficiary_facility_mapping bfm on ben.id = bfm.beneficiary_id and (bfm.is_active = true)\n"
			+ "left outer join soch.facility fac on bfm.facility_id = fac.id\n"
			+ "left outer join soch.master_client_status_ticore msc on tiben.status_id = msc.id\n"
			+ "left outer join soch.typology_master tm on tm.typology_id = tiben.master_hrg_primary_id\n"
			+ "left outer join soch.master_gender bg on ben.gender_id = bg.id\n"
			+ "left outer join soch.ti_ben_scr_details tbsd on tbsd.beneficiary_id = tiben.id\n"
			+ "left outer join soch.master_hiv_screening_status mhss on mhss.id = tbsd.screening_status_hiv_id\n"
			+ "where fac.id = :facilityId and tiben.is_deleted = :isDeleted and tiben.orw_code = :orwCode and tiben.master_hrg_primary_id = :typologyId")
	int getNumberOfCount(@Param("facilityId") Long facilityId, @Param("orwCode") String orwCode,
			@Param("typologyId") Long typologyId, @Param("isDeleted") boolean isDeleted);

	@Query(nativeQuery = true, value = "SELECT count(DISTINCT tiben.beneficiary_id) AS ti_reactive_beneficiaries_count\r\n" + 
			"FROM soch.ti_beneficiary tiben\r\n" + 
			"LEFT OUTER JOIN soch.beneficiary ben ON tiben.beneficiary_id = ben.id\r\n" + 
			"LEFT OUTER JOIN soch.ti_ben_scr_details tbsd ON tbsd.beneficiary_id = tiben.id\r\n" + 
			"WHERE ( ben.hiv_status_id = 2 OR (tbsd.infection_id = 1 AND tbsd.screening_status_hiv_id = 1))\r\n" + 
			"AND tiben.facility_id = :facilityId\r\n" + 
			"AND tiben.is_deleted = :isDeleted\r\n" + 
			"AND tiben.orw_code = :orwCode\r\n" + 
			"AND tiben.master_hrg_primary_id = :typologyId")
	int getNumberOfReactiveCount(@Param("facilityId") Long facilityId, @Param("orwCode") String orwCode,
			@Param("typologyId") Long typologyId, @Param("isDeleted") boolean isDeleted);

}
