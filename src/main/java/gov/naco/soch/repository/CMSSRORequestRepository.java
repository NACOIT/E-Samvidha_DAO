package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CMSSRORequest;
import gov.naco.soch.projection.CMSSRORequestProjection;

@Repository
public interface CMSSRORequestRepository extends JpaRepository<CMSSRORequest, Long> {

	@Query(value = "select r.id as id, r.product_id as productId, p.product_name as productName, "
			+ "cw.store_id as storeId, cw.store_name as storeName, r.indent_num as indentNbr, "
			+ "r.requested_quantity as requestedQty, r.requested_delivery_date as requestedDate, "
			+ "i.indent_reasons_name as reason, s.status as status, "
			+ "r.received_quantity as receivedQty, r.received_date as receivedDate "
			+ "from soch.cmss_ro_request r "
			+ "join soch.cmss_warehouse cw on cw.id = r.store_id "
			+ "join soch.cmss_product_mapping cpm on cpm.id = r.product_id join soch.product p "
			+ "on p.product_short_code = cpm.product_code join soch.indent_reasons_master i on i.id = r.reason_id "
			+ "join soch.master_cmss_ro_status s on s.id = r.ro_status where r.facility_id = :facilityId "
			+ "order by r.id desc", nativeQuery = true)
	Page<CMSSRORequestProjection> findRORequests(@Param("facilityId") Long facilityId, Pageable paging);

	@Query(value = "select c from CMSSRORequest c where c.indentNumber = :indentNbr")
	Optional<CMSSRORequest> findByIndentNbr(@Param("indentNbr") String indentNbr);
}
