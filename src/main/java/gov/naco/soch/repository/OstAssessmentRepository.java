package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.OstAssessment;


@Repository
public interface OstAssessmentRepository
	extends JpaRepository<OstAssessment, Long>, JpaSpecificationExecutor<OstAssessment> {
    @Override
    @EntityGraph(value = "ostAssessGraph")
    Page<OstAssessment> findAll(Specification<OstAssessment> spec, Pageable pageable);
}
