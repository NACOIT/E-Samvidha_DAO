package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ReportsSubModule;

@Repository
public interface ReportsSubModuleRepository extends JpaRepository<ReportsSubModule, Long> {

	public List<ReportsSubModule> findByReportsModule_ModuleId(Long reportId);

	@Query(nativeQuery = true, value = "select grs.* from soch.global_reports_submodule grs "
			+ "left join soch.global_reports_module grm on grs.module_id=grm.module_id "
			+ "left join soch.user_master um on grs.created_by=um.id ")
	public Page<ReportsSubModule> findList(Pageable paginateObject);

}
