package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductCommodityTypeMaster;

@Repository
public interface ProductCommodityTypeMasterRepository extends JpaRepository<ProductCommodityTypeMaster, Long> {

	List<ProductCommodityTypeMaster> findAllByIsDelete(Boolean false1);
	
	@Query(nativeQuery = true, value = "select count(d.id) from soch.product_commodity_type_master d where is_delete = false and  LOWER(d.product_commodity_type_name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name); 

}
