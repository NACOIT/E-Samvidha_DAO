package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.AccessMaster;
import gov.naco.soch.entity.RoleAccessMapping;

//repository mapped with entity class RoleAccessMapping
@Repository
public interface AccessMasterRepository extends JpaRepository<AccessMaster, Long> {

	@Query(value = "SELECT ra.* FROM soch.access_master ra left join soch.role_access_mapping rm on (ra.code = rm.access_code and rm.role_id = ? ) where rm.access_code is NULL", nativeQuery = true)
	List<AccessMaster> fetchNotAddedAccessList(Long roleId);

}
