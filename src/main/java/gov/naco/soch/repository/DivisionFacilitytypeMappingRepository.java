package gov.naco.soch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityTypeDivisionMapping;
import gov.naco.soch.projection.FacilityTypeProjection;

@Repository
public interface DivisionFacilitytypeMappingRepository extends JpaRepository<FacilityTypeDivisionMapping, Long> {

	@Query(nativeQuery = true, value = "select ft.id as mapId,ftm.id as id,ftm.facility_type_name as facilityTypeName,ftm.is_active as isActive from soch.facility_type as ftm "
			+ "join soch.division_facilityType_mapping as ft on ft.facility_type_id=ftm.id where ft.division_id=?1")
	List<Object[]> findAllByDivisionId(Long long1);

	// Query to delete values from division facility mapper table
	@Query(nativeQuery = true, value = "delete from soch.facility_type_division_mapping where division_id=?1")
	void deleteFromDivisionFacilityMapp(Integer division_id);

	// to get division details corresponding to a facilityType_id
	@Query(nativeQuery = true, value = "select d.id,d.name from soch.division d join"
			+ " soch.facility_type_division_mapping ftm on ftm.division_id=d.id "
			+ " join soch.facility_type ft on ft.id=ftm.facility_type_id where ft.id=?1 order by d.name asc")
	List<Object[]> findAllByFacilityTypeId(Long id);

	@Query(nativeQuery = true, value = "select facility_type_name from soch.facility_type where id=?1")
	String findFacilityTypeName(Long long1);

	@Query(nativeQuery = true, value = "select facility_type_id from soch.facility_type_division_mapping where division_id=?1")
	Set facilityTypeNameExists(Long id);

	@Query(nativeQuery = true, value = "select * from soch.facility_type_division_mapping fdm "
			+ "where fdm.is_delete = false and division_id = :divisionId")
	List<FacilityTypeDivisionMapping> findFacilityTypeMappingByDivisionId(@Param("divisionId") Long divisionId);

	@Query(nativeQuery = true, value = "select distinct fdm.facility_type_id as facilityTypeId,ft.facility_type_name as facilityTypeName\r\n"
			+ "from soch.facility_type_division_mapping fdm join soch.facility_type ft on (fdm.facility_type_id=ft.id)\r\n "
			+ "where fdm.is_delete = false and fdm.is_active=true and ft.is_delete=false and ft.id!=18 and fdm.division_id IN :divisionIds")
	List<FacilityTypeProjection> findFacilityTypeMappingByDivisionIdList(@Param("divisionIds") List<Long> divisionIds);
}
