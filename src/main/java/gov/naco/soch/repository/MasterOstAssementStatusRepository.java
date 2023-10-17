package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterOstAssementStatus;

@Repository
public interface MasterOstAssementStatusRepository extends JpaRepository<MasterOstAssementStatus, Long> {

	List<MasterOstAssementStatus> findByIsDelete(Boolean isDelete);

}