
package gov.naco.soch.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.InventoryStatusMaster;

@Repository
public interface InventoryStatusMasterRepository extends JpaRepository<InventoryStatusMaster, Long> {

	// method to select all inventory status details
	@Query(nativeQuery = true, value = "select * from soch.inventory_status_master order by id desc")
	ArrayList<InventoryStatusMaster> findAll();

	// method to check whether the inventory_status_name is already exist in add
	@Query(nativeQuery = true, value = "select count(id) from soch.inventory_status_master where LOWER(inventory_status_name)"
			+ "=LOWER(?1)")
	int existsByInventoryStatusNameInAdd(String inventoryStatusMasterName);

	// method to check whether the inventory_status_name is already exist in edit
	@Query(nativeQuery = true, value = "select count(id) from soch.inventory_status_master where LOWER(inventory_status_name)"
			+ "=LOWER(?1) and id!=?2")
	int existsByInventoryStatusNameInEdit(String inventoryStatusName, Long id);

}
