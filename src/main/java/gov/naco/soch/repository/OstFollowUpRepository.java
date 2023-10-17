package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.OstFollowUp;

@Repository
public interface OstFollowUpRepository extends JpaRepository<OstFollowUp, Long>, JpaSpecificationExecutor<OstFollowUp> {
    
    @Override
    @EntityGraph(value = "ostFollowUpGraph")
     Page<OstFollowUp> findAll(Specification<OstFollowUp> spec, Pageable pageable);
}