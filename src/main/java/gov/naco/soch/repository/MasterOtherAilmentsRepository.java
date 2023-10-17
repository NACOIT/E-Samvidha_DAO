package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterOtherAilment;

@Repository
public interface MasterOtherAilmentsRepository extends JpaRepository<MasterOtherAilment, Long> {

	List<MasterOtherAilment> findByIsDelete(Boolean isDelete);

}