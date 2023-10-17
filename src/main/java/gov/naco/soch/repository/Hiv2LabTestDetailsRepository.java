package gov.naco.soch.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Hiv2LabTestDetails;

@Repository
public interface Hiv2LabTestDetailsRepository extends JpaRepository<Hiv2LabTestDetails, Long> {

	@Query(value = "select * from soch.hiv2_lab_test_details hltd where hltd.pid=:pid and hltd.is_delete=:isDelete ", nativeQuery = true)
	Hiv2LabTestDetails findByPIdAndIsDelete(@Param("pid") String pid,@Param("isDelete") boolean isDelete);

	@Query(value = "select count(pid) from soch.hiv2_lab_test_details  where pid=:pid and is_delete=false", nativeQuery = true)
	Integer findLabResultCountByPidAndIsDelete(@Param("pid") String pid);

	@Modifying
	@Transactional
	@Query(value = "update soch.hiv2_lab_test_details set hiv2_lab_result_status_id=:status where pid in(:pidList) and is_delete=false", nativeQuery = true)
	Integer updateLabTestResults(@Param("pidList") List<String> pidList, @Param("status") Long status);

	@Modifying
	@Transactional
	@Query(value = "update soch.hiv2_lab_test_details set hiv2_lab_result_status_id=:status,is_active=false,is_delete=true where pid=:pid", nativeQuery = true)
	Integer deleteLabTestResult(@Param("pid") String pid,@Param("status") Long status);

}
