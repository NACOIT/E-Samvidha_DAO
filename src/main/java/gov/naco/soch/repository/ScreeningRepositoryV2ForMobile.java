package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ScreeningV2ForMobile;

@Repository
public interface ScreeningRepositoryV2ForMobile extends JpaRepository<ScreeningV2ForMobile, Long>, JpaSpecificationExecutor<ScreeningV2ForMobile> {
    
}