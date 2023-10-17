package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductFacilityTypeMapping;

@Repository
public interface ProductFacilityTypeMappingRepository extends JpaRepository<ProductFacilityTypeMapping, Long> {

}
