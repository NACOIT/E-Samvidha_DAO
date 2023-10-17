package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductDosageCategoryMaster;

@Repository
public interface ProductDosageCategoryMasterRepository extends JpaRepository<ProductDosageCategoryMaster, Long> {

	List<ProductDosageCategoryMaster> findByIsDelete(Boolean false1);

	@Query(nativeQuery = true, value = "select pdcm.* from soch.product_dosage_category_master pdcm where pdcm.is_delete=false and pdcm.id=:productCategoryId")
	List<ProductDosageCategoryMaster> findByIsDeleteAndId(@Param("productCategoryId") Long productCategoryId);

}
