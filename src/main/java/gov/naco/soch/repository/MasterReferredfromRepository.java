package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterReferredfrom;

@Repository
public interface MasterReferredfromRepository extends JpaRepository<MasterReferredfrom, Long> {

	List<MasterReferredfrom> findByIsDelete(Boolean isDelete);

}