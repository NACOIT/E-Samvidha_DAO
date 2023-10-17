package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityAggregateStock;
import gov.naco.soch.projection.ProductInventoryProjection;

@Repository
public interface FacilityAggregateStockRepository extends JpaRepository<FacilityAggregateStock, Long> {

	List<FacilityAggregateStock> findAllByFacilityId(Long facilityId);

	FacilityAggregateStock findByFacilityIdAndProductId(Long facilityId, Long productId);

	@Query(nativeQuery = true, value = "select p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,"
			+ "	sum(fas.git) as git from (select product_id, facility_id, git,damaged_quantity,case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then 0 else available_quantity\r\n"
			+ "	end as available_quantity,case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then available_quantity else 0\r\n"
			+ "	end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "	where facility_id = :facilityId ) as fas join soch.product as p on\r\n"
			+ "	p.id = fas.product_id group by fas.product_id,fas.facility_id,\r\n"
			+ "	p.product_name,p.product_image,p.product_short_code,p.is_delete having fas.facility_id = :facilityId and p.is_delete=false", countQuery = "select count(*) from (\r\n"
					+ "select fas.product_id as productId\r\n" + "from(select product_id, facility_id\r\n"
					+ "from soch.facility_aggregate_stock\r\n" + "where facility_id = :facilityId ) as fas\r\n"
					+ "join soch.product as p on\r\n" + "p.id = fas.product_id group by\r\n"
					+ "fas.product_id,fas.facility_id,p.is_delete\r\n"
					+ "having fas.facility_id = :facilityId and p.is_delete = false) res")
	Page<ProductInventoryProjection> findAllByFacilityIdToProjection(@Param("facilityId") Long facilityId,
			Pageable paging);

	@Query(nativeQuery = true, value = "select p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,"
			+ "	sum(fas.git) as git from (select product_id, facility_id, git,damaged_quantity,case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then 0 else available_quantity\r\n"
			+ "	end as available_quantity,case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then available_quantity else 0\r\n"
			+ "	end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "	where facility_id = :facilityId ) as fas join soch.product as p on\r\n"
			+ "	p.id = fas.product_id group by fas.product_id,fas.facility_id,\r\n"
			+ "	p.product_name,p.product_image,p.product_short_code,p.is_delete having fas.facility_id = :facilityId and p.is_delete=false order by p.product_name asc")
	List<ProductInventoryProjection> findAllByFacilityIdToProjection(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,\r\n"
			+ "	sum(fas.git) as git from(select\r\n" + "	product_id, facility_id, git,damaged_quantity,case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then 0 else available_quantity\r\n"
			+ "	end as available_quantity,case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then available_quantity else 0\r\n"
			+ "	end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "	where facility_id = :facilityId and product_id = :productId) as fas\r\n"
			+ " join soch.product as p on p.id = fas.product_id group by fas.product_id,\r\n"
			+ "	fas.facility_id,p.product_name,p.product_image,\r\n"
			+ "	p.product_short_code having fas.facility_id = :facilityId and fas.product_id = :productId")
	ProductInventoryProjection findByFacilityIdAndProductIdToProjection(@Param("facilityId") Long facilityId,
			@Param("productId") Long productId);

	List<FacilityAggregateStock> findAllByFacilityIdAndProductIdAndProduct_IsDelete(Long facilityId, Long productId,
			Boolean b);

	@Query(nativeQuery = true, value = "select\r\n" + "	p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,\r\n" + "	p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,p.product_commodity_type_id,\r\n" + "	fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,\r\n"
			+ "	sum(fas.git) as git\r\n" + "from\r\n" + "	(\r\n" + "	select\r\n"
			+ "		product_id, facility_id, git,damaged_quantity,\r\n" + "		case\r\n"
			+ "			when date(batch_expiry_date) < date(now()) then 0\r\n" + "			else available_quantity\r\n"
			+ "		end as available_quantity,\r\n" + "		case\r\n"
			+ "			when date(batch_expiry_date) < date(now()) then available_quantity\r\n" + "			else 0\r\n"
			+ "		end as expired_quantity\r\n" + "	from\r\n" + "		soch.facility_aggregate_stock\r\n"
			+ "	where\r\n" + "		facility_id = :facilityId) as fas\r\n" + "join soch.product as p on\r\n"
			+ "	p.id = fas.product_id\r\n" + "group by\r\n" + "	fas.product_id,\r\n" + "	fas.facility_id,\r\n"
			+ "	p.product_name,p.product_commodity_type_id,\r\n" + "p.product_image,\r\n"
			+ "	p.product_short_code,p.is_delete\r\n" + "having\r\n"
			+ "	fas.facility_id = :facilityId and p.product_commodity_type_id=:typeId and p.is_delete=false")
	List<ProductInventoryProjection> findAllARVDrugs(@Param("typeId") Long typeId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,p.product_commodity_type_id,fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,sum(fas.git) as git from\r\n"
			+ "	(select product_id, facility_id, git,damaged_quantity, case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then 0 else available_quantity\r\n"
			+ "	end as available_quantity, case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then available_quantity\r\n" + "			else 0\r\n"
			+ "	end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "	where facility_id = :facilityId) as fas join soch.product as p on\r\n"
			+ "	p.id = fas.product_id group by fas.product_id, fas.facility_id,\r\n"
			+ "	p.product_name,p.product_commodity_type_id, p.product_image, p.product_short_code,p.is_delete\r\n"
			+ "having fas.facility_id = :facilityId and (p.product_commodity_type_id!=:typeId or p.product_commodity_type_id IS NULL ) and p.is_delete=false")
	List<ProductInventoryProjection> findAllNonARVDrugs(@Param("typeId") Long typeId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select p.product_name as productName,p.is_active as status,\r\n"
			+ "p.product_short_code as productCode,p.product_image as productImage,\r\n"
			+ "ptm.id as productTypeId,ptm.product_type_name as productType,pum.id as uomId,pum.uom_name as uomName,\r\n"
			+ "fas.product_id as productId,fas.facility_id as facilityId,\r\n"
			+ "fas.batch_number as batchNumber,fas.batch_expiry_date as expiryDate,\r\n"
			+ "fas.batch_manufacture_date as manufactureDate,fas.available_quantity as availableQuantity,\r\n"
			+ "fas.damaged_quantity as damagedQuantity,\r\n"
			+ "fas.git as git from soch.facility_aggregate_stock fas\r\n"
			+ "left join soch.product p on(fas.product_id=p.id)\r\n"
			+ "left join soch.product_types_master ptm on(p.product_type_id=ptm.id)\r\n"
			+ "left join soch.product_uom_master pum on(p.uom_id=pum.id)\r\n"
			+ "where fas.facility_id=:facilityId and fas.product_id=:productId")
	List<ProductInventoryProjection> findProductDetailsByFacilityIdAndProductId(@Param("facilityId") Long facilityId,
			@Param("productId") Long productId);

	@Query(nativeQuery = true, value = "select fas.facility_id as facilityId,fas.product_id as productId,\r\n"
			+ "p.product_name as productName,p.product_short_code as productCode,\r\n"
			+ "p.product_image as productImage,ptm.product_type_name as productType,\r\n"
			+ "ptm.id as productTypeId,pum.id as uomId,pum.uom_name as uomName,\r\n"
			+ "fas.batch_number as batchNumber,fas.batch_expiry_date as expiryDate,\r\n"
			+ "fas.batch_manufacture_date as manufactureDate,fas.available_quantity as availableQuantity,\r\n"
			+ "fas.damaged_quantity as damagedQuantity\r\n"
			+ "from soch.facility_aggregate_stock fas join soch.product p\r\n"
			+ "on(fas.product_id=p.id) left join soch.product_types_master ptm\r\n"
			+ "on(p.product_type_id=ptm.id) left join soch.product_uom_master pum on(p.uom_id=pum.id)\r\n"
			+ "where fas.facility_id=:facilityId and  date(batch_expiry_date) >= date(now())\r\n"
			+ "and fas.available_quantity>0 and fas.available_quantity is not null and p.is_delete=false order by fas.batch_expiry_date asc \r\n"
			+ "")
	List<ProductInventoryProjection> findActiveBatchesByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select fas.facility_id as facilityId,fas.product_id as productId,\r\n"
			+ "p.product_name as productName,p.product_short_code as productCode,\r\n"
			+ "p.product_image as productImage,ptm.product_type_name as productType,\r\n"
			+ "ptm.id as productTypeId,pum.id as uomId,pum.uom_name as uomName,\r\n"
			+ "fas.batch_number as batchNumber,fas.batch_expiry_date as expiryDate,\r\n"
			+ "fas.batch_manufacture_date as manufactureDate,fas.available_quantity as availableQuantity,\r\n"
			+ "fas.damaged_quantity as damagedQuantity\r\n"
			+ "from soch.facility_aggregate_stock fas join soch.product p\r\n"
			+ "on(fas.product_id=p.id) left join soch.product_types_master ptm\r\n"
			+ "on(p.product_type_id=ptm.id) left join soch.product_uom_master pum on(p.uom_id=pum.id)\r\n"
			+ "where fas.facility_id=:facilityId and  date(batch_expiry_date) >= date(now())\r\n"
			+ "and fas.available_quantity>0 and fas.available_quantity is not null and p.is_delete=false\r\n"
			+ " and p.product_short_code in (:productCodes) order by fas.batch_expiry_date asc \r\n")
	List<ProductInventoryProjection> findActiveBatchesByFacilityIdAndProductCodes(@Param("facilityId") Long facilityId,
			@Param("productCodes") List<String> productCodes);

	@Query(nativeQuery = true, value = "select p.product_name as productName,pum.uom_name as uomName,\r\n"
			+ "	p.product_short_code as productCode,p.product_image as productImage,\r\n"
			+ "	fas.product_id as productId,fas.facility_id as facilityId,\r\n"
			+ "	sum(fas.available_quantity) as availableQuantity,\r\n"
			+ "	sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,"
			+ "	sum(fas.git) as git from (select product_id, facility_id, git,damaged_quantity,case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then 0 else available_quantity\r\n"
			+ "	end as available_quantity,case\r\n"
			+ "	when date(batch_expiry_date) < date(now()) then available_quantity else 0\r\n"
			+ "	end as expired_quantity from soch.facility_aggregate_stock\r\n"
			+ "	where facility_id = :facilityId ) as fas join soch.product as p on\r\n"
			+ "	(p.id = fas.product_id) left join soch.product_uom_master pum\r\n"
			+ "	on(p.uom_id=pum.id)group by fas.product_id,fas.facility_id,\r\n"
			+ "	p.product_name,p.product_image,p.product_short_code,p.is_delete,pum.uom_name having fas.facility_id = :facilityId and p.is_delete=false\r\n"
			+ " and( LOWER(p.product_name) like :searchValue% OR LOWER(p.product_short_code) like :searchValue% OR LOWER(pum.uom_name) like :searchValue% )", countQuery = "select count(*) from (\r\n"
					+ "select fas.product_id as productId from(select product_id, facility_id\r\n"
					+ "from soch.facility_aggregate_stock where facility_id = :facilityId ) as fas\r\n"
					+ "join soch.product as p on (p.id = fas.product_id) left join soch.product_uom_master pum\r\n"
					+ "on(p.uom_id=pum.id) group by\r\n"
					+ "fas.product_id,p.product_name,fas.facility_id,p.is_delete,p.product_short_code,pum.uom_name\r\n"
					+ "having fas.facility_id = :facilityId and p.is_delete = false "
					+ "and( LOWER(p.product_name) like :searchValue% OR LOWER(p.product_short_code) like :searchValue% OR LOWER(pum.uom_name) like :searchValue%)) res")
	Page<ProductInventoryProjection> findAllFacilityProductListByNormalSearch(@Param("facilityId") Long facilityId,
			@Param("searchValue") String searchValue, Pageable paging);

	@Query(nativeQuery = true, value = "select fas.facility_id as facilityId,fas.product_id as productId,\r\n"
			+ "p.product_name as productName,p.product_short_code as productCode,\r\n"
			+ "p.product_image as productImage,ptm.product_type_name as productType,\r\n"
			+ "ptm.id as productTypeId,pum.id as uomId,pum.uom_name as uomName,\r\n"
			+ "fas.batch_number as batchNumber,fas.batch_expiry_date as expiryDate,\r\n"
			+ "fas.batch_manufacture_date as manufactureDate,fas.available_quantity as availableQuantity,\r\n"
			+ "fas.damaged_quantity as damagedQuantity\r\n"
			+ "from soch.facility_aggregate_stock fas join soch.product p\r\n"
			+ "on(fas.product_id=p.id) left join soch.product_types_master ptm\r\n"
			+ "on(p.product_type_id=ptm.id) left join soch.product_uom_master pum on(p.uom_id=pum.id)\r\n"
			+ "left join soch.product_facility_type_mapping pftm on(p.id=pftm.product_id)"
			+ "where fas.facility_id=:facilityId and  date(batch_expiry_date) >= date(now())\r\n"
			+ "and fas.available_quantity>0 and fas.available_quantity is not null and p.is_delete=false and pftm.facility_type_id=:facilityTypeId order by fas.batch_expiry_date asc \r\n"
			+ "")
	List<ProductInventoryProjection> findActiveBatchesByFacilityIdAndFacilityTypeId(
			@Param("facilityId") Long facilityId, @Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "select fas.facility_id as facilityId,fas.product_id as productId,\n"
			+ "p.product_name as productName,p.product_short_code as productCode,\n"
			+ "p.product_image as productImage,ptm.product_type_name as productType,\n"
			+ "ptm.id as productTypeId,pum.id as uomId,pum.uom_name as uomName,\n"
			+ "fas.batch_number as batchNumber,fas.batch_expiry_date as expiryDate,\n"
			+ "fas.batch_manufacture_date as manufactureDate,fas.available_quantity as availableQuantity,\n"
			+ "fas.damaged_quantity as damagedQuantity\n" + "from soch.facility_aggregate_stock fas\n"
			+ "join soch.product p on(fas.product_id=p.id)\n"
			+ "left join soch.product_types_master ptm on(p.product_type_id=ptm.id)\n"
			+ "left join soch.product_uom_master pum on(p.uom_id=pum.id)\n"
			+ "where date(batch_expiry_date) >= date(now())\n" + "and date(batch_expiry_date) >= date(now())\n"
			+ "and fas.available_quantity>0 and fas.available_quantity is not null and p.is_delete=false\n"
			+ "and fas.facility_id= :facilityId\n" + "and (\n" + "(\n" + "p.product_name not ilike '%needle%'\n"
			+ "and p.product_name not ilike '%syringe%'\n" + "and p.product_name not ilike '%condom%' )\n"
			+ "or p.product_short_code in (:productCodes)\n" + ")\n" + "order by fas.batch_expiry_date asc")
	List<ProductInventoryProjection> findActiveBatchesByFacilityIdAndProductCodesForOther(
			@Param("facilityId") Long facilityId, @Param("productCodes") List<String> productCodes);

	@Query(nativeQuery = true, value = "select fas.facility_id as facilityId,fas.product_id as productId,\r\n"
			+ "p.product_name as productName,p.product_short_code as productCode,\r\n"
			+ "p.product_image as productImage,ptm.product_type_name as productType,\r\n"
			+ "ptm.id as productTypeId,pum.id as uomId,pum.uom_name as uomName,\r\n"
			+ "fas.batch_number as batchNumber,fas.batch_expiry_date as expiryDate,\r\n"
			+ "fas.batch_manufacture_date as manufactureDate,fas.available_quantity as availableQuantity,\r\n"
			+ "fas.damaged_quantity as damagedQuantity\r\n"
			+ "from soch.facility_aggregate_stock fas join soch.product p\r\n"
			+ "on(fas.product_id=p.id) left join soch.product_types_master ptm\r\n"
			+ "on(p.product_type_id=ptm.id) left join soch.product_uom_master pum on(p.uom_id=pum.id)\r\n"
			+ "where fas.facility_id=:facilityId and  date(batch_expiry_date) >= date(now())\r\n"
			+ "and fas.available_quantity>0 and fas.available_quantity is not null and p.is_delete=false\r\n"
			+ " and p.product_name ilike ('%'||(:productCodes)||'%') order by fas.batch_expiry_date asc \r\n")
	List<ProductInventoryProjection> findActiveBatchesByFacilityIdAndProductCodesForMobile(
			@Param("facilityId") Long facilityId, @Param("productCodes") List<String> productCodes);

}
