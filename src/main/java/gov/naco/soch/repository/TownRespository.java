package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Town;

@Repository
public interface TownRespository extends JpaRepository<Town, Long> {

	@Query(nativeQuery = true, value = "select * from soch.town  where subdistrict_id=:subdistrictId and is_delete =false and is_active=true order by town_name asc")
	List<Town> findBySubDistrictIdAndIsDeleteAndIsActive(@Param("subdistrictId") Long subdistrictId);

	@Query(nativeQuery = true, value = "select * from soch.town where town_id =:townId and is_delete =false and is_active=true" )
	Optional<Town> findByTownId(@Param("townId") Long townId);
}
