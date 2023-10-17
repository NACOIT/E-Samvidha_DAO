package gov.naco.soch.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.RVAssessmentV2ForMobile;
import gov.naco.soch.projection.TiBenRVAssessmentProjection;
import gov.naco.soch.projection.TiBenRVAssessmentProjectionForMobile;

@Repository
public interface RVAssessmentV2RepositoryForMobile
		extends JpaRepository<RVAssessmentV2ForMobile, Long>, JpaSpecificationExecutor<RVAssessmentV2ForMobile> {

	String query = "select trv.id as id,trv.due_date_of_assessment as dueDate, trv.facility_id as facilityId,\r\n"
			+ "trv.is_delete as isDelete, trv.is_early as isEarly, tiben.id as tiBenId,\r\n"
			+ "tiben.ti_code as tiCode,tiben.date_of_reg as dateOfReg, \r\n"
			+ "tm.typology_id as typologyId,tm.typology_name as typologyName,\r\n"
			+ "msc.id as statusId,msc.name as status,ben.id as beneficiaryId,\r\n"
			+ "ben.uid as uid,ben.first_name as firstname, ben.mobile_number as mobile,\r\n"
			+ "ben.last_name as lastname,ben.date_of_birth as dateOfBirth,bg.name as gender\r\n"
			+ "from soch.ti_ben_rv_assessment  trv\r\n"
			+ "left outer join soch.ti_beneficiary tiben on tiben.id=trv.beneficiary_id\r\n"
			+ "left outer join soch.beneficiary ben on ben.id=tiben.beneficiary_id\r\n"
			+ "left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id\r\n"
			+ "left outer join soch.typology_master tm on tm.typology_id = tiben.master_hrg_primary_id\r\n"
			+ "left outer join soch.master_gender bg on ben.gender_id = bg.id\r\n"
			+ "where trv.due_date_of_assessment>=:dueDate and trv.due_date_of_assessment<=:endDueDate\r\n"
			+ "and trv.is_delete=:isDeleted and trv.facility_id=:facilityId and ben.ti_benf_search_str ilike :searchString \r\n"
			+ "";

	String count = "\r\n" + "select count(*)\r\n" + "from soch.ti_ben_rv_assessment  trv\r\n"
			+ "left outer join soch.ti_beneficiary tiben on tiben.id=trv.beneficiary_id\r\n"
			+ "left outer join soch.beneficiary ben on ben.id=tiben.beneficiary_id\r\n"
			+ "left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id\r\n"
			+ "where trv.due_date_of_assessment>=:duDate and trv.due_date_of_assessment<=:endDueDate\r\n"
			+ "and trv.is_delete=:isDeleted and trv.facility_id=:facilityId and ben.ti_benf_search_str ilike :searchString \r\n"
			+ "";

	@Query(nativeQuery = true, value = query, countQuery = count)
	Page<TiBenRVAssessmentProjectionForMobile> findTiBenAssessmentByBasicSearchWithTsVector(
			@Param("facilityId") Long facilityId, @Param("isDeleted") Boolean isDeleted,
			@Param("searchString") String searchString, @Param("dueDate") LocalDate dueDate,
			@Param("endDueDate") LocalDate endDueDate, Pageable pageable);

	String missedAssessmentquery = "select trv.id as id,trv.due_date_of_assessment as dueDate, trv.facility_id as facilityId,\r\n"
			+ "trv.is_delete as isDelete, trv.is_early as isEarly, tiben.id as tiBenId,\r\n"
			+ "tiben.ti_code as tiCode,tiben.date_of_reg as dateOfReg, \r\n"
			+ "tm.typology_id as typologyId,tm.typology_name as typologyName,\r\n"
			+ "msc.id as statusId,msc.name as status,ben.id as beneficiaryId,\r\n"
			+ "ben.uid as uid,ben.first_name as firstname, ben.mobile_number as mobile,\r\n"
			+ "ben.last_name as lastname,ben.date_of_birth as dateOfBirth,bg.name as gender\r\n"
			+ "from soch.ti_ben_rv_assessment  trv\r\n"
			+ "left outer join soch.ti_beneficiary tiben on tiben.id=trv.beneficiary_id\r\n"
			+ "left outer join soch.beneficiary ben on ben.id=tiben.beneficiary_id\r\n"
			+ "left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id\r\n"
			+ "left outer join soch.typology_master tm on tm.typology_id = tiben.master_hrg_primary_id\r\n"
			+ "left outer join soch.master_gender bg on ben.gender_id = bg.id\r\n"
			+ "where trv.due_date_of_assessment<=:dueDate\r\n"
			+ "and trv.is_delete=:isDeleted and trv.facility_id=:facilityId and ben.ti_benf_search_str ilike :searchString \r\n"
			+ "";

	String missedAssessmentCount = "\r\n" + "select count(*)\r\n" + "from soch.ti_ben_rv_assessment  trv\r\n"
			+ "left outer join soch.ti_beneficiary tiben on tiben.id=trv.beneficiary_id\r\n"
			+ "left outer join soch.beneficiary ben on ben.id=tiben.beneficiary_id\r\n"
			+ "left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id\r\n"
			+ "where trv.due_date_of_assessment<=:dueDate\r\n"
			+ "and trv.is_delete=:isDeleted and trv.facility_id=:facilityId and ben.ti_benf_search_str ilike :searchString \r\n"
			+ "";

	@Query(nativeQuery = true, value = missedAssessmentquery, countQuery = missedAssessmentCount)
	Page<TiBenRVAssessmentProjection> findTiBenMissedAssessmentByBasicSearchWithTsVector(
			@Param("facilityId") Long facilityId, @Param("isDeleted") Boolean isDeleted,
			@Param("searchString") String searchString, @Param("dueDate") LocalDate dueDate, Pageable pageable);

}
