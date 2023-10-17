package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IndentProductScheduleSac;
import gov.naco.soch.projection.IndentProductScheduleSacsProjection;

@Repository
public interface IndentProductScheduleSacsRepository extends JpaRepository<IndentProductScheduleSac, Long> {

	@Query(nativeQuery = true, value = "select ipss.indent_product_schedule_id as scheduleId,ipss.id as scheduleSacsId,f.id as facilityId,f.name as facilityName,\r\n"
			+ "fp.facility_type_name as facilityTypeName from soch.indent_product_schedule_sacs ipss join soch.facility f on(f.id=ipss.to_facility)\r\n"
			+ "join soch.facility_type fp on(fp.id=f.facility_type_id) where ipss.indent_product_schedule_id IN :scheduleIds ")
	List<IndentProductScheduleSacsProjection> findByIndentProductScheduleId(
			@Param("scheduleIds") List<Long> scheduleIds);

}
