package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.SubDistrictReadOnly;

@Repository
public interface SubdistrictReadOnlyRepository extends JpaRepository<SubDistrictReadOnly, Long>  {

	@Query(nativeQuery = true, value = "select * from soch.subdistrict  where district_id=:districtId and is_delete =false and is_active=true order by subdistrict_name asc")
	List<SubDistrictReadOnly> findByDistrictIdAndIsDeleteAndIsActive(@Param("districtId") Long districtId);
}
