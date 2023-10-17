package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterReport;

@Repository
public interface MasterReportsRepository extends JpaRepository<MasterReport, Long> {

	public List<MasterReport> findBySubModule_SubModuleId(Long subModuleId);

	@Query(nativeQuery = true, value = "select gmr.* from soch.global_master_reports gmr \r\n"
			+ "left join soch.global_reports_module grm on gmr.module_id = grm.module_id \r\n"
			+ "left join soch.global_reports_submodule grs on gmr.submodule_id = grs.submodule_id \r\n"
			+ "left join soch.user_master um on gmr.created_by = um.id ")
	public Page<MasterReport> findList(Pageable paginateObject);

}
