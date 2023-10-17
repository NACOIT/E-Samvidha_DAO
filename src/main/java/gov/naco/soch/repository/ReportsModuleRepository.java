package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ReportsModule;

@Repository
public interface ReportsModuleRepository extends JpaRepository<ReportsModule, Long> {

	@Query(nativeQuery=true,value="select grm.* from soch.global_reports_module grm "
			+ "left join soch.user_master um on grm.created_by=um.id ")
	Page<ReportsModule> findList(Pageable paginateObject);

}
