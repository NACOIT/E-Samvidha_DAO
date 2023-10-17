package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.MasterMultimonthDispensation;

@Repository
public interface MasterMultimonthDispensationRepository extends JpaRepository<MasterMultimonthDispensation, Long>{

	List<MasterMultimonthDispensation> findByIsDelete(Boolean false1);

}
