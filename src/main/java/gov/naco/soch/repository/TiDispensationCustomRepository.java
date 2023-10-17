package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.projection.TIDispensationExpectedList;

@Repository
public interface TiDispensationCustomRepository extends JpaRepository<TiOstBeneficiary, Long> ,JpaSpecificationExecutor<TIDispensationExpectedList>,CustomRepository {

}
