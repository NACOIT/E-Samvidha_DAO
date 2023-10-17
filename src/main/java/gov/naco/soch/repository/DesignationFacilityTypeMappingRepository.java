package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.DesignationFacilityTypeMapping;

@Repository
public interface DesignationFacilityTypeMappingRepository extends JpaRepository<DesignationFacilityTypeMapping, Long> {

	@Query(nativeQuery = true, value = "select d.id,d.title from soch.designation d join"
			+ " soch.designation_facility_type_mapping dftm on dftm.designation_id=d.id "
			+ " where dftm.facility_type_id=?1 and d.is_active=true and d.is_delete=false order by d.title asc")
	List<Object[]> findDesignationByFacilityType(Long id);

}
