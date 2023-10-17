/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHcvStatus;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-08 8:53:45 pm 
 * 
 */
@Repository
public interface MasterHcvStatusRepository extends JpaRepository<MasterHcvStatus,Long> {
	List<MasterHcvStatus> findByIsDelete(Boolean isDelete);

}
