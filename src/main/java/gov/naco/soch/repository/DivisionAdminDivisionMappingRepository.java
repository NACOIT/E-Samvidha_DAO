package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.DivisionAdminDivisionMapping;

public interface DivisionAdminDivisionMappingRepository extends JpaRepository<DivisionAdminDivisionMapping, Long> {

	@Query(nativeQuery = true, value = "select * from soch.division_admin_division_mapping  where division_id = :divisionId and user_id=:userId and is_delete =false")
	Optional<DivisionAdminDivisionMapping> findExistingDivisionAdminDivisionMapping(
			@Param("divisionId") Long divisionId, @Param("userId") Long userId);

}
