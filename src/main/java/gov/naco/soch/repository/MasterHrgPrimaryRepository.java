package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHrgPrimary;

@Repository
public interface MasterHrgPrimaryRepository extends JpaRepository<MasterHrgPrimary, Long> {

	List<MasterHrgPrimary> findByIsDelete(Boolean isDelete);

}