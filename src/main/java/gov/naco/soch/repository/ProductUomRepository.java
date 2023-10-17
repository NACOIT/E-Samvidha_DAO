/**
 * 
 */
package gov.naco.soch.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductUomMaster;

@Repository
public interface ProductUomRepository extends JpaRepository<ProductUomMaster, Long> {

	//method to select all product_uom details
	@Query(nativeQuery = true, value = "select * from soch.product_uom_master  order by id desc")
	ArrayList<ProductUomMaster> findAll();

	/**
	 * @param checkName
	 * @return count
	 */
	//method to check whether the productUom_name is already exist in add
	@Query(nativeQuery = true, value = "select count(id) from soch.product_uom_master where LOWER(uom_name)=LOWER(?1)")
	int existsByuomNameIgnoreCase(String productUomName);
	
	/**
	 * @param checkName
	 * @return count
	 */
	//method to check whether the productUom_name is already exist in edit
	@Query(nativeQuery = true, value = "select count(id) from soch.product_uom_master where LOWER(uom_name)=LOWER(?1) and id!=?2")
	int existsByuomNameInEdit(String productUomName,Long id);

	List<ProductUomMaster> findByIsDelete(Boolean isDelete);
}
