package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.projection.ArtBeneficiaryQueueProjection;
import gov.naco.soch.projection.UserRoleMappingQueueProjection;

//repository mapped with entity class

@Repository
public interface ArtBeneficiaryQueueRepository extends JpaRepository<ArtBeneficiaryQueue, Long>, CustomRepository {

//	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.assigned_to=:assignedTo "
//			+ "and bq.facility_id=:facilityId and bq.is_visited=:isVisited and bq.visit_date=:visitDate "
//			+ "and is_active=true and is_delete=false order by bq.id asc", nativeQuery = true)
//	List<ArtBeneficiaryQueue> findAllByAssignedTo(@Param("assignedTo") Long assignedTo,
//			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
//			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select count(bq.beneficiary_id) "
			+ "from soch.art_beneficiary_queue bq, soch.art_beneficiary ab, soch.beneficiary b, soch.master_gender g, soch.master_art_beneficiary_status ms, soch.user_master um "
			+ "where bq.beneficiary_id= ab.beneficiary_id and b.id=bq.beneficiary_id and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id and um.id = bq.assigned_to "
			+ "and bq.assigned_to=:assignedTo and bq.facility_id=:facilityId and bq.is_visited=false and bq.visit_date=:visitDate "
			+ "and bq.is_active=true and bq.is_delete=false", nativeQuery = true)
	int findAllByAssignedCount(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate);

//	@Query(value = "select count(bq.beneficiary_id) "
//			+ "from soch.art_beneficiary_queue bq, soch.art_beneficiary ab, soch.beneficiary b, soch.master_gender g, soch.master_art_beneficiary_status ms, soch.user_master um "
//			+ "where bq.beneficiary_id= ab.beneficiary_id and b.id=bq.beneficiary_id and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id and um.id = bq.assigned_to "
//			+ "and bq.assigned_to=:assignedTo and bq.facility_id=:facilityId and bq.is_visited=true and bq.visit_date=:visitDate ", nativeQuery = true)
//	int findAllByAssignedCountVisited(@Param("assignedTo") Long assignedTo,
//			@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select bq.beneficiary_id as beneficiaryId, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,"
			+ "g.name as genderName, b.pre_art_number as preArtNumber, b.art_number as artNumber, b.is_active as isActive, ms.name as statusName, um.firstname as userFirstName, um.lastname as userLastName "
			+ "from soch.art_beneficiary_queue bq, soch.art_beneficiary ab, soch.beneficiary b, soch.master_gender g, soch.master_art_beneficiary_status ms, soch.user_master um "
			+ "where bq.beneficiary_id= ab.beneficiary_id and b.id=bq.beneficiary_id and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id and um.id = bq.assigned_to "
			+ "and bq.assigned_to=:assignedTo and bq.facility_id=:facilityId and bq.is_visited=false and bq.visit_date=:visitDate "
			+ "and bq.is_active=true and bq.is_delete=false order by bq.beneficiary_id DESC", nativeQuery = true)
	Page<ArtBeneficiaryQueueProjection> findAllByAssignedToByPagination(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate, Pageable pageable);

	@Query(value = "select distinct bq.beneficiary_id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,"
			+ "g.name as genderName, b.pre_art_number as preArtNumber, b.art_number as artNumber, b.is_active as isActive, ms.name as statusName, um.firstname as userFirstName, um.lastname as userLastName, bq.assigned_to as assignedTo "
			+ "from soch.art_beneficiary_queue bq, soch.art_beneficiary ab, soch.beneficiary b, soch.master_gender g, soch.master_art_beneficiary_status ms, soch.user_master um "
			+ "where bq.beneficiary_id= ab.beneficiary_id and b.id=bq.beneficiary_id and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id and um.id = bq.assigned_to "
			+ "and bq.assigned_to=:assignedTo and bq.facility_id=:facilityId and bq.is_visited = false and bq.visit_date=:visitDate "
			+ "and bq.is_active=true and bq.is_delete=false order by bq.beneficiary_id DESC", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> findAllByAssignedTo(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select distinct bq.beneficiary_id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,"
			+ "g.name as genderName, b.pre_art_number as preArtNumber, b.art_number as artNumber, b.is_active as isActive, ms.name as statusName, um.firstname as userFirstName, um.lastname as userLastName, bq.assigned_to as assignedTo "
			+ "from soch.art_beneficiary_queue bq, soch.art_beneficiary ab, soch.beneficiary b, soch.master_gender g, soch.master_art_beneficiary_status ms, soch.user_master um "
			+ "where bq.beneficiary_id= ab.beneficiary_id and b.id=bq.beneficiary_id and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id and um.id = bq.assigned_to "
			+ "and bq.assigned_to=:assignedTo and bq.facility_id=:facilityId and bq.is_visited=true and bq.visit_date=:visitDate", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> findAllByAssignedToVisited(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate);

	// carecordinator visited list

	@Query(value = "select distinct bq.beneficiary_id as beneficiaryId,b.uid as uid, b.first_name as firstName, b.middle_name as middleName, b.last_name as lastName,"
			+ "g.name as genderName, b.pre_art_number as preArtNumber, b.art_number as artNumber, b.is_active as isActive, ms.name as statusName "
			+ "from soch.art_beneficiary_queue bq, soch.art_beneficiary ab, soch.beneficiary b, soch.master_gender g, soch.master_art_beneficiary_status ms, soch.user_master um "
			+ "where bq.beneficiary_id= ab.beneficiary_id and b.id=bq.beneficiary_id and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id "
			+ "and bq.assigned_to=:assignedTo and bq.facility_id=:facilityId and bq.is_visited=true "
			+ "and bq.visit_date between :fromVisitedDate and :toVisitedDate", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> findAllByVisitedListQueue(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("fromVisitedDate") LocalDate fromVisitedDate,
			@Param("toVisitedDate") LocalDate toVisitedDate);

	@Query(value = "select bq.beneficiary_id as beneficiaryId, bq.assigned_to as assignedTo from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.beneficiary_id =:beneficiaryId order by bq.id desc limit 1", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> findAllByAssignedToLatest(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	// beneficiaryId IN

	@Query(value = "select bq.beneficiary_id as beneficiaryId, bq.assigned_to as assignedTo from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.beneficiary_id IN :beneficiaryId order by bq.id desc ", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> findAllByAssignedToLatestArray(@Param("beneficiaryId") List<Long> beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	ArtBeneficiaryQueue findByBeneficiaryIdAndIsVisitedAndIsDelete(Long beneficiaryId, boolean b, boolean c);

	@Query(value = "select count(distinct beneficiary_id) from soch.art_beneficiary_queue bq where "
			+ "bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to IN :assignedTo and is_active=true and is_delete=false", nativeQuery = true)
	Long getQueueCount(@Param("assignedTo") List<Long> assignedTo, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select count(distinct beneficiary_id) from soch.art_beneficiary_queue bq where "
			+ "bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to IN :assignedTo", nativeQuery = true)
	Long getVisitedQueueCount(@Param("assignedTo") List<Long> assignedTo, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	// tilecount for single assigne
	@Query(value = "select count(distinct beneficiary_id) as beneficiaryId from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to=:assignedTo and is_active=true and is_delete=false", nativeQuery = true)
	int getQueueCountByAssignee(@Param("assignedTo") Long assignedTo, @Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select distinct beneficiary_id as beneficiaryId from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to=:assignedTo and is_active=true and is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> getQueueCountByAssigneeCo(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select distinct beneficiary_id as beneficiaryId from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to=:assignedTo and is_active=true and is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> visitedQueueId(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);

	// tilecount for single assigne
	@Query(value = "select count(distinct beneficiary_id) from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to=:assignedTo", nativeQuery = true)
	int getVisitedQueueCountByAssignee(@Param("assignedTo") Long assignedTo, @Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.assigned_to=:assignedTo and "
			+ "bq.facility_id=:facilityId and bq.visit_date=:visitDate and bq.beneficiary_id = :beneficiaryId and is_visited=false order by bq.id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findBeneficiaryAssignedTo(@Param("beneficiaryId") Long beneficiaryId,
			@Param("assignedTo") Long assignedTo, @Param("facilityId") Long facilityId,
			@Param("visitDate") LocalDate visitDate);
	
	@Query(value = "select * from soch.art_beneficiary_queue bq where "
			+ "bq.facility_id=:facilityId and bq.visit_date=:visitDate and bq.beneficiary_id = :beneficiaryId and is_visited=false order by bq.id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findAllBeneficiaryAssignedTo(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.assigned_to=:assignedTo and "
			+ "bq.facility_id=:facilityId and bq.visit_date=:visitDate and bq.beneficiary_id = :beneficiaryId and is_visited=false order by bq.id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findBeneficiaryCareAssignedTo(@Param("beneficiaryId") Long beneficiaryId,
			@Param("assignedTo") Long assignedTo, @Param("facilityId") Long facilityId,
			@Param("visitDate") LocalDate visitDate);

	// select search beneficiary
	@Query(value = "select * from soch.art_beneficiary_queue bq where "
			+ "bq.facility_id=:facilityId and bq.beneficiary_id = :beneficiaryId and bq.assigned_to =:assignedTo and bq.visit_date=:visitDate order by bq.id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findBeneficiarySearch(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("assignedTo") Long assignedTo,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select bq.assigned_to as assignedTo from soch.art_beneficiary_queue bq where bq.facility_id=:facilityId and bq.visit_date=:visitDate and bq.beneficiary_id IN :beneficiaryId and is_visited=false", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> changedAssignedTo(@Param("beneficiaryId") List<Long> beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select * from soch.art_beneficiary_queue bq where "
			+ "bq.facility_id=:facilityId and bq.visit_date=:visitDate and bq.beneficiary_id = :beneficiaryId and is_visited=false", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findBeneficiaryInQueue(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.visit_register_id = :beneficiaryVisitRegisterId"
			+ " and bq.is_visited = true", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findByVisitRegisterId(
			@Param("beneficiaryVisitRegisterId") Long beneficiaryVisitRegisterId);

	/**
	 * @param beneficiaryid
	 * @param facilityId
	 * @return
	 */
//	@Query(nativeQuery = true,value = "select * from soch.art_beneficiary_queue where beneficiary_id=:beneficiaryId and facility_id=:facilityId and is_visited=false and visit_date= Current_Date")

	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_queue bq where bq.beneficiary_id=:beneficiaryId "
			+ " and bq.facility_id=:facilityId and bq.is_visited=false and bq.visit_date = Current_Date order by bq.id desc limit 1 ")
	ArtBeneficiaryQueue findByBeneficiaryIdAndCurrentDateAndIsvisitedAndFacilityId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.assigned_to=:assignedTo AND "
			+ "bq.facility_id=:facilityId AND bq.visit_date=:visitDate AND bq.beneficiary_id = :beneficiaryId and bq.is_visited=:b order by bq.created_time DESC LIMIT 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findLatestByBeneficiaryIdAndAssignedTo(@Param("beneficiaryId") Long beneficiaryId,
			@Param("assignedTo") Long assignedTo, @Param("facilityId") Long facilityId,
			@Param("visitDate") LocalDate visitDate, @Param("b") Boolean b);

	@Query(value = "select * from soch.art_beneficiary_queue bq where bq.beneficiary_id = :beneficiaryId and bq.facility_id=:facilityId order by bq.visit_register_id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryQueue> findByBeneficiaryIdandFacilityId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

	// queue for nodel officer
	@Query(value = "select distinct b.id as beneficiaryId,b.uid as uid, bq.assigned_to as assigendTo from soch.art_beneficiary_queue bq, soch.beneficiary b "
			+ "where b.id = bq.beneficiary_id and bq.facility_id=:facilityId "
			+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to=:assignedTo "
			+ "and bq.is_active=true and bq.is_delete=false order by b.id, b.uid", nativeQuery = true)
	List<ArtBeneficiaryQueueProjection> getQueueListforNodelOfficer(@Param("assignedTo") Long assignedTo,
			@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
			@Param("visitDate") LocalDate visitDate);
	
	// queue for nodel officer
		@Query(value = "select distinct b.id as beneficiaryId,b.uid as uid, bq.assigned_to as assigendTo from soch.art_beneficiary_queue bq, soch.beneficiary b "
				+ "where b.id = bq.beneficiary_id and bq.facility_id=:facilityId "
				+ "and bq.is_visited=:isVisited and bq.visit_date=:visitDate and bq.assigned_to=:assignedTo "
				+ "and bq.is_active=true and bq.is_delete=false and (lower(b.uid) like %:searchString% or lower(b.art_number) like %:searchString% " + 
				" or lower(b.pre_art_number) like %:searchString% or lower(b.first_name) " + 
				" like %:searchString% or lower(b.last_name) like %:searchString% or lower(b.middle_name) like %:searchString% " + 
				" or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchString% " + 
				" or concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchString% or concat(lower(b.first_name), ' '," + 
				" lower(b.last_name)) like %:searchString%) order by b.uid", nativeQuery = true)
		List<ArtBeneficiaryQueueProjection> getQueueListforNodelOfficerSearch(@Param("assignedTo") Long assignedTo,
				@Param("facilityId") Long facilityId, @Param("isVisited") Boolean isVisited,
				@Param("visitDate") LocalDate visitDate,@Param("searchString") String searchString);

	
	
		
}
