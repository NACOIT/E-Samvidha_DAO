package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IndentProductSchedule;
import gov.naco.soch.projection.IndentProductScheduleProjection;

@Repository
public interface IndentProductScheduleRepository extends JpaRepository<IndentProductSchedule, Long> {

	@Query(nativeQuery = true, value = "select ips.indent_product_id as indentProductId,ips.id as scheduleId,ips.schedule_number as scheduleNumber,\r\n"
			+ "ips.quantity as quantity,ips.unit_price as unitPrice from soch.indent_product_schedule ips join soch.indent_product ip on(ip.id=ips.indent_product_id)\r\n"
			+ "join soch.indent i on(i.indent_id=ip.indent_id) where ips.indent_product_id IN :indentProductIds ORDER BY ips.schedule_number ASC")
	List<IndentProductScheduleProjection> findByIndentProductId(@Param("indentProductIds") List<Long> indentProductIds);

}
