package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.RoleAccessMapping;

//repository mapped with entity class RoleAccessMapping
@Repository
public interface RoleAccessMappingRepository extends JpaRepository<RoleAccessMapping, Long> {
	
	@Query(nativeQuery = true, value = "select * from role_access_mapping where role_id = :roleId")
	List<RoleAccessMapping> findByRole(@Param("roleId") Long roleId);

}
