/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDiagnosedBy;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-08 9:23:29 pm 
 * 
 */
@Repository
public interface MasterDiagnosedByRepository  extends JpaRepository<MasterDiagnosedBy, Long>{
	List<MasterDiagnosedBy> findByIsDelete(Boolean isDelete);


}
