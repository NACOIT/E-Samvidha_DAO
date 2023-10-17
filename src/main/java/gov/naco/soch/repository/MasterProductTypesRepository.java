package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductTypesMaster;

@Repository
public interface MasterProductTypesRepository extends JpaRepository<ProductTypesMaster, Long> {
	List<ProductTypesMaster> findByIsDelete(Boolean isDelete);

	@Query(nativeQuery = true, value = "select count(d.id) from soch.product_types_master d where is_delete = false and  LOWER(d.product_type_name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name); 
}
