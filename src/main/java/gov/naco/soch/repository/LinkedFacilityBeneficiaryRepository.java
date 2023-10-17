package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.LinkedFacilityBeneficiary;

@Repository
public interface LinkedFacilityBeneficiaryRepository
		extends JpaRepository<LinkedFacilityBeneficiary, Long>, JpaSpecificationExecutor<LinkedFacilityBeneficiary> , CustomRepository {

	
	@Query(value = "select fl.*, concat(b.first_name , ' ', b.middle_name ,' ', b.last_name) as fullname , b.art_number as artNumber ,b.pre_art_number as preArtNumber, f.name as lacName from soch.facility_linked_facility_beneficiary as fl " +
            "join soch.beneficiary as b on b.id=fl.beneficiary_id join soch.facility as f on f.id = fl.linked_facility_id where fl.parent_facility_id=:facilityId and fl.facility_type=:facilityTypeId and fl.is_linked=true ", nativeQuery = true)
    Page<LinkedFacilityBeneficiary> findLacList(@Param("facilityId") Long facilityId, @Param("facilityTypeId") Long facilityTypeId , Pageable pageable);

	
	//List<LinkedFacilityBeneficiary> findLacList(@Param("id")Long id,@Param("facilityTypeId") Long facilityTypeId);
	
	
	  @Query(value ="select * from soch.facility_linked_facility_beneficiary as fb join soch.beneficiary as b on b.id = fb.beneficiary_id " + 
	  		"join soch.facility as fl on fl.id=fb.linked_facility_id where fb.is_active=true and fb.is_delete=false and fb.parent_facility_id =:facilityId and fb.is_linked=true " + 
	  		"and fb.facility_type=:facilityTypeId and ((lower(b.art_benf_search_str) like %:searchValue%) or lower(fl.name) like %:searchValue% )", nativeQuery = true ) 
	  Page<LinkedFacilityBeneficiary> findlacBySearch(@Param("facilityId") Long facilityId,@Param("searchValue") String searchValue,@Param("facilityTypeId") Long facilityTypeId,Pageable pageable);

	
	  @Query(value = "select * from soch.facility_linked_facility_beneficiary fl where fl.linked_facility_id=:facilityId and is_linked=true", nativeQuery = true)
	  Page<LinkedFacilityBeneficiary> findBeneficiaryList(@Param("facilityId") Long facilityId,Pageable pageable);
	 
	  @Query(value ="select * from soch.facility_linked_facility_beneficiary as fb join soch.beneficiary as b on b.id = fb.beneficiary_id "
			  +"join soch.facility as fl on fl.id=fb.linked_facility_id join soch.art_beneficiary as ab on ab.beneficiary_id=b.id "  
			  +"join soch.master_gender as mg on mg.id=b.gender_id join soch.master_art_beneficiary_status as bs on bs.id=ab.art_beneficiary_status_id  "
			  + "where fb.is_active=true and fb.is_delete=false and fb.linked_facility_id =:facilityId and fb.is_linked=true "
			  +"and (lower(b.first_name) like %:searchValue% or lower(b.middle_name) like %:searchValue% or lower(b.last_name) like %:searchValue%  or lower(b.mobile_number) "
			  +"like %:searchValue% or lower(b.pre_art_number) like %:searchValue% or lower(b.art_number) like %:searchValue% or lower(fl.name) like %:searchValue% or lower(b.age) like %:searchValue% or lower(mg.name) like %:searchValue% or lower(bs.name) like %:searchValue% )", nativeQuery = true ) 
	Page<LinkedFacilityBeneficiary> findlacBenListBySearch(@Param("facilityId") Long facilityId,@Param ("searchValue") String searchValue,Pageable pageable);

	  @Query(value = "select * from soch.facility_linked_facility_beneficiary fb where fb.beneficiary_id = :beneficiaryId and fb.linked_facility_id = :lacId" ,nativeQuery = true )
	Optional<LinkedFacilityBeneficiary> findLacByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId,@Param("lacId") Long lacId);

	

	
	
}
