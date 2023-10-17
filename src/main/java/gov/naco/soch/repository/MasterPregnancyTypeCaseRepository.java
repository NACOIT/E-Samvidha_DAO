package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterPregnancyTypeCase;

@Repository
public interface MasterPregnancyTypeCaseRepository extends JpaRepository<MasterPregnancyTypeCase, Long> {

	List<MasterPregnancyTypeCase> findByIsDelete(Boolean isDelete);

}
