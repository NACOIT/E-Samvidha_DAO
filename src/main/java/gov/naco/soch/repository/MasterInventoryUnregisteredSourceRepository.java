package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterInventoryUnregisteredSource;
import gov.naco.soch.projection.UnregisteredSourceProjection;

@Repository
public interface MasterInventoryUnregisteredSourceRepository
		extends JpaRepository<MasterInventoryUnregisteredSource, Long> {

	List<MasterInventoryUnregisteredSource> findByIsDelete(Boolean isDelete);

	@Query(nativeQuery = true, value = "select mus.id as sourceId,mus.source_name as sourceName,a.id as address_id,\r\n"
			+ "a.address_line_one as address,s.id as stateId,s.name as stateName,\r\n"
			+ "d.id as districtId,d.name as districtName,a.pincode as pincode,\r\n"
			+ "sd.subdistrict_id as subdistrictId,sd.subdistrict_name as subdistrictName,\r\n"
			+ "t.town_id as townId,t.town_name as townName\r\n"
			+ "from soch.master_inventory_unregistered_source mus\r\n"
			+ "join soch.address a on(mus.address_id=a.id) and a.id > 0 join soch.state s on(a.state_id=s.id)\r\n"
			+ "join soch.district d on(a.district_id=d.id)\r\n"
			+ "LEFT OUTER JOIN  soch.subdistrict sd on(a.subdistrict_id=sd.subdistrict_id )\r\n"
			+ "LEFT OUTER JOIN  soch.town t on(a.town_id=t.town_id )\r\n"
			+ "where mus.is_delete=:b1 and mus.is_facility=:b2")
	List<UnregisteredSourceProjection> findUnregisteredSourcesOrFacilities(@Param("b1") Boolean b1,
			@Param("b2") Boolean b2);

	@Query(nativeQuery = true, value = "select mus.id as sourceId,mus.source_name as sourceName,a.id as address_id,\r\n"
			+ "a.address_line_one as address,s.id as stateId,s.name as stateName,\r\n"
			+ "d.id as districtId,d.name as districtName,a.pincode as pincode,\r\n"
			+ "sd.subdistrict_id as subdistrictId,sd.subdistrict_name as subdistrictName,\r\n"
			+ "t.town_id as townId,t.town_name as townName\r\n"
			+ "from soch.master_inventory_unregistered_source mus\r\n"
			+ "join soch.address a on(mus.address_id=a.id) and a.id > 0 join soch.state s on(a.state_id=s.id)\r\n"
			+ "join soch.district d on(a.district_id=d.id)\r\n"
			+ "LEFT OUTER JOIN  soch.subdistrict sd on(a.subdistrict_id=sd.subdistrict_id )\r\n"
			+ "LEFT OUTER JOIN  soch.town t on(a.town_id=t.town_id )\r\n"
			+ "where mus.is_delete=:b1 and mus.is_facility=:b2 and LOWER(mus.source_name) like %:sourceName%")
	List<UnregisteredSourceProjection> findUnregisteredSourcesOrFacilitiesByName(@Param("b1") Boolean b1,
			@Param("b2") Boolean b2, @Param("sourceName") String sourceName);

}
