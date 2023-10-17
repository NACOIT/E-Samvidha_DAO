package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.SatelliteOstParentOstMapping;
import gov.naco.soch.projection.FacilityProjection;

@Repository
public interface SatelliteOstParentOstMappingRepository extends JpaRepository<SatelliteOstParentOstMapping, Long> {

	void deleteBySatelliteOstId(Long id);

	@Query("SELECT sop FROM SatelliteOstParentOstMapping sop JOIN FETCH sop.satelliteOst so JOIN FETCH sop.parentOst po WHERE so.id=:SatelliteOstId AND sop.isDelete=false")
	List<SatelliteOstParentOstMapping> findAllBySatelliteOstId(@Param("SatelliteOstId") Long SatelliteOstId);

	@Query(nativeQuery = true, value = "select fspm.parent_ost_id ,f.name as name  from soch.facility_satelliteost_parentost_mapping as fspm " + 
			"left join soch.facility as f on f.id = fspm.parent_ost_id " + 
			"where fspm.satellite_ost_id = :satelliteId and fspm.mapping_status_flag = false")
	List<FacilityProjection> findDeactivateParentOst(@Param("satelliteId")Long satelliteId);

	@Query(nativeQuery = true, value = "SELECT * FROM soch.facility_satelliteost_parentost_mapping fsp " + 
			"left join soch.facility f on f.id = fsp.parent_ost_id " + 
			"WHERE fsp.satellite_ost_id=:sateliteOstId AND fsp.is_delete=false and fsp.mapping_status_flag = true")
	List<SatelliteOstParentOstMapping> findAllParentOstaBySataliteOstId(@Param("sateliteOstId")Long sateliteOstId);

}
