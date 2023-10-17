package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ReportsRoleMapping;

@Repository
public interface ReportsRoleMappingRepository extends JpaRepository<ReportsRoleMapping, Long> {

	public void deleteByMasterReport_ReportId(Long reportId);

	public List<ReportsRoleMapping> findByMasterReport_ReportId(Long reportId);

	public List<ReportsRoleMapping> findByRole_Id(Long roleId);

	@Query(nativeQuery = true, value = "select distinct on(grrm.report_id) grrm.* from soch.global_report_role_mapping grrm \r\n"
			+ "join soch.global_reports_division_mapping grdm on grrm.report_id =grdm.report_id \r\n"
			+ "join soch.division_admin_division_mapping dadm on grdm.division_id = dadm.division_id \r\n"
			+ "where dadm.user_id= :userId and grrm.role_id= :roleId group by grrm.mapping_id,grrm.report_id  order by grrm.report_id ")
	public List<ReportsRoleMapping> findByReportByDivisionAdmin(@Param("userId") Long userId,
			@Param("roleId") Long roleId);

	@Query(nativeQuery = true, value = "select distinct on(grrm.report_id) grrm.* from soch.global_report_role_mapping grrm "
			+ "where grrm.role_id= :roleId group by grrm.mapping_id,grrm.report_id  " + "order by grrm.report_id;")
	public List<ReportsRoleMapping> findByReportByRole_Id(@Param("roleId") Long roleId);

	@Query(nativeQuery = true, value = "select grrm.* from soch.global_report_role_mapping grrm \r\n"
			+ "left join soch.global_reports_module grm on grrm.module_id =grm.module_id \r\n"
			+ "left join soch.global_reports_submodule grs on grrm.submodule_id = grs.submodule_id \r\n"
			+ "left join soch.global_master_reports gmr on grrm.report_id = gmr.report_id \r\n"
			+ "left join soch.role r on grrm.role_id =r.id \r\n"
			+ "left join soch.user_master um on grrm.created_by = um.id ")
	public Page<ReportsRoleMapping> findList(Pageable paginateObject);

	@Query(nativeQuery = true, value = "select distinct on(r.id) r.id,r.name from soch.role r\r\n"
			+ "join soch. global_report_role_mapping grrm on r.id = grrm.role_id \r\n"
			+ "where grrm.report_id= :reportId order by r.id")
	public List<Object[]> findRoleListByReportId(@Param("reportId") Long reportId);

}
