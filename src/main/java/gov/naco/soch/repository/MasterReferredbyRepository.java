package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterReferredby;

@Repository
public interface MasterReferredbyRepository extends JpaRepository<MasterReferredby, Long> {

	List<MasterReferredby> findByIsDelete(Boolean isDelete);

}
