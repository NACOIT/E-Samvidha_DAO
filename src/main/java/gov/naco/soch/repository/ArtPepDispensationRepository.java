package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtPepDispensation;
import gov.naco.soch.projection.ArtPepProjection;

@Repository
public interface ArtPepDispensationRepository extends JpaRepository<ArtPepDispensation, Long>,CustomRepository {

	@Query(value="SELECT a FROM ArtPepDispensation a LEFT JOIN a.artPep WHERE a.facility.id=:facilityId and a.dispenseDate=:date ")
	List<ArtPepDispensation> findAllByFacility_IdAndDispenseDate(@Param("facilityId")Long facilityId,@Param("date") LocalDate date);

	@Query(nativeQuery=true, value= " select ap.id as pepId,ap.exposed_staff_name as pepName,ap.pep_number as pepNumber,ap.mobile_number as contactNumber," + 
			" mg.name as genderName,ap.date_of_birth as dob,ap.is_stop as isStop,ap.registration_date as registrationDate,cast(apd.dispense_date as date) as dispenseDate, " + 
			" fc.name as pepFacilityName,apd.id as pepDispenseId" + 
			" from soch.art_pep_dispensation as apd " + 
			" left join soch.art_pep as ap on ap.id=apd.pep_id " + 
			" left join soch.master_gender as mg on mg.id=ap.gender " + 
			" left join soch.facility as fc on fc.id = ap.exposed_staff_facility_id " + 
			" where apd.facility_id =:facilityId and apd.dispense_date BETWEEN :fromDate AND :toDate " + 
			" and ap.is_active = true and ap.is_delete = false and apd.is_active = true and apd.is_delete = false order by apd.id desc ")
	Page<ArtPepProjection> findDispensationList(@Param("facilityId") Long facilityId,@Param("fromDate") LocalDate fromDate,
			@Param("toDate") LocalDate toDate,  Pageable pageable);

	
	@Query(nativeQuery=true, value= " select ap.id as pepId,ap.exposed_staff_name as pepName,ap.pep_number as pepNumber,ap.mobile_number as contactNumber," + 
			" mg.name as genderName,ap.date_of_birth as dob,ap.is_stop as isStop,ap.registration_date as registrationDate,cast(apd.dispense_date as date) as dispenseDate, " + 
			" fc.name as pepFacilityName,apd.id as pepDispenseId" + 
			" from soch.art_pep_dispensation as apd " + 
			" left join soch.art_pep as ap on ap.id=apd.pep_id " + 
			" left join soch.master_gender as mg on mg.id=ap.gender " + 
			" left join soch.facility as fc on fc.id = ap.exposed_staff_facility_id " + 
			" where apd.facility_id =:facilityId and apd.dispense_date BETWEEN :fromDate AND :toDate " + 
			" and ap.is_active = true and ap.is_delete = false and apd.is_active = true and apd.is_delete = false " +
			" and ( lower(ap.pep_number) like %:searchText% or lower(ap.exposed_staff_name) like %:searchText%  or " + 
			" lower(ap.mobile_number) like %:searchText% )" + 
			" order by apd.id desc")
	Page<ArtPepProjection> findDispensationListbySearchText(@Param("facilityId") Long facilityId,@Param("searchText") String searchText,@Param("fromDate") LocalDate fromDate,
			@Param("toDate") LocalDate toDate,  Pageable pageable);

	@Query(nativeQuery=true, value= " select count(apd.id) from soch.art_pep_dispensation as apd " + 
			" left join soch.art_pep as ap on ap.id=apd.pep_id " + 
			" left join soch.facility as fc on fc.id = ap.exposed_staff_facility_id " + 
			" where apd.facility_id =:facilityId and apd.dispense_date BETWEEN :fromDate AND :toDate " + 
			" and ap.is_active = true and ap.is_delete = false and apd.is_active = true and apd.is_delete = false" +
			" and ( lower(ap.pep_number) like %:searchText% or lower(ap.exposed_staff_name) like %:searchText%  or " + 
			" lower(ap.mobile_number) like %:searchText% )" ) 
	Long getActualCountofPepDispensationListBySearchText(@Param("facilityId") Long facilityId,@Param("searchText") String searchText,@Param("fromDate") LocalDate fromDate,
			@Param("toDate") LocalDate toDate);

	@Query(nativeQuery=true, value= " select count(apd.id) from soch.art_pep_dispensation as apd " + 
			" left join soch.art_pep as ap on ap.id=apd.pep_id " + 
			" left join soch.facility as fc on fc.id = ap.exposed_staff_facility_id " + 
			" where apd.facility_id =:facilityId and apd.dispense_date BETWEEN :fromDate AND :toDate" + 
			" and ap.is_active = true and ap.is_delete = false and apd.is_active = true and apd.is_delete = false ")
	Long getActualCountofPepDispensationList(@Param("facilityId") Long facilityId,@Param("fromDate") LocalDate fromDate,@Param("toDate") LocalDate toDate);


}
