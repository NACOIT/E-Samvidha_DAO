package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssWarehouse;

@Repository
public interface CmssWarehouseRepository extends JpaRepository<CmssWarehouse, Long> {

	Boolean existsByStoreId(String storeId);

	@Query(nativeQuery=true,value="select count(c.store_id) from soch.cmss_warehouse c where c.store_id=:storeId and id!=:id")
	int existsByIdAndStoreId(@Param("id")Long id,@Param("storeId") String storeId);

	List<CmssWarehouse> findAllByOrderByIdAsc();
	
	@Query(value = "select c from CmssWarehouse c where c.id = :id")
	Optional<CmssWarehouse> findById(@Param("id") Long id);

	@Query(nativeQuery=true,value="SELECT * FROM soch.cmss_warehouse cw join soch.sacs_cmss_warehouse_mapping cwm\r\n" + 
			"on(cw.id=cwm.cmss_warehouse_id) where cwm.sacs_id=:sacsId\r\n" + 
			"ORDER BY cw.store_name ASC ")
	List<CmssWarehouse> findBySACSId(@Param("sacsId") Long sacsId);
	
	
	

}
