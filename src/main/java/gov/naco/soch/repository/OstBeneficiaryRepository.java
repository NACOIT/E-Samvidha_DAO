package gov.naco.soch.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.OstBenSubEntity;



@Repository
public interface OstBeneficiaryRepository 
extends JpaRepository<OstBenSubEntity, Long>, JpaSpecificationExecutor<OstBenSubEntity>{
}
