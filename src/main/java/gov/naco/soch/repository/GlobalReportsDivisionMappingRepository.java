package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.GlobalReportsDivisionMapping;

@Repository
public interface GlobalReportsDivisionMappingRepository extends JpaRepository<GlobalReportsDivisionMapping, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "delete from soch.global_reports_division_mapping where report_id= :reportId")
	void deleteByReportId(@Param("reportId") Long reportId);

	@Query(nativeQuery = true, value = "select distinct on(d.id) d.id,d.name from soch.division d\r\n"
			+ "join soch.global_reports_division_mapping grdm on d.id = grdm.division_id \r\n"
			+ "where grdm.report_id= :reportId order by d.id")
	List<Object[]> findDivisionListByReportId(@Param("reportId") Long reportId);

	// public void deleteByMasterReport_ReportId(Long reportId);

}
