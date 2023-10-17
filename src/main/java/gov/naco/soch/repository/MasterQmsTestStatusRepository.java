package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterQmsTestStatus;

@Repository
public interface MasterQmsTestStatusRepository extends JpaRepository<MasterQmsTestStatus, Long> {

	List<MasterQmsTestStatus> findByIsDelete(Boolean isDelete);

}
