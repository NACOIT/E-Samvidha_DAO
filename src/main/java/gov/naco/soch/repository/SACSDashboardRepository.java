package gov.naco.soch.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.constructordto.SACSSummaryDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.DashboardStockAdjustProjection;
import gov.naco.soch.projection.StatisticsProjection;

public interface SACSDashboardRepository extends CrudRepository<Beneficiary, Long> {

	@Query(value = "select days_in_transit,grntwo_pending,avg_grntwo_pending,git,git_days,batch_count,product_count,grntwo_pending_By_Facility,avg_grntwo_pending_By_Facility from soch.summarydatasacs(:facilityId)", nativeQuery = true)
	Object getSummaryData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY p.id ) as slNo, p.product_name as pName , fsa.date_of_addition_or_consupmtion as adjustDate , pum.uom_name as uom , fsa.adjust_stock_quantity as quantity , adr.stock_adjustment_reason as adjustreason\r\n"
			+ "from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "inner join product p on p.id = fsa.product_id  inner join product_uom_master pum on pum.id = p.uom_id \r\n"
			+ "inner join facility_stock_adjustment_type_reasons adr on adr.id  = fsa.reason_code where fsa.facility_id  = :facilityId and p.is_active = true and p.is_delete =false")
	List<DashboardStockAdjustProjection> getStockAdjustData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select f.name, count(fd.facility_dispatch_id ) as value \r\n" + 
			"from  soch.facility_dispatch fd \r\n" + 
			"left join soch.facility f on f.id = fd.consignee_facility_id\r\n" + 
			"where fd.consignor_facility_id =:facilityId  and\r\n" + 
			"LOWER(fd.dispatch_type)='dispatch' and fd.expected_dispatch_date >= date_trunc('month', now())- interval '1 month'\r\n" + 
			"group by f.name")
	List<StatisticsProjection> getDispatchSumamry(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ft.facility_type_name as name , count(f.id) as value from facility f inner join facility_type ft on f.facility_type_id  = ft.id \r\n"
			+ "where f.sacs_id  = :facilityId and f.is_active =true and f.is_delete =false group by ft.facility_type_name")
	List<StatisticsProjection> getFacilityCount(@Param("facilityId") Long facilityId);

	default SACSSummaryDto getSummaryDashboardDetails(Long facilityId) {

		Object object = getSummaryData(facilityId);
		SACSSummaryDto sacsSummaryDto = new SACSSummaryDto();
		if (object instanceof Object[]) {
			Object[] values = (Object[]) object;
			sacsSummaryDto.setDaysInTransit((BigInteger) values[0]);
			sacsSummaryDto.setGrnTwoPending((BigInteger) values[1]);
			sacsSummaryDto.setAvgGrnPendingDays((BigInteger) values[2]);
			sacsSummaryDto.setGit((BigInteger) values[3]);
			sacsSummaryDto.setGitDays((BigInteger) values[4]);
			sacsSummaryDto.setBatchCount((BigInteger) values[5]);
			sacsSummaryDto.setProductCount((BigInteger) values[6]);
			sacsSummaryDto.setGrnTwoPendingByFacility((BigInteger) values[7]);
			sacsSummaryDto.setAvgGrnPendingDaysByFacility((BigInteger) values[8]);
		}
		return sacsSummaryDto;

	}
}
