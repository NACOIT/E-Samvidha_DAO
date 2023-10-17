package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constructordto.ScreeningDTO;
import gov.naco.soch.entity.TIBenScrDetails;
import gov.naco.soch.projection.TiBeneficiaryScreeningProjection;
import gov.naco.soch.projection.TiBeneficiaryScreeningProjectionForMobile;

/**
 * Spring Data repository for the TIBenScrDetails entity.
 */
@Repository
public interface TIBenScrDetailsRepository
		extends JpaRepository<TIBenScrDetails, Long>, JpaSpecificationExecutor<TIBenScrDetails> {

	@Query(nativeQuery = true, value = "select scr.* from soch.ti_ben_scr_details  scr join (select infection,max(date_of_screening) as latestscreeningdate "
			+ " from soch.ti_ben_scr_details group by infection ) groupedscr  "
			+ " on scr.infection=groupedscr.infection and scr.date_of_screening=groupedscr.latestscreeningdate where scr.beneficiary_id=:beneficiaryId ")
	Stream<TIBenScrDetails> findScreeningDetailsByBeneficiary(@Param("beneficiaryId") Long beneficiaryId);

	@Query("select  new gov.naco.soch.constructordto.ScreeningDTO(max(id) as id,case when infection.id=1 then screeningStatusHiv.id "
			+ " when infection.id=2 then screeningStatusSyphilis.id when infection.id=3 then tbStatus.id end as status)"
			+ " from TIBenScrDetails where infection.id=:infectionId and beneficiary.id=:beneficiaryId group by infection.id,"
			+ " screeningStatusHiv.id,screeningStatusSyphilis.id,tbStatus.id  ")
	ScreeningDTO findLatestRecord(@Param("infectionId") Long infectionId, @Param("beneficiaryId") Long beneficiaryId);

	@Query("select  new gov.naco.soch.constructordto.ScreeningDTO(max(id) as id,case when infection.id=1 then screeningStatusHiv.id "
			+ " when infection.id=2 then screeningStatusSyphilis.id when infection.id=3 then tbStatus.id end as status)"
			+ " from TIBenScrDetails where infection.id=:infectionId and beneficiary.id=:beneficiaryId group by infection.id,"
			+ " screeningStatusHiv.id,screeningStatusSyphilis.id,tbStatus.id  ")
	ScreeningDTO findLatestRecordV2(@Param("infectionId") Long infectionId, @Param("beneficiaryId") Long beneficiaryId);

	@Query("select  max(dateOfScreening) from TIBenScrDetails where infection.id=:infectionId and beneficiary.id=:beneficiaryId"
			+ " and beneficiary.hrgPrimary.typologyId not in(:bridgeTi)")
	LocalDate findLatestScreeningDate(@Param("beneficiaryId") Long beneficiaryId,
			@Param("infectionId") Long infectionId, @Param("bridgeTi") List<Long> bridgeTi);

	@Query("select  max(dateOfScreening) from TIBenScrDetails where infection.id=:infectionId and beneficiary.id=:beneficiaryId"
			+ " and beneficiary.hrgPrimary.typologyId in(:bridgeTi) and screeningStatusHiv in (1,3)")
	LocalDate findLatestScreeningDateForBridgeICTCReferel(@Param("beneficiaryId") Long beneficiaryId,
			@Param("infectionId") Long infectionId, @Param("bridgeTi") List<Long> bridgeTi);

	@Query(nativeQuery = true, value = "select  count(scr.id) from soch.ti_ben_scr_details scr  join soch.ti_beneficiary tb on tb.id=scr.beneficiary_id "
			+ " join soch.typology_master tm on tm.typology_id=tb.master_hrg_primary_id"
			+ " where infection_id=:infectionId and scr.beneficiary_id=:beneficiaryId"
			+ " and tm.typology_id in(:bridges) and date(scr.date_of_screening)=:screeningDate")
	long validateScreeningForBridge(@Param("beneficiaryId") Long beneficiaryId, @Param("infectionId") Long infectionId,
			@Param("screeningDate") LocalDate screeningDate, @Param("bridges") List<Long> bridges);

	@Query(nativeQuery = true, countQuery = upcomingCountQuery, value = upcomingQuery)
	Page<TiBeneficiaryScreeningProjection> findTiUpcomingScreeningByBasicSearchWithTsVector(
			@Param("facilityId") Long facilityId, @Param("statusId") Long statusId,
			@Param("isDeleted") Boolean isDeleted, @Param("isEarly") Boolean isEarly,
			@Param("nextDateOfScreening1") LocalDate nextDateOfScreening1,
			@Param("nextDateOfScreening2") LocalDate nextDateOfScreening2, @Param("searchString") String searchString,
			Pageable page);

	@Query(nativeQuery = true, countQuery = missedScreeningCountQuery, value = missedScreeningQuery)
	Page<TiBeneficiaryScreeningProjection> findTiMissedScreeningByBasicSearchWithTsVector(
			@Param("facilityId") Long facilityId, @Param("statusId") Long statusId,
			@Param("isDeleted") Boolean isDeleted, @Param("isEarly") Boolean isEarly,
			@Param("nextDateOfScreening") LocalDate nextDateOfScreening, @Param("searchString") String searchString,
			Pageable page);

	String upcomingCountQuery = "select count(scr.id) "
			+ "from soch.ti_ben_scr_details scr left outer join soch.master_infection_type mit on scr.infection_id = mit.id	\r\n"
			+ "left outer join soch.ti_beneficiary tiben on scr.beneficiary_id = tiben.id\r\n"
			+ "left outer join soch.beneficiary ben on tiben.beneficiary_id = ben.id\r\n"
			+ "left outer join soch.beneficiary_facility_mapping bfm on ben.id = bfm.beneficiary_id and (bfm.is_active =true)\r\n"
			+ "left outer join soch.master_client_status_ticore mcs on tiben.status_id = mcs.id where mcs.id = :statusId\r\n"
			+ "and scr.is_early =:isEarly and bfm.facility_id =:facilityId and scr.is_deleted =:isDeleted and scr.next_date_of_screening <=:nextDateOfScreening2\r\n"
			+ "and scr.next_date_of_screening >=:nextDateOfScreening1 and ben.ti_benf_search_str ilike :searchString ";

	String upcomingQuery = "select scr.id as id,scr.date_of_screening as dateOfScreening ,scr.next_date_of_screening  as nextDateOfScreening,\r\n"
			+ "scr.facility_id as facilityId,scr.is_deleted as isDeleted,scr.is_early as isEarly,scr.is_active as isActive,scr.infection_id as infectionId,\r\n"
			+ "mit.name as infectionStatus,scr.beneficiary_id as tiBeneficiaryId,tiben.date_of_reg as dateOfReg,tiben.ti_code as tiCode,\r\n"
			+ "tiben.status_id as statusId,mcs.name as status,tm.typology_id as hrgPrimaryId,tm.typology_name as hrgPrimaryName,\r\n"
			+ "ben.age as age,ben.date_of_birth as dateOfBirth,ben.first_name  as firstName,ben.id as beneficiaryId,ben.last_name as lastName,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.uid as uid,ben.gender_id as genderId,g.name as gender\r\n"
			+ "from soch.ti_ben_scr_details scr left outer join soch.master_infection_type mit on scr.infection_id = mit.id	\r\n"
			+ "left outer join soch.ti_beneficiary tiben on scr.beneficiary_id = tiben.id\r\n"
			+ "left outer join soch.typology_master tm on tiben.master_hrg_primary_id = tm.typology_id\r\n"
			+ "left outer join soch.beneficiary ben on tiben.beneficiary_id = ben.id\r\n"
			+ "left outer join soch.beneficiary_facility_mapping bfm on ben.id = bfm.beneficiary_id and (bfm.is_active =true)\r\n"
			+ "left outer join soch.master_client_status_ticore mcs on tiben.status_id = mcs.id\r\n"
			+ "left outer join soch.master_gender g on ben.gender_id = g.id where mcs.id = :statusId\r\n"
			+ "and scr.is_early =:isEarly and bfm.facility_id =:facilityId and scr.is_deleted =:isDeleted and scr.next_date_of_screening <=:nextDateOfScreening2\r\n"
			+ "and scr.next_date_of_screening >=:nextDateOfScreening1 and ben.ti_benf_search_str ilike :searchString ";

	String missedScreeningCountQuery = "select count(scr.id) "
			+ "from soch.ti_ben_scr_details scr left outer join soch.master_infection_type mit on scr.infection_id = mit.id	\r\n"
			+ "left outer join soch.ti_beneficiary tiben on scr.beneficiary_id = tiben.id\r\n"
			+ "left outer join soch.beneficiary ben on tiben.beneficiary_id = ben.id\r\n"
			+ "left outer join soch.beneficiary_facility_mapping bfm on ben.id = bfm.beneficiary_id and (bfm.is_active =true)\r\n"
			+ "left outer join soch.master_client_status_ticore mcs on tiben.status_id = mcs.id where mcs.id = :statusId\r\n"
			+ "and scr.is_early =:isEarly and bfm.facility_id =:facilityId and scr.is_deleted =:isDeleted and scr.next_date_of_screening <=:nextDateOfScreening\r\n"
			+ "and ben.ti_benf_search_str ilike :searchString ";

	String missedScreeningQuery = "select scr.id as id,scr.date_of_screening as dateOfScreening ,scr.next_date_of_screening  as nextDateOfScreening,\r\n"
			+ "scr.facility_id as facilityId,scr.is_deleted as isDeleted,scr.is_early as isEarly,scr.is_active as isActive,scr.infection_id as infectionId,\r\n"
			+ "mit.name as infectionStatus,scr.beneficiary_id as tiBeneficiaryId,tiben.date_of_reg as dateOfReg,tiben.ti_code as tiCode,\r\n"
			+ "tiben.status_id as statusId,mcs.name as status,tm.typology_id as hrgPrimaryId,tm.typology_name as hrgPrimaryName,\r\n"
			+ "ben.age as age,ben.date_of_birth as dateOfBirth,ben.first_name  as firstName,ben.id as beneficiaryId,ben.last_name as lastName,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.uid as uid,ben.gender_id as genderId,g.name as gender\r\n"
			+ "from soch.ti_ben_scr_details scr left outer join soch.master_infection_type mit on scr.infection_id = mit.id	\r\n"
			+ "left outer join soch.ti_beneficiary tiben on scr.beneficiary_id = tiben.id\r\n"
			+ "left outer join soch.typology_master tm on tiben.master_hrg_primary_id = tm.typology_id\r\n"
			+ "left outer join soch.beneficiary ben on tiben.beneficiary_id = ben.id\r\n"
			+ "left outer join soch.beneficiary_facility_mapping bfm on ben.id = bfm.beneficiary_id and (bfm.is_active =true)\r\n"
			+ "left outer join soch.master_client_status_ticore mcs on tiben.status_id = mcs.id\r\n"
			+ "left outer join soch.master_gender g on ben.gender_id = g.id where mcs.id = :statusId\r\n"
			+ "and scr.is_early =:isEarly and bfm.facility_id =:facilityId and scr.is_deleted =:isDeleted and scr.next_date_of_screening <=:nextDateOfScreening\r\n"
			+ "and ben.ti_benf_search_str ilike :searchString ";

	@Query(nativeQuery = true, countQuery = upcomingCountQueryForMobile, value = upcomingQueryForMobile)
	Page<TiBeneficiaryScreeningProjectionForMobile> findTiUpcomingScreeningByBasicSearchWithTsVectorForMobile(
			@Param("facilityId") Long facilityId, @Param("statusId") Long statusId,
			@Param("isDeleted") Boolean isDeleted, @Param("isEarly") Boolean isEarly,
			@Param("nextDateOfScreening1") LocalDate nextDateOfScreening1,
			@Param("nextDateOfScreening2") LocalDate nextDateOfScreening2, @Param("searchString") String searchString,
			Pageable page);

	String upcomingCountQueryForMobile = "select count(scr.id) "
			+ "from soch.ti_ben_scr_details scr left outer join soch.master_infection_type mit on scr.infection_id = mit.id	\r\n"
			+ "left outer join soch.ti_beneficiary tiben on scr.beneficiary_id = tiben.id\r\n"
			+ "left outer join soch.beneficiary ben on tiben.beneficiary_id = ben.id\r\n"
			+ "left outer join soch.beneficiary_facility_mapping bfm on ben.id = bfm.beneficiary_id and (bfm.is_active =true)\r\n"
			+ "left outer join soch.master_client_status_ticore mcs on tiben.status_id = mcs.id where mcs.id = :statusId\r\n"
			+ "and scr.is_early =:isEarly and bfm.facility_id =:facilityId and scr.is_deleted =:isDeleted and scr.next_date_of_screening <=:nextDateOfScreening2\r\n"
			+ "and scr.next_date_of_screening >=:nextDateOfScreening1 and ben.ti_benf_search_str ilike :searchString  ";

	String upcomingQueryForMobile = "select scr.id as id,scr.date_of_screening as dateOfScreening ,scr.next_date_of_screening  as nextDateOfScreening,\r\n"
			+ "scr.facility_id as facilityId,scr.is_deleted as isDeleted,scr.is_early as isEarly,scr.is_active as isActive,scr.infection_id as infectionId,\r\n"
			+ "mit.name as infectionStatus,scr.beneficiary_id as tiBeneficiaryId,tiben.date_of_reg as dateOfReg,tiben.ti_code as tiCode,\r\n"
			+ "tiben.status_id as statusId,mcs.name as status,tm.typology_id as hrgPrimaryId,tm.typology_name as hrgPrimaryName,\r\n"
			+ "ben.age as age,ben.date_of_birth as dateOfBirth,ben.first_name  as firstName,ben.id as beneficiaryId,ben.last_name as lastName,\r\n"
			+ "ben.mobile_number as mobileNumber,ben.uid as uid,ben.gender_id as genderId,g.name as gender\r\n"
			+ "from soch.ti_ben_scr_details scr left outer join soch.master_infection_type mit on scr.infection_id = mit.id	\r\n"
			+ "left outer join soch.ti_beneficiary tiben on scr.beneficiary_id = tiben.id\r\n"
			+ "left outer join soch.typology_master tm on tiben.master_hrg_primary_id = tm.typology_id\r\n"
			+ "left outer join soch.beneficiary ben on tiben.beneficiary_id = ben.id\r\n"
			+ "left outer join soch.beneficiary_facility_mapping bfm on ben.id = bfm.beneficiary_id and (bfm.is_active =true)\r\n"
			+ "left outer join soch.master_client_status_ticore mcs on tiben.status_id = mcs.id\r\n"
			+ "left outer join soch.master_gender g on ben.gender_id = g.id where mcs.id = :statusId\r\n"
			+ "and scr.is_early =:isEarly and bfm.facility_id =:facilityId and scr.is_deleted =:isDeleted and scr.next_date_of_screening <=:nextDateOfScreening2\r\n"
			+ "and scr.next_date_of_screening >=:nextDateOfScreening1 and ben.ti_benf_search_str ilike :searchString ";
}
