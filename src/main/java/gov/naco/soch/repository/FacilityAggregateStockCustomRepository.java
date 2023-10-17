package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityAggregateStock;
import gov.naco.soch.projection.FacilityAggregateStockProjection;
import gov.naco.soch.projection.ProductInventoryProjection;

@Repository
public interface FacilityAggregateStockCustomRepository extends JpaRepository<FacilityAggregateStock, Long>,
		JpaSpecificationExecutor<FacilityAggregateStockProjection>, CustomRepository {
}
