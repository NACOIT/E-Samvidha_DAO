package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssStoreSacsMapping;

@Repository
public interface CmssStoreSacsMappingRepository extends JpaRepository<CmssStoreSacsMapping, Long> {

	@Query(nativeQuery = true, value = "select c.* from soch.cmss_store_sacs_mapping c "
			+ "where c.is_delete = :isDelete order by c.id")
	List<CmssStoreSacsMapping> findByIsDelete(@Param("isDelete") Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select * from soch.cmss_store_sacs_mapping where id = :id")
	Optional<CmssStoreSacsMapping> findById(@Param("id") Long id);
	
	@Query(nativeQuery = true, value = "select * from soch.cmss_store_sacs_mapping where sacs_id = :facilityId")
	Optional<CmssStoreSacsMapping> findByFacilityId(@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select * from soch.cmss_store_sacs_mapping where sacs_id is not null")
	List<CmssStoreSacsMapping> findMappedOfficers(@Param("facilityId") Long facilityId);
	
}
