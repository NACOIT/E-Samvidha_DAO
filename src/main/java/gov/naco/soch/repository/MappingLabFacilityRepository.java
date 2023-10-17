package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MappingLabFacility;

public interface MappingLabFacilityRepository extends JpaRepository<MappingLabFacility, Long> {

	@Query(nativeQuery = true, value = "select distinct on (f.id,f.name) f.id as facilityid,f.name as facilityname,f.code as code ,a.id as addressid,"
			+ "s.id as stateid,s.name as statename,d.id as distictid,d.name as districtname \r\n"
			+ "from soch.facility f \r\n" + "join soch.mapping_lab_facility mlf on f.id = mlf.facility_id \r\n"
			+ "left join soch.address a on f.address_id =a.id and a.is_active = true and a.is_delete = false \r\n"
			+ "left join soch.state s on a.state_id = s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.district d on a.district_id =d.id and d.is_active =true and d.is_delete =false \r\n"
			+ "where mlf.is_delete = false and\r\n"
			+ "f.is_active = true and f.is_delete =false and mlf.lab_id = :labId \r\n"
			+ "group by f.id,a.id,s.id,d.id order by f.name asc")
	List<Object[]> findByLabId(@Param("labId") Long labId);

	void deleteByLabId(Long labId);

	@Query(nativeQuery = true, value = "select count(mlf.id) from soch.mapping_lab_facility mlf where mlf.lab_id=:labId")
	int findCountByLabId(@Param("labId") Long labId);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.mapping_lab_facility set is_delete=true, is_active=false where lab_id=:labId")
	void updateIsDeleteByLabId(@Param("labId") Long labId);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.mapping_lab_facility set is_delete=false, is_active=true where lab_id=:labId and facility_id IN :facilityIds ")
	void updateIsDeleteByLabIdAndFacilityIds(@Param("labId") Long labId, @Param("facilityIds") List<Long> facilityIds);

}
