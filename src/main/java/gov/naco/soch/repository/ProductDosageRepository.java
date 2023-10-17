package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductDosage;

@Repository
public interface ProductDosageRepository extends JpaRepository<ProductDosage, Long>, CustomRepository {

	@Query(nativeQuery = true, value = "select distinct on(pd.id) pd.id as dosageid,p.id as productid,p.product_name as productName,\r\n"
			+ "p.product_short_code as productshortcode,pd.dosage_qty_per_month as dosage,\r\n"
			+ "pdcm.id as dosagecategoryid,pdcm.product_dosage_category_name as dosagecategoryname,\r\n"
			+ "mwb.id as weightbandid,mwb.name as weightband \r\n" + "from soch.product_dosage pd \r\n"
			+ "join soch.product p on pd.product_id = p.id \r\n"
			+ "left join soch.product_dosage_category_master pdcm on pd.age_category = pdcm.id and pdcm.is_delete = false and pdcm.is_active = true \r\n"
			+ "left join soch.master_weight_band mwb on pd.weight_band = mwb.id and mwb.is_delete =false and mwb.is_active=true \r\n"
			+ "where pd.is_delete = false and p.is_delete =false and p.is_active = true \r\n" + "order by pd.id desc")
	List<Object[]> findAllByIsDeleteOrderByIdDesc();

	Optional<ProductDosage> findByIdAndIsDelete(Long dosageId, Boolean false1);

	ProductDosage findByProductId(Long productId);

	List<ProductDosage> findAllByProduct_Id(Long productId);

	@Query(nativeQuery = true, value = "select pd.dosage_qty_per_month from soch.product_dosage pd where pd.product_id=:productId\r\n"
			+ "order by pd.created_time DESC LIMIT 1")
	Float findLatestByProductId(@Param("productId") Long productId);

	/*
	 * @Query(value =
	 * "select p from ProductDosage p where p.productId in ('ATV/r-A') ")
	 * List<ProductDosage> findSubstituitionDrugs();
	 */

}
