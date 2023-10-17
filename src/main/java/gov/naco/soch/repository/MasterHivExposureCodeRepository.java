/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHcvStatus;
import gov.naco.soch.entity.MasterHivExposureCode;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-08 9:06:14 pm 
 * 
 */
@Repository
public interface MasterHivExposureCodeRepository extends JpaRepository<MasterHivExposureCode, Long>{
	List<MasterHivExposureCode> findByIsDelete(Boolean isDelete);

}
