/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterBaselineTest;
import gov.naco.soch.entity.MasterDnaPcrResult;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-08 9:35:27 pm 
 * 
 */
@Repository
public interface MasterDnaPcrResultRepository extends JpaRepository<MasterDnaPcrResult,	Long> {
	List<MasterDnaPcrResult> findByIsDelete(Boolean isDelete);


}
