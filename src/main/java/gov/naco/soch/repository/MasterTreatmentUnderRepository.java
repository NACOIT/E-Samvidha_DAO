/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterRouteOfTransmission;
import gov.naco.soch.entity.MasterTreatmentUnder;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-08 9:27:58 pm 
 * 
 */
@Repository
public interface MasterTreatmentUnderRepository extends JpaRepository<MasterTreatmentUnder, Long>{
	List<MasterTreatmentUnder> findByIsDelete(Boolean isDelete);

}
