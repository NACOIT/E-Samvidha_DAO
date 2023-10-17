package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.OstFollowUpV2;

@Repository
public interface OstFollowUpV2Repository extends JpaRepository<OstFollowUpV2, Long>, JpaSpecificationExecutor<OstFollowUpV2> {
    
    @Override
    @EntityGraph(value = "ostFollowUpGraphV2")
     Page<OstFollowUpV2> findAll(Specification<OstFollowUpV2> spec, Pageable pageable);
}