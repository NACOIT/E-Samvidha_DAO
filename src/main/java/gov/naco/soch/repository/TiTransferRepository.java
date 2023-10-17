package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.naco.soch.entity.TiTransferReadOnly;

public interface TiTransferRepository  extends JpaRepository<TiTransferReadOnly, Long>, JpaSpecificationExecutor<TiTransferReadOnly>{
    @Override
    @EntityGraph(value = "TiTransferReadOnlyEntityGraph")
    Page<TiTransferReadOnly> findAll(Specification<TiTransferReadOnly> spec, Pageable pageable);
}
