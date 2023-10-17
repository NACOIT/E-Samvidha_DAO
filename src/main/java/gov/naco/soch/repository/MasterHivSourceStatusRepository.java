/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHivExposureCode;
import gov.naco.soch.entity.MasterHivSourceStatus;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-08 9:14:03 pm 
 * 
 */
@Repository
public interface MasterHivSourceStatusRepository extends JpaRepository<MasterHivSourceStatus, Long> {
	List<MasterHivSourceStatus> findByIsDelete(Boolean isDelete);

}
