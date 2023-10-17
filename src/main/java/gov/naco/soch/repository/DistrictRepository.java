package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.District;
import gov.naco.soch.projection.FacilityProjection;

public interface DistrictRepository extends JpaRepository<District, Long> {

	@Query(nativeQuery = true, value = "select d.id as id,d.name as name,s.id as stateId from soch.district d\r\n"
			+ "join soch.state s on(d.state_id=s.id) where d.state_id=:stateId and d.is_delete=false")
	List<FacilityProjection> findByState(@Param("stateId") Long stateId);

	@Query(nativeQuery = true, value = "select d.* from soch.district d where d.state_id = :stateId")
	List<District> findByStateId(@Param("stateId") Long stateId);

	@Query(nativeQuery = true, value = "select * from soch.district  where state_id = :stateId and is_delete =false and is_active=true order by name asc")
	List<District> findByStateIdAndIsDeleteAndIsActive(@Param("stateId") Long stateId);
}
