package gov.naco.soch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtFollowupList;
import gov.naco.soch.projection.ArtFollowupListProjection;


@Repository
public interface ArtFollowupListRepository extends JpaRepository<ArtFollowupList, Long> {

	@Query(nativeQuery = true, value = " select afl.id as id, afl.year_generated as yearGenerated, afl.month_generated as monthGenerated, " + 
			" bf.uid as uid, concat(bf.first_name,' ',bf.middle_name,' ',bf.last_name) as benficiaryName, " + 
			" bf.pre_art_number as preArtNumber, bf.art_number as artNumber,bf.mobile_number as mobileNumber, " + 
			" bf.date_of_birth as beneficiaryDob, bf.id as beneficiaryId, afl.facility_id as facilityId, " + 
			" mabs.id as artBeneficiaryStatusId, mabs.name as artBeneficiaryStatusName, " + 
			" mg.id as genderId , mg.name as genderName " + 
			" from soch.art_followup_list as afl " + 
			" join soch.beneficiary as bf on bf.id = afl.beneficiary_id " + 
			" left join soch.master_art_beneficiary_status as mabs on mabs.id = afl.art_beneficiary_status_id_captured " + 
			" left join soch.master_gender as mg on mg.id =bf.gender_id  " + 
			" where afl.year_generated =:year and afl.month_generated =:month  and afl.facility_id=:facilityId and  " + 
			" afl.is_active = true and afl.is_delete = false ")
	List<ArtFollowupListProjection> findByYearAndDateAndFaciltyId(@Param("year") Integer year, @Param("month") Integer month,@Param("facilityId") Long facilityId);
	//@Query(nativeQuery = true, value = "select * from soch.art_followup_list where year_generated =:year and month_generated =:month  and facility_id=:facilityId")
	//List<ArtFollowupList> findByYearAndDateAndFaciltyId(@Param("year") Integer year, @Param("month") Integer month,@Param("facilityId") Long facilityId);
	//List<ArtFollowupList> findByYearAndDate(@Param("year") Integer year, @Param("month") Integer month);

	@Query(nativeQuery=true, value = "select COUNT(*) from soch.art_followup_list where  beneficiary_id=:beneficiaryId and month_generated =:month and year_generated =:year ")
	int FindCountByBeneficiaryIdAndCurrentMonthAndCurrentYear(@Param("beneficiaryId") Long beneficiaryId, @Param("month") Integer month,
			@Param("year") Integer year);

	@Query(nativeQuery=true, value = " select beneficiary_id from soch.art_followup_list where is_active = true and is_delete = false " + 
			" and year_generated =:year and month_generated =:month ")
	Set<Long> getExistingBeneficiaryIdsForCurrentMonthYear(@Param("year") Integer year, @Param("month") Integer month);

}
