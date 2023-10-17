package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.District;
import gov.naco.soch.entity.Subdistrict;

@Repository
public interface SubdistrictRepository extends JpaRepository<Subdistrict, Long> {

	@Query(nativeQuery=true, value="select s.* from soch.subdistrict as s where s.district_id=:districtId order by s.subdistrict_name asc")
	List<Subdistrict> findAllByDistrictId(@Param("districtId") Long districtId);
	
	@Query(nativeQuery=true, value="select * from soch.subdistrict")
	List<Subdistrict> findAll();
	
	@Query(nativeQuery = true, value = "select * from soch.subdistrict  where district_id=:districtId and is_delete =false and is_active=true order by subdistrict_name asc")
	List<Subdistrict> findByDistrictIdAndIsDeleteAndIsActive(@Param("districtId") Long districtId);

}
