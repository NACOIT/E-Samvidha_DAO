package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterRemark;

@Repository
public interface MasterRemarkRepository extends JpaRepository<MasterRemark, Long> {

	List<MasterRemark> findByIsDelete(Boolean isDelete);
}
