package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TiBeneficiaryReadOnly;

@Repository
public interface TiBenRepositoryReadOnly
		extends JpaRepository<TiBeneficiaryReadOnly, Long>, JpaSpecificationExecutor<TiBeneficiaryReadOnly> {
        @Override
        @EntityGraph(value = "tiBenGraph")
        Page<TiBeneficiaryReadOnly> findAll(Specification<TiBeneficiaryReadOnly> spec, Pageable pageable);
}
