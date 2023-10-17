package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TownReadOnly;

@Repository
public interface TownReadOnlyRepository extends JpaRepository<TownReadOnly, Long> {

	@Query(nativeQuery = true, value = "select * from soch.town  where subdistrict_id=:subdistrictId and is_delete =false and is_active=true order by town_name asc")
	List<TownReadOnly> findBySubDistrictIdAndIsDeleteAndIsActive(@Param("subdistrictId") Long subdistrictId);
}
