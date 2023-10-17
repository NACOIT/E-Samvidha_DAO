/**
 * 
 */
package gov.naco.soch.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductTypesMaster;

// repository mapped with entity class
@Repository
public interface ProductTypesMasterRepository extends JpaRepository<ProductTypesMaster, Long> {

	// to get all product types details
	@Query(nativeQuery = true, value = "select * from soch.product_types_master order by id desc")
	ArrayList<ProductTypesMaster> findAll();

	// method to check whether the product_type_name i already exist or not in add
	@Query(nativeQuery = true, value = "select count(id) from soch.product_types_master where LOWER(product_type_name)=LOWER(?1)")
	int existsByproductTypeNameIgnoreCase(String checkName);

	// method to check whether the product_type_name i already exist or not in edit
	@Query(nativeQuery = true, value = "select count(id) from soch.product_types_master where LOWER(product_type_name)=LOWER(?1) and id!=?2")
	int existsByproductTypeNameInEdit(String productTypeName, Long id);

}
