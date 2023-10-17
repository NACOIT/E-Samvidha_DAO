package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIHotspot;

@Repository
public interface TIHotspotRepository extends JpaRepository<TIHotspot, Long>, JpaSpecificationExecutor<TIHotspot> {

	List<TIHotspot> findAllByFacilityId(Long facilityId);

	boolean existsByHotspotCodeAndIsDeleteAndFacilityId(String hotspotCode, boolean b, Long facilityId);

	boolean existsByHotspotNameAndIsDeleteAndFacilityId(String hotspotName, boolean b, Long facilityId);

	boolean existsByHotspotCodeAndIsDeleteAndFacilityIdAndIdNot(String hotspotCode, boolean b, Long facilityId,
			Long hotspotId);

	boolean existsByHotspotNameAndIsDeleteAndFacilityIdAndIdNot(String hotspotName, boolean b, Long facilityId,
			Long hotspotId);
}
