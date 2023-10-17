package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.DispatchBatch;

@Repository
public interface DispatchBatchRepository extends JpaRepository<DispatchBatch, Long>{

	@Query(nativeQuery=true,value="select sum(db.quantity_number) from soch.dispatch_batch db\r\n"
			+ "join soch.dispatch d on(d.dispatch_id=db.dispatch_id) where d.lot_id=:lotId\r\n"
			+ "and d.dispatch_status_id not in (3,4) and db.is_active=true")
	Long findTotalDispatchQuantity(@Param("lotId")Long lotId);

}
