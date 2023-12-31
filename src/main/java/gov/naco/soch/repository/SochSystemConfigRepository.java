package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.SochSystemConfig;

@Repository
public interface SochSystemConfigRepository extends JpaRepository<SochSystemConfig, Long> {

}
