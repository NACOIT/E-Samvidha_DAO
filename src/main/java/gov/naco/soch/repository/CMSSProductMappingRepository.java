package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CMSSProductMapping;
import gov.naco.soch.projection.CMSSProductProjection;

@Repository
public interface CMSSProductMappingRepository extends JpaRepository<CMSSProductMapping, Long> {

	List<CMSSProductMapping> findByIsDelete(Boolean isDelete);

	@Query(nativeQuery = true, value = "SELECT c.id as mappingId, p.product_name as productName "
			+ "FROM soch.cmss_product_mapping c join soch.product p on c.product_code = p.product_short_code "
			+ "where p.is_active = true and p.is_delete = false")
	List<CMSSProductProjection> getCMSSProductForRO();

	@Query(value = "select c from CMSSProductMapping c where c.id = :id")
	Optional<CMSSProductMapping> findById(@Param("id") Long id);
}
