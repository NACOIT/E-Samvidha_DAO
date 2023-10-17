package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterBaselineTest;

@Repository
public interface MasterBaselineTestsRepository extends JpaRepository<MasterBaselineTest, Long> {

	List<MasterBaselineTest> findByIsDelete(Boolean isDelete);

}
