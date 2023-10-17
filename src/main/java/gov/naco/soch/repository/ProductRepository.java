package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Product;
import gov.naco.soch.projection.ProductInventoryProjection;
import gov.naco.soch.projection.ProductListProjection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, CustomRepository {

	@Query(value = "select p from Product p where p.productName in ('Buprenorphine','Methadone') ")
	List<Product> findSubstituitionDrugs();

	Product findById(Integer product);

	@Query(nativeQuery = true, value = "select fac.name as PlCenName ,addr.address as PlAddr ,addr.city as PlCity,dis.name as PlDist,"
			+ "stat.name as PlState, addr.pincode as PlPin ,prod.product_name as PlProdName ,fstock.batch_number as PlBatchNum,"
			+ "fstock.manufacturing_date as PlManfDate,fstock.expired_date as PlExprDate,fstock.current_quantity as PlAvailStock,"
			+ "(Select COALESCE (SUM(quantity),0) " + "FROM soch.facility_stock_tracking Fstr "
			+ "WHERE Fstr.facility_id 		= fstock.facility_id " + "AND Fstr.product_id 		= fstock.product_id "
			+ "AND Fstr.is_active 			= true " + "AND Fstr.created_time\\:\\:date = current_date "
			+ "AND Fstr.stock_add_deduct	= 'deduct')	as PlStockConsumed, " + "pum.uom_code as PlUom "
			+ "from soch.facility fac " + "join soch.address addr on fac.address_id = addr.id "
			+ "join soch.district dis on addr.district_id = dis.id "
			+ "join soch.state stat on addr.state_id = stat.id "
			+ "join soch.facility_stock fstock on fac.id = fstock.facility_id "
			+ "join soch.product prod on fstock.product_id = prod.id "
			+ "join soch.facility_stock_tracking fst on fac.id = fst.facility_id "
			+ "join soch.product_uom_master pum on pum.id = prod.uom_id " + "where fac.id=?1 ")
	List<ProductListProjection> getProductsByFacility(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select count(id) from soch.product where lower(product_name)=lower(:productName) and is_delete=false")
	int isExistByProductNameInSave(@Param("productName") String productName);

	@Query(nativeQuery = true, value = "select count(id) from soch.product where LOWER(product_name)=LOWER(:productName) and is_delete=false and id !=:id")
	int isExistByProductNameInEdit(@Param("productName") String productName, @Param("id") Long id);

	@Query(value = "select p.* from soch.product as p where lower(p.product_name) LIKE %:productName%", nativeQuery = true)
	List<Product> findByProductNameLike(@Param("productName") String productName);

	@Query(nativeQuery = true, value = "select p.id from soch.product p where p.product_name=:productName")
	Long findProductIdByProductName(@Param("productName") String productNam);

	List<Product> findAllByIsDelete(Boolean false1);

	@Query(nativeQuery = true, value = "select distinct on(p.id) p.id as productId,p.product_name as productName,p.product_image as productImage,\r\n"
			+ "p.product_short_code as productCode,p.is_active as status,\r\n"
			+ "p.uom_id as uomId,uom.uom_name as uomName, CAST(array_agg(concat(ft.facility_type_name)) as character varying) as facilitytype from soch.product p \r\n"
			+ "left join soch.product_uom_master uom on p.uom_id = uom.id \r\n"
			+ "left join soch.product_facility_type_mapping pftm on p.id = pftm.product_id and pftm.is_delete = false \r\n"
			+ "left join soch.facility_type ft on pftm.facility_type_id = ft.id \r\n"
			+ "where (lower(p.product_name) Like lower(:searchValue) or lower(uom.uom_name) Like lower(:searchValue) or lower(p.product_short_code) Like lower(:searchValue) \r\n"
			+ "or pftm.product_id in (select pftm2.product_id from soch.product_facility_type_mapping pftm2 \r\n"
			+ "join soch.facility_type ft2 on pftm2.facility_type_id=ft2.id \r\n"
			+ "where lower(ft2.facility_type_name) Like lower(:searchValue) and pftm2.is_delete=false)) and \r\n"
			+ "p.is_delete=false group by p.id,uom.id order by p.id desc")
	List<ProductInventoryProjection> findProductsByNormalSearch(@Param("searchValue") String searchValue);

	@Query(nativeQuery = true, value = "select distinct on(p.id) p.id as productId,p.product_name as productName,p.product_image as productImage,\r\n"
			+ "p.product_short_code as productCode,p.is_active as status,\r\n"
			+ "p.uom_id as uomId,uom.uom_name as uomName, CAST(array_agg(distinct(concat(ft.facility_type_name))) as character varying) as facilitytype from soch.product p \r\n"
			+ "left join soch.product_uom_master uom on p.uom_id = uom.id \r\n"
			+ "join soch.product_facility_type_mapping pftm on p.id = pftm.product_id and pftm.is_delete = false \r\n"
			+ "join soch.product_facility_type_mapping pftm2 on p.id = pftm2.product_id and pftm2.is_delete = false \r\n"
			+ "join soch.facility_type_division_mapping ftdm on pftm .facility_type_id =ftdm .facility_type_id and ftdm .is_delete = false \r\n"
			+ "join soch.division_admin_division_mapping dadm on ftdm .division_id = dadm .division_id \r\n"
			+ "join soch.facility_type ft on pftm2.facility_type_id = ft.id \r\n"
			+ "where (lower(p.product_name) Like lower(:searchValue) or lower(uom.uom_name) Like lower(:searchValue) or lower(p.product_short_code) Like lower(:searchValue) \r\n"
			+ "or pftm2.product_id in (select pftm3.product_id from soch.product_facility_type_mapping pftm3 \r\n"
			+ "join soch.facility_type ft2 on pftm3.facility_type_id=ft2.id \r\n"
			+ "where lower(ft2.facility_type_name) Like lower(:searchValue) and pftm3.is_delete=false )) and \r\n"
			+ "p.is_delete=false and dadm.user_id =:userId group by p.id,uom.id order by p.id desc")
	List<ProductInventoryProjection> findProductsByNormalSearchForDivisionAdmin(
			@Param("searchValue") String searchValue, @Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select distinct on (p.id) p.id as productId,p.product_name as productName,p.product_image as productImage,\r\n"
			+ "p.product_short_code as productCode,p.is_active as status,\r\n"
			+ "p.uom_id as uomId,uom.uom_name as uomName, CAST(array_agg(concat(ft.facility_type_name)) as character varying) as facilitytype from soch.product p \r\n"
			+ "left join soch.product_uom_master uom on p.uom_id = uom.id \r\n"
			+ "left join soch.product_facility_type_mapping pftm on p.id = pftm.product_id and pftm.is_delete = false \r\n"
			+ "left join soch.facility_type ft on pftm.facility_type_id = ft.id \r\n"
			+ "where p.is_delete=false group by p.id,uom.id order by p.id desc")
	List<ProductInventoryProjection> findAllByIsDeleteOrderByIdDesc();

	@Query(nativeQuery = true, value = "select distinct on(p.id) p.id as productId,p.product_name as productName,p.product_image as productImage, \r\n"
			+ "p.product_short_code as productCode,p.is_active as status, \r\n"
			+ "p.uom_id as uomId,uom.uom_name as uomName, CAST(array_agg(distinct(concat(ft.facility_type_name))) as character varying) as facilitytype from soch.product p \r\n"
			+ "left join soch.product_uom_master uom on p.uom_id = uom.id \r\n"
			+ "join soch.product_facility_type_mapping pftm on p.id = pftm.product_id and pftm.is_delete = false \r\n"
			+ "join soch.facility_type_division_mapping ftdm on pftm .facility_type_id =ftdm .facility_type_id and ftdm .is_delete = false \r\n"
			+ "join soch.division_admin_division_mapping dadm on ftdm .division_id = dadm .division_id \r\n"
			+ "join soch.product_facility_type_mapping pftm2 on p.id = pftm2.product_id and pftm2.is_delete = false \r\n"
			+ "join soch.facility_type ft on pftm2.facility_type_id = ft.id "
			+ "where dadm.user_id =:userId and p.is_delete = false group by p.id,uom.id order by p.id desc")
	List<ProductInventoryProjection> findAllByIsDeleteOrderByIdDescForDivisionAdmin(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select count(id) from soch.product where lower(product_short_code)=lower(:productShortCode) and is_delete=false and id !=:id")
	int isExistByProductShortCodeInEdit(@Param("productShortCode") String productShortCode, @Param("id") Long id);

	@Query(nativeQuery = true, value = "select count(id) from soch.product where lower(product_short_code)=lower(:productShortCode) and is_delete=false")
	int isExistByProductShortCodeInSave(@Param("productShortCode") String productShortCode);

	@Query(nativeQuery = true, value = "select distinct on(p.id,p.product_name) p.id as productId,p.product_name as productName,p.product_short_code as productCode,"
			+ "p.uom_id as uomId,uom.uom_name as uomName from soch.product p "
			+ "left join soch.product_uom_master uom on p.uom_id = uom.id "
			+ "where p.is_delete=false and p.is_active=true order by p.product_name asc")
	List<ProductInventoryProjection> findAllProductByIsActiveAndIsDelete();

	@Query(value = "select p.* from soch.product p join soch.product_facility_type_mapping f "
			+ "on p.id = f.product_id where p.is_delete = false "
			+ "and p.is_active =true and f.facility_type_id = :facilityTypeId order by p.product_name asc", nativeQuery = true)
	List<Product> findAllProductsUnderFacilityType(@Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "select  p.id as productId,p.product_name as productName,"
			+ "p.uom_id as uomId,uom.uom_name as uomName from soch.product p "
			+ "left join soch.product_uom_master uom on p.uom_id = uom.id " + "where p.id in :productIds")
	List<ProductInventoryProjection> findByProductId(@Param("productIds") List<Long> productIds);

	@Query(nativeQuery = true, value = "select distinct on(p.id,p.product_name) p.id as productId,p.product_name as productName,p.product_short_code as productCode,\r\n"
			+ "p.uom_id as uomId,uom.uom_name as uomName from soch.product p \r\n"
			+ "left join soch.product_uom_master uom on p.uom_id = uom.id \r\n"
			+ "join soch.product_facility_type_mapping pftm on p.id =pftm.product_id and pftm.is_delete =false \r\n"
			+ "join soch.facility_type_division_mapping ftdm on pftm.facility_type_id=ftdm.facility_type_id and ftdm.is_delete=false \r\n"
			+ "join soch.division_admin_division_mapping dadm on ftdm.division_id = dadm.division_id and dadm.is_delete=false \r\n"
			+ "where p.is_delete=false and p.is_active=true and dadm.user_id=:userId order by p.product_name asc")
	List<ProductInventoryProjection> findAllProductByDivisionAdminId(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select p.product_recipient_type_id from soch.product p where p.id=:productId")
	Long findReceiptTypeIdByProductId(@Param("productId") Long productId);

}
