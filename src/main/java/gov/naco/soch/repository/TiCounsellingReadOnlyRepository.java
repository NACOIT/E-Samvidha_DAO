package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TiCounsellingSubEntity;


@Repository
public interface TiCounsellingReadOnlyRepository extends JpaRepository<TiCounsellingSubEntity, Long>, JpaSpecificationExecutor<TiCounsellingSubEntity> {
    
    @Override
    @EntityGraph(value = "counsellingGraph")
    Page<TiCounsellingSubEntity> findAll(Specification<TiCounsellingSubEntity> spec, Pageable pageable);

}
