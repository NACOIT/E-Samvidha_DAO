package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterVitaminAAge;

@Repository
public interface MasterVitaminAAgeRepository extends JpaRepository<MasterVitaminAAge, Long> {

	List<MasterVitaminAAge> findByIsDelete(Boolean isDelete);

}
