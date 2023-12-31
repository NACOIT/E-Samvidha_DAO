package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDiagnosisRecordedAt;

@Repository
public interface MasterDiagnosisRecordedAtRepository extends JpaRepository<MasterDiagnosisRecordedAt, Long> {

	List<MasterDiagnosisRecordedAt> findByIsDelete(Boolean isDelete);

}
