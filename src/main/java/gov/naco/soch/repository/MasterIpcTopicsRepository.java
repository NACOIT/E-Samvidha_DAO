package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterIPCTopic;

@Repository
public interface MasterIpcTopicsRepository extends JpaRepository<MasterIPCTopic, Long> {

	List<MasterIPCTopic> findByIsDelete(Boolean isDelete);

}