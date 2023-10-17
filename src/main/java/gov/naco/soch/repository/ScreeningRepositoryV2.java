package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ScreeningV2;

@Repository
public interface ScreeningRepositoryV2 extends JpaRepository<ScreeningV2, Long>, JpaSpecificationExecutor<ScreeningV2> {
    
}