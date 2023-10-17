package gov.naco.soch.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.projection.StockTransactionProjection;

@Repository
public interface FacilityStockTrackingRepository extends JpaRepository<FacilityStockTracking, Long> {
	
	
	@Query(nativeQuery=true,
		   value ="select * from soch.fnGetRepStockTrans (?,?,?,? )"
			)
	List<StockTransactionProjection> getStockReport( int facilityId, int productId, Date fromDate, Date toDate);
	
	

}
