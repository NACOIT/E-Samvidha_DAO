package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TiOstDispensation;
import gov.naco.soch.projection.TiDispensationStockReportProjection;

@Repository
public interface TiDispensationForMobileRepository extends JpaRepository<TiOstDispensation, Long>  {

	@Query(nativeQuery = true, value = "select ostdis.substitution_drug as productId, prod.product_name as productName, ostdis.batch_number as batchNumber,\r\n" + 
			"sum(ostdis.total_dosage_qty) as dosage,\r\n" + 
			"sum(ostdis.total_dispensed_qty) as totalDispensedQuantity, bdi.disdate as dispensationDate\r\n" + 
			"from soch.ti_ost_dispensation ostdis\r\n" + 
			"join soch.product prod on prod.id = ostdis.substitution_drug\r\n" + 
			"inner join (\r\n" + 
			"Select distinct(oditem.ost_bulk_dispensation_id) as bulkdisid, oditem.dispensation_date as disdate\r\n" + 
			"from soch.ti_ost_dispensation_item oditem\r\n" + 
			"where oditem.dispensation_date between cast(:fromDate as date) and cast(:toDate as date)\r\n" + 
			"and oditem.facility_id = :facilityId\r\n" + 
			") bdi on bdi.bulkdisid = ostdis.ost_bulk_dispensation_id\r\n" + 
			"where\r\n" + 
			"ostdis.substitution_drug = :productId\r\n" + 
			"group by bdi.disdate, ostdis.substitution_drug, prod.product_name, ostdis.batch_number\r\n" + 
			"order by bdi.disdate")
	List<TiDispensationStockReportProjection> getDispenseStockReport(@Param("facilityId")Long facilityId, 
			@Param("productId")Long productId,
			@Param("fromDate")LocalDate fromDate, @Param("toDate")LocalDate toDate);

}

