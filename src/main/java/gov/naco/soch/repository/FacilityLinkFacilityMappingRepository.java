package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityLinkFacilityMapping;

@Repository
public interface FacilityLinkFacilityMappingRepository extends JpaRepository<FacilityLinkFacilityMapping, Long>  {

}
