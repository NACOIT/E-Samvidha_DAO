package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TypologyFacilityMapping;

@Repository
public interface TypologyFacilityMappingRepository extends JpaRepository<TypologyFacilityMapping, Long> {

	List<TypologyFacilityMapping> findAllByFacilityId(Long id);

	void deleteByFacilityId(Long id);

	@Query(nativeQuery = true, value = "select count(typology_facility_mapping_id) from soch.typology_facility_mapping where is_delete = false and facility_id = ?1")
	int isExistByFacilityId(Long id);

	boolean existsByFacility_IdAndTypologyMaster_TypologyId(Long referredToFacility, long typology);
	
	@Query(nativeQuery = true, value ="select * from soch.typology_facility_mapping where facility_id = :facilityId")
	List<TypologyFacilityMapping> findAllByFacilityId(@Param("facilityId") Integer facilityId);

}
