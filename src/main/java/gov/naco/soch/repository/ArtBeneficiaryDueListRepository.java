/**
 * 
 */
package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.projection.ArtBeneficiaryDueListProjection;
import gov.naco.soch.projection.UserRoleMappingQueueProjection;

/**
 * @author Shijithra
 *
 */
@Repository
public interface ArtBeneficiaryDueListRepository extends JpaRepository<ArtBeneficiaryDueList, Long>, CustomRepository {

	// Query for Beneficiary list by facility old
	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId "
			+ "and dq.is_visited=:isVisited and dq.expected_visit_date=:VisitedDate and dq.is_active=true and dq.is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryDueList> findAllByFacilityIdOld(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("VisitedDate") LocalDate VisitedDate);

	// Query for Beneficiary list by facility changed
	@Query(value = "select dq.beneficiary_id as beneficiaryId, b.uid as uid, b.first_name as firstName, "
			+ "b.middle_name as middleName, b.last_name as lastName,\r\n"
			+ "g.name as genderName, b.pre_art_number as preArtNumber,b.art_number as artNumber, \r\n"
			+ "b.is_active as isActive, ms.name as statusName from soch.art_beneficiary_due_list dq , soch.art_beneficiary ab, soch.beneficiary b, \r\n"
			+ "soch.master_gender g, soch.master_art_beneficiary_status ms where dq.beneficiary_id= ab.beneficiary_id and b.id=dq.beneficiary_id \r\n"
			+ "and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id "
			+ "and dq.facility_id=:facilityId and dq.is_visited=false "
			+ "and dq.expected_visit_date=:VisitedDate and dq.is_active=true and dq.is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> findAllByFacilityId(@Param("facilityId") Long facilityId,
			@Param("VisitedDate") LocalDate VisitedDate);

	// Query for Beneficiary list by facility old
	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId "
			+ "and dq.is_visited=:isVisited and dq.visited_date=:VisitedDate", nativeQuery = true)
	List<ArtBeneficiaryDueList> findAllByFacilityIdVisitedOld(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("VisitedDate") LocalDate VisitedDate);

	@Query(value = "select dq.beneficiary_id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, \r\n"
			+ "b.last_name as lastName, g.name as genderName, b.pre_art_number as preArtNumber,\r\n"
			+ "b.art_number as artNumber, b.is_active as isActive, ms.name as statusName \r\n"
			+ "from soch.art_beneficiary_due_list dq , soch.art_beneficiary ab, soch.beneficiary b, \r\n"
			+ "soch.master_gender g, soch.master_art_beneficiary_status ms \r\n"
			+ "where dq.beneficiary_id= ab.beneficiary_id and b.id=dq.beneficiary_id \r\n"
			+ "and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id \r\n"
			+ "and dq.facility_id=:facilityId and dq.is_visited=:isVisited and dq.visited_date=:VisitedDate", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> findAllByFacilityIdVisited(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("VisitedDate") LocalDate VisitedDate);

	// Query for Beneficiary todays list
	@Query(value = "select dq.beneficiary_id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName, "
			+ "b.last_name as lastName, g.name as genderName, b.pre_art_number as preArtNumber,b.art_number as artNumber, "
			+ "b.is_active as isActive, ms.name as statusName from soch.art_beneficiary_due_list dq , soch.art_beneficiary ab, soch.beneficiary b, "
			+ "soch.master_gender g, soch.master_art_beneficiary_status ms where dq.beneficiary_id= ab.beneficiary_id and b.id=dq.beneficiary_id "
			+ "and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id "
			+ "and dq.facility_id=:facilityId and dq.is_visited=false "
			+ "and dq.visited_date between :fromVisitedDate and :toVisitedDate and dq.is_active=true and dq.is_delete=false ", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> findAllByTodaysList(@Param("facilityId") Long facilityId,
			@Param("fromVisitedDate") LocalDate fromVisitedDate, @Param("toVisitedDate") LocalDate toVisitedDate);

	// Query for Beneficiary todays list
	@Query(value = "select dq.beneficiary_id as beneficiaryId, b.uid as uid, b.first_name as firstName, b.middle_name as middleName,"
			+ "b.last_name as lastName, g.name as genderName, b.pre_art_number as preArtNumber,b.art_number as artNumber, "
			+ "b.is_active as isActive, ms.name as statusName from soch.art_beneficiary_due_list dq , soch.art_beneficiary ab, soch.beneficiary b, "
			+ "soch.master_gender g, soch.master_art_beneficiary_status ms where dq.beneficiary_id= ab.beneficiary_id and b.id=dq.beneficiary_id "
			+ "and b.id=ab.beneficiary_id and b.gender_id=g.id and ms.id = ab.art_beneficiary_status_id "
			+ "and dq.facility_id=:facilityId and dq.is_visited=true "
			+ "and dq.visited_date between :fromVisitedDate and :toVisitedDate and dq.is_active=true and dq.is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> findAllByVisitedList(@Param("facilityId") Long facilityId,
			@Param("fromVisitedDate") LocalDate fromVisitedDate, @Param("toVisitedDate") LocalDate toVisitedDate);

	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId "
			+ "and dq.visited_date between :fromVisitedDate and :toVisitedDate and dq.is_visited=:isVisited", nativeQuery = true)
	List<ArtBeneficiaryDueList> findAllByBeneficiaryDueList(@Param("facilityId") Long facilityId,
			@Param("fromVisitedDate") LocalDate fromVisitedDate, @Param("toVisitedDate") LocalDate toVisitedDate,
			@Param("isVisited") Boolean isVisited);

	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.beneficiary_id=:beneficiaryId and dq.facility_id=:facilityId and dq.expected_visit_date=:expectedVisitDate and dq.is_delete=:isDelete order by dq.id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryDueList> findByBeneficiaryNextVisitDateAndIsDelete(
			@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId,
			@Param("expectedVisitDate") LocalDate expectedVisitDate, @Param("isDelete") boolean isDelete);

	@Query(value = "select beneficiary_id as beneficiaryId from soch.art_beneficiary_due_list dq where "
			+ "dq.facility_id=:facilityId and dq.is_visited=:isVisited and dq.expected_visit_date=:visitDate and dq.is_active=true and dq.is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> getVisitDueCountS(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select beneficiary_id as beneficiaryId from soch.art_beneficiary_due_list dq where "
			+ "dq.facility_id=:facilityId and dq.is_visited=:isVisited and dq.expected_visit_date=:visitDate and dq.is_active=true and dq.is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> getVisitDueCount(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select beneficiary_id as beneficiaryId from soch.art_beneficiary_due_list dq where "
			+ "dq.facility_id=:facilityId and dq.is_visited=:isVisited and dq.visited_date=:visitDate", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> getVisitedDueCount(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("visitDate") LocalDate visitDate);

	/*
	 * @Query(nativeQuery = true, value =
	 * "select ab.visited_date as visitDate,ab.expected_visit_date as expectedVisitDate from soch.art_beneficiary_due_list ab join (\r\n"
	 * + "select max(id) as id from soch.art_beneficiary_due_list\r\n" +
	 * "	where beneficiary_id=:beneficiaryId)res on (ab.id=res.id) where ab.id=res.id"
	 * ) ArtBeneficiaryDueListProjection
	 * findLatestbyBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
	 */

	@Query(nativeQuery = true, value = "select ab.visited_date as visitDate,ab.expected_visit_date as expectedVisitDate from soch.art_beneficiary_due_list ab "
			+ "where ab.beneficiary_id=:beneficiaryId order by ab.visit_register_id desc limit 1")
	ArtBeneficiaryDueListProjection findLatestbyBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(value = "select * from soch.art_beneficiary_due_list dq where "
			+ " beneficiary_id=:beneficiaryId and expected_visit_date=:localDate and facility_id=:facilityId order by dq.id desc limit 1", nativeQuery = true)
	ArtBeneficiaryDueList findSearchBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("localDate") LocalDate localDate);

	@Query(value = "select * from soch.art_beneficiary_due_list dq where "
			+ "dq.visit_register_id=:visitRegisterId and dq.visited_date=:localDate order by dq.id desc limit 1", nativeQuery = true)
	ArtBeneficiaryDueList findByBeneficiaryVisitRegister_Id(@Param("visitRegisterId") Long visitRegisterId,
			@Param("localDate") LocalDate localDate);

	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_due_list where beneficiary_id=:beneficiaryId and expected_visit_date =:expectedVisitDate and facility_id=:facilityId and is_visited =false")
	ArtBeneficiaryDueList findByBeneficiaryIdAndExpectedVisitDateAndIsvisitedAndFacilityId(
			@Param("beneficiaryId") Long beneficiaryId, @Param("expectedVisitDate") LocalDate expectedVisitDate,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_due_list where beneficiary_id=:beneficiaryId "
			+ " and expected_visit_date =:expectedVisitDate and facility_id=:facilityId and is_visited =false "
			+ " and entry_user=:userId")
	ArtBeneficiaryDueList findByBeneficiaryIdAssignedToAndNextAppoinmentDate(@Param("beneficiaryId") Long beneficiaryId,
			@Param("expectedVisitDate") LocalDate nextAppointmentDate, @Param("userId") Long userId,
			@Param("facilityId") Long facilityId);

	@Query(value = "select * from soch.art_beneficiary_due_list dq where dq.beneficiary_id = :beneficiaryId and dq.facility_id=:facilityId order by dq.visit_register_id desc limit 1", nativeQuery = true)
	Optional<ArtBeneficiaryDueList> findByBeneficiaryIdandFacilityId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_due_list where beneficiary_id = :beneficiaryId and facility_id =:facilityId and "
			+ " is_visited = false and is_active=true and is_delete= false order by id desc limit 1;")
	ArtBeneficiaryDueList findByBeneficiaryIdAndFacilityIdAndIsVisited(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select * from soch.art_beneficiary_due_list ad where ad.beneficiary_id=:beneficiaryId "
			+ "and ad.facility_id=:facilityId and date(ad.expected_visit_date)>=date(Now()) and ad.is_visited =false and ad.is_delete=false  and ad.is_active=true "
			+ " and ad.entry_user=:userId order by ad.id desc limit 1")
	ArtBeneficiaryDueList findByBeneficiaryIdAndEntryUser(@Param("beneficiaryId") Long beneficiaryId,
			@Param("userId") Long userId, @Param("facilityId") Long facilityId);
	

	@Query(value = "select COUNT(dl) from soch.art_beneficiary_due_list dl "
			+ "where dl.facility_id=:facilityId and dl.is_visited=false "
			+ "and dl.expected_visit_date= :date and dl.is_active=true and dl.is_delete=false ", nativeQuery = true)
	Long findBeneficiaryDueCount(@Param("facilityId") Long facilityId,@Param("date") LocalDate date);


	@Query(value = "select beneficiary_id as beneficiaryId, b.uid as uid from soch.art_beneficiary_due_list dq, soch.beneficiary b where b.id = dq.beneficiary_id and "
			+ "dq.facility_id=:facilityId and dq.is_visited=:isVisited and dq.expected_visit_date=:visitDate and dq.is_active=true and dq.is_delete=false", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> getNodelOfficerDueList(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("visitDate") LocalDate visitDate);
	
	@Query(value = "select beneficiary_id as beneficiaryId, b.uid as uid from soch.art_beneficiary_due_list dq, soch.beneficiary b where b.id = dq.beneficiary_id and "
			+ "dq.facility_id=:facilityId and dq.is_visited=:isVisited and dq.expected_visit_date=:visitDate "
			+ "and dq.is_active=true and dq.is_delete=false and (lower(b.uid) like %:searchString% or lower(b.art_number) like %:searchString%" + 
			" or lower(b.pre_art_number) like %:searchString% or lower(b.first_name) " + 
			" like %:searchString% or lower(b.last_name) like %:searchString% or lower(b.middle_name) like %:searchString% " + 
			" or concat(lower(b.first_name), ' ',lower(b.middle_name), ' ',lower(b.last_name)) like %:searchString% " + 
			" or concat(lower(b.first_name), ' ',lower(b.middle_name)) like %:searchString% or concat(lower(b.first_name), ' '," + 
			" lower(b.last_name)) like %:searchString%) order by b.uid ", nativeQuery = true)
	List<ArtBeneficiaryDueListProjection> getNodelOfficerDueListSearch(@Param("facilityId") Long facilityId,
			@Param("isVisited") Boolean isVisited, @Param("visitDate") LocalDate visitDate,@Param("searchString") String searchString);

}
