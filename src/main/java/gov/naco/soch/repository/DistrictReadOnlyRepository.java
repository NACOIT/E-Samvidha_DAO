package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.DistrictReadOnly;

@Repository
public interface DistrictReadOnlyRepository extends JpaRepository<DistrictReadOnly, Long> {

	@Query(nativeQuery = true, value = "select * from soch.district  where state_id = :stateId and is_delete =false and is_active=true order by name asc")
	List<DistrictReadOnly> findByStateIdAndIsDeleteAndIsActive(@Param("stateId") Long stateId);
}
