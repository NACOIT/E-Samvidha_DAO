package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityAggregateStock;
import gov.naco.soch.projection.ProductInventoryProjection;

@Repository
public interface FacilityAggregateStockMobileRepository extends JpaRepository<FacilityAggregateStock, Long> {



	@Query(nativeQuery = true, value = "select p.product_name as productName,\r\n"
			+ "	p.product_short_code as productCode,p.product_image as productImage,p.uom_id as uomId, \r\n"
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
			+ "	p.product_name,p.product_image,p.product_short_code,p.is_delete, p.uom_id having fas.facility_id = :facilityId and p.is_delete=false", countQuery = "select count(*) from (\r\n"
					+ "select fas.product_id as productId\r\n" + "from(select product_id, facility_id\r\n"
					+ "from soch.facility_aggregate_stock\r\n" + "where facility_id = :facilityId ) as fas\r\n"
					+ "join soch.product as p on\r\n" + "p.id = fas.product_id group by\r\n"
					+ "fas.product_id,fas.facility_id,p.is_delete\r\n"
					+ "having fas.facility_id = :facilityId and p.is_delete = false) res")
	Page<ProductInventoryProjection> findAllByFacilityIdToProjection(@Param("facilityId") Long facilityId,
			Pageable paging);

	

}
